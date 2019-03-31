package com.maikerumine.ESMC.rendering.models.blocks;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class ModelEsmChest extends ModelBase 
{
	public ModelRenderer chestKnob;
    public ModelRenderer chestLid;
    public ModelRenderer chestBelow;

    public ModelEsmChest() 
    {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        
        this.chestBelow = new ModelRenderer(this, 0, 19);
        this.chestBelow.func_78793_a(1.0F, 6.0F, 1.0F);
        this.chestBelow.func_78790_a(0.0F, 0.0F, 0.0F, 14, 10, 14, 0.0F);
        this.chestKnob = new ModelRenderer(this, 0, 0);
        this.chestKnob.func_78793_a(8.0F, 7.0F, 15.0F);
        this.chestKnob.func_78790_a(-1.0F, -2.0F, -15.0F, 2, 4, 1, 0.0F);
        this.chestLid = new ModelRenderer(this, 0, 0);
        this.chestLid.func_78793_a(1.0F, 7.0F, 15.0F);
        this.chestLid.func_78790_a(0.0F, -5.0F, -14.0F, 14, 5, 14, 0.0F);
    }
    public void renderAll()
    {
        this.chestKnob.field_78795_f = this.chestLid.field_78795_f;
        this.chestLid.func_78785_a(0.0625F);
        this.chestKnob.func_78785_a(0.0625F);
        this.chestBelow.func_78785_a(0.0625F);
    }
}
