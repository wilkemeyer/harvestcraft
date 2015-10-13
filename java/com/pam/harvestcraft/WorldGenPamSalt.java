/*    */ package com.pam.harvestcraft;
/*    */ 
/*    */ import cpw.mods.fml.common.IWorldGenerator;
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraft.world.WorldProvider;
/*    */ import net.minecraft.world.chunk.IChunkProvider;
/*    */ import net.minecraft.world.gen.feature.WorldGenMinable;
/*    */ 
/*    */ 
/*    */ public class WorldGenPamSalt
/*    */   implements IWorldGenerator
/*    */ {
/*    */   public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
/*    */   {
/* 18 */     switch (world.provider.dimensionId) {
/* 19 */     case 0:  GenerateOverworld(random, chunkX * 16, chunkZ * 16, world);
/*    */     }
/*    */   }
/*    */   
/*    */   private void GenerateOverworld(Random random, int x, int z, World world)
/*    */   {
/* 25 */     addOreSpawn(BlockRegistry.pamSalt, world, random, x, z, 4, 6, BlockRegistry.saltRarity, 0, 128);
/*    */   }
/*    */   
/*    */   public void addOreSpawn(Block block, World world, Random random, int blockXPos, int blockZPos, int minVeinSize, int maxVeinSize, int chancesToSpawn, int minY, int maxY)
/*    */   {
/* 30 */     WorldGenMinable minable = new WorldGenMinable(block, minVeinSize + random.nextInt(maxVeinSize - minVeinSize), Blocks.stone);
/* 31 */     for (int i = 0; i < chancesToSpawn; i++)
/*    */     {
/* 33 */       int posX = blockXPos + random.nextInt(16);
/* 34 */       int posY = minY + random.nextInt(maxY - minY);
/* 35 */       int posZ = blockZPos + random.nextInt(16);
/* 36 */       minable.generate(world, random, posX, posY, posZ);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Modding\Desktop\Pam's HarvestCraft 1.7.10k.deobf.jar!\com\pam\harvestcraft\WorldGenPamSalt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */