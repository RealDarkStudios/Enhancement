package net.darkstudios.enhancement.world.features;

import net.darkstudios.enhancement.EnhancementMod;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.*;
import net.minecraft.world.gen.feature.PlacedFeature;

import java.util.List;

public class ModPlacedFeatures {

    public static final RegistryKey<PlacedFeature> DRAGONITE_ORE_KEY = registerKey("dragonite_ore");

    public static final PlacedFeature DRAGONITE_ORE_PLACED = registerPlacedFeature("dragonite_ore", ModConfiguredFeatures.DRAGONITE_ORE.withPlacement(modifiersWithCount(2, HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(5), YOffset.fixed(20)))));

    public static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
        return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
    }

    public static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModifier) {
        return modifiers(CountPlacementModifier.of(count), heightModifier);
    }

    private static PlacedFeature registerPlacedFeature(String name, PlacedFeature placedFeature) {
        return Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(EnhancementMod.MOD_ID, name), placedFeature);
    }

    private static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(EnhancementMod.MOD_ID, name));
    }
}
