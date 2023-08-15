package com.mowmaster.moblootblock.Blocks;

import com.mowmaster.moblootblock.Configs.MobLootBlockConfig;
import com.mowmaster.moblootblock.moblootblock;
import com.mowmaster.mowlib.MowLibUtils.MowLibTooltipUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.EntityDamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BaseMobLootBlock extends Block {

    private String resLocMob;
    public BaseMobLootBlock(Properties p_49795_, String getMobResLoc) {
        super(p_49795_);
        this.resLocMob = getMobResLoc;
    }

    public String getResourceLocationAssignedMob()
    {
        return this.resLocMob;
    }

    @Override
    public List<ItemStack> getDrops(BlockState p_60537_, LootContext.Builder p_60538_) {
        List<ItemStack> loot = super.getDrops(p_60537_, p_60538_);
        if(p_60538_.getParameter(LootContextParams.THIS_ENTITY) instanceof Player getPlayer)
        {
            Entity entityMob = EntityType.byString(resLocMob).get().create(p_60538_.getLevel());
            if(entityMob != null)
            {
                if(entityMob instanceof LivingEntity livingMob)
                {
                    if(getPlayer.getItemInHand(InteractionHand.MAIN_HAND).isEnchanted())
                    {
                        if(getPlayer.getItemInHand(InteractionHand.MAIN_HAND).getEnchantmentLevel(Enchantments.SILK_TOUCH)>0)
                        {
                            loot.add(new ItemStack(p_60537_.getBlock().asItem(),1));
                            return loot;
                        }
                        else if(getPlayer.getItemInHand(InteractionHand.MAIN_HAND).getEnchantmentLevel(Enchantments.FIRE_ASPECT)>0 || getPlayer.getItemInHand(InteractionHand.MAIN_HAND).getEnchantmentLevel(Enchantments.FLAMING_ARROWS)>0)
                        {
                            livingMob.setRemainingFireTicks(20);
                        }
                    }
                    DamageSource damageSource = DamageSource.playerAttack(getPlayer);
                    LootTable loottable = p_60538_.getLevel().getServer().getLootTables().get(livingMob.getLootTable());
                    LootContext.Builder lootcontext$builder = (new LootContext.Builder((ServerLevel) p_60538_.getLevel()))
                            .withParameter(LootContextParams.THIS_ENTITY, livingMob)
                            .withParameter(LootContextParams.ORIGIN, p_60538_.getParameter(LootContextParams.ORIGIN))
                            .withParameter(LootContextParams.DAMAGE_SOURCE, damageSource)
                            .withOptionalParameter(LootContextParams.KILLER_ENTITY, getPlayer)
                            .withOptionalParameter(LootContextParams.DIRECT_KILLER_ENTITY, damageSource.getDirectEntity())
                            .withParameter(LootContextParams.TOOL, getPlayer.getItemInHand(InteractionHand.MAIN_HAND));
                    lootcontext$builder = lootcontext$builder.withParameter(LootContextParams.LAST_DAMAGE_PLAYER, getPlayer)
                            .withLuck(getPlayer.getLuck());

                    loot.addAll(loottable.getRandomItems(lootcontext$builder.create(LootContextParamSets.ENTITY)));
                }
            }
        }

        return loot;
    }

    public static final TagKey<EntityType<?>> MOBALLOWLIST = TagKey.create(ForgeRegistries.ENTITY_TYPES.getRegistryKey(), new ResourceLocation(moblootblock.MODID, "moblootblock_supported_mobs"));

    @Override
    public void appendHoverText(ItemStack p_49816_, @Nullable BlockGetter p_49817_, List<Component> p_49818_, TooltipFlag p_49819_) {
        super.appendHoverText(p_49816_, p_49817_, p_49818_, p_49819_);

        if(p_49816_.getItem() instanceof BaseMobLootBlockItem)
        {
            if(((BaseMobLootBlockItem) p_49816_.getItem()).getBlock() instanceof BaseMobLootBlock baseMobLootBlock)
            {
                if(EntityType.byString(baseMobLootBlock.getResourceLocationAssignedMob()).isPresent())
                {
                    if(!(EntityType.byString(baseMobLootBlock.getResourceLocationAssignedMob()).get().is(MOBALLOWLIST)))
                    {
                        MutableComponent componentNotAllowed = Component.translatable(moblootblock.MODID + ".moblootblock.tooltip_notallowed");
                        componentNotAllowed.withStyle(ChatFormatting.RED);
                        MowLibTooltipUtils.addTooltipMessage(p_49818_,p_49816_,componentNotAllowed);
                    }
                }
            }
        }

        MutableComponent componentDrops = Component.translatable(moblootblock.MODID + ".moblootblock.tooltip_drops");
        componentDrops.withStyle(ChatFormatting.GOLD);
        MowLibTooltipUtils.addTooltipMessage(p_49818_,p_49816_,componentDrops);

        MutableComponent componentCraft = Component.translatable(moblootblock.MODID + ".moblootblock.tooltip_crafting");
        componentCraft.withStyle(ChatFormatting.GRAY);
        MowLibTooltipUtils.addTooltipMessage(p_49818_,p_49816_,componentCraft);

        MutableComponent componentSilk = Component.translatable(moblootblock.MODID + ".moblootblock.tooltip_silktouch");
        componentSilk.withStyle(ChatFormatting.AQUA);
        MowLibTooltipUtils.addTooltipMessage(p_49818_,p_49816_,componentSilk);

        boolean spawner = MobLootBlockConfig.COMMON.moblootblock_allowSpawnerChanging.get();
        boolean mobspawn = MobLootBlockConfig.COMMON.moblootblock_allowMobSpawning.get();
        if(spawner || mobspawn)
        {
            MutableComponent componentShift = (mobspawn)?(Component.translatable(moblootblock.MODID + ".moblootblock.tooltip_shiftmsg")):(Component.literal(""));
            componentShift.withStyle(ChatFormatting.GREEN);
            MutableComponent componentShiftAdditional = Component.translatable(moblootblock.MODID + ".moblootblock.tooltip_shiftmsgtwo");
            componentShiftAdditional.withStyle(ChatFormatting.LIGHT_PURPLE);
            if(spawner){componentShift.append(componentShiftAdditional);}
            MowLibTooltipUtils.addTooltipShiftMessage(moblootblock.MODID,p_49818_,componentShift);
        }
    }
}
