package com.maikerumine.ESMC.world.dimensions;

import com.maikerumine.ESMC.init.BiomeInit;
import com.maikerumine.ESMC.init.DimensionInit;
import com.maikerumine.ESMC.world.generation.chunks.ChunkGeneratorNetherTemplate;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.gen.IChunkGenerator;

public class DimensionLibrary extends WorldProvider
{
	public DimensionLibrary() 
	{
		this.field_76578_c = new BiomeProviderSingle(BiomeInit.DESERT);
		this.field_191067_f = false;
	}
	
	@Override
	public DimensionType func_186058_p() 
	{
		return DimensionInit.DESERT;
	}
	
	@Override
	public IChunkGenerator func_186060_c() 
	{
		return new ChunkGeneratorNetherTemplate(field_76579_a, true, field_76579_a.func_72905_C());
	}
	
	@Override
	public boolean func_76567_e() 
	{
		return false;
	}
	
	@Override
	public boolean func_76569_d() 
	{
		return false;
	}
}
