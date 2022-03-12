package net.darkstudios.enhancement.item;

import net.darkstudios.enhancement.EnhancementMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class ModItems {

    //Mod Items Here (Items will be sorted into categories as more get added.)
    public static final Item DRAGONITE_INGOT = registerItem("dragonite_ingot", new Item(new FabricItemSettings().rarity(Rarity.RARE).fireproof().group(ItemGroup.MISC)));

    //Register Item to the Minecraft Registry, so that it exists!
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(EnhancementMod.MOD_ID, name), item);
    }

    //Load the class so that all mod items are registered.
    public static void registerModItems() {
        EnhancementMod.LOGGER.info("Registering Mod Items for: " + EnhancementMod.MOD_DISPLAY_NAME);
    }
}
