package com.maikerumine.ESMC.util.handlers;

import java.lang.reflect.Field;

import com.maikerumine.ESMC.Main;
import com.maikerumine.ESMC.blocks.tileentities.TileEntityEsmChest;
import com.maikerumine.ESMC.init.BiomeInit;
import com.maikerumine.ESMC.init.EntityInit;
import com.maikerumine.ESMC.init.FluidInit;
import com.maikerumine.ESMC.init.ModBlocks;
import com.maikerumine.ESMC.init.ModItems;
import com.maikerumine.ESMC.rendering.RenderEsmChest;
import com.maikerumine.ESMC.util.ModConfiguration;
import com.maikerumine.ESMC.util.interfaces.IHasModel;
import com.maikerumine.ESMC.world.ModEventHandler;
import com.maikerumine.ESMC.world.ModWorldGeneration;
import com.maikerumine.ESMC.world.generation.WorldGenCustomOres;
import com.maikerumine.ESMC.world.type.WorldTypeDesert;
import com.maikerumine.ESMC.world.type.WorldTypeMinetest;
import com.maikerumine.ESMC.world.type.WorldTypeOcean;
import com.maikerumine.ESMC.world.type.WorldTypeStoneJustTest;

import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.stats.RecipeBookServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.WorldType;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.ReflectionHelper;
import net.minecraftforge.registries.IForgeRegistryModifiable;

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
//		TileEntityHandler.registerTileEntities();  MOVED TO RENDERER		
//		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityEsmChest.class, new RenderEsmChest());	//This renders on client?
	}
	
	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event)
	{		
//		Main.proxy.registerModel(Item.getItemFromBlock(ModBlocks.ESM_CHEST), 0);		//BUGGED AS WELL AS ENTITY STONE
		
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

/**
 * BY: kreezxil
 * http://www.minecraftforge.net/forum/topic/59711-112-override-vanilla-recipe/
 * Posted July 25, 2017
 * 	
 * @param event
*/
	//Recipe remover
    @SubscribeEvent
    public static void registerRecipes(RegistryEvent.Register<IRecipe> event)
    {
    	ResourceLocation Stick = new ResourceLocation("minecraft:stick");
    	ResourceLocation Book = new ResourceLocation("minecraft:book");
    	ResourceLocation Button = new ResourceLocation("minecraft:wooden_button");
        IForgeRegistryModifiable modRegistry = (IForgeRegistryModifiable) event.getRegistry();
        modRegistry.remove(Stick);
        modRegistry.remove(Book);
        modRegistry.remove(Button);
    }

	public static void preInitRegistries(FMLPreInitializationEvent event)
	{
		FluidInit.registerFluids();	
		GameRegistry.registerWorldGenerator(new WorldGenCustomOres(), 0);				//CRASHING SERVER
		BiomeInit.registerBiomes();
		GameRegistry.registerWorldGenerator(new ModWorldGeneration(), 3);
		//=======================================================================================================================
		//=======================================================================================================================		
//		EntityInit.registerEntities();						//CRASHING SERVER  THESE THREE NEED TO WORK.  Renders Mobs
//		RenderHandler.registerEntityRenders();				//CRASHING SERVER		Renders mobs:
//		RenderHandler.registerCustomMeshesAndStates();		//CRASHING SERVER		Renders liquid flow
//		RenderHandler.registerTileEntities();				//CRASHING SERVER		Renders Tile entities: chest
//		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityEsmChest.class, new RenderEsmChest());
		//=======================================================================================================================
		//=======================================================================================================================
		ModConfiguration.registerConfig(event);
		MinecraftForge.TERRAIN_GEN_BUS.register(new ModEventHandler());  		//from forge forum
		MinecraftForge.ORE_GEN_BUS.register(new ModEventHandler());  		//from forge forum
		
		System.out.println("Extreme");
		System.out.println("Survival");
		System.out.println("Minecraft");
		System.out.println("By: maikerumine");
		System.out.println("Enjoy The Struggle!!!!");
	}

	public static void initRegistries(FMLInitializationEvent event)
	{
		NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, new GuiHandler());
		SoundsHandler.registerSounds();		
	}

	
	public static void postInitRegistries(FMLPostInitializationEvent event)
	{
		WorldType STONEJUSTTEST = new WorldTypeStoneJustTest();
		WorldType OCEAN = new WorldTypeOcean();
		WorldType DESERT = new WorldTypeDesert();
		WorldType MINETEST = new WorldTypeMinetest();

	}
	
	public static void serverRegistries(FMLServerStartingEvent event)
	{
		//TODO  register "spawn" command.
	}
		
}
