package com.maikerumine.ESMC;

import java.io.File;

import com.maikerumine.ESMC.creativetabs.EsmTab;
import com.maikerumine.ESMC.init.ModRecipes;
import com.maikerumine.ESMC.proxy.CommonProxy;
import com.maikerumine.ESMC.util.Reference;
import com.maikerumine.ESMC.world.ModWorldGeneration;
import com.maikerumine.ESMC.world.ModWorldGeneration2;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
public class Main {
	
	//public static final CreativeTabs ESM = null;
	public static final CreativeTabs ESM = new EsmTab();

	@Instance
	public static Main instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;

	public static File config;
	
	@EventHandler
	public static void PreInit(FMLPreInitializationEvent event)
	{
		GameRegistry.registerWorldGenerator(new ModWorldGeneration(), 3);
		
		
		
		/*		GameRegistry.registerWorldGenerator(new ModWorldGeneration2(), 3);
		 * 
		 * 
		 * 
		 * **/
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent event)
	{
		ModRecipes.init();
	}
	
	@EventHandler
	public static void Postinit(FMLPostInitializationEvent event)
	{
		
	}

}
