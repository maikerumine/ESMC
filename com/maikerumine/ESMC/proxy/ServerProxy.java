/**
    Copyright (C) 2017 by jabelar

    This file is part of jabelar's Minecraft Forge modding examples; as such,
    you can redistribute it and/or modify it under the terms of the GNU
    General Public License as published by the Free Software Foundation,
    either version 3 of the License, or (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
    GNU General Public License for more details.

    For a copy of the GNU General Public License see <http://www.gnu.org/licenses/>.
*/

package com.maikerumine.ESMC.proxy;

//import com.maikerumine.ESMC.blocks.BlockLeavesCloud;
//import com.maikerumine.ESMC.commands.CommandStructureCapture;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

// TODO: Auto-generated Javadoc
public class ServerProxy implements IProxy
{
    
    /* (non-Javadoc)
     * @see com.blogspot.jabelarminecraft.examplemod.proxy.IProxy#preInit(net.minecraftforge.fml.common.event.FMLPreInitializationEvent)
     */
    @Override
    public void preInit(FMLPreInitializationEvent event)
    {
    }

    /* (non-Javadoc)
     * @see com.blogspot.jabelarminecraft.examplemod.proxy.IProxy#init(net.minecraftforge.fml.common.event.FMLInitializationEvent)
     */
    @Override
    public void init(FMLInitializationEvent event)
    {
    }
    
    /* (non-Javadoc)
     * @see com.blogspot.jabelarminecraft.examplemod.proxy.IProxy#postInit(net.minecraftforge.fml.common.event.FMLPostInitializationEvent)
     */
    @Override
    public void postInit(FMLPostInitializationEvent event)
    {
    }
    
    /* (non-Javadoc)
     * @see com.blogspot.jabelarminecraft.examplemod.proxy.IProxy#serverStarting(net.minecraftforge.fml.common.event.FMLServerStartingEvent)
     */
    @Override
    public void serverStarting(FMLServerStartingEvent event)
    {
//        event.registerServerCommand(new CommandStructureCapture());
    }
    
    /* (non-Javadoc)
     * @see com.blogspot.jabelarminecraft.examplemod.proxy.IProxy#getPlayerEntityFromContext(net.minecraftforge.fml.common.network.simpleimpl.MessageContext)
     */
    @Override
    public EntityPlayer getPlayerEntityFromContext(MessageContext ctx)
    {
        return ctx.getServerHandler().field_147369_b;
    }

    /* (non-Javadoc)
     * @see com.blogspot.jabelarminecraft.examplemod.proxy.IProxy#handleMaterialAcceleration(net.minecraft.entity.Entity, net.minecraft.block.material.Material)
     */
    @Override
    public boolean handleMaterialAcceleration(Entity entityIn, Material materialIn)
    {
        World parWorld = entityIn.field_70170_p;
        AxisAlignedBB bb = entityIn.func_174813_aQ().func_72314_b(0.0D, -0.4000000059604645D, 0.0D).func_186664_h(0.001D);

        int j2 = MathHelper.func_76128_c(bb.field_72340_a);
        int k2 = MathHelper.func_76143_f(bb.field_72336_d);
        int l2 = MathHelper.func_76128_c(bb.field_72338_b);
        int i3 = MathHelper.func_76143_f(bb.field_72337_e);
        int j3 = MathHelper.func_76128_c(bb.field_72339_c);
        int k3 = MathHelper.func_76143_f(bb.field_72334_f);

        boolean flag = false;
        Vec3d vec3d = Vec3d.field_186680_a;
        BlockPos.PooledMutableBlockPos blockpos$pooledmutableblockpos = BlockPos.PooledMutableBlockPos.func_185346_s();

        for (int l3 = j2; l3 < k2; ++l3)
        {
            for (int i4 = l2; i4 < i3; ++i4)
            {
                for (int j4 = j3; j4 < k3; ++j4)
                {
                    blockpos$pooledmutableblockpos.func_181079_c(l3, i4, j4);
                    IBlockState iblockstate1 = parWorld.func_180495_p(blockpos$pooledmutableblockpos);
                    Block block = iblockstate1.func_177230_c();

                    Boolean result = block.isEntityInsideMaterial(parWorld, blockpos$pooledmutableblockpos, iblockstate1, entityIn, i3, materialIn, false);
                    if (result != null && result == true)
                    {
                        // Forge: When requested call blocks modifyAcceleration method, and more importantly cause this method to return true, which results in an entity being
                        // "inWater"
                        flag = true;
                        vec3d = block.func_176197_a(parWorld, blockpos$pooledmutableblockpos, entityIn, vec3d);

                        // // DEBUG
                        // System.out.println("Entity is inside material = "+materialIn+" and motion add vector = "+vec3d);

                        continue;
                    }
                    else if (result != null && result == false)
                        continue;

                    if (iblockstate1.func_185904_a() == materialIn)
                    {
                        // // DEBUG
                        // System.out.println("blockstate material matches material in");

                        double d0 = i4 + 1 - BlockLiquid.func_149801_b(iblockstate1.func_177229_b(BlockLiquid.field_176367_b).intValue());

                        if (i3 >= d0)
                        {
                            flag = true;
                            vec3d = block.func_176197_a(parWorld, blockpos$pooledmutableblockpos, entityIn, vec3d);

                            // // DEBUG
                            // System.out.println("deep enough to push entity and motion add = "+vec3d);
                        }
                    }
                }
            }
        }

        blockpos$pooledmutableblockpos.func_185344_t();

        if (vec3d.func_72433_c() > 0.0D && entityIn.func_96092_aw())
        {
            // // DEBUG
            // System.out.println("motion vector is non-zero");

            /*
             * Although applied to all entities, EntityPlayer doesn't really take affect, so the fluid motion control is handled in the client-side PlayerTickEvent
             */
            vec3d = vec3d.func_72432_b();
            double d1 = 0.014D;
            entityIn.field_70159_w += vec3d.field_72450_a * d1;
            entityIn.field_70181_x += vec3d.field_72448_b * d1;
            entityIn.field_70179_y += vec3d.field_72449_c * d1;
        }
        else
        {
            // // DEBUG
            // System.out.println("motion vector is zero");
        }

        entityIn.field_70143_R = 0.0F;

        return flag;
    }

	@Override
	public void registerModel(Item item, int metadata) {
		// TODO Auto-generated method stub
		
	}

    /* (non-Javadoc)
     * @see com.blogspot.jabelarminecraft.examplemod.proxy.IProxy#setGraphicsLevel(com.blogspot.jabelarminecraft.examplemod.blocks.BlockLeavesCloud, boolean)
     */
//    @Override
//    public void setGraphicsLevel(BlockLeavesCloud parBlock, boolean parFancyEnabled)
//    {
//    }
}
