package net.darkstudios.enhancement.entity.client;

import net.darkstudios.enhancement.EnhancementMod;
import net.darkstudios.enhancement.entity.custom.PiglinHunterEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class PiglinHunterRenderer extends GeoEntityRenderer<PiglinHunterEntity> {
    public PiglinHunterRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new PiglinHunterModel());
    }

    @Override
    public Identifier getTexture(PiglinHunterEntity entity) {
        return new Identifier(EnhancementMod.MOD_ID, "textures/entity/piglin_hunter/piglin_hunter.png");
    }
}
