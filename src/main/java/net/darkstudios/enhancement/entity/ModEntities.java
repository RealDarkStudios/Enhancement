package net.darkstudios.enhancement.entity;

import net.darkstudios.enhancement.EnhancementMod;
import net.darkstudios.enhancement.entity.custom.PiglinHunterEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEntities {
    public static final EntityType<PiglinHunterEntity> PIGLIN_HUNTER = Registry.register(Registry.ENTITY_TYPE, new Identifier(EnhancementMod.MOD_ID, "piglin_hunter"), FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, PiglinHunterEntity::new).dimensions(EntityDimensions.fixed(0.6F, 1.8F)).build());
}
