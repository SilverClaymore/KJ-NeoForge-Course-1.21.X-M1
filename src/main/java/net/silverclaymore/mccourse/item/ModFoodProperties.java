package net.silverclaymore.mccourse.item;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties TOMATO = new FoodProperties.Builder().nutrition(3).saturationModifier(0.25f)
            .effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 600), 0.65f).build();

    public static final FoodProperties GOJI_BERRY = new FoodProperties.Builder().nutrition(2)
            .saturationModifier(0.15f).fast().build();
    public static final FoodProperties HONEY_BERRY = new FoodProperties.Builder().nutrition(2)
            .saturationModifier(0.15f).fast().build();
    public static final FoodProperties PINK_BERRY = new FoodProperties.Builder().nutrition(2)
            .saturationModifier(0.15f).fast().build();
}