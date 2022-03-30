package net.darkstudios.enhancement.util;

import net.darkstudios.enhancement.EnhancementMod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModTags {
    public static class Blocks {

        public static final TagKey<Block> DRAGONITE_BLOCKS = createCommonTag("dragonite_blocks");
        public static final TagKey<Block> ORES = createCommonTag("ores");

        //Add Block Tag
        private static TagKey<Block> createTag(String name) {
            return TagKey.of(Registry.BLOCK_KEY, (new Identifier(EnhancementMod.MOD_ID, name)));
        }

        //Add Block Common Tags. Read about common tags here: https://www.fabricmc.net/wiki/tutorial:tags#common_tags_vs_mod_tags
        private static TagKey<Block> createCommonTag(String name) {
            return TagKey.of(Registry.BLOCK_KEY, (new Identifier("c", name)));
        }
    }

    public static class Items {

        public static final TagKey<Item> DRAGONITE_INGOTS = createCommonTag("dragonite_ingots");
        public static final TagKey<Item> DRAGONITE_NUGGETS = createCommonTag("dragonite_nuggets");
        public static final TagKey<Item> DRAGONITE_DUSTS = createCommonTag("dragonite_dusts");
        public static final TagKey<Item> CORES = createCommonTag("cores");
        public static final TagKey<Item> GEMS = createCommonTag("gems");
        public static final TagKey<Item> STICKS = createCommonTag("sticks");
        public static final TagKey<Item> PLATES = createCommonTag("plates");
        public static final TagKey<Item> ADVANCED_PLATES = createCommonTag("advanced_plates");
        public static final TagKey<Item> RUNES = createCommonTag("runes");

        //Add Item Tag
        private static TagKey<Item> createTag(String name) {
            return TagKey.of(Registry.ITEM_KEY, (new Identifier(EnhancementMod.MOD_ID, name)));
        }

        //Add Item Common Tags.
        private static TagKey<Item> createCommonTag(String name) {
            return TagKey.of(Registry.ITEM_KEY, (new Identifier("c", name)));
        }
    }
}
