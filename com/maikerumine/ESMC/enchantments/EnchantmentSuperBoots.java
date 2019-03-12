package com.maikerumine.ESMC.enchantments;


import com.maikerumine.ESMC.util.Reference;
import com.maikerumine.ESMC.init.EnchantmentInit;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.init.Enchantments;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.util.ResourceLocation;

import net.minecraft.enchantment.Enchantment.Rarity;

public class EnchantmentSuperBoots extends Enchantment 
{
	public EnchantmentSuperBoots() 
	{
		super(Rarity.RARE, EnumEnchantmentType.ARMOR_FEET, new EntityEquipmentSlot[] {EntityEquipmentSlot.FEET});
		this.func_77322_b("devils_feet");
		this.setRegistryName(new ResourceLocation(Reference.MOD_ID + ":super_boots"));
		
		EnchantmentInit.ENCHANTMENTS.add(this);
	}

	@Override
	public int func_77321_a(int enchantmentLevel) 
	{
		return 20 * enchantmentLevel;
	}
	
	@Override
	public int func_77317_b(int enchantmentLevel)
	{
		return this.func_77321_a(enchantmentLevel) + 10;
	}
	
	@Override
	public int func_77325_b()
	{
		return 5;
	}
	
	@Override
	protected boolean func_77326_a(Enchantment ench) 
	{
		return super.func_77326_a(ench) && ench != Enchantments.field_185301_j && ench != Enchantments.field_185300_i;
	}
}

