/*    */ package com.pam.harvestcraft;
/*    */ 
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class WorldGenPamMushroomGarden extends net.minecraft.world.gen.feature.WorldGenerator
/*    */ {
/*    */   private Block plantBlockId;
/*    */   private int flowerType;
/*    */   
/*    */   public WorldGenPamMushroomGarden(Block p_i45452_1_, int i)
/*    */   {
/* 14 */     this.plantBlockId = p_i45452_1_;
/* 15 */     this.flowerType = i;
/*    */   }
/*    */   
/*    */   public boolean generate(World world, Random random, int i, int j, int k)
/*    */   {
/* 20 */     for (int l = 0; l < 8; l++)
/*    */     {
/* 22 */       int i1 = i + random.nextInt(8) - random.nextInt(8);
/* 23 */       int j1 = j + random.nextInt(4) - random.nextInt(4);
/* 24 */       int k1 = k + random.nextInt(8) - random.nextInt(8);
/*    */       
/* 26 */       if ((world.isAirBlock(i1, j1, k1)) && (this.plantBlockId.canPlaceBlockAt(world, i1, j1, k1)))
/*    */       {
/* 28 */         world.setBlock(i1, j1, k1, net.minecraft.init.Blocks.log, 4, 2);
/* 29 */         world.setBlock(i1 + 1, j1, k1, net.minecraft.init.Blocks.log, 4, 2);
/* 30 */         world.setBlock(i1 - 1, j1, k1, net.minecraft.init.Blocks.log, 4, 2);
/* 31 */         world.setBlock(i1, j1 + 1, k1, this.plantBlockId, this.flowerType, 2);
/*    */       }
/*    */     }
/*    */     
/* 35 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Modding\Desktop\Pam's HarvestCraft 1.7.10k.deobf.jar!\com\pam\harvestcraft\WorldGenPamMushroomGarden.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */