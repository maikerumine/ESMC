package com.maikerumine.ESMC.world.biomes;


import com.maikerumine.ESMC.entity.EntityStonemonster;
import com.maikerumine.ESMC.init.ModBlocks;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

import net.minecraft.world.biome.Biome.BiomeProperties;
import net.minecraft.world.biome.Biome.SpawnListEntry;

public class BiomeDeepOcean extends Biome 
{
	public BiomeDeepOcean() 
	{
		super(new BiomeProperties("MT .. Deep Ocean").func_185398_c(-2.0F).func_185400_d(0.1F));
//		registerBiome(0, "ocean", new BiomeOcean((new Biome.BiomeProperties("Ocean")).setBaseHeight(-1.0F).setHeightVariation(0.1F)));
		
		field_76752_A = Blocks.field_150348_b.func_176223_P();
		field_76753_B = Blocks.field_150348_b.func_176223_P();
		

		
//		this.spawnableCaveCreatureList.clear();
//		this.spawnableCreatureList.clear();
//		this.spawnableMonsterList.clear();
//		this.spawnableWaterCreatureList.clear();
		
		this.field_76762_K.add(new SpawnListEntry(EntityStonemonster.class, 5, 1, 5));
	}
}
