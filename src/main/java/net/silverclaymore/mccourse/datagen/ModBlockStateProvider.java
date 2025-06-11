package net.silverclaymore.mccourse.datagen;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.silverclaymore.mccourse.MCCourseMod;
import net.silverclaymore.mccourse.block.ModBlocks;
import net.silverclaymore.mccourse.block.custom.BlackOpalLampBlock;
import net.silverclaymore.mccourse.block.custom.TomatoCropBlock;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, MCCourseMod.MOD_ID, exFileHelper);
    }

    private static final Map<String, Pair<DeferredBlock<Block>, List<DeferredBlock<Block>>>> BLOCK_GROUPS = Map.ofEntries(
            Map.entry("black_opal", Pair.of(ModBlocks.BLACK_OPAL_BLOCK, List.of(
                      ModBlocks.BLACK_OPAL_STAIRS, ModBlocks.BLACK_OPAL_SLAB, ModBlocks.BLACK_OPAL_PRESSURE_PLATE, ModBlocks.BLACK_OPAL_BUTTON
                    , ModBlocks.BLACK_OPAL_FENCE, ModBlocks.BLACK_OPAL_FENCE_GATE, ModBlocks.BLACK_OPAL_WALL, ModBlocks.BLACK_OPAL_DOOR, ModBlocks.BLACK_OPAL_TRAPDOOR
            ))),
            Map.entry("bismuth", Pair.of(ModBlocks.BISMUTH_BLOCK, List.of(
                      ModBlocks.BISMUTH_STAIRS, ModBlocks.BISMUTH_SLAB, ModBlocks.BISMUTH_PRESSURE_PLATE, ModBlocks.BISMUTH_BUTTON
                    , ModBlocks.BISMUTH_FENCE, ModBlocks.BISMUTH_FENCE_GATE, ModBlocks.BISMUTH_WALL, ModBlocks.BISMUTH_DOOR, ModBlocks.BISMUTH_TRAPDOOR
            ))),
            Map.entry("alexandrite", Pair.of(ModBlocks.ALEXANDRITE_BLOCK, List.of(
                      ModBlocks.ALEXANDRITE_STAIRS, ModBlocks.ALEXANDRITE_SLAB, ModBlocks.ALEXANDRITE_PRESSURE_PLATE, ModBlocks.ALEXANDRITE_BUTTON
                    , ModBlocks.ALEXANDRITE_FENCE, ModBlocks.ALEXANDRITE_FENCE_GATE, ModBlocks.ALEXANDRITE_WALL, ModBlocks.ALEXANDRITE_DOOR, ModBlocks.ALEXANDRITE_TRAPDOOR
            ))),
            Map.entry("ebony", Pair.of(ModBlocks.EBONY_PLANKS, List.of(
                      ModBlocks.EBONY_STAIRS, ModBlocks.EBONY_SLAB, ModBlocks.EBONY_PRESSURE_PLATE, ModBlocks.EBONY_BUTTON
                    , ModBlocks.EBONY_FENCE, ModBlocks.EBONY_FENCE_GATE, ModBlocks.EBONY_WALL
            )))
    );

    private static final Map<String, List<DeferredBlock<Block>>> BLOCKS_WITH_ITEMS = Map.ofEntries(
            Map.entry("black_opal", List.of(
                      ModBlocks.BLACK_OPAL_BLOCK, ModBlocks.RAW_BLACK_OPAL_BLOCK, ModBlocks.BLACK_OPAL_ORE, ModBlocks.BLACK_OPAL_DEEPSLATE_ORE
                    , ModBlocks.BLACK_OPAL_END_ORE, ModBlocks.BLACK_OPAL_NETHER_ORE, ModBlocks.MAGIC_BLOCK
                    , ModBlocks.BLACK_OPAL_BRICK_BLOCK
            )),
            Map.entry("black_opal_64", List.of(
                    ModBlocks.BLACK_OPAL_64_BLOCK, ModBlocks.BLACK_OPAL_64_BRICK_BLOCK, ModBlocks.BLACK_OPAL_64_PILLAR_BLOCK, ModBlocks.BLACK_OPAL_64_STONE_BRICK_BLOCK
            )),
            Map.entry("bismuth", List.of(
                      ModBlocks.BISMUTH_BLOCK, ModBlocks.RAW_BISMUTH_BLOCK, ModBlocks.BISMUTH_ORE, ModBlocks.BISMUTH_DEEPSLATE_ORE
                    , ModBlocks.BISMUTH_END_ORE, ModBlocks.BISMUTH_NETHER_ORE
                    , ModBlocks.BISMUTH_BRICK_BLOCK
            )),
            Map.entry("alexandrite", List.of(
                      ModBlocks.ALEXANDRITE_BLOCK, ModBlocks.RAW_ALEXANDRITE_BLOCK, ModBlocks.ALEXANDRITE_ORE, ModBlocks.ALEXANDRITE_DEEPSLATE_ORE
                    , ModBlocks.ALEXANDRITE_BRICK_BLOCK
            )),
            Map.entry("pink_garnet", List.of(
                      ModBlocks.PINK_GARNET_BLOCK, ModBlocks.RAW_PINK_GARNET_BLOCK, ModBlocks.PINK_GARNET_ORE, ModBlocks.PINK_GARNET_DEEPSLATE_ORE
                    , ModBlocks.PINK_GARNET_END_ORE, ModBlocks.PINK_GARNET_NETHER_ORE
                    , ModBlocks.PINK_GARNET_BRICK_BLOCK
            ))
    );

    @Override
    protected void registerStatesAndModels() {
        BLOCKS_WITH_ITEMS.forEach((groupName, blocks) -> {
            blocks.forEach(this::blockWithItem);
        });

        commonWoodenBlocks(ModBlocks.EBONY_LOG, ModBlocks.EBONY_PLANKS , ModBlocks.EBONY_WOOD, ModBlocks.STRIPPED_EBONY_LOG, ModBlocks.STRIPPED_EBONY_WOOD, ModBlocks.EBONY_LEAVES, ModBlocks.EBONY_SAPLING);
        commonWoodenBlocks(ModBlocks.WALNUT_LOG, ModBlocks.WALNUT_PLANKS, ModBlocks.WALNUT_WOOD, ModBlocks.STRIPPED_WALNUT_LOG, ModBlocks.STRIPPED_WALNUT_WOOD, ModBlocks.WALNUT_LEAVES, ModBlocks.WALNUT_SAPLING);
        commonWoodenBlocks(ModBlocks.BLOODWOOD_LOG, ModBlocks.BLOODWOOD_PLANKS, ModBlocks.BLOODWOOD_WOOD, ModBlocks.STRIPPED_BLOODWOOD_LOG, ModBlocks.STRIPPED_BLOODWOOD_WOOD, ModBlocks.BLOODWOOD_LEAVES, ModBlocks.BLOODWOOD_SAPLING);

        commonBlocksWithTexture();

        customLamp();

        makeCrop(((TomatoCropBlock) ModBlocks.TOMATO_CROP.get()), "tomato_crop_stage","tomato_crop_stage");

        simpleBlock(ModBlocks.PETUNIA.get(),
                models().cross(blockTexture(ModBlocks.PETUNIA.get()).getPath(), blockTexture(ModBlocks.PETUNIA.get())).renderType("cutout"));
        simpleBlock(ModBlocks.POTTED_PETUNIA.get(), models().singleTexture("potted_petunia", ResourceLocation.parse("flower_pot_cross"), "plant",
                blockTexture(ModBlocks.PETUNIA.get())).renderType("cutout"));

        leavesBlock(ModBlocks.COLORED_LEAVES);
    }

    //private void leavesBlock(DeferredBlock<Block> deferredBlock) {
        //simpleBlockWithItem(deferredBlock.get(),
                //models().singleTexture(deferredBlock.getId().getPath(), ResourceLocation.parse("minecraft:block/leaves"),
                        //"all", blockTexture(deferredBlock.get())).renderType("cutout"));
    //}

    private void leavesBlock(DeferredBlock<Block> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(),
                models().singleTexture(BuiltInRegistries.BLOCK.getKey(deferredBlock.get()).getPath(), ResourceLocation.parse("minecraft:block/leaves"),
                        "all", blockTexture(deferredBlock.get())).renderType("cutout"));
    }

    private void saplingBlock(DeferredBlock<Block> deferredBlock) {
        simpleBlock(deferredBlock.get(), models().cross(BuiltInRegistries.BLOCK.getKey(deferredBlock.get()).getPath(), blockTexture(deferredBlock.get())).renderType("cutout"));
    }


    public void makeCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> states(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] states(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((TomatoCropBlock) block).getAgeProperty()),
                ResourceLocation.fromNamespaceAndPath(MCCourseMod.MOD_ID, "block/" + textureName + "_" +
                        state.getValue(((TomatoCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    private void customLamp() {
        getVariantBuilder(ModBlocks.BLACK_OPAL_LAMP.get()).forAllStates(state -> {
            if(state.getValue(BlackOpalLampBlock.CLICKED)) {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("black_opal_lamp_on",
                        ResourceLocation.fromNamespaceAndPath(MCCourseMod.MOD_ID, "block/" + "black_opal_lamp_on")))};
            } else {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("black_opal_lamp_off",
                        ResourceLocation.fromNamespaceAndPath(MCCourseMod.MOD_ID, "block/" + "black_opal_lamp_off")))};
            }
        });
        simpleBlockItem(ModBlocks.BLACK_OPAL_LAMP.get(), models().cubeAll("black_opal_lamp_on",
                ResourceLocation.fromNamespaceAndPath(MCCourseMod.MOD_ID, "block/" + "black_opal_lamp_on")));
    }

    private void commonWoodenBlocks(DeferredBlock<Block> log, DeferredBlock<Block> planks, DeferredBlock<Block> wood, DeferredBlock<Block> strippedLog, DeferredBlock<Block> strippedWood, DeferredBlock<Block> leaves, DeferredBlock<Block> sapling){
        logBlock(((RotatedPillarBlock) log.get()));
        axisBlock(((RotatedPillarBlock) wood.get()), blockTexture(log.get()), blockTexture(log.get()));
        logBlock(((RotatedPillarBlock) strippedLog.get()));
        axisBlock(((RotatedPillarBlock) strippedWood.get()), blockTexture(strippedLog.get()), blockTexture(strippedLog.get()));

        blockWithItem(planks);
        blockItem(planks);

        blockItem(log);
        blockItem(wood);
        blockItem(strippedLog);
        blockItem(strippedWood);

        leavesBlock(leaves);
        saplingBlock(sapling);
    }

    private void commonBlocksWithTexture() {
        BLOCK_GROUPS.forEach((groupName, pair) -> {
            Block textureBlock = pair.getLeft().get(); // Extract texture block
            List<DeferredBlock<Block>> blocks = pair.getRight(); // Extract block list

            for (DeferredBlock<Block> block : blocks) {
                if (block == null) continue;
                Block instance = block.get();

                switch (instance) {
                    case StairBlock stair -> {
                        stairsBlock(stair, blockTexture(textureBlock));
                        blockItem(block);
                    }
                    case SlabBlock slab -> {
                        slabBlock(slab, blockTexture(textureBlock), blockTexture(textureBlock));
                        blockItem(block);
                    }
                    case PressurePlateBlock pressurePlate -> {
                        pressurePlateBlock(pressurePlate, blockTexture(textureBlock));
                        blockItem(block);
                    }
                    case ButtonBlock button -> buttonBlock(button, blockTexture(textureBlock));
                    case FenceGateBlock fenceGate -> {
                        fenceGateBlock(fenceGate, blockTexture(textureBlock));
                        blockItem(block);
                    }
                    case FenceBlock fence -> {
                        fenceBlock(fence, blockTexture(textureBlock));
                    }
                    case WallBlock wall -> {
                        wallBlock(wall, blockTexture(textureBlock));
                    }
                    case DoorBlock door -> {
                        doorBlockWithRenderType(door, modLoc("block/" + groupName + "_door_bottom"), modLoc("block/" + groupName + "_door_top"), "cutout");
                    }
                    case TrapDoorBlock trapdoor -> {
                        trapdoorBlockWithRenderType(trapdoor, modLoc("block/" + groupName + "_trapdoor"), true, "cutout");
                        blockItem(block, "_bottom");
                    }
                    default -> {} // Do nothing for unsupported types
                }
            }
        });
    }

    private void blockWithItem(DeferredBlock<Block> deferredBlock){
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<Block> deferredBlock){
        blockItem(deferredBlock,"");
    }

    private void blockItem(DeferredBlock<Block> deferredBlock, String appendix){
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("mccourse:block/" + deferredBlock.getId().getPath() + appendix));
    }
}