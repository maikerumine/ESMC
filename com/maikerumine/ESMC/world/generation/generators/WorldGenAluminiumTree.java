package com.maikerumine.ESMC.world.generation.generators;

import java.util.Random;

import com.maikerumine.ESMC.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.IPlantable;

public class WorldGenAluminiumTree extends WorldGenAbstractTree 
{
	//public static final IBlockState LOG = ModBlocks.ALUMINIUM_LOG.getDefaultState();
	//public static final IBlockState LEAF = ModBlocks.ALUMINIUM_LEAVES.getDefaultState();
	
	private final int minHeight;
	
	public WorldGenAluminiumTree() 
	{
		super(false);
		this.minHeight = 12;
	}

	@Override
	public boolean func_180709_b(World world, Random rand, BlockPos pos) 
	{
		int height = this.minHeight + rand.nextInt(3);
		boolean flag = true;
		
		int x = pos.func_177958_n();
		int y = pos.func_177956_o();
		int z = pos.func_177952_p();
		
		for(int yPos = y; yPos <= y + 1 + height; yPos++)
		{
			int b0 = 2;
			if(yPos == y) b0 = 1;
			if(yPos >= y + 1 + height - 2) b0 = 2;
			
			BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();
			
			for(int xPos = x - b0; xPos <= x + b0 && flag; xPos++)
			{
				for(int zPos = z - b0; zPos <- z + b0 && flag; zPos++)
				{
					if(yPos >= 0 && yPos < world.func_72800_K())
					{
						if(!this.isReplaceable(world, new BlockPos(xPos, yPos, zPos)))
						{
							flag = false;
						}
					}
					else
					{
						flag = false;
					}
				}
			}
		}
		
		if(!flag)
		{
			return false;
		}
		else
		{
			BlockPos down = pos.func_177977_b();
			IBlockState state = world.func_180495_p(down);
			boolean isSoil = state.func_177230_c().canSustainPlant(state, world, down, EnumFacing.UP, (IPlantable) Blocks.field_150345_g);
			
			if(isSoil && y < world.func_72800_K() - height - 1)
			{
				state.func_177230_c().onPlantGrow(state, world, down, pos);
				
				for(int yPos = y - 3 + height; yPos <= y + height; yPos++)
				{
					int b1 = yPos - (y + height);
					int b2 = 1 - b1 / 2;
					
					for(int xPos = x - b2; xPos <= x + b2; xPos++)
					{
						int b3 = xPos - x;
						for(int zPos = z - b2; zPos <= z + b2; zPos++)
						{
							int b4 = zPos - z;
							if(Math.abs(b3) != b2 || Math.abs(b4) != b2 || rand.nextInt(2) != 0 && b1 != 0)
							{
								BlockPos treePos = new BlockPos(xPos, yPos, zPos);
								IBlockState treeState = world.func_180495_p(treePos);
								if(treeState.func_177230_c().isAir(treeState, world, treePos) || treeState.func_177230_c().isAir(treeState, world, treePos))
								{
//									this.setBlockAndNotifyAdequately(world, treePos, LEAF);
//									this.setBlockAndNotifyAdequately(world, treePos.add(0, -0.25 * height, 0), LEAF);
//									this.setBlockAndNotifyAdequately(world, treePos.add(0, -0.5 * height, 0), LEAF);
								}
							}
						}
					}
				}
				
				for(int logHeight = 0; logHeight < height; logHeight++)
				{
					BlockPos up = pos.func_177981_b(logHeight);
					IBlockState logState = world.func_180495_p(up);
					
					if(logState.func_177230_c().isAir(logState, world, up) || logState.func_177230_c().isLeaves(logState, world, up))
					{
//						this.setBlockAndNotifyAdequately(world, pos.up(logHeight), LOG);
					}
				}
				
				return true;
			}
		}
		
		return true;
	}	
	
	@Override
	protected boolean func_150523_a(Block blockType)
	{
		Material material = blockType.func_176223_P().func_185904_a();
        return material == Material.field_151579_a || material == Material.field_151584_j || material == Material.field_151578_c || blockType == Blocks.field_150349_c || blockType == Blocks.field_150346_d || blockType == Blocks.field_150364_r || blockType == Blocks.field_150363_s || blockType == Blocks.field_150345_g || blockType == Blocks.field_150395_bd;
  
	}
}
