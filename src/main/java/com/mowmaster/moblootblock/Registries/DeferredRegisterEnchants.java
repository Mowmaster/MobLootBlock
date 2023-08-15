package com.mowmaster.moblootblock.Registries;

import com.mowmaster.moblootblock.Enchants.MobLootBlockEnchant;
import com.mowmaster.moblootblock.moblootblock;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

//https://github.com/vectorwing/FarmersDelight/blob/1.20/src/main/java/vectorwing/farmersdelight/common/registry/ModEnchantments.java
public class DeferredRegisterEnchants
{
    //public static final EnchantmentCategory KNIFE = EnchantmentCategory.create("knife", item -> item instanceof KnifeItem);
    public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, moblootblock.MODID);

    public static final RegistryObject<Enchantment> MOBLOOTBLOCK_DROPS = ENCHANTMENTS.register("moblootblockdrops",
            () -> new MobLootBlockEnchant(Enchantment.Rarity.COMMON, EnchantmentCategory.WEAPON, EquipmentSlot.values()));
}
