package net.silverclaymore.mccourse.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.silverclaymore.mccourse.MCCourseMod;
import net.silverclaymore.mccourse.block.ModBlocks;
import net.silverclaymore.mccourse.item.ModItems;
import net.silverclaymore.mccourse.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, MCCourseMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(ModItems.BLACK_OPAL.get())
                .add(Items.COAL)
                .add(Items.DANDELION)
                .add(Items.COMPASS);

        tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.EBONY_LOG.get().asItem())
                .add(ModBlocks.EBONY_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_EBONY_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_EBONY_WOOD.get().asItem());

        tag(ModTags.Items.EBONY_LOG_TAGS)
                .add(ModBlocks.EBONY_LOG.get().asItem());

        tag(ItemTags.SWORDS)
                .add(ModItems.BLACK_OPAL_SWORD.get())
                .add(ModItems.BISMUTH_SWORD.get());

        tag(ItemTags.PICKAXES)
                .add(ModItems.BLACK_OPAL_PICKAXE.get())
                .add(ModItems.BISMUTH_PICKAXE.get());

        tag(ItemTags.AXES)
                .add(ModItems.BLACK_OPAL_AXE.get())
                .add(ModItems.BISMUTH_AXE.get());

        tag(ItemTags.SHOVELS)
                .add(ModItems.BLACK_OPAL_SHOVEL.get())
                .add(ModItems.BISMUTH_SHOVEL.get());

        tag(ItemTags.HOES)
                .add(ModItems.BLACK_OPAL_HOE.get())
                .add(ModItems.BISMUTH_HOE.get());

        tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.BLACK_OPAL_HELMET.get())
                .add(ModItems.BLACK_OPAL_CHESTPLATE.get())
                .add(ModItems.BLACK_OPAL_LEGGINGS.get())
                .add(ModItems.BLACK_OPAL_BOOTS.get())
                .add(ModItems.BISMUTH_HELMET.get())
                .add(ModItems.BISMUTH_CHESTPLATE.get())
                .add(ModItems.BISMUTH_LEGGINGS.get())
                .add(ModItems.BISMUTH_BOOTS.get())
                .add(ModItems.ALEXANDRITE_HELMET.get())
                .add(ModItems.ALEXANDRITE_CHESTPLATE.get())
                .add(ModItems.ALEXANDRITE_LEGGINGS.get())
                .add(ModItems.ALEXANDRITE_BOOTS.get())
                .add(ModItems.PINK_GARNET_HELMET.get())
                .add(ModItems.PINK_GARNET_CHESTPLATE.get())
                .add(ModItems.PINK_GARNET_LEGGINGS.get())
                .add(ModItems.PINK_GARNET_BOOTS.get())
        ;

        tag(ItemTags.TRIM_MATERIALS)
                .add(ModItems.BLACK_OPAL.get());

        tag(ItemTags.TRIM_TEMPLATES)
                .add(ModItems.KAUPEN_SMITHING_TEMPLATE.get());
    }
}