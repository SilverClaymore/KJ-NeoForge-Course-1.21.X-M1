package net.silverclaymore.mccourse.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.silverclaymore.mccourse.MCCourseMod;
import net.silverclaymore.mccourse.block.ModBlocks;
import net.silverclaymore.mccourse.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {

        List<ItemLike> BLACK_OPAL_SMELTABLES = List.of(ModItems.RAW_BLACK_OPAL,
                ModBlocks.BLACK_OPAL_ORE, ModBlocks.BLACK_OPAL_DEEPSLATE_ORE, ModBlocks.BLACK_OPAL_END_ORE, ModBlocks.BLACK_OPAL_NETHER_ORE);

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

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BLACK_OPAL.get(),9)
                .requires(ModBlocks.MAGIC_BLOCK.get())
                .unlockedBy("has_magic_block", has(ModBlocks.MAGIC_BLOCK.get()))
                .save(recipeOutput, MCCourseMod.MOD_ID + ":" + "black_opal_2");

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

        oreSmelting(recipeOutput, BLACK_OPAL_SMELTABLES, RecipeCategory.MISC, ModItems.BLACK_OPAL.get(), 0.25f, 200, "black_opal" );
        oreBlasting(recipeOutput, BLACK_OPAL_SMELTABLES, RecipeCategory.MISC, ModItems.BLACK_OPAL.get(), 0.25f, 100, "black_opal" );

        stairBuilder(ModBlocks.BLACK_OPAL_STAIRS.get(), Ingredient.of(ModItems.BLACK_OPAL.get())).group("black_opal")
                        .unlockedBy("has_black_opal", has(ModItems.BLACK_OPAL.get())).save(recipeOutput);
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLACK_OPAL_SLAB.get(), ModItems.BLACK_OPAL.get());

        pressurePlate(recipeOutput, ModBlocks.BLACK_OPAL_PRESSURE_PLATE.get(), ModItems.BLACK_OPAL.get());
        buttonBuilder(ModBlocks.BLACK_OPAL_BUTTON.get(), Ingredient.of(ModItems.BLACK_OPAL.get())).group("black_opal")
                .unlockedBy("has_black_opal", has(ModItems.BLACK_OPAL.get())).save(recipeOutput);

        fenceBuilder(ModBlocks.BLACK_OPAL_FENCE.get(), Ingredient.of(ModItems.BLACK_OPAL.get())).group("black_opal")
                .unlockedBy("has_black_opal", has(ModItems.BLACK_OPAL.get())).save(recipeOutput);
        fenceGateBuilder(ModBlocks.BLACK_OPAL_FENCE_GATE.get(), Ingredient.of(ModItems.BLACK_OPAL.get())).group("black_opal")
                .unlockedBy("has_black_opal", has(ModItems.BLACK_OPAL.get())).save(recipeOutput);

        doorBuilder(ModBlocks.BLACK_OPAL_DOOR.get(), Ingredient.of(ModItems.BLACK_OPAL.get())).group("black_opal")
                .unlockedBy("has_black_opal", has(ModItems.BLACK_OPAL.get())).save(recipeOutput);
        trapdoorBuilder(ModBlocks.BLACK_OPAL_TRAPDOOR.get(), Ingredient.of(ModItems.BLACK_OPAL.get())).group("black_opal")
                .unlockedBy("has_black_opal", has(ModItems.BLACK_OPAL.get())).save(recipeOutput);

        wall(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLACK_OPAL_WALL.get(), ModItems.BLACK_OPAL.get());

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