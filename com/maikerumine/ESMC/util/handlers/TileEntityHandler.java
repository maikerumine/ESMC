package com.maikerumine.ESMC.util.handlers;

import com.maikerumine.ESMC.Reference;
import com.maikerumine.ESMC.blocks.tileentities.TileEntityEsmChest;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler 
{
	public static void registerTileEntities()
	{
		GameRegistry.registerTileEntity(TileEntityEsmChest.class, new ResourceLocation(Reference.MODID + ":esm_chest"));
	}
}
