package com.maikerumine.ESMC.items.tools;

import com.maikerumine.ESMC.Main;
import com.maikerumine.ESMC.init.ModItems;
import com.maikerumine.ESMC.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;

import net.minecraft.item.Item.ToolMaterial;

public class ToolSword extends ItemSword implements IHasModel
{

	
	public ToolSword(String name, ToolMaterial material)
	{
		super(material);
		func_77655_b(name);
		setRegistryName(name);
		func_77637_a(CreativeTabs.field_78037_j);
		
		ModItems.ITEMS.add(this);
	}

	@Override
	public void registerModels() 
	{
		//Main.proxy.registerItemRenderer(this, 0, "inventory");		//Lore
		// TODO Auto-generated method stub
		Main.proxy.registerModel(this, 0);			//Harry
		
	}
	
}
