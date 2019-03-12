package com.maikerumine.ESMC.init;

import com.maikerumine.ESMC.Main;
import com.maikerumine.ESMC.entity.EntityStonemonster;
import com.maikerumine.ESMC.util.ModConfiguration;
import com.maikerumine.ESMC.util.Reference;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

/**
public class EntityInit 
{
	public static void registerEntities()
	{
		registerEntity("stonemonster", EntityStonemonster.class, Reference.ENTITY_STONEMONSTER, 82, 11184810, 000000);
	}
	
	private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range, int color1, int color2)
	{
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":" + name), entity, name, id, Main.instance, range, 1, true, color1, color2);
	}
}
*/
//http://www.minecraftforge.net/forum/topic/59325-1112-solved-crash-when-rendering-custom-mob/
public class EntityInit {
	
	public static void init() {
		//id of mob local to this mod
		int entityID = 1;
		EntityRegistry.registerModEntity(new ResourceLocation("esm:stonemonster"), EntityStonemonster.class, "Stonemonster", ++entityID, Main.instance, 64, 3, true, 0xF5C56B, 0xC43232);
	}
	
}
