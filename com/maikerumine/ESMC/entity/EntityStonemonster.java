package com.maikerumine.ESMC.entity;


import java.util.Calendar;
import java.util.List;
import java.util.UUID;
import javax.annotation.Nullable;
import com.maikerumine.ESMC.init.ModItems;
import com.maikerumine.ESMC.util.handlers.LootTableHandler;
import com.maikerumine.ESMC.util.handlers.SoundsHandler;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAIFleeSun;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAIRestrictSun;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityAIZombieAttack;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.ai.attributes.RangedAttribute;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.monster.EntityZombieVillager;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityParrot;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityStonemonster extends EntityZombie
{
	
    /** The attribute which determines the chance that this mob will spawn reinforcements */
    protected static final IAttribute SPAWN_REINFORCEMENTS_CHANCE = (new RangedAttribute((IAttribute)null, "stonemonster.spawnReinforcements", 0.0D, 0.0D, 1.0D)).func_111117_a("Spawn Reinforcements Chance");
    private static final UUID BABY_SPEED_BOOST_ID = UUID.fromString("B9766B59-9566-4402-BC1F-2EE2A276D836");
    private static final AttributeModifier BABY_SPEED_BOOST = new AttributeModifier(BABY_SPEED_BOOST_ID, "Baby speed boost", 0.5D, 1);
    private static final DataParameter<Boolean> IS_CHILD = EntityDataManager.<Boolean>func_187226_a(EntityStonemonster.class, DataSerializers.field_187198_h);
    /**
     * Was the type of villager for zombie villagers prior to 1.11. Now unused. Use {@link
     * EntityZombieVillager#PROFESSION} instead.
     */
    private static final DataParameter<Integer> VILLAGER_TYPE = EntityDataManager.<Integer>func_187226_a(EntityStonemonster.class, DataSerializers.field_187192_b);
    private static final DataParameter<Boolean> ARMS_RAISED = EntityDataManager.<Boolean>func_187226_a(EntityStonemonster.class, DataSerializers.field_187198_h);
    private final EntityAIBreakDoor breakDoor = new EntityAIBreakDoor(this);
    private boolean isBreakDoorsTaskSet;
    /** The width of the entity */
//    private float stonemonsterWidth = -1.0F;
    private float zombieWidth = -1.0F;
    /** The height of the the entity. */
//    private float stonemonsterHeight;
    private float zombieHeight;
    
    
	public EntityStonemonster(World worldIn) 
	{
		super(worldIn);
		this.func_70105_a(0.9F, 2.7F);
	}
	
	@Override
    protected void func_184651_r()
    {
        this.field_70714_bg.func_75776_a(0, new EntityAISwimming(this));
        this.field_70714_bg.func_75776_a(1, new EntityAILeapAtTarget(this,0.7f));
        this.field_70714_bg.func_75776_a(2, new EntityAIRestrictSun(this));
        this.field_70714_bg.func_75776_a(2, new EntityAIZombieAttack(this, 1.0D, false));
        this.field_70714_bg.func_75776_a(3, new EntityAIFleeSun(this, 1.0D));
        this.field_70714_bg.func_75776_a(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
        this.field_70714_bg.func_75776_a(7, new EntityAIWanderAvoidWater(this, 1.0D));
        this.field_70714_bg.func_75776_a(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.field_70714_bg.func_75776_a(8, new EntityAILookIdle(this));
        this.field_70714_bg.func_75776_a(3, new EntityAIPanic(this, 2.9D));
        this.func_175456_n();
    }
	
	@Override
    protected void func_175456_n()
    {
        this.field_70714_bg.func_75776_a(6, new EntityAIMoveThroughVillage(this, 1.0D, false));
        this.field_70715_bh.func_75776_a(1, new EntityAIHurtByTarget(this, true, new Class[] {EntityPigZombie.class}));
        this.field_70715_bh.func_75776_a(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
        this.field_70715_bh.func_75776_a(3, new EntityAINearestAttackableTarget(this, EntityVillager.class, false));
        this.field_70715_bh.func_75776_a(3, new EntityAINearestAttackableTarget(this, EntityIronGolem.class, true));
        this.field_70715_bh.func_75776_a(3, new EntityAINearestAttackableTarget(this, EntityPig.class, true));
        this.field_70715_bh.func_75776_a(3, new EntityAINearestAttackableTarget(this, EntityCow.class, true));
        this.field_70715_bh.func_75776_a(3, new EntityAINearestAttackableTarget(this, EntityChicken.class, true));
        this.field_70715_bh.func_75776_a(3, new EntityAINearestAttackableTarget(this, EntityWolf.class, true));
        this.field_70715_bh.func_75776_a(3, new EntityAINearestAttackableTarget(this, EntityParrot.class, true));
        this.field_70715_bh.func_75776_a(3, new EntityAINearestAttackableTarget(this, EntityOcelot.class, true));
        this.field_70715_bh.func_75776_a(3, new EntityAINearestAttackableTarget(this, EntitySheep.class, true));   
    }

    protected void func_110147_ax()
    {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111265_b).func_111128_a(35.0D);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.23000000417232513D);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(3.0D);
        this.func_110148_a(SharedMonsterAttributes.field_188791_g).func_111128_a(2.0D);
        this.func_110140_aT().func_111150_b(SPAWN_REINFORCEMENTS_CHANCE).func_111128_a(this.field_70146_Z.nextDouble() * net.minecraftforge.common.ForgeModContainer.zombieSummonBaseChance);
    }
	
//	@Override
//	public float getEyeHeight()
//	{
//		return 2.0F;
//	}

	
	
    protected void func_70088_a()
    {
        super.func_70088_a();
        this.func_184212_Q().func_187214_a(IS_CHILD, Boolean.valueOf(false));
        this.func_184212_Q().func_187214_a(VILLAGER_TYPE, Integer.valueOf(0));
        this.func_184212_Q().func_187214_a(ARMS_RAISED, Boolean.valueOf(false));
    }

    public void func_184733_a(boolean armsRaised)
    {
        this.func_184212_Q().func_187227_b(ARMS_RAISED, Boolean.valueOf(armsRaised));
    }

    @SideOnly(Side.CLIENT)
    public boolean func_184734_db()
    {
        return ((Boolean)this.func_184212_Q().func_187225_a(ARMS_RAISED)).booleanValue();
    }

    public boolean func_146072_bX()
    {
        return this.isBreakDoorsTaskSet;
    }

    /**
     * Sets or removes EntityAIBreakDoor task
     */
    public void func_146070_a(boolean enabled)
    {
        if (this.isBreakDoorsTaskSet != enabled)
        {
            this.isBreakDoorsTaskSet = enabled;
            ((PathNavigateGround)this.func_70661_as()).func_179688_b(enabled);

            if (enabled)
            {
                this.field_70714_bg.func_75776_a(1, this.breakDoor);
            }
            else
            {
                this.field_70714_bg.func_85156_a(this.breakDoor);
            }
        }
    }

    /**
     * If Animal, checks if the age timer is negative
     */
    public boolean func_70631_g_()
    {
        return ((Boolean)this.func_184212_Q().func_187225_a(IS_CHILD)).booleanValue();
    }

    /**
     * Get the experience points the entity currently has.
     */
    protected int func_70693_a(EntityPlayer player)
    {
        if (this.func_70631_g_())
        {
            this.field_70728_aV = (int)((float)this.field_70728_aV * 2.5F);
        }

        return super.func_70693_a(player);
    }

    /**
     * Set whether this zombie is a child.
     */
    public void func_82227_f(boolean childZombie)
    {
        this.func_184212_Q().func_187227_b(IS_CHILD, Boolean.valueOf(childZombie));

        if (this.field_70170_p != null && !this.field_70170_p.field_72995_K)
        {
            IAttributeInstance iattributeinstance = this.func_110148_a(SharedMonsterAttributes.field_111263_d);
            iattributeinstance.func_111124_b(BABY_SPEED_BOOST);

            if (childZombie)
            {
                iattributeinstance.func_111121_a(BABY_SPEED_BOOST);
            }
        }

        this.func_146071_k(childZombie);
    }

    public void func_184206_a(DataParameter<?> key)
    {
        if (IS_CHILD.equals(key))
        {
            this.func_146071_k(this.func_70631_g_());
        }

        super.func_184206_a(key);
    }

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
/**
    public void onLivingUpdate()
    {
        if (this.world.isDaytime() && !this.world.isRemote && !this.isChild() && this.shouldBurnInDay())
        {
            float f = this.getBrightness();

            if (f > 0.5F && this.rand.nextFloat() * 30.0F < (f - 0.4F) * 2.0F && this.world.canSeeSky(new BlockPos(this.posX, this.posY + (double)this.getEyeHeight(), this.posZ)))
            {
                boolean flag = true;
                ItemStack itemstack = this.getItemStackFromSlot(EntityEquipmentSlot.HEAD);

                if (!itemstack.isEmpty())
                {
                    if (itemstack.isItemStackDamageable())
                    {
                        itemstack.setItemDamage(itemstack.getItemDamage() + this.rand.nextInt(2));

                        if (itemstack.getItemDamage() >= itemstack.getMaxDamage())
                        {
                            this.renderBrokenItemStack(itemstack);
                            this.setItemStackToSlot(EntityEquipmentSlot.HEAD, ItemStack.EMPTY);
                        }
                    }

                    flag = false;
                }

                if (flag)
                {
                    this.setFire(8);
                }
            }
        }

        super.onLivingUpdate();
    }

    protected boolean shouldBurnInDay()
    {
        return true;
    }
**/
    /**
     * Called when the entity is attacked.
     */
    public boolean func_70097_a(DamageSource source, float amount)
    {
        if (super.func_70097_a(source, amount))
        {
            EntityLivingBase entitylivingbase = this.func_70638_az();

            if (entitylivingbase == null && source.func_76346_g() instanceof EntityLivingBase)
            {
                entitylivingbase = (EntityLivingBase)source.func_76346_g();
            }

            int i = MathHelper.func_76128_c(this.field_70165_t);
            int j = MathHelper.func_76128_c(this.field_70163_u);
            int k = MathHelper.func_76128_c(this.field_70161_v);
            net.minecraftforge.event.entity.living.ZombieEvent.SummonAidEvent summonAid = net.minecraftforge.event.ForgeEventFactory.fireZombieSummonAid(this, field_70170_p, i, j, k, entitylivingbase, this.func_110148_a(SPAWN_REINFORCEMENTS_CHANCE).func_111126_e());
            if (summonAid.getResult() == net.minecraftforge.fml.common.eventhandler.Event.Result.DENY) return true;

            if (summonAid.getResult() == net.minecraftforge.fml.common.eventhandler.Event.Result.ALLOW  ||
                entitylivingbase != null && this.field_70170_p.func_175659_aa() == EnumDifficulty.HARD && (double)this.field_70146_Z.nextFloat() < this.func_110148_a(SPAWN_REINFORCEMENTS_CHANCE).func_111126_e() && this.field_70170_p.func_82736_K().func_82766_b("doMobSpawning"))
            {
                EntityStonemonster entitystonemonster;
                if (summonAid.getCustomSummonedAid() != null && summonAid.getResult() == net.minecraftforge.fml.common.eventhandler.Event.Result.ALLOW)
                {
                    entitystonemonster = (EntityStonemonster) summonAid.getCustomSummonedAid();
                }
                else
                {
                    entitystonemonster = new EntityStonemonster(this.field_70170_p);
                }

                for (int l = 0; l < 50; ++l)
                {
                    int i1 = i + MathHelper.func_76136_a(this.field_70146_Z, 7, 40) * MathHelper.func_76136_a(this.field_70146_Z, -1, 1);
                    int j1 = j + MathHelper.func_76136_a(this.field_70146_Z, 7, 40) * MathHelper.func_76136_a(this.field_70146_Z, -1, 1);
                    int k1 = k + MathHelper.func_76136_a(this.field_70146_Z, 7, 40) * MathHelper.func_76136_a(this.field_70146_Z, -1, 1);

                    if (this.field_70170_p.func_180495_p(new BlockPos(i1, j1 - 1, k1)).isSideSolid(this.field_70170_p, new BlockPos(i1, j1 - 1, k1), net.minecraft.util.EnumFacing.UP) && this.field_70170_p.func_175671_l(new BlockPos(i1, j1, k1)) < 10)
                    {
                    	entitystonemonster.func_70107_b((double)i1, (double)j1, (double)k1);

                        if (!this.field_70170_p.func_175636_b((double)i1, (double)j1, (double)k1, 7.0D) && this.field_70170_p.func_72917_a(entitystonemonster.func_174813_aQ(), entitystonemonster) && this.field_70170_p.func_184144_a(entitystonemonster, entitystonemonster.func_174813_aQ()).isEmpty() && !this.field_70170_p.func_72953_d(entitystonemonster.func_174813_aQ()))
                        {
                            this.field_70170_p.func_72838_d(entitystonemonster);
                            if (entitylivingbase != null) entitystonemonster.func_70624_b(entitylivingbase);
                            entitystonemonster.func_180482_a(this.field_70170_p.func_175649_E(new BlockPos(entitystonemonster)), (IEntityLivingData)null);
                            this.func_110148_a(SPAWN_REINFORCEMENTS_CHANCE).func_111121_a(new AttributeModifier("Zombie reinforcement caller charge", -0.05000000074505806D, 0));
                            entitystonemonster.func_110148_a(SPAWN_REINFORCEMENTS_CHANCE).func_111121_a(new AttributeModifier("Zombie reinforcement callee charge", -0.05000000074505806D, 0));
                            break;
                        }
                    }
                }
            }

            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean func_70652_k(Entity entityIn)
    {
        boolean flag = super.func_70652_k(entityIn);

        if (flag)
        {
            float f = this.field_70170_p.func_175649_E(new BlockPos(this)).func_180168_b();

            if (this.func_184614_ca().func_190926_b() && this.func_70027_ad() && this.field_70146_Z.nextFloat() < f * 0.3F)
            {
                entityIn.func_70015_d(2 * (int)f);
            }
        }

        return flag;
    }

    protected SoundEvent func_184639_G()
    {
        return SoundsHandler.ENTITY_STONEMONSTER_AMBIENT;			//set to custom Stonemonster
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn)
    {
        return SoundsHandler.ENTITY_STONEMONSTER_HURT;			//set to custom Stonemonster
    }

    protected SoundEvent func_184615_bR()
    {
        return SoundsHandler.ENTITY_STONEMONSTER_DEATH;			//set to custom Stonemonster
    }

//    protected SoundEvent getStepSound()
//    {
//       return SoundsHandler.ENTITY_STONEMONSTER_STEP;			//set to custom Stonemonster
//    }

    protected void func_180429_a(BlockPos pos, Block blockIn)
    {
        this.func_184185_a(this.func_190731_di(), 0.15F, 1.0F);
    }

    /**
     * Get this Entity's EnumCreatureAttribute
     */
    
/*
    public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.UNDEAD;			//set to custom Stonemonster
    }
*/
    @Nullable
    protected ResourceLocation func_184647_J()
    {
        return LootTableList.field_186398_F;   //set to custom Stonemonster
    }

    /**
     * Gives armor or weapon for entity based on given DifficultyInstance
     */
    protected void func_180481_a(DifficultyInstance difficulty)
    {
        super.func_180481_a(difficulty);

        if (this.field_70146_Z.nextFloat() < (this.field_70170_p.func_175659_aa() == EnumDifficulty.HARD ? 0.05F : 0.01F))
        {
            int i = this.field_70146_Z.nextInt(3);

            if (i == 0)
            {
                this.func_184201_a(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.field_151040_l));
            }
            else
            {
                this.func_184201_a(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.field_151037_a));
            }
        }
    }

    public static void registerFixesStonemonster(DataFixer fixer)
    {
        EntityLiving.func_189752_a(fixer, EntityStonemonster.class);
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void func_70014_b(NBTTagCompound compound)
    {
        super.func_70014_b(compound);

        if (this.func_70631_g_())
        {
            compound.func_74757_a("IsBaby", true);
        }

        compound.func_74757_a("CanBreakDoors", this.func_146072_bX());
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void func_70037_a(NBTTagCompound compound)
    {
        super.func_70037_a(compound);

        if (compound.func_74767_n("IsBaby"))
        {
            this.func_82227_f(true);
        }

        this.func_146070_a(compound.func_74767_n("CanBreakDoors"));
    }

    /**
     * This method gets called when the entity kills another one.
     */
    public void func_70074_a(EntityLivingBase entityLivingIn)
    {
        super.func_70074_a(entityLivingIn);

        if ((this.field_70170_p.func_175659_aa() == EnumDifficulty.NORMAL || this.field_70170_p.func_175659_aa() == EnumDifficulty.HARD) && entityLivingIn instanceof EntityVillager)
        {
            if (this.field_70170_p.func_175659_aa() != EnumDifficulty.HARD && this.field_70146_Z.nextBoolean())
            {
                return;
            }

            EntityVillager entityvillager = (EntityVillager)entityLivingIn;
            EntityZombieVillager entityzombievillager = new EntityZombieVillager(this.field_70170_p);
            entityzombievillager.func_82149_j(entityvillager);
            this.field_70170_p.func_72900_e(entityvillager);
            entityzombievillager.func_180482_a(this.field_70170_p.func_175649_E(new BlockPos(entityzombievillager)), new EntityStonemonster.GroupData(false));
            entityzombievillager.func_190733_a(entityvillager.func_70946_n());
            entityzombievillager.func_82227_f(entityvillager.func_70631_g_());
            entityzombievillager.func_94061_f(entityvillager.func_175446_cd());

            if (entityvillager.func_145818_k_())
            {
                entityzombievillager.func_96094_a(entityvillager.func_95999_t());
                entityzombievillager.func_174805_g(entityvillager.func_174833_aM());
            }

            this.field_70170_p.func_72838_d(entityzombievillager);
            this.field_70170_p.func_180498_a((EntityPlayer)null, 1026, new BlockPos(this), 0);
        }
    }

    public float func_70047_e()
    {
        float f = 1.94F;  //was 1.74F

        if (this.func_70631_g_())
        {
            f = (float)((double)f - 0.81D);
        }

        return f;
    }

    protected boolean func_175448_a(ItemStack stack)
    {
        return stack.func_77973_b() == Items.field_151110_aK && this.func_70631_g_() && this.func_184218_aH() ? false : super.func_175448_a(stack);
    }

    /**
     * Called only once on an entity when first time spawned, via egg, mob spawner, natural spawning etc, but not called
     * when entity is reloaded from nbt. Mainly used for initializing attributes and inventory
     */
    @Nullable
    public IEntityLivingData func_180482_a(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata)
    {
        livingdata = super.func_180482_a(difficulty, livingdata);
        float f = difficulty.func_180170_c();
        this.func_98053_h(this.field_70146_Z.nextFloat() < 0.55F * f);

        if (livingdata == null)
        {
            livingdata = new EntityStonemonster.GroupData(this.field_70170_p.field_73012_v.nextFloat() < net.minecraftforge.common.ForgeModContainer.zombieBabyChance);
        }

        if (livingdata instanceof EntityStonemonster.GroupData)
        {
        	EntityStonemonster.GroupData entitystonemonster$groupdata = (EntityStonemonster.GroupData)livingdata;

            if (entitystonemonster$groupdata.isChild)
            {
                this.func_82227_f(true);

                if ((double)this.field_70170_p.field_73012_v.nextFloat() < 0.05D)
                {
                    List<EntityChicken> list = this.field_70170_p.<EntityChicken>func_175647_a(EntityChicken.class, this.func_174813_aQ().func_72314_b(5.0D, 3.0D, 5.0D), EntitySelectors.field_152785_b);

                    if (!list.isEmpty())
                    {
                        EntityChicken entitychicken = list.get(0);
                        entitychicken.func_152117_i(true);
                        this.func_184220_m(entitychicken);
                    }
                }
                else if ((double)this.field_70170_p.field_73012_v.nextFloat() < 0.05D)
                {
                    EntityChicken entitychicken1 = new EntityChicken(this.field_70170_p);
                    entitychicken1.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, 0.0F);
                    entitychicken1.func_180482_a(difficulty, (IEntityLivingData)null);
                    entitychicken1.func_152117_i(true);
                    this.field_70170_p.func_72838_d(entitychicken1);
                    this.func_184220_m(entitychicken1);
                }
            }
        }

        this.func_146070_a(this.field_70146_Z.nextFloat() < f * 0.1F);
        this.func_180481_a(difficulty);
        this.func_180483_b(difficulty);

        if (this.func_184582_a(EntityEquipmentSlot.HEAD).func_190926_b())
        {
            Calendar calendar = this.field_70170_p.func_83015_S();

            if (calendar.get(2) + 1 == 10 && calendar.get(5) == 31 && this.field_70146_Z.nextFloat() < 0.25F)
            {
                this.func_184201_a(EntityEquipmentSlot.HEAD, new ItemStack(this.field_70146_Z.nextFloat() < 0.1F ? Blocks.field_150428_aP : Blocks.field_150423_aK));
                this.field_184655_bs[EntityEquipmentSlot.HEAD.func_188454_b()] = 0.0F;
            }
        }

        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111121_a(new AttributeModifier("Random spawn bonus", this.field_70146_Z.nextDouble() * 0.05000000074505806D, 0));
        double d0 = this.field_70146_Z.nextDouble() * 1.5D * (double)f;

        if (d0 > 1.0D)
        {
            this.func_110148_a(SharedMonsterAttributes.field_111265_b).func_111121_a(new AttributeModifier("Random stonemonster-spawn bonus", d0, 2));
        }

        if (this.field_70146_Z.nextFloat() < f * 0.05F)
        {
            this.func_110148_a(SPAWN_REINFORCEMENTS_CHANCE).func_111121_a(new AttributeModifier("Leader stonemonster bonus", this.field_70146_Z.nextDouble() * 0.25D + 0.5D, 0));
            this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111121_a(new AttributeModifier("Leader stonemonster bonus", this.field_70146_Z.nextDouble() * 3.0D + 1.0D, 2));
            this.func_146070_a(true);
        }

        return livingdata;
    }

    /**
     * sets the size of the entity to be half of its current size if true.
     */
    public void func_146071_k(boolean isChild)
    {
        this.func_146069_a(isChild ? 0.5F : 1.0F);
    }


    /**
     * Returns the Y Offset of this entity.
     */
    public double func_70033_W()
    {
        return this.func_70631_g_() ? 0.0D : -0.45D;
    }

    /**
     * Called when the mob's health reaches 0.
     */
    public void func_70645_a(DamageSource cause)
    {
        super.func_70645_a(cause);

        if (cause.func_76346_g() instanceof EntityCreeper)
        {
            EntityCreeper entitycreeper = (EntityCreeper)cause.func_76346_g();

            if (entitycreeper.func_70830_n() && entitycreeper.func_70650_aV())
            {
                entitycreeper.func_175493_co();
                ItemStack itemstack = this.func_190732_dj();

                if (!itemstack.func_190926_b())
                {
                    this.func_70099_a(itemstack, 0.0F);
                }
            }
        }
    }

    protected ItemStack func_190732_dj()
    {
        return new ItemStack(Items.field_151144_bL, 1, 2);
    }

    class GroupData implements IEntityLivingData
    {
        public boolean isChild;

        private GroupData(boolean p_i47328_2_)
        {
            this.isChild = p_i47328_2_;
        }
    }

}




//THE BELOW CODE IS TEST SAMPLE FROM HARRY"S MODDING TUTORIAL
/**
package com.maikerumine.ESMC.entity;

import com.maikerumine.ESMC.init.ModItems;
import com.maikerumine.ESMC.util.handlers.LootTableHandler;
import com.maikerumine.ESMC.util.handlers.SoundsHandler;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityStonemonster extends EntityCow
{
	public EntityStonemonster(World worldIn) 
	{
		super(worldIn);
		this.setSize(0.9F, 2.8F);
	}
	
	@Override
	protected void initEntityAI()
	{
		this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 2.0D));
        this.tasks.addTask(2, new EntityAIMate(this, 1.0D));
        this.tasks.addTask(4, new EntityAIFollowParent(this, 1.25D));
        this.tasks.addTask(5, new EntityAIWanderAvoidWater(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
	}
	
	@Override
	protected void applyEntityAttributes() 
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(40.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
	}
	
	@Override
	public float getEyeHeight()
	{
		return 2.6F;
	}
	
	@Override
	public EntityCow createChild(EntityAgeable ageable) 
	{
		return new EntityStonemonster(world);
	}
	
	@Override
	protected ResourceLocation getLootTable() 
	{
		return LootTableHandler.STONEMONSTER;
	}
	
	@Override
	protected SoundEvent getAmbientSound() 
	{
		return SoundsHandler.ENTITY_STONEMONSTER_AMBIENT;
	}
	
	@Override
	protected SoundEvent getHurtSound(DamageSource source) 
	{
		return SoundsHandler.ENTITY_STONEMONSTER_HURT;
	}
	
	@Override
	protected SoundEvent getDeathSound() 
	{
		return SoundsHandler.ENTITY_STONEMONSTER_DEATH;
	}
}
*/
