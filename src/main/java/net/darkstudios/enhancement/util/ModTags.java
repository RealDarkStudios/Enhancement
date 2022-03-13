package net.darkstudios.enhancement.util;

import net.darkstudios.enhancement.EnhancementMod;
import net.fabricmc.fabric.api.tag.TagFactory;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {

        public static final Tag.Identified<Block> DRAGONITE_BLOCKS = createCommonTag("dragonite_blocks");
        public static final Tag.Identified<Block> BASE_STONE_END = createTag("base_stone_end");

        //Add Block Tag
        private static Tag.Identified<Block> createTag(String name) {
            return TagFactory.BLOCK.create(new Identifier(EnhancementMod.MOD_ID, name));
        }

        //Add Block Common Tags. Read about common tags here: https://www.fabricmc.net/wiki/tutorial:tags#common_tags_vs_mod_tags
        private static Tag.Identified<Block> createCommonTag(String name) {
            return TagFactory.BLOCK.create(new Identifier("c", name));
        }
    }

    public static class Items {

        public static final Tag.Identified<Item> DRAGONITE_INGOTS = createCommonTag("dragonite_ingots");

        //Add Item Tag
        private static Tag.Identified<Item> createTag(String name) {
            return TagFactory.ITEM.create(new Identifier(EnhancementMod.MOD_ID, name));
        }

        //Add Item Common Tag
        private static Tag.Identified<Item> createCommonTag(String name) {
            return TagFactory.ITEM.create(new Identifier("c", name));
        }
    }
}
