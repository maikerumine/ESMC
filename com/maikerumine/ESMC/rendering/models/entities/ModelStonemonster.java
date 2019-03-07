package com.maikerumine.ESMC.rendering.models.entities;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelStonemonster extends ModelBase 
{
    public ModelRenderer CowBody;
    public ModelRenderer Udders;
    public ModelRenderer RearLeftLeg;
    public ModelRenderer FrontLeftLeg;
    public ModelRenderer RearRightLeg;
    public ModelRenderer FrontRightLeg;
    public ModelRenderer VillagerHead;
    public ModelRenderer VillagerCoat;
    public ModelRenderer VillagerMiddleArm;
    public ModelRenderer VillagerRightArm;
    public ModelRenderer VillagerLeftArm;
    public ModelRenderer VillagerChest;
    public ModelRenderer VillagerNose;

    public ModelStonemonster() 
    {
        this.field_78090_t = 64;
        this.field_78089_u = 32;
        this.FrontLeftLeg = new ModelRenderer(this, 0, 16);
        this.FrontLeftLeg.func_78793_a(4.0F, 12.0F, -6.0F);
        this.FrontLeftLeg.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.VillagerHead = new ModelRenderer(this, 0, 0);
        this.VillagerHead.func_78793_a(0.0F, -15.0F, -3.0F);
        this.VillagerHead.func_78790_a(-4.0F, -10.0F, -4.0F, 8, 10, 8, 0.0F);
        this.CowBody = new ModelRenderer(this, 18, 4);
        this.CowBody.func_78793_a(0.0F, 5.0F, 2.0F);
        this.CowBody.func_78790_a(-6.0F, -10.0F, -7.0F, 12, 18, 10, 0.0F);
        this.setRotateAngle(CowBody, 1.5707963267948966F, 0.0F, 0.0F);
        this.FrontRightLeg = new ModelRenderer(this, 0, 16);
        this.FrontRightLeg.func_78793_a(-4.0F, 12.0F, -6.0F);
        this.FrontRightLeg.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.VillagerMiddleArm = new ModelRenderer(this, 40, 38);
        this.VillagerMiddleArm.func_78793_a(0.0F, -12.0F, -4.0F);
        this.VillagerMiddleArm.func_78790_a(-4.0F, 2.0F, -2.0F, 8, 4, 4, 0.0F);
        this.setRotateAngle(VillagerMiddleArm, -0.7499679795819634F, 0.0F, 0.0F);
        this.RearLeftLeg = new ModelRenderer(this, 0, 16);
        this.RearLeftLeg.func_78793_a(4.0F, 12.0F, 7.0F);
        this.RearLeftLeg.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.VillagerCoat = new ModelRenderer(this, 0, 38);
        this.VillagerCoat.func_78793_a(0.0F, -15.0F, -3.0F);
        this.VillagerCoat.func_78790_a(-4.0F, 0.0F, -3.0F, 8, 18, 6, 0.5F);
        this.Udders = new ModelRenderer(this, 52, 0);
        this.Udders.func_78793_a(0.0F, 5.0F, 2.0F);
        this.Udders.func_78790_a(-2.0F, 2.0F, -8.0F, 4, 6, 1, 0.0F);
        this.setRotateAngle(Udders, 1.5707963267948966F, 0.0F, 0.0F);
        this.VillagerNose = new ModelRenderer(this, 24, 0);
        this.VillagerNose.func_78793_a(0.0F, -2.0F, 0.0F);
        this.VillagerNose.func_78790_a(-1.0F, -1.0F, -6.0F, 2, 4, 2, 0.0F);
        this.VillagerRightArm = new ModelRenderer(this, 44, 22);
        this.VillagerRightArm.func_78793_a(0.0F, -12.0F, -4.0F);
        this.VillagerRightArm.func_78790_a(-8.0F, -2.0F, -2.0F, 4, 8, 4, 0.0F);
        this.setRotateAngle(VillagerRightArm, -0.7499679795819634F, 0.0F, 0.0F);
        this.VillagerLeftArm = new ModelRenderer(this, 44, 22);
        this.VillagerLeftArm.func_78793_a(0.0F, -12.0F, -4.0F);
        this.VillagerLeftArm.func_78790_a(4.0F, -2.0F, -2.0F, 4, 8, 4, 0.0F);
        this.setRotateAngle(VillagerLeftArm, -0.7499679795819634F, 0.0F, 0.0F);
        this.VillagerChest = new ModelRenderer(this, 16, 20);
        this.VillagerChest.func_78793_a(0.0F, -12.0F, -3.0F);
        this.VillagerChest.func_78790_a(-4.0F, 0.0F, -3.0F, 8, 12, 6, 0.0F);
        this.RearRightLeg = new ModelRenderer(this, 0, 16);
        this.RearRightLeg.func_78793_a(-4.0F, 12.0F, 7.0F);
        this.RearRightLeg.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.VillagerHead.func_78792_a(this.VillagerNose);
    }

    @Override
    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) 
    { 
        this.FrontLeftLeg.func_78785_a(f5);
        this.VillagerHead.func_78785_a(f5);
        this.CowBody.func_78785_a(f5);
        this.FrontRightLeg.func_78785_a(f5);
        this.VillagerMiddleArm.func_78785_a(f5);
        this.RearLeftLeg.func_78785_a(f5);
        this.VillagerCoat.func_78785_a(f5);
        this.Udders.func_78785_a(f5);
        this.VillagerRightArm.func_78785_a(f5);
        this.VillagerLeftArm.func_78785_a(f5);
        this.VillagerChest.func_78785_a(f5);
        this.RearRightLeg.func_78785_a(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) 
    {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }
    
    @Override
    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) 
    {
    	this.FrontLeftLeg.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    	this.RearLeftLeg.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    	this.FrontRightLeg.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
    	this.RearRightLeg.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
    	
    	this.VillagerHead.field_78796_g = netHeadYaw * 0.017453292F;
    	this.VillagerHead.field_78795_f = headPitch * 0.017453292F;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
