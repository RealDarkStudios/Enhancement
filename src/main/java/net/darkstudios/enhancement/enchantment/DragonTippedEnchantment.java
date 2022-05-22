package net.darkstudios.enhancement.enchantment;

import net.minecraft.enchantment.DamageEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class DragonTippedEnchantment extends DamageEnchantment {
    public DragonTippedEnchantment(Rarity weight, int typeIndex, EquipmentSlot... slots) {
        super(weight, typeIndex, slots);
    }

    @Override
    public float getAttackDamage(int level, EntityGroup group) {
        if (this.typeIndex == 0) {
            return 3.0f + (float)Math.max(0, level - 1) * 0.5f;
        }
        return 0.0f;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (target instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity)target;
            if (this.typeIndex == 0 && level > 0) {
                int i = 20 + user.getRandom().nextInt(10 * level);
                livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, i, 3));
            }
        }
    }
}
