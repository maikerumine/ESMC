package com.maikerumine.ESMC.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class MeselampBlock extends BlockBase {

	public MeselampBlock(String name, Material material) {
		super(name, material);
		func_149672_a(SoundType.field_185853_f);
		func_149711_c(5.0F);
		func_149752_b(15.0F);
		setHarvestLevel("pickaxe", 2);
		func_149715_a(1.0F);
		//setLightOpacity(1);
		//setBlockUnbreakable();
	}
}