package net.darkstudios.enhancement.effect;

import net.darkstudios.enhancement.EnhancementMod;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEffects {
    public static StatusEffect FREEZE;

    public static StatusEffect register(String name, StatusEffect effect) {
        return Registry.register(Registry.STATUS_EFFECT, new Identifier(EnhancementMod.MOD_ID, name), effect);
    }

    public static void registerEffects() {
        FREEZE = register("freeze", new FreezeEffect(StatusEffectCategory.HARMFUL, 3124687));
    }
}
