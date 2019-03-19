package com.maikerumine.ESMC.world.biomes;


import com.maikerumine.ESMC.entity.EntityStonemonster;
import com.maikerumine.ESMC.init.ModBlocks;
import com.maikerumine.ESMC.world.generation.BiomeDecoratorDesert;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;


import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.monster.EntityHusk;
import net.minecraft.entity.monster.EntityZombieVillager;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntitySquid;

import net.minecraft.world.biome.Biome.BiomeProperties;

public class BiomeDesert extends Biome 
{
	public BiomeDesert() 
	{
		super(new BiomeProperties("ESM Desert").func_185398_c(0.125F).func_185400_d(0.05F).func_185410_a(2.0F).func_185395_b(0.0F).func_185396_a());
		
		field_76752_A = Blocks.field_150354_m.func_176223_P();
		field_76753_B = Blocks.field_150322_A.func_176223_P();
			
		
		
        setSpawnables();
//        addFlowers();
        
        
//		this.spawnableCaveCreatureList.clear();
//		this.spawnableCreatureList.clear();
//		this.spawnableMonsterList.clear();
//		this.spawnableWaterCreatureList.clear();
		
//		this.spawnableCreatureList.add(new SpawnListEntry(EntityStonemonster.class, 5, 1, 5));
	}
	
	
    /**
     * Allocate a new BiomeDecorator for this BiomeGenBase.
     *
     * @return the biome decorator
     */
    @Override
    public BiomeDecorator func_76729_a()
    {
        BiomeDecorator biomeDecorator = new BiomeDecoratorDesert();
        
        biomeDecorator.field_76833_y = 0;
        biomeDecorator.field_76832_z = 0;
        biomeDecorator.field_189870_A = 0.1F;
        biomeDecorator.field_76802_A = 0;
        biomeDecorator.field_76803_B = 0;
        biomeDecorator.field_76804_C = 7;
        biomeDecorator.field_76798_D = 0;
        biomeDecorator.field_76799_E = 0;
        biomeDecorator.field_76800_F = 1;
        biomeDecorator.field_76801_G = 5;
        biomeDecorator.field_76805_H = 3;
        biomeDecorator.field_76806_I = 1;
        biomeDecorator.field_76807_J = 0;
        biomeDecorator.field_76808_K = false;

        return getModdedBiomeDecorator(biomeDecorator);
    }	
	
	
    private void setSpawnables()
    {
        field_76762_K.clear();
        field_76761_J.clear();
        field_76755_L.clear();
        field_82914_M.clear();
//        spawnableCreatureList.add(new Biome.SpawnListEntry(EntitySheep.class, 12, 4, 4));
//        spawnableCreatureList.add(new Biome.SpawnListEntry(EntityPig.class, 10, 4, 4));
//        spawnableCreatureList.add(new Biome.SpawnListEntry(EntityChicken.class, 10, 4, 4));
//        spawnableCreatureList.add(new Biome.SpawnListEntry(EntityCow.class, 8, 4, 4));
        field_76761_J.add(new Biome.SpawnListEntry(EntitySpider.class, 100, 4, 4));
        field_76761_J.add(new Biome.SpawnListEntry(EntityZombie.class, 95, 4, 4));
        field_76761_J.add(new Biome.SpawnListEntry(EntityHusk.class, 95, 4, 4));
        field_76761_J.add(new Biome.SpawnListEntry(EntityZombieVillager.class, 5, 1, 1));
//        spawnableMonsterList.add(new Biome.SpawnListEntry(EntitySkeleton.class, 100, 4, 4));
//        spawnableMonsterList.add(new Biome.SpawnListEntry(EntityCreeper.class, 100, 4, 4));
//        spawnableMonsterList.add(new Biome.SpawnListEntry(EntitySlime.class, 100, 4, 4));
        field_76761_J.add(new Biome.SpawnListEntry(EntityEnderman.class, 10, 1, 4));
        field_76761_J.add(new Biome.SpawnListEntry(EntityWitch.class, 5, 1, 1));
//        spawnableWaterCreatureList.add(new Biome.SpawnListEntry(EntitySquid.class, 10, 4, 4));
        field_82914_M.add(new Biome.SpawnListEntry(EntityBat.class, 10, 8, 8));
    }	
	
	
}
