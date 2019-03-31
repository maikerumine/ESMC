package com.maikerumine.ESMC.blocks.block_jt;

import com.maikerumine.ESMC.Main;
import com.maikerumine.ESMC.blocks.BlockBaseMulti;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class VendorDepositorBlock extends BlockBaseMulti {

	public VendorDepositorBlock(String name, Material material) {
		super(name, material, Main.JT);
		func_149672_a(SoundType.field_185848_a);
		func_149711_c(1.0F);
		func_149752_b(5.0F);
		setHarvestLevel("pickaxe", 0);
		func_149715_a(0.0F);
		//setLightOpacity(1);
		//setBlockUnbreakable();
	}
	
    /**
     * Called when the block is right clicked by a player.
     */
    public boolean func_180639_a(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        return false;
    }
}
