package com.maikerumine.ESMC.items.tools;

import com.maikerumine.ESMC.Main;
import com.maikerumine.ESMC.init.ModItems;
import com.maikerumine.ESMC.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;

import net.minecraft.item.Item.ToolMaterial;

public class ToolPickaxe extends ItemPickaxe implements IHasModel
{

	
	public ToolPickaxe(String name, ToolMaterial material)
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
		Main.proxy.registerItemRenderer(this, 0, "inventory");
		// TODO Auto-generated method stub
		
	}
	
}
