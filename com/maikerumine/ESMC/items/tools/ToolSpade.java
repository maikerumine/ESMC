package com.maikerumine.ESMC.items.tools;

import com.maikerumine.ESMC.Main;
import com.maikerumine.ESMC.init.ModItems;
import com.maikerumine.ESMC.util.interfaces.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;

import net.minecraft.item.Item.ToolMaterial;

public class ToolSpade extends ItemSpade implements IHasModel
{

	
	public ToolSpade(String name, ToolMaterial material)
	{
		super(material);
		func_77655_b(name);
		setRegistryName(name);
		func_77637_a(CreativeTabs.field_78040_i);
		
		ModItems.ITEMS.add(this);
	}

	@Override
	public void registerModels() 
	{
		//Main.proxy.registerItemRenderer(this, 0, "inventory");			//Lore
		// TODO Auto-generated method stub
		Main.proxy.registerModel(this, 0);				//Harry
		
	}
	
}
