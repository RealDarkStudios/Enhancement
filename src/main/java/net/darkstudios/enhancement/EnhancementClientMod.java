package net.darkstudios.enhancement;

import net.darkstudios.enhancement.entity.ModEntities;
import net.darkstudios.enhancement.entity.client.PiglinHunterRenderer;
import net.darkstudios.enhancement.entity.client.armor.DragoniteArmorRenderer;
import net.darkstudios.enhancement.item.ModItems;
import net.darkstudios.enhancement.particle.ModParticles;
import net.darkstudios.enhancement.particle.custom.DragoniteStaffUseParticle;
import net.darkstudios.enhancement.particle.custom.OilParticle;
import net.darkstudios.enhancement.screen.DragoniteBlasterScreen;
import net.darkstudios.enhancement.screen.ModScreenHandler;
import net.darkstudios.enhancement.util.ModModelPredicateProvider;
import net.darkstudios.enhancement.util.ModRenderHelper;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

@Environment(EnvType.CLIENT)
public class EnhancementClientMod implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModRenderHelper.setRenderLayers();

        ModModelPredicateProvider.registerModModels();

        ParticleFactoryRegistry.getInstance().register(ModParticles.OIL_PARTICLE, OilParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.DRAGONITE_STAFF_USE, DragoniteStaffUseParticle.Factory::new);

        ScreenRegistry.register(ModScreenHandler.DRAGONITE_BLASTER_SCREEN_HANDLER, DragoniteBlasterScreen::new);

        EntityRendererRegistry.register(ModEntities.PIGLIN_HUNTER, PiglinHunterRenderer::new);

        GeoArmorRenderer.registerArmorRenderer(new DragoniteArmorRenderer(), ModItems.DRAGONITE_BOOTS, ModItems.DRAGONITE_LEGGINGS, ModItems.DRAGONITE_CHESTPLATE, ModItems.DRAGONITE_HELMET);
    }
}
