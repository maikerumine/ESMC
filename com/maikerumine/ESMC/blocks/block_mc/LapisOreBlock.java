package com.maikerumine.ESMC.blocks.block_mc;

import java.util.Random;

import com.maikerumine.ESMC.Main;
import com.maikerumine.ESMC.blocks.BlockBase;
import com.maikerumine.ESMC.init.ModItems;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDye;

public class LapisOreBlock extends BlockBase {

	public LapisOreBlock(String name, Material material, CreativeTabs tab) {
		super(name, material, Main.MINETEST);
		func_149672_a(SoundType.field_185851_d);
		func_149711_c(12.0F);
		func_149752_b(10.0F);
		setHarvestLevel("pickaxe", 2);
		func_149715_a(0.0F);
		//setLightOpacity(1);
		//setBlockUnbreakable();

	}
/*
	public int damageDropped(int par1)
	{
	return this.blockID == Block.oreLapis.blockID ? 4 : 0;
	}
*/	
//	@Override
//	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
//		return Item.DYE,"data": 4;
//		return Items.DYE;				//Hmmmmm  need to make drop blue dye  351:4
//		return Items.QUARTZ;
//	}

/*	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		//ItemStack greenDye = new ItemStack(Items.dye, 1, 2); 
//		return Block.getBlockFromName(name);
//		return Items.DYE;				//Hmmmmm  need to make drop blue dye  351:4
//		return Items.QUARTZ;

	}
	
	
	@Override
	public int quantityDropped (Random rand) {
		//return 3;
		int max = 4;
		int min = 1;
		return rand.nextInt(max) + min;
		
	}
	
	*/
}
