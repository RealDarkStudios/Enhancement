package net.darkstudios.enhancement.entity.custom;

import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.Angerable;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PiglinBruteEntity;
import net.minecraft.entity.mob.PiglinEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.TimeHelper;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.Difficulty;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.AnimationState;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import java.util.UUID;

public class PiglinHunterEntity extends PassiveEntity implements IAnimatable, Angerable {
    private static final TrackedData<Integer> ANGER_TIME = DataTracker.registerData(WolfEntity.class, TrackedDataHandlerRegistry.INTEGER);

    private AnimationFactory factory = new AnimationFactory(this);
    private static final UniformIntProvider ANGER_TIME_RANGE = TimeHelper.betweenSeconds(20, 39);
    @Nullable
    private UUID angryAt;

    public PiglinHunterEntity(EntityType<? extends PassiveEntity> entityType, World world) {
        super(entityType, world);
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }

    public static DefaultAttributeContainer.Builder setAttibutes() {
        return PassiveEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 20.0D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 6.0F)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 2.0F)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.5F);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new MeleeAttackGoal(this, 0.5F, true));
        this.goalSelector.add(2, new WanderAroundPointOfInterestGoal(this, 0.75F, false));
        this.goalSelector.add(3, new WanderAroundFarGoal(this, 0.75F, 1));
        this.goalSelector.add(4, new LookAroundGoal(this));
        this.goalSelector.add(5, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.targetSelector.add(1, new ActiveTargetGoal<PiglinBruteEntity>(this, PiglinBruteEntity.class, false));
        this.targetSelector.add(1, new ActiveTargetGoal<PiglinEntity>(this, PiglinEntity.class, false));
        this.targetSelector.add(0, new RevengeGoal(this, new Class[0]).setGroupRevenge(new Class[0]));
        this.targetSelector.add(3, new ActiveTargetGoal<PlayerEntity>(this, PlayerEntity.class, 10, true, false, this::shouldAngerAt));
    }

    private <E extends IAnimatable>PlayState predicate(AnimationEvent<E> event) {
        if (event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.enhancement.piglin_hunter.walk", true));
            return PlayState.CONTINUE;
        } else if (event.isMoving() && isAttacking()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.enhancement.piglin_hunter.attack", true));
            return PlayState.CONTINUE;
        }

        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.enhancement.piglin_hunter.idle", true));
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimationData animationData) {
        animationData.addAnimationController(new AnimationController(this, "controller", 0, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }

    @Override
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityNbt) {
        initEquipment(difficulty);

        for (EquipmentSlot equipmentSlot : EquipmentSlot.values()) {
            Item equipment = getEquipmentForSlot(equipmentSlot);
            this.equipStack(equipmentSlot, new ItemStack(equipment));
        }

        return entityData;
    }

    @Override
    public int getAngerTime() {
        return this.dataTracker.get(ANGER_TIME);
    }

    @Override
    public void setAngerTime(int angerTime) {
        this.dataTracker.set(ANGER_TIME, angerTime);
    }

    @Override
    public void chooseRandomAngerTime() {
        this.setAngerTime(ANGER_TIME_RANGE.get(this.random));
    }

    @Override
    @Nullable
    public UUID getAngryAt() {
        return this.angryAt;
    }

    @Override
    public void setAngryAt(@Nullable UUID angryAt) {
        this.angryAt = angryAt;
    }

    @Override
    protected void initEquipment(LocalDifficulty difficulty) {
        super.initEquipment(difficulty);
        int i = this.random.nextInt(3);
        if (i == 0) {
            this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.DIAMOND_SWORD));
        } else {
            this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.IRON_SWORD));
        }
    }

    @Nullable
    public static Item getEquipmentForSlot(EquipmentSlot equipmentSlot) {
        switch (equipmentSlot) {
            case HEAD -> {
                return Items.CHAINMAIL_HELMET;
            }
            case CHEST -> {
                return Items.IRON_CHESTPLATE;
            }
            case LEGS -> {
                return Items.CHAINMAIL_LEGGINGS;
            }
            case FEET -> {
                    return Items.CHAINMAIL_BOOTS;
            }
        }
        return null;
    }
}
