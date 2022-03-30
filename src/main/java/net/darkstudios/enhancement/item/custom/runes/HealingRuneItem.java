package net.darkstudios.enhancement.item.custom.runes;

import net.darkstudios.enhancement.util.ModStatistics;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class HealingRuneItem extends Item {
    public HealingRuneItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!user.getItemCooldownManager().isCoolingDown(this)) {
            if (!world.isClient()) {
                user.heal(8);
                user.getItemCooldownManager().set(this, 1200);
                user.sendToolBreakStatus(user.getActiveHand());
                user.incrementStat(ModStatistics.HEALING_RUNE_USED);
            }
        }

        return super.use(world, user, hand);
    }
}
