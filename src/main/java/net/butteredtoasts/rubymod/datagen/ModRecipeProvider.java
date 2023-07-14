package net.butteredtoasts.rubymod.datagen;

import net.butteredtoasts.rubymod.RubyMod;
import net.butteredtoasts.rubymod.block.ModBlocks;
import net.butteredtoasts.rubymod.item.ModItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> RUBY_SMELTABLES = List.of(ModItems.RAW_RUBY.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RUBY_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.RUBY.get())
                .unlockedBy("has_ruby", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.RUBY.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RUBY_STAIRS.get())
                .pattern("R  ")
                .pattern("RR ")
                .pattern("RRR")
                .define('R', ModItems.RUBY.get())
                .unlockedBy("has_ruby", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.RUBY.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RUBY_SLAB.get())
                .pattern("RRR")
                .define('R', ModItems.RUBY.get())
                .unlockedBy("has_ruby", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.RUBY.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BURGER.get())
                .pattern("BSB")
                .define('B', ModItems.BUN.get())
                .define('S', Items.COOKED_BEEF)
                .unlockedBy("has_bun", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.BUN.get()).build()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RUBY.get(), 9)
                .requires(ModBlocks.RUBY_BLOCK.get())
                .unlockedBy("has_ruby_block", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModBlocks.RUBY_BLOCK.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RAW_RUBY.get())
                .pattern("RR")
                .define('R', ModItems.RUBY_DUST.get())
                .unlockedBy("has_ruby_dust", inventoryTrigger(ItemPredicate.Builder.item().of(ModItems.RUBY_DUST.get()).build()))
                .save(pWriter);

        oreSmelting(pWriter, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY.get(), 0.25f, 200, "ruby");
        oreBlasting(pWriter, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY.get(), 0.25f, 100, "ruby");
    }
}