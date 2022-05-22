package net.darkstudios.enhancement.enchantment;

import net.darkstudios.enhancement.EnhancementMod;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEnchantments {
    public static Enchantment DRAGON_TIPPED = register("dragon_tipped", new DragonTippedEnchantment(Enchantment.Rarity.VERY_RARE, 0, EquipmentSlot.MAINHAND));

    private static Enchantment register(String name, Enchantment enchantment) {
        return Registry.register(Registry.ENCHANTMENT, new Identifier(EnhancementMod.MOD_ID, name), enchantment);
    }

    public static void registerModEnchantments() {
        EnhancementMod.LOGGER.info("Registering Mod Enchantments for: " + EnhancementMod.MOD_DISPLAY_NAME);
    }
}
