package com.maikerumine.ESMC.blocks.block_jt;

import com.maikerumine.ESMC.Main;
import com.maikerumine.ESMC.blocks.BlockBase;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class ProtectorBlock extends BlockBase {

	public ProtectorBlock(String name, Material material, CreativeTabs tab) {
		super(name, material, Main.JT);
		func_149672_a(SoundType.field_185848_a);
		func_149711_c(1.0F);
		func_149752_b(15.0F);
		setHarvestLevel("pickaxe", 0);
		func_149715_a(0.2F);
		//setLightOpacity(1);
		//setBlockUnbreakable();
	}
}
