package net.darkstudios.enhancement.block;

import net.darkstudios.enhancement.EnhancementMod;
import net.darkstudios.enhancement.block.custom.blocktypes.*;
import net.darkstudios.enhancement.item.ModItemGroups;
import net.darkstudios.enhancement.item.ModItems;
import net.darkstudios.enhancement.world.feature.tree.RedwoodSaplingGenerator;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
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
    public static final Block HARDENED_DRAGONITE_BLOCK = registerBlock("hardened_dragonite_block", new Block(FabricBlockSettings.of(Material.STONE).strength(100F, 1750F).mapColor(MapColor.TERRACOTTA_BLACK).sounds(BlockSoundGroup.NETHERITE).requiresTool()), new FabricItemSettings().group(ModItemGroups.DRAGONITE_AGE).fireproof().rarity(Rarity.RARE));

    //Redwood
    public static final Block REDWOOD_LOG = registerBlock("redwood_log", new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)), new FabricItemSettings().rarity(Rarity.COMMON).group(ModItemGroups.BLOCKS));
    public static final Block REDWOOD_WOOD = registerBlock("redwood_wood", new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD)), new FabricItemSettings().rarity(Rarity.COMMON).group(ModItemGroups.BLOCKS));
    public static final Block REDWOOD_PLANKS = registerBlock("redwood_planks", new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)), new FabricItemSettings().rarity(Rarity.COMMON).group(ModItemGroups.BLOCKS));
    public static final Block STRIPPED_REDWOOD_LOG = registerBlock("stripped_redwood_log", new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)), new FabricItemSettings().rarity(Rarity.COMMON).group(ModItemGroups.BLOCKS));
    public static final Block STRIPPED_REDWOOD_WOOD = registerBlock("stripped_redwood_wood", new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD)), new FabricItemSettings().rarity(Rarity.COMMON).group(ModItemGroups.BLOCKS));
    public static final Block REDWOOD_LEAVES = registerBlock("redwood_leaves", new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES)), new FabricItemSettings().rarity(Rarity.COMMON).group(ModItemGroups.BLOCKS));
    public static final Block REDWOOD_SAPLING = registerBlock("redwood_sapling", new ModSaplingBlock(new RedwoodSaplingGenerator(),FabricBlockSettings.copy(Blocks.OAK_SAPLING)), new FabricItemSettings().rarity(Rarity.COMMON).group(ModItemGroups.BLOCKS));
    public static final Block REDWOOD_SLAB = registerBlock("redwood_slab", new SlabBlock(FabricBlockSettings.copy(Blocks.OAK_SLAB)), new FabricItemSettings().rarity(Rarity.COMMON).group(ModItemGroups.BLOCKS));
    public static final Block REDWOOD_STAIRS = registerBlock("redwood_stairs", new ModStairsBlock(ModBlocks.REDWOOD_PLANKS.getDefaultState(), FabricBlockSettings.copy(Blocks.OAK_STAIRS)), new FabricItemSettings().rarity(Rarity.COMMON).group(ModItemGroups.BLOCKS));
    public static final Block REDWOOD_FENCE = registerBlock("redwood_fence", new FenceBlock(FabricBlockSettings.copy(Blocks.OAK_FENCE)), new FabricItemSettings().rarity(Rarity.COMMON).group(ModItemGroups.BLOCKS));
    public static final Block REDWOOD_FENCE_GATE = registerBlock("redwood_fence_gate", new FenceGateBlock(FabricBlockSettings.copy(Blocks.OAK_FENCE_GATE)), new FabricItemSettings().rarity(Rarity.COMMON).group(ModItemGroups.BLOCKS));
    public static final Block REDWOOD_PRESSURE_PLATE = registerBlock("redwood_pressure_plate", new ModPressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copy(Blocks.OAK_PRESSURE_PLATE)), new FabricItemSettings().rarity(Rarity.COMMON).group(ModItemGroups.BLOCKS));
    public static final Block REDWOOD_BUTTON = registerBlock("redwood_button", new ModWoodenButtonBlock(FabricBlockSettings.copy(Blocks.OAK_BUTTON)), new FabricItemSettings().rarity(Rarity.COMMON).group(ModItemGroups.BLOCKS));
    public static final Block REDWOOD_DOOR = registerBlock("redwood_door", new ModDoorBlock(FabricBlockSettings.copy(Blocks.OAK_DOOR)), new FabricItemSettings().group(ModItemGroups.BLOCKS).rarity(Rarity.COMMON));
    public static final Block REDWOOD_TRAPDOOR = registerBlock("redwood_trapdoor", new ModTrapdoorBlock(FabricBlockSettings.copy(Blocks.OAK_TRAPDOOR)), new FabricItemSettings().group(ModItemGroups.BLOCKS).rarity(Rarity.COMMON));


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
