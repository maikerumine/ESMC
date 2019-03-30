package com.maikerumine.ESMC.world.generation;

import java.util.Random;

import com.maikerumine.ESMC.init.ModBlocks;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenCustomOres implements IWorldGenerator
{
	private WorldGenerator lag_block;
	private WorldGenerator nyancat_block, mese_block;
	
	public WorldGenCustomOres() 
	{
		nyancat_block = new WorldGenMinable(ModBlocks.NYANCAT_BLOCK.func_176223_P(), 1, BlockMatcher.func_177642_a(Blocks.field_150424_aL));
		lag_block = new WorldGenMinable(ModBlocks.DESERT_STONE.func_176223_P(), 1, BlockMatcher.func_177642_a(Blocks.field_150348_b));
		mese_block = new WorldGenMinable(ModBlocks.MESE_BLOCK.func_176223_P(), 1, BlockMatcher.func_177642_a(Blocks.field_150377_bs));
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) 
	{
		switch(world.field_73011_w.getDimension())
		{
		case -1:
			
			runGenerator(nyancat_block, world, random, chunkX, chunkZ, 10, 0, 100);
			
			break;
			
		case 0:
			
			runGenerator(lag_block, world, random, chunkX, chunkZ, 10, 0, 100);
			
			break;
			
		case 1:
			
			runGenerator(mese_block, world, random, chunkX, chunkZ, 10, 0, 256);
		}
	}
	
	private void runGenerator(WorldGenerator gen, World world, Random rand, int chunkX, int chunkZ, int chance, int minHeight, int maxHeight)
	{
		if(minHeight > maxHeight || minHeight < 0 || maxHeight > 256) throw new IllegalArgumentException("Ore generated out of bounds");
		
		int heightDiff = maxHeight - minHeight + 1;
		for(int i = 0; i < chance; i++)
		{
			int x = chunkX * 16 + rand.nextInt(16);
			int y = minHeight + rand.nextInt(heightDiff);
			int z = chunkZ * 16 + rand.nextInt(16);
			
			gen.func_180709_b(world, rand, new BlockPos(x,y,z));
		}
	}
}
