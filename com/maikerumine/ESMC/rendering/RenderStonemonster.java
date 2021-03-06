package com.maikerumine.ESMC.rendering;

import com.maikerumine.ESMC.util.Reference;
import com.maikerumine.ESMC.entity.EntityStonemonster;
import com.maikerumine.ESMC.rendering.models.entities.ModelStonemonster;

import net.minecraft.client.renderer.entity.RenderLiving;   //needs to be sided?
import net.minecraft.client.renderer.entity.RenderManager;	//needs to be sided?
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderStonemonster extends RenderLiving<EntityStonemonster>
{
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/stonemonster.png");

	public RenderStonemonster(RenderManager manager) 
	{
		super(manager, new ModelStonemonster(), 0.5F);
	}
	
	@Override
	protected ResourceLocation func_110775_a(EntityStonemonster entity) 
	{
		return TEXTURES;
	}

	@Override
	protected void func_77043_a(EntityStonemonster entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
	{
		super.func_77043_a(entityLiving, p_77043_2_, rotationYaw, partialTicks);
	}
}
