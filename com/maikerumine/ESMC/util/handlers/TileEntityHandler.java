package com.maikerumine.ESMC.util.handlers;

import com.maikerumine.ESMC.util.Reference;
import com.maikerumine.ESMC.blocks.tileentities.TileEntityEsmChest;
import com.maikerumine.ESMC.blocks.tileentities.TileEntitySinteringFurnace;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
@SideOnly(Side.CLIENT)
public class TileEntityHandler 
{
	
		public static void registerTileEntities()
	{
			
					GameRegistry.registerTileEntity(TileEntityEsmChest.class, new ResourceLocation(Reference.MOD_ID + ":esm_chest"));
			//NOTE:  Supressing this ---^ actually causes the chest to show...  hmmmm
			// TURNED OFF COMPLETELY FIXES VISIBILITY FROM SERVER TO CLIENT.		
			
			
//					GameRegistry.registerTileEntity(TileEntitySinteringFurnace.class, new ResourceLocation(Reference.MOD_ID + ":sintering_furnace"));
	}
}
