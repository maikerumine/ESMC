package com.maikerumine.ESMC.blocks.block_esm;

import java.util.Random;

import com.maikerumine.ESMC.Main;
import com.maikerumine.ESMC.blocks.BlockBase;
import com.maikerumine.ESMC.init.ModItems;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class DepletedUraniumOreBlock extends BlockBase {

	public DepletedUraniumOreBlock(String name, Material material, CreativeTabs tab) {
		super(name, material, Main.ESM);
		func_149672_a(SoundType.field_185851_d);
		func_149711_c(3.0F);
		func_149752_b(10.0F);
		setHarvestLevel("pickaxe", 2);
		func_149715_a(0.3F);
		//setLightOpacity(1);
		//setBlockUnbreakable();
	}
	@Override
	public Item func_180660_a(IBlockState state, Random rand, int fortune) {
		return ModItems.DEPLETED_URANIUM_LUMP;
	}
	
	@Override
	public int func_149745_a (Random rand) {
		//return 3;
		int max = 1;
		int min = 1;
		return rand.nextInt(max) + min;
		
	}
}
