package com.maikerumine.ESMC.util;

import java.io.File;

import com.maikerumine.ESMC.Main;
import com.maikerumine.ESMC.util.Reference;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ModConfiguration 
{
	public static Configuration config;
	
	public static int ENTITY_STONEMONSTER_ID = 201;
	

	public static int GUI_ESM_CHEST_ID = 2;

	
	public static boolean spawnCustomBiomesInOverworld = true;
	
	public static void init(File file)
	{
		config = new Configuration(file);
		
		String category;
		
		category = "Entity IDs";
		config.addCustomCategoryComment(category, "Set the ID's for the entities to ensure that they don't clash with other mod's ids");
		ENTITY_STONEMONSTER_ID = config.getInt("ENTITY_STONEMONSTER_ID", category, 201, 201, 999, "Entity IDs below 201 are used by Minecraft");
		
		category = "GUI IDs";
		config.addCustomCategoryComment(category, "Set the ID's for the GUI's to ensure that they don't clash with other mod's ids");

		GUI_ESM_CHEST_ID = config.getInt("GUI_ESM_CHEST_ID", category, 4, 1, 999, "Set the ID for the ESM Chest");
	
		category = "Dimension IDs";
		config.addCustomCategoryComment(category, "Set the ID's for the dimensions to ensure that they don't clash with other mod's ids");

		category = "Biomes";
		config.addCustomCategoryComment(category, "Set the ID's for the GUI's to ensure that they don't clash with other mod's ids");
		spawnCustomBiomesInOverworld = config.getBoolean("spawnCustomBiomesInOverworld", category, true, "Decide whether the custom biomes should spawn in the overworld");	
	}
	
	public static void registerConfig(FMLPreInitializationEvent event)
	{
		Main.config = new File(event.getModConfigurationDirectory() + "/" + Reference.MOD_ID);
		Main.config.mkdirs();
		init(new File(Main.config.getPath(), Reference.MOD_ID + ".cfg"));
	}
} 
