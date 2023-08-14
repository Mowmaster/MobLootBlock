package com.mowmaster.moblootblock.DeferredRegistries;

import Blocks.BaseMobLootBlock;
import com.mowmaster.moblootblock.moblootblock;
import com.mowmaster.mowlib.MowLibUtils.MowLibTooltipUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class DeferredCreativeTabRegistry
{
    public static final DeferredRegister<CreativeModeTab> DEF_REG = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, moblootblock.MODID);

    public static final TagKey<EntityType<?>> MOBALLOWLIST = TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation(moblootblock.MODID, "moblootblock_supported_mobs"));

    public static final RegistryObject<CreativeModeTab> TAB = DEF_REG.register(moblootblock.MODID, () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup." + moblootblock.MODID))
            .icon(() -> makeIcon())
            .displayItems((enabledFeatures, output) -> {
                for(RegistryObject<Item> item : DeferredRegisterItems.ITEMS.getEntries()){
                    if(item.get() instanceof BlockItem blockItem)
                    {
                        if(blockItem.getBlock() instanceof BaseMobLootBlock baseMobLootBlock)
                        {
                            if(EntityType.byString(baseMobLootBlock.getResourceLocationAssignedMob()).get().is(MOBALLOWLIST))
                            {
                                output.accept(item.get());
                            }
                        }
                    }
                    else
                    {
                        output.accept(item.get());
                    }
                }
            })
            .build());

    private static ItemStack makeIcon() {
        ItemStack stack = new ItemStack(DeferredRegisterBlocks.MOBBLOCK_SHULKER.get());
        CompoundTag tag = new CompoundTag();
        tag.putInt("3DRender", 1);
        stack.setTag(tag);
        return stack;
    }
}
