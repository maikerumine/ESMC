package com.maikerumine.ESMC.creativetabs;

import com.maikerumine.ESMC.init.ModBlocks;
import com.maikerumine.ESMC.init.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class Minetest extends CreativeTabs
{
	public Minetest() 
	{
		super("Minetest");
	}

	@Override
	public ItemStack func_78016_d() 
	{
		return new ItemStack(ModBlocks.MESE_BLOCK);
	}
}

