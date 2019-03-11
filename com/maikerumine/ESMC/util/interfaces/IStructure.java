package com.maikerumine.ESMC.util.interfaces;

import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.world.WorldServer;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraftforge.fml.common.FMLCommonHandler;

public interface IStructure 
{
	public static final WorldServer worldServer = FMLCommonHandler.instance().getMinecraftServerInstance().func_71218_a(0);
	public static final PlacementSettings settings = (new PlacementSettings()).func_186218_a(null).func_186222_a(false).func_186226_b(false).func_186214_a(Mirror.NONE).func_186220_a(Rotation.NONE);
}
