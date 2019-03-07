package com.maikerumine.ESMC.init;

import com.maikerumine.ESMC.fluids.FluidLiquid;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class FluidInit
{
	public static final Fluid TOXIC_WATER_FLUID = new FluidLiquid("toxic_water", new ResourceLocation("esm:blocks/toxic_water_block"), new ResourceLocation("tutorial:blocks/toxic_water_flowing_block_animated"));

	public static void registerFluids()
	{
		registerFluid(TOXIC_WATER_FLUID);
	}
	
	public static void registerFluid(Fluid fluid)
	{
		FluidRegistry.registerFluid(fluid);
		FluidRegistry.addBucketForFluid(fluid);
	}
}
