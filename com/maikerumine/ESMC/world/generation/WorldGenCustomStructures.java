package com.maikerumine.ESMC.world.generation;

import java.util.ArrayList;
import java.util.Random;

import com.maikerumine.ESMC.init.ModBlocks;
import com.maikerumine.ESMC.world.biomes.BiomeStone;
import com.maikerumine.ESMC.world.generation.generators.WorldGenStructure;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import scala.actors.threadpool.Arrays;

public class WorldGenCustomStructures implements IWorldGenerator
{
	public static final WorldGenStructure ARMOURY = new WorldGenStructure("armoury");
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) 
	{
		switch(world.field_73011_w.getDimension())
		{
		case 2:
			
			break;
			
		case 1:
			
			break;
			
		case 0:
			
			generateStructure(ARMOURY, world, random, chunkX, chunkZ, 20, Blocks.field_150348_b, BiomeStone.class);
			
			break;
			
		case -1:
			
		}
	}
	
	private void generateStructure(WorldGenerator generator, World world, Random random, int chunkX, int chunkZ, int chance, Block topBlock, Class<?>... classes)
	{
		ArrayList<Class<?>> classesList = new ArrayList<Class<?>>(Arrays.asList(classes));
		
		int x = (chunkX * 16) + random.nextInt(15);
		int z = (chunkZ * 16) + random.nextInt(15);
		int y = calculateGenerationHeight(world, x, z, topBlock);
		BlockPos pos = new BlockPos(x,y,z);
		
		Class<?> biome = world.field_73011_w.getBiomeForCoords(pos).getClass();
		
		if(world.func_175624_G() != WorldType.field_77138_c)
		{
			if(classesList.contains(biome))
			{
				if(random.nextInt(chance) == 0)
				{
					generator.func_180709_b(world, random, pos);
				}
			}
		}
	}
	
	private static int calculateGenerationHeight(World world, int x, int z, Block topBlock)
	{
		int y = world.func_72800_K();
		boolean foundGround = false;
		
		while(!foundGround && y-- >= 0)
		{
			Block block = world.func_180495_p(new BlockPos(x,y,z)).func_177230_c();
			foundGround = block == topBlock;
		}
		
		return y;
	}
}
