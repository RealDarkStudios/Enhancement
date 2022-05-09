package net.darkstudios.enhancement.item.custom.others;

import net.darkstudios.enhancement.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.tag.TagKey;

public class ModPaxelItem extends MiningToolItem {
    public ModPaxelItem(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(attackDamage, attackSpeed, material, ModTags.Blocks.PAXEL_MINABLE , settings);
    }
}
