package com.maikerumine.ESMC.creativetabs;

import com.maikerumine.ESMC.init.ModBlocks;
import com.maikerumine.ESMC.init.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class Esm extends CreativeTabs
{
	public Esm() 
	{
		super("Esm");
	}

	@Override
	public ItemStack func_78016_d() 
	{
		return new ItemStack(ModItems.AIKERUM_CRYSTAL);
	}
}
