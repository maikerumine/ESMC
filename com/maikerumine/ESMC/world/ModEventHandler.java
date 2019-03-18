package com.maikerumine.ESMC.world;

import net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ModEventHandler {
	
	////from forge forum:  http://www.minecraftforge.net/forum/topic/53576-1112-remove-overwrite-vanilla-tree-generation/
	/**
	 * Adding all types here
	 * 
	 * 
	 */	
	@SubscribeEvent()
	public void onEvent(Decorate event) {
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
/*
	@SubscribeEvent()
	public void onEvent(OreGenEvent event) {
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
	
	
	//Code from Forge forum by; EmperorZelos
	//  http://www.minecraftforge.net/forum/topic/24010-1710-remove-orespawning/
	@SubscribeEvent(priority=EventPriority.HIGHEST, receiveCanceled=true)
	public void onEvent(OreGenEvent.GenerateMinable event)
	{

		System.out.println("deny the ore damn it");
		event.setResult(Result.DENY);
	}
	
	
}
	
