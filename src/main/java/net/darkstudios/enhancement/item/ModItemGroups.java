package net.darkstudios.enhancement.item;

import net.darkstudios.enhancement.EnhancementMod;
import net.darkstudios.enhancement.block.ModBlocks;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup DRAGONITE_AGE = FabricItemGroupBuilder.build(new Identifier(EnhancementMod.MOD_ID, "dragonite_age"), () -> new ItemStack(ModBlocks.DRAGONITE_BLOCK));
}
