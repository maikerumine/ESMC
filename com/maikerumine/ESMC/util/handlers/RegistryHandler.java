package com.maikerumine.ESMC.util.handlers;

import java.lang.reflect.Field;

import com.maikerumine.ESMC.Main;
import com.maikerumine.ESMC.blocks.tileentities.TileEntityEsmChest;
import com.maikerumine.ESMC.commands.CommandTeleportDimension;
import com.maikerumine.ESMC.crafting.RecipeRemover;
import com.maikerumine.ESMC.enchantments.EnchantmentSuperBoots;
import com.maikerumine.ESMC.init.BiomeInit;
import com.maikerumine.ESMC.init.DimensionInit;
import com.maikerumine.ESMC.init.EnchantmentInit;
import com.maikerumine.ESMC.init.EntityInit;
import com.maikerumine.ESMC.init.FluidInit;
import com.maikerumine.ESMC.init.ModBlocks;
import com.maikerumine.ESMC.init.ModItems;
import com.maikerumine.ESMC.init.ModTriggers;
import com.maikerumine.ESMC.recipes.RecipeBookServerCustom;
import com.maikerumine.ESMC.rendering.RenderEsmChest;
import com.maikerumine.ESMC.util.ModConfiguration;
import com.maikerumine.ESMC.util.interfaces.IHasModel;
import com.maikerumine.ESMC.world.generation.WorldGenCustomOres;
import com.maikerumine.ESMC.world.generation.WorldGenCustomStructures;
import com.maikerumine.ESMC.world.generation.WorldGenCustomTrees;
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
				TileEntityHandler.registerTileEntities();
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityEsmChest.class, new RenderEsmChest());
	}
	
	@SubscribeEvent
	public static void registerEnchantment(RegistryEvent.Register<Enchantment> event)
	{
//		event.getRegistry().registerAll(EnchantmentInit.ENCHANTMENTS.toArray(new Enchantment[0]));
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
//		GameRegistry.registerWorldGenerator(new WorldGenCustomStructures(), 0);
//		GameRegistry.registerWorldGenerator(new WorldGenCustomTrees(), 0);
		BiomeInit.registerBiomes();
//		DimensionInit.registerDimensions();
		//=======================================================================================================================
		//=======================================================================================================================		
		EntityInit.registerEntities();						//CRASHING SERVER  THESE THREE NEED TO WORK.  Renders Mobs
		RenderHandler.registerEntityRenders();				//CRASHING SERVER		Renders Tile and mob:  Chest?
		RenderHandler.registerCustomMeshesAndStates();		//CRASHING SERVER		Renders liquid flow
		//=======================================================================================================================
		//=======================================================================================================================
		ModConfiguration.registerConfig(event);
	}

	public static void initRegistries(FMLInitializationEvent event)
	{
		NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, new GuiHandler());
//		RecipeRemover.removeRecipe();
//		RecipeRemover.removeRecipes();
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
		event.registerServerCommand(new CommandTeleportDimension());
	}
	
	
	
	
	
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
//*/	
//    public static Field recipeBook = ReflectionHelper.findField(EntityPlayerMP.class, "recipeBook", "field_192036_cb");
    
    /**
     * On event.
     *
     * @param event the event
     */
    
    /**
    @SubscribeEvent(priority = EventPriority.HIGHEST, receiveCanceled = true)
    public static void onEvent(PlayerTickEvent event)
    {
        if (event.player instanceof EntityPlayerMP)
        {
            EntityPlayerMP playerMP = (EntityPlayerMP) event.player;
            RecipeBookServer recipeBookCurrent = playerMP.getRecipeBook();
            if (!(recipeBookCurrent instanceof RecipeBookServerCustom))
            {
                // DEBUG
                System.out.println("Replacing recipe book with custom book");
                
                RecipeBookServerCustom recipeBookNew = new RecipeBookServerCustom();
                recipeBookNew.copyFrom(recipeBookCurrent);
                try
                {
                    recipeBook.set(playerMP, recipeBookNew);
                }
                catch (IllegalArgumentException | IllegalAccessException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
 */   
    /**
     * This method is part of my simple custom advancement triggering tutorial.
     * See: http://jabelarminecraft.blogspot.com/p/minecraft-modding-custom-triggers-aka.html
     *
     * @param event the event
     */
    
    /**
    @SubscribeEvent(priority = EventPriority.HIGHEST, receiveCanceled = true)
    public static void onEvent(RightClickBlock event)
    {
        EntityPlayer thePlayer = event.getEntityPlayer();
        if (thePlayer instanceof EntityPlayerMP)
        {
            EntityPlayerMP thePlayerMP = (EntityPlayerMP)thePlayer;
            
            // DEBUG
            System.out.println("Right clicking block with "+thePlayer.getHeldItem(event.getHand()));
   
            if (thePlayer.getHeldItem(event.getHand()).getItem() == ModItems.AIKERUM_CRYSTAL)
            {
                ModTriggers.MINE_AIKERUM.trigger(thePlayerMP);
            }
        }
    }
*/	
}
