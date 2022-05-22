package net.darkstudios.enhancement.item.custom.others;

import com.google.common.collect.ImmutableMap;
import net.darkstudios.enhancement.EnhancementMod;
import net.darkstudios.enhancement.item.ModArmorMaterial;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.lang.reflect.Array;
import java.util.Map;
import java.util.Set;

public class ModArmorItem extends ArmorItem {
    private static final Map<ArmorMaterial, Set> MATERIAL_TO_EFFECT_MAP = (new ImmutableMap.Builder<ArmorMaterial, Set>())
            .put(ModArmorMaterial.DRAGONITE, Set.of(new StatusEffectInstance(StatusEffects.STRENGTH, 200, 0)))
            .build();

    public ModArmorItem(ArmorMaterial material, EquipmentSlot slot, Settings settings) {
        super(material, slot, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(!world.isClient()) {
            if(entity instanceof PlayerEntity) {
                PlayerEntity player = (PlayerEntity)entity;

                if (hasFullSuitOfArmorOn(player)) {
                    evaluateArmorEffects(player);
                }
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private void evaluateArmorEffects(PlayerEntity player) {
        for (Map.Entry<ArmorMaterial, Set> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            Set<StatusEffectInstance> mapStatusEffectSet = entry.getValue();

            if (hasCorrectArmorOn(mapArmorMaterial, player)) {
                addStatusEffectForMaterial(player, mapArmorMaterial, mapStatusEffectSet);
            }
        }
    }

    private void addStatusEffectForMaterial(PlayerEntity player, ArmorMaterial mapArmorMaterial, Set<StatusEffectInstance> mapStatusEffectSet) {
        StatusEffectInstance[] mapStatusEffectArray = mapStatusEffectSet.toArray(new StatusEffectInstance[0]);

        if (hasCorrectArmorOn(mapArmorMaterial, player)) {

            for (int i = 0; i < mapStatusEffectArray.length; i++) {
                if (!player.hasStatusEffect(mapStatusEffectArray[i].getEffectType())) {
                    player.addStatusEffect(mapStatusEffectArray[i]);
                }
            }
        }
    }

    private boolean hasFullSuitOfArmorOn(PlayerEntity player) {
        ItemStack boots = player.getInventory().getArmorStack(0);
        ItemStack leggings = player.getInventory().getArmorStack(1);
        ItemStack chestplate = player.getInventory().getArmorStack(2);
        ItemStack helmet = player.getInventory().getArmorStack(3);

        return !helmet.isEmpty() && !chestplate.isEmpty() && !leggings.isEmpty() && !boots.isEmpty();
    }

    private boolean hasCorrectArmorOn(ArmorMaterial material, PlayerEntity player) {
        for (ItemStack armorStack: player.getInventory().armor) {
            if(!(armorStack.getItem() instanceof ArmorItem)) {
                return false;
            }
        }

        ArmorItem boots = ((ArmorItem)player.getInventory().getArmorStack(0).getItem());
        ArmorItem leggings = ((ArmorItem)player.getInventory().getArmorStack(1).getItem());
        ArmorItem chestplate = ((ArmorItem)player.getInventory().getArmorStack(2).getItem());
        ArmorItem helmet = ((ArmorItem)player.getInventory().getArmorStack(3).getItem());

        return helmet.getMaterial() == material && chestplate.getMaterial() == material && leggings.getMaterial() == material && boots.getMaterial() == material;
    }
}
