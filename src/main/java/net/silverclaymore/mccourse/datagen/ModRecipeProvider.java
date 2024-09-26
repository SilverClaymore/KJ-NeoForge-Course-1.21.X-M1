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
import net.minecraft.world.level.block.PressurePlateBlock;
import net.neoforged.neoforge.registries.DeferredBlock;
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

        List<ItemLike> MOD_SMELTABLES = List.of(ModItems.RAW_BLACK_OPAL,
                ModBlocks.BLACK_OPAL_ORE, ModBlocks.BLACK_OPAL_DEEPSLATE_ORE, ModBlocks.BLACK_OPAL_END_ORE, ModBlocks.BLACK_OPAL_NETHER_ORE,
                ModItems.RAW_BISMUTH, ModBlocks.BISMUTH_ORE);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BLACK_OPAL_BLOCK.get())
                .pattern("XXX")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', ModItems.BLACK_OPAL.get())
                .unlockedBy("has_black_opal", has(ModItems.BLACK_OPAL.get()))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BLACK_OPAL.get(),9)
                .requires(ModBlocks.BLACK_OPAL_BLOCK.get())
                .unlockedBy("has_black_opal_block", has(ModBlocks.BLACK_OPAL_BLOCK.get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BISMUTH_BLOCK.get())
                .pattern("XXX")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', ModItems.BISMUTH.get())
                .unlockedBy("has_bismuth", has(ModItems.BISMUTH.get()))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BISMUTH.get(),9)
                .requires(ModBlocks.BISMUTH_BLOCK.get())
                .unlockedBy("has_bismuth_block", has(ModBlocks.BISMUTH_BLOCK.get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ALEXANDRITE_BLOCK.get())
                .pattern("XXX")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', ModItems.ALEXANDRITE.get())
                .unlockedBy("has_alexandrite", has(ModItems.ALEXANDRITE.get()))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ALEXANDRITE.get(),9)
                .requires(ModBlocks.ALEXANDRITE_BLOCK.get())
                .unlockedBy("has_alexandrite_block", has(ModBlocks.ALEXANDRITE_BLOCK.get())) // for name parameter can be used: getHasName(ModItems.ALEXANDRITE.get())
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BLACK_OPAL.get(),9)
                .requires(ModBlocks.MAGIC_BLOCK.get())
                .unlockedBy("has_magic_block", has(ModBlocks.MAGIC_BLOCK.get()))
                .save(recipeOutput, MCCourseMod.MOD_ID + ":" + "black_opal_2"); // instead of black_opal_2 rename it into black_opal_from_magic_block

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ALEXANDRITE.get(),32)
                .requires(ModBlocks.EBONY_SAPLING.get())
                .unlockedBy(getHasName(ModBlocks.ALEXANDRITE_BLOCK.get()), has(ModBlocks.ALEXANDRITE_BLOCK.get()))
                .save(recipeOutput, MCCourseMod.MOD_ID + ":" + "alexandrite_from_ebony_sapling");

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.BLACK_OPAL_SWORD.get(), 1)
                .pattern(" X ")
                .pattern(" X ")
                .pattern(" Y ")
                .define('X', ModItems.BLACK_OPAL.get())
                .define('Y', Items.STICK )
                .unlockedBy("has_black_opal", has(ModItems.BLACK_OPAL.get()))
                .save(recipeOutput, MCCourseMod.MOD_ID + ":" + "black_opal_recipe_sword");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.BLACK_OPAL_PICKAXE.get(), 1)
                .pattern("XXX")
                .pattern(" Y ")
                .pattern(" Y ")
                .define('X', ModItems.BLACK_OPAL.get())
                .define('Y', Items.STICK )
                .unlockedBy("has_black_opal", has(ModItems.BLACK_OPAL.get()))
                .save(recipeOutput, MCCourseMod.MOD_ID + ":" + "black_opal_recipe_pickaxe");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.BLACK_OPAL_AXE.get(), 1)
                .pattern("XX ")
                .pattern("XY ")
                .pattern(" Y ")
                .define('X', ModItems.BLACK_OPAL.get())
                .define('Y', Items.STICK )
                .unlockedBy("has_black_opal", has(ModItems.BLACK_OPAL.get()))
                .save(recipeOutput, MCCourseMod.MOD_ID + ":" + "black_opal_recipe_axe");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.BLACK_OPAL_SHOVEL.get(), 1)
                .pattern(" X ")
                .pattern(" Y ")
                .pattern(" Y ")
                .define('X', ModItems.BLACK_OPAL.get())
                .define('Y', Items.STICK )
                .unlockedBy("has_black_opal", has(ModItems.BLACK_OPAL.get()))
                .save(recipeOutput, MCCourseMod.MOD_ID + ":" + "black_opal_recipe_shovel");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.BLACK_OPAL_HOE.get(), 1)
                .pattern("XX ")
                .pattern(" Y ")
                .pattern(" Y ")
                .define('X', ModItems.BLACK_OPAL.get())
                .define('Y', Items.STICK )
                .unlockedBy("has_black_opal", has(ModItems.BLACK_OPAL.get()))
                .save(recipeOutput, MCCourseMod.MOD_ID + ":" + "black_opal_recipe_hoe");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, ModItems.BLACK_OPAL_PAXEL.get(),1)
                .requires(ModItems.BLACK_OPAL_PICKAXE.get())
                .requires(ModItems.BLACK_OPAL_AXE.get())
                .requires(ModItems.BLACK_OPAL_SHOVEL.get())
                .requires(ModItems.BLACK_OPAL_HOE.get())
                .unlockedBy("has_magic_block", has(ModBlocks.MAGIC_BLOCK.get()))
                .save(recipeOutput, MCCourseMod.MOD_ID + ":" + "black_opal_recipe_paxel");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.BLACK_OPAL_HAMMER.get(), 1)
                .pattern("XXX")
                .pattern("XYX")
                .pattern(" Y ")
                .define('X', ModItems.BLACK_OPAL.get())
                .define('Y', Items.STICK )
                .unlockedBy("has_black_opal", has(ModItems.BLACK_OPAL.get()))
                .save(recipeOutput, MCCourseMod.MOD_ID + ":" + "black_opal_recipe_hammer");

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.KAUPEN_BOW.get(), 1)
                .pattern(" BX")
                .pattern("S X")
                .pattern(" BX")
                .define('X', Items.STRING)
                .define('B', ModItems.BLACK_OPAL)
                .define('S', Items.STICK)
                .unlockedBy("has_black_opal", has(ModItems.BLACK_OPAL.get()))
                .save(recipeOutput, MCCourseMod.MOD_ID + ":" + "kaupen_bow_recipe_kaupen_bow");

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.BLACK_OPAL_HELMET.get(), 1)
                .pattern("XXX")
                .pattern("X X")
                .define('X', ModItems.BLACK_OPAL.get())
                .unlockedBy("has_black_opal", has(ModItems.BLACK_OPAL.get()))
                .save(recipeOutput, MCCourseMod.MOD_ID + ":" + "black_opal_recipe_helmet");

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.BLACK_OPAL_CHESTPLATE.get(), 1)
                .pattern("X X")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', ModItems.BLACK_OPAL.get())
                .unlockedBy("has_black_opal", has(ModItems.BLACK_OPAL.get()))
                .save(recipeOutput, MCCourseMod.MOD_ID + ":" + "black_opal_recipe_chestplate");

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.BLACK_OPAL_LEGGINGS.get(), 1)
                .pattern("XXX")
                .pattern("X X")
                .pattern("X X")
                .define('X', ModItems.BLACK_OPAL.get())
                .unlockedBy("has_black_opal", has(ModItems.BLACK_OPAL.get()))
                .save(recipeOutput, MCCourseMod.MOD_ID + ":" + "black_opal_recipe_leggings");

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.BLACK_OPAL_BOOTS.get(), 1)
                .pattern("X X")
                .pattern("X X")
                .define('X', ModItems.BLACK_OPAL.get())
                .unlockedBy("has_black_opal", has(ModItems.BLACK_OPAL.get()))
                .save(recipeOutput, MCCourseMod.MOD_ID + ":" + "black_opal_recipe_boots");

        oreSmelting(recipeOutput, MOD_SMELTABLES, RecipeCategory.MISC, ModItems.BLACK_OPAL.get(), 0.25f, 200, "black_opal" );
        oreBlasting(recipeOutput, MOD_SMELTABLES, RecipeCategory.MISC, ModItems.BLACK_OPAL.get(), 0.25f, 100, "black_opal" );

        oreSmelting(recipeOutput, MOD_SMELTABLES, RecipeCategory.MISC, ModItems.BISMUTH.get(), 0.25f, 200, "bismuth" );
        oreBlasting(recipeOutput, MOD_SMELTABLES, RecipeCategory.MISC, ModItems.BISMUTH.get(), 0.25f, 100, "bismuth" );

        oreSmelting(recipeOutput, MOD_SMELTABLES, RecipeCategory.MISC, ModItems.ALEXANDRITE.get(), 0.25f, 200, "alexandrite" );
        oreBlasting(recipeOutput, MOD_SMELTABLES, RecipeCategory.MISC, ModItems.ALEXANDRITE.get(), 0.25f, 100, "alexandrite" );

        commonRecipes(recipeOutput, ModBlocks.BLACK_OPAL_BLOCK, null, "black_opal",
                ModBlocks.BLACK_OPAL_PRESSURE_PLATE, ModBlocks.BLACK_OPAL_BUTTON, ModBlocks.BLACK_OPAL_SLAB, ModBlocks.BLACK_OPAL_STAIRS, ModBlocks.BLACK_OPAL_FENCE, ModBlocks.BLACK_OPAL_FENCE_GATE, ModBlocks.BLACK_OPAL_WALL, ModBlocks.BLACK_OPAL_DOOR, ModBlocks.BLACK_OPAL_TRAPDOOR);

        commonRecipes(recipeOutput, ModBlocks.BISMUTH_BLOCK, null, "bismuth",
                ModBlocks.BISMUTH_PRESSURE_PLATE, ModBlocks.BISMUTH_BUTTON, ModBlocks.BISMUTH_SLAB, ModBlocks.BISMUTH_STAIRS, ModBlocks.BISMUTH_FENCE, ModBlocks.BISMUTH_FENCE_GATE, ModBlocks.BISMUTH_WALL, ModBlocks.BISMUTH_DOOR, ModBlocks.BISMUTH_TRAPDOOR);

        commonRecipes(recipeOutput, ModBlocks.EBONY_PLANKS, ModTags.Items.EBONY_LOG_TAGS, "ebony",
                ModBlocks.EBONY_PRESSURE_PLATE, ModBlocks.EBONY_BUTTON, ModBlocks.EBONY_SLAB, ModBlocks.EBONY_STAIRS, null, null, null, null, null);
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