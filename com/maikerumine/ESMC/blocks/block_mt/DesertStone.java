package com.maikerumine.ESMC.blocks.block_mt;

import java.util.Random;

import com.maikerumine.ESMC.Main;
import com.maikerumine.ESMC.blocks.BlockBase;
import com.maikerumine.ESMC.init.ModBlocks;
import com.maikerumine.ESMC.init.ModItems;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class DesertStone extends BlockBase {

	public DesertStone(String name, Material material, CreativeTabs tab) {
		super(name, material, Main.MINETEST);
		func_149672_a(SoundType.field_185851_d);
		func_149711_c(2.0F);
		func_149752_b(15.0F);
		setHarvestLevel("pickaxe", 0);
		func_149715_a(0.0F);
		//setLightOpacity(1);
		//setBlockUnbreakable();
	}
	
//	@Override
//	public Block getDrops() {
//		return ModBlocks.DESERT_COBBLE_BLOCK;
//	}
	

}
