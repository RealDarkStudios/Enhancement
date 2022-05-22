package net.darkstudios.enhancement.entity.client.armor;

import net.darkstudios.enhancement.EnhancementMod;
import net.darkstudios.enhancement.item.custom.others.DragoniteArmorItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class DragoniteArmorModel extends AnimatedGeoModel<DragoniteArmorItem> {
    @Override
    public Identifier getModelLocation(DragoniteArmorItem object) {
        return new Identifier(EnhancementMod.MOD_ID, "geo/dragonite_armor.geo.json");
    }

    @Override
    public Identifier getTextureLocation(DragoniteArmorItem object) {
        return new Identifier(EnhancementMod.MOD_ID, "textures/models/armor/dragonite_armor_texture.png");
    }

    @Override
    public Identifier getAnimationFileLocation(DragoniteArmorItem animatable) {
        return new Identifier(EnhancementMod.MOD_ID, "animations/dragonite_armor_animation.json");
    }
}
