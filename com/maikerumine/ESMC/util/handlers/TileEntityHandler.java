package com.maikerumine.ESMC.util.handlers;

import com.maikerumine.ESMC.util.Reference;
import com.maikerumine.ESMC.blocks.tileentities.TileEntityEsmChest;
import com.maikerumine.ESMC.blocks.tileentities.TileEntitySinteringFurnace;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler 
{
		public static void registerTileEntities()
	{
					GameRegistry.registerTileEntity(TileEntityEsmChest.class, new ResourceLocation(Reference.MOD_ID + ":esm_chest"));
					GameRegistry.registerTileEntity(TileEntitySinteringFurnace.class, new ResourceLocation(Reference.MOD_ID + ":sintering_furnace"));
	}
}
