package com.maikerumine.ESMC.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;

public class TeleportBlock extends BlockBase {

	public TeleportBlock(String name, Material material) {
		super(name, material);
		func_149672_a(SoundType.field_185853_f);
		func_149711_c(5.0F);
		func_149752_b(15.0F);
		setHarvestLevel("pickaxe", 3);
		func_149715_a(1.0F);
		func_149713_g(0);
	}

@Override
public boolean func_149662_c(IBlockState state)
{
    return false;
}

//@Override
public boolean isVisuallyOpaque(IBlockState state)
{
    return false;
}


@Override
public boolean func_149751_l(IBlockState state) 
{
	return true;
}

@Override

public boolean func_149686_d(IBlockState state) 
{ 
	return false; 
}



@Override
public BlockRenderLayer func_180664_k() 
{
	return BlockRenderLayer.CUTOUT;
}

}