package net.darkstudios.enhancement.block.entity;

import net.darkstudios.enhancement.EnhancementMod;
import net.darkstudios.enhancement.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlockEntities {
    public static BlockEntityType<DragoniteBlasterBlockEntity> DRAGONITE_BLASTER;

    public static void registerBlockEntities() {
        DRAGONITE_BLASTER = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(EnhancementMod.MOD_ID, "dragonite_blaster"), FabricBlockEntityTypeBuilder.create(DragoniteBlasterBlockEntity::new, ModBlocks.DRAGONITE_BLASTER).build(null));
    }
}
