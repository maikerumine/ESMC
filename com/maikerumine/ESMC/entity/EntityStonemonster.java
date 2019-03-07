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
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityStonemonster extends EntityZombie
{
	public EntityStonemonster(World worldIn) 
	{
		super(worldIn);
		this.func_70105_a(0.9F, 2.8F);
	}
	
	@Override
	protected void func_184651_r()
	{
		this.field_70714_bg.func_75776_a(0, new EntityAISwimming(this));
        this.field_70714_bg.func_75776_a(1, new EntityAIPanic(this, 2.0D));
        //this.tasks.addTask(2, new EntityAIMate(this, 1.0D));
        this.field_70714_bg.func_75776_a(3, new EntityAITempt(this, 1.25D, ModItems.PURPELLIUM_SPADE, false));
        //this.tasks.addTask(4, new EntityAIFollowParent(this, 1.25D));
        this.field_70714_bg.func_75776_a(5, new EntityAIWanderAvoidWater(this, 1.0D));
        this.field_70714_bg.func_75776_a(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.field_70714_bg.func_75776_a(7, new EntityAILookIdle(this));
	}
	
	@Override
	protected void func_110147_ax() 
	{
		super.func_110147_ax();
		this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(40.0D);
		this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.25D);
	}
	
	@Override
	public float func_70047_e()
	{
		return 2.6F;
	}
	
	
	@Override
	protected ResourceLocation func_184647_J() 
	{
		return LootTableHandler.STONEMONSTER;
	}
	
	@Override
	protected SoundEvent func_184639_G() 
	{
		return SoundsHandler.ENTITY_STONEMONSTER_AMBIENT;
	}
	
	@Override
	protected SoundEvent func_184601_bQ(DamageSource source) 
	{
		return SoundsHandler.ENTITY_STONEMONSTER_HURT;
	}
	
	@Override
	protected SoundEvent func_184615_bR() 
	{
		return SoundsHandler.ENTITY_STONEMONSTER_DEATH;
	}
}
