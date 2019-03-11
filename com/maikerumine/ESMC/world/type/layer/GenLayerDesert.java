package com.maikerumine.ESMC.world.type.layer;

import com.maikerumine.ESMC.init.BiomeInit;

import net.minecraft.init.Biomes;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGeneratorSettings;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerDesert extends GenLayer
{
    @SuppressWarnings("unchecked")
    private java.util.List<net.minecraftforge.common.BiomeManager.BiomeEntry>[] biomes = new java.util.ArrayList[net.minecraftforge.common.BiomeManager.BiomeType.values().length];
    private final ChunkGeneratorSettings settings;

    public GenLayerDesert(long p_i45560_1_, GenLayer p_i45560_3_, WorldType p_i45560_4_, ChunkGeneratorSettings p_i45560_5_)
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

        biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(Biomes.field_76769_d, 30));


        if (p_i45560_4_ == WorldType.field_77136_e)
        {
            biomes[desertIdx].clear();
            biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(Biomes.field_76769_d, 10));

            biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(Biomes.field_150575_M, 10));
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
