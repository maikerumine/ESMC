                                                                                            package com.maikerumine.ESMC.world.biomes;


import java.util.Random;
import java.util.function.Predicate;

import com.maikerumine.ESMC.entity.EntityStonemonster;
import com.maikerumine.ESMC.init.ModBlocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;

import net.minecraft.world.biome.Biome.BiomeProperties;
import net.minecraft.world.biome.Biome.SpawnListEntry;

public class BiomeStoneJustTest extends Biome 
{
	public BiomeStoneJustTest() 
	{
		super(new BiomeProperties("StoneJustTest").func_185398_c(0.4F).func_185400_d(0.2F).func_185396_a().func_185410_a(0.6F));
		
		field_76752_A = Blocks.field_150348_b.func_176223_P();
		field_76753_B = Blocks.field_150348_b.func_176223_P();
		
		
		//this.spawnableCaveCreatureList.clear();
		this.field_76762_K.clear();
		this.field_76761_J.clear();
		this.field_76755_L.clear();
		
		this.field_76762_K.add(new SpawnListEntry(EntityStonemonster.class, 5, 1, 5));
		
		
	}
	
	@SubscribeEvent
	public void onDecorate(Decorate e)
	{
		EventType event_type = e.getType();
		if (event_type == EventType.SAND || event_type == EventType.SAND )
		{
			e.setResult(Result.DENY);
			System.out.println("blocked DIRT event of type " + event_type);
		}
	}
	
		@Override
	    public BiomeDecorator func_76729_a()
	    {
	        return getModdedBiomeDecorator(new BiomeDecorator());
	        
	        
	    }


}
