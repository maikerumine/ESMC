package com.maikerumine.ESMC.blocks;

import java.util.Random;

import com.maikerumine.ESMC.Main;
import com.maikerumine.ESMC.init.ModBlocks;
import com.maikerumine.ESMC.init.ModItems;
import com.maikerumine.ESMC.util.interfaces.IHasModel;
import com.maikerumine.ESMC.world.generation.generators.WorldGenAluminiumTree;
import com.maikerumine.ESMC.world.generation.generators.WorldGenCopperTree;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.TerrainGen;

public class BlockSaplingBase extends BlockBush implements IGrowable, IHasModel
{	
	public static final PropertyInteger STAGE = PropertyInteger.func_177719_a("stage", 0, 1);
    protected static final AxisAlignedBB SAPLING_AABB = new AxisAlignedBB(0.09999999403953552D, 0.0D, 0.09999999403953552D, 0.8999999761581421D, 0.800000011920929D, 0.8999999761581421D);
    private static String type;
    
    public BlockSaplingBase(String name) 
    {
		func_149663_c(name);
		setRegistryName(name);
		this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a(STAGE, Integer.valueOf(0)));
		func_149647_a(Main.TUT);
		
		type = name.replaceAll("_sapling", "").trim();
				
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
    
    //Sapling Shape
    @Override
    public AxisAlignedBB func_185496_a(IBlockState state, IBlockAccess source, BlockPos pos) 
    {
    	return SAPLING_AABB;
    }
    
    @Override
    public AxisAlignedBB func_180646_a(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) 
    {
    	return field_185506_k;
    }
    
    @Override
    public boolean func_149662_c(IBlockState state) 
    {
    	return false;
    }
    
    @Override
    public boolean func_149686_d(IBlockState state) 
    {
    	return false;
    }
    
    //Variants
	@Override
	public IBlockState func_176203_a(int meta) 
	{
		return this.func_176223_P().func_177226_a(STAGE, Integer.valueOf((meta & 8) >> 3));
	}
	
	@Override
	public int func_176201_c(IBlockState state)
	{
		int i = 0;
		i = i | ((Integer)state.func_177229_b(STAGE)).intValue() << 3;
		return i;
	}
	
	@Override
	protected BlockStateContainer func_180661_e() 
	{
		return new BlockStateContainer(this, new IProperty[] {STAGE});	
	}
	
	@Override
	public void registerModels() 
	{
		Main.proxy.registerModel(Item.func_150898_a(this), 0);
	}
	
	//Tree Code
	
	
	@Override
	public void func_176474_b(World worldIn, Random rand, BlockPos pos, IBlockState state) 
	{
		if(((Integer)state.func_177229_b(STAGE)).intValue() == 0)
		{
			worldIn.func_180501_a(pos, state.func_177231_a(STAGE), 4);
		}
		else
		{
			this.generateTree(worldIn, rand, pos, state);
		}
	}
	
	public void generateTree(World world, Random rand, BlockPos pos, IBlockState state)
	{
		if(!TerrainGen.saplingGrowTree(world, rand, pos)) return;
		WorldGenerator gen = (WorldGenerator)(rand.nextInt(10) == 0 ? new WorldGenBigTree(false) : new WorldGenTrees(false));
		boolean flag = false;
		int i = 0, j = 0;
		
		switch(type)
		{
		case "copper":
			gen = new WorldGenCopperTree();
			break;
		case "aluminium":
			gen = new WorldGenAluminiumTree();
			break;
		}
		
		IBlockState iblockstate = Blocks.field_150350_a.func_176223_P();
		if(flag)
		{
			world.func_180501_a(pos.func_177982_a(i, 0, j), iblockstate, 4);
			world.func_180501_a(pos.func_177982_a(i + 1, 0, j), iblockstate, 4);
			world.func_180501_a(pos.func_177982_a(i, 0, j + 1), iblockstate, 4);
			world.func_180501_a(pos.func_177982_a(i + 1, 0, j + 1), iblockstate, 4);
		}
		else
		{
			world.func_180501_a(pos, iblockstate, 4);
		}
		
		if(!gen.func_180709_b(world, rand, pos.func_177982_a(i, 0, j)))
		{
			if(flag)
			{
				world.func_180501_a(pos.func_177982_a(i, 0, j), iblockstate, 4);
				world.func_180501_a(pos.func_177982_a(i + 1, 0, j), iblockstate, 4);
				world.func_180501_a(pos.func_177982_a(i, 0, j + 1), iblockstate, 4);
				world.func_180501_a(pos.func_177982_a(i + 1, 0, j + 1), iblockstate, 4);
			}
			else
			{
				world.func_180501_a(pos, iblockstate, 4);
			}
		}
	}
	
	@Override
	public boolean func_176473_a(World worldIn, BlockPos pos, IBlockState state, boolean isClient)
	{
		return true;
	}
	
	@Override
	public boolean func_180670_a(World worldIn, Random rand, BlockPos pos, IBlockState state) 
	{
		return (double)worldIn.field_73012_v.nextFloat() < 0.45D;
	}
	
	@Override
	protected boolean func_185514_i(IBlockState state) 
	{
		return state.func_185904_a() == Material.field_151578_c || state.func_185904_a() == Material.field_151577_b || state.func_185904_a() == Material.field_151585_k
				
				;
	}
}
