package com.mowmaster.moblootblock.EventHandlers;

import com.mowmaster.moblootblock.Registries.DeferredRegisterItems;
import com.mowmaster.moblootblock.moblootblock;
import com.mowmaster.mowlib.MowLibUtils.MowLibCompoundTagUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber
public class LootModifier {

    public static final TagKey<EntityType<?>> MOBALLOWLIST = TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation(moblootblock.MODID, "moblootblock_supported_mobs"));

    //https://github.com/Mrbysco/ForceCraft/blob/1.20/src/main/java/com/mrbysco/forcecraft/handlers/LootingHandler.java
    @SubscribeEvent()
    public static void MobChunkMobLoot(LivingDropsEvent event)
    {
        if (event.getSource() == null || event.getSource().getEntity() == null) {
            return;
        }

        Entity source = event.getSource().getEntity();
        if (source instanceof Player player) {

            int hasEnchant = player.getMainHandItem().getEnchantmentLevel(Enchantments.BINDING_CURSE);
            if(hasEnchant>0)
            {
                RandomSource rand = player.getRandom();
                int looting = event.getLootingLevel();
                LivingEntity entity = event.getEntity();
                if(entity.getType().is(MOBALLOWLIST))
                {
                    BlockPos entityPos = entity.blockPosition();
                    Level entityLevel = entity.level();
                    ResourceLocation entityLoc = ForgeRegistries.ENTITY_TYPES.getKey(entity.getType());

                    int chanceMax = 20;
                    if (looting > 0) {
                        chanceMax = chanceMax / looting;
                        if (chanceMax < 0) {
                            chanceMax = 1;
                        }
                    }
                    float dropChance = rand.nextInt(chanceMax);
                    if (dropChance == 0) {
                        //https://github.com/CreeperHost/SoulShards/blob/1.20/src/main/java/net/creeperhost/soulshardsrespawn/core/EventHandler.java
                        ItemStack getDroppedChunk = new ItemStack(DeferredRegisterItems.MOB_BIT.get(), rand.nextInt(Math.max(1, looting)) + 1);
                        getDroppedChunk.setTag(MowLibCompoundTagUtils.writeStringToNBT(moblootblock.MODID,getDroppedChunk.getOrCreateTag(),entityLoc.toString(),"_moblootitem"));
                        //MowLibCompoundTagUtils.readStringFromNBT(moblootblock.MODID,p_41421_.getOrCreateTag(),"moblootitem")

                        if (entity.isInvertedHealAndHarm()) {
                            event.getDrops().add(new ItemEntity(entityLevel, entityPos.getX(), entityPos.getY(), entityPos.getZ(), getDroppedChunk));
                        } else {
                            if (entity instanceof Monster) {
                                event.getDrops().add(new ItemEntity(entityLevel, entityPos.getX(), entityPos.getY(), entityPos.getZ(), getDroppedChunk));
                            } else {
                                event.getDrops().add(new ItemEntity(entityLevel, entityPos.getX(), entityPos.getY(), entityPos.getZ(), getDroppedChunk));
                            }
                        }
                    }
                }
            }
        }
    }
}
