package com.maikerumine.ESMC.world.type;

import com.maikerumine.ESMC.init.BiomeInit;
import com.maikerumine.ESMC.world.generation.layer.GenLayerMinetest;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.gen.ChunkGeneratorSettings;
import net.minecraft.world.gen.layer.GenLayer;




public class WorldTypeMinetest extends WorldType
{
	public WorldTypeMinetest() 
	{
		super("Minetest");
	}
	
	@Override
	public GenLayer getBiomeLayer(long worldSeed, GenLayer parentLayer, ChunkGeneratorSettings chunkSettings )
	{
		return new GenLayerMinetest(worldSeed, parentLayer, this, chunkSettings);
	}
}

