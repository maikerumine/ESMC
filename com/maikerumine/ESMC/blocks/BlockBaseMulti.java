package com.maikerumine.ESMC.blocks;

import com.maikerumine.ESMC.Main;
import com.maikerumine.ESMC.init.ModBlocks;
import com.maikerumine.ESMC.init.ModItems;
import com.maikerumine.ESMC.util.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;



public class BlockBaseMulti extends Block implements IHasModel 
{
    public static final PropertyDirection FACING = PropertyDirection.func_177714_a("facing");

    public BlockBaseMulti(String name, Material material) {
		super(material);
		func_149663_c(name);
		setRegistryName(name);
		func_149647_a(CreativeTabs.field_78030_b);
		
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));

        func_180632_j(field_176227_L.func_177621_b().func_177226_a(FACING, EnumFacing.NORTH));
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.func_150898_a(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public void func_180633_a(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        world.func_180501_a(pos, state.func_177226_a(FACING, getFacingFromEntity(pos, placer)), 2);
    }

    public static EnumFacing getFacingFromEntity(BlockPos clickedBlock, EntityLivingBase entity) {
        return EnumFacing.func_176737_a(
             (float) (entity.field_70165_t - clickedBlock.func_177958_n()),
             (float) (entity.field_70163_u - clickedBlock.func_177956_o()),
             (float) (entity.field_70161_v - clickedBlock.func_177952_p()));
    }

    @Override
    public IBlockState func_176203_a(int meta) {
        return func_176223_P().func_177226_a(FACING, EnumFacing.func_82600_a(meta & 7));
    }

    @Override
    public int func_176201_c(IBlockState state) {
        return state.func_177229_b(FACING).func_176745_a();
    }

    @Override
    protected BlockStateContainer func_180661_e() {
        return new BlockStateContainer(this, FACING);
    }

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(Item.func_150898_a(this), 0, "inventory");
		
	}
}
