package com.maikerumine.ESMC.blocks;

import com.maikerumine.ESMC.Main;
import com.maikerumine.ESMC.util.Reference;
import com.maikerumine.ESMC.blocks.tileentities.TileEntityEsmChest;
import com.maikerumine.ESMC.init.ModBlocks;
import com.maikerumine.ESMC.init.ModItems;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockEsmChest extends BlockContainer
{
	public BlockEsmChest(String name) 
	{
		super(Material.field_151573_f);
		func_149663_c(name);
		setRegistryName(name);
		func_149647_a(Main.ESM);
		
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(name));
	}
	
	@Override
	public boolean func_180639_a(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) 
	{
		if(!worldIn.field_72995_K)
		{
//			playerIn.openGui(Main.instance, Reference.GUI_ESM_CHEST, worldIn, pos.getX(), pos.getY(), pos.getZ());
		}
		
		return true;
	}
	
	@Override
	public void func_180663_b(World worldIn, BlockPos pos, IBlockState state) 
	{
		TileEntityEsmChest tileentity = (TileEntityEsmChest)worldIn.func_175625_s(pos);
		InventoryHelper.func_180175_a(worldIn, pos, tileentity);
		super.func_180663_b(worldIn, pos, state);
	}
	
	@Override
	public void func_180633_a(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
	{
		if(stack.func_82837_s())
		{
			TileEntity tileentity = worldIn.func_175625_s(pos);
			
			if(tileentity instanceof TileEntityEsmChest)
			{
				((TileEntityEsmChest)tileentity).func_190575_a(stack.func_82833_r());
			}	
		}
	}
	
	@Override
	public TileEntity func_149915_a(World worldIn, int meta)
	{
		return new TileEntityEsmChest();
	}
	
	@Override
	public EnumBlockRenderType func_149645_b(IBlockState state) 
	{
		return EnumBlockRenderType.ENTITYBLOCK_ANIMATED;
	}
	
	@Override
	public boolean func_149730_j(IBlockState state) 
	{
		return false;
	}
	
	@Override
	public boolean func_149686_d(IBlockState state)
	{
		return false;
	}
	
	@Override
	public boolean func_149662_c(IBlockState state)
	{
		return false;
	}
}
