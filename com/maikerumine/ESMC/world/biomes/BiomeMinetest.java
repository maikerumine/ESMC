package com.maikerumine.ESMC.world.biomes;


import com.maikerumine.ESMC.entity.EntityStonemonster;
import com.maikerumine.ESMC.init.ModBlocks;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

import net.minecraft.world.biome.Biome.BiomeProperties;
import net.minecraft.world.biome.Biome.SpawnListEntry;

public class BiomeMinetest extends Biome 
{
	public BiomeMinetest() 
	{
		//registerBiome(16, "beaches", new BiomeBeach((new Biome.BiomeProperties("Beach")).setBaseHeight(0.0F).setHeightVariation(0.025F).setTemperature(0.8F).setRainfall(0.4F)));
		super(new BiomeProperties("MT Minetest").func_185398_c(-30.1F).func_185400_d(0.5F).func_185410_a(0.2F).func_185395_b(0.53F));
		
		field_76752_A = Blocks.field_150348_b.func_176223_P();
		field_76753_B = Blocks.field_150348_b.func_176223_P();
		
		
//		this.spawnableCaveCreatureList.clear();
		this.field_76762_K.clear();
//		this.spawnableMonsterList.clear();
		this.field_76755_L.clear();
		
		this.field_76762_K.add(new SpawnListEntry(EntityStonemonster.class, 5, 1, 5));
	}
}
