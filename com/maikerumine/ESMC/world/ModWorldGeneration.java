package com.maikerumine.ESMC.world;

import java.util.Random;

import com.maikerumine.ESMC.init.ModBlocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class ModWorldGeneration implements IWorldGenerator {
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) 
	{
		if (world.field_73011_w.getDimension() == 0) 
		{
			generateOverworld(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
		}
	}
	
	private void generateOverworld(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) 
	{
		generateOre(ModBlocks.AIKERUM_ORE_BLOCK.func_176223_P(), world, random, chunkX * 16, chunkZ * 16, 16, 32, random.nextInt(3) + 1, 2);
		generateOre(ModBlocks.COPPER_ORE_BLOCK.func_176223_P(), world, random, chunkX * 16, chunkZ * 16, 16, 256, random.nextInt(5) + 4, 6);
		generateOre(ModBlocks.DEPLETED_URANIUM_ORE_BLOCK.func_176223_P(), world, random, chunkX * 16, chunkZ * 16, 16, 64, random.nextInt(3) + 4, 2);
		generateOre(ModBlocks.INFINIUM_ORE_BLOCK.func_176223_P(), world, random, chunkX * 16, chunkZ * 16, 16, 32, random.nextInt(3) + 2, 2);
		generateOre(ModBlocks.MESE_ORE_BLOCK.func_176223_P(), world, random, chunkX * 16, chunkZ * 16, 16, 32, random.nextInt(2) + 2, 2);
		generateOre(ModBlocks.MESE_BLOCK.func_176223_P(), world, random, chunkX * 16, chunkZ * 16, 16, 32, random.nextInt(2) + 3, 2);
		generateOre(ModBlocks.PURPELLIUM_ORE_BLOCK.func_176223_P(), world, random, chunkX * 16, chunkZ * 16, 16, 32, random.nextInt(3) + 1, 3);
		generateOre(ModBlocks.RUBY_ORE_BLOCK.func_176223_P(), world, random, chunkX * 16, chunkZ * 16, 16, 32, random.nextInt(3) + 1, 3);
		generateOre(ModBlocks.NYANCAT_BLOCK.func_176223_P(), world, random, chunkX * 16, chunkZ * 16, 16, 256, random.nextInt(2) + 1, 1);
		generateOre(ModBlocks.RAINBOW_BLOCK.func_176223_P(), world, random, chunkX * 16, chunkZ * 16, 16, 256, random.nextInt(2) + 1, 1);
//		generateOre(ModBlocks.TOXIC_WATER_FLUID.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 16, 64, random.nextInt(5) + 4, 2);
		
		//Default esque
		generateOre(ModBlocks.IRON_ORE_BLOCK.func_176223_P(), world, random, chunkX * 16, chunkZ * 16, 16, 256, random.nextInt(5) + 4, 6);
		generateOre(ModBlocks.TIN_ORE_BLOCK.func_176223_P(), world, random, chunkX * 16, chunkZ * 16, 16, 256, random.nextInt(5) + 4, 6);
		generateOre(ModBlocks.COAL_ORE_BLOCK.func_176223_P(), world, random, chunkX * 16, chunkZ * 16, 16, 256, random.nextInt(5) + 5, 7);
		generateOre(ModBlocks.DIAMOND_ORE_BLOCK.func_176223_P(), world, random, chunkX * 16, chunkZ * 16, 16, 32, random.nextInt(3) + 2, 4);
		generateOre(ModBlocks.REDSTONE_ORE_BLOCK.func_176223_P(), world, random, chunkX * 16, chunkZ * 16, 16, 32, random.nextInt(5) + 4, 6);
		generateOre(ModBlocks.EMERALD_ORE_BLOCK.func_176223_P(), world, random, chunkX * 16, chunkZ * 16, 16, 32, random.nextInt(3) + 2, 2);
		generateOre(ModBlocks.LAPIS_ORE_BLOCK.func_176223_P(), world, random, chunkX * 16, chunkZ * 16, 16, 32, random.nextInt(3) + 2, 2);
		generateOre(ModBlocks.GOLD_ORE_BLOCK.func_176223_P(), world, random, chunkX * 16, chunkZ * 16, 16, 32, random.nextInt(3) + 2, 5);
		
		generateOre(Blocks.field_150418_aU.func_176223_P(), world, random, chunkX * 16, chunkZ * 16, 16, 128, random.nextInt(3) + 2, 2);
//		generateOre(Blocks.WATER.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 16, 256, random.nextInt(3) + 2, 2);
//		generateOre(Blocks.LAVA.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 16, 256, random.nextInt(3) + 2, 2);
	}
	
	private void generateOre(IBlockState ore, World world, Random random, int x, int z, int minY, int maxY, int size, int chances) 
	{
		int deltaY = maxY - minY;
		
		for (int i = 0; i < chances; i++) {
			BlockPos pos = new BlockPos(x + random.nextInt(16), minY + random.nextInt(deltaY), z + random.nextInt(16));
			
			WorldGenMinable generator = new WorldGenMinable(ore, size);
			generator.func_180709_b(world, random, pos);
		}
	}
}
