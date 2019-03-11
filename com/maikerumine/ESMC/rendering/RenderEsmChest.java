package com.maikerumine.ESMC.rendering;

import com.maikerumine.ESMC.util.Reference;
import com.maikerumine.ESMC.blocks.tileentities.TileEntityEsmChest;
import com.maikerumine.ESMC.rendering.models.blocks.ModelEsmChest;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderEsmChest extends TileEntitySpecialRenderer<TileEntityEsmChest>
{
	private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/blocks/esm_chest_front.png");
	private final ModelEsmChest MODEL = new ModelEsmChest();
	
	@Override
	public void func_192841_a(TileEntityEsmChest te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) 
	{
		GlStateManager.func_179126_j();
        GlStateManager.func_179143_c(515);
        GlStateManager.func_179132_a(true);
    	
    	ModelEsmChest model = MODEL;
    	
    	if (destroyStage >= 0)
        {
            this.func_147499_a(field_178460_a[destroyStage]);
            GlStateManager.func_179128_n(5890);
            GlStateManager.func_179094_E();
            GlStateManager.func_179152_a(4.0F, 4.0F, 1.0F);
            GlStateManager.func_179109_b(0.0625F, 0.0625F, 0.0625F);
            GlStateManager.func_179128_n(5888);
        }
    	else this.func_147499_a(TEXTURE);
    	
    	GlStateManager.func_179094_E();
        GlStateManager.func_179091_B();
        GlStateManager.func_179109_b((float)x, (float)y + 1.0F, (float)z + 1.0F);
        GlStateManager.func_179152_a(1.0F, -1.0F, -1.0F);
        GlStateManager.func_179109_b(0.5F, 0.5F, 0.5F);
        GlStateManager.func_179109_b(-0.5F, -0.5F, -0.5F);
       
        float f = te.prevLidAngle + (te.lidAngle - te.prevLidAngle) * partialTicks;
        f = 1.0F - f;
        f = 1.0F - f * f * f;
        model.chestLid.field_78795_f = -(f * ((float)Math.PI / 2F));
        model.renderAll();
        GlStateManager.func_179101_C();
        GlStateManager.func_179121_F();
        GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);

        if (destroyStage >= 0)
        {
            GlStateManager.func_179128_n(5890);
            GlStateManager.func_179121_F();
            GlStateManager.func_179128_n(5888);
        }	
	}
}
