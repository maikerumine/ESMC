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

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;
import java.util.Map;


import com.maikerumine.ESMC.Main;



import com.google.common.collect.Lists;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiCreateWorld;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ModelManager;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.RenderEntityItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.resources.LanguageManager;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.entity.monster.EntityHusk;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityStray;
import net.minecraft.entity.monster.EntityWitherSkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.monster.EntityZombieVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MouseHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.translation.LanguageMap;
import net.minecraft.world.World;
import net.minecraftforge.client.event.EntityViewRenderEvent.FogColors;
import net.minecraftforge.client.event.EntityViewRenderEvent.FogDensity;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.ReflectionHelper;
import net.minecraftforge.fml.relauncher.Side;



//public class ClientProxy extends CommonProxy   //maik

// TODO: Auto-generated Javadoc
//@EventBusSubscriber(value = Side.CLIENT, modid = Main.MOD_ID)
public class ClientProxy implements IProxy
{

	
    
//	public class IProxy 
	/**
	 * Thus is Harrys code
	 */
//	{
//		public void registerModel(Item item, int metadata) {}
//	}

//		public class ClientProxy extends IProxy 
		/**
		 * This is Harry's code
		 * @return 
*/
//		{
			@Override
			public void registerModel(Item item, int metadata) 
			{
				ModelLoader.setCustomModelResourceLocation(item, metadata, new ModelResourceLocation(item.getRegistryName(), "inventory"));
			}
//		}		
		
		
		
		
		
		

    //public static ModRenderItem modRenderItem; // used to provide custom enchantment glint color
    public static Field modelManager = ReflectionHelper.findField(Minecraft.class, "modelManager", "modelManager");
    public static Field renderItem = ReflectionHelper.findField(Minecraft.class, "renderItem", "renderItem");
    public static Field itemRenderer = ReflectionHelper.findField(ItemRenderer.class, "itemRenderer", "itemRenderer");
    public static Field playerRenderer = ReflectionHelper.findField(RenderManager.class, "playerRender", "playerRenderer");




    /* (non-Javadoc)
     * @see com.maikerumine.ESMC.proxy.IProxy#preInit(net.minecraftforge.fml.common.event.FMLPreInitializationEvent)
     */
    @Override
    public void preInit(FMLPreInitializationEvent event)
    {
        // DEBUG
        System.out.println("on Client side");
        
        Minecraft mc = Minecraft.func_71410_x();
    }
        

    


    /* (non-Javadoc)
     * @see com.maikerumine.ESMC.proxy.IProxy#postInit(net.minecraftforge.fml.common.event.FMLPostInitializationEvent)
     */
    @Override
    public void postInit(FMLPostInitializationEvent event)
    {
        // DEBUG
        System.out.println("on Client side");

        refreshLangResources();
    }

    /**
     * Refresh lang resources.
     */
    @SuppressWarnings("unlikely-arg-type")
    public void refreshLangResources()
    {
        // DEBUG
        System.out.println("Refreshing lang files with proper precedence");
//        Minecraft.getMinecraft().refreshResources();
        List<String> list = Lists.newArrayList("en_us");

        if (!"en_us".equals(Minecraft.func_71410_x().func_135016_M().func_135041_c()))
        {
            list.add(Minecraft.func_71410_x().func_135016_M().func_135041_c().toString());
        }

    }

  
    /* (non-Javadoc)
     * @see com.maikerumine.ESMC.proxy.IProxy#serverStarting(net.minecraftforge.fml.common.event.FMLServerStartingEvent)
     */
    @Override
    public void serverStarting(FMLServerStartingEvent event)
    {
        // This will never get called on client side
    }





	@Override
	public void init(FMLInitializationEvent event) {
		// TODO Auto-generated method stub
		
	}





	@Override
	public EntityPlayer getPlayerEntityFromContext(MessageContext parContext) {
		// TODO Auto-generated method stub
		return null;
	}





	@Override
	public boolean handleMaterialAcceleration(Entity parEntity, Material parMaterial) {
		// TODO Auto-generated method stub
		return false;
	}

}



//maikeru junk below
/**
 * 
 * package com.maikerumine.ESMC.proxy;


import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public class ClientProxy extends CommonProxy 
/**
 * This is Harry's code

{
	@Override
	public void registerModel(Item item, int metadata) 
	{
		ModelLoader.setCustomModelResourceLocation(item, metadata, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
}

*/

/**
 * THIS IS Loremaster Code
{
	public void registerItemRenderer(Item item, int meta, String id) 
	{
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
	}
}	
**/


/*  from mcreator

	@Override
	public void registerRenderers(testenvironmentmod instance) {
		instance.mcreator_0.registerRenderers();
	}
	*/

