package com.maikerumine.ESMC.blocks.tileentities;

import com.maikerumine.ESMC.Reference;
import com.maikerumine.ESMC.blocks.containers.ContainerEsmChest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityLockableLoot;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;

public class TileEntityEsmChest extends TileEntityLockableLoot implements ITickable
{
	private NonNullList<ItemStack> chestContents = NonNullList.<ItemStack>func_191197_a(72, ItemStack.field_190927_a);
	public int numPlayersUsing, ticksSinceSync;
	public float lidAngle, prevLidAngle;
	
	@Override
	public int func_70302_i_()
	{
		return 72;
	}
	
	@Override
	public int func_70297_j_() 
	{
		return 64;
	}
	
	@Override
	public boolean func_191420_l()
	{
		for(ItemStack stack : this.chestContents)
		{
			if(!stack.func_190926_b()) return false;
		}
		
		return true;
	}
	
	@Override
	public String func_70005_c_() 
	{
		return this.func_145818_k_() ? this.field_190577_o : "container.esm_chest";
	}
	
	@Override
	public void func_145839_a(NBTTagCompound compound)
	{
		super.func_145839_a(compound);
		this.chestContents = NonNullList.<ItemStack>func_191197_a(this.func_70302_i_(), ItemStack.field_190927_a);
		
		if(!this.func_184283_b(compound)) ItemStackHelper.func_191283_b(compound, chestContents);
		if(compound.func_150297_b("CustomName", 8)) this.field_190577_o = compound.func_74779_i("CustomName");
	}
	
	@Override
	public NBTTagCompound func_189515_b(NBTTagCompound compound)
	{
		super.func_189515_b(compound);
		
		if(!this.func_184282_c(compound)) ItemStackHelper.func_191282_a(compound, chestContents);
		if(compound.func_150297_b("CustomName", 8)) compound.func_74778_a("CustomName", this.field_190577_o);
		
		return compound;
	}
	
	@Override
	public Container func_174876_a(InventoryPlayer playerInventory, EntityPlayer playerIn) 
	{
		return new ContainerEsmChest(playerInventory, this, playerIn);
	}
	
	@Override
	public String func_174875_k() 
	{
		return Reference.MODID + ":esm_chest";
	}
	
	@Override
	protected NonNullList<ItemStack> func_190576_q() 
	{
		return this.chestContents;
	}
	
	@Override
	public void func_73660_a()
	{
		if (!this.field_145850_b.field_72995_K && this.numPlayersUsing != 0 && (this.ticksSinceSync + field_174879_c.func_177958_n() + field_174879_c.func_177956_o() + field_174879_c.func_177952_p()) % 200 == 0)
        {
            this.numPlayersUsing = 0;
            float f = 5.0F;

            for (EntityPlayer entityplayer : this.field_145850_b.func_72872_a(EntityPlayer.class, new AxisAlignedBB((double)((float)field_174879_c.func_177958_n() - 5.0F), (double)((float)field_174879_c.func_177956_o() - 5.0F), (double)((float)field_174879_c.func_177952_p() - 5.0F), (double)((float)(field_174879_c.func_177958_n() + 1) + 5.0F), (double)((float)(field_174879_c.func_177956_o() + 1) + 5.0F), (double)((float)(field_174879_c.func_177952_p() + 1) + 5.0F))))
            {
                if (entityplayer.field_71070_bA instanceof ContainerEsmChest)
                {
                    if (((ContainerEsmChest)entityplayer.field_71070_bA).getChestInventory() == this)
                    {
                        ++this.numPlayersUsing;
                    }
                }
            }
        }
		
        this.prevLidAngle = this.lidAngle;
        float f1 = 0.1F;

        if (this.numPlayersUsing > 0 && this.lidAngle == 0.0F)
        {
            double d1 = (double)field_174879_c.func_177958_n() + 0.5D;
            double d2 = (double)field_174879_c.func_177952_p() + 0.5D;
            this.field_145850_b.func_184148_a((EntityPlayer)null, d1, (double)field_174879_c.func_177956_o() + 0.5D, d2, SoundEvents.field_187617_cK, SoundCategory.BLOCKS, 0.5F, this.field_145850_b.field_73012_v.nextFloat() * 0.1F + 0.9F);
        }

        if (this.numPlayersUsing == 0 && this.lidAngle > 0.0F || this.numPlayersUsing > 0 && this.lidAngle < 1.0F)
        {
            float f2 = this.lidAngle;

            if (this.numPlayersUsing > 0)
            {
                this.lidAngle += 0.1F;
            }
            else
            {
                this.lidAngle -= 0.1F;
            }

            if (this.lidAngle > 1.0F)
            {
                this.lidAngle = 1.0F;
            }

            float f3 = 0.5F;

            if (this.lidAngle < 0.5F && f2 >= 0.5F)
            {
                double d3 = (double)field_174879_c.func_177958_n() + 0.5D;
                double d0 = (double)field_174879_c.func_177952_p() + 0.5D;
                this.field_145850_b.func_184148_a((EntityPlayer)null, d3, (double)field_174879_c.func_177956_o() + 0.5D, d0, SoundEvents.field_187614_cJ, SoundCategory.BLOCKS, 0.5F, this.field_145850_b.field_73012_v.nextFloat() * 0.1F + 0.9F);
            }

            if (this.lidAngle < 0.0F)
            {
                this.lidAngle = 0.0F;
            }
        }		
	}
	
	@Override
	public void func_174889_b(EntityPlayer player)
	{
		++this.numPlayersUsing;
		this.field_145850_b.func_175641_c(field_174879_c, this.func_145838_q(), 1, this.numPlayersUsing);
		this.field_145850_b.func_175685_c(field_174879_c, this.func_145838_q(), false);
	}
	
	@Override
	public void func_174886_c(EntityPlayer player) 
	{
		--this.numPlayersUsing;
		this.field_145850_b.func_175641_c(field_174879_c, this.func_145838_q(), 1, this.numPlayersUsing);
		this.field_145850_b.func_175685_c(field_174879_c, this.func_145838_q(), false);
	}	
}
