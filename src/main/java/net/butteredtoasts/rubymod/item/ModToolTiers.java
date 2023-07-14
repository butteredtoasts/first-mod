package net.butteredtoasts.rubymod.item;

import net.butteredtoasts.rubymod.RubyMod;
import net.butteredtoasts.rubymod.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier RUBY = TierSortingRegistry.registerTier(
            new ForgeTier(5, 1600, 11f, 3f, 26,
                    ModTags.Blocks.NEEDS_RUBY_TOOL, () -> Ingredient.of(ModItems.RUBY.get())),
            new ResourceLocation(RubyMod.MOD_ID, "ruby"), List.of(Tiers.NETHERITE), List.of());

}