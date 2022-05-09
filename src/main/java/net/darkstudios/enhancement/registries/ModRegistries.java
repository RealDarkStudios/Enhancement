package net.darkstudios.enhancement.registries;

import net.darkstudios.enhancement.EnhancementMod;
import net.darkstudios.enhancement.block.ModBlocks;
import net.darkstudios.enhancement.command.EnhancementTopLevelCommand;
import net.darkstudios.enhancement.item.ModItems;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;

public class ModRegistries {
    public static void registerModStuff() {
        registerStrippables();
        registerCommands();
        registerFlammableBlocks();
        registerFuels();
    }

    //Register Strippable Blocks
    private static void registerStrippables() {
        EnhancementMod.LOGGER.info("Registering Mod Strippable Blocks for: " + EnhancementMod.MOD_DISPLAY_NAME);
        StrippableBlockRegistry.register(ModBlocks.REDWOOD_LOG, ModBlocks.STRIPPED_REDWOOD_LOG);
        StrippableBlockRegistry.register(ModBlocks.REDWOOD_WOOD, ModBlocks.STRIPPED_REDWOOD_WOOD);
    }

    //Register Mod Commands
    private static void registerCommands() {
        EnhancementMod.LOGGER.info("Registering Mod Commands for: " + EnhancementMod.MOD_DISPLAY_NAME);
        CommandRegistrationCallback.EVENT.register(EnhancementTopLevelCommand::register);
    }

    private static void registerFlammableBlocks() {
        EnhancementMod.LOGGER.info("Registering Mod Flammable Blocks for: " + EnhancementMod.MOD_DISPLAY_NAME);
        FlammableBlockRegistry instance = FlammableBlockRegistry.getDefaultInstance();

        instance.add(ModBlocks.REDWOOD_LOG, 5, 5);
        instance.add(ModBlocks.STRIPPED_REDWOOD_LOG, 5, 5);
        instance.add(ModBlocks.REDWOOD_WOOD, 5, 5);
        instance.add(ModBlocks.STRIPPED_REDWOOD_WOOD, 5, 5);
        instance.add(ModBlocks.REDWOOD_PLANKS, 5, 20);
        instance.add(ModBlocks.REDWOOD_LEAVES, 30, 60);
    }

    private static void registerFuels() {
        EnhancementMod.LOGGER.info("Registering Mod Fuels for: " + EnhancementMod.MOD_DISPLAY_NAME);
        FuelRegistry registry = FuelRegistry.INSTANCE;

        registry.add(ModItems.DRAGONITE_COAL, 6400);
    }
}
