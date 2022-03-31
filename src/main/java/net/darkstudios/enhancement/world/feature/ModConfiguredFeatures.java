package net.darkstudios.enhancement.world.feature;

import net.darkstudios.enhancement.EnhancementMod;
import net.darkstudios.enhancement.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.SpruceFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.GiantTrunkPlacer;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> REDWOOD_TREE =
        ConfiguredFeatures.register("redwood_tree", Feature.TREE, new TreeFeatureConfig.Builder(
            BlockStateProvider.of(ModBlocks.REDWOOD_LOG),
            new GiantTrunkPlacer(13, 2, 14),
            BlockStateProvider.of(ModBlocks.REDWOOD_LEAVES),
            new SpruceFoliagePlacer(ConstantIntProvider.create(10), ConstantIntProvider.create(0), UniformIntProvider.create(10, 17)),
            new TwoLayersFeatureSize(1, 1, 2)).ignoreVines().build());

    public static final RegistryEntry<PlacedFeature> REDWOOD_CHECKED =
            PlacedFeatures.register("redwood_checked", REDWOOD_TREE,
                    PlacedFeatures.wouldSurvive(ModBlocks.REDWOOD_SAPLING));

    public static final  RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> REDWOOD_SPAWN =
            ConfiguredFeatures.register("redwood_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfig(List.of(new RandomFeatureEntry(REDWOOD_CHECKED, 0.5f)), REDWOOD_CHECKED));

    public static final List<OreFeatureConfig.Target> END_DRAGONITE_ORES = List.of(
            OreFeatureConfig.createTarget( new BlockMatchRuleTest(Blocks.END_STONE), ModBlocks.DRAGONITE_ORE.getDefaultState())
    );

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> DRAGONITE_ORE = ConfiguredFeatures.register("dragonite_ore",
            Feature.ORE, new OreFeatureConfig(END_DRAGONITE_ORES, 3));

    public static void registerConfiguredFeatures() {
        EnhancementMod.LOGGER.info("Registering Mod Configured Features for: " + EnhancementMod.MOD_DISPLAY_NAME);
    }

}
