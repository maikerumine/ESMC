package com.maikerumine.ESMC.blocks.guis;

import com.maikerumine.ESMC.Main;
import com.maikerumine.ESMC.blocks.containers.ContainerSinteringFurnace;
import com.maikerumine.ESMC.blocks.tileentities.TileEntitySinteringFurnace;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiSinteringFurnace extends GuiContainer
{
	private static final ResourceLocation TEXTURES = new ResourceLocation(Main.MOD_ID + ":textures/gui/sintering_furnace.png");
	private final InventoryPlayer player;
	private final TileEntitySinteringFurnace tileentity;
	
	public GuiSinteringFurnace(InventoryPlayer player, TileEntitySinteringFurnace tileentity) 
	{
		super(new ContainerSinteringFurnace(player, tileentity));
		this.player = player;
		this.tileentity = tileentity;
	}
	
	@Override
	protected void func_146979_b(int mouseX, int mouseY) 
	{
		String tileName = this.tileentity.func_145748_c_().func_150260_c();
		this.field_146289_q.func_78276_b(tileName, (this.field_146999_f / 2 - this.field_146289_q.func_78256_a(tileName) / 2) + 3, 8, 4210752);
		this.field_146289_q.func_78276_b(this.player.func_145748_c_().func_150260_c(), 122, this.field_147000_g - 96 + 2, 4210752);
	}
	
	@Override
	protected void func_146976_a(float partialTicks, int mouseX, int mouseY)
	{
		GlStateManager.func_179131_c(1.0f, 1.0f, 1.0f, 1.0f);
		this.field_146297_k.func_110434_K().func_110577_a(TEXTURES);
		this.func_73729_b(this.field_147003_i, this.field_147009_r, 0, 0, this.field_146999_f, this.field_147000_g);
		
		if(TileEntitySinteringFurnace.isBurning(tileentity))
		{
			int k = this.getBurnLeftScaled(13);
			this.func_73729_b(this.field_147003_i + 8, this.field_147009_r + 54 + 12 - k, 176, 12 - k, 14, k + 1);
		}
		
		int l = this.getCookProgressScaled(24);
		this.func_73729_b(this.field_147003_i + 44, this.field_147009_r + 36, 176, 14, l + 1, 16);
	}
	
	private int getBurnLeftScaled(int pixels)
	{
		int i = this.tileentity.getField(1);
		if(i == 0) i = 200;
		return this.tileentity.getField(0) * pixels / i;
	}
	
	private int getCookProgressScaled(int pixels)
	{
		int i = this.tileentity.getField(2);
		int j = this.tileentity.getField(3);
		return j != 0 && i != 0 ? i * pixels / j : 0;
	}
}
