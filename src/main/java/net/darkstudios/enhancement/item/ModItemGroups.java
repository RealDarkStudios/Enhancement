package net.darkstudios.enhancement.item;

import net.darkstudios.enhancement.EnhancementMod;
import net.darkstudios.enhancement.block.ModBlocks;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.lwjgl.system.CallbackI;

public class ModItemGroups {
    public static final ItemGroup BLOCKS = FabricItemGroupBuilder.build(new Identifier(EnhancementMod.MOD_ID, "blocks"), () -> new ItemStack(ModBlocks.REDWOOD_LOG));
    public static final ItemGroup ITEMS = FabricItemGroupBuilder.build(new Identifier(EnhancementMod.MOD_ID, "items"), () -> new ItemStack(ModBlocks.DRAGONITE_BLOCK));
    public static final ItemGroup COMBAT_AND_TOOLS = FabricItemGroupBuilder.build(new Identifier(EnhancementMod.MOD_ID, "combat_and_tools"), () -> new ItemStack(ModItems.DRAGONITE_SWORD));
    public static final ItemGroup MISC = FabricItemGroupBuilder.build(new Identifier(EnhancementMod.MOD_ID, "misc"), () -> new ItemStack(ModItems.DRAGONITE_CORE));
    public static final ItemGroup FOODS = FabricItemGroupBuilder.build(new Identifier(EnhancementMod.MOD_ID, "foods"), () -> new ItemStack(ModItems.GRAPES));
    public static final ItemGroup DECO = FabricItemGroupBuilder.build(new Identifier(EnhancementMod.MOD_ID, "deco"), () -> new ItemStack(ModBlocks.BLENDERITE_STATUE));
}
