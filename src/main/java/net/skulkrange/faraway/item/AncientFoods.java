package net.skulkrange.faraway.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class AncientFoods {
    public static FoodProperties MYSTIC_BERRIES = new FoodProperties.Builder()
            .alwaysEat().nutrition(2).saturationMod(4f)
            .effect(() -> new MobEffectInstance(MobEffects.HEAL, 30),1f ).build();
    public static FoodProperties GYRO_PITA = new FoodProperties.Builder()
            .nutrition(4).saturationMod(2f)
            .effect(() -> new MobEffectInstance(MobEffects.GLOWING, 1000),1f ).build();

}
