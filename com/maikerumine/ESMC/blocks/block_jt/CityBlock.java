package com.maikerumine.ESMC.blocks.block_jt;

import com.maikerumine.ESMC.Main;
import com.maikerumine.ESMC.blocks.BlockBase;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.BlockRenderLayer;

public class CityBlock extends BlockBase {

	public CityBlock(String name, Material material, CreativeTabs tab) {
		super(name, material, Main.JT);
		func_149672_a(SoundType.field_185853_f);
		func_149711_c(3.0F);
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
