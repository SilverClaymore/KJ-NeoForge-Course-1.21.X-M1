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

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider provider) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), provider);
    }

    @Override
    protected void generate() {
        addOre(ModItems.RAW_BLACK_OPAL, ModBlocks.BLACK_OPAL_ORE, ModBlocks.BLACK_OPAL_DEEPSLATE_ORE, ModBlocks.BLACK_OPAL_END_ORE, ModBlocks.BLACK_OPAL_NETHER_ORE);
        addOre(ModItems.RAW_BISMUTH, ModBlocks.BISMUTH_ORE, null, null, null);
        addOre(ModItems.RAW_ALEXANDRITE, ModBlocks.ALEXANDRITE_ORE, ModBlocks.ALEXANDRITE_DEEPSLATE_ORE, null, null);
        //addOre(ModItems.RAW_PINK_GARNET, null, null, null, null);

        LootItemCondition.Builder lootItemConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.TOMATO_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(TomatoCropBlock.AGE, 5));
        this.add(ModBlocks.TOMATO_CROP.get(), this.createCropDrops(ModBlocks.TOMATO_CROP.get(),
                ModItems.TOMATO.get(), ModItems.TOMATO_SEEDS.asItem(), lootItemConditionBuilder));

        this.dropSelf(ModBlocks.PETUNIA.get());
        this.add(ModBlocks.POTTED_PETUNIA.get(), createPotFlowerItemTable(ModBlocks.PETUNIA));

        dropSelf(ModBlocks.COLORED_LEAVES.get());
        dropSelf(ModBlocks.PEDESTAL.get());

        commonDrops(ModBlocks.BLACK_OPAL_BLOCK, ModBlocks.RAW_BLACK_OPAL_BLOCK, ModBlocks.BLACK_OPAL_STAIRS, ModBlocks.BLACK_OPAL_SLAB, ModBlocks.BLACK_OPAL_PRESSURE_PLATE, ModBlocks.BLACK_OPAL_BUTTON, ModBlocks.BLACK_OPAL_FENCE, ModBlocks.BLACK_OPAL_FENCE_GATE, ModBlocks.BLACK_OPAL_WALL, ModBlocks.BLACK_OPAL_TRAPDOOR, ModBlocks.BLACK_OPAL_DOOR, ModBlocks.BLACK_OPAL_LAMP);
        commonDrops(ModBlocks.BISMUTH_BLOCK, ModBlocks.RAW_BISMUTH_BLOCK, ModBlocks.BISMUTH_STAIRS, ModBlocks.BISMUTH_SLAB, ModBlocks.BISMUTH_PRESSURE_PLATE, ModBlocks.BISMUTH_BUTTON, ModBlocks.BISMUTH_FENCE, ModBlocks.BISMUTH_FENCE_GATE, ModBlocks.BISMUTH_WALL, ModBlocks.BISMUTH_TRAPDOOR, ModBlocks.BISMUTH_DOOR, null);
        commonDrops(ModBlocks.ALEXANDRITE_BLOCK, ModBlocks.RAW_ALEXANDRITE_BLOCK, ModBlocks.ALEXANDRITE_STAIRS, ModBlocks.ALEXANDRITE_SLAB, ModBlocks.ALEXANDRITE_PRESSURE_PLATE, ModBlocks.ALEXANDRITE_BUTTON, ModBlocks.ALEXANDRITE_FENCE, ModBlocks.ALEXANDRITE_FENCE_GATE, ModBlocks.ALEXANDRITE_WALL, ModBlocks.ALEXANDRITE_TRAPDOOR, ModBlocks.ALEXANDRITE_DOOR, null);
        commonDrops(ModBlocks.PINK_GARNET_BLOCK, ModBlocks.RAW_PINK_GARNET_BLOCK, null, null, null, null, null, null, null, null, null, null);
        commonWoodDrops(ModBlocks.EBONY_LOG, ModBlocks.EBONY_WOOD, ModBlocks.STRIPPED_EBONY_LOG, ModBlocks.STRIPPED_EBONY_WOOD, ModBlocks.EBONY_PLANKS, ModBlocks.EBONY_SAPLING, ModBlocks.EBONY_LEAVES);
        commonDrops(null, null, ModBlocks.EBONY_STAIRS, ModBlocks.EBONY_SLAB, ModBlocks.EBONY_PRESSURE_PLATE, ModBlocks.EBONY_BUTTON, ModBlocks.EBONY_FENCE, ModBlocks.EBONY_FENCE_GATE, ModBlocks.EBONY_WALL, null, null, null);
    }

    protected void addOre (DeferredItem<Item> item, DeferredBlock<Block> ore, DeferredBlock<Block> deepslateOre, DeferredBlock<Block> endOre, DeferredBlock<Block> netherOre){
        this.add(ore.get(), block -> createOreDrop(ore.get(), item.get()));
        if (deepslateOre != null) this.add(deepslateOre.get(), block -> createMultipleOreDrops(deepslateOre.get(), item.get(), 2, 5));
        if (endOre != null)this.add(endOre.get(), block -> createMultipleOreDrops(endOre.get(), item.get(), 3, 7));
        if (netherOre != null)this.add(netherOre.get(), block -> createMultipleOreDrops(netherOre.get(), item.get(), 4, 9));
    }

    protected void commonDrops(DeferredBlock<Block> block, DeferredBlock<Block> rawBlock, DeferredBlock<Block> stairs, DeferredBlock<Block> slab, DeferredBlock<Block> pressurePlate, DeferredBlock<Block> button, DeferredBlock<Block> fence, DeferredBlock<Block> fenceGate, DeferredBlock<Block> wall, DeferredBlock<Block> trapdoor, DeferredBlock<Block> door, DeferredBlock<Block> lamp){
        dropSelf(block);
        dropSelf(rawBlock);

        dropSelf(stairs);

        if (slab != null) this.add(slab.get(),
                fBlock -> createSlabItemTable(slab.get()));

        dropSelf(pressurePlate);
        dropSelf(button);

        dropSelf(fence);
        dropSelf(fenceGate);
        dropSelf(wall);

        dropSelf(trapdoor);
        if (door != null) this.add(door.get(),
                fBlock -> createDoorTable(door.get()));

        dropSelf(lamp);
    }

    protected void commonWoodDrops(DeferredBlock<Block> log, DeferredBlock<Block> wood, DeferredBlock<Block> strippedLog, DeferredBlock<Block> strippedWood, DeferredBlock<Block> planks, DeferredBlock<Block> sapling, DeferredBlock<Block> leaves){
        this.dropSelf(log.get());
        this.dropSelf(wood.get());
        this.dropSelf(strippedLog.get());
        this.dropSelf(strippedWood.get());

        this.dropSelf(planks.get());
        this.dropSelf(sapling.get());

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