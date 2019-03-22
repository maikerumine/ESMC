package com.maikerumine.ESMC.init;

import com.maikerumine.ESMC.util.ModConfiguration;
import com.maikerumine.ESMC.world.dimensions.DimensionLibrary;
import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;

public class DimensionInit 
{
	public static final DimensionType DESERT = DimensionType.register("Desert", "_desert", ModConfiguration.DIMENSION_DESERT_ID, DimensionLibrary.class, false);
	
	public static void registerDimensions()
	{
		DimensionManager.registerDimension(ModConfiguration.DIMENSION_DESERT_ID, DESERT);
	}
}
