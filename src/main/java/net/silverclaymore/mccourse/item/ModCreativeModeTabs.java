package net.silverclaymore.mccourse.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
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

    private static void addCommonItems(CreativeModeTab.Output pOutput, DeferredItem<Item> item, DeferredItem<Item> rawItem, DeferredItem<Item> sword, DeferredItem<Item> pickaxe, DeferredItem<Item> axe, DeferredItem<Item> shovel, DeferredItem<Item> hoe, DeferredItem<Item> paxel, DeferredItem<Item> hammer, DeferredItem<Item> helmet, DeferredItem<Item> chestplate, DeferredItem<Item> leggings, DeferredItem<Item> boots, DeferredItem<Item> horseArmor) {
        if(item != null) pOutput.accept(item);
        if(rawItem != null) pOutput.accept(rawItem);

        if(sword != null) pOutput.accept(sword);
        if(pickaxe != null) pOutput.accept(pickaxe);
        if(axe != null) pOutput.accept(axe);
        if(shovel != null) pOutput.accept(shovel);
        if(hoe != null) pOutput.accept(hoe);

        if(paxel != null) pOutput.accept(paxel);
        if(hammer != null) pOutput.accept(hammer);

        if(helmet != null) pOutput.accept(helmet);
        if(chestplate != null) pOutput.accept(chestplate);
        if(leggings != null) pOutput.accept(leggings);
        if(boots != null) pOutput.accept(boots);

        if(horseArmor != null) pOutput.accept(horseArmor);
    }

    private static void addCommonBlocks(CreativeModeTab.Output pOutput, DeferredBlock<Block> block, DeferredBlock<Block> rawBlock, DeferredBlock<Block> ore, DeferredBlock<Block> deepslateOre, DeferredBlock<Block> endOre, DeferredBlock<Block> netherOre, DeferredBlock<Block> slab, DeferredBlock<Block> stairs, DeferredBlock<Block> pressurePlate, DeferredBlock<Block> button, DeferredBlock<Block> fence, DeferredBlock<Block> fenceGate, DeferredBlock<Block> wall, DeferredBlock<Block> door, DeferredBlock<Block> trapdoor ) {
        if(block != null) pOutput.accept(block);
        if(rawBlock != null) pOutput.accept(rawBlock);

        if(ore != null) pOutput.accept(ore);
        if(deepslateOre != null) pOutput.accept(deepslateOre);
        if(endOre != null) pOutput.accept(endOre);
        if(netherOre != null) pOutput.accept(netherOre);

        if(slab != null) pOutput.accept(slab);
        if(stairs != null) pOutput.accept(stairs);
        if(pressurePlate != null) pOutput.accept(pressurePlate);
        if(button != null) pOutput.accept(button);
        if(fence != null) pOutput.accept(fence);
        if(fenceGate != null) pOutput.accept(fenceGate);
        if(wall != null) pOutput.accept(wall);
        if(door != null) pOutput.accept(door);
        if(trapdoor != null) pOutput.accept(trapdoor);
    }

    private static void addCommonWoodBlocks(CreativeModeTab.Output pOutput, DeferredBlock<Block> log, DeferredBlock<Block> wood, DeferredBlock<Block> strippedLog, DeferredBlock<Block> strippedWood, DeferredBlock<Block> leaves, DeferredBlock<Block> planks, DeferredBlock<Block> sapling) {
        if(log != null) pOutput.accept(log);
        if(wood != null) pOutput.accept(wood);
        if(strippedLog != null) pOutput.accept(strippedLog);
        if(strippedWood != null) pOutput.accept(strippedWood);
        if(leaves != null) pOutput.accept(leaves);
        if(planks != null) pOutput.accept(planks);
        if(sapling != null) pOutput.accept(sapling);
    }

    public static final Supplier<CreativeModeTab> BLACK_OPAL_ITEMS_TAB =
            CREATIVE_MODE_TABS.register("black_opal_items_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.mccourse.black_opal_items_tab"))
                    .icon(() -> new ItemStack(ModItems.BLACK_OPAL.get()))
                    .displayItems((pParameters, pOutput) -> {
                        addCommonItems(pOutput, ModItems.BLACK_OPAL, ModItems.RAW_BLACK_OPAL, ModItems.BLACK_OPAL_SWORD, ModItems.BLACK_OPAL_PICKAXE, ModItems.BLACK_OPAL_AXE, ModItems.BLACK_OPAL_SHOVEL, ModItems.BLACK_OPAL_HOE, ModItems.BLACK_OPAL_PAXEL, ModItems.BLACK_OPAL_HAMMER, ModItems.BLACK_OPAL_HELMET, ModItems.BLACK_OPAL_CHESTPLATE, ModItems.BLACK_OPAL_LEGGINGS, ModItems.BLACK_OPAL_BOOTS, ModItems.BLACK_OPAL_HORSE_ARMOR);

                        pOutput.accept(ModItems.KAUPEN_SMITHING_TEMPLATE);

                        pOutput.accept(ModItems.CHAINSAW);
                        pOutput.accept(ModItems.TOMATO);
                        pOutput.accept(ModItems.TOMATO_SEEDS);
                        pOutput.accept(ModItems.FROSTFIRE_ICE);

                        pOutput.accept(ModItems.BAR_BRAWL_MUSIC_DISC);
                        pOutput.accept(ModItems.BLACK_OPAL_SWORD_LEVITATION);

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
                        addCommonItems(pOutput, ModItems.BISMUTH, ModItems.RAW_BISMUTH, ModItems.BISMUTH_SWORD, ModItems.BISMUTH_PICKAXE, ModItems.BISMUTH_AXE, ModItems.BISMUTH_SHOVEL, ModItems.BISMUTH_HOE, null, ModItems.BISMUTH_HAMMER, null, null, null, null, null);
                    }).build());

    public static final Supplier<CreativeModeTab> ALEXANDRITE_ITEMS_TAB =
            CREATIVE_MODE_TABS.register("alexandrite_items_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.mccourse.alexandrite_items_tab"))
                    .icon(() -> new ItemStack(ModItems.ALEXANDRITE.get()))
                    .displayItems((pParameters, pOutput) -> {
                        addCommonItems(pOutput, ModItems.ALEXANDRITE, ModItems.RAW_ALEXANDRITE, null, null, null, null, null, null, null, null, null, null, null, null);
                    }).build());


    public static final Supplier<CreativeModeTab> BLACK_OPAL_BLOCKS_TAB =
            CREATIVE_MODE_TABS.register("black_opal_blocks_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.mccourse.black_opal_blocks_tab"))
                    .icon(() -> new ItemStack(ModBlocks.BLACK_OPAL_BLOCK.get()))
                    .displayItems((pParameters, pOutput) -> {
                        addCommonBlocks(pOutput, ModBlocks.BLACK_OPAL_BLOCK, ModBlocks.RAW_BLACK_OPAL_BLOCK, ModBlocks.BLACK_OPAL_ORE, ModBlocks.BLACK_OPAL_DEEPSLATE_ORE, ModBlocks.BLACK_OPAL_END_ORE, ModBlocks.BLACK_OPAL_NETHER_ORE, ModBlocks.BLACK_OPAL_SLAB, ModBlocks.BLACK_OPAL_STAIRS, ModBlocks.BLACK_OPAL_PRESSURE_PLATE, ModBlocks.BLACK_OPAL_BUTTON, ModBlocks.BLACK_OPAL_FENCE, ModBlocks.BLACK_OPAL_FENCE_GATE, ModBlocks.BLACK_OPAL_WALL, ModBlocks.BLACK_OPAL_DOOR, ModBlocks.BLACK_OPAL_TRAPDOOR);
                        addCommonBlocks(pOutput, null, null, null, null, null, null, ModBlocks.EBONY_SLAB, ModBlocks.EBONY_STAIRS, ModBlocks.EBONY_PRESSURE_PLATE, ModBlocks.EBONY_BUTTON, ModBlocks.EBONY_FENCE, ModBlocks.EBONY_FENCE_GATE, ModBlocks.EBONY_WALL, null, null);
                        addCommonWoodBlocks(pOutput, ModBlocks.EBONY_LOG, ModBlocks.EBONY_WOOD, ModBlocks.STRIPPED_EBONY_LOG, ModBlocks.STRIPPED_EBONY_WOOD, ModBlocks.EBONY_LEAVES, ModBlocks.EBONY_PLANKS, ModBlocks.EBONY_SAPLING);
                        pOutput.accept(ModBlocks.MAGIC_BLOCK);

                        pOutput.accept(ModBlocks.BLACK_OPAL_LAMP);

                        pOutput.accept(ModBlocks.PETUNIA);
                        pOutput.accept(ModBlocks.COLORED_LEAVES);

                        pOutput.accept(ModBlocks.PEDESTAL);

                    })
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(MCCourseMod.MOD_ID,"black_opal_items_tab"))
                    .build());

    public static final Supplier<CreativeModeTab> BISMUTH_BLOCKS_TAB =
            CREATIVE_MODE_TABS.register("bismuth_blocks_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.mccourse.bismuth_blocks_tab"))
                    .icon(() -> new ItemStack(ModBlocks.BISMUTH_BLOCK.get()))
                    .displayItems((pParameters, pOutput) -> {
                        addCommonBlocks(pOutput, ModBlocks.BISMUTH_BLOCK, ModBlocks.RAW_BISMUTH_BLOCK, ModBlocks.BISMUTH_ORE, null, null, null, ModBlocks.BISMUTH_SLAB, ModBlocks.BISMUTH_STAIRS, ModBlocks.BISMUTH_PRESSURE_PLATE, ModBlocks.BISMUTH_BUTTON, ModBlocks.BISMUTH_FENCE, ModBlocks.BISMUTH_FENCE_GATE, ModBlocks.BISMUTH_WALL, ModBlocks.BISMUTH_DOOR, ModBlocks.BISMUTH_TRAPDOOR);

                    })
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(MCCourseMod.MOD_ID,"bismuth_items_tab"))
                    .build());

    public static final Supplier<CreativeModeTab> ALEXANDRITE_BLOCKS_TAB =
            CREATIVE_MODE_TABS.register("alexandrite_blocks_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.mccourse.alexandrite_blocks_tab"))
                    .icon(() -> new ItemStack(ModBlocks.ALEXANDRITE_BLOCK.get()))
                    .displayItems((pParameters, pOutput) -> {
                        addCommonBlocks(pOutput, ModBlocks.ALEXANDRITE_BLOCK, ModBlocks.RAW_ALEXANDRITE_BLOCK, ModBlocks.ALEXANDRITE_ORE, ModBlocks.ALEXANDRITE_DEEPSLATE_ORE, null, null, ModBlocks.ALEXANDRITE_SLAB, ModBlocks.ALEXANDRITE_STAIRS, ModBlocks.ALEXANDRITE_PRESSURE_PLATE, ModBlocks.ALEXANDRITE_BUTTON, ModBlocks.ALEXANDRITE_FENCE, ModBlocks.ALEXANDRITE_FENCE_GATE, ModBlocks.ALEXANDRITE_WALL, ModBlocks.ALEXANDRITE_DOOR, ModBlocks.ALEXANDRITE_TRAPDOOR);
                    })
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(MCCourseMod.MOD_ID,"alexandrite_items_tab"))
                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
