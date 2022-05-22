package net.darkstudios.enhancement.block;

import net.darkstudios.enhancement.EnhancementMod;
import net.darkstudios.enhancement.block.custom.DragoniteBlasterBlock;
import net.darkstudios.enhancement.block.custom.blocktypes.*;
import net.darkstudios.enhancement.entity.ModSignTypes;
import net.darkstudios.enhancement.fluid.ModFluids;
import net.darkstudios.enhancement.item.ModItemGroups;
import net.darkstudios.enhancement.world.feature.tree.RedwoodSaplingGenerator;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;

import java.util.function.ToIntFunction;

public class ModBlocks {

    //Tin
    public static final Block TIN_BLOCK = registerBlock("tin_block", new Block(FabricBlockSettings.of(Material.METAL).strength(5F, 6F).mapColor(MapColor.LIGHT_GRAY).sounds(BlockSoundGroup.METAL).requiresTool()), new FabricItemSettings().group(ModItemGroups.BLOCKS).rarity(Rarity.COMMON));
    public static final Block TIN_ORE = registerBlock("tin_ore", new OreBlock(FabricBlockSettings.of(Material.STONE).strength(3F, 3F).mapColor(MapColor.STONE_GRAY).sounds(BlockSoundGroup.STONE).requiresTool(), UniformIntProvider.create(5, 9)), new FabricItemSettings().group(ModItemGroups.BLOCKS).rarity(Rarity.COMMON));
    public static final Block DEEPSLATE_TIN_ORE = registerBlock("deepslate_tin_ore", new OreBlock(FabricBlockSettings.of(Material.STONE).strength(3F, 3F).mapColor(MapColor.STONE_GRAY).sounds(BlockSoundGroup.STONE).requiresTool(), UniformIntProvider.create(5, 9)), new FabricItemSettings().group(ModItemGroups.BLOCKS).rarity(Rarity.COMMON));

    //Blenderite -- Requested by idot daniel
    public static final Block BLENDERITE_BLOCK = registerBlock("blender_block", new Block(FabricBlockSettings.of(Material.METAL).strength(15F, 18F).mapColor(MapColor.LIGHT_GRAY).sounds(BlockSoundGroup.METAL).requiresTool()), new FabricItemSettings().group(ModItemGroups.BLOCKS).rarity(Rarity.UNCOMMON));
    public static final Block BLENDERITE_ORE = registerBlock("blenderite_ore", new OreBlock(FabricBlockSettings.of(Material.STONE).strength(9F, 9F).mapColor(MapColor.STONE_GRAY).sounds(BlockSoundGroup.STONE).requiresTool(), UniformIntProvider.create(5, 9)), new FabricItemSettings().group(ModItemGroups.BLOCKS).rarity(Rarity.UNCOMMON));
    public static final Block DEEPSLATE_BLENDERITE_ORE = registerBlock("deepslate_blenderite_ore", new OreBlock(FabricBlockSettings.of(Material.STONE).strength(9F, 9F).mapColor(MapColor.STONE_GRAY).sounds(BlockSoundGroup.STONE).requiresTool(), UniformIntProvider.create(5, 9)), new FabricItemSettings().group(ModItemGroups.BLOCKS).rarity(Rarity.UNCOMMON));
    public static final Block BLENDERITE_STATUE = registerBlock("blenderite_statue", new Block(FabricBlockSettings.of(Material.STONE).strength(12F, 15F).mapColor(MapColor.ORANGE).sounds(BlockSoundGroup.METAL).requiresTool()), new FabricItemSettings().group(ModItemGroups.DECO).rarity(Rarity.UNCOMMON));

    //Dragonite
    public static final Block DRAGONITE_BLOCK = registerBlock("dragonite_block", new Block(FabricBlockSettings.of(Material.METAL).strength(70F, 1400F).mapColor(MapColor.TERRACOTTA_BLACK).sounds(BlockSoundGroup.NETHERITE).requiresTool()), new FabricItemSettings().group(ModItemGroups.BLOCKS).fireproof().rarity(Rarity.RARE));
    public static final Block DRAGONITE_ORE = registerBlock("dragonite_ore", new OreBlock(FabricBlockSettings.of(Material.STONE).strength(30F, 500F).mapColor(MapColor.PALE_YELLOW).sounds(BlockSoundGroup.STONE).requiresTool(), UniformIntProvider.create(5, 9)), new FabricItemSettings().group(ModItemGroups.BLOCKS).fireproof().rarity(Rarity.RARE));
    public static final Block HARDENED_DRAGONITE_BLOCK = registerBlock("hardened_dragonite_block", new Block(FabricBlockSettings.of(Material.STONE).strength(100F, 1750F).mapColor(MapColor.TERRACOTTA_BLACK).sounds(BlockSoundGroup.NETHERITE).requiresTool()), new FabricItemSettings().group(ModItemGroups.BLOCKS).fireproof().rarity(Rarity.RARE));

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
    public static final Block REDWOOD_SIGN = registerBlockWithoutBlockItem("redwood_sign", new SignBlock(FabricBlockSettings.copy(Blocks.OAK_SIGN), ModSignTypes.REDWOOD));
    public static final Block REDWOOD_WALL_SIGN = registerBlockWithoutBlockItem("redwood_wall_sign", new WallSignBlock(FabricBlockSettings.copy(Blocks.OAK_WALL_SIGN), ModSignTypes.REDWOOD));

//Fluids
    public static final Block OIL_FLUID_BLOCK = registerBlockWithoutBlockItem("oil_fluid_block", new ModFluidBlock(ModFluids.OIL_STILL, FabricBlockSettings.copy(Blocks.WATER).noCollision().nonOpaque().dropsNothing()));

//Block Entities
    public static final Block DRAGONITE_BLASTER = registerBlock("dragonite_blaster", new DragoniteBlasterBlock(FabricBlockSettings.of(Material.METAL).strength(70F, 1400F).mapColor(MapColor.TERRACOTTA_BLACK).requiresTool().nonOpaque().luminance(createLightLevelFromLitBlockState(13))), new FabricItemSettings().group(ModItemGroups.BLOCKS).fireproof().rarity(Rarity.RARE));

    //Add light to a block if the lit property is true!
    private static ToIntFunction<BlockState> createLightLevelFromLitBlockState(int litLevel) {
        return state -> state.get(Properties.LIT) ? litLevel : 0;
    }

    //Register Block to the Minecraft Registry, so that it exists!
    private static Block registerBlock(String name, Block block, FabricItemSettings settings) {
        registerBlockItem(name, block, settings);
        return Registry.register(Registry.BLOCK, new Identifier(EnhancementMod.MOD_ID, name), block);
    }

    //Register Item to the Minecraft Registry, so that it exists!
    private static Item registerBlockItem(String name, Block block, FabricItemSettings settings) {
        return Registry.register(Registry.ITEM, new Identifier(EnhancementMod.MOD_ID, name), new BlockItem(block, settings));
    }

    private static Block registerBlockWithoutBlockItem(String name, Block block) {
        return Registry.register(Registry.BLOCK, new Identifier(EnhancementMod.MOD_ID, name), block);
    }

    //Load the class so that all mod blocks. are registered.
    public static void registerModBlocks() {
        EnhancementMod.LOGGER.info("Registering Mod Blocks for: " + EnhancementMod.MOD_DISPLAY_NAME);
    }
}
