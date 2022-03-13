package net.darkstudios.enhancement.item;

import net.darkstudios.enhancement.EnhancementMod;
import net.darkstudios.enhancement.item.custom.ModArmorItem;
import net.darkstudios.enhancement.item.custom.ModAxeItem;
import net.darkstudios.enhancement.item.custom.ModHoeItem;
import net.darkstudios.enhancement.item.custom.ModPickaxeItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class ModItems {

    //Dragonite
    public static final Item DRAGONITE_INGOT = registerItem("dragonite_ingot", new Item(new FabricItemSettings().rarity(Rarity.RARE).fireproof().group(ModItemGroups.DRAGONITE_AGE)));
    public static final Item DRAGONITE_DUST = registerItem("dragonite_dust", new Item(new FabricItemSettings().rarity(Rarity.RARE).fireproof().group(ModItemGroups.DRAGONITE_AGE)));

    //Dragonite Armor
    public static final Item DRAGONITE_HELMET = registerItem("dragonite_helmet", new ModArmorItem(ModArmorMaterial.DRAGONITE, EquipmentSlot.HEAD ,  1, new FabricItemSettings().rarity(Rarity.RARE).fireproof().group(ModItemGroups.DRAGONITE_AGE)));
    public static final Item DRAGONITE_CHESTPLATE = registerItem("dragonite_chestplate", new ArmorItem(ModArmorMaterial.DRAGONITE, EquipmentSlot.CHEST,new FabricItemSettings().rarity(Rarity.RARE).fireproof().group(ModItemGroups.DRAGONITE_AGE)));
    public static final Item DRAGONITE_LEGGINGS = registerItem("dragonite_leggings", new ArmorItem(ModArmorMaterial.DRAGONITE, EquipmentSlot.LEGS,new FabricItemSettings().rarity(Rarity.RARE).fireproof().group(ModItemGroups.DRAGONITE_AGE)));
    public static final Item DRAGONITE_BOOTS = registerItem("dragonite_boots", new ArmorItem(ModArmorMaterial.DRAGONITE, EquipmentSlot.FEET,new FabricItemSettings().rarity(Rarity.RARE).fireproof().group(ModItemGroups.DRAGONITE_AGE)));

    //Dragonite Tools
    public static final Item DRAGONITE_SWORD = registerItem("dragonite_sword", new SwordItem(ModToolMaterial.DRAGONITE, 3, -2.4F, new FabricItemSettings().rarity(Rarity.RARE).group(ModItemGroups.DRAGONITE_AGE).fireproof()));
    public static final Item DRAGONITE_PICKAXE = registerItem("dragonite_pickaxe", new ModPickaxeItem(ModToolMaterial.DRAGONITE, 1, -2.8F, new FabricItemSettings().rarity(Rarity.RARE).group(ModItemGroups.DRAGONITE_AGE).fireproof()));
    public static final Item DRAGONITE_AXE = registerItem("dragonite_axe", new ModAxeItem(ModToolMaterial.DRAGONITE, 6.0F, -3.0F, new FabricItemSettings().rarity(Rarity.RARE).group(ModItemGroups.DRAGONITE_AGE).fireproof()));
    public static final Item DRAGONITE_SHOVEL = registerItem("dragonite_shovel", new ShovelItem(ModToolMaterial.DRAGONITE, 1.5F, -3.0F, new FabricItemSettings().rarity(Rarity.RARE).group(ModItemGroups.DRAGONITE_AGE).fireproof()));
    public static final Item DRAGONITE_HOE = registerItem("dragonite_hoe", new ModHoeItem(ModToolMaterial.DRAGONITE, -4, 0.0F, new FabricItemSettings().rarity(Rarity.RARE).group(ModItemGroups.DRAGONITE_AGE).fireproof()));

    //Register Item to the Minecraft Registry, so that it exists!
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(EnhancementMod.MOD_ID, name), item);
    }

    //Load the class so that all mod items are registered.
    public static void registerModItems() {
        EnhancementMod.LOGGER.info("Registering Mod Items for: " + EnhancementMod.MOD_DISPLAY_NAME);
    }
}
