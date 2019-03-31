package com.maikerumine.ESMC.blocks.block_jt;

import com.maikerumine.ESMC.Main;
import com.maikerumine.ESMC.blocks.BlockBase;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class AdminTntBlock extends BlockBase {

	public AdminTntBlock(String name, Material material, CreativeTabs tab) {
		super(name, material, Main.JT);
		func_149672_a(SoundType.field_185848_a);
		func_149711_c(3.0F);
		func_149752_b(15.0F);
		setHarvestLevel("axe", 3);
		func_149715_a(0.0F);
		//setLightOpacity(1);
		//setBlockUnbreakable();
	}
}
