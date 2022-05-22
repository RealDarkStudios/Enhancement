package net.darkstudios.enhancement.entity.client;

import net.darkstudios.enhancement.EnhancementMod;
import net.darkstudios.enhancement.entity.custom.PiglinHunterEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class PiglinHunterModel extends AnimatedGeoModel<PiglinHunterEntity> {
    @Override
    public Identifier getModelLocation(PiglinHunterEntity object) {
        return new Identifier(EnhancementMod.MOD_ID, "geo/piglin_hunter.geo.json");
    }

    @Override
    public Identifier getTextureLocation(PiglinHunterEntity object) {
        return new Identifier(EnhancementMod.MOD_ID, "textures/entity/piglin_hunter/piglin_hunter.png");
    }

    @Override
    public Identifier getAnimationFileLocation(PiglinHunterEntity animatable) {
        return new Identifier(EnhancementMod.MOD_ID, "animations/piglin_hunter.animation.json");
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    @Override
    public void setLivingAnimations(PiglinHunterEntity entity, Integer uID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("head_inner");
        IBone inner_head = this.getAnimationProcessor().getBone("headwear");

        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        if (head != null) {
            head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
            head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
        }
        if (inner_head != null) {
            inner_head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
            inner_head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
        }
    }
}
