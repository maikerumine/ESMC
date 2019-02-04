package com.maikerumine.ESMC.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes 
{
	public static void init() {
		GameRegistry.addSmelting(Items.field_151166_bC, new ItemStack(ModItems.EMERALD_CRYSTAL, 1), 1.3F);
		GameRegistry.addSmelting(ModItems.COPPER_LUMP, new ItemStack(ModItems.COPPER_INGOT, 1), 2.3F);
		GameRegistry.addSmelting(ModItems.OBSIDIAN_SHARD, new ItemStack(ModBlocks.OBSIDIAN_GLASS_BLOCK, 1), 2.3F);
		GameRegistry.addSmelting(ModItems.PURPELLIUM_LUMP, new ItemStack(ModItems.PURPELLIUM_INGOT, 1), 1.3F);
		GameRegistry.addSmelting(Items.field_151069_bo, new ItemStack(Blocks.field_150410_aZ, 1), 0.3F);
	}
	
	
}
