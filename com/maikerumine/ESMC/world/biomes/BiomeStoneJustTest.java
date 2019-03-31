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
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType;
import net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;

import net.minecraft.world.biome.Biome.BiomeProperties;
import net.minecraft.world.biome.Biome.SpawnListEntry;

public class BiomeStoneJustTest extends Biome 
{
	public BiomeStoneJustTest() 
	{
		super(new BiomeProperties("Stone Just Test").func_185398_c(0.4F).func_185400_d(0.2F).func_185396_a().func_185410_a(0.6F));
		
		field_76752_A = Blocks.field_150348_b.func_176223_P();
		field_76753_B = Blocks.field_150348_b.func_176223_P();
		
		
		//this.spawnableCaveCreatureList.clear();
//		this.spawnableCreatureList.clear();
//		this.spawnableMonsterList.clear();
		this.field_76755_L.clear();
		
		this.field_76762_K.add(new SpawnListEntry(EntityStonemonster.class, 5, 1, 5));
		
		
	}
/**	
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
		
		
*/		
	    /**
	     * Allocate a new BiomeDecorator for this BiomeGenBase
	     */
	    public BiomeDecorator func_76729_a()
	    {
//	        return getModdedBiomeDecorator(new BiomeDecorator());
	    	
	    	return getModdedBiomeDecorator(new BiomeDecorator());	    	
	    	
	    }
		
/**		
		@SubscribeEvent()
		public void BiomeDecorator(Decorate event) {
			if(event.getType()==Decorate.EventType.BIG_SHROOM){event.setResult(Event.Result.DENY);}
			if(event.getType()==Decorate.EventType.CACTUS){event.setResult(Event.Result.DENY);}
			if(event.getType()==Decorate.EventType.CLAY){event.setResult(Event.Result.DENY);}
			if(event.getType()==Decorate.EventType.CUSTOM){event.setResult(Event.Result.DENY);}
			if(event.getType()==Decorate.EventType.DEAD_BUSH){event.setResult(Event.Result.DENY);}
			if(event.getType()==Decorate.EventType.DESERT_WELL){event.setResult(Event.Result.DENY);}
			if(event.getType()==Decorate.EventType.FLOWERS){event.setResult(Event.Result.DENY);}
			if(event.getType()==Decorate.EventType.FOSSIL){event.setResult(Event.Result.DENY);}
			if(event.getType()==Decorate.EventType.GRASS){event.setResult(Event.Result.DENY);}
			if(event.getType()==Decorate.EventType.ICE){event.setResult(Event.Result.DENY);}
			if(event.getType()==Decorate.EventType.LAKE_LAVA){event.setResult(Event.Result.DENY);}
			if(event.getType()==Decorate.EventType.LAKE_WATER){event.setResult(Event.Result.DENY);}
			if(event.getType()==Decorate.EventType.LILYPAD){event.setResult(Event.Result.DENY);}
			if(event.getType()==Decorate.EventType.PUMPKIN){event.setResult(Event.Result.DENY);}
			if(event.getType()==Decorate.EventType.REED){event.setResult(Event.Result.DENY);}
			if(event.getType()==Decorate.EventType.ROCK){event.setResult(Event.Result.DENY);}
			if(event.getType()==Decorate.EventType.SAND){event.setResult(Event.Result.DENY);}
			if(event.getType()==Decorate.EventType.SAND_PASS2){event.setResult(Event.Result.DENY);}
			if(event.getType()==Decorate.EventType.SHROOM){event.setResult(Event.Result.DENY);}
			if(event.getType()==Decorate.EventType.TREE){event.setResult(Event.Result.DENY);}
		}

		@SubscribeEvent()
		public void BiomeDecorator(OreGenEvent event) {
			if(((GenerateMinable) event).getType()== OreGenEvent.GenerateMinable.EventType.ANDESITE) {event.setResult(Event.Result.DENY);}
			if(((GenerateMinable) event).getType()== OreGenEvent.GenerateMinable.EventType.COAL) {event.setResult(Event.Result.DENY);}
			if(((GenerateMinable) event).getType()== OreGenEvent.GenerateMinable.EventType.CUSTOM) {event.setResult(Event.Result.DENY);}
			if(((GenerateMinable) event).getType()== OreGenEvent.GenerateMinable.EventType.DIAMOND) {event.setResult(Event.Result.DENY);}
			if(((GenerateMinable) event).getType()== OreGenEvent.GenerateMinable.EventType.DIORITE) {event.setResult(Event.Result.DENY);}
			if(((GenerateMinable) event).getType()== OreGenEvent.GenerateMinable.EventType.DIRT) {event.setResult(Event.Result.DENY);}
			if(((GenerateMinable) event).getType()== OreGenEvent.GenerateMinable.EventType.EMERALD) {event.setResult(Event.Result.DENY);}
			if(((GenerateMinable) event).getType()== OreGenEvent.GenerateMinable.EventType.GOLD) {event.setResult(Event.Result.DENY);}
			if(((GenerateMinable) event).getType()== OreGenEvent.GenerateMinable.EventType.GRANITE) {event.setResult(Event.Result.DENY);}
			if(((GenerateMinable) event).getType()== OreGenEvent.GenerateMinable.EventType.GRAVEL) {event.setResult(Event.Result.DENY);}
			if(((GenerateMinable) event).getType()== OreGenEvent.GenerateMinable.EventType.IRON) {event.setResult(Event.Result.DENY);}
			if(((GenerateMinable) event).getType()== OreGenEvent.GenerateMinable.EventType.LAPIS) {event.setResult(Event.Result.DENY);}
			if(((GenerateMinable) event).getType()== OreGenEvent.GenerateMinable.EventType.QUARTZ) {event.setResult(Event.Result.DENY);}
			if(((GenerateMinable) event).getType()== OreGenEvent.GenerateMinable.EventType.REDSTONE) {event.setResult(Event.Result.DENY);}
			if(((GenerateMinable) event).getType()== OreGenEvent.GenerateMinable.EventType.SILVERFISH) {event.setResult(Event.Result.DENY);}
		}
*/    
	    

}
