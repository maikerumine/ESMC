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

import com.maikerumine.ESMC.Main;
import com.maikerumine.ESMC.blocks.Block3DModelBase;
import com.maikerumine.ESMC.blocks.BlockBase;
import com.maikerumine.ESMC.blocks.BlockDirtBase;
import com.maikerumine.ESMC.blocks.BlockEsmChest;
import com.maikerumine.ESMC.blocks.BlockFluid;
import com.maikerumine.ESMC.blocks.BlockLeavesBase;
import com.maikerumine.ESMC.blocks.BlockLogBase;
import com.maikerumine.ESMC.blocks.BlockSaplingBase;
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
import com.maikerumine.ESMC.blocks.block_jt.CityBlock;
import com.maikerumine.ESMC.blocks.block_jt.CursedStoneBlock;
import com.maikerumine.ESMC.blocks.block_jt.KickVotingBlock;
import com.maikerumine.ESMC.blocks.block_jt.LagBlock;
import com.maikerumine.ESMC.blocks.block_jt.ProtectorBlock;
import com.maikerumine.ESMC.blocks.block_jt.TeleportBlock;
import com.maikerumine.ESMC.blocks.block_jt.VendorDepositorBlock;
import com.maikerumine.ESMC.blocks.block_jt.VendorVendorBlock;
import com.maikerumine.ESMC.blocks.block_mc.CoalOreBlock;
import com.maikerumine.ESMC.blocks.block_mc.DiamondBlock;
import com.maikerumine.ESMC.blocks.block_mc.DiamondOreBlock;
import com.maikerumine.ESMC.blocks.block_mc.EmeraldBlock;
import com.maikerumine.ESMC.blocks.block_mc.EmeraldOreBlock;
import com.maikerumine.ESMC.blocks.block_mc.GoldOreBlock;
import com.maikerumine.ESMC.blocks.block_mc.IronOreBlock;
import com.maikerumine.ESMC.blocks.block_mc.LapisOreBlock;
import com.maikerumine.ESMC.blocks.block_mc.RedstoneOreBlock;
import com.maikerumine.ESMC.blocks.block_mt.BronzeBlock;
import com.maikerumine.ESMC.blocks.block_mt.CopperBlock;
import com.maikerumine.ESMC.blocks.block_mt.CopperOreBlock;
import com.maikerumine.ESMC.blocks.block_mt.DesertCobbleBlock;
import com.maikerumine.ESMC.blocks.block_mt.DesertStone;
import com.maikerumine.ESMC.blocks.block_mt.DesertStoneBlock;
import com.maikerumine.ESMC.blocks.block_mt.MeseBlock;
import com.maikerumine.ESMC.blocks.block_mt.MeseOreBlock;
import com.maikerumine.ESMC.blocks.block_mt.MeselampBlock;
import com.maikerumine.ESMC.blocks.block_mt.NyancatBlock;
import com.maikerumine.ESMC.blocks.block_mt.ObsidianBlock;
import com.maikerumine.ESMC.blocks.block_mt.ObsidianBrickBlock;
import com.maikerumine.ESMC.blocks.block_mt.ObsidianGlassBlock;
import com.maikerumine.ESMC.blocks.block_mt.RainbowBlock;
import com.maikerumine.ESMC.blocks.block_mt.SmoothstoneBlock;
import com.maikerumine.ESMC.blocks.block_mt.StoneBlock;
import com.maikerumine.ESMC.blocks.block_mt.TinBlock;
import com.maikerumine.ESMC.blocks.block_mt.TinOreBlock;
import com.maikerumine.ESMC.blocks.machines.BlockSinteringFurnace;
import com.maikerumine.ESMC.blocks.slabs.BlockSlabDoubleBase;
import com.maikerumine.ESMC.blocks.slabs.BlockSlabHalfBase;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class ModBlocks 
{
	public static final List<Block> BLOCKS = new ArrayList<Block>();

	//	E S   B L O C K S
		//blocks
	public static final Block AIKERUM_BLOCK = new AikerumBlock("aikerum_block", Material.field_151588_w, null);
	public static final Block AIKERUM_ORE_BLOCK = new AikerumOreBlock("aikerum_ore_block", Material.field_151576_e, null);
	public static final Block DEPLETED_URANIUM_ORE_BLOCK = new DepletedUraniumOreBlock("depleted_uranium_ore_block", Material.field_151576_e, null);
	public static final Block INFINIUM_BLOCK = new InfiniumBlock("infinium_block", Material.field_151574_g, null);
	public static final Block INFINIUM_ORE_BLOCK = new InfiniumOreBlock("infinium_ore_block", Material.field_151576_e, null);
	public static final Block RUBY_BLOCK = new RubyBlock("ruby_block", Material.field_151588_w, null);
	public static final Block RUBY_ORE_BLOCK = new RubyOreBlock("ruby_ore_block", Material.field_151576_e, null);
	public static final Block PURPELLIUM_BLOCK = new PurpelliumBlock("purpellium_block", Material.field_151588_w, null);
	public static final Block PURPELLIUM_ORE_BLOCK = new PurpelliumOreBlock("purpellium_ore_block", Material.field_151576_e, null);
		//container
	public static final Block ESM_CHEST = new BlockEsmChest("esm_chest");		//BROKEN  ALSO TILE ENTITY HANDLER
		//fluid
	public static final Block TOXIC_WATER_FLUID = new BlockFluid("toxic_water_fluid", FluidInit.TOXIC_WATER_FLUID, Material.field_151587_i);
	
	// J U S T  T E S T   B L O C K S
		//blocks
	public static final Block ADMIN_TNT_BLOCK = new AdminTntBlock("admin_tnt_block", Material.field_151588_w, null);
	public static final Block CITY_BLOCK = new CityBlock("city_block", Material.field_151576_e, null);
	public static final Block CURSED_STONE_BLOCK = new CursedStoneBlock("cursed_stone_block", Material.field_151576_e, null);
	public static final Block KICK_VOTING_BLOCK = new KickVotingBlock("kick_voting_block", Material.field_151575_d, null);
	public static final Block LAG_BLOCK = new LagBlock("lag_block", Material.field_151574_g, null);
	public static final Block TELEPORT_BLOCK = new TeleportBlock("teleport_block", Material.field_151592_s, null);
		//container
	public static final Block VENDOR_DEPOSITOR_BLOCK = new VendorDepositorBlock("vendor_depositor_block", Material.field_151575_d);
	public static final Block VENDOR_VENDOR_BLOCK = new VendorVendorBlock("vendor_vendor_block", Material.field_151575_d);

	// M I N E T E S T   B L O C K S
		//blocks
	public static final Block BONES_BLOCK = new BonesBlock("bones_block", Material.field_151573_f);
	public static final Block BRONZE_BLOCK = new BronzeBlock("bronze_block", Material.field_151573_f, null);
	public static final Block COPPER_BLOCK = new CopperBlock("copper_block", Material.field_151573_f, null);
	public static final Block COPPER_ORE_BLOCK = new CopperOreBlock("copper_ore_block", Material.field_151573_f, null);
	public static final Block DESERT_COBBLE_BLOCK = new DesertCobbleBlock("desert_cobble_block", Material.field_151576_e, null);
	public static final Block DESERT_STONE = new DesertStone("desert_stone", Material.field_151576_e, null);
	public static final Block DESERT_STONE_BLOCK = new DesertStoneBlock("desert_stone_block", Material.field_151576_e, null);
	public static final Block MESE_BLOCK = new MeseBlock("mese_block", Material.field_151574_g, null);
	public static final Block MESELAMP_BLOCK = new MeselampBlock("meselamp_block", Material.field_151592_s, null);
	public static final Block MESE_ORE_BLOCK = new MeseOreBlock("mese_ore_block", Material.field_151576_e, null);
	public static final Block TIN_BLOCK = new TinBlock("tin_block", Material.field_151573_f, null);
	public static final Block TIN_ORE_BLOCK = new TinOreBlock("tin_ore_block", Material.field_151573_f, null);
	public static final Block OBSIDIAN_GLASS_BLOCK = new ObsidianGlassBlock("obsidian_glass_block", Material.field_151592_s);
	public static final Block OBSIDIAN_BLOCK = new ObsidianBlock("obsidian_block", Material.field_151576_e, null);
	public static final Block OBSIDIAN_BRICK_BLOCK = new ObsidianBrickBlock("obsidian_brick_block", Material.field_151576_e, null);
	public static final Block SMOOTHSTONE_BLOCK = new SmoothstoneBlock("smoothstone_block", Material.field_151576_e, null);//CHANGE TO STONEBLOCK
	public static final Block STONE_BLOCK = new StoneBlock("stone_block", Material.field_151576_e, null);
	
	//M I N E T E S T   M I S C.
		//blocks
	public static final Block PROTECTOR_BLOCK = new ProtectorBlock("protector_block", Material.field_151575_d, null);
	public static final Block NYANCAT_BLOCK = new NyancatBlock("nyancat_block", Material.field_151575_d);
	public static final Block RAINBOW_BLOCK = new RainbowBlock("rainbow_block", Material.field_151575_d);

	//M I N E C R A F T  B L O C K   R E P L A C E M E N T
		//blocks
	public static final Block COAL_ORE_BLOCK = new CoalOreBlock("coal_ore_block", Material.field_151576_e, null);
//	public static final Block EMERALD_BLOCK = new EmeraldBlock("emerald_block", Material.ICE, null);
	public static final Block EMERALD_ORE_BLOCK = new EmeraldOreBlock("emerald_ore_block", Material.field_151576_e, null);
//	public static final Block DIAMOND_BLOCK = new DiamondBlock("diamond_block", Material.ROCK, null);
	public static final Block DIAMOND_ORE_BLOCK = new DiamondOreBlock("diamond_ore_block", Material.field_151576_e, null);
	public static final Block GOLD_ORE_BLOCK = new GoldOreBlock("gold_ore_block", Material.field_151573_f, null);
//	public static final Block IRON_BLOCK = new IronBlock("iron_block", Material.IRON, null);
	public static final Block IRON_ORE_BLOCK = new IronOreBlock("iron_ore_block", Material.field_151573_f, null);
	public static final Block LAPIS_ORE_BLOCK = new LapisOreBlock("lapis_ore_block", Material.field_151573_f, null);
	public static final Block REDSTONE_ORE_BLOCK = new RedstoneOreBlock("redstone_ore_block", Material.field_151573_f, null);
	
	
	// H A R R Y S   T U T O R I A L   B L O C K S
	/**
	 * From Harry's Tutorial:  
	 * https://github.com/HarryTechRevs/Minecraft-Modding-1.12
	 * 
	 */
	//Copper
//	public static final Block COPPER_BLOCK = new BlockBase("copper_block", Material.IRON, Main.TUT);
//	public static final Block COPPER_DIRT = new BlockDirtBase("copper_dirt", Main.TUT);
//	public static final Block COPPER_LEAVES = new BlockLeavesBase("copper_leaves");
//	public static final Block COPPER_LOG = new BlockLogBase("copper_log");
//	public static final Block COPPER_ORE = new BlockBase("copper_ore", Material.ROCK, Main.TUT);
//	public static final Block COPPER_PLANKS = new BlockBase("copper_planks", Material.WOOD, Main.TUT);
//	public static final Block COPPER_SAPLING = new BlockSaplingBase("copper_sapling");
//	public static final Block COPPER_DOOR = new BlockDoorBase("copper_door", Material.ANVIL, null);
//	public static final BlockSlab COPPER_SLAB_DOUBLE = new BlockSlabDoubleBase("copper_slab_double", Material.IRON, Main.TUT, ModBlocks.COPPER_SLAB_HALF);
//	public static final BlockSlab COPPER_SLAB_HALF = new BlockSlabHalfBase("copper_slab_half", Material.IRON, Main.TUT, ModBlocks.COPPER_SLAB_HALF, ModBlocks.COPPER_SLAB_DOUBLE);
	
	//Aluminium
//	public static final Block ALUMINIUM_LEAVES = new BlockLeavesBase("aluminium_leaves");
//	public static final Block ALUMINIUM_LOG = new BlockLogBase("aluminium_log");
//	public static final Block ALUMINIUM_SAPLING = new BlockSaplingBase("aluminium_sapling");
	
	//Custom Models
//	public static final Block COPPER_CHEST = new BlockCopperChest("copper_chest");
	
//	public static final Block SANTA_HAT = new Block3DModelBase("santa_hat", Material.CLOTH, Main.TUT, 0.1875D, 0, 0.1875D, 0.8125D, 0.8125D, 0.8125D);
	
	//Machines
//	public static final Block SINTERING_FURNACE = new BlockSinteringFurnace("sintering_furnace");
//	public static final Block ELECTRIC_SINTERING_FURNACE = new BlockElectricSinteringFurnace("electric_sintering_furnace");
//	public static final Block GLOWSTONE_GENERATOR = new BlockGlowstoneGenerator("glowstone_generator");
//	public static final Block ENERGY_STORAGE = new BlockEnergyStorage("energy_storage");

	//Fluids
//	public static final Block MOLTEN_COPPER_BLOCK = new BlockFluid("molten_copper", FluidInit.MOLTEN_COPPER_FLUID, Material.LAVA);
	
}
