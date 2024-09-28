package net.silverclaymore.mccourse.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.silverclaymore.mccourse.MCCourseMod;
import net.silverclaymore.mccourse.block.ModBlocks;
import net.silverclaymore.mccourse.fluid.ModFluids;
import net.silverclaymore.mccourse.item.ModItems;

import java.util.LinkedHashMap;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MCCourseMod.MOD_ID, existingFileHelper);
    }

    protected void commonItems(DeferredItem<Item> ore, DeferredItem<Item> rawOre, DeferredBlock<Block> baseBlock, DeferredBlock<Block> button, DeferredBlock<Block> fence, DeferredBlock<Block> wall, DeferredBlock<Block> door, DeferredItem<Item> sword, DeferredItem<Item> axe, DeferredItem<Item> pickaxe, DeferredItem<Item> shovel, DeferredItem<Item> hoe, DeferredItem<Item> paxel, DeferredItem<Item> hammer, DeferredItem<Item> helmet, DeferredItem<Item> chestplate, DeferredItem<Item> leggings, DeferredItem<Item> boots, DeferredItem<Item> horseArmor){
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

        if (helmet != null) trimmedArmorItem(helmet);
        if (chestplate != null) trimmedArmorItem(chestplate);
        if (leggings != null) trimmedArmorItem(leggings);
        if (boots != null) trimmedArmorItem(boots);

        if (horseArmor != null) basicItem(horseArmor.get());
    }

    @Override
    protected void registerModels() {

        commonItems(ModItems.BLACK_OPAL, ModItems.RAW_BLACK_OPAL, ModBlocks.BLACK_OPAL_BLOCK, ModBlocks.BLACK_OPAL_BUTTON, ModBlocks.BLACK_OPAL_FENCE, ModBlocks.BLACK_OPAL_WALL, ModBlocks.BLACK_OPAL_DOOR, ModItems.BLACK_OPAL_SWORD, ModItems.BLACK_OPAL_AXE, ModItems.BLACK_OPAL_PICKAXE, ModItems.BLACK_OPAL_SHOVEL, ModItems.BLACK_OPAL_HOE, ModItems.BLACK_OPAL_PAXEL, ModItems.BLACK_OPAL_HAMMER, ModItems.BLACK_OPAL_HELMET, ModItems.BLACK_OPAL_CHESTPLATE, ModItems.BLACK_OPAL_LEGGINGS, ModItems.BLACK_OPAL_BOOTS, ModItems.BLACK_OPAL_HORSE_ARMOR);
        commonItems(ModItems.BISMUTH, ModItems.RAW_BISMUTH, ModBlocks.BISMUTH_BLOCK, ModBlocks.BISMUTH_BUTTON, ModBlocks.BISMUTH_FENCE, ModBlocks.BISMUTH_WALL, ModBlocks.BISMUTH_DOOR, ModItems.BISMUTH_SWORD, ModItems.BISMUTH_AXE, ModItems.BISMUTH_PICKAXE, ModItems.BISMUTH_SHOVEL, ModItems.BISMUTH_HOE, null, null, null, null, null, null, null);
        commonItems(ModItems.ALEXANDRITE, ModItems.RAW_ALEXANDRITE, ModBlocks.ALEXANDRITE_BLOCK, ModBlocks.ALEXANDRITE_BUTTON, ModBlocks.ALEXANDRITE_FENCE, ModBlocks.ALEXANDRITE_WALL, ModBlocks.ALEXANDRITE_DOOR, null, null, null, null, null, null, null, null, null, null, null, null);
        commonItems(null, null, ModBlocks.EBONY_PLANKS, ModBlocks.EBONY_BUTTON, ModBlocks.EBONY_FENCE, ModBlocks.EBONY_WALL, null, null, null, null, null, null, null, null, null, null, null, null, null);

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

    private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }

    // Shoutout to El_Redstoniano for making this
    private void trimmedArmorItem(DeferredItem<Item> itemDeferredItem) {
        final String MOD_ID = MCCourseMod.MOD_ID; // Change this to your mod id
        if(itemDeferredItem.get() instanceof ArmorItem armorItem) {
            trimMaterials.forEach((trimMaterial, value) -> {
                float trimValue = value;
                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };
                String armorItemPath = armorItem.toString();
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = ResourceLocation.parse(armorItemPath);
                ResourceLocation trimResLoc = ResourceLocation.parse(trimPath); // minecraft namespace
                ResourceLocation trimNameResLoc = ResourceLocation.parse(currentTrimName);
                // This is used for making the ExistingFileHelper acknowledge that this texture exist, so this will
                // avoid an IllegalArgumentException
                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");
                // Trimmed armorItem files
                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc.getNamespace() + ":item/" + armorItemResLoc.getPath())
                        .texture("layer1", trimResLoc);
                // Non-trimmed armorItem file (normal variant)
                this.withExistingParent(itemDeferredItem.getId().getPath(),
                                mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc.getNamespace()  + ":item/" + trimNameResLoc.getPath()))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                                ResourceLocation.fromNamespaceAndPath(MOD_ID,
                                        "item/" + itemDeferredItem.getId().getPath()));
            });
        }
    }
}