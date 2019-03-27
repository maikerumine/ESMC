package com.maikerumine.ESMC.blocks.machines;

import java.util.Random;

import com.maikerumine.ESMC.Main;
import com.maikerumine.ESMC.blocks.BlockBase;
import com.maikerumine.ESMC.blocks.tileentities.TileEntitySinteringFurnace;
import com.maikerumine.ESMC.init.ModBlocks;
import com.maikerumine.ESMC.util.Reference;

import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockSinteringFurnace extends BlockBase
{
	public static final PropertyDirection FACING = BlockHorizontal.field_185512_D;
	public static final PropertyBool BURNING = PropertyBool.func_177716_a("burning");
	
	public BlockSinteringFurnace(String name) 
	{
		super(name, Material.field_151573_f, Main.TUT);
		func_149672_a(SoundType.field_185852_e);
		this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a(FACING, EnumFacing.NORTH).func_177226_a(BURNING, false));
	}
/**	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) 
	{
		return Item.getItemFromBlock(ModBlocks.SINTERING_FURNACE);
	}
	
	@Override
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
	{
		return new ItemStack(ModBlocks.SINTERING_FURNACE);
	}
*/	
	@Override
	public boolean func_180639_a(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) 
	{
		if(!worldIn.field_72995_K)
		{
			playerIn.openGui(Main.instance, Reference.GUI_SINTERING_FURNACE, worldIn, pos.func_177958_n(), pos.func_177956_o(), pos.func_177952_p());
		}
		
		return true;
	}
	
	@Override
	public void func_176213_c(World worldIn, BlockPos pos, IBlockState state) 
	{
		if (!worldIn.field_72995_K) 
        {
            IBlockState north = worldIn.func_180495_p(pos.func_177978_c());
            IBlockState south = worldIn.func_180495_p(pos.func_177968_d());
            IBlockState west = worldIn.func_180495_p(pos.func_177976_e());
            IBlockState east = worldIn.func_180495_p(pos.func_177974_f());
            EnumFacing face = (EnumFacing)state.func_177229_b(FACING);

            if (face == EnumFacing.NORTH && north.func_185913_b() && !south.func_185913_b()) face = EnumFacing.SOUTH;
            else if (face == EnumFacing.SOUTH && south.func_185913_b() && !north.func_185913_b()) face = EnumFacing.NORTH;
            else if (face == EnumFacing.WEST && west.func_185913_b() && !east.func_185913_b()) face = EnumFacing.EAST;
            else if (face == EnumFacing.EAST && east.func_185913_b() && !west.func_185913_b()) face = EnumFacing.WEST;
            worldIn.func_180501_a(pos, state.func_177226_a(FACING, face), 2);
        }
	}
	
	public static void setState(boolean active, World worldIn, BlockPos pos) 
	{
		IBlockState state = worldIn.func_180495_p(pos);
		TileEntity tileentity = worldIn.func_175625_s(pos);
		
		//if(active) worldIn.setBlockState(pos, BlockInit.SINTERING_FURNACE.getDefaultState().withProperty(FACING, state.getValue(FACING)).withProperty(BURNING, true), 3);
		//else worldIn.setBlockState(pos, BlockInit.SINTERING_FURNACE.getDefaultState().withProperty(FACING, state.getValue(FACING)).withProperty(BURNING, false), 3);
		
		if(tileentity != null) 
		{
			tileentity.func_145829_t();
			worldIn.func_175690_a(pos, tileentity);
		}
	}
	
	@Override
	public boolean hasTileEntity(IBlockState state) 
	{
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(World world, IBlockState state) 
	{
		return new TileEntitySinteringFurnace();
	}
	
	@Override
	public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand) 
	{
		return this.func_176223_P().func_177226_a(FACING, placer.func_174811_aO().func_176734_d());
	}
	
	@Override
	public void func_180633_a(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) 
	{
		worldIn.func_180501_a(pos, this.func_176223_P().func_177226_a(FACING, placer.func_174811_aO().func_176734_d()), 2);
	}
	
	@Override
	public EnumBlockRenderType func_149645_b(IBlockState state) 
	{
		return EnumBlockRenderType.MODEL;
	}
	
	@Override
	public IBlockState func_185499_a(IBlockState state, Rotation rot)
	{
		return state.func_177226_a(FACING, rot.func_185831_a((EnumFacing)state.func_177229_b(FACING)));
	}
	
	@Override
	public IBlockState func_185471_a(IBlockState state, Mirror mirrorIn) 
	{
		return state.func_185907_a(mirrorIn.func_185800_a((EnumFacing)state.func_177229_b(FACING)));
	}
	
	@Override
	protected BlockStateContainer func_180661_e() 
	{
		return new BlockStateContainer(this, new IProperty[] {BURNING,FACING});
	}
	
	@Override
	public IBlockState func_176203_a(int meta) 
	{
		EnumFacing facing = EnumFacing.func_82600_a(meta);
		if(facing.func_176740_k() == EnumFacing.Axis.Y) facing = EnumFacing.NORTH;
		return this.func_176223_P().func_177226_a(FACING, facing);
	}
	
	@Override
	public int func_176201_c(IBlockState state) 
	{
		return ((EnumFacing)state.func_177229_b(FACING)).func_176745_a();
	}	
}
