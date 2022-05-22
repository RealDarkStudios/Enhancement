package net.darkstudios.enhancement.recipe;

import net.darkstudios.enhancement.EnhancementMod;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModRecipes {
    public static void registerRecipes() {
        Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(EnhancementMod.MOD_ID, DragoniteBlasterRecipe.Serializer.ID), DragoniteBlasterRecipe.Serializer.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE, new Identifier(EnhancementMod.MOD_ID, DragoniteBlasterRecipe.Type.ID), DragoniteBlasterRecipe.Type.INSTANCE);
    }
}
