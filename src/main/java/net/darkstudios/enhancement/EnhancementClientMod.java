package net.darkstudios.enhancement;

import net.darkstudios.enhancement.util.ModModelPredicateProvider;
import net.darkstudios.enhancement.util.ModRenderHelper;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class EnhancementClientMod implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModRenderHelper.setRenderLayers();

        ModModelPredicateProvider.registerModModels();
    }
}
