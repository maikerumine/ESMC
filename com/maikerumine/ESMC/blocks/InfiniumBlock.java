package com.maikerumine.ESMC.blocks;

import com.maikerumine.ESMC.Main;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class InfiniumBlock extends BlockBase {

	public InfiniumBlock(String name, Material material, CreativeTabs tab) {
		super(name, material, Main.ESM);
		func_149672_a(SoundType.field_185851_d);
		func_149711_c(8.0F);
		func_149752_b(15.0F);
		setHarvestLevel("pickaxe", 3);
		func_149715_a(0.0F);
		//setLightOpacity(1);
		//setBlockUnbreakable();
	}
}
