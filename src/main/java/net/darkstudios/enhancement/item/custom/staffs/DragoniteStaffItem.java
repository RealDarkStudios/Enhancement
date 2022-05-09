package net.darkstudios.enhancement.item.custom.staffs;

import net.darkstudios.enhancement.particle.ModParticles;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

import java.util.Random;

public class DragoniteStaffItem extends Item {
    public DragoniteStaffItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if (!user.getItemCooldownManager().isCoolingDown(this)) {
            entity.damage(DamageSource.MAGIC, 10);
            user.getItemCooldownManager().set(this, 100);

            Random random = new Random();

            for (int i = 0; i < 50; i++) {
                user.getWorld().addParticle(ModParticles.DRAGONITE_STAFF_USE, entity.getX() + random.nextFloat(), entity.getY() + random.nextFloat(), entity.getZ() + random.nextFloat(), random.nextFloat()*10, random.nextFloat()*10, random.nextFloat()*10);
            }
            return ActionResult.SUCCESS;
        }

        return ActionResult.FAIL;
    }
}
