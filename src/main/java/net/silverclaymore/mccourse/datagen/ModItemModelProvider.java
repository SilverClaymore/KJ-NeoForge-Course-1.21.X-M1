package net.silverclaymore.mccourse.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.silverclaymore.mccourse.MCCourseMod;
import net.silverclaymore.mccourse.block.ModBlocks;
import net.silverclaymore.mccourse.fluid.ModFluids;
import net.silverclaymore.mccourse.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MCCourseMod.MOD_ID, existingFileHelper);
    }

    protected void commonItems(DeferredItem<Item> ore, DeferredItem<Item> rawOre, DeferredBlock<Block> baseBlock, DeferredBlock<Block> button, DeferredBlock<Block> fence, DeferredBlock<Block> wall, DeferredBlock<Block> door, DeferredItem<Item> sword, DeferredItem<Item> axe, DeferredItem<Item> pickaxe, DeferredItem<Item> shovel, DeferredItem<Item> hoe, DeferredItem<Item> paxel, DeferredItem<Item> hammer, DeferredItem<Item> helmet, DeferredItem<Item> chestplate, DeferredItem<Item> leggings, DeferredItem<Item> boots){
        if (ore != null) basicItem(ore.get());
        if (rawOre != null) basicItem(rawOre.get());

        if (button != null) buttonItem(button, baseBlock);
        if (fence != null) fenceItem(fence, baseBlock);
        if (wall != null) wallItem(wall, baseBlock);

        if (door != null) basicItem(door.asItem());

        if (sword != null) handheldItem(sword);
        if (pickaxe != null) handheldItem(pickaxe);
        if (axe != null) handheldItem(axe);
        if (shovel != null) handheldItem(shovel);
        if (hoe != null) handheldItem(hoe);
        if (paxel != null) handheldItem(paxel);
        if (hammer != null) handheldItem(hammer);

        if (helmet != null) basicItem(helmet.get());
        if (chestplate != null) basicItem(chestplate.get());
        if (leggings != null) basicItem(leggings.get());
        if (boots != null) basicItem(boots.get());
    }

    @Override
    protected void registerModels() {

        commonItems(ModItems.BLACK_OPAL, ModItems.RAW_BLACK_OPAL, ModBlocks.BLACK_OPAL_BLOCK, ModBlocks.BLACK_OPAL_BUTTON, ModBlocks.BLACK_OPAL_FENCE, ModBlocks.BLACK_OPAL_WALL, ModBlocks.BLACK_OPAL_DOOR, ModItems.BLACK_OPAL_SWORD, ModItems.BLACK_OPAL_AXE, ModItems.BLACK_OPAL_PICKAXE, ModItems.BLACK_OPAL_SHOVEL, ModItems.BLACK_OPAL_HOE, ModItems.BLACK_OPAL_PAXEL, ModItems.BLACK_OPAL_HAMMER, ModItems.BLACK_OPAL_HELMET, ModItems.BLACK_OPAL_CHESTPLATE, ModItems.BLACK_OPAL_LEGGINGS, ModItems.BLACK_OPAL_BOOTS);
        commonItems(ModItems.BISMUTH, ModItems.RAW_BISMUTH, ModBlocks.BISMUTH_BLOCK, ModBlocks.BISMUTH_BUTTON, ModBlocks.BISMUTH_FENCE, ModBlocks.BISMUTH_WALL, ModBlocks.BISMUTH_DOOR, ModItems.BISMUTH_SWORD, ModItems.BISMUTH_AXE, ModItems.BISMUTH_PICKAXE, ModItems.BISMUTH_SHOVEL, ModItems.BISMUTH_HOE, null, null, null, null, null, null);
        commonItems(ModItems.ALEXANDRITE, ModItems.RAW_ALEXANDRITE, ModBlocks.ALEXANDRITE_BLOCK, ModBlocks.ALEXANDRITE_BUTTON, ModBlocks.ALEXANDRITE_FENCE, ModBlocks.ALEXANDRITE_WALL, ModBlocks.ALEXANDRITE_DOOR, null, null, null, null, null, null, null, null, null, null, null);
        commonItems(null, null, ModBlocks.EBONY_PLANKS, ModBlocks.EBONY_BUTTON, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

        basicItem(ModItems.CHAINSAW.get());

        basicItem(ModItems.TOMATO.get());
        basicItem(ModItems.TOMATO_SEEDS.get());
        flowerItem(ModBlocks.PETUNIA);

        basicItem(ModItems.FROSTFIRE_ICE.get());

        basicItem(ModItems.METAL_DETECTOR.get());
        //basicItem(ModItems.DATA_TABLET.get());

        handheldItem(ModItems.BLACK_OPAL_SWORD_LEVITATION);

        basicItem(ModItems.BAR_BRAWL_MUSIC_DISC.get());
        basicItem(ModFluids.BLACK_OPAL_WATER_BUCKET.get());

        saplingItem(ModBlocks.EBONY_SAPLING);

        withExistingParent(ModItems.PENGUIN_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
    }

    public void flowerItem(DeferredBlock<Block> block) {
        this.withExistingParent(block.getId().getPath(), mcLoc("item/generated"))
                .texture("layer0",  ResourceLocation.fromNamespaceAndPath(MCCourseMod.MOD_ID,
                        "block/" + block.getId().getPath()));
    }

    private ItemModelBuilder saplingItem(DeferredBlock<Block> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(MCCourseMod.MOD_ID, "block/" + item.getId().getPath()));
    }

    public void buttonItem(DeferredBlock<Block> block, DeferredBlock<Block> baseBlock){
        this.baseItem(block, baseBlock, "button", "texture");
    }

    public void fenceItem(DeferredBlock<Block> block, DeferredBlock<Block> baseBlock){
        this.baseItem(block, baseBlock, "fence", "texture");
    }

    public void wallItem(DeferredBlock<Block> block, DeferredBlock<Block> baseBlock){
        this.baseItem(block, baseBlock, "wall", "wall");
    }

    private void baseItem(DeferredBlock<Block> block, DeferredBlock<Block> baseBlock, String name, String key){
        this.withExistingParent(block.getId().getPath(), mcLoc("block/"+ name +"_inventory"))
                .texture(key, ResourceLocation.fromNamespaceAndPath(MCCourseMod.MOD_ID, "block/" + baseBlock.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(DeferredItem<Item> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(MCCourseMod.MOD_ID,"item/" + item.getId().getPath()));
    }
}