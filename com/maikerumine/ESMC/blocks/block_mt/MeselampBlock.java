package com.maikerumine.ESMC.blocks.block_mt;

import com.maikerumine.ESMC.Main;
import com.maikerumine.ESMC.blocks.BlockBase;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class MeselampBlock extends BlockBase {

	public MeselampBlock(String name, Material material, CreativeTabs tab) {
		super(name, material, Main.MINETEST);
		func_149672_a(SoundType.field_185853_f);
		func_149711_c(1.0F);
		func_149752_b(7.0F);
		setHarvestLevel("pickaxe", 0);
		func_149715_a(1.0F);
		//setLightOpacity(1);
		//setBlockUnbreakable();
	}
}
