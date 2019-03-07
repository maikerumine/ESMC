package com.maikerumine.ESMC.init;

import com.maikerumine.ESMC.Main;
import com.maikerumine.ESMC.Reference;
import com.maikerumine.ESMC.entity.EntityStonemonster;
import com.maikerumine.ESMC.util.ModConfiguration;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityInit 
{
	public static void registerEntities()
	{
		registerEntity("stonemonster", EntityStonemonster.class, ModConfiguration.ENTITY_STONEMONSTER_ID, 50, 11437146, 000000);
	}
	
	private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range, int color1, int color2)
	{
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID + ":" + name), entity, name, id, Main.instance, range, 1, true, color1, color2);
	}
}
