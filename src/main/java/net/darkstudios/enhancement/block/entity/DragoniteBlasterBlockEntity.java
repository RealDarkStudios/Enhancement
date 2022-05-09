package net.darkstudios.enhancement.block.entity;

import net.darkstudios.enhancement.item.ModItems;
import net.darkstudios.enhancement.item.inventory.ImplementedInventory;
import net.darkstudios.enhancement.screen.DragoniteBlasterScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.recipe.RecipeType;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class  DragoniteBlasterBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {
    public DragoniteBlasterBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.DRAGONITE_BLASTER , pos, state);
    }

    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(4, ItemStack.EMPTY);

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public Text getDisplayName() {
        return new TranslatableText("blockEntity.enhancement.dragonite_blaster");
    }

    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new DragoniteBlasterScreenHandler(syncId, playerInventory, this);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        super.readNbt(nbt);
    }

    public static void tick(World world, BlockPos pos, BlockState state, DragoniteBlasterBlockEntity entity) {
        if (hasRecipe(entity) && hasNotReachedStackLimit(entity)) {
            craftItem(entity);
        }
    }

    private static void craftItem(DragoniteBlasterBlockEntity entity) {
        entity.removeStack(0, 1);
        entity.removeStack(1, 1);
        entity.removeStack(2, 1);

        entity.setStack(3, new ItemStack(ModItems.DRAGONITE_CHESTPLATE, entity.getStack(3).getCount() + 1));
    }

    private static boolean hasRecipe(DragoniteBlasterBlockEntity entity) {
        boolean itemInFirst = entity.getStack(0).getItem() == ModItems.DRAGONITE_DUST;
        boolean itemInSecond = entity.getStack(1).getItem() == ModItems.DRAGONITE_INGOT;
        boolean itemInThird = entity.getStack(2).getItem() == Items.DIAMOND_CHESTPLATE;

        return itemInFirst && itemInSecond && itemInThird;
    }

    private static boolean hasNotReachedStackLimit(DragoniteBlasterBlockEntity entity) {
        return entity.getStack(3).getCount() < entity.getStack(3).getMaxCount();
    }
}
