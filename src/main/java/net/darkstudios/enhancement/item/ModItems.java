package net.darkstudios.enhancement.item;

import net.darkstudios.enhancement.EnhancementMod;
import net.darkstudios.enhancement.block.ModBlocks;
import net.darkstudios.enhancement.fluid.ModFluids;
import net.darkstudios.enhancement.item.custom.cores.*;
import net.darkstudios.enhancement.item.custom.others.*;
import net.darkstudios.enhancement.item.custom.runes.AirRuneItem;
import net.darkstudios.enhancement.item.custom.runes.HealingRuneItem;
import net.darkstudios.enhancement.item.custom.staffs.DragoniteStaffItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class ModItems {

//Redwood
    public static final Item REDWOOD_SIGN = registerItem("redwood_sign", new SignItem(new FabricItemSettings().group(ModItemGroups.BLOCKS).maxCount(16), ModBlocks.REDWOOD_SIGN, ModBlocks.REDWOOD_WALL_SIGN));

    //Vanilla Addons
    public static final Item WOODEN_PAXEL = registerItem("wooden_paxel", new ModPaxelItem(ToolMaterials.WOOD, 1f, 1f, new FabricItemSettings().rarity(Rarity.COMMON).group(ItemGroup.TOOLS)));
    public static final Item GOLD_PAXEL = registerItem("gold_paxel", new ModPaxelItem(ToolMaterials.GOLD, 1f, 1f, new FabricItemSettings().rarity(Rarity.COMMON).group(ItemGroup.TOOLS)));
    public static final Item STONE_PAXEL = registerItem("stone_paxel", new ModPaxelItem(ToolMaterials.STONE, 1f, 1f, new FabricItemSettings().rarity(Rarity.COMMON).group(ItemGroup.TOOLS)));
    public static final Item IRON_PAXEL = registerItem("iron_paxel", new ModPaxelItem(ToolMaterials.IRON, 1f, 1f, new FabricItemSettings().rarity(Rarity.COMMON).group(ItemGroup.TOOLS)));
    public static final Item DIAMOND_PAXEL = registerItem("diamond_paxel", new ModPaxelItem(ToolMaterials.DIAMOND, 1f, 1f, new FabricItemSettings().rarity(Rarity.COMMON).group(ItemGroup.TOOLS)));
    public static final Item NETHERITE_PAXEL = registerItem("netherite_paxel", new ModPaxelItem(ToolMaterials.NETHERITE, 1f, 1f, new FabricItemSettings().rarity(Rarity.COMMON).group(ItemGroup.TOOLS).fireproof()));

//Dragonite
    //Materials
    public static final Item DRAGONITE_INGOT = registerItem("dragonite_ingot", new Item(new FabricItemSettings().rarity(Rarity.RARE).fireproof().group(ModItemGroups.DRAGONITE_AGE)));
    public static final Item DRAGONITE_NUGGET = registerItem("dragonite_nugget", new Item(new FabricItemSettings().rarity(Rarity.RARE).fireproof().group(ModItemGroups.DRAGONITE_AGE)));
    public static final Item DRAGONITE_DUST = registerItem("dragonite_dust", new Item(new FabricItemSettings().rarity(Rarity.RARE).fireproof().group(ModItemGroups.DRAGONITE_AGE)));
    public static final Item DRAGONITE_COAL = registerItem("dragonite_coal", new Item(new FabricItemSettings().rarity(Rarity.RARE).fireproof().group(ModItemGroups.MISC)));

    //Dragonite Tools
    public static final Item DRAGONITE_SWORD = registerItem("dragonite_sword", new SwordItem(ModToolMaterial.DRAGONITE, 3, -2.4F, new FabricItemSettings().rarity(Rarity.RARE).group(ModItemGroups.COMBAT_AND_TOOLS).fireproof()));
    public static final Item DRAGONITE_PICKAXE = registerItem("dragonite_pickaxe", new ModPickaxeItem(ModToolMaterial.DRAGONITE, 1, -2.8F, new FabricItemSettings().rarity(Rarity.RARE).group(ModItemGroups.COMBAT_AND_TOOLS).fireproof()));
    public static final Item DRAGONITE_AXE = registerItem("dragonite_axe", new ModAxeItem(ModToolMaterial.DRAGONITE, 6.0F, -3.0F, new FabricItemSettings().rarity(Rarity.RARE).group(ModItemGroups.COMBAT_AND_TOOLS).fireproof()));
    public static final Item DRAGONITE_SHOVEL = registerItem("dragonite_shovel", new ShovelItem(ModToolMaterial.DRAGONITE, 1.5F, -3.0F, new FabricItemSettings().rarity(Rarity.RARE).group(ModItemGroups.COMBAT_AND_TOOLS).fireproof()));
    public static final Item DRAGONITE_HOE = registerItem("dragonite_hoe", new ModHoeItem(ModToolMaterial.DRAGONITE, -4, 0.0F, new FabricItemSettings().rarity(Rarity.RARE).group(ModItemGroups.COMBAT_AND_TOOLS).fireproof()));
    //public static final Item DRAGONITE_BOW = registerItem("dragonite_bow", new BowItem(new FabricItemSettings().rarity(Rarity.RARE).group(ModItemGroups.COMBAT_AND_TOOLS).fireproof().maxDamage(640)));
    public static final Item DRAGONITE_PAXEL = registerItem("dragonite_paxel", new ModPaxelItem(ModToolMaterial.DRAGONITE, 1f, 1f, new FabricItemSettings().rarity(Rarity.RARE).group(ModItemGroups.COMBAT_AND_TOOLS).fireproof()));

    //Dragonite Armor
    public static final Item DRAGONITE_HELMET = registerItem("dragonite_helmet", new ModArmorItem(ModArmorMaterial.DRAGONITE, EquipmentSlot.HEAD, new FabricItemSettings().rarity(Rarity.RARE).fireproof().group(ModItemGroups.COMBAT_AND_TOOLS)));
    public static final Item DRAGONITE_CHESTPLATE = registerItem("dragonite_chestplate", new ArmorItem(ModArmorMaterial.DRAGONITE, EquipmentSlot.CHEST, new FabricItemSettings().rarity(Rarity.RARE).fireproof().group(ModItemGroups.COMBAT_AND_TOOLS)));
    public static final Item DRAGONITE_LEGGINGS = registerItem("dragonite_leggings", new ArmorItem(ModArmorMaterial.DRAGONITE, EquipmentSlot.LEGS, new FabricItemSettings().rarity(Rarity.RARE).fireproof().group(ModItemGroups.COMBAT_AND_TOOLS)));
    public static final Item DRAGONITE_BOOTS = registerItem("dragonite_boots", new ArmorItem(ModArmorMaterial.DRAGONITE, EquipmentSlot.FEET, new FabricItemSettings().rarity(Rarity.RARE).fireproof().group(ModItemGroups.COMBAT_AND_TOOLS)));

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

    //Staffs
    public static final Item DRAGONITE_STAFF = registerItem("dragonite_staff", new DragoniteStaffItem(new FabricItemSettings().rarity(Rarity.RARE).group(ModItemGroups.MISC).fireproof().maxCount(1)));

//Foods
    public static final Item RED_GRAPES = registerItem("red_grapes", new Item(new FabricItemSettings().rarity(Rarity.COMMON).group(ModItemGroups.FOODS).food(ModFoodComponents.GRAPES)));
    public static final Item GRAPES = registerItem("grapes", new Item(new FabricItemSettings().rarity(Rarity.COMMON).group(ModItemGroups.FOODS).food(ModFoodComponents.GRAPES)));

//Fluids
    public static final Item OIL_BUCKET = registerItem("oil_bucket", new BucketItem(ModFluids.OIL_STILL, new FabricItemSettings().group(ModItemGroups.MISC).rarity(Rarity.COMMON).maxCount(1)));

    //Register Item to the Minecraft Registry, so that it exists!
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(EnhancementMod.MOD_ID, name), item);
    }

    //Load the class so that all mod items are registered.
    public static void registerModItems() {
        EnhancementMod.LOGGER.info("Registering Mod Items for: " + EnhancementMod.MOD_DISPLAY_NAME);
    }
}
