package com.maikerumine.ESMC.init;




import java.util.ArrayList;
import java.util.List;

import com.maikerumine.ESMC.util.Reference;
import com.maikerumine.ESMC.enchantments.EnchantmentSuperBoots;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid=Reference.MOD_ID)
public class EnchantmentInit 
{
	public static final List<Enchantment> ENCHANTMENTS = new ArrayList<Enchantment>();
	
	public static final Enchantment SUPER_BOOTS = new EnchantmentSuperBoots();
	
	@SubscribeEvent
	public static void createMagma(LivingUpdateEvent event) 
	{	
		EntityLivingBase living = event.getEntityLiving();
		int level = EnchantmentHelper.func_185284_a(SUPER_BOOTS, living);
		BlockPos pos = living.func_180425_c();
		
		if(level > 0)
		{
			World world = event.getEntity().field_70170_p;
			if (living.field_70122_E)
			{
				float f = (float)Math.min(16, 2 + level);
				BlockPos.MutableBlockPos blockpos = new BlockPos.MutableBlockPos(0, 0, 0);

				for (BlockPos.MutableBlockPos blockpos1 : BlockPos.func_177975_b(pos.func_177963_a((double)(-f), -1.0D, (double)(-f)), pos.func_177963_a((double)f, -1.0D, (double)f)))
				{
					if (blockpos1.func_177957_d(living.field_70165_t, living.field_70163_u, living.field_70161_v) <= (double)(f * f))
					{
						blockpos.func_181079_c(blockpos1.func_177958_n(), blockpos1.func_177956_o() + 1, blockpos1.func_177952_p());
						IBlockState iblockstate = world.func_180495_p(blockpos);

						if (iblockstate.func_185904_a() == Material.field_151579_a)
						{
							IBlockState iblockstate1 = world.func_180495_p(blockpos1);

							if (iblockstate1.func_185904_a() == Material.field_151587_i && (iblockstate1.func_177230_c() == Blocks.field_150353_l || iblockstate1.func_177230_c() == Blocks.field_150356_k) && ((Integer)iblockstate1.func_177229_b(BlockLiquid.field_176367_b)).intValue() == 0 && world.func_190527_a(Blocks.field_189877_df, blockpos1, false, EnumFacing.DOWN, (Entity)null))
							{
								world.func_175656_a(blockpos1, Blocks.field_189877_df.func_176223_P());
								world.func_175684_a(blockpos1.func_185334_h(), Blocks.field_189877_df, MathHelper.func_76136_a(living.func_70681_au(), 60, 120));
								living.func_70690_d(new PotionEffect(Potion.func_188412_a(12)));
							}
						}
					}
				}
			}
		}
	}
}
