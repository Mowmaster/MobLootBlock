package com.mowmaster.moblootblock.Enchants;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

//https://github.com/vectorwing/FarmersDelight/blob/1.20/src/main/java/vectorwing/farmersdelight/common/item/enchantment/BackstabbingEnchantment.java
public class MobLootBlockEnchant extends Enchantment {
    public MobLootBlockEnchant(Rarity p_44676_, EnchantmentCategory p_44677_, EquipmentSlot[] p_44678_) {
        super(p_44676_, p_44677_, p_44678_);
    }

    @Override
    public boolean isCurse() {
        return true;
    }

    @Override
    public int getMinLevel() {
        return 1;
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public int getMinCost(int enchantmentLevel) {
        return 10 + (enchantmentLevel - 1) * 9;
    }

    @Override
    public int getMaxCost(int enchantmentLevel) {
        return super.getMinCost(enchantmentLevel) + 50;
    }


    /*
    public static boolean isLookingBehindTarget(LivingEntity target, Vec3 attackerLocation) {
        if (attackerLocation != null) {
            Vec3 lookingVector = target.getViewVector(1.0F);
            Vec3 attackAngleVector = attackerLocation.subtract(target.position()).normalize();
            attackAngleVector = new Vec3(attackAngleVector.x, 0.0D, attackAngleVector.z);
            return attackAngleVector.dot(lookingVector) < -0.5D;
        }
        return false;
    }

    public static float getBackstabbingDamagePerLevel(float amount, int level) {
        float multiplier = ((level * 0.2F) + 1.2F);
        return amount * multiplier;
    }

    @Mod.EventBusSubscriber(modid = FarmersDelight.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class BackstabbingEvent
    {
        @SubscribeEvent
        @SuppressWarnings("unused")
        public static void onKnifeBackstab(LivingHurtEvent event) {
            Entity attacker = event.getSource().getEntity();
            if (attacker instanceof Player) {
                ItemStack weapon = ((Player) attacker).getMainHandItem();
                int enchantmentLevel = EnchantmentHelper.getItemEnchantmentLevel(ModEnchantments.BACKSTABBING.get(), weapon);
                if (enchantmentLevel > 0 && isLookingBehindTarget(event.getEntity(), event.getSource().getSourcePosition())) {
                    Level level = event.getEntity().getCommandSenderWorld();
                    if (!level.isClientSide) {
                        event.setAmount(getBackstabbingDamagePerLevel(event.getAmount(), enchantmentLevel));
                        level.playSound(null, attacker.getX(), attacker.getY(), attacker.getZ(), SoundEvents.PLAYER_ATTACK_CRIT, SoundSource.BLOCKS, 1.0F, 1.0F);
                    }
                }
            }
        }
    }*/
}
