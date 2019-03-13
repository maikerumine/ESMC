package com.maikerumine.ESMC.blocks;

import com.maikerumine.ESMC.util.Reference;
import com.maikerumine.ESMC.util.interfaces.IHasModel;
import com.maikerumine.ESMC.Main;
import com.maikerumine.ESMC.init.ModBlocks;
import com.maikerumine.ESMC.init.ModItems;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBaseGlass1 extends Block implements IHasModel
{
	public BlockBaseGlass1(String name, Material material, CreativeTabs tab)
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
	public boolean func_149662_c(IBlockState state) 
	{
		return false;
	}
	
	//@Override
	public boolean isVisuallyOpaque(IBlockState state) 
	{
		return false;
	}
	
	
	@Override
	public boolean func_149751_l(IBlockState state) 
	{
		return true;
	}
	
	@Override
	public boolean func_149686_d(IBlockState state) 
	{
		return false;
	}

	@Override
	public void registerModels() {
		//Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
		Main.proxy.registerModel(Item.func_150898_a(this), 0);
		
	}
	
	
}
