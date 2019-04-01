package com.maikerumine.ESMC.blocks.block_mt;

import com.maikerumine.ESMC.Main;
import com.maikerumine.ESMC.blocks.BlockBase;
import com.maikerumine.ESMC.blocks.BlockBaseMulti;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class LadderSteel extends BlockBase {

	public LadderSteel(String name, Material material, CreativeTabs tab) {
		super(name, material, Main.MINETEST);
		func_149672_a(SoundType.field_185852_e);
		func_149711_c(3.0F);
		func_149752_b(5.0F);
		setHarvestLevel("pickaxe", 2);
		func_149715_a(0.0F);
		//setLightOpacity(1);
		//setBlockUnbreakable();
//		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.4F);
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
	@Override			//added to make ladder work
    public boolean isLadder(IBlockState state, IBlockAccess world, BlockPos pos, EntityLivingBase entity) { return true; }


}
