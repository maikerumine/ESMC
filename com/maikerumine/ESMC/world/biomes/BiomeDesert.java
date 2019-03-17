package com.maikerumine.ESMC.world.biomes;


import com.maikerumine.ESMC.entity.EntityStonemonster;
import com.maikerumine.ESMC.init.ModBlocks;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

import net.minecraft.world.biome.Biome.BiomeProperties;
import net.minecraft.world.biome.Biome.SpawnListEntry;

public class BiomeDesert extends Biome 
{
	public BiomeDesert() 
	{
		super(new BiomeProperties("ESM Desert").func_185398_c(0.125F).func_185400_d(0.05F).func_185410_a(2.0F).func_185395_b(0.0F).func_185396_a());
		
		field_76752_A = Blocks.field_150354_m.func_176223_P();
		field_76753_B = Blocks.field_150322_A.func_176223_P();
				
//		this.spawnableCaveCreatureList.clear();
		this.field_76762_K.clear();
//		this.spawnableMonsterList.clear();
//		this.spawnableWaterCreatureList.clear();
		
		this.field_76762_K.add(new SpawnListEntry(EntityStonemonster.class, 5, 1, 5));
	}
}
