package net.darkstudios.enhancement.item.custom.runes;

import net.darkstudios.enhancement.util.ModStatistics;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class AirRuneItem extends Item {
    public AirRuneItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!user.getItemCooldownManager().isCoolingDown(this)) {
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 1200, 4, true, false));
            user.getItemCooldownManager().set(this, 1800);
            user.incrementStat(ModStatistics.AIR_RUNE_USED);
        }
        return super.use(world, user, hand);
    }
}
