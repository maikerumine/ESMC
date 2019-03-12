package com.maikerumine.ESMC.items;

import com.maikerumine.ESMC.Main;
import com.maikerumine.ESMC.init.ModItems;
import com.maikerumine.ESMC.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel {
	


	
	/**Harrys code
	 * 
	 */
	public ItemBase(String name, CreativeTabs tab) 
	{
		func_77655_b(name);
		setRegistryName(name);
		func_77637_a(tab);
		
		ModItems.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() 
	{
		Main.proxy.registerModel(this, 0);
	}
	/**
	 * 
	 * Loremaster code
	 */
	/**
	 *	public ItemBase(String name)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.MATERIALS);
		
		ModItems.ITEMS.add(this);
	}
	
	
	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
		// TODO Auto-generated method stub
		
	}
*/
}
