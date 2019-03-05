package com.maikerumine.ESMC.init;

import java.util.ArrayList;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.common.util.EnumHelper;

import java.util.List;
import java.util.ArrayList;


import com.maikerumine.ESMC.blocks.AdminTntBlock;
import com.maikerumine.ESMC.blocks.AikerumBlock;
import com.maikerumine.ESMC.blocks.AikerumOreBlock;
import com.maikerumine.ESMC.blocks.BlockBase;
import com.maikerumine.ESMC.blocks.BonesBlock;
import com.maikerumine.ESMC.blocks.BronzeBlock;
import com.maikerumine.ESMC.blocks.CopperBlock;
import com.maikerumine.ESMC.blocks.CopperOreBlock;
import com.maikerumine.ESMC.blocks.DepletedUraniumOreBlock;
import com.maikerumine.ESMC.blocks.InfiniumBlock;
import com.maikerumine.ESMC.blocks.InfiniumOreBlock;
import com.maikerumine.ESMC.blocks.KickVotingBlock;
import com.maikerumine.ESMC.blocks.LagBlock;
import com.maikerumine.ESMC.blocks.MeseBlock;
import com.maikerumine.ESMC.blocks.MeseOreBlock;
import com.maikerumine.ESMC.blocks.MeselampBlock;
import com.maikerumine.ESMC.blocks.NyancatBlock;
import com.maikerumine.ESMC.blocks.ObsidianBrickBlock;
import com.maikerumine.ESMC.blocks.ObsidianGlassBlock;
import com.maikerumine.ESMC.blocks.ProtectorBlock;
import com.maikerumine.ESMC.blocks.PurpelliumBlock;
import com.maikerumine.ESMC.blocks.PurpelliumOreBlock;
import com.maikerumine.ESMC.blocks.RainbowBlock;
import com.maikerumine.ESMC.blocks.RubyBlock;
import com.maikerumine.ESMC.blocks.RubyOreBlock;
import com.maikerumine.ESMC.blocks.SmoothstoneBlock;
import com.maikerumine.ESMC.blocks.TeleportBlock;
import com.maikerumine.ESMC.blocks.VendorDepositorBlock;
import com.maikerumine.ESMC.blocks.VendorVendorBlock;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class ModBlocks 
{
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block AIKERUM_BLOCK = new AikerumBlock("aikerum_block", Material.field_151588_w);
	public static final Block AIKERUM_ORE_BLOCK = new AikerumOreBlock("aikerum_ore_block", Material.field_151576_e);
	
	public static final Block ADMIN_TNT_BLOCK = new AdminTntBlock("admin_tnt_block", Material.field_151588_w);
	
	public static final Block BONES_BLOCK = new BonesBlock("bones_block", Material.field_151573_f);
	public static final Block BRONZE_BLOCK = new BronzeBlock("bronze_block", Material.field_151573_f);
	
	public static final Block COPPER_BLOCK = new CopperBlock("copper_block", Material.field_151573_f);
	public static final Block COPPER_ORE_BLOCK = new CopperOreBlock("copper_ore_block", Material.field_151573_f);
	
	public static final Block DEPLETED_URANIUM_ORE_BLOCK = new DepletedUraniumOreBlock("depleted_uranium_ore_block", Material.field_151576_e);

	public static final Block INFINIUM_BLOCK = new InfiniumBlock("infinium_block", Material.field_151574_g);
	public static final Block INFINIUM_ORE_BLOCK = new InfiniumOreBlock("infinium_ore_block", Material.field_151576_e);
	
	public static final Block KICK_VOTING_BLOCK = new KickVotingBlock("kick_voting_block", Material.field_151575_d);
	
	public static final Block LAG_BLOCK = new LagBlock("lag_block", Material.field_151575_d);
	
	public static final Block MESE_BLOCK = new MeseBlock("mese_block", Material.field_151574_g);
	public static final Block MESELAMP_BLOCK = new MeselampBlock("meselamp_block", Material.field_151592_s);
	public static final Block MESE_ORE_BLOCK = new MeseOreBlock("mese_ore_block", Material.field_151576_e);
	
	public static final Block OBSIDIAN_GLASS_BLOCK = new ObsidianGlassBlock("obsidian_glass_block", Material.field_151592_s);
	public static final Block OBSIDIAN_BRICK_BLOCK = new ObsidianBrickBlock("obsidian_brick_block", Material.field_151576_e);
	
	public static final Block RUBY_BLOCK = new RubyBlock("ruby_block", Material.field_151588_w);
	public static final Block RUBY_ORE_BLOCK = new RubyOreBlock("ruby_ore_block", Material.field_151576_e);

	public static final Block PROTECTOR_BLOCK = new ProtectorBlock("protector_block", Material.field_151575_d);
	
	public static final Block PURPELLIUM_BLOCK = new PurpelliumBlock("purpellium_block", Material.field_151588_w);
	public static final Block PURPELLIUM_ORE_BLOCK = new PurpelliumOreBlock("purpellium_ore_block", Material.field_151576_e);
	
	public static final Block NYANCAT_BLOCK = new NyancatBlock("nyancat_block", Material.field_151575_d);
	public static final Block RAINBOW_BLOCK = new RainbowBlock("rainbow_block", Material.field_151575_d);

	public static final Block SMOOTHSTONE_BLOCK = new SmoothstoneBlock("smoothstone_block", Material.field_151576_e);
	
	public static final Block TELEPORT_BLOCK = new TeleportBlock("teleport_block", Material.field_151575_d);
	
	public static final Block VENDOR_DEPOSITOR_BLOCK = new VendorDepositorBlock("vendor_depositor_block", Material.field_151575_d);
	public static final Block VENDOR_VENDOR_BLOCK = new VendorVendorBlock("vendor_vendor_block", Material.field_151575_d);
	
	

}
