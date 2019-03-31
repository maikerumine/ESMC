package com.maikerumine.ESMC.util.handlers;

import com.maikerumine.ESMC.blocks.tileentities.TileEntityEsmChest;
import com.maikerumine.ESMC.entity.EntityStonemonster;
import com.maikerumine.ESMC.init.ModBlocks;
import com.maikerumine.ESMC.rendering.RenderStonemonster;
import com.maikerumine.ESMC.util.Reference;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.client.model.ModelLoader;

@SideOnly(Side.CLIENT)		//20190330 WAS HOPING TO FIX RENDERING FROM SERVER PROBLEM.
public class RenderHandler 

{

	public static void registerEntityRenders()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityStonemonster.class, new IRenderFactory<EntityStonemonster>()		//DAMN SERVER CRASH
		{
			
			public Render<? super EntityStonemonster> createRenderFor(RenderManager manager) 
			{
				return new RenderStonemonster(manager);
			}
		});
	}

	public static void registerCustomMeshesAndStates()
	{
		ModelLoader.setCustomMeshDefinition(Item.func_150898_a(ModBlocks.TOXIC_WATER_FLUID), new ItemMeshDefinition() 
		{	
			
			public ModelResourceLocation func_178113_a(ItemStack stack) 
			{
				return new ModelResourceLocation("esm:toxic_water_fluid", "fluid");
			}
		});
		
		ModelLoader.setCustomStateMapper(ModBlocks.TOXIC_WATER_FLUID, new StateMapperBase() 
		{	
			
			protected ModelResourceLocation func_178132_a(IBlockState state)
			{
				return new ModelResourceLocation("esm:toxic_water_fluid", "fluid");
			}
		});
	}
	
	@SideOnly(Side.CLIENT)		//20190330 WAS HOPING TO FIX RENDERING FROM SERVER PROBLEM.
	public static void registerTileEntities()
	{
	//		GameRegistry.registerTileEntity(TileEntityEsmChest.class, new ResourceLocation(Reference.MOD_ID + ":esm_chest"));
			//NOTE:  Supressing this ---^ actually causes the chest to show...  hmmmm
			// TURNED OFF COMPLETELY FIXES VISIBILITY FROM SERVER TO CLIENT.		
	}
	
}
