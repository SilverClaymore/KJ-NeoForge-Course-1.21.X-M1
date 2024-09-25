package net.silverclaymore.mccourse.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.silverclaymore.mccourse.MCCourseMod;
import net.silverclaymore.mccourse.block.ModBlocks;
import net.silverclaymore.mccourse.fluid.ModFluids;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MCCourseMod.MOD_ID);

    public static final Supplier<CreativeModeTab> BLACK_OPAL_ITEMS_TAB =
            CREATIVE_MODE_TABS.register("black_opal_items_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.mccourse.black_opal_items_tab"))
                    .icon(() -> new ItemStack(ModItems.BLACK_OPAL.get()))
                    .displayItems((pParameters, pOutput) -> {
                     pOutput.accept(ModItems.BLACK_OPAL);
                     pOutput.accept(ModItems.RAW_BLACK_OPAL);

                     pOutput.accept(ModItems.CHAINSAW);
                     pOutput.accept(ModItems.TOMATO);
                     pOutput.accept(ModItems.TOMATO_SEEDS);
                     pOutput.accept(ModItems.FROSTFIRE_ICE);

                     pOutput.accept(ModItems.BAR_BRAWL_MUSIC_DISC);

                     pOutput.accept(ModItems.BLACK_OPAL_SWORD);
                     pOutput.accept(ModItems.BLACK_OPAL_SWORD_LEVITATION);
                     pOutput.accept(ModItems.BLACK_OPAL_PICKAXE);
                     pOutput.accept(ModItems.BLACK_OPAL_AXE);
                     pOutput.accept(ModItems.BLACK_OPAL_SHOVEL);
                     pOutput.accept(ModItems.BLACK_OPAL_HOE);

                     pOutput.accept(ModItems.BLACK_OPAL_PAXEL);
                     pOutput.accept(ModItems.BLACK_OPAL_HAMMER);

                     pOutput.accept(ModItems.BLACK_OPAL_HELMET);
                     pOutput.accept(ModItems.BLACK_OPAL_CHESTPLATE);
                     pOutput.accept(ModItems.BLACK_OPAL_LEGGINGS);
                     pOutput.accept(ModItems.BLACK_OPAL_BOOTS);

                     pOutput.accept(ModItems.METAL_DETECTOR);
                     pOutput.accept(ModItems.DATA_TABLET);

                     pOutput.accept(ModItems.KAUPEN_BOW);

                     pOutput.accept(ModItems.RADIATION_STAFF);

                     pOutput.accept(ModFluids.BLACK_OPAL_WATER_BUCKET);

                     pOutput.accept(ModItems.PENGUIN_SPAWN_EGG);

                    }).build());

    public static final Supplier<CreativeModeTab> BISMUTH_ITEMS_TAB =
            CREATIVE_MODE_TABS.register("bismuth_items_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.mccourse.bismuth_items_tab"))
                    .icon(() -> new ItemStack(ModItems.BISMUTH.get()))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.BISMUTH);
                        pOutput.accept(ModItems.RAW_BISMUTH);

                        pOutput.accept(ModItems.BISMUTH_SWORD);
                        pOutput.accept(ModItems.BISMUTH_PICKAXE);
                        pOutput.accept(ModItems.BISMUTH_AXE);
                        pOutput.accept(ModItems.BISMUTH_SHOVEL);
                        pOutput.accept(ModItems.BISMUTH_HOE);

                    }).build());


    public static final Supplier<CreativeModeTab> BLACK_OPAL_BLOCKS_TAB =
            CREATIVE_MODE_TABS.register("black_opal_blocks_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.mccourse.black_opal_blocks_tab"))
                    .icon(() -> new ItemStack(ModBlocks.BLACK_OPAL_BLOCK.get()))
                    .displayItems((pParameters, pOutput) -> {
                     pOutput.accept(ModBlocks.BLACK_OPAL_BLOCK);
                     pOutput.accept(ModBlocks.RAW_BLACK_OPAL_BLOCK);

                     pOutput.accept(ModBlocks.BLACK_OPAL_ORE);
                     pOutput.accept(ModBlocks.BLACK_OPAL_DEEPSLATE_ORE);
                     pOutput.accept(ModBlocks.BLACK_OPAL_END_ORE);
                     pOutput.accept(ModBlocks.BLACK_OPAL_NETHER_ORE);

                     pOutput.accept(ModBlocks.MAGIC_BLOCK);

                     pOutput.accept(ModBlocks.BLACK_OPAL_SLAB);
                     pOutput.accept(ModBlocks.EBONY_SLAB);

                     pOutput.accept(ModBlocks.BLACK_OPAL_STAIRS);
                     pOutput.accept(ModBlocks.EBONY_STAIRS);

                     pOutput.accept(ModBlocks.BLACK_OPAL_PRESSURE_PLATE);
                     pOutput.accept(ModBlocks.BLACK_OPAL_BUTTON);

                     pOutput.accept(ModBlocks.EBONY_PRESSURE_PLATE);
                     pOutput.accept(ModBlocks.EBONY_BUTTON);

                     pOutput.accept(ModBlocks.BLACK_OPAL_FENCE);
                     pOutput.accept(ModBlocks.BLACK_OPAL_FENCE_GATE);
                     pOutput.accept(ModBlocks.BLACK_OPAL_WALL);

                     pOutput.accept(ModBlocks.BLACK_OPAL_DOOR);
                     pOutput.accept(ModBlocks.BLACK_OPAL_TRAPDOOR);

                     pOutput.accept(ModBlocks.BLACK_OPAL_LAMP);

                     pOutput.accept(ModBlocks.PETUNIA);
                     pOutput.accept(ModBlocks.COLORED_LEAVES);

                     pOutput.accept(ModBlocks.PEDESTAL);

                     pOutput.accept(ModBlocks.EBONY_LOG);
                     pOutput.accept(ModBlocks.EBONY_WOOD);
                     pOutput.accept(ModBlocks.STRIPPED_EBONY_LOG);
                     pOutput.accept(ModBlocks.STRIPPED_EBONY_WOOD);
                     pOutput.accept(ModBlocks.EBONY_LEAVES);
                     pOutput.accept(ModBlocks.EBONY_PLANKS);
                     pOutput.accept(ModBlocks.EBONY_SAPLING);

                    })
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(MCCourseMod.MOD_ID,"black_opal_items_tab"))
                    .build());

    public static final Supplier<CreativeModeTab> BISMUTH_BLOCKS_TAB =
            CREATIVE_MODE_TABS.register("bismuth_blocks_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.mccourse.bismuth_blocks_tab"))
                    .icon(() -> new ItemStack(ModBlocks.BISMUTH_BLOCK.get()))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModBlocks.BISMUTH_BLOCK);
                        pOutput.accept(ModBlocks.RAW_BISMUTH_BLOCK);

                        pOutput.accept(ModBlocks.BISMUTH_ORE);

                        pOutput.accept(ModBlocks.BISMUTH_PRESSURE_PLATE);
                        pOutput.accept(ModBlocks.BISMUTH_SLAB);
                        pOutput.accept(ModBlocks.BISMUTH_BUTTON);
                        pOutput.accept(ModBlocks.BISMUTH_STAIRS);

                        pOutput.accept(ModBlocks.BISMUTH_DOOR);
                        pOutput.accept(ModBlocks.BISMUTH_TRAPDOOR);

                        //pOutput.accept(ModBlocks.BISMUTH_DEEPSLATE_ORE);
                        //pOutput.accept(ModBlocks.BISMUTH_END_ORE);
                        //pOutput.accept(ModBlocks.BISMUTH_NETHER_ORE);

                    })
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(MCCourseMod.MOD_ID,"bismuth_items_tab"))
                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
