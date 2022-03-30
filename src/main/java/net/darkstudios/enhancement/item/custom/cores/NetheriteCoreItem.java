package net.darkstudios.enhancement.item.custom.cores;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class NetheriteCoreItem extends Item {
    public NetheriteCoreItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (!Screen.hasShiftDown()) {
            tooltip.add(new TranslatableText("tooltip.enhancement.base_tier_core_description", "§6§lNetherite Core§r"));
            tooltip.add(new TranslatableText("tooltip.enhancement.util.shift_info"));
        } else {
            tooltip.add(new TranslatableText("tooltip.enhancement.base_core_info", "§6§lNetherite Core§r", "§6§lDragonite Core§r"));
            tooltip.add(new TranslatableText("tooltip.enhancement.netherite_core_extra_info"));
            tooltip.add(new TranslatableText("tooltip.enhancement.netherite_core_main_crafting_use"));
        }

        super.appendTooltip(stack, world, tooltip, context);
    }
}
