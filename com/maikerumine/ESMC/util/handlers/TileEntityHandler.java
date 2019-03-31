package com.maikerumine.ESMC.util.handlers;

import com.maikerumine.ESMC.util.Reference;
import com.maikerumine.ESMC.blocks.tileentities.TileEntityEsmChest;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TileEntityHandler 
{
		@SideOnly(Side.CLIENT)		//20190330 WAS HOPING TO FIX RENDERING FROM SERVER PROBLEM.
		public static void registerTileEntities()
	{
			GameRegistry.registerTileEntity(TileEntityEsmChest.class, new ResourceLocation(Reference.MOD_ID + ":esm_chest"));
			//NOTE:  Supressing this ---^ actually causes the chest to show...  hmmmm
			// TURNED OFF COMPLETELY FIXES VISIBILITY FROM SERVER TO CLIENT.		
	}
}
