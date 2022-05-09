package net.darkstudios.enhancement.util;

import net.darkstudios.enhancement.EnhancementMod;
import net.darkstudios.enhancement.block.ModBlocks;
import net.darkstudios.enhancement.fluid.ModFluids;
import net.darkstudios.enhancement.screen.DragoniteBlasterScreen;
import net.darkstudios.enhancement.screen.ModScreenHandler;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;

public class ModRenderHelper {

    //Set the Render Layers for transparent blocks.
    public static void setRenderLayers() {
        final Identifier OIL_OVERLAY = new Identifier(EnhancementMod.MOD_ID, "block/oil_overlay");

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.REDWOOD_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.REDWOOD_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.REDWOOD_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DRAGONITE_BLASTER, RenderLayer.getCutout());

        FluidRenderHandlerRegistry fluidInstance = FluidRenderHandlerRegistry.INSTANCE;
        fluidInstance.register(ModFluids.OIL_STILL, new SimpleFluidRenderHandler(SimpleFluidRenderHandler.WATER_STILL, SimpleFluidRenderHandler.WATER_FLOWING, OIL_OVERLAY, 0x1f1f1f));
        fluidInstance.register(ModFluids.OIL_FLOWING, new SimpleFluidRenderHandler(SimpleFluidRenderHandler.WATER_STILL, SimpleFluidRenderHandler.WATER_FLOWING, OIL_OVERLAY, 0x1f1f1f));
    }
}
