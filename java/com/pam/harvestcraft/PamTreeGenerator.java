/*     */ package com.pam.harvestcraft;
/*     */ 
/*     */ import cpw.mods.fml.common.IWorldGenerator;
/*     */ import java.util.Random;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.WorldProvider;
/*     */ import net.minecraft.world.biome.BiomeGenBase;
/*     */ import net.minecraft.world.biome.WorldChunkManager;
/*     */ import net.minecraft.world.chunk.IChunkProvider;
/*     */ import net.minecraftforge.common.BiomeDictionary;
/*     */ import net.minecraftforge.common.BiomeDictionary.Type;
/*     */ 
/*     */ 
/*     */ public class PamTreeGenerator
/*     */   implements IWorldGenerator
/*     */ {
/*     */   public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
/*     */   {
/*  20 */     switch (world.provider.dimensionId) {
/*     */     case 0: 
/*  22 */       generateSurface(world, random, chunkX * 16, chunkZ * 16);
/*     */     case 6: 
/*  24 */       if (BlockRegistry.enableAroma1997sdimensionalworldfruittreeGen)
/*     */       {
/*  26 */         generateSurface(world, random, chunkX * 16, chunkZ * 16);
/*     */       }
/*     */     case 7: 
/*  29 */       if (BlockRegistry.enabletwilightforestfruittreeGen)
/*     */       {
/*  31 */         generateSurface(world, random, chunkX * 16, chunkZ * 16);
/*     */       }
/*     */       break;
/*     */     }
/*     */   }
/*     */   
/*     */   public void generateSurface(World world, Random rand, int chunkX, int chunkZ)
/*     */   {
/*  39 */     BiomeGenBase biome = world.getWorldChunkManager().getBiomeGenAt(chunkX, chunkZ);
/*  40 */     if (BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.DEAD))
/*     */     {
/*  42 */       return;
/*     */     }
/*  44 */     if ((BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.FOREST)) && (!BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.COLD)) && (!BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.SPOOKY)) && (!BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.MOUNTAIN)))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  50 */       for (int k = 0; k < BlockRegistry.temperatefruittreeRarity; k++)
/*     */       {
/*  52 */         int l = rand.nextInt(256);
/*  53 */         int i1 = chunkX + rand.nextInt(16);
/*  54 */         int j1 = chunkZ + rand.nextInt(16);
/*  55 */         if ((world.getBlock(i1, l - 1, j1) == Blocks.grass) || (world.getBlock(i1, l - 1, j1) == Blocks.dirt))
/*     */         {
/*  57 */           switch (rand.nextInt(7))
/*     */           {
/*     */           case 0: 
/*  60 */             if (BlockRegistry.appletreeGeneration)
/*     */             {
/*  62 */               new WorldGenPamFruitTree(true, 5, 0, 0, BlockRegistry.pamApple).generate(world, rand, i1, l, j1);
/*     */             }
/*     */           case 1: 
/*  65 */             if (BlockRegistry.avocadotreeGeneration)
/*     */             {
/*  67 */               new WorldGenPamFruitTree(true, 5, 0, 0, BlockRegistry.pamAvocado).generate(world, rand, i1, l, j1);
/*     */             }
/*     */           case 2: 
/*  70 */             if (BlockRegistry.cherrytreeGeneration)
/*     */             {
/*  72 */               new WorldGenPamFruitTree(true, 5, 0, 0, BlockRegistry.pamCherry).generate(world, rand, i1, l, j1);
/*     */             }
/*     */           case 3: 
/*  75 */             if (BlockRegistry.chestnuttreeGeneration)
/*     */             {
/*  77 */               new WorldGenPamFruitTree(true, 5, 0, 0, BlockRegistry.pamChestnut).generate(world, rand, i1, l, j1);
/*     */             }
/*     */           case 4: 
/*  80 */             if (BlockRegistry.nutmegtreeGeneration)
/*     */             {
/*  82 */               new WorldGenPamFruitTree(true, 5, 0, 0, BlockRegistry.pamNutmeg).generate(world, rand, i1, l, j1);
/*     */             }
/*     */           case 5: 
/*  85 */             if (BlockRegistry.peartreeGeneration)
/*     */             {
/*  87 */               new WorldGenPamFruitTree(true, 5, 0, 0, BlockRegistry.pamPear).generate(world, rand, i1, l, j1);
/*     */             }
/*     */           case 6: 
/*  90 */             if (BlockRegistry.walnuttreeGeneration)
/*     */             {
/*  92 */               new WorldGenPamFruitTree(true, 5, 0, 0, BlockRegistry.pamWalnut).generate(world, rand, i1, l, j1);
/*     */             }
/*     */           case 7: 
/*  95 */             if (BlockRegistry.gooseberrytreeGeneration)
/*     */             {
/*  97 */               new WorldGenPamFruitTree(true, 5, 0, 0, BlockRegistry.pamGooseberry).generate(world, rand, i1, l, j1);
/*     */             }
/*     */             
/*     */ 
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 108 */     if (BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.OCEAN))
/*     */     {
/* 110 */       if (BlockRegistry.coconuttreeGeneration)
/*     */       {
/* 112 */         for (int k = 0; k < BlockRegistry.tropicalfruittreeRarity; k++)
/*     */         {
/* 114 */           int l = rand.nextInt(256);
/* 115 */           int i1 = chunkX + rand.nextInt(16);
/* 116 */           int j1 = chunkZ + rand.nextInt(16);
/* 117 */           if ((world.getBlock(i1, l - 1, j1) == Blocks.grass) || (world.getBlock(i1, l - 1, j1) == Blocks.dirt))
/*     */           {
/* 119 */             new WorldGenPamFruitTree(true, 5, 3, 3, BlockRegistry.pamCoconut).generate(world, rand, i1, l, j1);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 126 */     if (((BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.WET)) && (!BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.PLAINS)) && (!BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.DRY))) || ((BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.HOT)) && (!BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.PLAINS)) && (!BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.DRY))))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 132 */       for (int k = 0; k < BlockRegistry.tropicalfruittreeRarity; k++)
/*     */       {
/* 134 */         int l = rand.nextInt(256);
/* 135 */         int i1 = chunkX + rand.nextInt(16);
/* 136 */         int j1 = chunkZ + rand.nextInt(16);
/* 137 */         if ((world.getBlock(i1, l - 1, j1) == Blocks.grass) || (world.getBlock(i1, l - 1, j1) == Blocks.dirt))
/*     */         {
/* 139 */           switch (rand.nextInt(24))
/*     */           {
/*     */           case 0: 
/* 142 */             if (BlockRegistry.bananatreeGeneration)
/*     */             {
/* 144 */               new WorldGenPamFruitTree(true, 5, 3, 3, BlockRegistry.pamBanana).generate(world, rand, i1, l, j1);
/*     */             }
/*     */           case 1: 
/* 147 */             if (BlockRegistry.cinnamontreeGeneration)
/*     */             {
/* 149 */               new WorldGenPamFruitLogTree(true, 5, 3, 3, BlockRegistry.pamCinnamon).generate(world, rand, i1, l, j1);
/*     */             }
/*     */           case 2: 
/* 152 */             if (BlockRegistry.coconuttreeGeneration)
/*     */             {
/* 154 */               new WorldGenPamFruitTree(true, 5, 3, 3, BlockRegistry.pamCoconut).generate(world, rand, i1, l, j1);
/*     */             }
/*     */           case 3: 
/* 157 */             if (BlockRegistry.datetreeGeneration)
/*     */             {
/* 159 */               new WorldGenPamFruitTree(true, 5, 3, 3, BlockRegistry.pamDate).generate(world, rand, i1, l, j1);
/*     */             }
/*     */           case 4: 
/* 162 */             if (BlockRegistry.dragonfruittreeGeneration)
/*     */             {
/* 164 */               new WorldGenPamFruitTree(true, 5, 3, 3, BlockRegistry.pamDragonfruit).generate(world, rand, i1, l, j1);
/*     */             }
/*     */           case 5: 
/* 167 */             if (BlockRegistry.papayatreeGeneration)
/*     */             {
/* 169 */               new WorldGenPamFruitTree(true, 5, 3, 3, BlockRegistry.pamPapaya).generate(world, rand, i1, l, j1);
/*     */             }
/*     */           case 6: 
/* 172 */             if (BlockRegistry.almondtreeGeneration)
/*     */             {
/* 174 */               new WorldGenPamFruitTree(true, 5, 3, 3, BlockRegistry.pamAlmond).generate(world, rand, i1, l, j1);
/*     */             }
/*     */           case 7: 
/* 177 */             if (BlockRegistry.apricottreeGeneration)
/*     */             {
/* 179 */               new WorldGenPamFruitTree(true, 5, 3, 3, BlockRegistry.pamApricot).generate(world, rand, i1, l, j1);
/*     */             }
/*     */           case 8: 
/* 182 */             if (BlockRegistry.cashewtreeGeneration)
/*     */             {
/* 184 */               new WorldGenPamFruitTree(true, 5, 3, 3, BlockRegistry.pamCashew).generate(world, rand, i1, l, j1);
/*     */             }
/*     */           case 9: 
/* 187 */             if (BlockRegistry.duriantreeGeneration)
/*     */             {
/* 189 */               new WorldGenPamFruitTree(true, 5, 3, 3, BlockRegistry.pamDurian).generate(world, rand, i1, l, j1);
/*     */             }
/*     */           case 10: 
/* 192 */             if (BlockRegistry.figtreeGeneration)
/*     */             {
/* 194 */               new WorldGenPamFruitTree(true, 5, 3, 3, BlockRegistry.pamFig).generate(world, rand, i1, l, j1);
/*     */             }
/*     */           case 11: 
/* 197 */             if (BlockRegistry.grapefruittreeGeneration)
/*     */             {
/* 199 */               new WorldGenPamFruitTree(true, 5, 3, 3, BlockRegistry.pamGrapefruit).generate(world, rand, i1, l, j1);
/*     */             }
/*     */           case 12: 
/* 202 */             if (BlockRegistry.lemontreeGeneration)
/*     */             {
/* 204 */               new WorldGenPamFruitTree(true, 5, 3, 3, BlockRegistry.pamLemon).generate(world, rand, i1, l, j1);
/*     */             }
/*     */           case 13: 
/* 207 */             if (BlockRegistry.limetreeGeneration)
/*     */             {
/* 209 */               new WorldGenPamFruitTree(true, 5, 3, 3, BlockRegistry.pamLime).generate(world, rand, i1, l, j1);
/*     */             }
/*     */           case 14: 
/* 212 */             if (BlockRegistry.mangotreeGeneration)
/*     */             {
/* 214 */               new WorldGenPamFruitTree(true, 5, 3, 3, BlockRegistry.pamMango).generate(world, rand, i1, l, j1);
/*     */             }
/*     */           case 15: 
/* 217 */             if (BlockRegistry.orangetreeGeneration)
/*     */             {
/* 219 */               new WorldGenPamFruitTree(true, 5, 3, 3, BlockRegistry.pamOrange).generate(world, rand, i1, l, j1);
/*     */             }
/*     */           case 16: 
/* 222 */             if (BlockRegistry.paperbarktreeGeneration)
/*     */             {
/* 224 */               new WorldGenPamFruitLogTree(true, 5, 3, 3, BlockRegistry.pamPaperbark).generate(world, rand, i1, l, j1);
/*     */             }
/*     */           case 17: 
/* 227 */             if (BlockRegistry.peachtreeGeneration)
/*     */             {
/* 229 */               new WorldGenPamFruitTree(true, 5, 3, 3, BlockRegistry.pamPeach).generate(world, rand, i1, l, j1);
/*     */             }
/*     */           case 18: 
/* 232 */             if (BlockRegistry.pecantreeGeneration)
/*     */             {
/* 234 */               new WorldGenPamFruitTree(true, 5, 3, 3, BlockRegistry.pamPecan).generate(world, rand, i1, l, j1);
/*     */             }
/*     */           case 19: 
/* 237 */             if (BlockRegistry.peppercorntreeGeneration)
/*     */             {
/* 239 */               new WorldGenPamFruitTree(true, 5, 3, 3, BlockRegistry.pamPeppercorn).generate(world, rand, i1, l, j1);
/*     */             }
/*     */           case 20: 
/* 242 */             if (BlockRegistry.persimmontreeGeneration)
/*     */             {
/* 244 */               new WorldGenPamFruitTree(true, 5, 3, 3, BlockRegistry.pamPersimmon).generate(world, rand, i1, l, j1);
/*     */             }
/*     */           case 21: 
/* 247 */             if (BlockRegistry.pistachiotreeGeneration)
/*     */             {
/* 249 */               new WorldGenPamFruitTree(true, 5, 3, 3, BlockRegistry.pamPistachio).generate(world, rand, i1, l, j1);
/*     */             }
/*     */           case 22: 
/* 252 */             if (BlockRegistry.pomegranatetreeGeneration)
/*     */             {
/* 254 */               new WorldGenPamFruitTree(true, 5, 3, 3, BlockRegistry.pamPomegranate).generate(world, rand, i1, l, j1);
/*     */             }
/*     */           case 23: 
/* 257 */             if (BlockRegistry.starfruittreeGeneration)
/*     */             {
/* 259 */               new WorldGenPamFruitTree(true, 5, 3, 3, BlockRegistry.pamStarfruit).generate(world, rand, i1, l, j1);
/*     */             }
/*     */           case 24: 
/* 262 */             if (BlockRegistry.vanillabeantreeGeneration)
/*     */             {
/* 264 */               new WorldGenPamFruitTree(true, 5, 3, 3, BlockRegistry.pamVanillabean).generate(world, rand, i1, l, j1);
/*     */             }
/*     */             
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       
/* 273 */       if (BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.CONIFEROUS))
/*     */       {
/* 275 */         if (BlockRegistry.mapletreeGeneration)
/*     */         {
/* 277 */           for (int k = 0; k < BlockRegistry.coniferousfruittreeRarity; k++)
/*     */           {
/* 279 */             int l = rand.nextInt(256);
/* 280 */             int i1 = chunkX + rand.nextInt(16);
/* 281 */             int j1 = chunkZ + rand.nextInt(16);
/* 282 */             if ((world.getBlock(i1, l - 1, j1) == Blocks.grass) || (world.getBlock(i1, l - 1, j1) == Blocks.dirt))
/*     */             {
/* 284 */               new WorldGenPamFruitLogTree(true, 5, 1, 1, BlockRegistry.pamMaple).generate(world, rand, i1, l, j1);
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Modding\Desktop\Pam's HarvestCraft 1.7.10k.deobf.jar!\com\pam\harvestcraft\PamTreeGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */