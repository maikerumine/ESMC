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
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderHandler 
{
	public static void registerEntityRenders()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityStonemonster.class, new IRenderFactory<EntityStonemonster>()
		{
			@Override
			public Render<? super EntityStonemonster> createRenderFor(RenderManager manager) 
			{
				return new RenderStonemonster(manager);
			}
		});
	}
	
	public static void registerCustomMeshesAndStates()
	{
		ModelLoader.setCustomMeshDefinition(Item.func_150898_a(ModBlocks.DEPLETED_URANIUM_ORE_BLOCK), new ItemMeshDefinition() 
		{	
			@Override
			public ModelResourceLocation func_178113_a(ItemStack stack) 
			{
				return new ModelResourceLocation("ESMC:toxic_water", "fluid");
			}
		});
		
		ModelLoader.setCustomStateMapper(ModBlocks.DEPLETED_URANIUM_ORE_BLOCK, new StateMapperBase() 
		{	
			@Override
			protected ModelResourceLocation func_178132_a(IBlockState state)
			{
				return new ModelResourceLocation("ESMC:toxic_water", "fluid");
			}
		});
	}
	
	
	
}
