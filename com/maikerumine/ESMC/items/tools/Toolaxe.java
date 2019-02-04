package com.maikerumine.ESMC.items.tools;

import com.maikerumine.ESMC.Main;
import com.maikerumine.ESMC.init.ModItems;
import com.maikerumine.ESMC.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;

import net.minecraft.item.Item.ToolMaterial;

public class Toolaxe extends ItemAxe implements IHasModel
{

	
	public Toolaxe(String name, ToolMaterial material)
	{
		super(material, 6.0F, -3.2F );
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
