package com.maikerumine.ESMC.init;

import com.maikerumine.ESMC.util.ModConfiguration;
import com.maikerumine.ESMC.world.biomes.BiomeBeach;
import com.maikerumine.ESMC.world.biomes.BiomeCold_desert;
import com.maikerumine.ESMC.world.biomes.BiomeCold_desert_ocean;
import com.maikerumine.ESMC.world.biomes.BiomeConiferous_forest;
import com.maikerumine.ESMC.world.biomes.BiomeConiferous_forest_dunes;
import com.maikerumine.ESMC.world.biomes.BiomeConiferous_forest_ocean;
import com.maikerumine.ESMC.world.biomes.BiomeDeciduous_forest;
import com.maikerumine.ESMC.world.biomes.BiomeDeciduous_forest_ocean;
import com.maikerumine.ESMC.world.biomes.BiomeDeciduous_forest_shore;
import com.maikerumine.ESMC.world.biomes.BiomeDesert;
import com.maikerumine.ESMC.world.biomes.BiomeDesert_ocean;
import com.maikerumine.ESMC.world.biomes.BiomeGrassland;
import com.maikerumine.ESMC.world.biomes.BiomeGrassland_dunes;
import com.maikerumine.ESMC.world.biomes.BiomeGrassland_ocean;
import com.maikerumine.ESMC.world.biomes.BiomeIcesheet;
import com.maikerumine.ESMC.world.biomes.BiomeIcesheet_ocean;
import com.maikerumine.ESMC.world.biomes.BiomeMinetest;
import com.maikerumine.ESMC.world.biomes.BiomeOcean;
import com.maikerumine.ESMC.world.biomes.BiomeRainforest;
import com.maikerumine.ESMC.world.biomes.BiomeRainforest_ocean;
import com.maikerumine.ESMC.world.biomes.BiomeRainforest_swamp;
import com.maikerumine.ESMC.world.biomes.BiomeRiver;
import com.maikerumine.ESMC.world.biomes.BiomeSandstone_desert;
import com.maikerumine.ESMC.world.biomes.BiomeSandstone_desert_ocean;
import com.maikerumine.ESMC.world.biomes.BiomeSavanna;
import com.maikerumine.ESMC.world.biomes.BiomeSavanna_ocean;
import com.maikerumine.ESMC.world.biomes.BiomeSavanna_shore;
import com.maikerumine.ESMC.world.biomes.BiomeSnowy_grassland;
import com.maikerumine.ESMC.world.biomes.BiomeSnowy_grassland_ocean;
import com.maikerumine.ESMC.world.biomes.BiomeStone;
import com.maikerumine.ESMC.world.biomes.BiomeStoneJustTest;
import com.maikerumine.ESMC.world.biomes.BiomeTaiga;
import com.maikerumine.ESMC.world.biomes.BiomeTaiga_ocean;
import com.maikerumine.ESMC.world.biomes.BiomeTundra;
import com.maikerumine.ESMC.world.biomes.BiomeTundra_beach;
import com.maikerumine.ESMC.world.biomes.BiomeTundra_highland;
import com.maikerumine.ESMC.world.biomes.BiomeTundra_ocean;
import com.maikerumine.ESMC.world.biomes.BiomeUnderground;

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
	public static final Biome BEACH = new BiomeBeach();
	public static final Biome RIVER = new BiomeRiver();

	//Minetest Biomes:
	public static final Biome MINETEST = new BiomeMinetest();  //Placeholder for root spawn
	public static final Biome ICESHEET = new BiomeIcesheet();
	public static final Biome ICESHEET_OCEAN = new BiomeIcesheet_ocean();
	public static final Biome TUNDRA_HIGHLAND = new BiomeTundra_highland();
	public static final Biome TUNDRA = new BiomeTundra();
	public static final Biome TUNDRA_BEACH = new BiomeTundra_beach();
	public static final Biome TUNDRA_OCEAN = new BiomeTundra_ocean();
	public static final Biome TAIGA = new BiomeTaiga();
	public static final Biome TAIGA_OCEAN = new BiomeTaiga_ocean();
	public static final Biome SNOWY_GRASSLAND = new BiomeSnowy_grassland();
	public static final Biome SNOWY_GRASSLAND_OCEAN = new BiomeSnowy_grassland_ocean();
	public static final Biome GRASSLAND = new BiomeGrassland();
	public static final Biome GRASSLAND_DUNES = new BiomeGrassland_dunes();
	public static final Biome GRASSLAND_OCEAN = new BiomeGrassland_ocean();
	public static final Biome CONIFEROUS_FOREST = new BiomeConiferous_forest();
	public static final Biome CONIFEROUS_FOREST_DUNES = new BiomeConiferous_forest_dunes();
	public static final Biome CONIFEROUS_FOREST_OCEAN = new BiomeConiferous_forest_ocean();
	public static final Biome DECIDUOUS_FOREST = new BiomeDeciduous_forest();
	public static final Biome DECIDUOUS_FOREST_SHORE = new BiomeDeciduous_forest_shore();
	public static final Biome DECIDUOUS_FOREST_OCEAN = new BiomeDeciduous_forest_ocean();
	public static final Biome DESERT = new BiomeDesert();
	public static final Biome DESERT_OCEAN = new BiomeDesert_ocean();
	public static final Biome SANDSTONE_DESERT = new BiomeSandstone_desert();
	public static final Biome SANDSTONE_DESERT_OCEAN = new BiomeSandstone_desert_ocean();
	public static final Biome COLD_DESERT = new BiomeCold_desert();
	public static final Biome COLD_DESERT_OCEAN = new BiomeCold_desert_ocean();
	public static final Biome SAVANNA = new BiomeSavanna();
	public static final Biome SAVANNA_SHORE = new BiomeSavanna_shore();
	public static final Biome SAVANNA_OCEAN = new BiomeSavanna_ocean();
	public static final Biome RAINFOREST = new BiomeRainforest();
	public static final Biome RAINFOREST_SWAMP = new BiomeRainforest_swamp();
	public static final Biome RAINFOREST_OCEAN = new BiomeRainforest_ocean();
	public static final Biome UNDERGROUND = new BiomeUnderground();

	
	public static void registerBiomes()
	{
		initBiome(STONE, "Stone", BiomeType.WARM, Type.HILLS, Type.MOUNTAIN, Type.DRY);
		initBiome(STONEJT, "Stone Just Test", BiomeType.COOL, Type.HILLS, Type.MOUNTAIN, Type.DRY);
		initBiome(OCEAN, "Esm Ocean", BiomeType.COOL, Type.WET, Type.OCEAN, Type.SPARSE);
		initBiome(BEACH, "Esm Beach", BiomeType.WARM, Type.BEACH, Type.RIVER, Type.WET);
		initBiome(RIVER, "Esm River", BiomeType.COOL, Type.HILLS, Type.RIVER, Type.WET);
	//MINETEST BIOMES W.I.P.
		initBiome(ICESHEET, "BiomeIcesheet", BiomeType.ICY, Type.SPARSE, Type.COLD, Type.DRY);
		initBiome(ICESHEET_OCEAN, "ICESHEET_OCEAN", BiomeType.ICY, Type.OCEAN, Type.COLD, Type.DRY);
		initBiome(TUNDRA_HIGHLAND, "TUNDRA_HIGHLAND", BiomeType.COOL, Type.SNOWY, Type.COLD, Type.HILLS);
		initBiome(TUNDRA, "TUNDRA", BiomeType.COOL, Type.SPARSE, Type.COLD, Type.DRY);
		initBiome(TUNDRA_BEACH, "TUNDRA_BEACH", BiomeType.COOL, Type.BEACH, Type.COLD, Type.DRY);
		initBiome(TUNDRA_OCEAN, "TUNDRA_OCEAN", BiomeType.COOL, Type.OCEAN, Type.COLD, Type.DRY);
		initBiome(TAIGA, "TAIGA", BiomeType.COOL, Type.HILLS, Type.CONIFEROUS, Type.DENSE);
		initBiome(TAIGA_OCEAN, "TAIGA_OCEAN", BiomeType.COOL, Type.OCEAN, Type.COLD, Type.WATER);
		initBiome(SNOWY_GRASSLAND, "SNOWY_GRASSLAND", BiomeType.ICY, Type.SNOWY, Type.PLAINS, Type.DRY);
		initBiome(SNOWY_GRASSLAND_OCEAN, "SNOWY_GRASSLAND_OCEAN", BiomeType.ICY, Type.OCEAN, Type.COLD, Type.WATER);
		initBiome(GRASSLAND, "GRASSLAND", BiomeType.WARM, Type.PLAINS, Type.SPARSE, Type.DRY);
		initBiome(GRASSLAND_DUNES, "GRASSLAND_DUNES", BiomeType.WARM, Type.HILLS, Type.HOT, Type.DRY);
		initBiome(GRASSLAND_OCEAN, "GRASSLAND_OCEAN", BiomeType.WARM, Type.OCEAN, Type.BEACH, Type.SPARSE);
		initBiome(CONIFEROUS_FOREST, "CONIFEROUS_FOREST", BiomeType.COOL, Type.CONIFEROUS, Type.DENSE, Type.DRY);
		initBiome(CONIFEROUS_FOREST_DUNES, "CONIFEROUS_FOREST_DUNES", BiomeType.COOL, Type.BEACH, Type.FOREST, Type.SANDY);
		initBiome(CONIFEROUS_FOREST_OCEAN, "CONIFEROUS_FOREST_OCEAN", BiomeType.COOL, Type.OCEAN, Type.CONIFEROUS, Type.RIVER);
		initBiome(DECIDUOUS_FOREST, "DECIDUOUS_FOREST", BiomeType.WARM, Type.FOREST, Type.DENSE, Type.PLAINS);
		initBiome(DECIDUOUS_FOREST_SHORE, "DECIDUOUS_FOREST_SHORE", BiomeType.WARM, Type.BEACH, Type.FOREST, Type.SANDY);
		initBiome(DECIDUOUS_FOREST_OCEAN, "DECIDUOUS_FOREST_OCEAN", BiomeType.WARM, Type.OCEAN, Type.FOREST, Type.SANDY);
		initBiome(DESERT, "ESM Desert", BiomeType.DESERT, Type.DEAD, Type.HOT, Type.DRY);
		initBiome(DESERT_OCEAN, "DESERT_OCEAN", BiomeType.DESERT, Type.OCEAN, Type.HOT, Type.DRY);
		initBiome(SANDSTONE_DESERT, "SANDSTONE_DESERT", BiomeType.DESERT, Type.SANDY, Type.HOT, Type.DRY);
		initBiome(SANDSTONE_DESERT_OCEAN, "ANDSTONE_DESERT_OCEAN", BiomeType.DESERT, Type.HILLS, Type.HOT, Type.DRY);
		initBiome(COLD_DESERT, "COLD_DESERT", BiomeType.DESERT, Type.SANDY, Type.COLD, Type.DRY);
		initBiome(COLD_DESERT_OCEAN, "COLD_DESERT_OCEAN", BiomeType.ICY, Type.OCEAN, Type.COLD, Type.BEACH);
		initBiome(SAVANNA, "SAVANNA", BiomeType.WARM, Type.HILLS, Type.HOT, Type.DRY);
		initBiome(SAVANNA_SHORE, "SAVANNA_SHORE", BiomeType.WARM, Type.HILLS, Type.HOT, Type.DRY);
		initBiome(SAVANNA_OCEAN, "SAVANNA_OCEAN", BiomeType.WARM, Type.HILLS, Type.HOT, Type.DRY);
		initBiome(RAINFOREST, "RAINFOREST", BiomeType.WARM, Type.JUNGLE, Type.HOT, Type.WET);
		initBiome(RAINFOREST_SWAMP, "RAINFOREST_SWAMP", BiomeType.WARM, Type.JUNGLE, Type.LUSH, Type.SWAMP);
		initBiome(RAINFOREST_OCEAN, "RAINFOREST_OCEAN", BiomeType.WARM, Type.JUNGLE, Type.HOT, Type.WATER);
		initBiome(UNDERGROUND, "UNDERGROUND", BiomeType.DESERT, Type.SPARSE, Type.SPOOKY, Type.MAGICAL);
		initBiome(MINETEST, "MINETEST", BiomeType.DESERT, Type.SPARSE, Type.SPOOKY, Type.MAGICAL);
		
		
	}
	
	private static Biome initBiome(Biome biome, String name, BiomeType biomeType, Type... types)
	{
		biome.setRegistryName(name);
		ForgeRegistries.BIOMES.register(biome);
		BiomeDictionary.addTypes(biome, types);
		BiomeManager.addBiome(biomeType, new BiomeEntry(biome, 1024));			//set to large spread
//		BiomeManager.addBiome(biomeType, new BiomeEntry(biome, 10));			//set to general biome spread
		
		if(ModConfiguration.spawnCustomBiomesInOverworld) 
		{
			BiomeManager.addSpawnBiome(biome);
		}
		return biome;
	}
	
}
