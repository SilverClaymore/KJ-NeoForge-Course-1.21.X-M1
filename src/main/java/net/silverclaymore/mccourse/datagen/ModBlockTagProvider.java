package net.silverclaymore.mccourse.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.WallBlock;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.silverclaymore.mccourse.MCCourseMod;
import net.silverclaymore.mccourse.block.ModBlocks;
import net.silverclaymore.mccourse.util.ModTags;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, MCCourseMod.MOD_ID, existingFileHelper);
    }

    protected void addCommonMineableTags() {
        BLOCK_GROUPS.forEach((tag, blocks) ->
                blocks.forEach(block -> {
                    addCommonTag(tag, block);

                    if (block.get() instanceof FenceBlock)
                        this.tag(BlockTags.FENCES).add(block.get());

                    if (block.get() instanceof FenceGateBlock)
                        this.tag(BlockTags.FENCE_GATES).add(block.get());

                    if (block.get() instanceof WallBlock)
                        this.tag(BlockTags.WALLS).add(block.get());
                })
        );
    }

    protected void addCommonTag(TagKey<Block> mineableWith, DeferredBlock<Block> block){
        if (block != null) this.tag(mineableWith).add(block.get());
    }

    private static final Map<TagKey<Block>, List<DeferredBlock<Block>>> BLOCK_GROUPS = Map.of(
            BlockTags.MINEABLE_WITH_PICKAXE, List.of(
                    // Black Opal
                      ModBlocks.BLACK_OPAL_BLOCK, ModBlocks.RAW_BLACK_OPAL_BLOCK, ModBlocks.BLACK_OPAL_ORE, ModBlocks.BLACK_OPAL_DEEPSLATE_ORE, ModBlocks.BLACK_OPAL_END_ORE, ModBlocks.BLACK_OPAL_NETHER_ORE
                    , ModBlocks.BLACK_OPAL_STAIRS, ModBlocks.BLACK_OPAL_SLAB, ModBlocks.BLACK_OPAL_PRESSURE_PLATE, ModBlocks.BLACK_OPAL_BUTTON
                    , ModBlocks.BLACK_OPAL_FENCE, ModBlocks.BLACK_OPAL_FENCE_GATE, ModBlocks.BLACK_OPAL_WALL, ModBlocks.BLACK_OPAL_DOOR, ModBlocks.BLACK_OPAL_TRAPDOOR
                    , ModBlocks.MAGIC_BLOCK, ModBlocks.BLACK_OPAL_64_BLOCK, ModBlocks.BLACK_OPAL_64_BRICK_BLOCK, ModBlocks.BLACK_OPAL_64_PILLAR_BLOCK, ModBlocks.BLACK_OPAL_64_STONE_BRICK_BLOCK
                    // Bismuth
                    , ModBlocks.BISMUTH_BLOCK, ModBlocks.RAW_BISMUTH_BLOCK, ModBlocks.BISMUTH_ORE
                    , ModBlocks.BISMUTH_STAIRS, ModBlocks.BISMUTH_SLAB, ModBlocks.BISMUTH_PRESSURE_PLATE, ModBlocks.BISMUTH_BUTTON
                    , ModBlocks.BISMUTH_FENCE, ModBlocks.BISMUTH_FENCE_GATE, ModBlocks.BISMUTH_WALL, ModBlocks.BISMUTH_DOOR, ModBlocks.BISMUTH_TRAPDOOR
                    // Alexandrite
                    , ModBlocks.ALEXANDRITE_BLOCK, ModBlocks.RAW_ALEXANDRITE_BLOCK, ModBlocks.ALEXANDRITE_ORE, ModBlocks.ALEXANDRITE_DEEPSLATE_ORE
                    , ModBlocks.ALEXANDRITE_STAIRS, ModBlocks.ALEXANDRITE_SLAB, ModBlocks.ALEXANDRITE_PRESSURE_PLATE, ModBlocks.ALEXANDRITE_BUTTON
                    , ModBlocks.ALEXANDRITE_FENCE, ModBlocks.ALEXANDRITE_FENCE_GATE, ModBlocks.ALEXANDRITE_WALL, ModBlocks.ALEXANDRITE_DOOR, ModBlocks.ALEXANDRITE_TRAPDOOR
                    // Pink Garnet
                    , ModBlocks.PINK_GARNET_BLOCK, ModBlocks.RAW_PINK_GARNET_BLOCK, ModBlocks.PINK_GARNET_ORE, ModBlocks.PINK_GARNET_DEEPSLATE_ORE, ModBlocks.PINK_GARNET_END_ORE, ModBlocks.PINK_GARNET_NETHER_ORE
            ),
            BlockTags.MINEABLE_WITH_AXE, List.of(
                    // Ebony Wood
                      ModBlocks.EBONY_LOG, ModBlocks.EBONY_PLANKS, ModBlocks.EBONY_WOOD, ModBlocks.STRIPPED_EBONY_LOG, ModBlocks.STRIPPED_EBONY_WOOD
                    , ModBlocks.EBONY_STAIRS, ModBlocks.EBONY_SLAB, ModBlocks.EBONY_PRESSURE_PLATE, ModBlocks.EBONY_BUTTON
                    , ModBlocks.EBONY_FENCE, ModBlocks.EBONY_FENCE_GATE, ModBlocks.EBONY_WALL
                    // Walnut Wood
                    , ModBlocks.WALNUT_LOG, ModBlocks.WALNUT_PLANKS, ModBlocks.WALNUT_WOOD, ModBlocks.STRIPPED_WALNUT_LOG, ModBlocks.STRIPPED_WALNUT_WOOD
                    // Bloodwood
                    , ModBlocks.BLOODWOOD_LOG, ModBlocks.BLOODWOOD_PLANKS, ModBlocks.BLOODWOOD_WOOD, ModBlocks.STRIPPED_BLOODWOOD_LOG, ModBlocks.STRIPPED_BLOODWOOD_WOOD
            )
    );


    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {

        tag(ModTags.Blocks.NEEDS_BLACK_OPAL_TOOL)
                .addTag(BlockTags.NEEDS_IRON_TOOL);

        tag(ModTags.Blocks.NEEDS_BISMUTH_TOOL)
                .addTag(BlockTags.NEEDS_IRON_TOOL);

        tag(ModTags.Blocks.NEEDS_ALEXANDRITE_TOOL)
                .addTag(BlockTags.NEEDS_IRON_TOOL);

        tag(ModTags.Blocks.INCORRECT_FOR_BLACK_OPAL_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_IRON_TOOL)
                .remove(ModTags.Blocks.NEEDS_BLACK_OPAL_TOOL).remove(ModTags.Blocks.NEEDS_BISMUTH_TOOL).remove(ModTags.Blocks.NEEDS_ALEXANDRITE_TOOL);

        tag(ModTags.Blocks.INCORRECT_FOR_BISMUTH_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_IRON_TOOL)
                .remove(ModTags.Blocks.NEEDS_BLACK_OPAL_TOOL).remove(ModTags.Blocks.NEEDS_BISMUTH_TOOL).remove(ModTags.Blocks.NEEDS_ALEXANDRITE_TOOL);

        tag(ModTags.Blocks.INCORRECT_FOR_ALEXANDRITE_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_IRON_TOOL)
                .remove(ModTags.Blocks.NEEDS_BLACK_OPAL_TOOL).remove(ModTags.Blocks.NEEDS_BISMUTH_TOOL).remove(ModTags.Blocks.NEEDS_ALEXANDRITE_TOOL);

        addCommonMineableTags();

        tag(BlockTags.PLANKS).add(ModBlocks.EBONY_PLANKS.get());
        tag(BlockTags.PLANKS).add(ModBlocks.WALNUT_PLANKS.get());
        tag(BlockTags.PLANKS).add(ModBlocks.BLOODWOOD_PLANKS.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.BLACK_OPAL_ORE.get())
                .add(ModBlocks.BISMUTH_ORE.get())
                .add(ModBlocks.ALEXANDRITE_ORE.get())
                .add(ModBlocks.PINK_GARNET_ORE.get())
                .add(ModBlocks.BLACK_OPAL_DEEPSLATE_ORE.get())
                .add(ModBlocks.ALEXANDRITE_DEEPSLATE_ORE.get())
                .add(ModBlocks.PINK_GARNET_DEEPSLATE_ORE.get())
                .add(ModBlocks.BISMUTH_DEEPSLATE_ORE.get())

                //.add(ModBlocks.BLACK_OPAL_STAIRS.get())
                .add(ModBlocks.BLACK_OPAL_SLAB.get())
                .add(ModBlocks.BISMUTH_SLAB.get())
        ;

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.BLACK_OPAL_END_ORE.get())
                .add(ModBlocks.BLACK_OPAL_NETHER_ORE.get())
                .add(ModBlocks.PINK_GARNET_END_ORE.get())
                .add(ModBlocks.PINK_GARNET_NETHER_ORE.get())
                .add(ModBlocks.BISMUTH_END_ORE.get())
                .add(ModBlocks.BISMUTH_NETHER_ORE.get())
        ;

        this.tag(ModTags.Blocks.PAXEL_MINEABLE)
                .addTag(BlockTags.MINEABLE_WITH_PICKAXE)
                .addTag(BlockTags.MINEABLE_WITH_AXE)
                .addTag(BlockTags.MINEABLE_WITH_SHOVEL)
        ;

        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.EBONY_LOG.get()).add(ModBlocks.EBONY_WOOD.get())
                .add(ModBlocks.STRIPPED_EBONY_LOG.get()).add(ModBlocks.STRIPPED_EBONY_WOOD.get())
                .add(ModBlocks.WALNUT_LOG.get()).add(ModBlocks.WALNUT_WOOD.get())
                .add(ModBlocks.STRIPPED_WALNUT_LOG.get()).add(ModBlocks.STRIPPED_WALNUT_WOOD.get())
                .add(ModBlocks.BLOODWOOD_LOG.get()).add(ModBlocks.BLOODWOOD_WOOD.get())
                .add(ModBlocks.STRIPPED_BLOODWOOD_LOG.get()).add(ModBlocks.STRIPPED_BLOODWOOD_WOOD.get())
        ;
    }
}