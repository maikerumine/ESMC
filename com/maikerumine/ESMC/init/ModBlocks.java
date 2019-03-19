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

import com.maikerumine.ESMC.blocks.BlockBase;
import com.maikerumine.ESMC.blocks.BlockEsmChest;
import com.maikerumine.ESMC.blocks.BlockFluid;
import com.maikerumine.ESMC.blocks.block_esm.AikerumBlock;
import com.maikerumine.ESMC.blocks.block_esm.AikerumOreBlock;
import com.maikerumine.ESMC.blocks.block_esm.DepletedUraniumOreBlock;
import com.maikerumine.ESMC.blocks.block_esm.InfiniumBlock;
import com.maikerumine.ESMC.blocks.block_esm.InfiniumOreBlock;
import com.maikerumine.ESMC.blocks.block_esm.PurpelliumBlock;
import com.maikerumine.ESMC.blocks.block_esm.PurpelliumOreBlock;
import com.maikerumine.ESMC.blocks.block_esm.RubyBlock;
import com.maikerumine.ESMC.blocks.block_esm.RubyOreBlock;
import com.maikerumine.ESMC.blocks.block_jt.AdminTntBlock;
import com.maikerumine.ESMC.blocks.block_jt.BonesBlock;
import com.maikerumine.ESMC.blocks.block_jt.CursedStoneBlock;
import com.maikerumine.ESMC.blocks.block_jt.KickVotingBlock;
import com.maikerumine.ESMC.blocks.block_jt.LagBlock;
import com.maikerumine.ESMC.blocks.block_jt.ProtectorBlock;
import com.maikerumine.ESMC.blocks.block_jt.TeleportBlock;
import com.maikerumine.ESMC.blocks.block_jt.VendorDepositorBlock;
import com.maikerumine.ESMC.blocks.block_jt.VendorVendorBlock;
import com.maikerumine.ESMC.blocks.block_mt.BronzeBlock;
import com.maikerumine.ESMC.blocks.block_mt.CopperBlock;
import com.maikerumine.ESMC.blocks.block_mt.CopperOreBlock;
import com.maikerumine.ESMC.blocks.block_mt.MeseBlock;
import com.maikerumine.ESMC.blocks.block_mt.MeseOreBlock;
import com.maikerumine.ESMC.blocks.block_mt.MeselampBlock;
import com.maikerumine.ESMC.blocks.block_mt.NyancatBlock;
import com.maikerumine.ESMC.blocks.block_mt.ObsidianBrickBlock;
import com.maikerumine.ESMC.blocks.block_mt.ObsidianGlassBlock;
import com.maikerumine.ESMC.blocks.block_mt.RainbowBlock;
import com.maikerumine.ESMC.blocks.block_mt.SmoothstoneBlock;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class ModBlocks 
{
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block AIKERUM_BLOCK = new AikerumBlock("aikerum_block", Material.field_151588_w, null);
	public static final Block AIKERUM_ORE_BLOCK = new AikerumOreBlock("aikerum_ore_block", Material.field_151576_e, null);
	
	public static final Block ADMIN_TNT_BLOCK = new AdminTntBlock("admin_tnt_block", Material.field_151588_w, null);
	
	public static final Block BONES_BLOCK = new BonesBlock("bones_block", Material.field_151573_f);
	public static final Block BRONZE_BLOCK = new BronzeBlock("bronze_block", Material.field_151573_f, null);
	
	public static final Block COPPER_BLOCK = new CopperBlock("copper_block", Material.field_151573_f, null);
	public static final Block COPPER_ORE_BLOCK = new CopperOreBlock("copper_ore_block", Material.field_151573_f, null);
	
	public static final Block CURSED_STONE_BLOCK = new CursedStoneBlock("cursed_stone_block", Material.field_151576_e, null);
	
	public static final Block DEPLETED_URANIUM_ORE_BLOCK = new DepletedUraniumOreBlock("depleted_uranium_ore_block", Material.field_151576_e, null);

	public static final Block INFINIUM_BLOCK = new InfiniumBlock("infinium_block", Material.field_151574_g, null);
	public static final Block INFINIUM_ORE_BLOCK = new InfiniumOreBlock("infinium_ore_block", Material.field_151576_e, null);
	
	public static final Block KICK_VOTING_BLOCK = new KickVotingBlock("kick_voting_block", Material.field_151575_d, null);
	
	public static final Block LAG_BLOCK = new LagBlock("lag_block", Material.field_151575_d, null);
	
	public static final Block MESE_BLOCK = new MeseBlock("mese_block", Material.field_151574_g, null);
	public static final Block MESELAMP_BLOCK = new MeselampBlock("meselamp_block", Material.field_151592_s, null);
	public static final Block MESE_ORE_BLOCK = new MeseOreBlock("mese_ore_block", Material.field_151576_e, null);
	
	public static final Block OBSIDIAN_GLASS_BLOCK = new ObsidianGlassBlock("obsidian_glass_block", Material.field_151592_s);
	public static final Block OBSIDIAN_BRICK_BLOCK = new ObsidianBrickBlock("obsidian_brick_block", Material.field_151576_e, null);
	
	public static final Block RUBY_BLOCK = new RubyBlock("ruby_block", Material.field_151588_w, null);
	public static final Block RUBY_ORE_BLOCK = new RubyOreBlock("ruby_ore_block", Material.field_151576_e, null);

	public static final Block PROTECTOR_BLOCK = new ProtectorBlock("protector_block", Material.field_151575_d, null);
	
	public static final Block PURPELLIUM_BLOCK = new PurpelliumBlock("purpellium_block", Material.field_151588_w, null);
	public static final Block PURPELLIUM_ORE_BLOCK = new PurpelliumOreBlock("purpellium_ore_block", Material.field_151576_e, null);
	
	public static final Block NYANCAT_BLOCK = new NyancatBlock("nyancat_block", Material.field_151575_d);
	public static final Block RAINBOW_BLOCK = new RainbowBlock("rainbow_block", Material.field_151575_d);

	public static final Block SMOOTHSTONE_BLOCK = new SmoothstoneBlock("smoothstone_block", Material.field_151576_e, null);
	
	public static final Block TELEPORT_BLOCK = new TeleportBlock("teleport_block", Material.field_151575_d, null);
	
	public static final Block VENDOR_DEPOSITOR_BLOCK = new VendorDepositorBlock("vendor_depositor_block", Material.field_151575_d);
	public static final Block VENDOR_VENDOR_BLOCK = new VendorVendorBlock("vendor_vendor_block", Material.field_151575_d);
	
	
	
	/*
	 * From Harry's Tutorial:  
	 * https://github.com/HarryTechRevs/Minecraft-Modding-1.12
	 * 
	 */
	public static final Block TOXIC_WATER_FLUID = new BlockFluid("toxic_water_fluid", FluidInit.TOXIC_WATER_FLUID, Material.field_151587_i);
	//public static final BlockSlab COPPER_SLAB_DOUBLE = new BlockSlabDoubleBase("copper_slab_double", Material.IRON, Main.TUTORIAL, BlockInit.COPPER_SLAB_HALF);
	//public static final BlockSlab COPPER_SLAB_HALF = new BlockSlabHalfBase("copper_slab_half", Material.IRON, Main.TUTORIAL, BlockInit.COPPER_SLAB_HALF, BlockInit.COPPER_SLAB_DOUBLE);
	
	public static final Block ESM_CHEST = new BlockEsmChest("esm_chest");		//BROKEN  ALSO TILE ENTITY HANDLER
	
	

}
