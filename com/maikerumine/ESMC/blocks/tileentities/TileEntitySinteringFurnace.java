package com.maikerumine.ESMC.blocks.tileentities;

import com.maikerumine.ESMC.blocks.machines.BlockSinteringFurnace;
import com.maikerumine.ESMC.blocks.recipes.SinteringFurnaceRecipes;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntitySinteringFurnace extends TileEntity implements ITickable
{
	private ItemStackHandler handler = new ItemStackHandler(4);
	private String customName;
	private ItemStack smelting = ItemStack.field_190927_a;
	
	private int burnTime;
	private int currentBurnTime;
	private int cookTime;
	private int totalCookTime = 200;

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) 
	{
		if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) return true;
		else return false;
	}
	
	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) 
	{
		if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) return (T) this.handler;
		return super.getCapability(capability, facing);
	}
	
	public boolean hasCustomName() 
	{
		return this.customName != null && !this.customName.isEmpty();
	}
	
	public void setCustomName(String customName) 
	{
		this.customName = customName;
	}
	
	@Override
	public ITextComponent func_145748_c_() 
	{
		return this.hasCustomName() ? new TextComponentString(this.customName) : new TextComponentTranslation("container.sintering_furnace");
	}
	
	@Override
	public void func_145839_a(NBTTagCompound compound)
	{
		super.func_145839_a(compound);
		this.handler.deserializeNBT(compound.func_74775_l("Inventory"));
		this.burnTime = compound.func_74762_e("BurnTime");
		this.cookTime = compound.func_74762_e("CookTime");
		this.totalCookTime = compound.func_74762_e("CookTimeTotal");
		this.currentBurnTime = getItemBurnTime((ItemStack)this.handler.getStackInSlot(2));
		
		if(compound.func_150297_b("CustomName", 8)) this.setCustomName(compound.func_74779_i("CustomName"));
	}
	
	@Override
	public NBTTagCompound func_189515_b(NBTTagCompound compound) 
	{
		super.func_189515_b(compound);
		compound.func_74768_a("BurnTime", (short)this.burnTime);
		compound.func_74768_a("CookTime", (short)this.cookTime);
		compound.func_74768_a("CookTimeTotal", (short)this.totalCookTime);
		compound.func_74782_a("Inventory", this.handler.serializeNBT());
		
		if(this.hasCustomName()) compound.func_74778_a("CustomName", this.customName);
		return compound;
	}
	
	public boolean isBurning() 
	{
		return this.burnTime > 0;
	}
	
	@SideOnly(Side.CLIENT)
	public static boolean isBurning(TileEntitySinteringFurnace te) 
	{
		return te.getField(0) > 0;
	}
	
	public void func_73660_a() 
	{	
		if(this.isBurning())
		{
			--this.burnTime;
			BlockSinteringFurnace.setState(true, field_145850_b, field_174879_c);
		}
		
		ItemStack[] inputs = new ItemStack[] {handler.getStackInSlot(0), handler.getStackInSlot(1)};
		ItemStack fuel = this.handler.getStackInSlot(2);
		
		if(this.isBurning() || !fuel.func_190926_b() && !this.handler.getStackInSlot(0).func_190926_b() || this.handler.getStackInSlot(1).func_190926_b())
		{
			if(!this.isBurning() && this.canSmelt())
			{
				this.burnTime = getItemBurnTime(fuel);
				this.currentBurnTime = burnTime;
				
				if(this.isBurning() && !fuel.func_190926_b())
				{
					Item item = fuel.func_77973_b();
					fuel.func_190918_g(1);
					
					if(fuel.func_190926_b())
					{
						ItemStack item1 = item.getContainerItem(fuel);
						this.handler.setStackInSlot(2, item1);
					}
				}
			}
		}
		
		if(this.isBurning() && this.canSmelt() && cookTime > 0)
		{
			cookTime++;
			if(cookTime == totalCookTime)
			{
				if(handler.getStackInSlot(3).func_190916_E() > 0)
				{
					handler.getStackInSlot(3).func_190917_f(1);
				}
				else
				{
					handler.insertItem(3, smelting, false);
				}
				
				smelting = ItemStack.field_190927_a;
				cookTime = 0;
				return;
			}
		}
		else
		{
			if(this.canSmelt() && this.isBurning())
			{
				ItemStack output = SinteringFurnaceRecipes.getInstance().getSinteringResult(inputs[0], inputs[1]);
				if(!output.func_190926_b())
				{
					smelting = output;
					cookTime++;
					inputs[0].func_190918_g(1);
					inputs[1].func_190918_g(1);
					handler.setStackInSlot(0, inputs[0]);
					handler.setStackInSlot(1, inputs[1]);
				}
			}
		}
	}
	
	private boolean canSmelt() 
	{
		if(((ItemStack)this.handler.getStackInSlot(0)).func_190926_b() || ((ItemStack)this.handler.getStackInSlot(1)).func_190926_b()) return false;
		else 
		{
			ItemStack result = SinteringFurnaceRecipes.getInstance().getSinteringResult((ItemStack)this.handler.getStackInSlot(0), (ItemStack)this.handler.getStackInSlot(1));	
			if(result.func_190926_b()) return false;
			else
			{
				ItemStack output = (ItemStack)this.handler.getStackInSlot(3);
				if(output.func_190926_b()) return true;
				if(!output.func_77969_a(result)) return false;
				int res = output.func_190916_E() + result.func_190916_E();
				return res <= 64 && res <= output.func_77976_d();
			}
		}
	}
	
	public static int getItemBurnTime(ItemStack fuel) 
	{
		if(fuel.func_190926_b()) return 0;
		else 
		{
			Item item = fuel.func_77973_b();

			if (item instanceof ItemBlock && Block.func_149634_a(item) != Blocks.field_150350_a) 
			{
				Block block = Block.func_149634_a(item);

				if (block == Blocks.field_150376_bx) return 150;
				if (block.func_176223_P().func_185904_a() == Material.field_151575_d) return 300;
				if (block == Blocks.field_150402_ci) return 16000;
			}

			if (item instanceof ItemTool && "WOOD".equals(((ItemTool)item).func_77861_e())) return 200;
			if (item instanceof ItemSword && "WOOD".equals(((ItemSword)item).func_150932_j())) return 200;
			if (item instanceof ItemHoe && "WOOD".equals(((ItemHoe)item).func_77842_f())) return 200;
			if (item == Items.field_151055_y) return 100;
			if (item == Items.field_151044_h) return 1600;
			if (item == Items.field_151129_at) return 20000;
			if (item == Item.func_150898_a(Blocks.field_150345_g)) return 100;
			if (item == Items.field_151072_bj) return 2400;

			return GameRegistry.getFuelValue(fuel);
		}
	}
		
	public static boolean isItemFuel(ItemStack fuel)
	{
		return getItemBurnTime(fuel) > 0;
	}
	
	public boolean isUsableByPlayer(EntityPlayer player) 
	{
		return this.field_145850_b.func_175625_s(this.field_174879_c) != this ? false : player.func_70092_e((double)this.field_174879_c.func_177958_n() + 0.5D, (double)this.field_174879_c.func_177956_o() + 0.5D, (double)this.field_174879_c.func_177952_p() + 0.5D) <= 64.0D;
	}

	public int getField(int id) 
	{
		switch(id) 
		{
		case 0:
			return this.burnTime;
		case 1:
			return this.currentBurnTime;
		case 2:
			return this.cookTime;
		case 3:
			return this.totalCookTime;
		default:
			return 0;
		}
	}

	public void setField(int id, int value) 
	{
		switch(id) 
		{
		case 0:
			this.burnTime = value;
			break;
		case 1:
			this.currentBurnTime = value;
			break;
		case 2:
			this.cookTime = value;
			break;
		case 3:
			this.totalCookTime = value;
		}
	}
}
