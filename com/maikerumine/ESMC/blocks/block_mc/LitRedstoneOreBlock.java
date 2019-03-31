package com.maikerumine.ESMC.blocks.block_mc;

import java.util.Random;

import com.maikerumine.ESMC.Main;
import com.maikerumine.ESMC.blocks.BlockBase;
import com.maikerumine.ESMC.init.ModItems;

import net.minecraft.block.BlockRedstoneOre;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class LitRedstoneOreBlock extends BlockBase {

	public LitRedstoneOreBlock(String name, Material material) {
		super(name, material, Main.MINETEST);
		func_149672_a(SoundType.field_185851_d);
		func_149711_c(3.0F);
		func_149752_b(5.0F);
		setHarvestLevel("pickaxe", 2);
		func_149715_a(0.625F);
		//setLightOpacity(1);
		//setBlockUnbreakable();
	}
	


	@Override
	public Item func_180660_a(IBlockState state, Random rand, int fortune) {
		return Items.field_151137_ax;
	}
	
	@Override
	public int func_149745_a (Random rand) {
		//return 3;
		int max = 4;
		int min = 1;
		return rand.nextInt(max) + min;
		
	}
	
//REF
	/**
	 *  registerBlock(73, "redstone_ore", (new BlockRedstoneOre(false)).setHardness(3.0F).setResistance(5.0F).setSoundType(SoundType.STONE).setUnlocalizedName("oreRedstone").setCreativeTab(CreativeTabs.BUILDING_BLOCKS));
        registerBlock(74, "lit_redstone_ore", (new BlockRedstoneOre(true)).setLightLevel(0.625F).setHardness(3.0F).setResistance(5.0F).setSoundType(SoundType.STONE).setUnlocalizedName("oreRedstone"));
        
        
	 */
    /**
     * Gathers how much experience this block drops when broken.
     *
     * @param state The current state
     * @param world The world
     * @param pos Block position
     * @param fortune
     * @return Amount of XP from breaking this block.
     */
    public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune)
    {
        return 2;
    }
}
