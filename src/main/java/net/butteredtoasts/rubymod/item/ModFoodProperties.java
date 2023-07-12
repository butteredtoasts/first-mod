package net.butteredtoasts.rubymod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties BURGER = new FoodProperties.Builder().nutrition(8).saturationMod(2.0f)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1000), 1.0f).build();
}