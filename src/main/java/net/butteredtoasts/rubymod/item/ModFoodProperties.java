package net.butteredtoasts.rubymod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

// Used as custom properties for added Food items in ModItems
public class ModFoodProperties {
    public static final FoodProperties BURGER = new FoodProperties.Builder().nutrition(10).saturationMod(2.0f)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1000), 1.0f).build();
    public static final FoodProperties BUN = new FoodProperties.Builder().nutrition(2).saturationMod(0.5f)
            .build();
}