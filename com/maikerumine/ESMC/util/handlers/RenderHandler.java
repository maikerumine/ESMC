package com.maikerumine.ESMC.util.handlers;

import com.maikerumine.ESMC.entity.EntityStonemonster;
import com.maikerumine.ESMC.init.ModBlocks;
import com.maikerumine.ESMC.rendering.RenderStonemonster;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.client.model.ModelLoader;




public class RenderHandler 
{
	public static void registerEntityRenders()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityStonemonster.class, new IRenderFactory<EntityStonemonster>()		//DAMN SERVER CRASH
		{
			@Override
			public Render<? super EntityStonemonster> createRenderFor(RenderManager manager) 
			{
				return new RenderStonemonster(manager);
			}
		});
	}
/**
	public static void registerCustomMeshesAndStates()
	{
		ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(ModBlocks.TOXIC_WATER_FLUID), new ItemMeshDefinition() 
		{	
			@Override
			public ModelResourceLocation getModelLocation(ItemStack stack) 
			{
				return new ModelResourceLocation("esm:toxic_water_fluid", "fluid");
			}
		});
		
		ModelLoader.setCustomStateMapper(ModBlocks.TOXIC_WATER_FLUID, new StateMapperBase() 
		{	
			@Override
			protected ModelResourceLocation getModelResourceLocation(IBlockState state)
			{
				return new ModelResourceLocation("esm:toxic_water_fluid", "fluid");
			}
		});
	}
*/	
	
	
}
