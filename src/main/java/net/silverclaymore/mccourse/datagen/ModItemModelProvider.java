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

    @Override
    protected void registerModels() {
        basicItem(ModItems.BLACK_OPAL.get());
        basicItem(ModItems.RAW_BLACK_OPAL.get());
        basicItem(ModItems.CHAINSAW.get());

        basicItem(ModItems.TOMATO.get());
        basicItem(ModItems.TOMATO_SEEDS.get());
        flowerItem(ModBlocks.PETUNIA);

        basicItem(ModItems.FROSTFIRE_ICE.get());

        buttonItem(ModBlocks.BLACK_OPAL_BUTTON, ModBlocks.BLACK_OPAL_BLOCK);
        buttonItem(ModBlocks.EBONY_BUTTON, ModBlocks.EBONY_PLANKS);

        fenceItem(ModBlocks.BLACK_OPAL_FENCE, ModBlocks.BLACK_OPAL_BLOCK);
        wallItem(ModBlocks.BLACK_OPAL_WALL, ModBlocks.BLACK_OPAL_BLOCK);

        basicItem(ModBlocks.BLACK_OPAL_DOOR.asItem());

        basicItem(ModItems.METAL_DETECTOR.get());
        //basicItem(ModItems.DATA_TABLET.get());

        handheldItem(ModItems.BLACK_OPAL_SWORD);
        handheldItem(ModItems.BLACK_OPAL_SWORD_LEVITATION);
        handheldItem(ModItems.BLACK_OPAL_PICKAXE);
        handheldItem(ModItems.BLACK_OPAL_AXE);
        handheldItem(ModItems.BLACK_OPAL_SHOVEL);
        handheldItem(ModItems.BLACK_OPAL_HOE);

        handheldItem(ModItems.BLACK_OPAL_PAXEL);
        handheldItem(ModItems.BLACK_OPAL_HAMMER);

        basicItem(ModItems.BLACK_OPAL_HELMET.get());
        basicItem(ModItems.BLACK_OPAL_CHESTPLATE.get());
        basicItem(ModItems.BLACK_OPAL_LEGGINGS.get());
        basicItem(ModItems.BLACK_OPAL_BOOTS.get());

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
        this.withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory"))
                .texture("texture", ResourceLocation.fromNamespaceAndPath(MCCourseMod.MOD_ID, "block/" + baseBlock.getId().getPath()));
    }

    public void fenceItem(DeferredBlock<Block> block, DeferredBlock<Block> baseBlock){
        this.baseItem(block, baseBlock, "fence");
    }

    public void wallItem(DeferredBlock<Block> block, DeferredBlock<Block> baseBlock){
        this.baseItem(block, baseBlock, "wall");
    }

    private void baseItem(DeferredBlock<Block> block, DeferredBlock<Block> baseBlock, String name){
        this.withExistingParent(block.getId().getPath(), mcLoc("block/"+ name +"_inventory"))
                .texture(name, ResourceLocation.fromNamespaceAndPath(MCCourseMod.MOD_ID, "block/" + baseBlock.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(DeferredItem<Item> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(MCCourseMod.MOD_ID,"item/" + item.getId().getPath()));
    }


}
