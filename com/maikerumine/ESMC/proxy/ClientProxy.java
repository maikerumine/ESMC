package com.maikerumine.ESMC.proxy;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public class ClientProxy extends CommonProxy 
/**
 * This is Harry's code
 */
{
	@Override
	public void registerModel(Item item, int metadata) 
	{
		ModelLoader.setCustomModelResourceLocation(item, metadata, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
}



/**
 * THIS IS Loremaster Code
{
	public void registerItemRenderer(Item item, int meta, String id) 
	{
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
	}
}	
**/


/*  from mcreator

	@Override
	public void registerRenderers(testenvironmentmod instance) {
		instance.mcreator_0.registerRenderers();
	}
	*/

