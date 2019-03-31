package com.maikerumine.ESMC.blocks.block_jt;

import com.maikerumine.ESMC.Main;
import com.maikerumine.ESMC.blocks.BlockBase;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class LagBlock extends BlockBase {

	public LagBlock(String name, Material material, CreativeTabs tab) {
		super(name, material, Main.JT);
		func_149672_a(SoundType.field_185853_f);
		func_149711_c(20.0F);
		func_149752_b(25.0F);
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
	
    /**
     * Checks if a player or entity can use this block to 'climb' like a ladder.
     *
     * @param state The current state
     * @param world The current world
     * @param pos Block position in world
     * @param entity The entity trying to use the ladder, CAN be null.
     * @return True if the block should act like a ladder
     */
    public boolean isLadder(IBlockState state, IBlockAccess world, BlockPos pos, EntityLivingBase entity) { return false; }


}

