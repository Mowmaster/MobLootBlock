package com.mowmaster.moblootblock.Configs;

import com.mowmaster.moblootblock.moblootblock;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import org.apache.commons.lang3.tuple.Pair;

public class MobLootBlockConfig
{
    public static class Common {

        public final ForgeConfigSpec.IntValue drops_Type;
        public final ForgeConfigSpec.IntValue drops_Modifier;
        public final ForgeConfigSpec.IntValue drops_AmountMax;


        public final ForgeConfigSpec.BooleanValue moblootblock_allowSpawnerChanging;
        public final ForgeConfigSpec.BooleanValue moblootblock_allowMobSpawning;

        Common(ForgeConfigSpec.Builder builder) {

            builder.comment("Adjust Global Mob Drop Values").push("Global_Drop_Configs");

            drops_Type = builder
                    .comment("Drop Bits(0), Pieces(1), or Chunks(2)")
                    .defineInRange("drops_Type", 0, 0, 2);
            drops_Modifier = builder
                    .comment("The Chance the Drop will Happen, lower values are better chances.")
                    .defineInRange("drops_Chance", 20, 1, Integer.MAX_VALUE);
            drops_AmountMax = builder
                    .comment("The Maximum amount of Drops (with looting)")
                    .defineInRange("drops_MaxAmount", 1, 1, Integer.MAX_VALUE);
            builder.pop();

            builder.comment("Mob Loot Block Options").push("Mob_Loot_Block_Configs");
            moblootblock_allowSpawnerChanging = builder
                    .comment("Allow using Mob Loot Blocks to change a Vanilla Spawners Mob Type")
                    .define("moblootblock_AllowSpawnerChanging",  true);
            moblootblock_allowMobSpawning = builder
                    .comment("Allows using the Mob Loot Block to spawn mobs")
                    .define("moblootblock_AllowMobSpawning",  true);
            builder.pop();

        }
    }

    /*public static class Client {

        public final ForgeConfigSpec.BooleanValue pedestalRotateItems;
        Client(ForgeConfigSpec.Builder builder) {
            builder.comment("Pedestal rendering options").push("Pedestal");
            pedestalRotateItems = builder
                    .comment("Should items on pedestal rotate")
                    .comment("§a§lLOW§f impact when §a§lTRUE")
                    .comment("§2§lLOWEST§f impact when §c§lFALSE")
                    .define("Rotate Items", true);
            builder.pop();
        }
    }*/

    public static final ForgeConfigSpec commonSpec;
    public static final Common COMMON;
    //public static final ForgeConfigSpec clientSpec;
    //public static final Client CLIENT;

    static {
        final Pair<Common, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Common::new);
        commonSpec = specPair.getRight();
        COMMON = specPair.getLeft();

        /*final Pair<ForgeConfig.Client, ForgeConfigSpec> clientSpecPair = new ForgeConfigSpec.Builder().configure(Client::new);
        clientSpec = clientSpecPair.getRight();
        CLIENT = clientSpecPair.getLeft();*/
    }

    @SubscribeEvent
    public static void onLoad(final ModConfigEvent.Loading configEvent) {
        moblootblock.LOGGER.debug("Loaded MobLootBlock config file {}", configEvent.getConfig().getFileName());
    }

    @SubscribeEvent
    public static void onFileChange(final ModConfigEvent.Reloading configEvent) {
        moblootblock.LOGGER.debug("MobLootBlock config just got changed on the file system!");
    }
}
