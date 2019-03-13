package com.maikerumine.ESMC.util;

import com.maikerumine.ESMC.proxy.IProxy;

import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class Reference 
{
	public static final String MOD_ID = "esm";
	public static final String NAME = "Extreme Survival Minecraft";
	public static final String VERSION = "1.12.2";
	public static final String ACCEPTED_VERSIONS = "[1.10,1.10.1,1.10.2,1.11,1.11.1,1.11.2,1.12.,1.12.1,1.12.2]";
//	public static final String CLIENT_PROXY_CLASS = "com.maikerumine.ESMC.proxy.ClientProxy";
//	public static final String COMMON_PROXY_CLASS = "com.maikerumine.ESMC.proxy.CommonProxy";
	
	/**
	 * From Jabelar's code
	 * 
	 */
    // Says where the client and server 'proxy' code is loaded.
    @SidedProxy(clientSide = "com.maikerumine.ESMC.proxy.ClientProxy",
            serverSide = "com.maikerumine.ESMC.proxy.ServerProxy")
    public static IProxy proxy;
    
    /**
     * Pre-Initialization FML Life Cycle event handling method which is automatically
     * called by Forge. It must be annotated as an event handler.
     *
     * @param event the event
     */
    @EventHandler
    // preInit "Run before anything else. Read your config, create blocks, items, etc, and register them with the GameRegistry."
    public void preInit(FMLPreInitializationEvent event)
    {
        // DEBUG
        System.out.println("preInit() " + event.getModMetadata().name);

        // Utilities.setModInfo(event);
        // ModConfig.initConfig(event); // load configuration before doing anything else that may be controlled by it.
        // register stuff
        // ModTileEntities.registerTileEntities();
        // ModFluids.registerFluids();
        // ModNetworking.registerSimpleNetworking();
        // ModWorldGen.registerDimensions();


        proxy.preInit(event);
    }
    
    
	public static final int ENTITY_STONEMONSTER = 222;			//SHUT OFF TO FIX.  ALSO ENTITY INIT
	public static final int GUI_ESM_CHEST = 2;

}
