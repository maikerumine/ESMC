package com.maikerumine.ESMC.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class NyancatBlock extends BlockBaseMulti {

	public NyancatBlock(String name, Material material) {
		super(name, material);
		func_149672_a(SoundType.field_185854_g);
		func_149711_c(1.0F);
		func_149752_b(15.0F);
		setHarvestLevel("pickaxe", 0);
		func_149715_a(1.0F);
		//setLightOpacity(1);
		//setBlockUnbreakable();
	}
}
