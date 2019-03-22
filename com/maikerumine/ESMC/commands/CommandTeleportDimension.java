package com.maikerumine.ESMC.commands;

import java.util.Collections;
import java.util.List;

import com.google.common.collect.Lists;

import com.maikerumine.ESMC.Main;
import com.maikerumine.ESMC.commands.CustomTeleporter;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

public class CommandTeleportDimension extends CommandBase
{
//	private final List<String> aliases = Lists.newArrayList(Main.MOD_ID, "TP", "tp", "tpdim", "tpdimension", "teleport");
	private final List<String> aliases = Lists.newArrayList(Main.MOD_ID, "spawn", "SPAWN", "spown", "spn", "Spawn");
	
	@Override
	public void func_184881_a(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException 
	{
		if(args.length < 1) return;
		
		String s = args[0];
		int dimension;
		
		try
		{
			dimension = Integer.parseInt(s);
		} catch(NumberFormatException e)
		{
			sender.func_145747_a(new TextComponentString(TextFormatting.RED + "Spawn not found"));
			return;
		}
		
		if(sender instanceof EntityPlayer)
		{
			CustomTeleporter.teleportToDimension((EntityPlayer)sender, dimension, 0, 65, 0);
		}
	}
	
	@Override
	public String func_71517_b() 
	{
		return "tpdimension";
	}
	
	@Override
	public String func_71518_a(ICommandSender sender)
	{
		return "tpdimension <id>";
	}
	
	@Override
	public List<String> func_71514_a() 
	{
		return aliases;
	}
	
	@Override
	public boolean func_184882_a(MinecraftServer server, ICommandSender sender) 
	{
		return true;
	}
	
	@Override
	public List<String> func_184883_a(MinecraftServer server, ICommandSender sender, String[] args, BlockPos targetPos) 
	{
		return Collections.emptyList();
	}
}
