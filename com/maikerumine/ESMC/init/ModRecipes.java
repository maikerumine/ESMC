package com.maikerumine.ESMC.init;

import com.maikerumine.ESMC.Main;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistryModifiable;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ModRecipes 
{
	
	public static void init() {
//		GameRegistry.addSmelting(Items.EMERALD, new ItemStack(ModItems.EMERALD_CRYSTAL, 1), 1.3F);
		GameRegistry.addSmelting(ModItems.COPPER_LUMP, new ItemStack(ModItems.COPPER_INGOT, 1), 0.3F);
		GameRegistry.addSmelting(ModItems.GOLD_LUMP, new ItemStack(Items.field_151043_k, 1), 0.3F);
		GameRegistry.addSmelting(ModItems.IRON_LUMP, new ItemStack(Items.field_151042_j, 1), 0.7F);
		GameRegistry.addSmelting(ModItems.TIN_LUMP, new ItemStack(ModItems.TIN_INGOT, 1), 0.2F);
		GameRegistry.addSmelting(ModItems.OBSIDIAN_SHARD, new ItemStack(ModBlocks.OBSIDIAN_GLASS_BLOCK, 1), 0.3F);
		GameRegistry.addSmelting(ModItems.PURPELLIUM_LUMP, new ItemStack(ModItems.PURPELLIUM_INGOT, 1), 1.3F);
		GameRegistry.addSmelting(ModItems.INFINIUM_GOO, new ItemStack(ModItems.INFINIUM_INGOT, 1), 1.6F);	//temp till glass vessel
		//PLACE HOLDER FOR CRUSHING FURNACE
		GameRegistry.addSmelting(Blocks.field_150348_b, new ItemStack(Blocks.field_150351_n,1), 0.3F);	//override cobble to stone
		GameRegistry.addSmelting(Blocks.field_150351_n, new ItemStack(Blocks.field_150346_d,1), 0.3F);
		GameRegistry.addSmelting(Blocks.field_150346_d, new ItemStack(Blocks.field_150354_m,1), 0.3F);
		GameRegistry.addSmelting(ModBlocks.DESERT_STONE, new ItemStack(ModBlocks.DESERT_COBBLE_BLOCK,1), 0.3F);
	}
	

	    
	    
}

