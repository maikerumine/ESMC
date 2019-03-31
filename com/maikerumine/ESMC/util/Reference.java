package com.maikerumine.ESMC.util;


import com.maikerumine.ESMC.init.FluidInit;
import com.maikerumine.ESMC.util.handlers.TileEntityHandler;

import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class Reference 
{
	public static final String MOD_ID = "esm";
	public static final String NAME = "Extreme Survival Minecraft";
	public static final String VERSION = "1.12.2";
	public static final String ACCEPTED_VERSIONS = "[1.12.2]";
	public static final int ENTITY_STONEMONSTER = 222;			//SHUT OFF TO FIX.  ALSO ENTITY INIT
	public static final int GUI_ESM_CHEST = 2;

	public static final String CLIENT = "com.maikerumine.ESMC.proxy.ClientProxy";		//Harry's
	public static final String SERVER = "com.maikerumine.ESMC.proxy.CommonProxy";		//Harry's

}
