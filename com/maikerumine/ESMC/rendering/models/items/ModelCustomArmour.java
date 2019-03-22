package com.maikerumine.ESMC.rendering.models.items;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelCustomArmour extends ModelBiped
{
    public ModelRenderer shape15;

    public ModelCustomArmour()
    {
        this.field_78090_t = 128;
        this.field_78089_u = 128;
        
        this.shape15 = new ModelRenderer(this, 82, 0);
        this.shape15.func_78793_a(-4.0F, -8.0F, -4.0F);
        this.shape15.func_78790_a(-1.0F, -5.0F, -1.0F, 10, 5, 12, 0.0F);
        
        this.field_78116_c.func_78792_a(shape15);
    }

    @Override
    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) 
    { 
    	super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) 
    {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }
}
