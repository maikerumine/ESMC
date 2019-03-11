package com.maikerumine.ESMC.init;

import com.maikerumine.ESMC.util.ModConfiguration;
import com.maikerumine.ESMC.world.biomes.BiomeDesert;
import com.maikerumine.ESMC.world.biomes.BiomeOcean;
import com.maikerumine.ESMC.world.biomes.BiomeStone;
import com.maikerumine.ESMC.world.biomes.BiomeStoneJustTest;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class BiomeInit 
{
	public static final Biome STONE = new BiomeStone();
	public static final Biome STONEJT = new BiomeStoneJustTest();
	public static final Biome OCEAN = new BiomeOcean();
	public static final Biome DESERT = new BiomeDesert();

	
	public static void registerBiomes()
	{
		initBiome(STONE, "Stone", BiomeType.WARM, Type.HILLS, Type.MOUNTAIN, Type.DRY);
		initBiome(STONEJT, "StoneJustTest", BiomeType.COOL, Type.HILLS, Type.MOUNTAIN, Type.DRY);
//  TODO:  ADD MORE STONE ONLY BIOMES
		
		
//
		initBiome(OCEAN, "Ocean", BiomeType.COOL, Type.WET, Type.OCEAN, Type.SPARSE);
		initBiome(DESERT, "Desert", BiomeType.WARM, Type.HILLS, Type.HOT, Type.DRY);
	}
	
	private static Biome initBiome(Biome biome, String name, BiomeType biomeType, Type... types)
	{
		biome.setRegistryName(name);
		ForgeRegistries.BIOMES.register(biome);
		BiomeDictionary.addTypes(biome, types);
		BiomeManager.addBiome(biomeType, new BiomeEntry(biome, 1000));
		
		if(ModConfiguration.spawnCustomBiomesInOverworld) 
		{
			BiomeManager.addSpawnBiome(biome);
		}
		return biome;
	}
}
