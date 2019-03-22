package com.maikerumine.ESMC.blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.maikerumine.ESMC.Main;
import com.maikerumine.ESMC.init.ModBlocks;
import com.maikerumine.ESMC.init.ModItems;
import com.maikerumine.ESMC.util.interfaces.IHasModel;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockPlanks.EnumType;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;

public class BlockLeavesBase extends BlockLeaves implements IHasModel
{		
	public static String type;
	
	public BlockLeavesBase(String name) 
	{
		type = name.replaceAll("_leaves", "").trim();
		System.out.println(type);
		
		func_149663_c(name);
		setRegistryName(name);
		func_149672_a(SoundType.field_185850_c);
		func_149647_a(Main.TUT);
		func_180632_j(this.field_176227_L.func_177621_b().func_177226_a(field_176236_b, Boolean.valueOf(true)).func_177226_a(field_176237_a, Boolean.valueOf(true)));
				
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public Item func_180660_a(IBlockState state, Random rand, int fortune) 
	{
		if(type == "copper") return Item.func_150898_a(ModBlocks.COPPER_SAPLING);
		else if(type == "aluminium") return Item.func_150898_a(ModItems.ALUMINIUM_SAPLING);
		else return Item.func_150898_a(Blocks.field_150345_g);
	}
	
	@Override
	public int func_176201_c(IBlockState state) 
	{
		int i = 0;
		if(!((Boolean)state.func_177229_b(field_176237_a)).booleanValue()) i |= 2;
		if(!((Boolean)state.func_177229_b(field_176236_b)).booleanValue()) i|= 4;
		return i;
	}
	
	@Override
	protected ItemStack func_180643_i(IBlockState state) 
	{
		return new ItemStack(this);
	}
	
	@Override
	protected void func_176234_a(World worldIn, BlockPos pos, IBlockState state, int chance) {return;}
	
	@Override
	protected int func_176232_d(IBlockState state) {return 30;}
	
	@Override
	public EnumType func_176233_b(int meta) {return null;}
	
	@Override
	public List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune) 
	{
		return NonNullList.func_191197_a(1, new ItemStack(this));
	}
	
	@Override
	public boolean func_149662_c(IBlockState state) 
	{
		return false;
	}
	
	@Override
	protected BlockStateContainer func_180661_e() 
	{
		return new BlockStateContainer(this, new IProperty[] {field_176236_b, field_176237_a});
	}
	
	@Override
	public BlockRenderLayer func_180664_k() 
	{
		return BlockRenderLayer.TRANSLUCENT;
	}	
	
	@Override
	public void registerModels() 
	{
		Main.proxy.registerModel(Item.func_150898_a(this), 0);
	}
}
