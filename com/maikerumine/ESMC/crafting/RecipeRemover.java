package com.maikerumine.ESMC.crafting;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryModifiable;


/**
 * 
 * FROM:
 * https://www.youtube.com/watch?v=ZQjBuHUxdro
 * 
 * 
 * 
 * @author Maikeru
 *
//Example:
public class RecipeRemover {
	public static void removeRecipe() {
//		List<IRecipe> recipes = CraftingManager.getInstance().getRecipeList();
		List<IRecipe> recipes = CraftingManager.getRecipe().getRecipeList()

		
		Iterator<IRecipe> remover = recipes.iterator();
		
			while(remover.hasNext()) {
				ItemStack itemstack = remover.next().getRecipeOutput();
				if(itemstack != null && itemstack.getItem() == Items.BOOK)
					remover.remove();
			}
	}
}

*/


/**
 * Removes all recipes that produce a given item.
 * @param itemToRemove The item whose recipes are to be removed.
 */

/**
 * 
 * FROM: https://www.programcreek.com/java-api-examples/?api=net.minecraft.item.crafting.CraftingManager
 * 
 * 
//Example: 
public class RecipeRemover {
private static void removeRecipe(Item itemToRemove) {
    Iterator<IRecipe> iter = CraftingManager.getInstance().getRecipeList().iterator();
    while (iter.hasNext()) {
        IRecipe recipe = iter.next();
        ItemStack out = recipe.getRecipeOutput();
        if (out != ItemStack.EMPTY && out.getItem() == itemToRemove) {
            FMLLog.info("Removing recipe for " + out);
            iter.remove();
        }
    }
}

*/

/**
 * 
 * From: Choonster
 * On Jabelar's tuts
 * 
 * http://jabelarminecraft.blogspot.com/p/minecraft-modding-ore-dictionary.html
 */


/**
//Example:
public class RecipeRemover {
	private static void removeRecipes(final Block output) 
	{
	    removeRecipes(Item.getItemFromBlock(output));
	}
	
	private static void removeRecipes(final Item output) 
	{
	    removeRecipes(recipe -> 
	    {
	        final ItemStack recipeOutput = recipe.getRecipeOutput();
	        return !recipeOutput.isEmpty() && recipeOutput.getItem() == output;
	    });
	}
}
*/

/**
//Example:
public class RecipeRemover {
	private static void removeRecipes(final Class recipeClass) 
	{
	    final int recipesRemoved = removeRecipes(recipeClass::isInstance);
	}
	
	}	
	
	private static int removeRecipes(final Predicate predicate) 
	{
	    int recipesRemoved = 0;
	
	    final IForgeRegistry registry = ForgeRegistries.RECIPES;
	    final List toRemove = new ArrayList<>();
	
	    for (final IRecipe recipe : registry) 
	    {
	        if (predicate.test(recipe)) 
	        {
	            toRemove.add(recipe);
	            recipesRemoved++;
	        }
	    }
	
	    toRemove.forEach(recipe -> 
	    {
	        final IRecipe replacement = 
	            new DummyRecipe().setRegistryName(recipe.getRegistryName());
	        registry.register(replacement);
	    });
	
	    return recipesRemoved;
	}
}
*/

//Example:
/**
//public class DummyRecipe  extends IForgeRegistryEntry.Impl implements IRecipe
public abstract class RecipeRemover  extends IForgeRegistry.Impl    implements IRecipe
{
    @Override
    public boolean matches(final InventoryCrafting inv, final World worldIn) 
    {
        return false;
    }

    @Override
    public ItemStack getCraftingResult(final InventoryCrafting inv) 
    {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canFit(final int width, final int height) 
    {
        return false;
    }

    @Override
    public ItemStack getRecipeOutput() 
    {
        return ItemStack.EMPTY;
    }
    
    */

//Example:
/**
public class RecipeRemover {
	private static int removeRecipes(final Predicate predicate) 
	{
	    int recipesRemoved = 0;
	
	    final IForgeRegistry registry = ForgeRegistries.RECIPES;
	    final List toRemove = new ArrayList<>();
	
	    for (final IRecipe recipe : registry) 
	    {
	        if (predicate.test(recipe)) 
	        {
	            toRemove.add(recipe);
	            recipesRemoved++;
	        }
	    }
	
	    toRemove.forEach(recipe -> 
	    {
	        final IRecipe replacement = 
	            new DummyRecipe().setRegistryName(recipe.getRegistryName());
	        registry.register(replacement);
	    });
	
	    return recipesRemoved;
	}

//	public static void removeRecipe() {
		// TODO Auto-generated method stub
		
//	}
}
*/

//this moved to registryhandler
//http://www.minecraftforge.net/forum/topic/59711-112-override-vanilla-recipe/?tab=comments#comment-277811
@EventBusSubscriber
public class RecipeRemover {
	@SubscribeEvent
	public static void registerRecipes(RegistryEvent.Register<IRecipe> event)
	{
		ResourceLocation theButton = new ResourceLocation("minecraft:wooden_button");
	    IForgeRegistryModifiable modRegistry = (IForgeRegistryModifiable) event.getRegistry();
	    modRegistry.remove(theButton);
	}

}
