package net.ebramig.tutorialmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties CEVICHE = new FoodProperties.Builder()
            .nutrition(5)
            .saturationModifier(0.2f)
            .effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 1000), 0.1f).build()
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 180), 1f).build()
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 2400, 0), 1.0F).build();
}
