package com.maikerumine.ESMC.rendering.models.entities;


import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Minetest Stonemonster replica
 * Created using Tabula 7.0.0
 */
public class ModelStonemonster extends ModelBase {
    public ModelRenderer arm_right;
    public ModelRenderer leg_right;
    public ModelRenderer head_inner;
    public ModelRenderer body;
    public ModelRenderer arm_left;
    public ModelRenderer leg_left;

    public ModelStonemonster() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.arm_left = new ModelRenderer(this, 40, 16);
        this.arm_left.field_78809_i = true;
        this.arm_left.func_78793_a(6.0F, 1.0F, 0.0F);
        this.arm_left.func_78790_a(-1.0F, -2.0F, -2.0F, 2, 14, 3, 0.0F);
        this.setRotateAngle(arm_left, -1.5707963267948966F, 0.0F, 0.0F);
        this.arm_right = new ModelRenderer(this, 40, 16);
        this.arm_right.func_78793_a(-6.0F, 1.0F, 0.0F);
        this.arm_right.func_78790_a(-1.0F, -2.0F, -2.0F, 2, 14, 3, 0.0F);
        this.setRotateAngle(arm_right, -1.5707963267948966F, 0.0F, 0.0F);
        this.body = new ModelRenderer(this, 16, 16);
        this.body.func_78793_a(0.0F, -1.0F, 0.0F);
        this.body.func_78790_a(-4.5F, 0.0F, -1.5F, 9, 13, 3, 0.0F);
        this.leg_right = new ModelRenderer(this, 0, 16);
        this.leg_right.func_78793_a(-2.5F, 12.0F, -0.6F);
        this.leg_right.func_78790_a(-1.6F, 0.0F, -1.0F, 3, 12, 2, 0.0F);
        this.head_inner = new ModelRenderer(this, 20, 0);
        this.head_inner.func_78793_a(0.0F, -2.0F, 0.0F);
        this.head_inner.func_78790_a(-4.0F, -7.0F, -4.0F, 8, 7, 8, 0.0F);
        this.leg_left = new ModelRenderer(this, 0, 16);
        this.leg_left.field_78809_i = true;
        this.leg_left.func_78793_a(2.5F, 12.0F, -0.6F);
        this.leg_left.func_78790_a(-1.5F, 0.0F, -1.0F, 3, 12, 2, 0.0F);
    }

    @Override
    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.arm_right.func_78785_a(f5);
        this.head_inner.func_78785_a(f5);
        this.arm_left.func_78785_a(f5);
        this.leg_left.func_78785_a(f5);
        this.leg_right.func_78785_a(f5);
        this.body.func_78785_a(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }
    
    
    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn)
    {
    	this.arm_left.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    	this.leg_left.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    	this.arm_right.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
    	this.leg_right.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
    	
    	this.head_inner.field_78796_g = netHeadYaw * 0.017453292F;
    	this.head_inner.field_78795_f = headPitch * 0.017453292F;
    		
    }
    
    
}
