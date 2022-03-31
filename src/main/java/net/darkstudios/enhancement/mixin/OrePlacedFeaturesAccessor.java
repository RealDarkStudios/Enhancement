package net.darkstudios.enhancement.mixin;

import net.minecraft.world.gen.feature.OrePlacedFeatures;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.util.List;

@Mixin(OrePlacedFeatures.class)
public interface OrePlacedFeaturesAccessor {

    @Invoker("modifiersWithCount")
    static List<PlacementModifier> callModifiersWithCount(int i, PlacementModifier mod) {
        return null;
    }
}
