package com.maikerumine.ESMC.proxy;

import net.minecraft.item.Item;

public class CommonProxy 
	{
		public void registerModel(Item item, int metadata) {}
		public static void registerRenderThings(){
			//This dummy method is needed on the server so you don't crash.
			}
	}




/**
public static void registerRenderThings(){
	//This dummy method is needed on the server so you don't crash.
	}
*/
