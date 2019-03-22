package com.maikerumine.ESMC.blocks;

import com.maikerumine.ESMC.Main;
import com.maikerumine.ESMC.init.ModBlocks;
import com.maikerumine.ESMC.init.ModItems;
import com.maikerumine.ESMC.util.interfaces.IHasModel;
import net.minecraft.block.BlockLog;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import net.minecraft.block.BlockLog.EnumAxis;

public class BlockLogBase extends BlockLog implements IHasModel
{
	public BlockLogBase(String name) 
	{
		func_149663_c(name);
		setRegistryName(name);
		func_149672_a(SoundType.field_185848_a);
		func_180632_j(this.field_176227_L.func_177621_b().func_177226_a(field_176299_a, EnumAxis.Y));
		func_149647_a(Main.TUT);
				
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public IBlockState func_176203_a(int meta) 
	{
		IBlockState state = this.func_176223_P();
		
		switch(meta & 6)
		{
		case 0:
			state = state.func_177226_a(field_176299_a, EnumAxis.Y);
			break;
			
		case 2:
			state = state.func_177226_a(field_176299_a, EnumAxis.X);
			break;
			
		case 4:
			state = state.func_177226_a(field_176299_a, EnumAxis.Z);
			break;
			
		default:
			state = state.func_177226_a(field_176299_a, EnumAxis.NONE);
		}
		
		return state;
	}
	
	@SuppressWarnings("incomplete-switch")
	@Override
	public int func_176201_c(IBlockState state) 
	{
		int i = 0;
		
		switch((BlockLog.EnumAxis)state.func_177229_b(field_176299_a))
		{
		case X:
			i |= 2;
			break;
			
		case Y:
			i |= 4;
			break;
			
		case Z:
			i |= 6;
		}
		
		return i;
	}
	
	@Override
	protected BlockStateContainer func_180661_e() 
	{
		return new BlockStateContainer(this, new IProperty[] {field_176299_a});
	}
	
	@Override
	protected ItemStack func_180643_i(IBlockState state) 
	{
		return new ItemStack(this);
	}
	
	@Override
	public void registerModels() 
	{
		Main.proxy.registerModel(Item.func_150898_a(this), 0);
	}	
}
