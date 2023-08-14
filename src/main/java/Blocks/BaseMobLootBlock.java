package Blocks;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import java.util.ArrayList;
import java.util.List;


public class BaseMobLootBlock extends Block {

    private String resLocMob;
    public BaseMobLootBlock(Properties p_49795_, String getMobResLoc) {
        super(p_49795_);
        this.resLocMob = getMobResLoc;
    }

    @Override
    public List<ItemStack> getDrops(BlockState p_287732_, LootParams.Builder p_287596_) {

        List<ItemStack> loot = new ArrayList<>();
        Entity entityMob = EntityType.byString(resLocMob).get().create(p_287596_.getLevel());
        if(entityMob != null)
        {
            if(entityMob instanceof LivingEntity livingMob)
            {
                if( p_287596_.getParameter(LootContextParams.THIS_ENTITY) instanceof Player getPlayer)
                {
                    if(getPlayer.getItemInHand(InteractionHand.MAIN_HAND).isEnchanted())
                    {
                        if(getPlayer.getItemInHand(InteractionHand.MAIN_HAND).getEnchantmentLevel(Enchantments.FIRE_ASPECT)>0 || getPlayer.getItemInHand(InteractionHand.MAIN_HAND).getEnchantmentLevel(Enchantments.FLAMING_ARROWS)>0)
                        {
                            livingMob.setRemainingFireTicks(20);
                        }
                    }
                    DamageSource damageSource = p_287596_.getLevel().damageSources().playerAttack(getPlayer);

                    LootTable loottable = p_287596_.getLevel().getServer().getLootData().getLootTable(livingMob.getLootTable());
                    LootParams.Builder lootcontext$builder = (new LootParams.Builder((ServerLevel) p_287596_.getLevel()))
                            .withParameter(LootContextParams.THIS_ENTITY, livingMob)
                            .withParameter(LootContextParams.ORIGIN, p_287596_.getParameter(LootContextParams.ORIGIN))
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
}
