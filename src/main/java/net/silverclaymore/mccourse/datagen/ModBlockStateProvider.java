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

import java.awt.*;
import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, MCCourseMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.BLACK_OPAL_BLOCK);
        blockWithItem(ModBlocks.RAW_BLACK_OPAL_BLOCK);

        blockWithItem(ModBlocks.BLACK_OPAL_ORE);
        blockWithItem(ModBlocks.BLACK_OPAL_DEEPSLATE_ORE);
        blockWithItem(ModBlocks.BLACK_OPAL_END_ORE);
        blockWithItem(ModBlocks.BLACK_OPAL_NETHER_ORE);

        blockWithItem(ModBlocks.MAGIC_BLOCK);

        stairsBlock(((StairBlock) ModBlocks.BLACK_OPAL_STAIRS.get()), blockTexture(ModBlocks.BLACK_OPAL_BLOCK.get()));
        slabBlock(((SlabBlock) ModBlocks.BLACK_OPAL_SLAB.get()), blockTexture(ModBlocks.BLACK_OPAL_BLOCK.get()), blockTexture(ModBlocks.BLACK_OPAL_BLOCK.get()));

        pressurePlateBlock(((PressurePlateBlock) ModBlocks.BLACK_OPAL_PRESSURE_PLATE.get()), blockTexture(ModBlocks.BLACK_OPAL_BLOCK.get()));
        buttonBlock(((ButtonBlock) ModBlocks.BLACK_OPAL_BUTTON.get()), blockTexture(ModBlocks.BLACK_OPAL_BLOCK.get()));

        fenceBlock(((FenceBlock) ModBlocks.BLACK_OPAL_FENCE.get()), blockTexture(ModBlocks.BLACK_OPAL_BLOCK.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.BLACK_OPAL_FENCE_GATE.get()), blockTexture(ModBlocks.BLACK_OPAL_BLOCK.get()));
        wallBlock(((WallBlock) ModBlocks.BLACK_OPAL_WALL.get()), blockTexture(ModBlocks.BLACK_OPAL_BLOCK.get()));

        doorBlockWithRenderType(((DoorBlock) ModBlocks.BLACK_OPAL_DOOR.get()), modLoc("block/black_opal_door_bottom"), modLoc("block/black_opal_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.BLACK_OPAL_TRAPDOOR.get()), modLoc("block/black_opal_trapdoor"), true, "cutout");
        
        blockItem(ModBlocks.BLACK_OPAL_STAIRS);
        blockItem(ModBlocks.BLACK_OPAL_SLAB);
        blockItem(ModBlocks.BLACK_OPAL_PRESSURE_PLATE);
        blockItem(ModBlocks.BLACK_OPAL_FENCE_GATE);

        blockItem(ModBlocks.BLACK_OPAL_TRAPDOOR, "_bottom");

        customLamp();

        makeCrop(((TomatoCropBlock) ModBlocks.TOMATO_CROP.get()), "tomato_crop_stage","tomato_crop_stage");

        simpleBlock(ModBlocks.PETUNIA.get(),
                models().cross(blockTexture(ModBlocks.PETUNIA.get()).getPath(), blockTexture(ModBlocks.PETUNIA.get())).renderType("cutout"));
        simpleBlock(ModBlocks.POTTED_PETUNIA.get(), models().singleTexture("potted_petunia", ResourceLocation.parse("flower_pot_cross"), "plant",
                blockTexture(ModBlocks.PETUNIA.get())).renderType("cutout"));

        leavesBlock(ModBlocks.COLORED_LEAVES);

        logBlock(((RotatedPillarBlock) ModBlocks.EBONY_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.EBONY_WOOD.get()), blockTexture(ModBlocks.EBONY_LOG.get()), blockTexture(ModBlocks.EBONY_LOG.get()));
        logBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_EBONY_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_EBONY_WOOD.get()), blockTexture(ModBlocks.STRIPPED_EBONY_LOG.get()), blockTexture(ModBlocks.STRIPPED_EBONY_LOG.get()));

        blockItem(ModBlocks.EBONY_LOG);
        blockItem(ModBlocks.EBONY_WOOD);
        blockItem(ModBlocks.STRIPPED_EBONY_LOG);
        blockItem(ModBlocks.STRIPPED_EBONY_WOOD);

        blockWithItem(ModBlocks.EBONY_PLANKS);

        leavesBlock(ModBlocks.EBONY_LEAVES);
        saplingBlock(ModBlocks.EBONY_SAPLING);

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


    private void blockWithItem(DeferredBlock<Block> deferredBlock){
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<Block> deferredBlock){
        //simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("mccourse:block/" + deferredBlock.getId().getPath()));
        blockItem(deferredBlock,"");
    }

    private void blockItem(DeferredBlock<Block> deferredBlock, String appendix){
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("mccourse:block/" + deferredBlock.getId().getPath() + appendix));
    }
}
