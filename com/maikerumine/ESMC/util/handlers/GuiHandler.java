package com.maikerumine.ESMC.util.handlers;

import com.maikerumine.ESMC.util.Reference;
import com.maikerumine.ESMC.blocks.containers.ContainerEsmChest;
import com.maikerumine.ESMC.blocks.containers.ContainerSinteringFurnace;
import com.maikerumine.ESMC.blocks.guis.GuiEsmChest;
import com.maikerumine.ESMC.blocks.guis.GuiSinteringFurnace;
import com.maikerumine.ESMC.blocks.tileentities.TileEntityEsmChest;
import com.maikerumine.ESMC.blocks.tileentities.TileEntitySinteringFurnace;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		if(ID == Reference.GUI_ESM_CHEST) return new ContainerEsmChest(player.field_71071_by, (TileEntityEsmChest)world.func_175625_s(new BlockPos(x,y,z)), player);
		if(ID == Reference.GUI_SINTERING_FURNACE) return new ContainerSinteringFurnace(player.field_71071_by, (TileEntitySinteringFurnace)world.func_175625_s(new BlockPos(x,y,z)));
		
		return null;
	}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		if(ID == Reference.GUI_ESM_CHEST) return new GuiEsmChest(player.field_71071_by, (TileEntityEsmChest)world.func_175625_s(new BlockPos(x,y,z)), player);
		if(ID == Reference.GUI_SINTERING_FURNACE) return new GuiSinteringFurnace(player.field_71071_by, (TileEntitySinteringFurnace)world.func_175625_s(new BlockPos(x,y,z)));
		
		return null;
	}
}
