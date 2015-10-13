/*    */ package com.pam.harvestcraft;
/*    */ 
/*    */ import cpw.mods.fml.common.IWorldGenerator;
/*    */ import java.util.Random;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraft.world.WorldProvider;
/*    */ import net.minecraft.world.chunk.IChunkProvider;
/*    */ 
/*    */ public class PamBeeGenerator implements IWorldGenerator
/*    */ {
/*    */   public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
/*    */   {
/* 14 */     switch (world.provider.dimensionId) {
/*    */     case -1: 
/* 16 */       generateNether(world, random, chunkX * 16, chunkZ * 16);
/*    */     case 0: 
/* 18 */       generateSurface(world, random, chunkX * 16, chunkZ * 16);
/*    */     }
/*    */     
/*    */   }
/*    */   
/*    */ 
/*    */   public void generateSurface(World world, Random rand, int i, int j)
/*    */   {
/* 26 */     for (int k = 0; k < BlockRegistry.beehiveRarity; k++)
/*    */     {
/* 28 */       int l = rand.nextInt(128);
/* 29 */       int i1 = i + rand.nextInt(16);
/* 30 */       int j1 = j + rand.nextInt(16);
/* 31 */       if ((world.getBlock(i1, l - 1, j1) == Blocks.leaves) || (world.getBlock(i1, l - 1, j1) == Blocks.log))
/*    */       {
/* 33 */         world.setBlock(i1, l - 1, j1, BlockRegistry.pamBeehive);
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public void generateNether(World world, Random rand, int i, int j) {}
/*    */ }


/* Location:              C:\Users\Modding\Desktop\Pam's HarvestCraft 1.7.10k.deobf.jar!\com\pam\harvestcraft\PamBeeGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */