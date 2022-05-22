package net.darkstudios.enhancement.entity.client.armor;

import net.darkstudios.enhancement.item.custom.others.DragoniteArmorItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class DragoniteArmorRenderer extends GeoArmorRenderer<DragoniteArmorItem> {
    public DragoniteArmorRenderer() {
        super(new DragoniteArmorModel());

        this.headBone = "armorHead";
        this.bodyBone = "armorBody";
        this.rightArmBone = "armorRightArm";
        this.leftArmBone = "armorLeftArm";
        this.rightLegBone = "armorLeftLeg";
        this.leftLegBone = "armorRightLeg";
        this.rightBootBone = "armorLeftBoot";
        this.leftBootBone = "armorRightBoot";
    }
}
