package com.maikerumine.ESMC.world.type;

import com.maikerumine.ESMC.init.BiomeInit;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.biome.BiomeProviderSingle;

public class WorldTypeOcean extends WorldType
{
	public WorldTypeOcean() 
	{
		super("Ocean");
	}
	
	@Override
	public BiomeProvider getBiomeProvider(World world) 
	{
		BiomeProvider provider = new BiomeProviderSingle(BiomeInit.OCEAN);
		return provider;
	}
}
