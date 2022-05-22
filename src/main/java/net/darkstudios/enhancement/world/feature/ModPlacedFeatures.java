package net.darkstudios.enhancement.world.feature;

import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;

public class ModPlacedFeatures {

    public static final RegistryEntry<PlacedFeature> REDWOOD_PLACED = PlacedFeatures.register("redwood_placed",
            ModConfiguredFeatures.REDWOOD_SPAWN, VegetationPlacedFeatures.modifiers(
                    PlacedFeatures.createCountExtraModifier(1, 0.1f, 2)));

    //public static final RegistryEntry<PlacedFeature> SPRUCE_CHECKED = PlacedFeatures.register("spruce_checked", ModConfiguredFeatures.REDWOOD_TREE_RANDOM));

    public static final RegistryEntry<PlacedFeature> DRAGONITE_ORE_PLACED = PlacedFeatures.register("dragonite_ore_placed",
            ModConfiguredFeatures.DRAGONITE_ORE, ModOreFeatures.modifiersWithCount(2,
                    HeightRangePlacementModifier.trapezoid(YOffset.fixed(0), YOffset.fixed(20))));

    public static final RegistryEntry<PlacedFeature> TIN_ORE_PLACED = PlacedFeatures.register("tin_ore_placed",
           ModConfiguredFeatures.TIN_ORE, ModOreFeatures.modifiersWithCount(7,
                   HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-80), YOffset.aboveBottom(144))));
}
