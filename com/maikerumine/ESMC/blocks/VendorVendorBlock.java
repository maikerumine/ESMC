package com.maikerumine.ESMC.blocks;

import com.maikerumine.ESMC.Main;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class VendorVendorBlock extends BlockBaseMulti {

	public VendorVendorBlock(String name, Material material) {
		super(name, material, Main.ESM);
		func_149672_a(SoundType.field_185848_a);
		func_149711_c(1.0F);
		func_149752_b(5.0F);
		setHarvestLevel("pickaxe", 0);
		func_149715_a(0.0F);
		//setLightOpacity(1);
		//setBlockUnbreakable();
	}
}
