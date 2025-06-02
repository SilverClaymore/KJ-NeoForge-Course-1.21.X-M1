package net.silverclaymore.mccourse.datagen;

import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.silverclaymore.mccourse.block.ModBlocks;
import net.silverclaymore.mccourse.block.custom.TomatoCropBlock;
import net.silverclaymore.mccourse.item.ModItems;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider provider) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), provider);
    }

    private static final Map<String, DeferredBlock<?>[]> DROPSELF_BLOCK_GROUPS = Map.of(
            "bismuth", new DeferredBlock<?>[]{
                      ModBlocks.BISMUTH_BLOCK, ModBlocks.RAW_BISMUTH_BLOCK, ModBlocks.BISMUTH_BRICK_BLOCK
                    , ModBlocks.BISMUTH_STAIRS, ModBlocks.BISMUTH_PRESSURE_PLATE, ModBlocks.BISMUTH_BUTTON
                    , ModBlocks.BISMUTH_FENCE, ModBlocks.BISMUTH_FENCE_GATE, ModBlocks.BISMUTH_WALL, ModBlocks.BISMUTH_TRAPDOOR
                    , ModBlocks.BLOODWOOD_LOG, ModBlocks.BLOODWOOD_WOOD, ModBlocks.STRIPPED_BLOODWOOD_LOG, ModBlocks.STRIPPED_BLOODWOOD_WOOD
                    , ModBlocks.BLOODWOOD_PLANKS, ModBlocks.BLOODWOOD_SAPLING
            },
            "black_opal", new DeferredBlock<?>[]{
                      ModBlocks.BLACK_OPAL_BLOCK, ModBlocks.RAW_BLACK_OPAL_BLOCK, ModBlocks.BLACK_OPAL_BRICK_BLOCK
                    , ModBlocks.BLACK_OPAL_STAIRS, ModBlocks.BLACK_OPAL_PRESSURE_PLATE, ModBlocks.BLACK_OPAL_BUTTON
                    , ModBlocks.BLACK_OPAL_FENCE, ModBlocks.BLACK_OPAL_FENCE_GATE, ModBlocks.BLACK_OPAL_WALL, ModBlocks.BLACK_OPAL_TRAPDOOR
                    , ModBlocks.BLACK_OPAL_LAMP, ModBlocks.PETUNIA, ModBlocks.COLORED_LEAVES, ModBlocks.PEDESTAL
                    , ModBlocks.EBONY_STAIRS, ModBlocks.EBONY_PRESSURE_PLATE, ModBlocks.EBONY_BUTTON
                    , ModBlocks.EBONY_FENCE, ModBlocks.EBONY_FENCE_GATE, ModBlocks.EBONY_WALL
                    , ModBlocks.EBONY_LOG, ModBlocks.EBONY_WOOD, ModBlocks.STRIPPED_EBONY_LOG, ModBlocks.STRIPPED_EBONY_WOOD
                    , ModBlocks.EBONY_PLANKS, ModBlocks.EBONY_SAPLING
            },
            "pink_garnet", new DeferredBlock<?>[]{
                    ModBlocks.PINK_GARNET_BLOCK, ModBlocks.RAW_PINK_GARNET_BLOCK, ModBlocks.PINK_GARNET_BRICK_BLOCK
                    //ModBlocks.PINK_GARNET_SLAB, ModBlocks.PINK_GARNET_STAIRS, ModBlocks.PINK_GARNET_PRESSURE_PLATE,
                    //ModBlocks.PINK_GARNET_BUTTON, ModBlocks.PINK_GARNET_FENCE, ModBlocks.PINK_GARNET_FENCE_GATE,
                    //ModBlocks.PINK_GARNET_WALL, ModBlocks.PINK_GARNET_DOOR, ModBlocks.PINK_GARNET_TRAPDOOR
            },
            "alexandrite", new DeferredBlock<?>[]{
                      ModBlocks.ALEXANDRITE_BLOCK, ModBlocks.RAW_ALEXANDRITE_BLOCK, ModBlocks.ALEXANDRITE_BRICK_BLOCK
                    , ModBlocks.ALEXANDRITE_STAIRS, ModBlocks.ALEXANDRITE_PRESSURE_PLATE, ModBlocks.ALEXANDRITE_BUTTON
                    , ModBlocks.ALEXANDRITE_FENCE, ModBlocks.ALEXANDRITE_FENCE_GATE, ModBlocks.ALEXANDRITE_WALL, ModBlocks.ALEXANDRITE_TRAPDOOR
                    , ModBlocks.WALNUT_LOG, ModBlocks.WALNUT_WOOD, ModBlocks.STRIPPED_WALNUT_LOG, ModBlocks.STRIPPED_WALNUT_WOOD
                    , ModBlocks.WALNUT_PLANKS, ModBlocks.WALNUT_SAPLING
            }
    );

    private static final Map<DeferredItem<Item>, DeferredBlock<?>[]> ORE_BLOCKS = Map.of(
            ModItems.RAW_BLACK_OPAL, new DeferredBlock<?>[]{ModBlocks.BLACK_OPAL_ORE, ModBlocks.BLACK_OPAL_DEEPSLATE_ORE, ModBlocks.BLACK_OPAL_END_ORE, ModBlocks.BLACK_OPAL_NETHER_ORE},
            ModItems.RAW_BISMUTH, new DeferredBlock<?>[]{ModBlocks.BISMUTH_ORE, ModBlocks.BISMUTH_DEEPSLATE_ORE, ModBlocks.BISMUTH_END_ORE, ModBlocks.BISMUTH_NETHER_ORE},
            ModItems.RAW_ALEXANDRITE, new DeferredBlock<?>[]{ModBlocks.ALEXANDRITE_ORE, ModBlocks.ALEXANDRITE_DEEPSLATE_ORE},
            ModItems.RAW_PINK_GARNET, new DeferredBlock<?>[]{ModBlocks.PINK_GARNET_ORE, ModBlocks.PINK_GARNET_DEEPSLATE_ORE, ModBlocks.PINK_GARNET_END_ORE, ModBlocks.PINK_GARNET_NETHER_ORE}
    );

    private static final Map<Integer, int[]> ORE_DROP_RANGES = Map.of(
            0, new int[]{1, 1},  // Standard ore drop
            1, new int[]{2, 5},  // Deepslate
            2, new int[]{3, 7},  // End
            3, new int[]{4, 9}   // Nether
    );

    @Override
    protected void generate() {
        addOreDrops(); // Ores defined in ORE_BLOCKS

        LootItemCondition.Builder lootItemConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.TOMATO_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(TomatoCropBlock.AGE, 5));
        this.add(ModBlocks.TOMATO_CROP.get(), this.createCropDrops(ModBlocks.TOMATO_CROP.get(),
                ModItems.TOMATO.get(), ModItems.TOMATO_SEEDS.asItem(), lootItemConditionBuilder));

        commonDropSelf();

        this.add(ModBlocks.POTTED_PETUNIA.get(), createPotFlowerItemTable(ModBlocks.PETUNIA));

        commonDrops(ModBlocks.BLACK_OPAL_SLAB, ModBlocks.BLACK_OPAL_DOOR);
        commonDrops(ModBlocks.BISMUTH_SLAB, ModBlocks.BISMUTH_DOOR);
        commonDrops(ModBlocks.ALEXANDRITE_SLAB, ModBlocks.ALEXANDRITE_DOOR);

        commonWoodDrops(ModBlocks.EBONY_SAPLING, ModBlocks.EBONY_LEAVES);
        commonWoodDrops(ModBlocks.WALNUT_SAPLING, ModBlocks.WALNUT_LEAVES);
        commonWoodDrops(ModBlocks.BLOODWOOD_SAPLING, ModBlocks.BLOODWOOD_LEAVES);
        commonDrops(ModBlocks.EBONY_SLAB, null);
        //commonDrops(ModBlocks.WALNUT_SLAB, null);
    }

    protected void addOreDrops() {
        ORE_BLOCKS.forEach((item, ores) -> {
            for (int i = 0; i < ores.length; i++) {
                if (ores[i] != null) {
                    final DeferredBlock<?> oreBlock = ores[i];
                    final boolean isPrimaryOre = (i == 0); // First element is the standard ore

                    int[] dropValues = ORE_DROP_RANGES.getOrDefault(i, new int[]{1, 1});
                    final int minDropAmount = dropValues[0];
                    final int maxDropAmount = dropValues[1];

                    this.add(oreBlock.get(), block ->
                            isPrimaryOre
                                    ? createOreDrop(oreBlock.get(), item.get())
                                    : createMultipleOreDrops(oreBlock.get(), item.get(), minDropAmount, maxDropAmount)
                    );
                }
            }
        });
    }

    protected void commonDropSelf() {
        DROPSELF_BLOCK_GROUPS.forEach((groupName, blocks) -> {
            for (DeferredBlock<?> block : blocks) {
                this.dropSelf(block.get()); // Standard drops-self function
            }
        });
    }

    protected void commonDrops(DeferredBlock<Block> slab, DeferredBlock<Block> door){
        if (slab != null) this.add(slab.get(), this::createSlabItemTable);
        if (door != null) this.add(door.get(), this::createDoorTable);
    }

    protected void commonWoodDrops(DeferredBlock<Block> sapling, DeferredBlock<Block> leaves){
        this.add(leaves.get(), block ->
                createLeavesDrops(block, sapling.get(), NORMAL_LEAVES_SAPLING_CHANCES));
    }

    protected LootTable.Builder createMultipleOreDrops(Block block, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(block, this.applyExplosionDecay(
                block, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }

    protected void dropSelf(@Nullable DeferredBlock<Block> block) {
        if (block != null) this.dropOther(block.get(), block.get());
    }
}