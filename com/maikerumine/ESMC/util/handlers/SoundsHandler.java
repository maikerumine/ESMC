package com.maikerumine.ESMC.util.handlers;

import com.maikerumine.ESMC.util.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class SoundsHandler 
{
	public static SoundEvent ENTITY_STONEMONSTER_AMBIENT, ENTITY_STONEMONSTER_HURT, ENTITY_STONEMONSTER_DEATH, ENTITY_STONEMONSTER_STEP;
	
	public static void registerSounds()
	{
		ENTITY_STONEMONSTER_AMBIENT = registerSound("entity.stonemonster.ambient");
		ENTITY_STONEMONSTER_HURT = registerSound("entity.stonemonster.hurt");
		ENTITY_STONEMONSTER_DEATH = registerSound("entity.stonemonster.death");
		ENTITY_STONEMONSTER_STEP = registerSound("entity.stonemonster.step");
	}
	
	private static SoundEvent registerSound(String name)
	{
		ResourceLocation location = new ResourceLocation(Reference.MOD_ID, name);
		SoundEvent event = new SoundEvent(location);
		event.setRegistryName(name);
		ForgeRegistries.SOUND_EVENTS.register(event);
		return event;
	}
}
