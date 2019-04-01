package com.maikerumine.ESMC;

import java.io.File;

import com.maikerumine.ESMC.creativetabs.Esm;
import com.maikerumine.ESMC.creativetabs.Jt;
import com.maikerumine.ESMC.creativetabs.Minetest;
import com.maikerumine.ESMC.init.FluidInit;
import com.maikerumine.ESMC.init.ModRecipes;
import com.maikerumine.ESMC.proxy.CommonProxy;
import com.maikerumine.ESMC.util.Reference;
import com.maikerumine.ESMC.util.handlers.RegistryHandler;
import com.maikerumine.ESMC.util.handlers.TileEntityHandler;
import com.maikerumine.ESMC.world.ModEventHandler;
import com.maikerumine.ESMC.world.ModWorldGeneration;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
public class Main 
{
/**
	//From Jabelar
    public static final String MOD_ID = "esm";
    public static final String MODNAME = "Extreme Survival Minecraft";
    public static final String MODVERSION = "0.1.5-Universal";
    public static final String MODDESCRIPTION = "Extreme Survival made for Minecraft!  Created by maikerumine for Minetest, then made for Minecraft!   Best used with BiomeTweaker and BiomeTweakerCore to get full effect of all stone world.  Place the BiomeTweaker folders into your config folder in your Forge installation.";
    public static final String MODAUTHOR = "maikerumine";
    public static final String MODCREDITS = "maikerumine and some Minetest community members for the ideas, textures, and gameplay.  Special thanks to Andrey for inspiring me to make stone world subgames.  :)  Special Thanks to Jabelar's modding examples, Harry's Modding examples, and Loremaster's Modding examples to help make this possible.";
    public static final String MODURL = "www.esmine.net";
    public static final String MODLOGO = "/assets/esm/textures/gui/logo.png";
   */ 


	@Instance
	public static Main instance;
	
	@SidedProxy(clientSide = Reference.CLIENT, serverSide = Reference.SERVER)
	public static CommonProxy proxy;
	
	public static final CreativeTabs ESM = new Esm();
	public static final CreativeTabs JT = new Jt();
	public static final CreativeTabs MINETEST = new Minetest();
	
	public static File config;

	static { FluidRegistry.enableUniversalBucket(); }
	
	@EventHandler
	public static void preInit(FMLPreInitializationEvent event)
	{
		RegistryHandler.preInitRegistries(event);			//Failure
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent event)
	{
		ModRecipes.init();		//afterthought									//Loremaster's
		RegistryHandler.initRegistries(event);  								//Harry's
	}
	
	@EventHandler
	public static void postInit(FMLPostInitializationEvent event)
	{
		RegistryHandler.postInitRegistries(event);								//Harry's
	}
	
	@EventHandler
	public static void serverInit(FMLServerStartingEvent event)
	{
		RegistryHandler.serverRegistries(event);
	}
}
