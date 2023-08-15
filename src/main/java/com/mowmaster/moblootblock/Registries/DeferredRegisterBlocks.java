package com.mowmaster.moblootblock.Registries;

import com.mowmaster.moblootblock.Blocks.BaseMobLootBlock;
import com.mowmaster.moblootblock.Blocks.BaseMobLootBlockItem;
import com.mowmaster.moblootblock.CustomCreativeTab.MobLootBlockTab;
import com.mowmaster.moblootblock.moblootblock;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class DeferredRegisterBlocks
{
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,moblootblock.MODID);

    public static final RegistryObject<Block> MOBBLOCK_ALLAY = registerBlock("mobblock_allay",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:allay"));
    public static final RegistryObject<Block> MOBBLOCK_AXOLOTL = registerBlock("mobblock_axolotl",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:axolotl"));
    public static final RegistryObject<Block> MOBBLOCK_BAT = registerBlock("mobblock_bat",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:bat"));
    public static final RegistryObject<Block> MOBBLOCK_BEE = registerBlock("mobblock_bee",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:bee"));
    public static final RegistryObject<Block> MOBBLOCK_CAMEL = registerBlock("mobblock_camel",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:camel"));
    public static final RegistryObject<Block> MOBBLOCK_CAT = registerBlock("mobblock_cat",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:cat"));
    public static final RegistryObject<Block> MOBBLOCK_CHICKEN = registerBlock("mobblock_chicken",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:chicken"));
    public static final RegistryObject<Block> MOBBLOCK_COD = registerBlock("mobblock_cod",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:cod"));
    public static final RegistryObject<Block> MOBBLOCK_COW = registerBlock("mobblock_cow",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:cow"));
    public static final RegistryObject<Block> MOBBLOCK_DOLPHIN = registerBlock("mobblock_dolphin",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:dolphin"));
    public static final RegistryObject<Block> MOBBLOCK_DONKEY = registerBlock("mobblock_donkey",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:donkey"));
    public static final RegistryObject<Block> MOBBLOCK_FOX = registerBlock("mobblock_fox",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:fox"));
    public static final RegistryObject<Block> MOBBLOCK_FROG = registerBlock("mobblock_frog",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:frog"));
    public static final RegistryObject<Block> MOBBLOCK_GLOW_SQUID = registerBlock("mobblock_glowsquid",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:glow_squid"));
    public static final RegistryObject<Block> MOBBLOCK_GOAT = registerBlock("mobblock_goat",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:goat"));
    public static final RegistryObject<Block> MOBBLOCK_HORSE = registerBlock("mobblock_horse",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:horse"));
    public static final RegistryObject<Block> MOBBLOCK_IRON_GOLEM = registerBlock("mobblock_irongolem",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:iron_golem"));
    public static final RegistryObject<Block> MOBBLOCK_LLAMA = registerBlock("mobblock_llama",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:llama"));
    public static final RegistryObject<Block> MOBBLOCK_MOOSHROOM = registerBlock("mobblock_mooshroom",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:mooshroom"));
    public static final RegistryObject<Block> MOBBLOCK_MULE = registerBlock("mobblock_mule",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:mule"));
    public static final RegistryObject<Block> MOBBLOCK_OCELOT = registerBlock("mobblock_ocelot",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:ocelot"));
    public static final RegistryObject<Block> MOBBLOCK_PANDA = registerBlock("mobblock_panda",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:panda"));
    public static final RegistryObject<Block> MOBBLOCK_PARROT = registerBlock("mobblock_parrot",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:parrot"));
    public static final RegistryObject<Block> MOBBLOCK_PIG = registerBlock("mobblock_pig",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:pig"));
    public static final RegistryObject<Block> MOBBLOCK_RABBIT = registerBlock("mobblock_rabbit",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:rabbit"));
    public static final RegistryObject<Block> MOBBLOCK_SALMON = registerBlock("mobblock_salmon",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:salmon"));
    public static final RegistryObject<Block> MOBBLOCK_SHEEP = registerBlock("mobblock_sheep",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:sheep"));
    public static final RegistryObject<Block> MOBBLOCK_SKELETON_HORSE = registerBlock("mobblock_skeletonhorse",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:skeleton_horse"));
    public static final RegistryObject<Block> MOBBLOCK_SNIFFER = registerBlock("mobblock_sniffer",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:sniffer"));
    public static final RegistryObject<Block> MOBBLOCK_SNOW_GOLEM = registerBlock("mobblock_snowgolem",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:snow_golem"));
    public static final RegistryObject<Block> MOBBLOCK_SQUID = registerBlock("mobblock_squid",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:squid"));
    public static final RegistryObject<Block> MOBBLOCK_STRIDER = registerBlock("mobblock_strider",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:strider"));
    public static final RegistryObject<Block> MOBBLOCK_TADPOLE = registerBlock("mobblock_tadpole",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:tadpole"));
    public static final RegistryObject<Block> MOBBLOCK_TRADER_LLAMA = registerBlock("mobblock_traderllama",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:trader_llama"));
    public static final RegistryObject<Block> MOBBLOCK_TROPICAL_FISH = registerBlock("mobblock_tropicalfish",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:tropical_fish"));
    public static final RegistryObject<Block> MOBBLOCK_TURTLE = registerBlock("mobblock_turtle",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:turtle"));
    public static final RegistryObject<Block> MOBBLOCK_VILLAGER = registerBlock("mobblock_villager",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:villager"));
    public static final RegistryObject<Block> MOBBLOCK_WANDERING_TRADER = registerBlock("mobblock_wanderingtrader",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:wandering_trader"));
    public static final RegistryObject<Block> MOBBLOCK_WOLF = registerBlock("mobblock_wolf",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:wolf"));
    public static final RegistryObject<Block> MOBBLOCK_ZOMBIE_HORSE = registerBlock("mobblock_zombiehorse",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:zombie_horse"));




    public static final RegistryObject<Block> MOBBLOCK_BLAZE = registerBlock("mobblock_blaze",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:blaze"));
    public static final RegistryObject<Block> MOBBLOCK_CAVESPIDER = registerBlock("mobblock_cavespider",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:cave_spider"));
    public static final RegistryObject<Block> MOBBLOCK_CREEPER = registerBlock("mobblock_creeper",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:creeper"));
    public static final RegistryObject<Block> MOBBLOCK_DROWNED = registerBlock("mobblock_drowned",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:drowned"));
    public static final RegistryObject<Block> MOBBLOCK_ELDERGUARDIAN = registerBlock("mobblock_elderguardian",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:elder_guardian"));
    public static final RegistryObject<Block> MOBBLOCK_ENDERDRAGON = registerBlock("mobblock_enderdragon",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:ender_dragon"));
    public static final RegistryObject<Block> MOBBLOCK_ENDERMAN = registerBlock("mobblock_enderman",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:enderman"));
    public static final RegistryObject<Block> MOBBLOCK_ENDERMITE = registerBlock("mobblock_endermite",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:endermite"));
    public static final RegistryObject<Block> MOBBLOCK_EVOKER = registerBlock("mobblock_evoker",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:evoker"));
    public static final RegistryObject<Block> MOBBLOCK_GHAST = registerBlock("mobblock_ghast",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:ghast"));
    public static final RegistryObject<Block> MOBBLOCK_GIANT = registerBlock("mobblock_giant",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:giant"));
    public static final RegistryObject<Block> MOBBLOCK_GUARDIAN = registerBlock("mobblock_guardian",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:guardian"));
    public static final RegistryObject<Block> MOBBLOCK_HOGLIN = registerBlock("mobblock_hoglin",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:hoglin"));
    public static final RegistryObject<Block> MOBBLOCK_HUSK = registerBlock("mobblock_husk",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:husk"));
    public static final RegistryObject<Block> MOBBLOCK_ILLUSIONER = registerBlock("mobblock_illusioner",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:illusioner"));
    public static final RegistryObject<Block> MOBBLOCK_MAGMACUBE = registerBlock("mobblock_magmacube",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:magma_cube"));
    public static final RegistryObject<Block> MOBBLOCK_PHANTOM = registerBlock("mobblock_phantom",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:phantom"));
    public static final RegistryObject<Block> MOBBLOCK_PIGLIN = registerBlock("mobblock_piglin",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:piglin"));
    public static final RegistryObject<Block> MOBBLOCK_PIGLINBRUTE = registerBlock("mobblock_piglinbrute",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:piglin_brute"));
    public static final RegistryObject<Block> MOBBLOCK_PILLAGER = registerBlock("mobblock_pillager",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:pillager"));
    public static final RegistryObject<Block> MOBBLOCK_POLAR_BEAR = registerBlock("mobblock_polarbear",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:polar_bear"));
    public static final RegistryObject<Block> MOBBLOCK_PUFFERFISH = registerBlock("mobblock_pufferfish",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:pufferfish"));
    public static final RegistryObject<Block> MOBBLOCK_SHULKER = registerBlock("mobblock_shulker",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:shulker"));
    public static final RegistryObject<Block> MOBBLOCK_SILVERFISH = registerBlock("mobblock_silverfish",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:silverfish"));
    public static final RegistryObject<Block> MOBBLOCK_SKELETON = registerBlock("mobblock_skeleton",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:skeleton"));
    public static final RegistryObject<Block> MOBBLOCK_SLIME = registerBlock("mobblock_slime",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:slime"));
    public static final RegistryObject<Block> MOBBLOCK_SPIDER = registerBlock("mobblock_spider",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:spider"));
    public static final RegistryObject<Block> MOBBLOCK_STRAY = registerBlock("mobblock_stray",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:stray"));
    public static final RegistryObject<Block> MOBBLOCK_VEX = registerBlock("mobblock_vex",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:vex"));
    public static final RegistryObject<Block> MOBBLOCK_VINDICATOR = registerBlock("mobblock_vindicator",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:vindicator"));
    public static final RegistryObject<Block> MOBBLOCK_WARDEN = registerBlock("mobblock_warden",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:warden"));
    public static final RegistryObject<Block> MOBBLOCK_WITCH = registerBlock("mobblock_witch",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:witch"));
    public static final RegistryObject<Block> MOBBLOCK_WITHER = registerBlock("mobblock_wither",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:wither"));
    public static final RegistryObject<Block> MOBBLOCK_WITHERSKELETON = registerBlock("mobblock_witherskeleton",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:wither_skeleton"));
    public static final RegistryObject<Block> MOBBLOCK_ZOGLIN = registerBlock("mobblock_zoglin",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:zoglin"));
    public static final RegistryObject<Block> MOBBLOCK_ZOMBIE = registerBlock("mobblock_zombie",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:zombie"));
    public static final RegistryObject<Block> MOBBLOCK_ZOMBIEVILLAGER = registerBlock("mobblock_zombievillager",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:zombie_villager"));
    public static final RegistryObject<Block> MOBBLOCK_ZOMBIFIEDPIGLIN = registerBlock("mobblock_zombifiedpiglin",
            () -> new BaseMobLootBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.WOOL), "minecraft:zombified_piglin"));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItemAllowed(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItemAllowed(String name, RegistryObject<T> block) {
        DeferredRegisterItems.ITEMS.register(name, () -> new BaseMobLootBlockItem(block.get(),
                new Item.Properties().tab(MobLootBlockTab.TAB_ITEMS)));
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        DeferredRegisterItems.ITEMS.register(name, () -> new BaseMobLootBlockItem(block.get(),
                new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
