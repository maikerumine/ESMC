package com.maikerumine.ESMC.commands;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

public class CustomTeleporter extends Teleporter
{
	private final WorldServer world;
    private double x, y, z;
	
	public CustomTeleporter(WorldServer world, double x, double y, double z) 
	{
		super(world);
		this.world = world;
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	@Override
	public void func_180266_a(Entity entity, float rotationYaw) 
	{
		this.world.func_180495_p(new BlockPos((int) this.x, (int) this.y, (int) this.z));
        entity.func_70107_b(this.x, this.y, this.z);
        entity.field_70159_w = 0.0f;
        entity.field_70181_x = 0.0f;
        entity.field_70179_y = 0.0f;
	}
	
	public static void teleportToDimension(EntityPlayer player, int dimension, double x, double y, double z) 
	{
        int oldDimension = player.func_130014_f_().field_73011_w.getDimension();
        EntityPlayerMP entityPlayerMP = (EntityPlayerMP) player;
        MinecraftServer server = player.func_130014_f_().func_73046_m();
        WorldServer worldServer = server.func_71218_a(dimension);
        player.func_82242_a(0);

        if (worldServer == null || worldServer.func_73046_m() == null)
        {
            throw new IllegalArgumentException("Dimension: "+dimension+" doesn't exist!");
        }

        worldServer.func_73046_m().func_184103_al().transferPlayerToDimension(entityPlayerMP, dimension, new CustomTeleporter(worldServer, x, y, z));
        player.func_70634_a(x, y, z);
    }
}
