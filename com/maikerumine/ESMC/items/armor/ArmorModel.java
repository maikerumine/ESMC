package com.maikerumine.ESMC.items.armor;

import com.maikerumine.ESMC.Main;
import com.maikerumine.ESMC.init.ModItems;
import com.maikerumine.ESMC.rendering.models.items.ModelCustomArmour;
import com.maikerumine.ESMC.util.interfaces.IHasModel;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import net.minecraft.item.ItemArmor.ArmorMaterial;

public class ArmorModel extends ItemArmor implements IHasModel 
{
	public ArmorModel(String name, CreativeTabs tab, ArmorMaterial materialIn, EntityEquipmentSlot equipmentSlotIn)
	{
		super(materialIn, 1, equipmentSlotIn);
		func_77655_b(name);
		setRegistryName(name);
		func_77637_a(tab);
		func_77625_d(1);
		
		ModItems.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() 
	{
		Main.proxy.registerModel(this, 0);
	}

	@Override
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped _default) 
	{
		if(itemStack != ItemStack.field_190927_a)
		{
			if(itemStack.func_77973_b() instanceof ItemArmor)
			{
				ModelCustomArmour model = new ModelCustomArmour();
				
				model.field_78116_c.field_78806_j = armorSlot == EntityEquipmentSlot.HEAD;
				
				model.field_78091_s = _default.field_78091_s;
				model.field_78093_q = _default.field_78093_q;
				model.field_78117_n = _default.field_78117_n;
				model.field_187076_m = _default.field_187076_m;
				model.field_187075_l = _default.field_187075_l;
				
				return model;
			}
		}
		
		return null;
	}
	
}
