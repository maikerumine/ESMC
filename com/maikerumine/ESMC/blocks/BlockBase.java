package com.maikerumine.ESMC.blocks;

import com.maikerumine.ESMC.Main;
import com.maikerumine.ESMC.init.ModBlocks;
import com.maikerumine.ESMC.init.ModItems;
import com.maikerumine.ESMC.util.interfaces.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements IHasModel 
{
	public BlockBase(String name, Material material, CreativeTabs tab)
	{
		super(material);
		func_149663_c(name);
		setRegistryName(name);
		//setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		func_149647_a(tab);
		
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	@Override
	public void registerModels() 
	{
		//Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");		//From Lore
		Main.proxy.registerModel(Item.func_150898_a(this), 0);  //from Harrys tut
		
	}
}
