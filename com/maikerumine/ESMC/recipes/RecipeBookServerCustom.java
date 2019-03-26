/**
    Copyright (C) 2017 by jabelar

    This file is part of jabelar's Minecraft Forge modding examples; as such,
    you can redistribute it and/or modify it under the terms of the GNU
    General Public License as published by the Free Software Foundation,
    either version 3 of the License, or (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
    GNU General Public License for more details.

    For a copy of the GNU General Public License see <http://www.gnu.org/licenses/>.
*/
package com.maikerumine.ESMC.recipes;

import java.util.Collections;
import java.util.List;

import com.google.common.collect.Lists;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.network.play.server.SPacketRecipeBook;
import net.minecraft.stats.RecipeBookServer;

public class RecipeBookServerCustom extends RecipeBookServer
{
    
    /* (non-Javadoc)
     * @see net.minecraft.stats.RecipeBookServer#add(java.util.List, net.minecraft.entity.player.EntityPlayerMP)
     */
    @SuppressWarnings("deprecation")
    @Override
    public void func_193835_a(List<IRecipe> recipesIn, EntityPlayerMP player)
    {
        List<IRecipe> list = Lists.<IRecipe>newArrayList();

        for (IRecipe irecipe : recipesIn)
        {
            if (!field_194077_a.get(func_194075_d(irecipe)) && !irecipe.func_192399_d())
            {
                if (!player.field_70170_p.func_72935_r()) // <--- Put whatever player condition here
                {
                    // DEBUG
                    System.out.println("Unlocking recipe");
                    
                    func_194073_a(irecipe);
                    func_193825_e(irecipe);
                    list.add(irecipe);
                    CriteriaTriggers.field_192126_f.func_192225_a(player, irecipe);
                    net.minecraftforge.common.ForgeHooks.sendRecipeBook(player.field_71135_a, SPacketRecipeBook.State.ADD, recipesIn, Collections.emptyList(), field_192818_b, field_192819_c);
               }
                else
                {
                    // DEBUG
                    System.out.println("Can't unlock recipe as player condition not met");
                }
            }
            else
            {
                net.minecraftforge.common.ForgeHooks.sendRecipeBook(player.field_71135_a, SPacketRecipeBook.State.ADD, recipesIn, Collections.emptyList(), field_192818_b, field_192819_c);
            }
        }
    }
}
