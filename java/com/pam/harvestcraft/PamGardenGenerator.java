/*     */ package com.pam.harvestcraft;
/*     */ 
/*     */ import cpw.mods.fml.common.IWorldGenerator;
/*     */ import java.util.Random;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.WorldProvider;
/*     */ import net.minecraft.world.biome.BiomeGenBase;
/*     */ import net.minecraft.world.biome.WorldChunkManager;
/*     */ import net.minecraft.world.chunk.IChunkProvider;
/*     */ import net.minecraftforge.common.BiomeDictionary;
/*     */ import net.minecraftforge.common.BiomeDictionary.Type;
/*     */ 
/*     */ 
/*     */ public class PamGardenGenerator
/*     */   implements IWorldGenerator
/*     */ {
/*     */   public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
/*     */   {
/*  19 */     switch (world.provider.dimensionId)
/*     */     {
/*     */     case 0: 
/*  22 */       generateSurface(world, random, chunkX * 16, chunkZ * 16);
/*     */     case 6: 
/*  24 */       if (BlockRegistry.enableAroma1997sdimensionalworldgardenGen)
/*     */       {
/*  26 */         generateSurface(world, random, chunkX * 16, chunkZ * 16);
/*     */       }
/*     */     case 7: 
/*  29 */       if (BlockRegistry.enabletwilightforestgardenGen)
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
/*     */     
/*  41 */     if (BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.DEAD)) {
/*  42 */       return;
/*     */     }
/*     */     
/*  45 */     if (BlockRegistry.enableberrygardenGeneration)
/*     */     {
/*  47 */       if ((BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.FOREST)) || (BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.HILLS)) || (BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.COLD)) || (BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.WET)))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  52 */         for (int i = 0; i < BlockRegistry.gardenRarity; i++)
/*     */         {
/*  54 */           int flowerType = rand.nextInt(1);
/*  55 */           int randPosX = chunkX + rand.nextInt(16) + 8;
/*  56 */           int randPosY = rand.nextInt(128);
/*  57 */           int randPosZ = chunkZ + rand.nextInt(16) + 8;
/*  58 */           new WorldGenPamGarden(BlockRegistry.pamberryGarden, flowerType).generate(world, rand, randPosX, randPosY, randPosZ);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*  63 */     if (BlockRegistry.enabledesertgardenGeneration)
/*     */     {
/*  65 */       if (BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.SANDY))
/*     */       {
/*  67 */         for (int i = 0; i < BlockRegistry.gardenRarity; i++)
/*     */         {
/*  69 */           int flowerType = rand.nextInt(1);
/*  70 */           int randPosX = chunkX + rand.nextInt(16) + 8;
/*  71 */           int randPosY = rand.nextInt(128);
/*  72 */           int randPosZ = chunkZ + rand.nextInt(16) + 8;
/*  73 */           new WorldGenPamGarden(BlockRegistry.pamdesertGarden, flowerType).generate(world, rand, randPosX, randPosY, randPosZ);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*  78 */     if (BlockRegistry.enablegrassgardenGeneration)
/*     */     {
/*  80 */       if ((BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.PLAINS)) && (!BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.COLD)))
/*     */       {
/*  82 */         for (int i = 0; i < BlockRegistry.gardenRarity; i++)
/*     */         {
/*  84 */           int flowerType = rand.nextInt(1);
/*  85 */           int randPosX = chunkX + rand.nextInt(16) + 8;
/*  86 */           int randPosY = rand.nextInt(128);
/*  87 */           int randPosZ = chunkZ + rand.nextInt(16) + 8;
/*  88 */           new WorldGenPamGarden(BlockRegistry.pamgrassGarden, flowerType).generate(world, rand, randPosX, randPosY, randPosZ);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*  93 */     if (BlockRegistry.enablegourdgardenGeneration)
/*     */     {
/*  95 */       if ((BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.PLAINS)) || (BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.FOREST)))
/*     */       {
/*     */ 
/*  98 */         for (int i = 0; i < BlockRegistry.gardenRarity; i++)
/*     */         {
/* 100 */           int flowerType = rand.nextInt(1);
/* 101 */           int randPosX = chunkX + rand.nextInt(16) + 8;
/* 102 */           int randPosY = rand.nextInt(128);
/* 103 */           int randPosZ = chunkZ + rand.nextInt(16) + 8;
/* 104 */           new WorldGenPamGarden(BlockRegistry.pamgourdGarden, flowerType).generate(world, rand, randPosX, randPosY, randPosZ);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 109 */     if (BlockRegistry.enablegroundgardenGeneration)
/*     */     {
/* 111 */       if ((BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.MOUNTAIN)) || (BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.HILLS)) || (BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.MESA)) || (BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.SAVANNA)))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 116 */         for (int i = 0; i < BlockRegistry.gardenRarity; i++)
/*     */         {
/* 118 */           int flowerType = rand.nextInt(1);
/* 119 */           int randPosX = chunkX + rand.nextInt(16) + 8;
/* 120 */           int randPosY = rand.nextInt(128);
/* 121 */           int randPosZ = chunkZ + rand.nextInt(16) + 8;
/* 122 */           new WorldGenPamGarden(BlockRegistry.pamgroundGarden, flowerType).generate(world, rand, randPosX, randPosY, randPosZ);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 127 */     if (BlockRegistry.enableherbgardenGeneration)
/*     */     {
/* 129 */       if (((BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.FOREST)) && (!BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.COLD))) || (BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.WET)))
/*     */       {
/*     */ 
/* 132 */         for (int i = 0; i < BlockRegistry.gardenRarity; i++)
/*     */         {
/* 134 */           int flowerType = rand.nextInt(1);
/* 135 */           int randPosX = chunkX + rand.nextInt(16) + 8;
/* 136 */           int randPosY = rand.nextInt(128);
/* 137 */           int randPosZ = chunkZ + rand.nextInt(16) + 8;
/* 138 */           new WorldGenPamGarden(BlockRegistry.pamherbGarden, flowerType).generate(world, rand, randPosX, randPosY, randPosZ);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 143 */     if (BlockRegistry.enableleafygardenGeneration)
/*     */     {
/* 145 */       if (((BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.FOREST)) && (!BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.COLD))) || (BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.WET)))
/*     */       {
/*     */ 
/* 148 */         for (int i = 0; i < BlockRegistry.gardenRarity; i++)
/*     */         {
/* 150 */           int flowerType = rand.nextInt(1);
/* 151 */           int randPosX = chunkX + rand.nextInt(16) + 8;
/* 152 */           int randPosY = rand.nextInt(128);
/* 153 */           int randPosZ = chunkZ + rand.nextInt(16) + 8;
/* 154 */           new WorldGenPamGarden(BlockRegistry.pamleafyGarden, flowerType).generate(world, rand, randPosX, randPosY, randPosZ);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 159 */     if (BlockRegistry.enablemushroomgardenGeneration)
/*     */     {
/* 161 */       if (((BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.FOREST)) && (!BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.COLD)) && (!BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.MOUNTAIN))) || (BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.WET)))
/*     */       {
/*     */ 
/*     */ 
/* 165 */         for (int i = 0; i < BlockRegistry.gardenRarity; i++)
/*     */         {
/* 167 */           int flowerType = rand.nextInt(1);
/* 168 */           int randPosX = chunkX + rand.nextInt(16) + 8;
/* 169 */           int randPosY = rand.nextInt(128);
/* 170 */           int randPosZ = chunkZ + rand.nextInt(16) + 8;
/* 171 */           new WorldGenPamMushroomGarden(BlockRegistry.pammushroomGarden, flowerType).generate(world, rand, randPosX, randPosY, randPosZ);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 176 */     if (BlockRegistry.enablestalkgardenGeneration)
/*     */     {
/* 178 */       if (((BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.PLAINS)) && (!BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.COLD))) || ((BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.FOREST)) && (!BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.COLD))) || (BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.WET)))
/*     */       {
/*     */ 
/*     */ 
/* 182 */         for (int i = 0; i < BlockRegistry.gardenRarity; i++)
/*     */         {
/* 184 */           int flowerType = rand.nextInt(1);
/* 185 */           int randPosX = chunkX + rand.nextInt(16) + 8;
/* 186 */           int randPosY = rand.nextInt(128);
/* 187 */           int randPosZ = chunkZ + rand.nextInt(16) + 8;
/* 188 */           new WorldGenPamGarden(BlockRegistry.pamstalkGarden, flowerType).generate(world, rand, randPosX, randPosY, randPosZ);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 193 */     if (BlockRegistry.enabletextilegardenGeneration)
/*     */     {
/* 195 */       if ((BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.COLD)) || (BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.HILLS)) || (BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.WET)))
/*     */       {
/*     */ 
/*     */ 
/* 199 */         for (int i = 0; i < BlockRegistry.gardenRarity; i++)
/*     */         {
/* 201 */           int flowerType = rand.nextInt(1);
/* 202 */           int randPosX = chunkX + rand.nextInt(16) + 8;
/* 203 */           int randPosY = rand.nextInt(128);
/* 204 */           int randPosZ = chunkZ + rand.nextInt(16) + 8;
/* 205 */           new WorldGenPamGarden(BlockRegistry.pamtextileGarden, flowerType).generate(world, rand, randPosX, randPosY, randPosZ);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 210 */     if (BlockRegistry.enabletropicalgardenGeneration)
/*     */     {
/* 212 */       if ((BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.WET)) || (BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.HOT)))
/*     */       {
/* 214 */         for (int i = 0; i < BlockRegistry.gardenRarity; i++)
/*     */         {
/* 216 */           int flowerType = rand.nextInt(1);
/* 217 */           int randPosX = chunkX + rand.nextInt(16) + 8;
/* 218 */           int randPosY = rand.nextInt(128);
/* 219 */           int randPosZ = chunkZ + rand.nextInt(16) + 8;
/* 220 */           new WorldGenPamGarden(BlockRegistry.pamtropicalGarden, flowerType).generate(world, rand, randPosX, randPosY, randPosZ);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 225 */     if (BlockRegistry.enablewatergardenGeneration)
/*     */     {
/* 227 */       if (((BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.OCEAN)) && (!BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.COLD))) || ((BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.RIVER)) && (!BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.COLD))))
/*     */       {
/*     */ 
/* 230 */         for (int i = 0; i < BlockRegistry.gardenRarity; i++)
/*     */         {
/* 232 */           int flowerType = rand.nextInt(1);
/* 233 */           int randPosX = chunkX + rand.nextInt(16) + 8;
/* 234 */           int randPosY = rand.nextInt(128);
/* 235 */           int randPosZ = chunkZ + rand.nextInt(16) + 8;
/* 236 */           new WorldGenPamGarden(BlockRegistry.pamwaterGarden, flowerType).generate(world, rand, randPosX, randPosY, randPosZ);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Modding\Desktop\Pam's HarvestCraft 1.7.10k.deobf.jar!\com\pam\harvestcraft\PamGardenGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */