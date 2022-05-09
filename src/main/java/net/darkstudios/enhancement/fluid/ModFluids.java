package net.darkstudios.enhancement.fluid;

import net.darkstudios.enhancement.EnhancementMod;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModFluids {
    public static final FlowableFluid OIL_STILL = register("oil_still", new OilFluid.Still());
    public static final FlowableFluid OIL_FLOWING = register("oil_flowing", new OilFluid.Flowing());

    private static  FlowableFluid register(String name, FlowableFluid fluid) {
        return Registry.register(Registry.FLUID, new Identifier(EnhancementMod.MOD_ID, name), fluid);
    }
}
