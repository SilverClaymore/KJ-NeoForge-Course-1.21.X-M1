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

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, MCCourseMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        commonBlocksWithItem(ModBlocks.BLACK_OPAL_BLOCK, ModBlocks.RAW_BLACK_OPAL_BLOCK, ModBlocks.BLACK_OPAL_ORE, ModBlocks.BLACK_OPAL_DEEPSLATE_ORE, ModBlocks.BLACK_OPAL_END_ORE, ModBlocks.BLACK_OPAL_NETHER_ORE, ModBlocks.MAGIC_BLOCK);
        commonBlocksWithItem(ModBlocks.BISMUTH_BLOCK, ModBlocks.RAW_BISMUTH_BLOCK, ModBlocks.BISMUTH_ORE, null, null, null, null);
        commonBlocksWithItem(ModBlocks.ALEXANDRITE_BLOCK, ModBlocks.RAW_ALEXANDRITE_BLOCK, ModBlocks.ALEXANDRITE_ORE, ModBlocks.ALEXANDRITE_DEEPSLATE_ORE, null, null, null);

        commonWoodenBlocks(ModBlocks.EBONY_LOG, ModBlocks.EBONY_PLANKS, ModBlocks.EBONY_WOOD, ModBlocks.STRIPPED_EBONY_LOG, ModBlocks.STRIPPED_EBONY_WOOD, ModBlocks.EBONY_LEAVES, ModBlocks.EBONY_SAPLING);

        commonBlocksWithTexture(ModBlocks.BLACK_OPAL_BLOCK, "black_opal", ModBlocks.BLACK_OPAL_STAIRS, ModBlocks.BLACK_OPAL_SLAB, ModBlocks.BLACK_OPAL_PRESSURE_PLATE, ModBlocks.BLACK_OPAL_BUTTON, ModBlocks.BLACK_OPAL_FENCE, ModBlocks.BLACK_OPAL_FENCE_GATE, ModBlocks.BLACK_OPAL_WALL, ModBlocks.BLACK_OPAL_DOOR, ModBlocks.BLACK_OPAL_TRAPDOOR);
        commonBlocksWithTexture(ModBlocks.BISMUTH_BLOCK, "bismuth", ModBlocks.BISMUTH_STAIRS, ModBlocks.BISMUTH_SLAB, ModBlocks.BISMUTH_PRESSURE_PLATE, ModBlocks.BISMUTH_BUTTON, ModBlocks.BISMUTH_FENCE, ModBlocks.BISMUTH_FENCE_GATE, ModBlocks.BISMUTH_WALL, ModBlocks.BISMUTH_DOOR, ModBlocks.BISMUTH_TRAPDOOR);
        commonBlocksWithTexture(ModBlocks.ALEXANDRITE_BLOCK, "alexandrite", ModBlocks.ALEXANDRITE_STAIRS, ModBlocks.ALEXANDRITE_SLAB, ModBlocks.ALEXANDRITE_PRESSURE_PLATE, ModBlocks.ALEXANDRITE_BUTTON, ModBlocks.ALEXANDRITE_FENCE, ModBlocks.ALEXANDRITE_FENCE_GATE, ModBlocks.ALEXANDRITE_WALL, ModBlocks.ALEXANDRITE_DOOR, ModBlocks.ALEXANDRITE_TRAPDOOR);

        commonBlocksWithTexture(ModBlocks.EBONY_PLANKS, "ebony", ModBlocks.EBONY_STAIRS, ModBlocks.EBONY_SLAB, ModBlocks.EBONY_PRESSURE_PLATE, ModBlocks.EBONY_BUTTON, ModBlocks.EBONY_FENCE, ModBlocks.EBONY_FENCE_GATE, ModBlocks.EBONY_WALL, null, null);

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

    private void commonBlocksWithTexture(DeferredBlock<Block> blockAsTexture, String group, DeferredBlock<Block> stairs, DeferredBlock<Block> slab, DeferredBlock<Block> pressurePlate, DeferredBlock<Block> button, DeferredBlock<Block> fence, DeferredBlock<Block> fenceGate, DeferredBlock<Block> wall, DeferredBlock<Block> door, DeferredBlock<Block> trapdoor){
        if (stairs != null) stairsBlock(((StairBlock) stairs.get()), blockTexture(blockAsTexture.get()));
        if (slab != null) slabBlock(((SlabBlock) slab.get()), blockTexture(blockAsTexture.get()), blockTexture(blockAsTexture.get()));
        if (pressurePlate != null) pressurePlateBlock(((PressurePlateBlock) pressurePlate.get()), blockTexture(blockAsTexture.get()));
        if (button != null) buttonBlock(((ButtonBlock) button.get()), blockTexture(blockAsTexture.get()));
        if (fence != null) fenceBlock(((FenceBlock) fence.get()), blockTexture(blockAsTexture.get()));
        if (fenceGate != null) fenceGateBlock(((FenceGateBlock) fenceGate.get()), blockTexture(blockAsTexture.get()));
        if (wall != null) wallBlock(((WallBlock) wall.get()), blockTexture(blockAsTexture.get()));

        if (door != null) doorBlockWithRenderType(((DoorBlock) door.get()), modLoc("block/" + group + "_door_bottom"), modLoc("block/" + group + "_door_top"), "cutout");
        if (trapdoor != null) trapdoorBlockWithRenderType(((TrapDoorBlock) trapdoor.get()), modLoc("block/" + group + "_trapdoor"), true, "cutout");

        if (stairs != null) blockItem(stairs);
        if (slab != null) blockItem(slab);
        if (pressurePlate != null) blockItem(pressurePlate);
        if (fenceGate != null) blockItem(fenceGate);
        if (trapdoor != null) blockItem(trapdoor,"_bottom");
    }

    private void commonBlocksWithItem(DeferredBlock<Block> block, DeferredBlock<Block> rawBlock, DeferredBlock<Block> ore, DeferredBlock<Block> deepslateOre, DeferredBlock<Block> endOre, DeferredBlock<Block> netherOre, DeferredBlock<Block> magicBlock){
        if (block != null) blockWithItem(block);
        if (rawBlock != null) blockWithItem(rawBlock);
        if (ore != null) blockWithItem(ore);
        if (deepslateOre != null) blockWithItem(deepslateOre);
        if (endOre != null) blockWithItem(endOre);
        if (netherOre != null) blockWithItem(netherOre);
        if (magicBlock != null) blockWithItem(magicBlock);
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
