package com.maikerumine.ESMC.blocks.block_mt;

import com.maikerumine.ESMC.Main;
import com.maikerumine.ESMC.blocks.BlockBaseMulti;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class RainbowBlock extends BlockBaseMulti {

	public RainbowBlock(String name, Material material) {
		super(name, material, Main.MINETEST);
		func_149672_a(SoundType.field_185854_g);
		func_149711_c(1.0F);
		func_149752_b(15.0F);
		setHarvestLevel("pickaxe", 2);
		func_149715_a(1.0F);
		//setLightOpacity(1);
		//setBlockUnbreakable();
	}
}
