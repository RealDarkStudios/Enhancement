package net.darkstudios.enhancement.potion;

import net.darkstudios.enhancement.EnhancementMod;
import net.darkstudios.enhancement.effect.ModEffects;
import net.darkstudios.enhancement.mixin.BrewingRecipeRegistryMixin;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModPotions {
    public static Potion FREEZE_POTION;

    private static Potion register(String name, Potion potion) {
        return Registry.register(Registry.POTION, new Identifier(EnhancementMod.MOD_ID, name), potion);
    }

    public static void registerPotions() {
        FREEZE_POTION = register("freeze_potion", new Potion(new StatusEffectInstance(ModEffects.FREEZE, 200, 0)));

        registerPotionRecipes();
    }

    private static void registerPotionRecipes() {
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, Items.SNOWBALL, ModPotions.FREEZE_POTION);
    }
}
