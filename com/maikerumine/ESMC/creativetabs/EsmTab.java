package com.maikerumine.ESMC.creativetabs;

import com.maikerumine.ESMC.init.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class EsmTab extends CreativeTabs
{
	public EsmTab() 
	{
		super("Extreme Survival");
	}

	@Override
	public ItemStack func_78016_d() 
	{
		return new ItemStack(ModItems.AIKERUM_CRYSTAL);
	}
}
