package com.maikerumine.ESMC.blocks.slabs;

import com.maikerumine.ESMC.Main;
import com.maikerumine.ESMC.init.ModItems;
import com.maikerumine.ESMC.items.ItemBase;
import com.maikerumine.ESMC.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSlab;

public class BlockSlabHalfBase extends BlockSlabBase implements IHasModel
{
	public BlockSlabHalfBase(String name, Material materialIn, CreativeTabs tab, BlockSlab half, BlockSlab doubleSlab)
	{
		super(name, materialIn, tab, half);
		
		ModItems.ITEMS.add(new ItemSlab(this, this, doubleSlab).setRegistryName(name));
	}
	
	@Override
	public boolean func_176552_j() 
	{
		return false;
	}

	@Override
	public void registerModels() 
	{
		Main.proxy.registerModel(Item.func_150898_a(this), 0);
	}
}
