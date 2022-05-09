package net.darkstudios.enhancement.particle;

import net.darkstudios.enhancement.EnhancementMod;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModParticles {
    public static final DefaultParticleType OIL_PARTICLE = FabricParticleTypes.simple();
    public static final DefaultParticleType DRAGONITE_STAFF_USE = FabricParticleTypes.simple();

    public static void registerParticles() {
        Registry.register(Registry.PARTICLE_TYPE, new Identifier(EnhancementMod.MOD_ID, "oil_particle"), OIL_PARTICLE);
        Registry.register(Registry.PARTICLE_TYPE, new Identifier(EnhancementMod.MOD_ID, "dragonite_staff_use"), DRAGONITE_STAFF_USE);
    }
}
