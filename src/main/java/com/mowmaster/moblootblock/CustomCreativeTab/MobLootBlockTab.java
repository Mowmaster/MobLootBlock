package com.mowmaster.moblootblock.CustomCreativeTab;

import com.mowmaster.moblootblock.Registries.DeferredRegisterBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class MobLootBlockTab extends CreativeModeTab {
    public MobLootBlockTab()  {
        super("tab_moblootblock");
    }

    public static final MobLootBlockTab TAB_ITEMS = new MobLootBlockTab() {};

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(DeferredRegisterBlocks.MOBBLOCK_SHULKER.get());
    }
}
