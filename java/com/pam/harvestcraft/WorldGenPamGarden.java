/*    */ package com.pam.harvestcraft;
/*    */ 
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.Block;
/*    */ 
/*    */ public class WorldGenPamGarden extends net.minecraft.world.gen.feature.WorldGenerator
/*    */ {
/*    */   private Block plantBlockId;
/*    */   private int flowerType;
/*    */   
/*    */   public WorldGenPamGarden(Block p_i45452_1_, int i)
/*    */   {
/* 13 */     this.plantBlockId = p_i45452_1_;
/* 14 */     this.flowerType = i;
/*    */   }
/*    */   
/*    */   public boolean generate(net.minecraft.world.World world, Random random, int i, int j, int k)
/*    */   {
/* 19 */     for (int l = 0; l < 8; l++)
/*    */     {
/* 21 */       int i1 = i + random.nextInt(8) - random.nextInt(8);
/* 22 */       int j1 = j + random.nextInt(4) - random.nextInt(4);
/* 23 */       int k1 = k + random.nextInt(8) - random.nextInt(8);
/*    */       
/* 25 */       if ((world.isAirBlock(i1, j1, k1)) && (this.plantBlockId.canPlaceBlockAt(world, i1, j1, k1)))
/*    */       {
/* 27 */         world.setBlock(i1, j1, k1, this.plantBlockId, this.flowerType, 2);
/*    */       }
/*    */     }
/*    */     
/* 31 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Modding\Desktop\Pam's HarvestCraft 1.7.10k.deobf.jar!\com\pam\harvestcraft\WorldGenPamGarden.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */