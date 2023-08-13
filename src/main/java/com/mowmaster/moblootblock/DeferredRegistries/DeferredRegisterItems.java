package com.mowmaster.moblootblock.DeferredRegistries;

import com.mowmaster.moblootblock.Items.MobLootItem;
import com.mowmaster.moblootblock.moblootblock;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DeferredRegisterItems
{
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, moblootblock.MODID);


    public static final RegistryObject<Item> MOB_BIT = ITEMS.register("mob_bit",
            () -> new MobLootItem(new Item.Properties()));
    public static final RegistryObject<Item> MOB_PIECE = ITEMS.register("mob_piece",
            () -> new MobLootItem(new Item.Properties()));
    public static final RegistryObject<Item> MOB_CHUNK = ITEMS.register("mob_chunk",
            () -> new MobLootItem(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
