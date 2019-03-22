package com.maikerumine.ESMC.blocks.containers;

import com.maikerumine.ESMC.blocks.recipes.SinteringFurnaceRecipes;
import com.maikerumine.ESMC.blocks.tileentities.TileEntitySinteringFurnace;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerSinteringFurnace extends Container
{
	private final TileEntitySinteringFurnace tileentity;
	private int cookTime, totalCookTime, burnTime, currentBurnTime;
	
	public ContainerSinteringFurnace(InventoryPlayer player, TileEntitySinteringFurnace tileentity) 
	{
		this.tileentity = tileentity;
		IItemHandler handler = tileentity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
		
		this.func_75146_a(new SlotItemHandler(handler, 0, 26, 11));
		this.func_75146_a(new SlotItemHandler(handler, 1, 26, 59));
		this.func_75146_a(new SlotItemHandler(handler, 2, 7, 35));
		this.func_75146_a(new SlotItemHandler(handler, 3, 81, 36));
		
		for(int y = 0; y < 3; y++)
		{
			for(int x = 0; x < 9; x++)
			{
				this.func_75146_a(new Slot(player, x + y*9 + 9, 8 + x*18, 84 + y*18));
			}
		}
		
		for(int x = 0; x < 9; x++)
		{
			this.func_75146_a(new Slot(player, x, 8 + x * 18, 142));
		}
	}
	
	@Override
	public void func_75142_b() 
	{
		super.func_75142_b();
		
		for(int i = 0; i < this.field_75149_d.size(); ++i) 
		{
			IContainerListener listener = (IContainerListener)this.field_75149_d.get(i);
			
			if(this.cookTime != this.tileentity.getField(2)) listener.func_71112_a(this, 2, this.tileentity.getField(2));
			if(this.burnTime != this.tileentity.getField(0)) listener.func_71112_a(this, 0, this.tileentity.getField(0));
			if(this.currentBurnTime != this.tileentity.getField(1)) listener.func_71112_a(this, 1, this.tileentity.getField(1));
			if(this.totalCookTime != this.tileentity.getField(3)) listener.func_71112_a(this, 3, this.tileentity.getField(3));
		}
		
		this.cookTime = this.tileentity.getField(2);
		this.burnTime = this.tileentity.getField(0);
		this.currentBurnTime = this.tileentity.getField(1);
		this.totalCookTime = this.tileentity.getField(3);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void func_75137_b(int id, int data) 
	{
		this.tileentity.setField(id, data);
	}
	
	@Override
	public boolean func_75145_c(EntityPlayer playerIn) 
	{
		return this.tileentity.isUsableByPlayer(playerIn);
	}
	
	@Override
	public ItemStack func_82846_b(EntityPlayer playerIn, int index) 
	{
		ItemStack stack = ItemStack.field_190927_a;
		Slot slot = (Slot)this.field_75151_b.get(index);
		
		if(slot != null && slot.func_75216_d()) 
		{
			ItemStack stack1 = slot.func_75211_c();
			stack = stack1.func_77946_l();
			
			if(index == 3) 
			{
				if(!this.func_75135_a(stack1, 4, 40, true)) return ItemStack.field_190927_a;
				slot.func_75220_a(stack1, stack);
			}
			else if(index != 2 && index != 1 && index != 0) 
			{		
				Slot slot1 = (Slot)this.field_75151_b.get(index + 1);
				
				if(!SinteringFurnaceRecipes.getInstance().getSinteringResult(stack1, slot1.func_75211_c()).func_190926_b())
				{
					if(!this.func_75135_a(stack1, 0, 2, false)) 
					{
						return ItemStack.field_190927_a;
					}
					else if(TileEntitySinteringFurnace.isItemFuel(stack1))
					{
						if(!this.func_75135_a(stack1, 2, 3, false)) return ItemStack.field_190927_a;
					}
					else if(TileEntitySinteringFurnace.isItemFuel(stack1))
					{
						if(!this.func_75135_a(stack1, 2, 3, false)) return ItemStack.field_190927_a;
					}
					else if(TileEntitySinteringFurnace.isItemFuel(stack1))
					{
						if(!this.func_75135_a(stack1, 2, 3, false)) return ItemStack.field_190927_a;
					}
					else if(index >= 4 && index < 31)
					{
						if(!this.func_75135_a(stack1, 31, 40, false)) return ItemStack.field_190927_a;
					}
					else if(index >= 31 && index < 40 && !this.func_75135_a(stack1, 4, 31, false))
					{
						return ItemStack.field_190927_a;
					}
				}
			} 
			else if(!this.func_75135_a(stack1, 4, 40, false)) 
			{
				return ItemStack.field_190927_a;
			}
			if(stack1.func_190926_b())
			{
				slot.func_75215_d(ItemStack.field_190927_a);
			}
			else
			{
				slot.func_75218_e();

			}
			if(stack1.func_190916_E() == stack.func_190916_E()) return ItemStack.field_190927_a;
			slot.func_190901_a(playerIn, stack1);
		}
		return stack;
	}
}
