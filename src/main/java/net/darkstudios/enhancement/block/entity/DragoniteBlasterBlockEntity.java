package net.darkstudios.enhancement.block.entity;

import net.darkstudios.enhancement.item.ModItems;
import net.darkstudios.enhancement.item.inventory.ImplementedInventory;
import net.darkstudios.enhancement.recipe.DragoniteBlasterRecipe;
import net.darkstudios.enhancement.screen.DragoniteBlasterScreenHandler;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.recipe.RecipeType;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class  DragoniteBlasterBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(4, ItemStack.EMPTY);
    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 72;
    private int fuelTime = 0;
    private int maxFuelTime = 0;

    public DragoniteBlasterBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.DRAGONITE_BLASTER , pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                switch (index) {
                    case 0: return DragoniteBlasterBlockEntity.this.progress;
                    case 1: return DragoniteBlasterBlockEntity.this.maxProgress;
                    case 2: return DragoniteBlasterBlockEntity.this.fuelTime;
                    case 3: return DragoniteBlasterBlockEntity.this.maxFuelTime;
                    default: return 0;
                }
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0:  DragoniteBlasterBlockEntity.this.progress = value; break;
                    case 1:  DragoniteBlasterBlockEntity.this.maxProgress = value; break;
                    case 2:  DragoniteBlasterBlockEntity.this.fuelTime = value; break;
                    case 3:  DragoniteBlasterBlockEntity.this.maxFuelTime = value; break;
                }
            }

            @Override
            public int size() {
                return 4;
            }
        };
    }

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
        return new DragoniteBlasterScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("blaster.progress", progress);
        nbt.putInt("blaster.fuelTime", fuelTime);
        nbt.putInt("blaster.maxFuelTime", maxFuelTime);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        super.readNbt(nbt);
        progress = nbt.getInt("blaster.progress");
        fuelTime = nbt.getInt("blaster.fuelTime");
        maxFuelTime = nbt.getInt("blaster.maxFuelTime");
    }

    private void consumeFuel() {
        if(!getStack(0).isEmpty()) {
            this.fuelTime = FuelRegistry.INSTANCE.get(this.removeStack(0, 1).getItem());
            this.maxFuelTime = this.fuelTime;
        }
    }

    public static void tick(World world, BlockPos pos, BlockState state, DragoniteBlasterBlockEntity entity) {
        if(isConsumingFuel(entity)) {
            entity.fuelTime--;
        }

        if(hasRecipe(entity)) {
            if(hasFuelInFuelSlot(entity) && !isConsumingFuel(entity)) {
                entity.consumeFuel();
            }
            if(isConsumingFuel(entity)) {
                entity.progress++;
                if(entity.progress > entity.maxProgress) {
                    craftItem(entity);
                }
            }
        } else {
            entity.resetProgress();
        }
    }

    private static boolean hasFuelInFuelSlot(DragoniteBlasterBlockEntity entity) {
        return !entity.getStack(0).isEmpty();
    }

    private static boolean isConsumingFuel(DragoniteBlasterBlockEntity entity) {
        return entity.fuelTime > 0;
    }

    private static boolean hasRecipe(DragoniteBlasterBlockEntity entity) {
        World world = entity.world;
        SimpleInventory inventory = new SimpleInventory(entity.inventory.size());
        for (int i = 0; i < entity.inventory.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        Optional<DragoniteBlasterRecipe> match = world.getRecipeManager()
                .getFirstMatch(DragoniteBlasterRecipe.Type.INSTANCE, inventory, world);

        return match.isPresent() && canInsertAmountIntoOutputSlot(inventory)
                && canInsertItemIntoOutputSlot(inventory, match.get().getOutput());
    }

    private static void craftItem(DragoniteBlasterBlockEntity entity) {
        World world = entity.world;
        SimpleInventory inventory = new SimpleInventory(entity.inventory.size());
        for (int i = 0; i < entity.inventory.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        Optional<DragoniteBlasterRecipe> match = world.getRecipeManager()
                .getFirstMatch(DragoniteBlasterRecipe.Type.INSTANCE, inventory, world);

        if(match.isPresent()) {
            entity.removeStack(1,1);
            entity.removeStack(2,1);

            entity.setStack(3, new ItemStack(match.get().getOutput().getItem(),
                    entity.getStack(3).getCount() + 1));

            entity.resetProgress();
        }
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleInventory inventory, ItemStack output) {
        return inventory.getStack(3).getItem() == output.getItem() || inventory.getStack(3).isEmpty();
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleInventory inventory) {
        return inventory.getStack(3).getMaxCount() > inventory.getStack(3).getCount();
    }
}
