package net.silverclaymore.mccourse.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.silverclaymore.mccourse.MCCourseMod;
import net.silverclaymore.mccourse.block.ModBlocks;
import net.silverclaymore.mccourse.fluid.ModFluids;

import java.util.Map;
import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MCCourseMod.MOD_ID);

    private static void addElements(CreativeModeTab.Output pOutput, DeferredItem<?>[] items) {
        for (DeferredItem<?> item : items) {
                pOutput.accept(item);
        }
    }

    private static void addElements(CreativeModeTab.Output pOutput, DeferredBlock<?>[] blocks) {
        for (DeferredBlock<?> block : blocks) {
            pOutput.accept(block);
        }
    }

    private static final Map<String, DeferredItem<?>[]> ITEM_GROUPS = Map.of(
            "black_opal", new DeferredItem<?>[]{
                      ModItems.BLACK_OPAL, ModItems.RAW_BLACK_OPAL, ModItems.BLACK_OPAL_SWORD
                    , ModItems.BLACK_OPAL_PICKAXE, ModItems.BLACK_OPAL_AXE, ModItems.BLACK_OPAL_SHOVEL
                    , ModItems.BLACK_OPAL_HOE, ModItems.BLACK_OPAL_PAXEL, ModItems.BLACK_OPAL_HAMMER
                    , ModItems.BLACK_OPAL_HELMET, ModItems.BLACK_OPAL_CHESTPLATE, ModItems.BLACK_OPAL_LEGGINGS, ModItems.BLACK_OPAL_BOOTS
                    , ModItems.BLACK_OPAL_HORSE_ARMOR, ModItems.KAUPEN_SMITHING_TEMPLATE
                    , ModItems.CHAINSAW, ModItems.TOMATO, ModItems.TOMATO_SEEDS, ModItems.FROSTFIRE_ICE
                    , ModItems.BAR_BRAWL_MUSIC_DISC, ModItems.BLACK_OPAL_SWORD_LEVITATION, ModItems.METAL_DETECTOR
                    , ModItems.DATA_TABLET, ModItems.KAUPEN_BOW, ModItems.RADIATION_STAFF, ModItems.PENGUIN_SPAWN_EGG
                    , ModFluids.BLACK_OPAL_WATER_BUCKET
            },
            "bismuth", new DeferredItem<?>[]{
                      ModItems.BISMUTH, ModItems.RAW_BISMUTH, ModItems.BISMUTH_SWORD
                    , ModItems.BISMUTH_PICKAXE, ModItems.BISMUTH_AXE, ModItems.BISMUTH_SHOVEL
                    , ModItems.BISMUTH_HOE, ModItems.BISMUTH_HAMMER
                    , ModItems.BISMUTH_HELMET, ModItems.BISMUTH_CHESTPLATE, ModItems.BISMUTH_LEGGINGS, ModItems.BISMUTH_BOOTS
            },
            "alexandrite", new DeferredItem<?>[]{
                      ModItems.ALEXANDRITE, ModItems.RAW_ALEXANDRITE
                    , ModItems.ALEXANDRITE_HELMET, ModItems.ALEXANDRITE_CHESTPLATE, ModItems.ALEXANDRITE_LEGGINGS, ModItems.ALEXANDRITE_BOOTS
            },
            "pink_garnet", new DeferredItem<?>[]{
                    ModItems.PINK_GARNET, ModItems.RAW_PINK_GARNET
                    , ModItems.PINK_GARNET_HELMET, ModItems.PINK_GARNET_CHESTPLATE, ModItems.PINK_GARNET_LEGGINGS, ModItems.PINK_GARNET_BOOTS
            }
    );

    private static final Map<String, DeferredBlock<?>[]> BLOCK_GROUPS = Map.of(
            "bismuth", new DeferredBlock<?>[]{
                    ModBlocks.BISMUTH_BLOCK, ModBlocks.RAW_BISMUTH_BLOCK, ModBlocks.BISMUTH_ORE, ModBlocks.BISMUTH_BRICK_BLOCK
                    , ModBlocks.BISMUTH_NETHER_ORE, ModBlocks.BISMUTH_DEEPSLATE_ORE, ModBlocks.BISMUTH_END_ORE
                    , ModBlocks.BISMUTH_SLAB, ModBlocks.BISMUTH_STAIRS, ModBlocks.BISMUTH_PRESSURE_PLATE
                    , ModBlocks.BISMUTH_BUTTON, ModBlocks.BISMUTH_FENCE, ModBlocks.BISMUTH_FENCE_GATE
                    , ModBlocks.BISMUTH_WALL, ModBlocks.BISMUTH_DOOR, ModBlocks.BISMUTH_TRAPDOOR
                    , ModBlocks.BLOODWOOD_LOG, ModBlocks.BLOODWOOD_WOOD, ModBlocks.STRIPPED_BLOODWOOD_LOG, ModBlocks.STRIPPED_BLOODWOOD_WOOD, ModBlocks.BLOODWOOD_LEAVES, ModBlocks.BLOODWOOD_PLANKS, ModBlocks.BLOODWOOD_SAPLING
            },
            "black_opal", new DeferredBlock<?>[]{
                    ModBlocks.BLACK_OPAL_BLOCK, ModBlocks.RAW_BLACK_OPAL_BLOCK, ModBlocks.BLACK_OPAL_ORE, ModBlocks.BLACK_OPAL_BRICK_BLOCK
                    , ModBlocks.BLACK_OPAL_NETHER_ORE, ModBlocks.BLACK_OPAL_DEEPSLATE_ORE, ModBlocks.BLACK_OPAL_END_ORE
                    , ModBlocks.BLACK_OPAL_SLAB, ModBlocks.BLACK_OPAL_STAIRS, ModBlocks.BLACK_OPAL_PRESSURE_PLATE
                    , ModBlocks.BLACK_OPAL_BUTTON, ModBlocks.BLACK_OPAL_FENCE, ModBlocks.BLACK_OPAL_FENCE_GATE
                    , ModBlocks.BLACK_OPAL_WALL, ModBlocks.BLACK_OPAL_DOOR, ModBlocks.BLACK_OPAL_TRAPDOOR
                    , ModBlocks.EBONY_SLAB, ModBlocks.EBONY_STAIRS, ModBlocks.EBONY_PRESSURE_PLATE
                    , ModBlocks.EBONY_BUTTON, ModBlocks.EBONY_FENCE, ModBlocks.EBONY_FENCE_GATE
                    , ModBlocks.EBONY_WALL
                    , ModBlocks.EBONY_LOG, ModBlocks.EBONY_WOOD, ModBlocks.STRIPPED_EBONY_LOG, ModBlocks.STRIPPED_EBONY_WOOD, ModBlocks.EBONY_LEAVES, ModBlocks.EBONY_PLANKS, ModBlocks.EBONY_SAPLING
                    , ModBlocks.MAGIC_BLOCK, ModBlocks.BLACK_OPAL_LAMP, ModBlocks.PETUNIA, ModBlocks.COLORED_LEAVES, ModBlocks.PEDESTAL
            },
            "pink_garnet", new DeferredBlock<?>[]{
                      ModBlocks.PINK_GARNET_BLOCK, ModBlocks.RAW_PINK_GARNET_BLOCK, ModBlocks.PINK_GARNET_ORE, ModBlocks.PINK_GARNET_BRICK_BLOCK
                    , ModBlocks.PINK_GARNET_NETHER_ORE, ModBlocks.PINK_GARNET_DEEPSLATE_ORE, ModBlocks.PINK_GARNET_END_ORE
                    //ModBlocks.PINK_GARNET_SLAB, ModBlocks.PINK_GARNET_STAIRS, ModBlocks.PINK_GARNET_PRESSURE_PLATE,
                    //ModBlocks.PINK_GARNET_BUTTON, ModBlocks.PINK_GARNET_FENCE, ModBlocks.PINK_GARNET_FENCE_GATE,
                    //ModBlocks.PINK_GARNET_WALL, ModBlocks.PINK_GARNET_DOOR, ModBlocks.PINK_GARNET_TRAPDOOR
            },
            "alexandrite", new DeferredBlock<?>[]{
                      ModBlocks.ALEXANDRITE_BLOCK, ModBlocks.RAW_ALEXANDRITE_BLOCK, ModBlocks.ALEXANDRITE_ORE, ModBlocks.ALEXANDRITE_BRICK_BLOCK
                    , ModBlocks.ALEXANDRITE_DEEPSLATE_ORE
                    , ModBlocks.ALEXANDRITE_SLAB, ModBlocks.ALEXANDRITE_STAIRS, ModBlocks.ALEXANDRITE_PRESSURE_PLATE
                    , ModBlocks.ALEXANDRITE_BUTTON, ModBlocks.ALEXANDRITE_FENCE, ModBlocks.ALEXANDRITE_FENCE_GATE
                    , ModBlocks.ALEXANDRITE_WALL, ModBlocks.ALEXANDRITE_DOOR, ModBlocks.ALEXANDRITE_TRAPDOOR
                    , ModBlocks.WALNUT_LOG, ModBlocks.WALNUT_WOOD, ModBlocks.STRIPPED_WALNUT_LOG, ModBlocks.STRIPPED_WALNUT_WOOD, ModBlocks.WALNUT_LEAVES, ModBlocks.WALNUT_PLANKS, ModBlocks.WALNUT_SAPLING
            }
    );

    public static Supplier<CreativeModeTab> createCreativeTab(String tabKeyStart, DeferredItem<?> item ) {
        return CREATIVE_MODE_TABS.register(tabKeyStart + "_items_tab", () -> CreativeModeTab.builder()
                .title(Component.translatable("itemGroup.mccourse." + tabKeyStart + "_items_tab"))
                .icon(() -> new ItemStack(item.get()))
                .displayItems((pParameters, pOutput) -> addElements(pOutput, ITEM_GROUPS.get(tabKeyStart)))
                //.withTabsBefore(ResourceLocation.fromNamespaceAndPath(MCCourseMod.MOD_ID, tabKeyStart + "_items_tab"))
                .build());
    }

    public static Supplier<CreativeModeTab> createCreativeTab(String tabKeyStart, DeferredBlock<?> block ) {
        return CREATIVE_MODE_TABS.register(tabKeyStart + "_blocks_tab", () -> CreativeModeTab.builder()
                .title(Component.translatable("itemGroup.mccourse." + tabKeyStart + "_blocks_tab"))
                .icon(() -> new ItemStack(block.get()))
                .displayItems((pParameters, pOutput) -> addElements(pOutput, BLOCK_GROUPS.get(tabKeyStart)))
                .withTabsBefore(ResourceLocation.fromNamespaceAndPath(MCCourseMod.MOD_ID, tabKeyStart + "_items_tab"))
                .build());
    }

    public static final Supplier<CreativeModeTab> BLACK_OPAL_ITEMS_TAB =
            createCreativeTab("black_opal", ModItems.BLACK_OPAL);

    public static final Supplier<CreativeModeTab> BISMUTH_ITEMS_TAB =
            createCreativeTab("bismuth", ModItems.BISMUTH);

    public static final Supplier<CreativeModeTab> ALEXANDRITE_ITEMS_TAB =
            createCreativeTab("alexandrite", ModItems.ALEXANDRITE);

    public static final Supplier<CreativeModeTab> PINK_GARNET_ITEMS_TAB =
            createCreativeTab("pink_garnet", ModItems.PINK_GARNET);

    public static final Supplier<CreativeModeTab> BISMUTH_BLOCKS_TAB =
            createCreativeTab("bismuth", ModBlocks.BISMUTH_BLOCK);

    public static final Supplier<CreativeModeTab> BLACK_OPAL_BLOCKS_TAB =
            createCreativeTab("black_opal", ModBlocks.BLACK_OPAL_BLOCK);

    public static final Supplier<CreativeModeTab> PINK_GARNET_BLOCKS_TAB =
            createCreativeTab("pink_garnet", ModBlocks.PINK_GARNET_BLOCK);

    public static final Supplier<CreativeModeTab> ALEXANDRITE_BLOCKS_TAB =
            createCreativeTab("alexandrite", ModBlocks.ALEXANDRITE_BLOCK);

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}