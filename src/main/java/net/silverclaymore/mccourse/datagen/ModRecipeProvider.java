package net.silverclaymore.mccourse.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.silverclaymore.mccourse.MCCourseMod;
import net.silverclaymore.mccourse.block.ModBlocks;
import net.silverclaymore.mccourse.item.ModItems;
import net.silverclaymore.mccourse.util.ModTags;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {

        List<ItemLike> SMELTABLES_BLACK_OPAL = List.of(ModItems.RAW_BLACK_OPAL, ModBlocks.BLACK_OPAL_ORE,
                ModBlocks.BLACK_OPAL_DEEPSLATE_ORE, ModBlocks.BLACK_OPAL_END_ORE, ModBlocks.BLACK_OPAL_NETHER_ORE);

        List<ItemLike> SMELTABLES_BISMUTH = List.of(ModItems.RAW_BISMUTH, ModBlocks.BISMUTH_ORE);

        List<ItemLike> SMELTABLES_ALEXANDRITE = List.of(ModItems.RAW_ALEXANDRITE, ModBlocks.ALEXANDRITE_ORE,
                ModBlocks.ALEXANDRITE_DEEPSLATE_ORE);

        recipeBlockFromItem9(recipeOutput, ModItems.BLACK_OPAL, ModBlocks.BLACK_OPAL_BLOCK);
        recipeBlockFromItem9(recipeOutput, ModItems.BISMUTH, ModBlocks.BISMUTH_BLOCK);
        recipeBlockFromItem9(recipeOutput, ModItems.ALEXANDRITE, ModBlocks.ALEXANDRITE_BLOCK);

        recipeItemsFromBlock(recipeOutput, ModBlocks.BLACK_OPAL_BLOCK, ModItems.BLACK_OPAL, 9);
        recipeItemsFromBlock(recipeOutput, ModBlocks.BISMUTH_BLOCK, ModItems.BISMUTH, 9);
        recipeItemsFromBlock(recipeOutput, ModBlocks.ALEXANDRITE_BLOCK, ModItems.ALEXANDRITE, 9);

        recipeItemsFromBlock(recipeOutput, ModBlocks.MAGIC_BLOCK, ModItems.BLACK_OPAL, 9);
        recipeItemsFromBlock(recipeOutput, ModBlocks.EBONY_SAPLING, ModItems.ALEXANDRITE, 32);

        recipeCommonToolsWeapons(recipeOutput, ModItems.BLACK_OPAL, ModItems.BLACK_OPAL_SWORD, ModItems.BLACK_OPAL_PICKAXE, ModItems.BLACK_OPAL_AXE, ModItems.BLACK_OPAL_SHOVEL, ModItems.BLACK_OPAL_HOE, ModItems.BLACK_OPAL_PAXEL, ModItems.BLACK_OPAL_HAMMER, ModItems.KAUPEN_BOW);
        recipeCommonToolsWeapons(recipeOutput, ModItems.BISMUTH, ModItems.BISMUTH_SWORD, ModItems.BISMUTH_PICKAXE, ModItems.BISMUTH_AXE, ModItems.BISMUTH_SHOVEL, ModItems.BISMUTH_HOE, null, null, null);

        recipeCommonArmor(recipeOutput, ModItems.BLACK_OPAL, ModItems.BLACK_OPAL_HELMET, ModItems.BLACK_OPAL_CHESTPLATE, ModItems.BLACK_OPAL_LEGGINGS, ModItems.BLACK_OPAL_BOOTS);
        recipeCommonArmor(recipeOutput, ModItems.BISMUTH, null, null, null, null);

        oreSmeltAndBlast(recipeOutput, SMELTABLES_BLACK_OPAL, ModItems.BLACK_OPAL, 0.25f, 0.25f, 200, 100, "black_opal");
        oreSmeltAndBlast(recipeOutput, SMELTABLES_BISMUTH, ModItems.BISMUTH, 0.25f, 0.25f, 200, 100, "bismuth");
        oreSmeltAndBlast(recipeOutput, SMELTABLES_ALEXANDRITE, ModItems.ALEXANDRITE, 0.25f, 0.25f, 200, 100, "alexandrite");

        commonRecipes(recipeOutput, ModBlocks.BLACK_OPAL_BLOCK, null, "black_opal",
                ModBlocks.BLACK_OPAL_PRESSURE_PLATE, ModBlocks.BLACK_OPAL_BUTTON, ModBlocks.BLACK_OPAL_SLAB, ModBlocks.BLACK_OPAL_STAIRS, ModBlocks.BLACK_OPAL_FENCE, ModBlocks.BLACK_OPAL_FENCE_GATE, ModBlocks.BLACK_OPAL_WALL, ModBlocks.BLACK_OPAL_DOOR, ModBlocks.BLACK_OPAL_TRAPDOOR);

        commonRecipes(recipeOutput, ModBlocks.BISMUTH_BLOCK, null, "bismuth",
                ModBlocks.BISMUTH_PRESSURE_PLATE, ModBlocks.BISMUTH_BUTTON, ModBlocks.BISMUTH_SLAB, ModBlocks.BISMUTH_STAIRS, ModBlocks.BISMUTH_FENCE, ModBlocks.BISMUTH_FENCE_GATE, ModBlocks.BISMUTH_WALL, ModBlocks.BISMUTH_DOOR, ModBlocks.BISMUTH_TRAPDOOR);

        commonRecipes(recipeOutput, ModBlocks.ALEXANDRITE_BLOCK, null, "alexandrite",
                ModBlocks.ALEXANDRITE_PRESSURE_PLATE, ModBlocks.ALEXANDRITE_BUTTON, ModBlocks.ALEXANDRITE_SLAB, ModBlocks.ALEXANDRITE_STAIRS, ModBlocks.ALEXANDRITE_FENCE, ModBlocks.ALEXANDRITE_FENCE_GATE, ModBlocks.ALEXANDRITE_WALL, ModBlocks.ALEXANDRITE_DOOR, ModBlocks.ALEXANDRITE_TRAPDOOR);

        commonRecipes(recipeOutput, ModBlocks.EBONY_PLANKS, ModTags.Items.EBONY_LOG_TAGS, "ebony",
                ModBlocks.EBONY_PRESSURE_PLATE, ModBlocks.EBONY_BUTTON, ModBlocks.EBONY_SLAB, ModBlocks.EBONY_STAIRS, ModBlocks.EBONY_FENCE, ModBlocks.EBONY_FENCE_GATE, ModBlocks.EBONY_WALL, null, null);
    }

    protected static void commonRecipes(RecipeOutput recipeOutput, DeferredBlock<Block> material, TagKey<Item> logsTag, String group,
                                        DeferredBlock<Block> pressurePlate, DeferredBlock<Block> button, DeferredBlock<Block> slabs, DeferredBlock<Block> stairs, DeferredBlock<Block> fence, DeferredBlock<Block> fenceGate, DeferredBlock<Block> wallBlock, DeferredBlock<Block> door, DeferredBlock<Block> trapdoor) {
        if (logsTag != null)
            planksFromLogs(recipeOutput, material, logsTag,4);

        if (pressurePlate != null) pressurePlate(recipeOutput, pressurePlate, material);
        if (button != null) buttonBuilder(button, Ingredient.of(material)).group(group)
                .unlockedBy("has_" + group, has(material)).save(recipeOutput);

        if (slabs != null) slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, slabs.get(), material.get());

        if (stairs != null) stairBuilder(stairs, Ingredient.of(material)).group(group)
                .unlockedBy("has_" + group, has(material)).save(recipeOutput);

        if (fence != null) fenceBuilder(fence, Ingredient.of(material)).group(group)
                .unlockedBy("has_" + group, has(material)).save(recipeOutput);
        if (fenceGate != null) fenceGateBuilder(fenceGate, Ingredient.of(material)).group(group)
                .unlockedBy("has_" + group, has(material)).save(recipeOutput);

        if (wallBlock != null) wall(recipeOutput, RecipeCategory.BUILDING_BLOCKS, wallBlock, material);

        if (door != null) doorBuilder(door, Ingredient.of(material)).group(group)
                .unlockedBy("has_" + group, has(material)).save(recipeOutput);
        if (trapdoor != null) trapdoorBuilder(trapdoor, Ingredient.of(material)).group(group)
                .unlockedBy("has_" + group, has(material)).save(recipeOutput);

    }

    protected void recipeCommonToolsWeapons(RecipeOutput recipeOutput, DeferredItem<Item> source, DeferredItem<Item> sword, DeferredItem<Item> pickaxe, DeferredItem<Item> axe, DeferredItem<Item> shovel, DeferredItem<Item> hoe, DeferredItem<Item> paxel, DeferredItem<Item> hammer, DeferredItem<Item> bow){
        if (sword != null) recipeSword(recipeOutput, source, sword, 1);
        if (pickaxe != null) recipePickaxe(recipeOutput, source, pickaxe, 1);
        if (axe != null) recipeAxe(recipeOutput, source, axe, 1);
        if (shovel != null) recipeShovel(recipeOutput, source, shovel, 1);
        if (hoe != null) recipeHoe(recipeOutput, source, hoe, 1);
        if (paxel != null) recipePaxel(recipeOutput, pickaxe, axe, shovel, hoe, ModBlocks.MAGIC_BLOCK, paxel, 1);
        if (hammer != null) recipeHammer(recipeOutput, source, hammer, 1);
        if (bow != null) recipeBow(recipeOutput, source, bow, 1);
    }

    protected void recipeCommonArmor(RecipeOutput recipeOutput, DeferredItem<Item> source, DeferredItem<Item> helmet, DeferredItem<Item> chestplate, DeferredItem<Item> leggings, DeferredItem<Item> boots){
        if (helmet != null) recipeHelmet(recipeOutput, source, helmet, 1);
        if (chestplate != null) recipeChestplate(recipeOutput, source, chestplate, 1);
        if (leggings != null) recipeLeggings(recipeOutput, source, leggings, 1);
        if (boots != null) recipeBoots(recipeOutput, source, boots, 1);
    }

    protected void recipeBlockFromItem9(RecipeOutput recipeOutput, DeferredItem<Item> source, DeferredBlock<Block> result)
    {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, result.get())
                .pattern("XXX")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', source.get())
                .unlockedBy(getHasName(result.get()), has(result.get()))
                .save(recipeOutput);
    }

    protected void recipeItemsFromBlock(RecipeOutput recipeOutput, DeferredBlock<Block> source, DeferredItem<Item> result, int resultCount)
    {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, result.get(), resultCount)
                .requires(source.get())
                .unlockedBy(getHasName(source.get()), has(source.get()))
                .save(recipeOutput, MCCourseMod.MOD_ID + ":" + result.getKey().location().getPath() + "_from_" + source.getKey().location().getPath());
    }

    protected void recipeSword(RecipeOutput recipeOutput, DeferredItem<Item> source, DeferredItem<Item> result, int resultCount)
    {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result.get(), resultCount)
                .pattern(" X ")
                .pattern(" X ")
                .pattern(" Y ")
                .define('X', source.get())
                .define('Y', Items.STICK)
                .unlockedBy(getHasName(source.get()), has(source.get()))
                .save(recipeOutput, MCCourseMod.MOD_ID + ":combatw_" + source.getKey().location().getPath() + "_to_" + result.getKey().location().getPath());
    }

    protected void recipeBow(RecipeOutput recipeOutput, DeferredItem<Item> source, DeferredItem<Item> result, int resultCount)
    {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result.get(), resultCount)
                .pattern(" BX")
                .pattern("S X")
                .pattern(" BX")
                .define('X', Items.STRING)
                .define('B', source)
                .define('S', Items.STICK)
                .unlockedBy(getHasName(source.get()), has(source.get()))
                .save(recipeOutput, MCCourseMod.MOD_ID + ":combatw_" + source.getKey().location().getPath() + "_to_" + result.getKey().location().getPath());
    }

    protected void recipePickaxe(RecipeOutput recipeOutput, DeferredItem<Item> source, DeferredItem<Item> result, int resultCount)
    {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, result.get(), resultCount)
                .pattern("XXX")
                .pattern(" Y ")
                .pattern(" Y ")
                .define('X', source.get())
                .define('Y', Items.STICK )
                .unlockedBy(getHasName(source.get()), has(source.get()))
                .save(recipeOutput, MCCourseMod.MOD_ID + ":tools_" + source.getKey().location().getPath() + "_to_" + result.getKey().location().getPath());
    }

    protected void recipeAxe(RecipeOutput recipeOutput, DeferredItem<Item> source, DeferredItem<Item> result, int resultCount)
    {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, result.get(), resultCount)
                .pattern("XX ")
                .pattern(" Y ")
                .pattern(" Y ")
                .define('X', source.get())
                .define('Y', Items.STICK )
                .unlockedBy(getHasName(source.get()), has(source.get()))
                .save(recipeOutput, MCCourseMod.MOD_ID + ":tools_" + source.getKey().location().getPath() + "_to_" + result.getKey().location().getPath());
    }

    protected void recipeShovel(RecipeOutput recipeOutput, DeferredItem<Item> source, DeferredItem<Item> result, int resultCount)
    {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, result.get(), resultCount)
                .pattern(" X ")
                .pattern(" Y ")
                .pattern(" Y ")
                .define('X', source.get())
                .define('Y', Items.STICK )
                .unlockedBy(getHasName(source.get()), has(source.get()))
                .save(recipeOutput, MCCourseMod.MOD_ID + ":tools_" + source.getKey().location().getPath() + "_to_" + result.getKey().location().getPath());
    }

    protected void recipeHoe(RecipeOutput recipeOutput, DeferredItem<Item> source, DeferredItem<Item> result, int resultCount)
    {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, result.get(), resultCount)
                .pattern("XX ")
                .pattern(" Y ")
                .pattern(" Y ")
                .define('X', source.get())
                .define('Y', Items.STICK )
                .unlockedBy(getHasName(source.get()), has(source.get()))
                .save(recipeOutput, MCCourseMod.MOD_ID + ":tools_" + source.getKey().location().getPath() + "_to_" + result.getKey().location().getPath());
    }

    protected void recipePaxel(RecipeOutput recipeOutput, DeferredItem<Item> pickaxe, DeferredItem<Item> axe, DeferredItem<Item> shovel, DeferredItem<Item> hoe, DeferredBlock<Block> unlockedByBlock, DeferredItem<Item> result, int resultCount)
    {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, result.get(),1)
                .requires(pickaxe.get())
                .requires(axe.get())
                .requires(shovel.get())
                .requires(hoe.get())
                .unlockedBy(getHasName(unlockedByBlock.get()), has(unlockedByBlock.get()))
                .save(recipeOutput, MCCourseMod.MOD_ID + ":tools_" + result.getKey().location().getPath());
    }

    protected void recipeHammer(RecipeOutput recipeOutput, DeferredItem<Item> source, DeferredItem<Item> result, int resultCount)
    {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, result.get(), resultCount)
                .pattern("XXX")
                .pattern("XYX")
                .pattern(" Y ")
                .define('X', source.get())
                .define('Y', Items.STICK )
                .unlockedBy(getHasName(source.get()), has(source.get()))
                .save(recipeOutput, MCCourseMod.MOD_ID + ":tools_" + source.getKey().location().getPath() + "_to_" + result.getKey().location().getPath());
    }

    protected void recipeHelmet(RecipeOutput recipeOutput, DeferredItem<Item> source, DeferredItem<Item> result, int resultCount)
    {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result.get(), resultCount)
                .pattern("XXX")
                .pattern("X X")
                .define('X', source.get())
                .unlockedBy(getHasName(source.get()), has(source.get()))
                .save(recipeOutput, MCCourseMod.MOD_ID + ":combat_" + source.getKey().location().getPath() + "_to_" + result.getKey().location().getPath());
    }

    protected void recipeChestplate(RecipeOutput recipeOutput, DeferredItem<Item> source, DeferredItem<Item> result, int resultCount)
    {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result.get(), resultCount)
                .pattern("X X")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', source.get())
                .unlockedBy(getHasName(source.get()), has(source.get()))
                .save(recipeOutput, MCCourseMod.MOD_ID + ":combat_" + source.getKey().location().getPath() + "_to_" + result.getKey().location().getPath());
    }

    protected void recipeLeggings(RecipeOutput recipeOutput, DeferredItem<Item> source, DeferredItem<Item> result, int resultCount)
    {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result.get(), resultCount)
                .pattern("XXX")
                .pattern("X X")
                .pattern("X X")
                .define('X', source.get())
                .unlockedBy(getHasName(source.get()), has(source.get()))
                .save(recipeOutput, MCCourseMod.MOD_ID + ":combat_" + source.getKey().location().getPath() + "_to_" + result.getKey().location().getPath());
    }

    protected void recipeBoots(RecipeOutput recipeOutput, DeferredItem<Item> source, DeferredItem<Item> result, int resultCount)
    {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result.get(), resultCount)
                .pattern("X X")
                .pattern("X X")
                .define('X', source.get())
                .unlockedBy(getHasName(source.get()), has(source.get()))
                .save(recipeOutput, MCCourseMod.MOD_ID + ":combat_" + source.getKey().location().getPath() + "_to_" + result.getKey().location().getPath());
    }

    protected static void oreSmeltAndBlast(RecipeOutput recipeOutput, List<ItemLike> ingredients, ItemLike result, float experienceSmelt, float experienceBlast, int cookingTimeSmelt, int cookingTimeBlast, String group){
        oreSmelting(recipeOutput, ingredients, RecipeCategory.MISC, result, experienceSmelt, cookingTimeSmelt, group );
        oreBlasting(recipeOutput, ingredients, RecipeCategory.MISC, result, experienceBlast, cookingTimeBlast, group );
    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> ingredients, RecipeCategory category, ItemLike result,
                                      float experience, int cookingTime, String group) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, ingredients, category, result, experience, cookingTime, group, "_from_smelting_");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> ingredients, RecipeCategory category, ItemLike result,
                                      float experience, int cookingTime, String group) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, ingredients, category, result, experience, cookingTime, group, "_from_blasting_");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> cookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> ingredients, RecipeCategory category, ItemLike result, float experience, int cookingTime, String group, String recipeName){
        for(ItemLike itemLike : ingredients){
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemLike), category, result, experience, cookingTime, cookingSerializer, factory)
                    .group(group).unlockedBy(getHasName(itemLike), has(itemLike))
                    .save(recipeOutput, MCCourseMod.MOD_ID + ":" + getItemName(result) + recipeName + getItemName(itemLike));
        }
    }
}