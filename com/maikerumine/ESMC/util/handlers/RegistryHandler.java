package com.maikerumine.ESMC.util.handlers;

import com.maikerumine.ESMC.init.BiomeInit;
import com.maikerumine.ESMC.init.EntityInit;
import com.maikerumine.ESMC.init.ModBlocks;
import com.maikerumine.ESMC.init.ModItems;
import com.maikerumine.ESMC.util.IHasModel;
import com.maikerumine.ESMC.world.type.WorldTypeDesert;
import com.maikerumine.ESMC.world.type.WorldTypeOcean;
import com.maikerumine.ESMC.world.type.WorldTypeStone;
import com.maikerumine.ESMC.world.type.WorldTypeStoneJustTest;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.world.WorldType;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class RegistryHandler 
{
	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
	}
	
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event)
	{
		event.getRegistry().registerAll(ModBlocks.BLOCKS.toArray(new Block[0]));
	}
	
	
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event)
	{
		for(Item item : ModItems.ITEMS)
		{
			if(item instanceof IHasModel)
			{
				((IHasModel)item).registerModels();
			}
		}
		
		for(Block block : ModBlocks.BLOCKS)
		{
			if(block instanceof IHasModel)
			{
				((IHasModel)block).registerModels();
			}
		}
	}
	
	
	public static void preInitRegistries()
	{
		BiomeInit.registerBiomes();
		
		RenderHandler.registerEntityRenders();
		EntityInit.registerEntities();
	}
	
	public static void postRegistries()
	{
		WorldType STONE = new WorldTypeStone();
		WorldType STONEJUSTTEST = new WorldTypeStoneJustTest();
		WorldType OCEAN = new WorldTypeOcean();
		WorldType DESERT = new WorldTypeDesert();
		
	}
	
	
}
