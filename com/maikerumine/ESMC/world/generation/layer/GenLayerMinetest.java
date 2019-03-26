package com.maikerumine.ESMC.world.generation.layer;


import com.maikerumine.ESMC.init.BiomeInit;
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
import com.maikerumine.ESMC.world.biomes.BiomeRainforest;
import com.maikerumine.ESMC.world.biomes.BiomeRainforest_ocean;
import com.maikerumine.ESMC.world.biomes.BiomeRainforest_swamp;
import com.maikerumine.ESMC.world.biomes.BiomeSandstone_desert;
import com.maikerumine.ESMC.world.biomes.BiomeSandstone_desert_ocean;
import com.maikerumine.ESMC.world.biomes.BiomeSavanna;
import com.maikerumine.ESMC.world.biomes.BiomeSavanna_ocean;
import com.maikerumine.ESMC.world.biomes.BiomeSavanna_shore;
import com.maikerumine.ESMC.world.biomes.BiomeSnowy_grassland;
import com.maikerumine.ESMC.world.biomes.BiomeSnowy_grassland_ocean;
import com.maikerumine.ESMC.world.biomes.BiomeTaiga;
import com.maikerumine.ESMC.world.biomes.BiomeTaiga_ocean;
import com.maikerumine.ESMC.world.biomes.BiomeTundra;
import com.maikerumine.ESMC.world.biomes.BiomeTundra_beach;
import com.maikerumine.ESMC.world.biomes.BiomeTundra_highland;
import com.maikerumine.ESMC.world.biomes.BiomeTundra_ocean;
import com.maikerumine.ESMC.world.biomes.BiomeUnderground;

import net.minecraft.init.Biomes;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGeneratorSettings;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerMinetest extends GenLayer
{
    @SuppressWarnings("unchecked")
    private java.util.List<net.minecraftforge.common.BiomeManager.BiomeEntry>[] biomes = new java.util.ArrayList[net.minecraftforge.common.BiomeManager.BiomeType.values().length];
    private final ChunkGeneratorSettings settings;

    public GenLayerMinetest(long p_i45560_1_, GenLayer p_i45560_3_, WorldType p_i45560_4_, ChunkGeneratorSettings p_i45560_5_)
    {
        super(p_i45560_1_);
        this.field_75909_a = p_i45560_3_;

        for (net.minecraftforge.common.BiomeManager.BiomeType type : net.minecraftforge.common.BiomeManager.BiomeType.values())
        {
            com.google.common.collect.ImmutableList<net.minecraftforge.common.BiomeManager.BiomeEntry> biomesToAdd = net.minecraftforge.common.BiomeManager.getBiomes(type);
            int idx = type.ordinal();

            if (biomes[idx] == null) biomes[idx] = new java.util.ArrayList<net.minecraftforge.common.BiomeManager.BiomeEntry>();
            if (biomesToAdd != null) biomes[idx].addAll(biomesToAdd);
        }

        int desertIdx = net.minecraftforge.common.BiomeManager.BiomeType.DESERT.ordinal();
/**
 * 
 * 	public static final Biome MINETEST = new BiomeMinetest();  //Placeholder for root spawn
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

 */
//        biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(Biomes.DESERT, 30));
//        biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(Biomes.SAVANNA, 20));
//        biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(Biomes.PLAINS, 10));
//        biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(Biomes.EXTREME_HILLS, 1));
        biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(BiomeInit.MINETEST, 10));				//TEST BIOME
        biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(BiomeInit.RIVER, 1024));
        biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(BiomeInit.ICESHEET, 1024));
        biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(BiomeInit.ICESHEET_OCEAN, 1024));
        biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(BiomeInit.TUNDRA_HIGHLAND, 1024));
        biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(BiomeInit.TUNDRA, 1024));
        biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(BiomeInit.TUNDRA_BEACH, 1024));
        biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(BiomeInit.TUNDRA_OCEAN, 1024));
        biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(BiomeInit.TAIGA, 1024));
        biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(BiomeInit.TAIGA_OCEAN, 1024));
        biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(BiomeInit.SNOWY_GRASSLAND, 1024));
        biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(BiomeInit.SNOWY_GRASSLAND_OCEAN, 1024));
        biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(BiomeInit.GRASSLAND, 1024));
        biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(BiomeInit.GRASSLAND_DUNES, 1024));
        biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(BiomeInit.GRASSLAND_OCEAN, 1024));
        biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(BiomeInit.CONIFEROUS_FOREST, 1024));
        biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(BiomeInit.CONIFEROUS_FOREST_DUNES, 1024));
        biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(BiomeInit.CONIFEROUS_FOREST_OCEAN, 1024));
        biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(BiomeInit.DECIDUOUS_FOREST, 1024));
        biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(BiomeInit.DECIDUOUS_FOREST_SHORE, 1024));
        biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(BiomeInit.DECIDUOUS_FOREST_OCEAN, 1024));
        biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(BiomeInit.SANDSTONE_DESERT, 1024));
        biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(BiomeInit.SANDSTONE_DESERT_OCEAN, 1024));
        biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(BiomeInit.COLD_DESERT, 1024));
        biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(BiomeInit.COLD_DESERT_OCEAN, 1024));
        biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(BiomeInit.SAVANNA, 1024));
        biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(BiomeInit.SAVANNA_SHORE, 1024));
        biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(BiomeInit.SAVANNA_OCEAN, 1024));
        biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(BiomeInit.RAINFOREST, 1024));
        biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(BiomeInit.RAINFOREST_SWAMP, 1024));
        biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(BiomeInit.RAINFOREST_OCEAN, 1024));
        biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(BiomeInit.UNDERGROUND, 10));		//TEST BIOME



        if (p_i45560_4_ == WorldType.field_77136_e)
        {
            biomes[desertIdx].clear();
//            biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(Biomes.EXTREME_HILLS, 10));
            biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(BiomeInit.MINETEST, 10));				//TEST BIOME
            biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(BiomeInit.RIVER, 200));
            biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(BiomeInit.ICESHEET, 200));
            biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(BiomeInit.ICESHEET_OCEAN, 200));
            biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(BiomeInit.TUNDRA_HIGHLAND, 200));
            biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(BiomeInit.TUNDRA, 200));
            biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(BiomeInit.TUNDRA_BEACH, 200));
            biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(BiomeInit.TUNDRA_OCEAN, 200));
            biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(BiomeInit.TAIGA, 200));
            biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(BiomeInit.TAIGA_OCEAN, 200));
            biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(BiomeInit.SNOWY_GRASSLAND, 200));
            biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(BiomeInit.SNOWY_GRASSLAND_OCEAN, 200));
            biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(BiomeInit.GRASSLAND, 200));
            biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(BiomeInit.GRASSLAND_DUNES, 200));
            biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(BiomeInit.GRASSLAND_OCEAN, 200));
            biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(BiomeInit.CONIFEROUS_FOREST, 200));
            biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(BiomeInit.CONIFEROUS_FOREST_DUNES, 200));
            biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(BiomeInit.CONIFEROUS_FOREST_OCEAN, 200));
            biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(BiomeInit.DECIDUOUS_FOREST, 200));
            biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(BiomeInit.DECIDUOUS_FOREST_SHORE, 200));
            biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(BiomeInit.DECIDUOUS_FOREST_OCEAN, 200));
            biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(BiomeInit.SANDSTONE_DESERT, 200));
            biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(BiomeInit.SANDSTONE_DESERT_OCEAN, 200));
            biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(BiomeInit.COLD_DESERT, 200));
            biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(BiomeInit.COLD_DESERT_OCEAN, 200));
            biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(BiomeInit.SAVANNA, 200));
            biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(BiomeInit.SAVANNA_SHORE, 200));
            biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(BiomeInit.SAVANNA_OCEAN, 200));
            biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(BiomeInit.RAINFOREST, 200));
            biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(BiomeInit.RAINFOREST_SWAMP, 200));
            biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(BiomeInit.RAINFOREST_OCEAN, 200));
            biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(BiomeInit.UNDERGROUND, 10));		//TEST BIOME
            this.settings = null;
        }
        else
        {
            this.settings = p_i45560_5_;
        }
    }

    /**
     * Returns a list of integer values generated by this layer. These may be interpreted as temperatures, rainfall
     * amounts, or Biome ID's based on the particular GenLayer subclass.
     */
    public int[] func_75904_a(int areaX, int areaY, int areaWidth, int areaHeight)
    {
        int[] aint = this.field_75909_a.func_75904_a(areaX, areaY, areaWidth, areaHeight);
        int[] aint1 = IntCache.func_76445_a(areaWidth * areaHeight);

        for (int i = 0; i < areaHeight; ++i)
        {
            for (int j = 0; j < areaWidth; ++j)
            {
                this.func_75903_a((long)(j + areaX), (long)(i + areaY));
                int k = aint[j + i * areaWidth];
                int l = (k & 3840) >> 8;
                k = k & -3841;

                if (this.settings != null && this.settings.field_177779_F >= 0)
                {
                    aint1[j + i * areaWidth] = this.settings.field_177779_F;
                }
                else if (func_151618_b(k))
                {
                    aint1[j + i * areaWidth] = k;
                }
                else if (k == Biome.func_185362_a(Biomes.field_76789_p))
                {
                    aint1[j + i * areaWidth] = k;
                }
                else if (k == 1)
                {
                    if (l > 0)
                    {
                        if (this.func_75902_a(3) == 0)
                        {
                            aint1[j + i * areaWidth] = Biome.func_185362_a(Biomes.field_150608_ab);
                        }
                        else
                        {
                            aint1[j + i * areaWidth] = Biome.func_185362_a(Biomes.field_150607_aa);
                        }
                    }
                    else
                    {
                        aint1[j + i * areaWidth] = Biome.func_185362_a(getWeightedBiomeEntry(net.minecraftforge.common.BiomeManager.BiomeType.DESERT).biome);
                    }
                }
                else if (k == 2)
                {
                    if (l > 0)
                    {
                        aint1[j + i * areaWidth] = Biome.func_185362_a(Biomes.field_76782_w);
                    }
                    else
                    {
                        aint1[j + i * areaWidth] = Biome.func_185362_a(getWeightedBiomeEntry(net.minecraftforge.common.BiomeManager.BiomeType.WARM).biome);
                    }
                }
                else if (k == 3)
                {
                    if (l > 0)
                    {
                        aint1[j + i * areaWidth] = Biome.func_185362_a(Biomes.field_150578_U);
                    }
                    else
                    {
                        aint1[j + i * areaWidth] = Biome.func_185362_a(getWeightedBiomeEntry(net.minecraftforge.common.BiomeManager.BiomeType.COOL).biome);
                    }
                }
                else if (k == 4)
                {
                    aint1[j + i * areaWidth] = Biome.func_185362_a(getWeightedBiomeEntry(net.minecraftforge.common.BiomeManager.BiomeType.ICY).biome);
                }
                else
                {
                    aint1[j + i * areaWidth] = Biome.func_185362_a(Biomes.field_76789_p);
                }
            }
        }

        return aint1;
    }

    protected net.minecraftforge.common.BiomeManager.BiomeEntry getWeightedBiomeEntry(net.minecraftforge.common.BiomeManager.BiomeType type)
    {
        java.util.List<net.minecraftforge.common.BiomeManager.BiomeEntry> biomeList = biomes[type.ordinal()];
        int totalWeight = net.minecraft.util.WeightedRandom.func_76272_a(biomeList);
        int weight = net.minecraftforge.common.BiomeManager.isTypeListModded(type)?func_75902_a(totalWeight):func_75902_a(totalWeight / 10) * 10;
        return (net.minecraftforge.common.BiomeManager.BiomeEntry)net.minecraft.util.WeightedRandom.func_180166_a(biomeList, weight);
    }
}
