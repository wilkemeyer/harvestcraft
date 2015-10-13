/*     */ package com.pam.harvestcraft;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockFlower;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.gen.feature.WorldGenerator;
/*     */ import net.minecraftforge.event.terraingen.TerrainGen;
/*     */ 
/*     */ 
/*     */ public class BlockPamSapling
/*     */   extends BlockFlower
/*     */ {
/*     */   protected BlockPamSapling()
/*     */   {
/*  25 */     super(0);
/*  26 */     float f = 0.4F;
/*  27 */     setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
/*  28 */     setTickRandomly(true);
/*  29 */     setStepSound(Block.soundTypeGrass);
/*  30 */     this.setCreativeTab(harvestcraft.tabHarvestCraft2);
/*     */   }
/*     */   
/*     */   public int damageDropped(int i)
/*     */   {
/*  35 */     return i;
/*     */   }
/*     */   
/*     */   public void markOrGrowMarked(World world, int x, int y, int z, Random par1Random) {
/*  39 */     int l = world.getBlockMetadata(x, y, z);
/*     */     
/*  41 */     if ((l & 0x8) == 0) {
/*  42 */       world.setBlockMetadataWithNotify(x, y, z, l | 0x8, 4);
/*     */     } else {
/*  44 */       growTree(world, x, y, z, par1Random);
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean isSameSapling(World par1World, int par2, int par3, int par4, int par5)
/*     */   {
/*  50 */     return (par1World.getBlock(par2, par3, par4) == this) && ((par1World.getBlockMetadata(par2, par3, par4) & 0x3) == par5);
/*     */   }
/*     */   
/*     */   public void growTree(World world, int x, int y, int z, Random par1Random)
/*     */   {
/*  55 */     if (this == BlockRegistry.pamappleSapling)
/*     */     {
/*  57 */       if (!TerrainGen.saplingGrowTree(world, par1Random, x, y, z)) return;
/*  58 */       int l = world.getBlockMetadata(x, y, z) & 0x7;
/*  59 */       Object object = null;
/*  60 */       int i1 = 0;
/*  61 */       int j1 = 0;
/*     */       
/*  63 */       object = new WorldGenPamFruitTree(true, 5, 0, 0, BlockRegistry.pamApple);
/*     */       
/*  65 */       world.setBlock(x, y, z, Blocks.air, 0, 4);
/*     */       
/*  67 */       if (!((WorldGenerator)object).generate(world, par1Random, x + i1, y, z + j1)) {
/*  68 */         world.setBlock(x, y, z, this, l, 4);
/*     */       }
/*     */     }
/*  71 */     if (this == BlockRegistry.pamavocadoSapling)
/*     */     {
/*  73 */       if (!TerrainGen.saplingGrowTree(world, par1Random, x, y, z)) return;
/*  74 */       int l = world.getBlockMetadata(x, y, z) & 0x7;
/*  75 */       Object object = null;
/*  76 */       int i1 = 0;
/*  77 */       int j1 = 0;
/*     */       
/*  79 */       object = new WorldGenPamFruitTree(true, 5, 0, 0, BlockRegistry.pamAvocado);
/*     */       
/*  81 */       world.setBlock(x, y, z, Blocks.air, 0, 4);
/*     */       
/*  83 */       if (!((WorldGenerator)object).generate(world, par1Random, x + i1, y, z + j1)) {
/*  84 */         world.setBlock(x, y, z, this, l, 4);
/*     */       }
/*     */     }
/*  87 */     if (this == BlockRegistry.pamcherrySapling)
/*     */     {
/*  89 */       if (!TerrainGen.saplingGrowTree(world, par1Random, x, y, z)) return;
/*  90 */       int l = world.getBlockMetadata(x, y, z) & 0x7;
/*  91 */       Object object = null;
/*  92 */       int i1 = 0;
/*  93 */       int j1 = 0;
/*     */       
/*  95 */       object = new WorldGenPamFruitTree(true, 5, 0, 0, BlockRegistry.pamCherry);
/*     */       
/*  97 */       world.setBlock(x, y, z, Blocks.air, 0, 4);
/*     */       
/*  99 */       if (!((WorldGenerator)object).generate(world, par1Random, x + i1, y, z + j1)) {
/* 100 */         world.setBlock(x, y, z, this, l, 4);
/*     */       }
/*     */     }
/* 103 */     if (this == BlockRegistry.pamchestnutSapling)
/*     */     {
/* 105 */       if (!TerrainGen.saplingGrowTree(world, par1Random, x, y, z)) return;
/* 106 */       int l = world.getBlockMetadata(x, y, z) & 0x7;
/* 107 */       Object object = null;
/* 108 */       int i1 = 0;
/* 109 */       int j1 = 0;
/*     */       
/* 111 */       object = new WorldGenPamFruitTree(true, 5, 0, 0, BlockRegistry.pamChestnut);
/*     */       
/* 113 */       world.setBlock(x, y, z, Blocks.air, 0, 4);
/*     */       
/* 115 */       if (!((WorldGenerator)object).generate(world, par1Random, x + i1, y, z + j1)) {
/* 116 */         world.setBlock(x, y, z, this, l, 4);
/*     */       }
/*     */     }
/* 119 */     if (this == BlockRegistry.pamnutmegSapling)
/*     */     {
/* 121 */       if (!TerrainGen.saplingGrowTree(world, par1Random, x, y, z)) return;
/* 122 */       int l = world.getBlockMetadata(x, y, z) & 0x7;
/* 123 */       Object object = null;
/* 124 */       int i1 = 0;
/* 125 */       int j1 = 0;
/*     */       
/* 127 */       object = new WorldGenPamFruitTree(true, 5, 0, 0, BlockRegistry.pamNutmeg);
/*     */       
/* 129 */       world.setBlock(x, y, z, Blocks.air, 0, 4);
/*     */       
/* 131 */       if (!((WorldGenerator)object).generate(world, par1Random, x + i1, y, z + j1)) {
/* 132 */         world.setBlock(x, y, z, this, l, 4);
/*     */       }
/*     */     }
/* 135 */     if (this == BlockRegistry.pampearSapling)
/*     */     {
/* 137 */       if (!TerrainGen.saplingGrowTree(world, par1Random, x, y, z)) return;
/* 138 */       int l = world.getBlockMetadata(x, y, z) & 0x7;
/* 139 */       Object object = null;
/* 140 */       int i1 = 0;
/* 141 */       int j1 = 0;
/*     */       
/* 143 */       object = new WorldGenPamFruitTree(true, 5, 0, 0, BlockRegistry.pamPear);
/*     */       
/* 145 */       world.setBlock(x, y, z, Blocks.air, 0, 4);
/*     */       
/* 147 */       if (!((WorldGenerator)object).generate(world, par1Random, x + i1, y, z + j1)) {
/* 148 */         world.setBlock(x, y, z, this, l, 4);
/*     */       }
/*     */     }
/* 151 */     if (this == BlockRegistry.pamplumSapling)
/*     */     {
/* 153 */       if (!TerrainGen.saplingGrowTree(world, par1Random, x, y, z)) return;
/* 154 */       int l = world.getBlockMetadata(x, y, z) & 0x7;
/* 155 */       Object object = null;
/* 156 */       int i1 = 0;
/* 157 */       int j1 = 0;
/*     */       
/* 159 */       object = new WorldGenPamFruitTree(true, 5, 0, 0, BlockRegistry.pamPlum);
/*     */       
/* 161 */       world.setBlock(x, y, z, Blocks.air, 0, 4);
/*     */       
/* 163 */       if (!((WorldGenerator)object).generate(world, par1Random, x + i1, y, z + j1)) {
/* 164 */         world.setBlock(x, y, z, this, l, 4);
/*     */       }
/*     */     }
/* 167 */     if (this == BlockRegistry.pamwalnutSapling)
/*     */     {
/* 169 */       if (!TerrainGen.saplingGrowTree(world, par1Random, x, y, z)) return;
/* 170 */       int l = world.getBlockMetadata(x, y, z) & 0x7;
/* 171 */       Object object = null;
/* 172 */       int i1 = 0;
/* 173 */       int j1 = 0;
/*     */       
/* 175 */       object = new WorldGenPamFruitTree(true, 5, 0, 0, BlockRegistry.pamWalnut);
/*     */       
/* 177 */       world.setBlock(x, y, z, Blocks.air, 0, 4);
/*     */       
/* 179 */       if (!((WorldGenerator)object).generate(world, par1Random, x + i1, y, z + j1)) {
/* 180 */         world.setBlock(x, y, z, this, l, 4);
/*     */       }
/*     */     }
/* 183 */     if (this == BlockRegistry.pamgooseberrySapling)
/*     */     {
/* 185 */       if (!TerrainGen.saplingGrowTree(world, par1Random, x, y, z)) return;
/* 186 */       int l = world.getBlockMetadata(x, y, z) & 0x7;
/* 187 */       Object object = null;
/* 188 */       int i1 = 0;
/* 189 */       int j1 = 0;
/*     */       
/* 191 */       object = new WorldGenPamFruitTree(true, 5, 0, 0, BlockRegistry.pamGooseberry);
/*     */       
/* 193 */       world.setBlock(x, y, z, Blocks.air, 0, 4);
/*     */       
/* 195 */       if (!((WorldGenerator)object).generate(world, par1Random, x + i1, y, z + j1)) {
/* 196 */         world.setBlock(x, y, z, this, l, 4);
/*     */       }
/*     */     }
/*     */     
/* 200 */     if (this == BlockRegistry.pambananaSapling)
/*     */     {
/*     */ 
/* 203 */       if (!TerrainGen.saplingGrowTree(world, par1Random, x, y, z)) return;
/* 204 */       int l = world.getBlockMetadata(x, y, z) & 0x7;
/* 205 */       Object object = null;
/* 206 */       int i1 = 0;
/* 207 */       int j1 = 0;
/*     */       
/* 209 */       object = new WorldGenPamFruitTree(true, 5, 3, 3, BlockRegistry.pamBanana);
/*     */       
/* 211 */       world.setBlock(x, y, z, Blocks.air, 0, 4);
/*     */       
/* 213 */       if (!((WorldGenerator)object).generate(world, par1Random, x + i1, y, z + j1)) {
/* 214 */         world.setBlock(x, y, z, this, l, 4);
/*     */       }
/*     */     }
/* 217 */     if (this == BlockRegistry.pamcoconutSapling)
/*     */     {
/* 219 */       if (!TerrainGen.saplingGrowTree(world, par1Random, x, y, z)) return;
/* 220 */       int l = world.getBlockMetadata(x, y, z) & 0x7;
/* 221 */       Object object = null;
/* 222 */       int i1 = 0;
/* 223 */       int j1 = 0;
/*     */       
/* 225 */       object = new WorldGenPamFruitTree(true, 5, 3, 3, BlockRegistry.pamCoconut);
/*     */       
/* 227 */       world.setBlock(x, y, z, Blocks.air, 0, 4);
/*     */       
/* 229 */       if (!((WorldGenerator)object).generate(world, par1Random, x + i1, y, z + j1)) {
/* 230 */         world.setBlock(x, y, z, this, l, 4);
/*     */       }
/*     */     }
/* 233 */     if (this == BlockRegistry.pamdateSapling)
/*     */     {
/* 235 */       if (!TerrainGen.saplingGrowTree(world, par1Random, x, y, z)) return;
/* 236 */       int l = world.getBlockMetadata(x, y, z) & 0x7;
/* 237 */       Object object = null;
/* 238 */       int i1 = 0;
/* 239 */       int j1 = 0;
/*     */       
/* 241 */       object = new WorldGenPamFruitTree(true, 5, 3, 3, BlockRegistry.pamDate);
/*     */       
/* 243 */       world.setBlock(x, y, z, Blocks.air, 0, 4);
/*     */       
/* 245 */       if (!((WorldGenerator)object).generate(world, par1Random, x + i1, y, z + j1)) {
/* 246 */         world.setBlock(x, y, z, this, l, 4);
/*     */       }
/*     */     }
/* 249 */     if (this == BlockRegistry.pamdragonfruitSapling)
/*     */     {
/* 251 */       if (!TerrainGen.saplingGrowTree(world, par1Random, x, y, z)) return;
/* 252 */       int l = world.getBlockMetadata(x, y, z) & 0x7;
/* 253 */       Object object = null;
/* 254 */       int i1 = 0;
/* 255 */       int j1 = 0;
/*     */       
/* 257 */       object = new WorldGenPamFruitTree(true, 5, 3, 3, BlockRegistry.pamDragonfruit);
/*     */       
/* 259 */       world.setBlock(x, y, z, Blocks.air, 0, 4);
/*     */       
/* 261 */       if (!((WorldGenerator)object).generate(world, par1Random, x + i1, y, z + j1)) {
/* 262 */         world.setBlock(x, y, z, this, l, 4);
/*     */       }
/*     */     }
/* 265 */     if (this == BlockRegistry.pampapayaSapling)
/*     */     {
/* 267 */       if (!TerrainGen.saplingGrowTree(world, par1Random, x, y, z)) return;
/* 268 */       int l = world.getBlockMetadata(x, y, z) & 0x7;
/* 269 */       Object object = null;
/* 270 */       int i1 = 0;
/* 271 */       int j1 = 0;
/*     */       
/* 273 */       object = new WorldGenPamFruitTree(true, 5, 3, 3, BlockRegistry.pamPapaya);
/*     */       
/* 275 */       world.setBlock(x, y, z, Blocks.air, 0, 4);
/*     */       
/* 277 */       if (!((WorldGenerator)object).generate(world, par1Random, x + i1, y, z + j1)) {
/* 278 */         world.setBlock(x, y, z, this, l, 4);
/*     */       }
/*     */     }
/*     */     
/* 282 */     if (this == BlockRegistry.pamalmondSapling)
/*     */     {
/* 284 */       if (!TerrainGen.saplingGrowTree(world, par1Random, x, y, z)) return;
/* 285 */       int l = world.getBlockMetadata(x, y, z) & 0x7;
/* 286 */       Object object = null;
/* 287 */       int i1 = 0;
/* 288 */       int j1 = 0;
/*     */       
/* 290 */       object = new WorldGenPamFruitTree(true, 5, 3, 3, BlockRegistry.pamAlmond);
/*     */       
/* 292 */       world.setBlock(x, y, z, Blocks.air, 0, 4);
/*     */       
/* 294 */       if (!((WorldGenerator)object).generate(world, par1Random, x + i1, y, z + j1)) {
/* 295 */         world.setBlock(x, y, z, this, l, 4);
/*     */       }
/*     */     }
/* 298 */     if (this == BlockRegistry.pamapricotSapling)
/*     */     {
/* 300 */       if (!TerrainGen.saplingGrowTree(world, par1Random, x, y, z)) return;
/* 301 */       int l = world.getBlockMetadata(x, y, z) & 0x7;
/* 302 */       Object object = null;
/* 303 */       int i1 = 0;
/* 304 */       int j1 = 0;
/*     */       
/* 306 */       object = new WorldGenPamFruitTree(true, 5, 3, 3, BlockRegistry.pamApricot);
/*     */       
/* 308 */       world.setBlock(x, y, z, Blocks.air, 0, 4);
/*     */       
/* 310 */       if (!((WorldGenerator)object).generate(world, par1Random, x + i1, y, z + j1)) {
/* 311 */         world.setBlock(x, y, z, this, l, 4);
/*     */       }
/*     */     }
/* 314 */     if (this == BlockRegistry.pamcashewSapling)
/*     */     {
/* 316 */       if (!TerrainGen.saplingGrowTree(world, par1Random, x, y, z)) return;
/* 317 */       int l = world.getBlockMetadata(x, y, z) & 0x7;
/* 318 */       Object object = null;
/* 319 */       int i1 = 0;
/* 320 */       int j1 = 0;
/*     */       
/* 322 */       object = new WorldGenPamFruitTree(true, 5, 3, 3, BlockRegistry.pamCashew);
/*     */       
/* 324 */       world.setBlock(x, y, z, Blocks.air, 0, 4);
/*     */       
/* 326 */       if (!((WorldGenerator)object).generate(world, par1Random, x + i1, y, z + j1)) {
/* 327 */         world.setBlock(x, y, z, this, l, 4);
/*     */       }
/*     */     }
/* 330 */     if (this == BlockRegistry.pamdurianSapling)
/*     */     {
/* 332 */       if (!TerrainGen.saplingGrowTree(world, par1Random, x, y, z)) return;
/* 333 */       int l = world.getBlockMetadata(x, y, z) & 0x7;
/* 334 */       Object object = null;
/* 335 */       int i1 = 0;
/* 336 */       int j1 = 0;
/*     */       
/* 338 */       object = new WorldGenPamFruitTree(true, 5, 3, 3, BlockRegistry.pamDurian);
/*     */       
/* 340 */       world.setBlock(x, y, z, Blocks.air, 0, 4);
/*     */       
/* 342 */       if (!((WorldGenerator)object).generate(world, par1Random, x + i1, y, z + j1)) {
/* 343 */         world.setBlock(x, y, z, this, l, 4);
/*     */       }
/*     */     }
/* 346 */     if (this == BlockRegistry.pamfigSapling)
/*     */     {
/* 348 */       if (!TerrainGen.saplingGrowTree(world, par1Random, x, y, z)) return;
/* 349 */       int l = world.getBlockMetadata(x, y, z) & 0x7;
/* 350 */       Object object = null;
/* 351 */       int i1 = 0;
/* 352 */       int j1 = 0;
/*     */       
/* 354 */       object = new WorldGenPamFruitTree(true, 5, 3, 3, BlockRegistry.pamFig);
/*     */       
/* 356 */       world.setBlock(x, y, z, Blocks.air, 0, 4);
/*     */       
/* 358 */       if (!((WorldGenerator)object).generate(world, par1Random, x + i1, y, z + j1)) {
/* 359 */         world.setBlock(x, y, z, this, l, 4);
/*     */       }
/*     */     }
/* 362 */     if (this == BlockRegistry.pamgrapefruitSapling)
/*     */     {
/* 364 */       if (!TerrainGen.saplingGrowTree(world, par1Random, x, y, z)) return;
/* 365 */       int l = world.getBlockMetadata(x, y, z) & 0x7;
/* 366 */       Object object = null;
/* 367 */       int i1 = 0;
/* 368 */       int j1 = 0;
/*     */       
/* 370 */       object = new WorldGenPamFruitTree(true, 5, 3, 3, BlockRegistry.pamGrapefruit);
/*     */       
/* 372 */       world.setBlock(x, y, z, Blocks.air, 0, 4);
/*     */       
/* 374 */       if (!((WorldGenerator)object).generate(world, par1Random, x + i1, y, z + j1)) {
/* 375 */         world.setBlock(x, y, z, this, l, 4);
/*     */       }
/*     */     }
/* 378 */     if (this == BlockRegistry.pamlemonSapling)
/*     */     {
/* 380 */       if (!TerrainGen.saplingGrowTree(world, par1Random, x, y, z)) return;
/* 381 */       int l = world.getBlockMetadata(x, y, z) & 0x7;
/* 382 */       Object object = null;
/* 383 */       int i1 = 0;
/* 384 */       int j1 = 0;
/*     */       
/* 386 */       object = new WorldGenPamFruitTree(true, 5, 3, 3, BlockRegistry.pamLemon);
/*     */       
/* 388 */       world.setBlock(x, y, z, Blocks.air, 0, 4);
/*     */       
/* 390 */       if (!((WorldGenerator)object).generate(world, par1Random, x + i1, y, z + j1)) {
/* 391 */         world.setBlock(x, y, z, this, l, 4);
/*     */       }
/*     */     }
/* 394 */     if (this == BlockRegistry.pamlimeSapling)
/*     */     {
/* 396 */       if (!TerrainGen.saplingGrowTree(world, par1Random, x, y, z)) return;
/* 397 */       int l = world.getBlockMetadata(x, y, z) & 0x7;
/* 398 */       Object object = null;
/* 399 */       int i1 = 0;
/* 400 */       int j1 = 0;
/*     */       
/* 402 */       object = new WorldGenPamFruitTree(true, 5, 3, 3, BlockRegistry.pamLime);
/*     */       
/* 404 */       world.setBlock(x, y, z, Blocks.air, 0, 4);
/*     */       
/* 406 */       if (!((WorldGenerator)object).generate(world, par1Random, x + i1, y, z + j1)) {
/* 407 */         world.setBlock(x, y, z, this, l, 4);
/*     */       }
/*     */     }
/* 410 */     if (this == BlockRegistry.pammangoSapling)
/*     */     {
/* 412 */       if (!TerrainGen.saplingGrowTree(world, par1Random, x, y, z)) return;
/* 413 */       int l = world.getBlockMetadata(x, y, z) & 0x7;
/* 414 */       Object object = null;
/* 415 */       int i1 = 0;
/* 416 */       int j1 = 0;
/*     */       
/* 418 */       object = new WorldGenPamFruitTree(true, 5, 3, 3, BlockRegistry.pamMango);
/*     */       
/* 420 */       world.setBlock(x, y, z, Blocks.air, 0, 4);
/*     */       
/* 422 */       if (!((WorldGenerator)object).generate(world, par1Random, x + i1, y, z + j1)) {
/* 423 */         world.setBlock(x, y, z, this, l, 4);
/*     */       }
/*     */     }
/* 426 */     if (this == BlockRegistry.pamoliveSapling)
/*     */     {
/* 428 */       if (!TerrainGen.saplingGrowTree(world, par1Random, x, y, z)) return;
/* 429 */       int l = world.getBlockMetadata(x, y, z) & 0x7;
/* 430 */       Object object = null;
/* 431 */       int i1 = 0;
/* 432 */       int j1 = 0;
/*     */       
/* 434 */       object = new WorldGenPamFruitTree(true, 5, 3, 3, BlockRegistry.pamOlive);
/*     */       
/* 436 */       world.setBlock(x, y, z, Blocks.air, 0, 4);
/*     */       
/* 438 */       if (!((WorldGenerator)object).generate(world, par1Random, x + i1, y, z + j1)) {
/* 439 */         world.setBlock(x, y, z, this, l, 4);
/*     */       }
/*     */     }
/* 442 */     if (this == BlockRegistry.pamorangeSapling)
/*     */     {
/* 444 */       if (!TerrainGen.saplingGrowTree(world, par1Random, x, y, z)) return;
/* 445 */       int l = world.getBlockMetadata(x, y, z) & 0x7;
/* 446 */       Object object = null;
/* 447 */       int i1 = 0;
/* 448 */       int j1 = 0;
/*     */       
/* 450 */       object = new WorldGenPamFruitTree(true, 5, 3, 3, BlockRegistry.pamOrange);
/*     */       
/* 452 */       world.setBlock(x, y, z, Blocks.air, 0, 4);
/*     */       
/* 454 */       if (!((WorldGenerator)object).generate(world, par1Random, x + i1, y, z + j1)) {
/* 455 */         world.setBlock(x, y, z, this, l, 4);
/*     */       }
/*     */     }
/* 458 */     if (this == BlockRegistry.pampeachSapling)
/*     */     {
/* 460 */       if (!TerrainGen.saplingGrowTree(world, par1Random, x, y, z)) return;
/* 461 */       int l = world.getBlockMetadata(x, y, z) & 0x7;
/* 462 */       Object object = null;
/* 463 */       int i1 = 0;
/* 464 */       int j1 = 0;
/*     */       
/* 466 */       object = new WorldGenPamFruitTree(true, 5, 3, 3, BlockRegistry.pamPeach);
/*     */       
/* 468 */       world.setBlock(x, y, z, Blocks.air, 0, 4);
/*     */       
/* 470 */       if (!((WorldGenerator)object).generate(world, par1Random, x + i1, y, z + j1)) {
/* 471 */         world.setBlock(x, y, z, this, l, 4);
/*     */       }
/*     */     }
/* 474 */     if (this == BlockRegistry.pampecanSapling)
/*     */     {
/* 476 */       if (!TerrainGen.saplingGrowTree(world, par1Random, x, y, z)) return;
/* 477 */       int l = world.getBlockMetadata(x, y, z) & 0x7;
/* 478 */       Object object = null;
/* 479 */       int i1 = 0;
/* 480 */       int j1 = 0;
/*     */       
/* 482 */       object = new WorldGenPamFruitTree(true, 5, 3, 3, BlockRegistry.pamPecan);
/*     */       
/* 484 */       world.setBlock(x, y, z, Blocks.air, 0, 4);
/*     */       
/* 486 */       if (!((WorldGenerator)object).generate(world, par1Random, x + i1, y, z + j1)) {
/* 487 */         world.setBlock(x, y, z, this, l, 4);
/*     */       }
/*     */     }
/* 490 */     if (this == BlockRegistry.pampeppercornSapling)
/*     */     {
/* 492 */       if (!TerrainGen.saplingGrowTree(world, par1Random, x, y, z)) return;
/* 493 */       int l = world.getBlockMetadata(x, y, z) & 0x7;
/* 494 */       Object object = null;
/* 495 */       int i1 = 0;
/* 496 */       int j1 = 0;
/*     */       
/* 498 */       object = new WorldGenPamFruitTree(true, 5, 3, 3, BlockRegistry.pamPeppercorn);
/*     */       
/* 500 */       world.setBlock(x, y, z, Blocks.air, 0, 4);
/*     */       
/* 502 */       if (!((WorldGenerator)object).generate(world, par1Random, x + i1, y, z + j1)) {
/* 503 */         world.setBlock(x, y, z, this, l, 4);
/*     */       }
/*     */     }
/* 506 */     if (this == BlockRegistry.pampersimmonSapling)
/*     */     {
/* 508 */       if (!TerrainGen.saplingGrowTree(world, par1Random, x, y, z)) return;
/* 509 */       int l = world.getBlockMetadata(x, y, z) & 0x7;
/* 510 */       Object object = null;
/* 511 */       int i1 = 0;
/* 512 */       int j1 = 0;
/*     */       
/* 514 */       object = new WorldGenPamFruitTree(true, 5, 3, 3, BlockRegistry.pamPersimmon);
/*     */       
/* 516 */       world.setBlock(x, y, z, Blocks.air, 0, 4);
/*     */       
/* 518 */       if (!((WorldGenerator)object).generate(world, par1Random, x + i1, y, z + j1)) {
/* 519 */         world.setBlock(x, y, z, this, l, 4);
/*     */       }
/*     */     }
/* 522 */     if (this == BlockRegistry.pampistachioSapling)
/*     */     {
/* 524 */       if (!TerrainGen.saplingGrowTree(world, par1Random, x, y, z)) return;
/* 525 */       int l = world.getBlockMetadata(x, y, z) & 0x7;
/* 526 */       Object object = null;
/* 527 */       int i1 = 0;
/* 528 */       int j1 = 0;
/*     */       
/* 530 */       object = new WorldGenPamFruitTree(true, 5, 3, 3, BlockRegistry.pamPistachio);
/*     */       
/* 532 */       world.setBlock(x, y, z, Blocks.air, 0, 4);
/*     */       
/* 534 */       if (!((WorldGenerator)object).generate(world, par1Random, x + i1, y, z + j1)) {
/* 535 */         world.setBlock(x, y, z, this, l, 4);
/*     */       }
/*     */     }
/* 538 */     if (this == BlockRegistry.pampomegranateSapling)
/*     */     {
/* 540 */       if (!TerrainGen.saplingGrowTree(world, par1Random, x, y, z)) return;
/* 541 */       int l = world.getBlockMetadata(x, y, z) & 0x7;
/* 542 */       Object object = null;
/* 543 */       int i1 = 0;
/* 544 */       int j1 = 0;
/*     */       
/* 546 */       object = new WorldGenPamFruitTree(true, 5, 3, 3, BlockRegistry.pamPomegranate);
/*     */       
/* 548 */       world.setBlock(x, y, z, Blocks.air, 0, 4);
/*     */       
/* 550 */       if (!((WorldGenerator)object).generate(world, par1Random, x + i1, y, z + j1)) {
/* 551 */         world.setBlock(x, y, z, this, l, 4);
/*     */       }
/*     */     }
/* 554 */     if (this == BlockRegistry.pamstarfruitSapling)
/*     */     {
/* 556 */       if (!TerrainGen.saplingGrowTree(world, par1Random, x, y, z)) return;
/* 557 */       int l = world.getBlockMetadata(x, y, z) & 0x7;
/* 558 */       Object object = null;
/* 559 */       int i1 = 0;
/* 560 */       int j1 = 0;
/*     */       
/* 562 */       object = new WorldGenPamFruitTree(true, 5, 3, 3, BlockRegistry.pamStarfruit);
/*     */       
/* 564 */       world.setBlock(x, y, z, Blocks.air, 0, 4);
/*     */       
/* 566 */       if (!((WorldGenerator)object).generate(world, par1Random, x + i1, y, z + j1)) {
/* 567 */         world.setBlock(x, y, z, this, l, 4);
/*     */       }
/*     */     }
/* 570 */     if (this == BlockRegistry.pamvanillabeanSapling)
/*     */     {
/* 572 */       if (!TerrainGen.saplingGrowTree(world, par1Random, x, y, z)) return;
/* 573 */       int l = world.getBlockMetadata(x, y, z) & 0x7;
/* 574 */       Object object = null;
/* 575 */       int i1 = 0;
/* 576 */       int j1 = 0;
/*     */       
/* 578 */       object = new WorldGenPamFruitTree(true, 5, 3, 3, BlockRegistry.pamVanillabean);
/*     */       
/* 580 */       world.setBlock(x, y, z, Blocks.air, 0, 4);
/*     */       
/* 582 */       if (!((WorldGenerator)object).generate(world, par1Random, x + i1, y, z + j1)) {
/* 583 */         world.setBlock(x, y, z, this, l, 4);
/*     */       }
/*     */     }
/*     */     
/* 587 */     if (this == BlockRegistry.pammapleSapling)
/*     */     {
/* 589 */       if (!TerrainGen.saplingGrowTree(world, par1Random, x, y, z)) return;
/* 590 */       int l = world.getBlockMetadata(x, y, z) & 0x7;
/* 591 */       Object object = null;
/* 592 */       int i1 = 0;
/* 593 */       int j1 = 0;
/*     */       
/* 595 */       object = new WorldGenPamFruitLogTree(true, 5, 1, 1, BlockRegistry.pamMaple);
/*     */       
/* 597 */       world.setBlock(x, y, z, Blocks.air, 0, 4);
/*     */       
/* 599 */       if (!((WorldGenerator)object).generate(world, par1Random, x + i1, y, z + j1)) {
/* 600 */         world.setBlock(x, y, z, this, l, 4);
/*     */       }
/*     */     }
/* 603 */     if (this == BlockRegistry.pampaperbarkSapling)
/*     */     {
/* 605 */       if (!TerrainGen.saplingGrowTree(world, par1Random, x, y, z)) return;
/* 606 */       int l = world.getBlockMetadata(x, y, z) & 0x7;
/* 607 */       Object object = null;
/* 608 */       int i1 = 0;
/* 609 */       int j1 = 0;
/*     */       
/* 611 */       object = new WorldGenPamFruitLogTree(true, 5, 3, 3, BlockRegistry.pamPaperbark);
/*     */       
/* 613 */       world.setBlock(x, y, z, Blocks.air, 0, 4);
/*     */       
/* 615 */       if (!((WorldGenerator)object).generate(world, par1Random, x + i1, y, z + j1)) {
/* 616 */         world.setBlock(x, y, z, this, l, 4);
/*     */       }
/*     */     }
/* 619 */     if (this == BlockRegistry.pamcinnamonSapling)
/*     */     {
/* 621 */       if (!TerrainGen.saplingGrowTree(world, par1Random, x, y, z)) return;
/* 622 */       int l = world.getBlockMetadata(x, y, z) & 0x7;
/* 623 */       Object object = null;
/* 624 */       int i1 = 0;
/* 625 */       int j1 = 0;
/*     */       
/* 627 */       object = new WorldGenPamFruitLogTree(true, 5, 3, 3, BlockRegistry.pamCinnamon);
/*     */       
/* 629 */       world.setBlock(x, y, z, Blocks.air, 0, 4);
/*     */       
/* 631 */       if (!((WorldGenerator)object).generate(world, par1Random, x + i1, y, z + j1)) {
/* 632 */         world.setBlock(x, y, z, this, l, 4);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void updateTick(World world, int x, int y, int z, Random par1Random)
/*     */   {
/* 639 */     if (!world.isRemote) {
/* 640 */       super.updateTick(world, x, y, z, par1Random);
/*     */       
/* 642 */       if ((world.getBlockLightValue(x, y + 1, z) >= 9) && (par1Random.nextInt(7) == 0)) {
/* 643 */         markOrGrowMarked(world, x, y, z, par1Random);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void registerBlockIcons(IIconRegister par1IconRegister)
/*     */   {
/* 651 */     if (this == BlockRegistry.pamalmondSapling)
/*     */     {
/* 653 */       this.blockIcon = par1IconRegister.registerIcon("harvestcraft:almondSapling");
/*     */     }
/* 655 */     if (this == BlockRegistry.pamappleSapling)
/*     */     {
/* 657 */       this.blockIcon = par1IconRegister.registerIcon("harvestcraft:appleSapling");
/*     */     }
/* 659 */     if (this == BlockRegistry.pamapricotSapling)
/*     */     {
/* 661 */       this.blockIcon = par1IconRegister.registerIcon("harvestcraft:apricotSapling");
/*     */     }
/* 663 */     if (this == BlockRegistry.pamavocadoSapling)
/*     */     {
/* 665 */       this.blockIcon = par1IconRegister.registerIcon("harvestcraft:avocadoSapling");
/*     */     }
/* 667 */     if (this == BlockRegistry.pambananaSapling)
/*     */     {
/* 669 */       this.blockIcon = par1IconRegister.registerIcon("harvestcraft:bananaSapling");
/*     */     }
/* 671 */     if (this == BlockRegistry.pamcashewSapling)
/*     */     {
/* 673 */       this.blockIcon = par1IconRegister.registerIcon("harvestcraft:cashewSapling");
/*     */     }
/* 675 */     if (this == BlockRegistry.pamcherrySapling)
/*     */     {
/* 677 */       this.blockIcon = par1IconRegister.registerIcon("harvestcraft:cherrySapling");
/*     */     }
/* 679 */     if (this == BlockRegistry.pamchestnutSapling)
/*     */     {
/* 681 */       this.blockIcon = par1IconRegister.registerIcon("harvestcraft:chestnutSapling");
/*     */     }
/* 683 */     if (this == BlockRegistry.pamcinnamonSapling)
/*     */     {
/* 685 */       this.blockIcon = par1IconRegister.registerIcon("harvestcraft:cinnamonSapling");
/*     */     }
/* 687 */     if (this == BlockRegistry.pamcoconutSapling)
/*     */     {
/* 689 */       this.blockIcon = par1IconRegister.registerIcon("harvestcraft:coconutSapling");
/*     */     }
/* 691 */     if (this == BlockRegistry.pamdateSapling)
/*     */     {
/* 693 */       this.blockIcon = par1IconRegister.registerIcon("harvestcraft:dateSapling");
/*     */     }
/* 695 */     if (this == BlockRegistry.pamdragonfruitSapling)
/*     */     {
/* 697 */       this.blockIcon = par1IconRegister.registerIcon("harvestcraft:dragonfruitSapling");
/*     */     }
/* 699 */     if (this == BlockRegistry.pamdurianSapling)
/*     */     {
/* 701 */       this.blockIcon = par1IconRegister.registerIcon("harvestcraft:durianSapling");
/*     */     }
/* 703 */     if (this == BlockRegistry.pamfigSapling)
/*     */     {
/* 705 */       this.blockIcon = par1IconRegister.registerIcon("harvestcraft:figSapling");
/*     */     }
/* 707 */     if (this == BlockRegistry.pamgrapefruitSapling)
/*     */     {
/* 709 */       this.blockIcon = par1IconRegister.registerIcon("harvestcraft:grapefruitSapling");
/*     */     }
/* 711 */     if (this == BlockRegistry.pamlemonSapling)
/*     */     {
/* 713 */       this.blockIcon = par1IconRegister.registerIcon("harvestcraft:lemonSapling");
/*     */     }
/* 715 */     if (this == BlockRegistry.pamlimeSapling)
/*     */     {
/* 717 */       this.blockIcon = par1IconRegister.registerIcon("harvestcraft:limeSapling");
/*     */     }
/* 719 */     if (this == BlockRegistry.pammapleSapling)
/*     */     {
/* 721 */       this.blockIcon = par1IconRegister.registerIcon("harvestcraft:mapleSapling");
/*     */     }
/* 723 */     if (this == BlockRegistry.pammangoSapling)
/*     */     {
/* 725 */       this.blockIcon = par1IconRegister.registerIcon("harvestcraft:mangoSapling");
/*     */     }
/* 727 */     if (this == BlockRegistry.pamnutmegSapling)
/*     */     {
/* 729 */       this.blockIcon = par1IconRegister.registerIcon("harvestcraft:nutmegSapling");
/*     */     }
/* 731 */     if (this == BlockRegistry.pamoliveSapling)
/*     */     {
/* 733 */       this.blockIcon = par1IconRegister.registerIcon("harvestcraft:oliveSapling");
/*     */     }
/* 735 */     if (this == BlockRegistry.pamorangeSapling)
/*     */     {
/* 737 */       this.blockIcon = par1IconRegister.registerIcon("harvestcraft:orangeSapling");
/*     */     }
/* 739 */     if (this == BlockRegistry.pampapayaSapling)
/*     */     {
/* 741 */       this.blockIcon = par1IconRegister.registerIcon("harvestcraft:papayaSapling");
/*     */     }
/* 743 */     if (this == BlockRegistry.pampaperbarkSapling)
/*     */     {
/* 745 */       this.blockIcon = par1IconRegister.registerIcon("harvestcraft:paperbarkSapling");
/*     */     }
/* 747 */     if (this == BlockRegistry.pampeachSapling)
/*     */     {
/* 749 */       this.blockIcon = par1IconRegister.registerIcon("harvestcraft:peachSapling");
/*     */     }
/* 751 */     if (this == BlockRegistry.pampeppercornSapling)
/*     */     {
/* 753 */       this.blockIcon = par1IconRegister.registerIcon("harvestcraft:peppercornSapling");
/*     */     }
/* 755 */     if (this == BlockRegistry.pampistachioSapling)
/*     */     {
/* 757 */       this.blockIcon = par1IconRegister.registerIcon("harvestcraft:pistachioSapling");
/*     */     }
/* 759 */     if (this == BlockRegistry.pampearSapling)
/*     */     {
/* 761 */       this.blockIcon = par1IconRegister.registerIcon("harvestcraft:pearSapling");
/*     */     }
/* 763 */     if (this == BlockRegistry.pampecanSapling)
/*     */     {
/* 765 */       this.blockIcon = par1IconRegister.registerIcon("harvestcraft:pecanSapling");
/*     */     }
/* 767 */     if (this == BlockRegistry.pampersimmonSapling)
/*     */     {
/* 769 */       this.blockIcon = par1IconRegister.registerIcon("harvestcraft:persimmonSapling");
/*     */     }
/* 771 */     if (this == BlockRegistry.pamplumSapling)
/*     */     {
/* 773 */       this.blockIcon = par1IconRegister.registerIcon("harvestcraft:plumSapling");
/*     */     }
/* 775 */     if (this == BlockRegistry.pampomegranateSapling)
/*     */     {
/* 777 */       this.blockIcon = par1IconRegister.registerIcon("harvestcraft:pomegranateSapling");
/*     */     }
/* 779 */     if (this == BlockRegistry.pamstarfruitSapling)
/*     */     {
/* 781 */       this.blockIcon = par1IconRegister.registerIcon("harvestcraft:starfruitSapling");
/*     */     }
/* 783 */     if (this == BlockRegistry.pamvanillabeanSapling)
/*     */     {
/* 785 */       this.blockIcon = par1IconRegister.registerIcon("harvestcraft:vanillabeanSapling");
/*     */     }
/* 787 */     if (this == BlockRegistry.pamwalnutSapling)
/*     */     {
/* 789 */       this.blockIcon = par1IconRegister.registerIcon("harvestcraft:walnutSapling");
/*     */     }
/* 791 */     if (this == BlockRegistry.pamgooseberrySapling)
/*     */     {
/* 793 */       this.blockIcon = par1IconRegister.registerIcon("harvestcraft:gooseberrySapling");
/*     */     }
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon getIcon(int par1, int par2) {
/* 799 */     return this.blockIcon;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List)
/*     */   {
/* 807 */     for (int i = 0; i < 1; i++)
/*     */     {
/* 809 */       par3List.add(new ItemStack(par1, 1, i));
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Modding\Desktop\Pam's HarvestCraft 1.7.10k.deobf.jar!\com\pam\harvestcraft\BlockPamSapling.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */