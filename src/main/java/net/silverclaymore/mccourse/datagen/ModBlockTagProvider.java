package net.silverclaymore.mccourse.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.silverclaymore.mccourse.MCCourseMod;
import net.silverclaymore.mccourse.block.ModBlocks;
import net.silverclaymore.mccourse.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, MCCourseMod.MOD_ID, existingFileHelper);
    }

    protected void addCommonTags(TagKey<Block> mineableWith, DeferredBlock<Block> block, DeferredBlock<Block> rawBlock, DeferredBlock<Block> ore, DeferredBlock<Block> deepslateOre, DeferredBlock<Block> endOre, DeferredBlock<Block> netherOre, DeferredBlock<Block> stairs, DeferredBlock<Block> slab, DeferredBlock<Block> pressurePlate, DeferredBlock<Block> button, DeferredBlock<Block> fence, DeferredBlock<Block> fenceGate, DeferredBlock<Block> wall) {
        addCommonTag(mineableWith, block);
        addCommonTag(mineableWith, rawBlock);
        addCommonTag(mineableWith, ore);
        addCommonTag(mineableWith, deepslateOre);
        addCommonTag(mineableWith, endOre);
        addCommonTag(mineableWith, netherOre);
        addCommonTag(mineableWith, stairs);
        addCommonTag(mineableWith, slab);
        addCommonTag(mineableWith, pressurePlate);
        addCommonTag(mineableWith, button);
        addCommonTag(mineableWith, fence);
        addCommonTag(mineableWith, fenceGate);
        addCommonTag(mineableWith, wall);

        if (fence != null) this.tag(BlockTags.FENCES).add(fence.get());
        if (fenceGate != null) tag(BlockTags.FENCE_GATES).add(fenceGate.get());
        if (wall != null) tag(BlockTags.WALLS).add(wall.get());
    }

    protected void addCommonWoodTags(TagKey<Block> mineableWith, DeferredBlock<Block> log, DeferredBlock<Block> planks, DeferredBlock<Block> wood, DeferredBlock<Block> strippedLog, DeferredBlock<Block> strippedWood, DeferredBlock<Block> stairs, DeferredBlock<Block> slab, DeferredBlock<Block> pressurePlate, DeferredBlock<Block> button, DeferredBlock<Block> fence, DeferredBlock<Block> fenceGate, DeferredBlock<Block> wall) {
        addCommonTag(mineableWith, log);
        addCommonTag(mineableWith, planks);
        addCommonTag(mineableWith, wood);
        addCommonTag(mineableWith, strippedLog);
        addCommonTag(mineableWith, strippedWood);
        addCommonTag(mineableWith, stairs);
        addCommonTag(mineableWith, slab);
        addCommonTag(mineableWith, pressurePlate);
        addCommonTag(mineableWith, button);

        if (fence != null) tag(BlockTags.FENCES).add(fence.get());
        if (fenceGate != null) tag(BlockTags.FENCE_GATES).add(fenceGate.get());
        if (wall != null) tag(BlockTags.WALLS).add(wall.get());
    }

    protected void addCommonTag(TagKey<Block> mineableWith, DeferredBlock<Block> block){
        if (block != null) this.tag(mineableWith).add(block.get());
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        tag(ModTags.Blocks.NEEDS_BLACK_OPAL_TOOL)
                .addTag(BlockTags.NEEDS_IRON_TOOL);

        tag(ModTags.Blocks.NEEDS_BISMUTH_TOOL)
                .addTag(BlockTags.NEEDS_IRON_TOOL);

        tag(ModTags.Blocks.INCORRECT_FOR_BLACK_OPAL_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_IRON_TOOL)
                .remove(ModTags.Blocks.NEEDS_BLACK_OPAL_TOOL);

        tag(ModTags.Blocks.INCORRECT_FOR_BISMUTH_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_IRON_TOOL)
                .remove(ModTags.Blocks.NEEDS_BISMUTH_TOOL);

        addCommonTags(BlockTags.MINEABLE_WITH_PICKAXE, ModBlocks.BLACK_OPAL_BLOCK, ModBlocks.RAW_BLACK_OPAL_BLOCK, ModBlocks.BLACK_OPAL_ORE, ModBlocks.BLACK_OPAL_DEEPSLATE_ORE, ModBlocks.BLACK_OPAL_END_ORE, ModBlocks.BLACK_OPAL_NETHER_ORE, ModBlocks.BLACK_OPAL_STAIRS, ModBlocks.BLACK_OPAL_SLAB, ModBlocks.BLACK_OPAL_PRESSURE_PLATE, ModBlocks.BLACK_OPAL_BUTTON, ModBlocks.BLACK_OPAL_FENCE, ModBlocks.BLACK_OPAL_FENCE_GATE, ModBlocks.BLACK_OPAL_WALL );
        addCommonTags(BlockTags.MINEABLE_WITH_PICKAXE, ModBlocks.BISMUTH_BLOCK, ModBlocks.RAW_BISMUTH_BLOCK, ModBlocks.BISMUTH_ORE, null, null, null, ModBlocks.BISMUTH_STAIRS, ModBlocks.BISMUTH_SLAB, ModBlocks.BISMUTH_PRESSURE_PLATE, ModBlocks.BISMUTH_BUTTON, null, null, null );
        addCommonWoodTags(BlockTags.MINEABLE_WITH_AXE, ModBlocks.EBONY_LOG, ModBlocks.EBONY_PLANKS, ModBlocks.EBONY_WOOD, ModBlocks.STRIPPED_EBONY_LOG, ModBlocks.STRIPPED_EBONY_WOOD, ModBlocks.EBONY_STAIRS, ModBlocks.EBONY_SLAB, ModBlocks.EBONY_PRESSURE_PLATE, ModBlocks.EBONY_BUTTON, null, null, null );

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.MAGIC_BLOCK.get())
        ;

        tag(BlockTags.PLANKS).add(ModBlocks.EBONY_PLANKS.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.BLACK_OPAL_ORE.get())
                .add(ModBlocks.BLACK_OPAL_DEEPSLATE_ORE.get())
                //.add(ModBlocks.BLACK_OPAL_STAIRS.get())
                .add(ModBlocks.BLACK_OPAL_SLAB.get())
                .add(ModBlocks.BISMUTH_SLAB.get())

                .add(ModBlocks.BISMUTH_ORE.get())
        ;

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.BLACK_OPAL_END_ORE.get())
                .add(ModBlocks.BLACK_OPAL_NETHER_ORE.get())
        ;

        this.tag(ModTags.Blocks.PAXEL_MINEABLE)
                .addTag(BlockTags.MINEABLE_WITH_PICKAXE)
                .addTag(BlockTags.MINEABLE_WITH_AXE)
                .addTag(BlockTags.MINEABLE_WITH_SHOVEL)
        ;

        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.EBONY_LOG.get())
                .add(ModBlocks.EBONY_WOOD.get())
                .add(ModBlocks.STRIPPED_EBONY_LOG.get())
                .add(ModBlocks.STRIPPED_EBONY_WOOD.get())
        ;
    }
}