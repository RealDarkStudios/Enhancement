package net.darkstudios.enhancement.item;

import net.darkstudios.enhancement.EnhancementMod;
import net.darkstudios.enhancement.item.custom.cores.*;
import net.darkstudios.enhancement.item.custom.others.ModArmorItem;
import net.darkstudios.enhancement.item.custom.others.ModAxeItem;
import net.darkstudios.enhancement.item.custom.others.ModHoeItem;
import net.darkstudios.enhancement.item.custom.others.ModPickaxeItem;
import net.darkstudios.enhancement.item.custom.runes.AirRuneItem;
import net.darkstudios.enhancement.item.custom.runes.HealingRuneItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class ModItems {

    //Dragonite
    //Materials
    public static final Item DRAGONITE_INGOT = registerItem("dragonite_ingot", new Item(new FabricItemSettings().rarity(Rarity.RARE).fireproof().group(ModItemGroups.DRAGONITE_AGE)));
    public static final Item DRAGONITE_NUGGET = registerItem("dragonite_nugget", new Item(new FabricItemSettings().rarity(Rarity.RARE).fireproof().group(ModItemGroups.DRAGONITE_AGE)));
    public static final Item DRAGONITE_DUST = registerItem("dragonite_dust", new Item(new FabricItemSettings().rarity(Rarity.RARE).fireproof().group(ModItemGroups.DRAGONITE_AGE)));

    //Dragonite Tools
    public static final Item DRAGONITE_SWORD = registerItem("dragonite_sword", new SwordItem(ModToolMaterial.DRAGONITE, 3, -2.4F, new FabricItemSettings().rarity(Rarity.RARE).group(ModItemGroups.COMBAT_AND_TOOLS).fireproof()));
    public static final Item DRAGONITE_PICKAXE = registerItem("dragonite_pickaxe", new ModPickaxeItem(ModToolMaterial.DRAGONITE, 1, -2.8F, new FabricItemSettings().rarity(Rarity.RARE).group(ModItemGroups.COMBAT_AND_TOOLS).fireproof()));
    public static final Item DRAGONITE_AXE = registerItem("dragonite_axe", new ModAxeItem(ModToolMaterial.DRAGONITE, 6.0F, -3.0F, new FabricItemSettings().rarity(Rarity.RARE).group(ModItemGroups.COMBAT_AND_TOOLS).fireproof()));
    public static final Item DRAGONITE_SHOVEL = registerItem("dragonite_shovel", new ShovelItem(ModToolMaterial.DRAGONITE, 1.5F, -3.0F, new FabricItemSettings().rarity(Rarity.RARE).group(ModItemGroups.COMBAT_AND_TOOLS).fireproof()));
    public static final Item DRAGONITE_HOE = registerItem("dragonite_hoe", new ModHoeItem(ModToolMaterial.DRAGONITE, -4, 0.0F, new FabricItemSettings().rarity(Rarity.RARE).group(ModItemGroups.COMBAT_AND_TOOLS).fireproof()));
    //public static final Item DRAGONITE_BOW = registerItem("dragonite_bow", new BowItem(new FabricItemSettings().rarity(Rarity.RARE).group(ModItemGroups.COMBAT_AND_TOOLS).fireproof().maxDamage(640)));

    //Dragonite Armor
    public static final Item DRAGONITE_HELMET = registerItem("dragonite_helmet", new ModArmorItem(ModArmorMaterial.DRAGONITE, EquipmentSlot.HEAD ,  1, new FabricItemSettings().rarity(Rarity.RARE).fireproof().group(ModItemGroups.COMBAT_AND_TOOLS)));
    public static final Item DRAGONITE_CHESTPLATE = registerItem("dragonite_chestplate", new ArmorItem(ModArmorMaterial.DRAGONITE, EquipmentSlot.CHEST,new FabricItemSettings().rarity(Rarity.RARE).fireproof().group(ModItemGroups.COMBAT_AND_TOOLS)));
    public static final Item DRAGONITE_LEGGINGS = registerItem("dragonite_leggings", new ArmorItem(ModArmorMaterial.DRAGONITE, EquipmentSlot.LEGS,new FabricItemSettings().rarity(Rarity.RARE).fireproof().group(ModItemGroups.COMBAT_AND_TOOLS)));
    public static final Item DRAGONITE_BOOTS = registerItem("dragonite_boots", new ArmorItem(ModArmorMaterial.DRAGONITE, EquipmentSlot.FEET,new FabricItemSettings().rarity(Rarity.RARE).fireproof().group(ModItemGroups.COMBAT_AND_TOOLS)));

    //Misc
    //Sticks
    public static final Item STONE_STICK = registerItem("stone_stick", new Item(new FabricItemSettings().rarity(Rarity.COMMON).group(ModItemGroups.MISC)));
    public static final Item IRON_STICK = registerItem("iron_stick", new Item(new FabricItemSettings().rarity(Rarity.UNCOMMON).group(ModItemGroups.MISC)));
    public static final Item DIAMOND_STICK = registerItem("diamond_stick", new Item(new FabricItemSettings().rarity(Rarity.UNCOMMON).group(ModItemGroups.MISC)));
    public static final Item NETHERITE_STICK = registerItem("netherite_stick", new Item(new FabricItemSettings().rarity(Rarity.RARE).group(ModItemGroups.MISC).fireproof()));
    public static final Item DRAGONITE_STICK = registerItem("dragonite_stick", new Item(new FabricItemSettings().rarity(Rarity.RARE).group(ModItemGroups.MISC).fireproof()));

    //Plates
    public static final Item IRON_PLATE = registerItem("iron_plate", new Item(new FabricItemSettings().rarity(Rarity.UNCOMMON).group(ModItemGroups.MISC)));
    public static final Item DIAMOND_PLATE = registerItem("diamond_plate", new Item(new FabricItemSettings().rarity(Rarity.UNCOMMON).group(ModItemGroups.MISC)));
    public static final Item NETHERITE_PLATE = registerItem("netherite_plate", new Item(new FabricItemSettings().rarity(Rarity.RARE).group(ModItemGroups.MISC).fireproof()));
    public static final Item DRAGONITE_PLATE = registerItem("dragonite_plate", new Item(new FabricItemSettings().rarity(Rarity.RARE).group(ModItemGroups.MISC).fireproof()));

    //Advanced Plates
    public static final Item ADVANCED_NETHERITE_PLATE = registerItem("advanced_netherite_plate", new Item(new FabricItemSettings().rarity(Rarity.RARE).group(ModItemGroups.MISC).fireproof()));
    public static final Item ADVANCED_DRAGONITE_PLATE = registerItem("advanced_dragonite_plate", new Item(new FabricItemSettings().rarity(Rarity.RARE).group(ModItemGroups.MISC).fireproof()));

    //Cores
    public static final Item WOODEN_CORE = registerItem("wooden_core", new WoodenCoreItem(new FabricItemSettings().rarity(Rarity.COMMON).group(ModItemGroups.MISC)));
    public static final Item STONE_CORE = registerItem("stone_core", new StoneCoreItem(new FabricItemSettings().rarity(Rarity.COMMON).group(ModItemGroups.MISC)));
    public static final Item IRON_CORE = registerItem("iron_core", new IronCoreItem(new FabricItemSettings().rarity(Rarity.UNCOMMON).group(ModItemGroups.MISC)));
    public static final Item DIAMOND_CORE = registerItem("diamond_core", new DiamondCoreItem(new FabricItemSettings().rarity(Rarity.UNCOMMON).group(ModItemGroups.MISC)));
    public static final Item NETHERITE_CORE = registerItem("netherite_core", new NetheriteCoreItem(new FabricItemSettings().rarity(Rarity.RARE).group(ModItemGroups.MISC).fireproof()));
    public static final Item DRAGONITE_CORE = registerItem("dragonite_core", new DragoniteCoreItem(new FabricItemSettings().rarity(Rarity.RARE).group(ModItemGroups.MISC).fireproof()));

    //Runes
    public static final Item HEALING_RUNE = registerItem("healing_rune", new HealingRuneItem(new FabricItemSettings().rarity(Rarity.UNCOMMON).group(ModItemGroups.MISC)));
    public static final Item AIR_RUNE = registerItem("air_rune", new AirRuneItem(new FabricItemSettings().rarity(Rarity.UNCOMMON).group(ModItemGroups.MISC)));

    //Register Item to the Minecraft Registry, so that it exists!
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(EnhancementMod.MOD_ID, name), item);
    }

    //Load the class so that all mod items are registered.
    public static void registerModItems() {
        EnhancementMod.LOGGER.info("Registering Mod Items for: " + EnhancementMod.MOD_DISPLAY_NAME);
    }
}
