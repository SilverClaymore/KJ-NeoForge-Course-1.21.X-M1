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

    public static final Supplier<CreativeModeTab> BLACK_OPAL_ITEMS_TAB =
            CREATIVE_MODE_TABS.register("black_opal_items_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.mccourse.black_opal_items_tab"))
                    .icon(() -> new ItemStack(ModItems.BLACK_OPAL.get()))
                    .displayItems((pParameters, pOutput) -> {
                        addElements(pOutput, new DeferredItem[]{
                                ModItems.BLACK_OPAL, ModItems.RAW_BLACK_OPAL, ModItems.BLACK_OPAL_SWORD, ModItems.BLACK_OPAL_PICKAXE, ModItems.BLACK_OPAL_AXE, ModItems.BLACK_OPAL_SHOVEL, ModItems.BLACK_OPAL_HOE, ModItems.BLACK_OPAL_PAXEL, ModItems.BLACK_OPAL_HAMMER, ModItems.BLACK_OPAL_HELMET, ModItems.BLACK_OPAL_CHESTPLATE, ModItems.BLACK_OPAL_LEGGINGS, ModItems.BLACK_OPAL_BOOTS, ModItems.BLACK_OPAL_HORSE_ARMOR
                                , ModItems.KAUPEN_SMITHING_TEMPLATE
                                , ModItems.CHAINSAW
                                , ModItems.TOMATO, ModItems.TOMATO_SEEDS, ModItems.FROSTFIRE_ICE
                                , ModItems.BAR_BRAWL_MUSIC_DISC, ModItems.BLACK_OPAL_SWORD_LEVITATION
                                , ModItems.METAL_DETECTOR, ModItems.DATA_TABLET
                                , ModItems.KAUPEN_BOW
                                , ModItems.RADIATION_STAFF
                                , ModItems.PENGUIN_SPAWN_EGG
                        });

                        pOutput.accept(ModFluids.BLACK_OPAL_WATER_BUCKET);
                    }).build());

    public static final Supplier<CreativeModeTab> BISMUTH_ITEMS_TAB =
            CREATIVE_MODE_TABS.register("bismuth_items_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.mccourse.bismuth_items_tab"))
                    .icon(() -> new ItemStack(ModItems.BISMUTH.get()))
                    .displayItems((pParameters, pOutput) -> {
                        //missing paxel, horse armor
                        addElements(pOutput, new DeferredItem[]{
                                ModItems.BISMUTH, ModItems.RAW_BISMUTH, ModItems.BISMUTH_SWORD, ModItems.BISMUTH_PICKAXE, ModItems.BISMUTH_AXE, ModItems.BISMUTH_SHOVEL, ModItems.BISMUTH_HOE, ModItems.BISMUTH_HAMMER, ModItems.BISMUTH_HELMET, ModItems.BISMUTH_CHESTPLATE, ModItems.BISMUTH_LEGGINGS, ModItems.BISMUTH_BOOTS
                        });
                    }).build());

    public static final Supplier<CreativeModeTab> ALEXANDRITE_ITEMS_TAB =
            CREATIVE_MODE_TABS.register("alexandrite_items_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.mccourse.alexandrite_items_tab"))
                    .icon(() -> new ItemStack(ModItems.ALEXANDRITE.get()))
                    .displayItems((pParameters, pOutput) -> {
                        //addCommonItems(pOutput, ModItems.ALEXANDRITE, ModItems.RAW_ALEXANDRITE, null, null, null, null, null, null, null, ModItems.ALEXANDRITE_HELMET, ModItems.ALEXANDRITE_CHESTPLATE, ModItems.ALEXANDRITE_LEGGINGS, ModItems.ALEXANDRITE_BOOTS, null);
                        //missing sword, pickaxe, axe, shovel, hoe, paxel, hammer, horse armor
                        addElements(pOutput, new DeferredItem[]{
                                ModItems.ALEXANDRITE, ModItems.RAW_ALEXANDRITE, ModItems.ALEXANDRITE_HELMET, ModItems.ALEXANDRITE_CHESTPLATE, ModItems.ALEXANDRITE_LEGGINGS, ModItems.ALEXANDRITE_BOOTS
                        });
                    }).build());

    public static final Supplier<CreativeModeTab> PINK_GARNET_ITEMS_TAB =
            CREATIVE_MODE_TABS.register("pink_garnet_items_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.mccourse.pink_garnet_items_tab"))
                    .icon(() -> new ItemStack(ModItems.PINK_GARNET.get()))
                    .displayItems((pParameters, pOutput) -> {
                        //addCommonItems(pOutput, ModItems.PINK_GARNET, ModItems.RAW_PINK_GARNET, null, null, null, null, null, null, null, ModItems.PINK_GARNET_HELMET, ModItems.PINK_GARNET_CHESTPLATE, ModItems.PINK_GARNET_LEGGINGS, ModItems.PINK_GARNET_BOOTS, null);
                        //missing sword, pickaxe, axe, shovel, hoe, paxel, hammer, horse armor
                        addElements(pOutput, new DeferredItem[]{
                                ModItems.PINK_GARNET, ModItems.RAW_PINK_GARNET, ModItems.PINK_GARNET_HELMET, ModItems.PINK_GARNET_CHESTPLATE, ModItems.PINK_GARNET_LEGGINGS, ModItems.PINK_GARNET_BOOTS
                        });
                    }).build());

    public static final Supplier<CreativeModeTab> BLACK_OPAL_BLOCKS_TAB =
            CREATIVE_MODE_TABS.register("black_opal_blocks_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.mccourse.black_opal_blocks_tab"))
                    .icon(() -> new ItemStack(ModBlocks.BLACK_OPAL_BLOCK.get()))
                    .displayItems((pParameters, pOutput) -> {
                        addElements(pOutput,new DeferredBlock[]{
                                ModBlocks.BLACK_OPAL_BLOCK, ModBlocks.RAW_BLACK_OPAL_BLOCK, ModBlocks.BLACK_OPAL_ORE, ModBlocks.BLACK_OPAL_DEEPSLATE_ORE, ModBlocks.BLACK_OPAL_END_ORE, ModBlocks.BLACK_OPAL_NETHER_ORE, ModBlocks.BLACK_OPAL_SLAB, ModBlocks.BLACK_OPAL_STAIRS, ModBlocks.BLACK_OPAL_PRESSURE_PLATE, ModBlocks.BLACK_OPAL_BUTTON, ModBlocks.BLACK_OPAL_FENCE, ModBlocks.BLACK_OPAL_FENCE_GATE, ModBlocks.BLACK_OPAL_WALL, ModBlocks.BLACK_OPAL_DOOR, ModBlocks.BLACK_OPAL_TRAPDOOR
                                , ModBlocks.EBONY_SLAB, ModBlocks.EBONY_STAIRS, ModBlocks.EBONY_PRESSURE_PLATE, ModBlocks.EBONY_BUTTON, ModBlocks.EBONY_FENCE, ModBlocks.EBONY_FENCE_GATE, ModBlocks.EBONY_WALL
                                , ModBlocks.EBONY_LOG, ModBlocks.EBONY_WOOD, ModBlocks.STRIPPED_EBONY_LOG, ModBlocks.STRIPPED_EBONY_WOOD, ModBlocks.EBONY_LEAVES, ModBlocks.EBONY_PLANKS, ModBlocks.EBONY_SAPLING
                                , ModBlocks.MAGIC_BLOCK, ModBlocks.BLACK_OPAL_LAMP, ModBlocks.PETUNIA, ModBlocks.COLORED_LEAVES, ModBlocks.PEDESTAL
                        });
                    })
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(MCCourseMod.MOD_ID,"black_opal_items_tab"))
                    .build());

    public static final Supplier<CreativeModeTab> BISMUTH_BLOCKS_TAB =
            CREATIVE_MODE_TABS.register("bismuth_blocks_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.mccourse.bismuth_blocks_tab"))
                    .icon(() -> new ItemStack(ModBlocks.BISMUTH_BLOCK.get()))
                    .displayItems((pParameters, pOutput) -> {
                        //addCommonBlocks(pOutput, ModBlocks.BISMUTH_BLOCK, ModBlocks.RAW_BISMUTH_BLOCK, ModBlocks.BISMUTH_ORE, null, null, null, ModBlocks.BISMUTH_SLAB, ModBlocks.BISMUTH_STAIRS, ModBlocks.BISMUTH_PRESSURE_PLATE, ModBlocks.BISMUTH_BUTTON, ModBlocks.BISMUTH_FENCE, ModBlocks.BISMUTH_FENCE_GATE, ModBlocks.BISMUTH_WALL, ModBlocks.BISMUTH_DOOR, ModBlocks.BISMUTH_TRAPDOOR);
                        addElements(pOutput,new DeferredBlock[]{
                                //missing deepslateOre, endOre, netherOre
                                ModBlocks.BISMUTH_BLOCK, ModBlocks.RAW_BISMUTH_BLOCK, ModBlocks.BISMUTH_ORE, ModBlocks.BISMUTH_SLAB, ModBlocks.BISMUTH_STAIRS, ModBlocks.BISMUTH_PRESSURE_PLATE, ModBlocks.BISMUTH_BUTTON, ModBlocks.BISMUTH_FENCE, ModBlocks.BISMUTH_FENCE_GATE, ModBlocks.BISMUTH_WALL, ModBlocks.BISMUTH_DOOR, ModBlocks.BISMUTH_TRAPDOOR
                        });
                    })
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(MCCourseMod.MOD_ID,"bismuth_items_tab"))
                    .build());

    public static final Supplier<CreativeModeTab> ALEXANDRITE_BLOCKS_TAB =
            CREATIVE_MODE_TABS.register("alexandrite_blocks_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.mccourse.alexandrite_blocks_tab"))
                    .icon(() -> new ItemStack(ModBlocks.ALEXANDRITE_BLOCK.get()))
                    .displayItems((pParameters, pOutput) -> {
                        //addCommonBlocks(pOutput, ModBlocks.ALEXANDRITE_BLOCK, ModBlocks.RAW_ALEXANDRITE_BLOCK, ModBlocks.ALEXANDRITE_ORE, ModBlocks.ALEXANDRITE_DEEPSLATE_ORE, null, null, ModBlocks.ALEXANDRITE_SLAB, ModBlocks.ALEXANDRITE_STAIRS, ModBlocks.ALEXANDRITE_PRESSURE_PLATE, ModBlocks.ALEXANDRITE_BUTTON, ModBlocks.ALEXANDRITE_FENCE, ModBlocks.ALEXANDRITE_FENCE_GATE, ModBlocks.ALEXANDRITE_WALL, ModBlocks.ALEXANDRITE_DOOR, ModBlocks.ALEXANDRITE_TRAPDOOR);
                        addElements(pOutput,new DeferredBlock[]{
                                //missing endOre, netherOre
                                ModBlocks.ALEXANDRITE_BLOCK, ModBlocks.RAW_ALEXANDRITE_BLOCK, ModBlocks.ALEXANDRITE_ORE, ModBlocks.ALEXANDRITE_DEEPSLATE_ORE, ModBlocks.ALEXANDRITE_SLAB, ModBlocks.ALEXANDRITE_STAIRS, ModBlocks.ALEXANDRITE_PRESSURE_PLATE, ModBlocks.ALEXANDRITE_BUTTON, ModBlocks.ALEXANDRITE_FENCE, ModBlocks.ALEXANDRITE_FENCE_GATE, ModBlocks.ALEXANDRITE_WALL, ModBlocks.ALEXANDRITE_DOOR, ModBlocks.ALEXANDRITE_TRAPDOOR
                        });
                    })
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(MCCourseMod.MOD_ID,"alexandrite_items_tab"))
                    .build());

    public static final Supplier<CreativeModeTab> PINK_GARNET_BLOCKS_TAB =
            CREATIVE_MODE_TABS.register("pink_garnet_blocks_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.mccourse.pink_garnet_blocks_tab"))
                    .icon(() -> new ItemStack(ModBlocks.PINK_GARNET_BLOCK.get()))
                    .displayItems((pParameters, pOutput) -> {
                        //addCommonBlocks(pOutput, ModBlocks.PINK_GARNET_BLOCK, ModBlocks.RAW_PINK_GARNET_BLOCK, null, null, null, null, null, null, null, null, null, null, null, null, null);
                        addElements(pOutput,new DeferredBlock[]{
                                //missing a lot of stuff
                                ModBlocks.PINK_GARNET_BLOCK, ModBlocks.RAW_PINK_GARNET_BLOCK
                        });
                    })
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(MCCourseMod.MOD_ID,"pink_garnet_items_tab"))
                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}