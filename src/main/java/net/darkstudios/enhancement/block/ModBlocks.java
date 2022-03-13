package net.darkstudios.enhancement.block;

import net.darkstudios.enhancement.EnhancementMod;
import net.darkstudios.enhancement.item.ModItemGroups;
import net.darkstudios.enhancement.item.ModItems;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    //Dragonite
    public static final Block DRAGONITE_BLOCK = registerBlock("dragonite_block", new Block(FabricBlockSettings.of(Material.METAL).strength(70F, 1400F).mapColor(MapColor.TERRACOTTA_BLACK).sounds(BlockSoundGroup.NETHERITE).requiresTool()), new FabricItemSettings().group(ModItemGroups.DRAGONITE_AGE).fireproof().rarity(Rarity.RARE));
    public static final Block DRAGONITE_ORE = registerBlock("dragonite_ore", new Block(FabricBlockSettings.of(Material.STONE).strength(30F, 500F).mapColor(MapColor.PALE_YELLOW).sounds(BlockSoundGroup.STONE).requiresTool()), new FabricItemSettings().group(ModItemGroups.DRAGONITE_AGE).fireproof().rarity(Rarity.RARE));

    //Register Block to the Minecraft Registry, so that it exists!
    private static Block registerBlock(String name, Block block, FabricItemSettings settings) {
        registerBlockItem(name, block, settings);
        return Registry.register(Registry.BLOCK, new Identifier(EnhancementMod.MOD_ID, name), block);
    }

    //Register Item to the Minecraft Registry, so that it exists!
    private static Item registerBlockItem(String name, Block block, FabricItemSettings settings) {
        return Registry.register(Registry.ITEM, new Identifier(EnhancementMod.MOD_ID, name), new BlockItem(block, settings));
    }

    //Load the class so that all mod blocks. are registered.
    public static void registerModBlocks() {
        EnhancementMod.LOGGER.info("Registering Mod Blocks for: " + EnhancementMod.MOD_DISPLAY_NAME);
    }
}
