package com.maikerumine.ESMC.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class AdminTntBlock extends BlockBase {

	public AdminTntBlock(String name, Material material) {
		super(name, material);
		func_149672_a(SoundType.field_185848_a);
		func_149711_c(5.0F);
		func_149752_b(15.0F);
		setHarvestLevel("axe", 3);
		func_149715_a(0.0F);
		//setLightOpacity(1);
		//setBlockUnbreakable();
	}
}