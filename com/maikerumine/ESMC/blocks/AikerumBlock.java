package com.maikerumine.ESMC.blocks;

import com.maikerumine.ESMC.Main;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class AikerumBlock extends BlockBase {

	public AikerumBlock(String name, Material material, CreativeTabs tab) {
		super(name, material, Main.ESM);
		func_149672_a(SoundType.field_185853_f);
		func_149711_c(5.0F);
		func_149752_b(15.0F);
		setHarvestLevel("pickaxe", 3);
		func_149715_a(1.0F);
		//setLightOpacity(1);
		//setBlockUnbreakable();
	}
}
