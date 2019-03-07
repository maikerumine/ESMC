package com.maikerumine.ESMC.blocks.guis;

import com.maikerumine.ESMC.Reference;
import com.maikerumine.ESMC.blocks.containers.ContainerEsmChest;
import com.maikerumine.ESMC.blocks.tileentities.TileEntityEsmChest;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiEsmChest extends GuiContainer
{
	private static final ResourceLocation GUI_CHEST = new ResourceLocation(Reference.MODID + ":textures/gui/esm_chest.png");
	private final InventoryPlayer playerInventory;
	private final TileEntityEsmChest te;
	
	public GuiEsmChest(InventoryPlayer playerInventory, TileEntityEsmChest chestInventory, EntityPlayer player) 
	{
		super(new ContainerEsmChest(playerInventory, chestInventory, player));
		this.playerInventory = playerInventory;
		this.te = chestInventory;
		
		this.field_146999_f = 179;
		this.field_147000_g = 256;
	}
	
	@Override
	protected void func_146979_b(int mouseX, int mouseY) 
	{
		this.field_146289_q.func_78276_b(this.te.func_145748_c_().func_150260_c(), 8, 6, 16086784);
		this.field_146289_q.func_78276_b(this.playerInventory.func_145748_c_().func_150260_c(), 8, this.field_147000_g - 92, 16086784);
	}
	
	@Override
	protected void func_146976_a(float partialTicks, int mouseX, int mouseY)
	{
		GlStateManager.func_179131_c(1.0f, 1.0f, 1.0f, 1.0f);
		this.field_146297_k.func_110434_K().func_110577_a(GUI_CHEST);
		this.func_73729_b(this.field_147003_i, this.field_147009_r, 0, 0, this.field_146999_f, this.field_147000_g);
	}
}
