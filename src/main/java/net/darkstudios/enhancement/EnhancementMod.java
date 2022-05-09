package net.darkstudios.enhancement;

import net.darkstudios.enhancement.block.ModBlocks;
import net.darkstudios.enhancement.block.entity.ModBlockEntities;
import net.darkstudios.enhancement.effect.ModEffects;
import net.darkstudios.enhancement.item.ModItems;
import net.darkstudios.enhancement.particle.ModParticles;
import net.darkstudios.enhancement.potion.ModPotions;
import net.darkstudios.enhancement.registries.ModRegistries;
import net.darkstudios.enhancement.screen.ModScreenHandler;
import net.darkstudios.enhancement.util.ModStatistics;
import net.darkstudios.enhancement.world.feature.ModConfiguredFeatures;
import net.darkstudios.enhancement.world.gen.ModWorldGen;
import net.fabricmc.api.ModInitializer;
import net.minecraft.world.biome.Biome;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EnhancementMod implements ModInitializer {

	public static final String MOD_ID = "enhancement";
	public static final String MOD_DISPLAY_NAME = "Enhancement for Fabric 1.18.1";

	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Enhancement for Fabric 1.18.1 - Initializing");

		ModConfiguredFeatures.registerConfiguredFeatures();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModRegistries.registerModStuff();

		ModWorldGen.generateModWorldGen();
		ModStatistics.registerModStats();

		ModParticles.registerParticles();

		ModEffects.registerEffects();
		ModPotions.registerPotions();

		ModBlockEntities.registerBlockEntities();
		ModScreenHandler.registerScreenHandlers();
	}
}
