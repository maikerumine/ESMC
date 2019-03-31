package com.maikerumine.ESMC.blocks.block_jt;

import java.util.Random;

import com.maikerumine.ESMC.Main;
import com.maikerumine.ESMC.blocks.BlockBase;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class CursedStoneBlock extends BlockBase {

	public CursedStoneBlock(String name, Material material, CreativeTabs tab) {
		super(name, material, Main.JT);
		func_149672_a(SoundType.field_185848_a);
		func_149711_c(3.0F);
		func_149752_b(5.0F);
		setHarvestLevel("pickaxe", 3);
		func_149715_a(0.0F);
		//setLightOpacity(1);
		//setBlockUnbreakable();
	}
	
	@Override
	public Item func_180660_a(IBlockState state, Random rand, int fortune) {
		return Items.field_151043_k;
	}
	
	@Override
	public int func_149745_a (Random rand) {
		return 9;
		//int max = 3;
		//int min = 1;
		//return rand.nextInt(max) + min;
		
	}
}
