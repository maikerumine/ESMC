package com.maikerumine.ESMC;

import java.io.File;

import com.maikerumine.ESMC.creativetabs.Esm;
import com.maikerumine.ESMC.creativetabs.Jt;
import com.maikerumine.ESMC.creativetabs.Minetest;
import com.maikerumine.ESMC.creativetabs.Tut;
import com.maikerumine.ESMC.init.ModRecipes;
import com.maikerumine.ESMC.proxy.CommonProxy;
import com.maikerumine.ESMC.proxy.IProxy;
import com.maikerumine.ESMC.util.Reference;
import com.maikerumine.ESMC.util.handlers.RegistryHandler;
import com.maikerumine.ESMC.world.ModEventHandler;
import com.maikerumine.ESMC.world.ModWorldGeneration;
import com.maikerumine.ESMC.world.ModWorldGeneration2;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
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
public class Main {
	
	public static final CreativeTabs ESM = new Esm();
	public static final CreativeTabs JT = new Jt();
	public static final CreativeTabs MINETEST = new Minetest();
	public static final CreativeTabs TUT = new Tut();
	//From Jabelar
    public static final String MOD_ID = "esm";
    public static final String MODNAME = "Extreme Survival Minecraft";
    public static final String MODVERSION = "0.1.4";
    public static final String MODDESCRIPTION = "Extreme Survival made for Minecraft!  Created by maikerumine for Minetest, then made for Minecraft!   Best used with BiomeTweaker and BiomeTweakerCore to get full effect of all stone world.  Place the BiomeTweaker folders into your config folder in your Forge installation.";
    public static final String MODAUTHOR = "maikerumine";
    public static final String MODCREDITS = "maikerumine and some Minetest community members for the ideas, textures, and gameplay.  Special thanks to Andrey for inspiring me to make stone world subgames.  :)  Special Thanks to Jabelar's modding examples, Harry's Modding examples, and Loremaster's Modding examples to help make this possible.";
    public static final String MODURL = "www.esmine.net";
    public static final String MODLOGO = "/assets/esm/textures/gui/logo.png";
    


	@Instance
	public static Main instance;
	
//	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
//	public static CommonProxy proxy;
	
//	@SidedProxy(serverSide = Reference.SERVER_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
//	public static CommonProxy proxy;
	
//  Says where the client and server 'proxy' code is loaded.
    @SidedProxy
    (clientSide = "com.maikerumine.ESMC.proxy.ClientProxy",
     serverSide = "com.maikerumine.ESMC.proxy.ServerProxy")
    public static IProxy proxy;
	public static File config;

	
	@EventHandler
	public static void PreInit(FMLPreInitializationEvent event)
	{
		GameRegistry.registerWorldGenerator(new ModWorldGeneration(), 3);
//		GameRegistry.registerWorldGenerator(new ModWorldGeneration2(), 3);		//This is prototype, to add dirt patches.
		RegistryHandler.preInitRegistries(event);
		MinecraftForge.TERRAIN_GEN_BUS.register(new ModEventHandler());  		//from forge forum
		MinecraftForge.ORE_GEN_BUS.register(new ModEventHandler());  		//from forge forum
		
		System.out.println("Extreme");
		System.out.println("Survival");
		System.out.println("Minecraft");
		System.out.println("By: maikerumine");
		System.out.println("Enjoy The Struggle!!!!");
		
		
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent event)
	{
		ModRecipes.init();														//Loremaster's
		RegistryHandler.initRegistries(event);  								//Harry's
		/**
		 * This removes decorations.
		 * http://www.minecraftforge.net/forum/topic/53576-1112-remove-overwrite-vanilla-tree-generation/
		 * 
		 */
//		MinecraftForge.TERRAIN_GEN_BUS.register(new ModEventHandler());  		//from forge forum
	}
	
	@EventHandler
	public static void Postinit(FMLPostInitializationEvent event)
	{
//		RegistryHandler.postRegistries();										//Loremaster's
		RegistryHandler.postInitRegistries(event);								//Harry's
	}
	
	@EventHandler
	public static void serverInit(FMLServerStartingEvent event)
	{
		RegistryHandler.serverRegistries(event);
	}

	
	
}
