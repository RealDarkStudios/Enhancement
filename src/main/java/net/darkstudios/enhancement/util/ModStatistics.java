package net.darkstudios.enhancement.util;

import net.darkstudios.enhancement.EnhancementMod;
import net.minecraft.stat.StatFormatter;
import net.minecraft.stat.Stats;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModStatistics {
    public static final Identifier HEALING_RUNE_USED = new Identifier(EnhancementMod.MOD_ID, "healing_rune_used");
    public static final Identifier AIR_RUNE_USED = new Identifier(EnhancementMod.MOD_ID, "air_rune_used");

    public static void registerModStats() {
        EnhancementMod.LOGGER.info("Registering Mod Statistics for: " + EnhancementMod.MOD_DISPLAY_NAME);

        Registry.register(Registry.CUSTOM_STAT, "healing_rune_used", HEALING_RUNE_USED);
        Registry.register(Registry.CUSTOM_STAT, "air_rune_used", AIR_RUNE_USED);

        Stats.CUSTOM.getOrCreateStat(HEALING_RUNE_USED, StatFormatter.DEFAULT);
        Stats.CUSTOM.getOrCreateStat(AIR_RUNE_USED, StatFormatter.DEFAULT);
    }
}
