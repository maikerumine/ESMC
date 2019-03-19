package com.maikerumine.ESMC.util.handlers;

import com.maikerumine.ESMC.Main;
import com.maikerumine.ESMC.blocks.tileentities.TileEntityEsmChest;
import com.maikerumine.ESMC.enchantments.EnchantmentSuperBoots;
import com.maikerumine.ESMC.init.BiomeInit;
import com.maikerumine.ESMC.init.EnchantmentInit;
import com.maikerumine.ESMC.init.EntityInit;
import com.maikerumine.ESMC.init.FluidInit;
import com.maikerumine.ESMC.init.ModBlocks;
import com.maikerumine.ESMC.init.ModItems;
import com.maikerumine.ESMC.rendering.RenderEsmChest;
import com.maikerumine.ESMC.util.ModConfiguration;
import com.maikerumine.ESMC.util.interfaces.IHasModel;
import com.maikerumine.ESMC.world.generation.WorldGenCustomOres;
import com.maikerumine.ESMC.world.generation.WorldGenCustomStructures;
import com.maikerumine.ESMC.world.generation.WorldGenCustomTrees;
import com.maikerumine.ESMC.world.type.WorldTypeDesert;
import com.maikerumine.ESMC.world.type.WorldTypeOcean;
import com.maikerumine.ESMC.world.type.WorldTypeStone;
import com.maikerumine.ESMC.world.type.WorldTypeStoneJustTest;

import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.world.WorldType;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

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
		//THESE CAUSE CRASH
//				TileEntityHandler.registerTileEntities();
//				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityEsmChest.class, new RenderEsmChest());
	}
	
	@SubscribeEvent
	public static void registerEnchantment(RegistryEvent.Register<Enchantment> event)
	{
		event.getRegistry().registerAll(EnchantmentInit.ENCHANTMENTS.toArray(new Enchantment[0]));
	}

	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event)
	{		
		Main.proxy.registerModel(Item.func_150898_a(ModBlocks.ESM_CHEST), 0);		//BUGGED AS WELL AS ENTITY STONE
		
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

	
	public static void preInitRegistries(FMLPreInitializationEvent event)
	{
		// TODO
//		GameRegistry.registerWorldGenerator(new WorldGenCustomOres(), 0);
//		GameRegistry.registerWorldGenerator(new WorldGenCustomStructures(), 0);
//		GameRegistry.registerWorldGenerator(new WorldGenCustomTrees(), 0);
//		DimensionInit.registerDimensions();
		
		BiomeInit.registerBiomes();
		FluidInit.registerFluids();
		//=======================================================================================================================
		//=======================================================================================================================		
//		EntityInit.registerEntities();						//CRASHING SERVER  THESE THREE NEED TO WORK.  Renders Mobs
//		RenderHandler.registerEntityRenders();				//CRASHING SERVER		Renders Tile and mob:  Chest?
//		RenderHandler.registerCustomMeshesAndStates();		//CRASHING SERVER		Renders liquid flow
		//=======================================================================================================================
		//=======================================================================================================================
		ModConfiguration.registerConfig(event);
	}

	public static void initRegistries(FMLInitializationEvent event)
	{
		NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, new GuiHandler());
		SoundsHandler.registerSounds();		
	}

	
	public static void postInitRegistries(FMLPostInitializationEvent event)
	{
		WorldType STONE = new WorldTypeStone();
		WorldType STONEJUSTTEST = new WorldTypeStoneJustTest();
		WorldType OCEAN = new WorldTypeOcean();
		WorldType DESERT = new WorldTypeDesert();
	}
	
	public static void serverRegistries(FMLServerStartingEvent event)
	{
//		event.registerServerCommand(new CommandTeleportDimension());
	}
	
}
