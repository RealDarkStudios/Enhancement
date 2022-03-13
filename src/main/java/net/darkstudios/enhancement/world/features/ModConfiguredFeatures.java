package net.darkstudios.enhancement.world.features;

import net.darkstudios.enhancement.EnhancementMod;
import net.darkstudios.enhancement.block.ModBlocks;
import net.darkstudios.enhancement.util.ModTags;
import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

import java.util.List;

public class ModConfiguredFeatures {

    public static final List<OreFeatureConfig.Target> END_DRAGONITE_ORES = List.of(
            OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.END_STONE), ModBlocks.DRAGONITE_ORE.getDefaultState()));

    public static final ConfiguredFeature<?, ?> DRAGONITE_ORE = register("dragonite_ore",
            Feature.ORE.configure(new OreFeatureConfig(END_DRAGONITE_ORES, 3)));

    public static <FC extends FeatureConfig> ConfiguredFeature<FC, ?> register(String name, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(EnhancementMod.MOD_ID, name),
                configuredFeature);
    }

    private static RandomPatchFeatureConfig createRandomPatchFeatureConfig(BlockStateProvider block, int tries) {
        return ConfiguredFeatures.createRandomPatchFeatureConfig(tries,
                Feature.SIMPLE_BLOCK.configure(new SimpleBlockFeatureConfig(block)).withInAirFilter());
    }

    public static void registerConfiguredFeatures() {
        EnhancementMod.LOGGER.info("Registering Mod Configured Features for: " + EnhancementMod.MOD_DISPLAY_NAME);
    }
}
