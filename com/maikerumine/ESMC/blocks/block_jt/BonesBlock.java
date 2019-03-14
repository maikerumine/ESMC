package com.maikerumine.ESMC.blocks.block_jt;

import com.maikerumine.ESMC.Main;
import com.maikerumine.ESMC.blocks.BlockBaseMulti;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BonesBlock extends BlockBaseMulti {

	public BonesBlock(String name, Material material) {
		super(name, material, Main.JT);
		func_149672_a(SoundType.field_185852_e);
		func_149711_c(5.0F);
		func_149752_b(15.0F);
		setHarvestLevel("pickaxe", 2);
		func_149715_a(0.0F);
		//setLightOpacity(1);
		//setBlockUnbreakable();
	}
}
