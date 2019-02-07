package com.maikerumine.ESMC.blocks;

import com.maikerumine.ESMC.util.IHasModel;
import com.maikerumine.ESMC.util.Reference;
import com.maikerumine.ESMC.Main;
import com.maikerumine.ESMC.init.ModBlocks;
import com.maikerumine.ESMC.init.ModItems;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;

public class BlockBaseGlass1 extends Block implements IHasModel
{
	public BlockBaseGlass1(String name, Material material)
	{
		//super(Material.GLASS);//Attempt to get it to draw the transparent parts properly, didn't work
		super(material);
		func_149663_c(name);
		setRegistryName(name);
		func_149647_a(CreativeTabs.field_78030_b);
		
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
		// TODO Auto-generated method stub
		
	}
}
