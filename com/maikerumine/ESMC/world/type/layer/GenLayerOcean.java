package com.maikerumine.ESMC.world.type.layer;

import com.maikerumine.ESMC.init.BiomeInit;

import net.minecraft.init.Biomes;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGeneratorSettings;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerOcean extends GenLayer
{
    public GenLayerOcean(long p_i45472_1_, GenLayer p_i45472_3_)
    {
        super(p_i45472_1_);
        this.field_75909_a = p_i45472_3_;
    }

    /**
     * Returns a list of integer values generated by this layer. These may be interpreted as temperatures, rainfall
     * amounts, or Biome ID's based on the particular GenLayer subclass.
     */
    public int[] func_75904_a(int areaX, int areaY, int areaWidth, int areaHeight)
    {
        int i = areaX - 1;
        int j = areaY - 1;
        int k = areaWidth + 2;
        int l = areaHeight + 2;
        int[] aint = this.field_75909_a.func_75904_a(i, j, k, l);
        int[] aint1 = IntCache.func_76445_a(areaWidth * areaHeight);

        for (int i1 = 0; i1 < areaHeight; ++i1)
        {
            for (int j1 = 0; j1 < areaWidth; ++j1)
            {
                int k1 = aint[j1 + 1 + (i1 + 1 - 1) * (areaWidth + 2)];
                int l1 = aint[j1 + 1 + 1 + (i1 + 1) * (areaWidth + 2)];
                int i2 = aint[j1 + 1 - 1 + (i1 + 1) * (areaWidth + 2)];
                int j2 = aint[j1 + 1 + (i1 + 1 + 1) * (areaWidth + 2)];
                int k2 = aint[j1 + 1 + (i1 + 1) * k];
                int l2 = 0;

                if (k1 == 0)
                {
                    ++l2;
                }

                if (l1 == 0)
                {
                    ++l2;
                }

                if (i2 == 0)
                {
                    ++l2;
                }

                if (j2 == 0)
                {
                    ++l2;
                }

                if (k2 == 0 && l2 > 3)
                {
                    aint1[j1 + i1 * areaWidth] = Biome.func_185362_a(Biomes.field_150575_M);
                }
                else
                {
                    aint1[j1 + i1 * areaWidth] = k2;
                }
            }
        }

        return aint1;
    }
}