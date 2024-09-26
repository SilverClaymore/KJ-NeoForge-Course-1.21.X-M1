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

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider provider) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), provider);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.BLACK_OPAL_BLOCK.get());
        dropSelf(ModBlocks.RAW_BLACK_OPAL_BLOCK.get());

        dropSelf(ModBlocks.BISMUTH_BLOCK.get());
        dropSelf(ModBlocks.RAW_BISMUTH_BLOCK.get());

        dropSelf(ModBlocks.ALEXANDRITE_BLOCK.get());
        dropSelf(ModBlocks.RAW_ALEXANDRITE_BLOCK.get());

        addOre(ModItems.RAW_BLACK_OPAL, ModBlocks.BLACK_OPAL_ORE, ModBlocks.BLACK_OPAL_DEEPSLATE_ORE, ModBlocks.BLACK_OPAL_END_ORE, ModBlocks.BLACK_OPAL_NETHER_ORE);
        addOre(ModItems.RAW_BISMUTH, ModBlocks.BISMUTH_ORE, null, null, null);
        addOre(ModItems.RAW_ALEXANDRITE, ModBlocks.ALEXANDRITE_ORE, ModBlocks.ALEXANDRITE_DEEPSLATE_ORE, null, null);

        LootItemCondition.Builder lootItemConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.TOMATO_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(TomatoCropBlock.AGE, 5));
        this.add(ModBlocks.TOMATO_CROP.get(), this.createCropDrops(ModBlocks.TOMATO_CROP.get(),
                ModItems.TOMATO.get(), ModItems.TOMATO_SEEDS.asItem(), lootItemConditionBuilder));

        this.dropSelf(ModBlocks.PETUNIA.get());
        this.add(ModBlocks.POTTED_PETUNIA.get(), createPotFlowerItemTable(ModBlocks.PETUNIA));

        dropSelf(ModBlocks.COLORED_LEAVES.get());
        dropSelf(ModBlocks.PEDESTAL.get());

        this.dropSelf(ModBlocks.EBONY_LOG.get());
        this.dropSelf(ModBlocks.EBONY_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_EBONY_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_EBONY_WOOD.get());

        this.dropSelf(ModBlocks.EBONY_PLANKS.get());
        this.dropSelf(ModBlocks.EBONY_SAPLING.get());

        this.add(ModBlocks.EBONY_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.EBONY_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        commonDrops(ModBlocks.BLACK_OPAL_STAIRS, ModBlocks.BLACK_OPAL_SLAB, ModBlocks.BLACK_OPAL_PRESSURE_PLATE, ModBlocks.BLACK_OPAL_BUTTON, ModBlocks.BLACK_OPAL_FENCE, ModBlocks.BLACK_OPAL_FENCE_GATE, ModBlocks.BLACK_OPAL_WALL, ModBlocks.BLACK_OPAL_TRAPDOOR, ModBlocks.BLACK_OPAL_DOOR, ModBlocks.BLACK_OPAL_LAMP);
        commonDrops(ModBlocks.BISMUTH_STAIRS, ModBlocks.BISMUTH_SLAB, ModBlocks.BISMUTH_PRESSURE_PLATE, ModBlocks.BISMUTH_BUTTON, ModBlocks.BISMUTH_FENCE, ModBlocks.BISMUTH_FENCE_GATE, ModBlocks.BISMUTH_WALL, ModBlocks.BISMUTH_TRAPDOOR, ModBlocks.BISMUTH_DOOR, null);
        commonDrops(ModBlocks.ALEXANDRITE_STAIRS, ModBlocks.ALEXANDRITE_SLAB, ModBlocks.ALEXANDRITE_PRESSURE_PLATE, ModBlocks.ALEXANDRITE_BUTTON, ModBlocks.ALEXANDRITE_FENCE, ModBlocks.ALEXANDRITE_FENCE_GATE, ModBlocks.ALEXANDRITE_WALL, ModBlocks.ALEXANDRITE_TRAPDOOR, ModBlocks.ALEXANDRITE_DOOR, null);

        commonDrops(ModBlocks.EBONY_STAIRS, ModBlocks.EBONY_SLAB, ModBlocks.EBONY_PRESSURE_PLATE, ModBlocks.EBONY_BUTTON, null, null, null, null, null, null);
    }

    protected void addOre (DeferredItem<Item> item, DeferredBlock<Block> ore, DeferredBlock<Block> deepslateOre, DeferredBlock<Block> endOre, DeferredBlock<Block> netherOre){
        this.add(ore.get(), block -> createOreDrop(ore.get(), item.get()));
        if (deepslateOre != null) this.add(deepslateOre.get(), block -> createMultipleOreDrops(deepslateOre.get(), item.get(), 2, 5));
        if (endOre != null)this.add(endOre.get(), block -> createMultipleOreDrops(endOre.get(), item.get(), 3, 7));
        if (netherOre != null)this.add(netherOre.get(), block -> createMultipleOreDrops(netherOre.get(), item.get(), 4, 9));
    }

    protected void commonDrops(DeferredBlock<Block> stairs, DeferredBlock<Block> slab, DeferredBlock<Block> pressurePlate, DeferredBlock<Block> button, DeferredBlock<Block> fence, DeferredBlock<Block> fenceGate, DeferredBlock<Block> wall, DeferredBlock<Block> trapdoor, DeferredBlock<Block> door, DeferredBlock<Block> lamp){
        if (stairs != null) dropSelf(stairs.get());

        if (slab != null) this.add(slab.get(),
                block -> createSlabItemTable(slab.get()));

        if (pressurePlate != null) dropSelf(pressurePlate.get());
        if (button != null) dropSelf(button.get());

        if (fence != null) dropSelf(fence.get());
        if (fenceGate != null) dropSelf(fenceGate.get());
        if (wall != null) dropSelf(wall.get());

        if (trapdoor != null) dropSelf(trapdoor.get());
        if (door != null) this.add(door.get(),
                block -> createDoorTable(door.get()));

        if (lamp != null) dropSelf(lamp.get());
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
}