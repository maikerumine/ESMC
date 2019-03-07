package com.maikerumine.ESMC.blocks;

import com.maikerumine.ESMC.init.ModBlocks;
import com.maikerumine.ESMC.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class BlockFluid extends BlockFluidClassic 
{
	public BlockFluid(String name, Fluid fluid, Material material)
	{
		super(fluid, material);
		func_149663_c(name);
		setRegistryName(name);
		
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(name));
	}

	@Override
	public EnumBlockRenderType func_149645_b(IBlockState state) 
	{
		return EnumBlockRenderType.MODEL;
	}
}
