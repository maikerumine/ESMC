package com.maikerumine.ESMC.blocks;

import com.maikerumine.ESMC.Main;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class MeseBlock extends BlockBase {

	public MeseBlock(String name, Material material, CreativeTabs tab) {
		super(name, material, Main.MINETEST);
		func_149672_a(SoundType.field_185852_e);
		func_149711_c(9.0F);
		func_149752_b(25.0F);
		setHarvestLevel("pickaxe", 4);
		func_149715_a(1.0F);
		//setLightOpacity(1);
		//setBlockUnbreakable();
	}
}
