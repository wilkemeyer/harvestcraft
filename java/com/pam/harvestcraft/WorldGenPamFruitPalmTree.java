/*     */ package com.pam.harvestcraft;
/*     */ 
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.gen.feature.WorldGenAbstractTree;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WorldGenPamFruitPalmTree
/*     */   extends WorldGenAbstractTree
/*     */ {
/*     */   private final int minTreeHeight;
/*     */   private final int metaWood;
/*     */   private final int metaLeaves;
/*     */   private final Block fruitType;
/*     */   
/*     */   public WorldGenPamFruitPalmTree(boolean par1, int par2, int par3, int par4, Block par5)
/*     */   {
/*  22 */     super(par1);
/*  23 */     this.minTreeHeight = par2;
/*  24 */     this.metaWood = par3;
/*  25 */     this.metaLeaves = par4;
/*  26 */     this.fruitType = par5;
/*     */   }
/*     */   
/*     */   public boolean generate(World par1World, Random par2Random, int x, int y, int z)
/*     */   {
/*  31 */     int treeHeight = par2Random.nextInt(2) + this.minTreeHeight;
/*  32 */     boolean flag = true;
/*     */     
/*     */ 
/*  35 */     if ((y >= 1) && (y + treeHeight + 1 <= 256))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  42 */       for (int i1 = y; i1 <= y + 1 + treeHeight; i1++)
/*     */       {
/*  44 */         byte b0 = 1;
/*     */         
/*  46 */         if (i1 == y)
/*     */         {
/*  48 */           b0 = 0;
/*     */         }
/*     */         
/*  51 */         if (i1 >= y + 1 + treeHeight - 2)
/*     */         {
/*  53 */           b0 = 2;
/*     */         }
/*     */         
/*  56 */         for (int l1 = x - b0; (l1 <= x + b0) && (flag); l1++)
/*     */         {
/*  58 */           for (int j1 = x - b0; (j1 <= x + b0) && (flag); j1++)
/*     */           {
/*  60 */             if ((i1 >= 0) && (i1 < 256))
/*     */             {
/*  62 */               Block k1 = par1World.getBlock(l1, i1, j1);
/*     */               
/*     */ 
/*  65 */               if ((!par1World.isAirBlock(l1, i1, j1)) && (!k1.isLeaves(par1World, l1, i1, j1)) && (k1 != Blocks.grass) && (k1 != Blocks.dirt) && (!k1.isWood(par1World, l1, i1, j1)))
/*     */               {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  71 */                 flag = false;
/*     */               }
/*     */             }
/*     */             else
/*     */             {
/*  76 */               flag = false;
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */       
/*  82 */       if (!flag)
/*     */       {
/*  84 */         return false;
/*     */       }
/*     */       
/*  87 */       Block j11 = par1World.getBlock(x, y - 1, z);
/*     */       
/*  89 */       if (((j11 != Blocks.grass) && (j11 != Blocks.dirt)) || (y >= 256 - treeHeight - 1))
/*     */       {
/*  91 */         return false;
/*     */       }
/*     */       
/*     */ 
/*  95 */       par1World.setBlock(x, y - 1, z, Blocks.dirt);
/*     */       
/*  97 */       setBlockAndNotifyAdequately(par1World, x, y + treeHeight + 2, z, Blocks.leaves, this.metaLeaves);
/*  98 */       setBlockAndNotifyAdequately(par1World, x, y + treeHeight + 1, z, Blocks.log, this.metaWood);
/*  99 */       setBlockAndNotifyAdequately(par1World, x, y + treeHeight, z, Blocks.log, this.metaWood);
/*     */       
/* 101 */       setBlockAndNotifyAdequately(par1World, x, y + treeHeight + 1, z + 1, Blocks.leaves, this.metaLeaves);
/* 102 */       setBlockAndNotifyAdequately(par1World, x, y + treeHeight, z + 1, this.fruitType, 0);
/* 103 */       setBlockAndNotifyAdequately(par1World, x, y + treeHeight + 1, z + 2, Blocks.leaves, this.metaLeaves);
/* 104 */       setBlockAndNotifyAdequately(par1World, x, y + treeHeight + 1, z + 3, Blocks.leaves, this.metaLeaves);
/* 105 */       setBlockAndNotifyAdequately(par1World, x, y + treeHeight, z + 4, Blocks.leaves, this.metaLeaves);
/*     */       
/* 107 */       setBlockAndNotifyAdequately(par1World, x + 1, y + treeHeight + 1, z, Blocks.leaves, this.metaLeaves);
/* 108 */       setBlockAndNotifyAdequately(par1World, x + 1, y + treeHeight, z, this.fruitType, 0);
/* 109 */       setBlockAndNotifyAdequately(par1World, x + 2, y + treeHeight + 1, z, Blocks.leaves, this.metaLeaves);
/* 110 */       setBlockAndNotifyAdequately(par1World, x + 3, y + treeHeight + 1, z, Blocks.leaves, this.metaLeaves);
/* 111 */       setBlockAndNotifyAdequately(par1World, x + 4, y + treeHeight, z, Blocks.leaves, this.metaLeaves);
/*     */       
/* 113 */       setBlockAndNotifyAdequately(par1World, x, y + treeHeight + 1, z - 1, Blocks.leaves, this.metaLeaves);
/* 114 */       setBlockAndNotifyAdequately(par1World, x, y + treeHeight, z - 1, this.fruitType, 0);
/* 115 */       setBlockAndNotifyAdequately(par1World, x, y + treeHeight + 1, z - 2, Blocks.leaves, this.metaLeaves);
/* 116 */       setBlockAndNotifyAdequately(par1World, x, y + treeHeight + 1, z - 3, Blocks.leaves, this.metaLeaves);
/* 117 */       setBlockAndNotifyAdequately(par1World, x, y + treeHeight, z - 4, Blocks.leaves, this.metaLeaves);
/*     */       
/* 119 */       setBlockAndNotifyAdequately(par1World, x - 1, y + treeHeight + 1, z, Blocks.leaves, this.metaLeaves);
/* 120 */       setBlockAndNotifyAdequately(par1World, x - 1, y + treeHeight, z, this.fruitType, 0);
/* 121 */       setBlockAndNotifyAdequately(par1World, x - 2, y + treeHeight + 1, z, Blocks.leaves, this.metaLeaves);
/* 122 */       setBlockAndNotifyAdequately(par1World, x - 3, y + treeHeight + 1, z, Blocks.leaves, this.metaLeaves);
/* 123 */       setBlockAndNotifyAdequately(par1World, x - 4, y + treeHeight, z, Blocks.leaves, this.metaLeaves);
/*     */       
/*     */ 
/* 126 */       setBlockAndNotifyAdequately(par1World, x - 1, y + treeHeight + 1, z - 1, Blocks.leaves, this.metaLeaves);
/* 127 */       setBlockAndNotifyAdequately(par1World, x - 1, y + treeHeight + 1, z + 1, Blocks.leaves, this.metaLeaves);
/* 128 */       setBlockAndNotifyAdequately(par1World, x + 1, y + treeHeight + 1, z - 1, Blocks.leaves, this.metaLeaves);
/* 129 */       setBlockAndNotifyAdequately(par1World, x + 1, y + treeHeight + 1, z + 1, Blocks.leaves, this.metaLeaves);
/*     */       
/* 131 */       setBlockAndNotifyAdequately(par1World, x + 2, y + treeHeight + 1, z + 2, Blocks.leaves, this.metaLeaves);
/* 132 */       setBlockAndNotifyAdequately(par1World, x + 2, y + treeHeight + 1, z - 2, Blocks.leaves, this.metaLeaves);
/* 133 */       setBlockAndNotifyAdequately(par1World, x - 2, y + treeHeight + 1, z + 2, Blocks.leaves, this.metaLeaves);
/* 134 */       setBlockAndNotifyAdequately(par1World, x - 2, y + treeHeight + 1, z - 2, Blocks.leaves, this.metaLeaves);
/*     */       
/* 136 */       setBlockAndNotifyAdequately(par1World, x + 3, y + treeHeight, z + 3, Blocks.leaves, this.metaLeaves);
/* 137 */       setBlockAndNotifyAdequately(par1World, x + 3, y + treeHeight, z - 3, Blocks.leaves, this.metaLeaves);
/* 138 */       setBlockAndNotifyAdequately(par1World, x - 3, y + treeHeight, z + 3, Blocks.leaves, this.metaLeaves);
/* 139 */       setBlockAndNotifyAdequately(par1World, x - 3, y + treeHeight, z - 3, Blocks.leaves, this.metaLeaves);
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 145 */       for (int l1 = 0; l1 < treeHeight; l1++)
/*     */       {
/* 147 */         Block block = par1World.getBlock(x, y + l1, z);
/*     */         
/* 149 */         if ((block.isAir(par1World, x, y + l1, z)) || (block.isLeaves(par1World, x, y + l1, z)) || (block == this.fruitType))
/*     */         {
/* 151 */           setBlockAndNotifyAdequately(par1World, x, y + l1, z, Blocks.log, this.metaWood);
/*     */         }
/*     */       }
/*     */       
/* 155 */       return true;
/*     */     }
/* 157 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Modding\Desktop\Pam's HarvestCraft 1.7.10k.deobf.jar!\com\pam\harvestcraft\WorldGenPamFruitPalmTree.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */