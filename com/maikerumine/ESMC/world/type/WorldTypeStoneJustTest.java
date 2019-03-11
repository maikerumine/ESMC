package com.maikerumine.ESMC.world.type;

import com.maikerumine.ESMC.init.BiomeInit;

import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.gen.ChunkGeneratorSettings;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


public class WorldTypeStoneJustTest extends WorldType
{
	public WorldTypeStoneJustTest() 
	{
		super("StoneJustTest");
	}
	
	@Override
	public BiomeProvider getBiomeProvider(World world) 
	{
		BiomeProvider provider = new BiomeProviderSingle(BiomeInit.STONEJT);
		return provider;
	}
	
	

	
	
}
