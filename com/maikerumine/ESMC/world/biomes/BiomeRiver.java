package com.maikerumine.ESMC.world.biomes;


import com.maikerumine.ESMC.entity.EntityStonemonster;
import com.maikerumine.ESMC.init.ModBlocks;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

import net.minecraft.world.biome.Biome.BiomeProperties;
import net.minecraft.world.biome.Biome.SpawnListEntry;

public class BiomeRiver extends Biome 
{
	public BiomeRiver() 
	{
		//registerBiome(7, "river", new BiomeRiver((new Biome.BiomeProperties("River")).setBaseHeight(-0.5F).setHeightVariation(0.0F)));
		super(new BiomeProperties("MT River").func_185398_c(-0.9F).func_185400_d(0.0F));
		
		field_76752_A = Blocks.field_150348_b.func_176223_P();
		field_76753_B = Blocks.field_150348_b.func_176223_P();
		
		
		this.field_82914_M.clear();
		this.field_76762_K.clear();
		this.field_76761_J.clear();
		this.field_76755_L.clear();
		
		this.field_76762_K.add(new SpawnListEntry(EntityStonemonster.class, 5, 1, 5));
	}
}
