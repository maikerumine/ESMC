/**
    Copyright (C) 2017 by jabelar

    This file is part of jabelar's Minecraft Forge modding examples; as such,
    you can redistribute it and/or modify it under the terms of the GNU
    General Public License as published by the Free Software Foundation,
    either version 3 of the License, or (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
    GNU General Public License for more details.

    For a copy of the GNU General Public License see <http://www.gnu.org/licenses/>.
*/
package com.maikerumine.ESMC.world.generation.generators;

import java.util.Random;

import com.maikerumine.ESMC.init.ModBlocks;
import com.google.common.base.Predicate;

import net.minecraft.block.BlockStone;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenLiquids;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.event.terraingen.TerrainGen;

// TODO: Auto-generated Javadoc
public class BiomeDecoratorDesert extends BiomeDecorator
{ 
    // This predicate is used by WorldGen constructors to define
    // whether a block can be replaced by ore generation.
    Predicate<IBlockState> replaceablePredicate = new CloudPredicate();
    
    // If you want to make these configurable, you'll need a ChunkGeneratorSettings
    // instance and use the fields from there instead.
    private int dirtSize = 33;
    private int gravelSize = 33;
    private int graniteSize = 33;
    private int dioriteSize = 33;
    private int andesiteSize = 33;
    private int coalSize = 17;
    private int ironSize = 9;
    private int goldSize = 9;
    private int redstoneSize = 9;
    private int diamondSize = 8;
    private int lapisSize = 8;

    private int dirtCount = 10;
    private int gravelCount = 8;
    private int dioriteCount = 10;
    private int graniteCount = 10;
    private int andesiteCount = 10;
    private int coalCount = 20;
    private int ironCount = 20;
    private int goldCount = 2;
    private int redstoneCount = 8;
    private int diamondCount = 1;
    private int lapisCount = 1;
    
    private int lapisCenterHeight =6;
    private int lapisSpread = 16;

    private int oreGenMinHeight = 0;

    private int dirtMaxHeight = 255;
    private int gravelMaxHeight = 255;
    private int dioriteMaxHeight = 80;
    private int graniteMaxHeight = 80;
    private int andesiteMaxHeight = 80;
    private int coalMaxHeight = 126;
    private int ironMaxHeight = 64;
    private int goldMaxHeight = 32;
    private int redstoneMaxHeight = 16;
    private int diamondMaxHeight = 16;
    
//    protected WorldGenFlowersCloud flowerGen;

    /**
     * Instantiates a new biome decorator cloud.
     */
    public BiomeDecoratorDesert()
    {
        super();
        
        // Must use predicate version if you wnat to replace custom blocks, otherwise will
        // only replace Blocks.STONE.
        field_76823_i = new WorldGenMinable(Blocks.field_150346_d.func_176223_P(), dirtSize, replaceablePredicate);
        field_76820_j = new WorldGenMinable(Blocks.field_150351_n.func_176223_P(), gravelSize, replaceablePredicate);
        field_180296_j = new WorldGenMinable(Blocks.field_150348_b.func_176223_P().func_177226_a(BlockStone.field_176247_a, BlockStone.EnumType.GRANITE), graniteSize, replaceablePredicate);
        field_180297_k = new WorldGenMinable(Blocks.field_150348_b.func_176223_P().func_177226_a(BlockStone.field_176247_a, BlockStone.EnumType.DIORITE), dioriteSize, replaceablePredicate);
        field_180295_l = new WorldGenMinable(Blocks.field_150348_b.func_176223_P().func_177226_a(BlockStone.field_176247_a, BlockStone.EnumType.ANDESITE), andesiteSize, replaceablePredicate);
        field_76821_k = new WorldGenMinable(Blocks.field_150365_q.func_176223_P(), coalSize, replaceablePredicate);
        field_76818_l = new WorldGenMinable(Blocks.field_150366_p.func_176223_P(), ironSize, replaceablePredicate);
        field_76819_m = new WorldGenMinable(Blocks.field_150352_o.func_176223_P(), goldSize, replaceablePredicate);
        field_180299_p = new WorldGenMinable(Blocks.field_150450_ax.func_176223_P(), redstoneSize, replaceablePredicate);
        field_180298_q = new WorldGenMinable(Blocks.field_150482_ag.func_176223_P(), diamondSize, replaceablePredicate);
        field_76831_p = new WorldGenMinable(Blocks.field_150369_x.func_176223_P(), lapisSize, replaceablePredicate);
    }

    /**
     *  
     * This is the function where ore generation and things like flowers are generated.
     *
     * @param worldIn the world in
     * @param random the random
     * @param biome the biome
     * @param pos the pos
     */
    @Override
    public void func_180292_a(World worldIn, Random random, Biome biome, BlockPos pos)
    {
        if (field_185425_a)
        {
            throw new RuntimeException("Already decorating");
        }
        else
        {
            field_180294_c = pos;
            func_150513_a(biome, worldIn, random);
            field_185425_a = false;
        }
    }
    
    /**
     * This is where things like trees are generated.
     *
     * @param biomeIn the biome in
     * @param worldIn the world in
     * @param random the random
     */
    @Override
    protected void func_150513_a(Biome biomeIn, World worldIn, Random random)
    {
        MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Pre(worldIn, random, field_180294_c));

        func_76797_b(worldIn, random);

        generate(worldIn, random, field_180294_c, DecorateBiomeEvent.Decorate.EventType.SAND, field_76810_g, field_76805_H);
        generate(worldIn, random, field_180294_c, DecorateBiomeEvent.Decorate.EventType.CLAY, field_76809_f, field_76806_I);
        generate(worldIn, random, field_180294_c, DecorateBiomeEvent.Decorate.EventType.SAND_PASS2, field_76822_h, field_76801_G);
        generate(worldIn, random, field_180294_c, DecorateBiomeEvent.Decorate.EventType.SAND_PASS2, field_76822_h, field_76801_G);
        generateTrees(worldIn, biomeIn, random, field_180294_c);
        generateFlowers(worldIn, biomeIn, random, field_180294_c);
        generateGrass(worldIn, biomeIn, random, field_180294_c);

        if (field_76808_K)
        {
            generateFalls(worldIn, random, field_180294_c);
        }
        MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Post(worldIn, random, field_180294_c));
    }
    
    private void generateTrees(World worldIn, Biome biomeIn, Random random, BlockPos chunkPos)
    {
        int treesToGen = field_76832_z;

        if (random.nextFloat() < field_189870_A)
        {
            ++treesToGen;
        }

        if(TerrainGen.decorate(worldIn, random, chunkPos, DecorateBiomeEvent.Decorate.EventType.TREE))
        for (int numTreesGenerated = 0; numTreesGenerated < treesToGen; ++numTreesGenerated)
        {
            int treeX = random.nextInt(16) + 8;
            int treeZ = random.nextInt(16) + 8;
            WorldGenAbstractTree treeGen = biomeIn.func_150567_a(random);
            treeGen.func_175904_e();
            BlockPos blockpos = worldIn.func_175645_m(chunkPos.func_177982_a(treeX, 0, treeZ));

            if (treeGen.func_180709_b(worldIn, random, blockpos))
            {
                treeGen.func_180711_a(worldIn, random, blockpos);
            }
        }
    }
    
    private void generateFlowers(World worldIn, Biome biomeIn, Random random, BlockPos chunkPos)
    {
        if(TerrainGen.decorate(worldIn, random, chunkPos, DecorateBiomeEvent.Decorate.EventType.FLOWERS))
        for (int numFlowersGenerated = 0; numFlowersGenerated < field_76802_A; ++numFlowersGenerated)
        {
            int flowerX = random.nextInt(16) + 8;
            int flowerZ = random.nextInt(16) + 8;
            int yRange = worldIn.func_175645_m(chunkPos.func_177982_a(flowerX, 0, flowerZ)).func_177956_o() + 32;

//            flowerGen = new WorldGenFlowersCloud();
            
            if (yRange > 0)
            {
                int flowerY = random.nextInt(yRange);
                BlockPos flowerBlockPos = chunkPos.func_177982_a(flowerX, flowerY, flowerZ);
                field_150514_p.func_180709_b(worldIn, random, flowerBlockPos);
            }
        }
    }
    
    private void generateGrass(World worldIn, Biome biomeIn, Random random, BlockPos chunkPos)
    {
        if(TerrainGen.decorate(worldIn, random, chunkPos, DecorateBiomeEvent.Decorate.EventType.GRASS))
        for (int numGrassPerChunk = 0; numGrassPerChunk < field_76803_B; ++numGrassPerChunk)
        {
            int grassX = random.nextInt(16) + 8;
            int grassZ = random.nextInt(16) + 8;
            int yRange = worldIn.func_175645_m(chunkPos.func_177982_a(grassX, 0, grassZ)).func_177956_o() * 2;

            if (yRange > 0)
            {
                int grassY = random.nextInt(yRange);
                biomeIn.func_76730_b(random).func_180709_b(worldIn, random, chunkPos.func_177982_a(grassX, grassY, grassZ));
            }
        }
    }
    
    private void generateFalls(World worldIn, Random random, BlockPos chunkPos)
    {
        if(TerrainGen.decorate(worldIn, random, chunkPos, DecorateBiomeEvent.Decorate.EventType.LAKE_WATER))
        for (int k5 = 0; k5 < 50; ++k5)
        {
            int i10 = random.nextInt(16) + 8;
            int l13 = random.nextInt(16) + 8;
            int i17 = random.nextInt(248) + 8;

            if (i17 > 0)
            {
                int k19 = random.nextInt(i17);
                BlockPos blockpos6 = chunkPos.func_177982_a(i10, k19, l13);
                (new WorldGenLiquids(Blocks.field_150358_i)).func_180709_b(worldIn, random, blockpos6);
            }
        }

        if(TerrainGen.decorate(worldIn, random, chunkPos, DecorateBiomeEvent.Decorate.EventType.LAKE_LAVA))
        for (int l5 = 0; l5 < 20; ++l5)
        {
            int j10 = random.nextInt(16) + 8;
            int i14 = random.nextInt(16) + 8;
            int j17 = random.nextInt(random.nextInt(random.nextInt(240) + 8) + 8);
            BlockPos blockpos3 = chunkPos.func_177982_a(j10, j17, i14);
            (new WorldGenLiquids(Blocks.field_150356_k)).func_180709_b(worldIn, random, blockpos3);
        }
    }

    private void generate(World worldIn, Random random, BlockPos chunkPos, EventType eventType, WorldGenerator generator, int countPerChunk)
    {
        if(TerrainGen.decorate(worldIn, random, chunkPos, eventType))
        {
            for (int count = 0; count < countPerChunk; ++count)
            {
                int randX = random.nextInt(16) + 8;
                int randZ = random.nextInt(16) + 8;
                generator.func_180709_b(worldIn, random, worldIn.func_175672_r(chunkPos.func_177982_a(randX, 0, randZ)));
            }
        }
    }

    /**
     * Generates ores in the current chunk.
     *
     * @param worldIn the world in
     * @param random the random
     */
    @Override
    protected void func_76797_b(World worldIn, Random random)
    {
        MinecraftForge.ORE_GEN_BUS.post(new OreGenEvent.Pre(worldIn, random, field_180294_c));
        if (TerrainGen.generateOre(worldIn, random, field_76823_i, field_180294_c, OreGenEvent.GenerateMinable.EventType.DIRT))
        func_76795_a(worldIn, random, dirtCount, field_76823_i, oreGenMinHeight, dirtMaxHeight);
        if (TerrainGen.generateOre(worldIn, random, field_76820_j, field_180294_c, OreGenEvent.GenerateMinable.EventType.GRAVEL))
        func_76795_a(worldIn, random, gravelCount, field_76820_j, oreGenMinHeight, gravelMaxHeight);
        if (TerrainGen.generateOre(worldIn, random, field_180297_k, field_180294_c, OreGenEvent.GenerateMinable.EventType.DIORITE))
        func_76795_a(worldIn, random, dioriteCount, field_180297_k, oreGenMinHeight, dioriteMaxHeight);
        if (TerrainGen.generateOre(worldIn, random, field_180296_j, field_180294_c, OreGenEvent.GenerateMinable.EventType.GRANITE))
        func_76795_a(worldIn, random, graniteCount, field_180296_j, oreGenMinHeight, graniteMaxHeight);
        if (TerrainGen.generateOre(worldIn, random, field_180295_l, field_180294_c, OreGenEvent.GenerateMinable.EventType.ANDESITE))
        func_76795_a(worldIn, random, andesiteCount, field_180295_l, oreGenMinHeight, andesiteMaxHeight);
        if (TerrainGen.generateOre(worldIn, random, field_76821_k, field_180294_c, OreGenEvent.GenerateMinable.EventType.COAL))
        func_76795_a(worldIn, random, coalCount, field_76821_k, oreGenMinHeight, coalMaxHeight);
        if (TerrainGen.generateOre(worldIn, random, field_76818_l, field_180294_c, OreGenEvent.GenerateMinable.EventType.IRON))
        func_76795_a(worldIn, random, ironCount, field_76818_l, oreGenMinHeight, ironMaxHeight);
        if (TerrainGen.generateOre(worldIn, random, field_76819_m, field_180294_c, OreGenEvent.GenerateMinable.EventType.GOLD))
        func_76795_a(worldIn, random, goldCount, field_76819_m, oreGenMinHeight, goldMaxHeight);
        if (TerrainGen.generateOre(worldIn, random, field_180299_p, field_180294_c, OreGenEvent.GenerateMinable.EventType.REDSTONE))
        func_76795_a(worldIn, random, redstoneCount, field_180299_p, oreGenMinHeight, redstoneMaxHeight);
        if (TerrainGen.generateOre(worldIn, random, field_180298_q, field_180294_c, OreGenEvent.GenerateMinable.EventType.DIAMOND))
        func_76795_a(worldIn, random, diamondCount, field_180298_q, oreGenMinHeight, diamondMaxHeight);
        if (TerrainGen.generateOre(worldIn, random, field_76831_p, field_180294_c, OreGenEvent.GenerateMinable.EventType.LAPIS))
        func_76793_b(worldIn, random, lapisCount, field_76831_p, lapisCenterHeight, lapisSpread);
        MinecraftForge.ORE_GEN_BUS.post(new OreGenEvent.Post(worldIn, random, field_180294_c));
    }

    static class CloudPredicate implements Predicate<IBlockState>
    {
        private CloudPredicate()
        {
        }

        /* (non-Javadoc)
         * @see com.google.common.base.Predicate#apply(java.lang.Object)
         */
        @Override
        public boolean apply(IBlockState parBlockState)
        {
            if (parBlockState != null && parBlockState.func_177230_c() == ModBlocks.CURSED_STONE_BLOCK)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }
}
