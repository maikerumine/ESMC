package com.maikerumine.ESMC.blocks;



import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.world.World;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.Minecraft;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockGlass;
import net.minecraft.block.Block;

import java.util.Random;

public class ModGlassBlock {



	public ModGlassBlock() {
	}

	public static BlockGlass block;
	public static Item item;
	public static Object instance;

	public int addFuel(ItemStack fuel) {
		return 0;
	}

	public void serverLoad(FMLServerStartingEvent event) {
	}

	public void preInit(FMLPreInitializationEvent event) {
		block.setRegistryName("glass");
		ForgeRegistries.BLOCKS.register(block);
		item = new ItemBlock(block).setRegistryName(block.getRegistryName());
		ForgeRegistries.ITEMS.register(item);
	}

	public void registerRenderers() {
	}

	public void load(FMLInitializationEvent event) {
		if (event.getSide() == Side.CLIENT) {
			Minecraft.func_71410_x().func_175599_af().func_175037_a()
					.func_178086_a(item, 0, new ModelResourceLocation("esmc:obsidian_glass", "inventory"));
		}
	}

	static {
		block = (BlockGlass) (new BlockGlass().func_149711_c(2.0F).func_149752_b(10.0F).func_149715_a(0.0F).func_149663_c("glass")
				.func_149713_g(0).func_149647_a(CreativeTabs.field_78030_b));
		block.setHarvestLevel("pickaxe", 4);
	}

	public void generateSurface(World world, Random random, int chunkX, int chunkZ) {
	}

	public void generateNether(World world, Random random, int chunkX, int chunkZ) {
	}

	static class BlockGlass extends Block {

		int a1 = 0, a2 = 0, a3 = 0, a4 = 0, a5 = 0, a6 = 0;
		boolean red = false;

		protected BlockGlass() {
			super(Material.field_151592_s);
			func_149672_a(SoundType.field_185853_f);
		}

		@Override
		public void func_176213_c(World world, BlockPos pos, IBlockState state) {
			int i = pos.func_177958_n();
			int j = pos.func_177956_o();
			int k = pos.func_177952_p();
			world.func_175684_a(new BlockPos(i, j, k), this, this.func_149738_a(world));
		}

		@Override
		public int func_180656_a(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
			return red ? 15 : 0;
		}

		@Override
		public int func_176211_b(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
			return red ? 15 : 0;
		}

		@Override
		public boolean func_149662_c(IBlockState state) {
			return false;
		}

		@SideOnly(Side.CLIENT)
		@Override
		public BlockRenderLayer func_180664_k() {
			return BlockRenderLayer.CUTOUT;
		}

		@Override
		public AxisAlignedBB func_185496_a(IBlockState state, IBlockAccess source, BlockPos pos) {
			return new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
		}

		@Override
		public int func_149738_a(World world) {
			return 10;
		}

		@Override
		public int func_149745_a(Random par1Random) {
			return 1;
		}
	}
}
