package com.maikerumine.ESMC.blocks.block_mt;

import com.maikerumine.ESMC.Main;
import com.maikerumine.ESMC.blocks.BlockBase;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;

public class ObsidianBrickBlock extends BlockBase {
//public class ObsidianBrickBlock extends BlockBaseGlass {

	public ObsidianBrickBlock(String name, Material material, CreativeTabs tab) {
		super(name, material, Main.MINETEST);
		func_149672_a(SoundType.field_185851_d);
		func_149711_c(7.0F);
		func_149752_b(25.0F);
		setHarvestLevel("pickaxe", 4);
		func_149715_a(0.0F);
		func_149713_g(0);
		
		//setBlockUnbreakable();
/*	    @Deprecated
	    public boolean isOpaqueCube(IBlockState state)
	    {
	        return true;
	    }
	    
	    registerBlock(20, "glass", (new BlockGlass(Material.GLASS, false)).setHardness(0.3F).setSoundType(SoundType.GLASS).setUnlocalizedName("glass"));
	    
**/
		
		
		
		
	}
}

