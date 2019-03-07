package com.maikerumine.ESMC.blocks.slabs;

import java.util.Random;

import com.maikerumine.ESMC.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import net.minecraft.block.BlockSlab.EnumBlockHalf;

public abstract class BlockSlabBase extends BlockSlab
{
	Block half;
	public static final PropertyEnum<Variant> VARIANT = PropertyEnum.<Variant>func_177709_a("variant", Variant.class);
	
	public BlockSlabBase(String name, Material materialIn, CreativeTabs tab, BlockSlab half) 
	{
		super(materialIn);
		func_149663_c(name);
		setRegistryName(name);
		func_149647_a(tab);
		this.field_149783_u = !this.func_176552_j();
		
		IBlockState state = this.field_176227_L.func_177621_b().func_177226_a(VARIANT, Variant.DEFAULT);
		if(!this.func_176552_j()) state = state.func_177226_a(field_176554_a, EnumBlockHalf.BOTTOM);
		func_180632_j(state);
		
		this.half = half;
		
		ModBlocks.BLOCKS.add(this);
	}

	@Override
	public Item func_180660_a(IBlockState state, Random rand, int fortune)
	{
		return Item.func_150898_a(half);
	}
	
	@Override
	public ItemStack func_185473_a(World worldIn, BlockPos pos, IBlockState state) 
	{
		return new ItemStack(half);
	}
	
	@Override
	public IBlockState func_176203_a(int meta) 
	{
		IBlockState state = this.field_176227_L.func_177621_b().func_177226_a(VARIANT, Variant.DEFAULT);
		if(!this.func_176552_j()) state = state.func_177226_a(field_176554_a, ((meta&8) != 0) ? EnumBlockHalf.TOP : EnumBlockHalf.BOTTOM);
		return state;
	}
	
	@Override
	public int func_176201_c(IBlockState state) 
	{
		int meta = 0;
		if(!this.func_176552_j() && state.func_177229_b(field_176554_a) == EnumBlockHalf.TOP) meta |= 8;
		return meta;
	}
	
	@Override
	protected BlockStateContainer func_180661_e() 
	{
		if(!this.func_176552_j()) return new BlockStateContainer(this, new IProperty[] {VARIANT,field_176554_a});
		else return new BlockStateContainer(this, new IProperty[] {VARIANT});
	}
	
	@Override
	public String func_150002_b(int meta) 
	{
		return super.func_149739_a();
	}
	
	@Override
	public IProperty<?> func_176551_l()
	{
		return VARIANT;
	}
	
	@Override
	public Comparable<?> func_185674_a(ItemStack stack) 
	{
		return Variant.DEFAULT;
	}
	
	public static enum Variant implements IStringSerializable
	{
		DEFAULT;
		
		@Override
		public String func_176610_l()
		{
			return "default";
		}
	}
}
