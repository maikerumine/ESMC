package com.maikerumine.ESMC.init;

import java.util.ArrayList;
import java.util.List;

import com.maikerumine.ESMC.Main;
import com.maikerumine.ESMC.items.ItemBase;
import com.maikerumine.ESMC.items.armor.ArmorBase;
import com.maikerumine.ESMC.items.tools.ToolPickaxe;
import com.maikerumine.ESMC.items.tools.ToolSpade;
import com.maikerumine.ESMC.items.tools.ToolSword;
import com.maikerumine.ESMC.items.tools.Toolaxe;
import com.maikerumine.ESMC.util.Reference;

import net.minecraft.block.Block;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;

public class ModItems 
{
	//MaterialType																				NAME	  HARVEST LVL  |  USE  |  SPEED  |  DAMAGE  |  ENCHANT
	public static final ToolMaterial MATERIAL_AIKERUM_CRYSTAL = EnumHelper.addToolMaterial("material_aikerum_crystal", 4, 1420, 9.5F, 4.0F, 18);
	public static final ArmorMaterial ARMOR_AIKERUM_CRYSTAL = EnumHelper.addArmorMaterial("armor_aikerum_crystal", Reference.MOD_ID + ":aikerum_crystal", 15, 
			new int [] {3, 9 ,7 ,4}, 10, SoundEvents.field_187716_o, 0.0F);

	public static final ToolMaterial MATERIAL_BRONZE = EnumHelper.addToolMaterial("material_bronze", 3, 390, 3.5F, 2.6F, 20);
	public static final ArmorMaterial ARMOR_BRONZE = EnumHelper.addArmorMaterial("armor_bronze", Reference.MOD_ID + ":bronze_ingot", 15, 
			new int [] {3, 6 ,6 ,2}, 10, SoundEvents.field_187722_q, 0.0F);
	
	public static final ToolMaterial MATERIAL_EMERALD_CRYSTAL = EnumHelper.addToolMaterial("material_emerald_crystal", 3, 780, 7.5F, 2.8F, 7);
	public static final ArmorMaterial ARMOR_EMERALD_CRYSTAL = EnumHelper.addArmorMaterial("armor_emerald_crystal", Reference.MOD_ID + ":emerald_crystal", 15, 
			new int [] {3, 7 ,6 ,3}, 10, SoundEvents.field_187716_o, 0.0F);
			
	public static final ToolMaterial MATERIAL_INFINIUM = EnumHelper.addToolMaterial("material_infinium_ingot", 4, 1550, 10.5F, 6.0F, 19);
	public static final ArmorMaterial ARMOR_INFINIUM = EnumHelper.addArmorMaterial("armor_infinium", Reference.MOD_ID + ":infinium_ingot", 15, 
			new int [] {4, 10 ,8 ,5}, 10, SoundEvents.field_187713_n, 0.0F);
		
	public static final ToolMaterial MATERIAL_PURPELLIUM = EnumHelper.addToolMaterial("material_purpellium_ingot", 4, 1480, 9.5F, 5.5F, 15);
	public static final ArmorMaterial ARMOR_PURPELLIUM = EnumHelper.addArmorMaterial("armor_purpellium", Reference.MOD_ID + ":purpellium_ingot", 15, 
			new int [] {4, 9 ,7 ,4}, 10, SoundEvents.field_187728_s, 0.0F);
		
	public static final ToolMaterial MATERIAL_RUBY_CRYSTAL = EnumHelper.addToolMaterial("material_ruby_crystal", 3, 980, 7.8F, 2.8F, 9);
	public static final ArmorMaterial ARMOR_RUBY_CRYSTAL = EnumHelper.addArmorMaterial("armor_ruby_crystal", Reference.MOD_ID + ":ruby_crystal", 15, 
			new int [] {3, 8 ,5 ,3}, 10, SoundEvents.field_187716_o, 0.0F);
			

	public static final List<Item> ITEMS = new ArrayList<Item>();
	//Items
	public static final Item AIKERUM_CRYSTAL = new ItemBase("aikerum_crystal", null);
	public static final Item BRONZE_INGOT = new ItemBase("bronze_ingot", null);
	public static final Item COPPER_INGOT = new ItemBase("copper_ingot", null);
	public static final Item COPPER_LUMP = new ItemBase("copper_lump", null);
	public static final Item COAL_LUMP = new ItemBase("coal_lump", null);
	public static final Item DEPLETED_URANIUM_INGOT = new ItemBase("depleted_uranium_ingot", null);
	public static final Item DEPLETED_URANIUM_LUMP = new ItemBase("depleted_uranium_lump", null);
	//public static final Item DIAMOND_CRYSTAL = new ItemBase("diamond_crystal", null);
	//public static final Item EMERALD_CRYSTAL = new ItemBase("emerald_crystal", null);
	public static final Item GOLD_LUMP = new ItemBase("gold_lump", null);
	public static final Item INFINIUM_GOO = new ItemBase("infinium_goo", null);
	public static final Item INFINIUM_INGOT = new ItemBase("infinium_ingot", null);
	//public static final Item IRON_INGOT = new ItemBase("iron_ingot", null);
	public static final Item IRON_LUMP = new ItemBase("iron_lump", null);
	public static final Item MESE_CRYSTAL = new ItemBase("mese_crystal", null);
	public static final Item MESE_CRYSTAL_FRAGMENT = new ItemBase("mese_crystal_fragment", null);
	public static final Item OBSIDIAN_SHARD = new ItemBase("obsidian_shard", null);
	public static final Item PURPELLIUM_INGOT = new ItemBase("purpellium_ingot", null);
	public static final Item PURPELLIUM_LUMP = new ItemBase("purpellium_lump", null);
	public static final Item RUBY_CRYSTAL = new ItemBase("ruby_crystal", null);
	public static final Item TIN_INGOT = new ItemBase("tin_ingot", null);
	public static final Item TIN_LUMP = new ItemBase("tin_lump", null);
	
	//BUCKET FOR TOXIC FLUID?
	public static final Item TOXIC_WATER_FLUID_BUCKET = new ItemBase("bucket_toxic_water_fluid", null);

	
	//T O O L S 
	//aikerum
	public static final ItemSword AIKERUM_CRYSTAL_SWORD = new ToolSword("aikerum_crystal_sword", MATERIAL_AIKERUM_CRYSTAL);
	public static final ItemSpade AIKERUM_CRYSTAL_SPADE = new ToolSpade("aikerum_crystal_spade", MATERIAL_AIKERUM_CRYSTAL);
	public static final ItemPickaxe AIKERUM_CRYSTAL_PICKAXE = new ToolPickaxe("aikerum_crystal_pickaxe", MATERIAL_AIKERUM_CRYSTAL);
	public static final ItemAxe AIKERUM_CRYSTAL_AXE = new Toolaxe("aikerum_crystal_axe", MATERIAL_AIKERUM_CRYSTAL);
	//bronze 
	public static final ItemSword MATERIAL_BRONZE_SWORD = new ToolSword("bronze_sword", MATERIAL_BRONZE);
	public static final ItemSpade MATERIAL_BRONZE_SPADE = new ToolSpade("bronze_spade", MATERIAL_BRONZE);
	public static final ItemPickaxe MATERIAL_BRONZE_PICKAXE = new ToolPickaxe("bronze_pickaxe", MATERIAL_BRONZE);
	public static final ItemAxe MATERIAL_BRONZE_AXE = new Toolaxe("bronze_axe", MATERIAL_BRONZE);
	
	//emerald
	public static final ItemSword EMERALD_CRYSTAL_SWORD = new ToolSword("emerald_crystal_sword", MATERIAL_EMERALD_CRYSTAL);
	public static final ItemSpade EMERALD_CRYSTAL_SPADE = new ToolSpade("emerald_crystal_spade", MATERIAL_EMERALD_CRYSTAL);
	public static final ItemPickaxe EMERALD_CRYSTAL_PICKAXE = new ToolPickaxe("emerald_crystal_pickaxe", MATERIAL_EMERALD_CRYSTAL);
	public static final ItemAxe EMERALD_CRYSTAL_AXE = new Toolaxe("emerald_crystal_axe", MATERIAL_EMERALD_CRYSTAL);
	
	//infinium 
	public static final ItemSword INFINIUM_SWORD = new ToolSword("infinium_sword", MATERIAL_INFINIUM);
	public static final ItemSpade INFINIUM_SPADE = new ToolSpade("infinium_spade", MATERIAL_INFINIUM);
	public static final ItemPickaxe INFINIUM_PICKAXE = new ToolPickaxe("infinium_pickaxe", MATERIAL_INFINIUM);
	public static final ItemAxe INFINIUM_AXE = new Toolaxe("infinium_axe", MATERIAL_INFINIUM);
	
	//purpellium	
	public static final ItemSword PURPELLIUM_SWORD = new ToolSword("purpellium_sword", MATERIAL_PURPELLIUM);
	public static final ItemSpade PURPELLIUM_SPADE = new ToolSpade("purpellium_spade", MATERIAL_PURPELLIUM);
	public static final ItemPickaxe PURPELLIUM_PICKAXE = new ToolPickaxe("purpellium_pickaxe", MATERIAL_PURPELLIUM);
	public static final ItemAxe PURPELLIUM_AXE = new Toolaxe("purpellium_axe", MATERIAL_PURPELLIUM);
	
	//ruby	
	public static final ItemSword RUBY_CRYSTAL_SWORD = new ToolSword("ruby_crystal_sword", MATERIAL_RUBY_CRYSTAL);
	public static final ItemSpade RUBY_CRYSTAL_SPADE = new ToolSpade("ruby_crystal_spade", MATERIAL_RUBY_CRYSTAL);
	public static final ItemPickaxe RUBY_CRYSTAL_PICKAXE = new ToolPickaxe("ruby_crystal_pickaxe", MATERIAL_RUBY_CRYSTAL);
	public static final ItemAxe RUBY_CRYSTAL_AXE = new Toolaxe("ruby_crystal_axe", MATERIAL_RUBY_CRYSTAL);
	
	
	
	//A R M O R 
	//aikerum
	public static final Item AIKERUM_CRYSTAL_HELMET = new ArmorBase("aikerum_crystal_helmet", ARMOR_AIKERUM_CRYSTAL, 1, EntityEquipmentSlot.HEAD);
	public static final Item AIKERUM_CRYSTAL_CHESTPLATE = new ArmorBase("aikerum_crystal_chestplate", ARMOR_AIKERUM_CRYSTAL, 1, EntityEquipmentSlot.CHEST);
	public static final Item AIKERUM_CRYSTAL_LEGGINGS = new ArmorBase("aikerum_crystal_leggings", ARMOR_AIKERUM_CRYSTAL, 2, EntityEquipmentSlot.LEGS);
	public static final Item AIKERUM_CRYSTAL_BOOTS = new ArmorBase("aikerum_crystal_boots", ARMOR_AIKERUM_CRYSTAL, 1, EntityEquipmentSlot.FEET);

	//bronze 
	public static final Item BRONZE_HELMET = new ArmorBase("bronze_helmet", ARMOR_BRONZE, 1, EntityEquipmentSlot.HEAD);
	public static final Item BRONZE_CHESTPLATE = new ArmorBase("bronze_chestplate", ARMOR_BRONZE, 1, EntityEquipmentSlot.CHEST);
	public static final Item BRONZE_LEGGINGS = new ArmorBase("bronze_leggings", ARMOR_BRONZE, 2, EntityEquipmentSlot.LEGS);
	public static final Item BRONZE_BOOTS = new ArmorBase("bronze_boots", ARMOR_BRONZE, 1, EntityEquipmentSlot.FEET);
	
	//emerald
	public static final Item EMERALD_CRYSTAL_HELMET = new ArmorBase("emerald_crystal_helmet", ARMOR_EMERALD_CRYSTAL, 1, EntityEquipmentSlot.HEAD);
	public static final Item EMERALD_CRYSTAL_CHESTPLATE = new ArmorBase("emerald_crystal_chestplate", ARMOR_EMERALD_CRYSTAL, 1, EntityEquipmentSlot.CHEST);
	public static final Item EMERALD_CRYSTAL_LEGGINGS = new ArmorBase("emerald_crystal_leggings", ARMOR_EMERALD_CRYSTAL, 2, EntityEquipmentSlot.LEGS);
	public static final Item EMERALD_CRYSTAL_BOOTS = new ArmorBase("emerald_crystal_boots", ARMOR_EMERALD_CRYSTAL, 1, EntityEquipmentSlot.FEET);
	
	//infinium
	public static final Item INFINIUM_HELMET = new ArmorBase("infinium_helmet", ARMOR_INFINIUM, 1, EntityEquipmentSlot.HEAD);
	public static final Item INFINIUM_CHESTPLATE = new ArmorBase("infinium_chestplate", ARMOR_INFINIUM, 1, EntityEquipmentSlot.CHEST);
	public static final Item INFINIUM_LEGGINGS = new ArmorBase("infinium_leggings", ARMOR_INFINIUM, 2, EntityEquipmentSlot.LEGS);
	public static final Item INFINIUM_BOOTS = new ArmorBase("infinium_boots", ARMOR_INFINIUM, 1, EntityEquipmentSlot.FEET);
	
	//purpellium 
	public static final Item PURPELLIUM_HELMET = new ArmorBase("purpellium_helmet", ARMOR_PURPELLIUM, 1, EntityEquipmentSlot.HEAD);
	public static final Item PURPELLIUM_CHESTPLATE = new ArmorBase("purpellium_chestplate", ARMOR_PURPELLIUM, 1, EntityEquipmentSlot.CHEST);
	public static final Item PURPELLIUM_LEGGINGS = new ArmorBase("purpellium_leggings", ARMOR_PURPELLIUM, 2, EntityEquipmentSlot.LEGS);
	public static final Item PURPELLIUM_BOOTS = new ArmorBase("purpellium_boots", ARMOR_PURPELLIUM, 1, EntityEquipmentSlot.FEET);
	
	//ruby 
	public static final Item RUBY_CRYSTAL_HELMET = new ArmorBase("ruby_crystal_helmet", ARMOR_RUBY_CRYSTAL, 1, EntityEquipmentSlot.HEAD);
	public static final Item RUBY_CRYSTAL_CHESTPLATE = new ArmorBase("ruby_crystal_chestplate", ARMOR_RUBY_CRYSTAL, 1, EntityEquipmentSlot.CHEST);
	public static final Item RUBY_CRYSTAL_LEGGINGS = new ArmorBase("ruby_crystal_leggings", ARMOR_RUBY_CRYSTAL, 2, EntityEquipmentSlot.LEGS);
	public static final Item RUBY_CRYSTAL_BOOTS = new ArmorBase("ruby_crystal_boots", ARMOR_RUBY_CRYSTAL, 1, EntityEquipmentSlot.FEET);
	
	//Harry's armour sample
	//Armour Materials
	public static final ArmorMaterial CUSTOM_MODEL_MATERIAL = EnumHelper.addArmorMaterial("custom_model", Main.MOD_ID + ":custom_model", 20, new int[] {7, 8, 8, 9}, 0, SoundEvents.field_187719_p, 2.0f);

	
	//??wtf-->
	public static Block ALUMINIUM_SAPLING;
	
	
	
	
	
	
	
	
	
}
