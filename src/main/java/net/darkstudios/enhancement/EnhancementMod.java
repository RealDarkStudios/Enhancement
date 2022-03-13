package net.darkstudios.enhancement;

import net.darkstudios.enhancement.block.ModBlocks;
import net.darkstudios.enhancement.item.ModItems;
import net.darkstudios.enhancement.registries.ModRegistries;
import net.darkstudios.enhancement.util.ModRenderHelper;
import net.darkstudios.enhancement.world.gen.ModWorldGen;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EnhancementMod implements ModInitializer {

	public static final String MOD_ID = "enhancement";
	public static final String MOD_DISPLAY_NAME = "Enhancement for Fabric 1.18.1";

	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Enhancement for Fabric 1.18.1 - Initializing");

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModRegistries.registerStrippables();

		ModWorldGen.generateModWorldGen();
	}
}
