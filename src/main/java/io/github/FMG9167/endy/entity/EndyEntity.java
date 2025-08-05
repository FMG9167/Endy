package io.github.FMG9167.endy.entity;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class EndyEntity extends HostileEntity {

    private static final TrackedData<Boolean> ATTACKING =
            DataTracker.registerData(EndyEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    public EndyEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public final AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40)+80;
            this.idleAnimationState.start(this.age);
        } else {
            --idleAnimationTimeout;
        }

        if(this.isAttacking() && attackAnimationTimeout <=0) {
            this.attackAnimationTimeout = 40;
            this.attackAnimationState.start(this.age);
        } else {
            --this.attackAnimationTimeout;
        }

        if(!this.isAttacking()) {
            attackAnimationState.stop();
        }
    }

    public void setAttacking(boolean attacking) {
        this.dataTracker.set(ATTACKING, attacking);
    }

    @Override
    public boolean isAttacking() {
        return this.dataTracker.get(ATTACKING);
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(ATTACKING, false);
    }

    @Override
    protected void updateLimbs(float posDelta) {
        float f = this.getPose() == EntityPose.STANDING ? Math.min(posDelta * 6.0f, 1.0f) : 0.0f;
        this.limbAnimator.updateLimbs(f, 0.2f);
    }

    @Override
    public void tick(){
        super.tick();
        if(this.getWorld().isClient()){
            setupAnimationStates();
        }
    }

    public static DefaultAttributeContainer.Builder createEndyAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 30)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 1D)
                .add(EntityAttributes.GENERIC_ARMOR, 20)
                .add(EntityAttributes.GENERIC_ARMOR_TOUGHNESS, 10)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 10)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 3)
                .add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 3D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 1D)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 120);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new EndyAttackGoal(this, 1f, true));
        this.goalSelector.add(0, new AttackGoal(this));
        this.goalSelector.add(3, new LookAroundGoal(this));
        this.goalSelector.add(2, new WanderAroundFarGoal(this, 0.5D));
        this.goalSelector.add(1, new WanderAroundGoal(this, 0.5D));

        this.targetSelector.add(0, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_ENDERMAN_AMBIENT;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_ENDERMAN_HURT;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_ENDERMAN_DEATH;
    }
}
