package com.maikerumine.ESMC.init;

import com.maikerumine.ESMC.fluids.FluidLiquid;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class FluidInit
{
	public static final Fluid TOXIC_WATER_FLUID = new FluidLiquid("toxic_water_fluid", new ResourceLocation("esm:blocks/toxic_water_source_fluid_animated"), new ResourceLocation("esm:blocks/toxic_water_flowing_fluid_animated"));

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
