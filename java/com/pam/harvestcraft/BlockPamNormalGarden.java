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
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.EnumPlantType;
/*     */ import net.minecraftforge.common.IPlantable;
/*     */ 
/*     */ 
/*     */ public class BlockPamNormalGarden
/*     */   extends BlockFlower
/*     */   implements IPlantable
/*     */ {
/*     */   public IIcon[] icons;
/*     */   
/*     */   protected BlockPamNormalGarden(int par2)
/*     */   {
/*  31 */     super(par2);
/*  32 */     float var4 = 0.2F;
/*  33 */     setBlockBounds(0.5F - var4, 0.0F, 0.5F - var4, 0.5F + var4, var4 * 3.0F, 0.5F + var4);
/*  34 */     setStepSound(Block.soundTypeGrass);
/*  35 */     setTickRandomly(true);
/*  36 */     this.setCreativeTab(harvestcraft.tabHarvestCraft2);
/*     */   }
/*     */   
/*     */   public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
/*     */   {
/*  41 */     if (BlockRegistry.gardensdropSeeds == true)
/*     */     {
/*  43 */       if (this == BlockRegistry.pamberryGarden)
/*     */       {
/*  45 */         int i = p_149650_2_.nextInt(6);
/*     */         
/*  47 */         if (i == 0)
/*     */         {
/*  49 */           return ItemRegistry.blackberryseedItem;
/*     */         }
/*  51 */         if (i == 1)
/*     */         {
/*  53 */           return ItemRegistry.blueberryseedItem;
/*     */         }
/*  55 */         if (i == 2)
/*     */         {
/*  57 */           return ItemRegistry.candleberryseedItem;
/*     */         }
/*  59 */         if (i == 3)
/*     */         {
/*  61 */           return ItemRegistry.raspberryseedItem;
/*     */         }
/*  63 */         if (i == 4)
/*     */         {
/*  65 */           return ItemRegistry.strawberryseedItem;
/*     */         }
/*  67 */         return ItemRegistry.grapeseedItem;
/*     */       }
/*  69 */       if (this == BlockRegistry.pamgrassGarden)
/*     */       {
/*  71 */         int i = p_149650_2_.nextInt(6);
/*     */         
/*  73 */         if (i == 0)
/*     */         {
/*  75 */           return ItemRegistry.asparagusseedItem;
/*     */         }
/*  77 */         if (i == 1)
/*     */         {
/*  79 */           return ItemRegistry.barleyseedItem;
/*     */         }
/*  81 */         if (i == 2)
/*     */         {
/*  83 */           return ItemRegistry.oatsseedItem;
/*     */         }
/*  85 */         if (i == 3)
/*     */         {
/*  87 */           return ItemRegistry.ryeseedItem;
/*     */         }
/*  89 */         if (i == 4)
/*     */         {
/*  91 */           return ItemRegistry.cornseedItem;
/*     */         }
/*  93 */         return ItemRegistry.bambooshootseedItem;
/*     */       }
/*  95 */       if (this == BlockRegistry.pamgourdGarden)
/*     */       {
/*  97 */         int i = p_149650_2_.nextInt(5);
/*     */         
/*  99 */         if (i == 0)
/*     */         {
/* 101 */           return ItemRegistry.cantaloupeseedItem;
/*     */         }
/* 103 */         if (i == 1)
/*     */         {
/* 105 */           return ItemRegistry.cucumberseedItem;
/*     */         }
/* 107 */         if (i == 2)
/*     */         {
/* 109 */           return ItemRegistry.wintersquashseedItem;
/*     */         }
/* 111 */         if (i == 3)
/*     */         {
/* 113 */           return ItemRegistry.zucchiniseedItem;
/*     */         }
/* 115 */         return Items.pumpkin_seeds;
/*     */       }
/* 117 */       if (this == BlockRegistry.pamgroundGarden)
/*     */       {
/* 119 */         int i = p_149650_2_.nextInt(11);
/*     */         
/* 121 */         if (i == 0)
/*     */         {
/* 123 */           return ItemRegistry.beetseedItem;
/*     */         }
/* 125 */         if (i == 1)
/*     */         {
/* 127 */           return ItemRegistry.onionseedItem;
/*     */         }
/* 129 */         if (i == 2)
/*     */         {
/* 131 */           return ItemRegistry.parsnipseedItem;
/*     */         }
/* 133 */         if (i == 3)
/*     */         {
/* 135 */           return ItemRegistry.peanutseedItem;
/*     */         }
/* 137 */         if (i == 4)
/*     */         {
/* 139 */           return ItemRegistry.radishseedItem;
/*     */         }
/* 141 */         if (i == 5)
/*     */         {
/* 143 */           return ItemRegistry.rutabagaseedItem;
/*     */         }
/* 145 */         if (i == 6)
/*     */         {
/* 147 */           return ItemRegistry.sweetpotatoseedItem;
/*     */         }
/* 149 */         if (i == 7)
/*     */         {
/* 151 */           return ItemRegistry.turnipseedItem;
/*     */         }
/* 153 */         if (i == 8)
/*     */         {
/* 155 */           return ItemRegistry.rhubarbseedItem;
/*     */         }
/*     */       }
/* 158 */       if (this == BlockRegistry.pamherbGarden)
/*     */       {
/* 160 */         int i = p_149650_2_.nextInt(8);
/*     */         
/* 162 */         if (i == 0)
/*     */         {
/* 164 */           return ItemRegistry.celeryseedItem;
/*     */         }
/* 166 */         if (i == 1)
/*     */         {
/* 168 */           return ItemRegistry.garlicseedItem;
/*     */         }
/* 170 */         if (i == 2)
/*     */         {
/* 172 */           return ItemRegistry.gingerseedItem;
/*     */         }
/* 174 */         if (i == 3)
/*     */         {
/* 176 */           return ItemRegistry.spiceleafseedItem;
/*     */         }
/* 178 */         if (i == 4)
/*     */         {
/* 180 */           return ItemRegistry.teaseedItem;
/*     */         }
/* 182 */         if (i == 5)
/*     */         {
/* 184 */           return ItemRegistry.coffeeseedItem;
/*     */         }
/* 186 */         return ItemRegistry.mustardseedItem;
/*     */       }
/* 188 */       if (this == BlockRegistry.pamleafyGarden)
/*     */       {
/* 190 */         int i = p_149650_2_.nextInt(9);
/*     */         
/* 192 */         if (i == 0)
/*     */         {
/* 194 */           return ItemRegistry.broccoliseedItem;
/*     */         }
/* 196 */         if (i == 1)
/*     */         {
/* 198 */           return ItemRegistry.cauliflowerseedItem;
/*     */         }
/* 200 */         if (i == 2)
/*     */         {
/* 202 */           return ItemRegistry.leekseedItem;
/*     */         }
/* 204 */         if (i == 3)
/*     */         {
/* 206 */           return ItemRegistry.lettuceseedItem;
/*     */         }
/* 208 */         if (i == 4)
/*     */         {
/* 210 */           return ItemRegistry.scallionseedItem;
/*     */         }
/* 212 */         if (i == 5)
/*     */         {
/* 214 */           return ItemRegistry.artichokeseedItem;
/*     */         }
/* 216 */         if (i == 6)
/*     */         {
/* 218 */           return ItemRegistry.brusselsproutseedItem;
/*     */         }
/* 220 */         if (i == 7)
/*     */         {
/* 222 */           return ItemRegistry.cabbageseedItem;
/*     */         }
/* 224 */         return ItemRegistry.spinachseedItem;
/*     */       }
/* 226 */       if (this == BlockRegistry.pamstalkGarden)
/*     */       {
/* 228 */         int i = p_149650_2_.nextInt(8);
/*     */         
/* 230 */         if (i == 0)
/*     */         {
/* 232 */           return ItemRegistry.beanseedItem;
/*     */         }
/* 234 */         if (i == 1)
/*     */         {
/* 236 */           return ItemRegistry.soybeanseedItem;
/*     */         }
/* 238 */         if (i == 2)
/*     */         {
/* 240 */           return ItemRegistry.bellpepperseedItem;
/*     */         }
/* 242 */         if (i == 3)
/*     */         {
/* 244 */           return ItemRegistry.chilipepperseedItem;
/*     */         }
/* 246 */         if (i == 4)
/*     */         {
/* 248 */           return ItemRegistry.eggplantseedItem;
/*     */         }
/* 250 */         if (i == 5)
/*     */         {
/* 252 */           return ItemRegistry.okraseedItem;
/*     */         }
/* 254 */         if (i == 6)
/*     */         {
/* 256 */           return ItemRegistry.peasseedItem;
/*     */         }
/* 258 */         return ItemRegistry.tomatoseedItem;
/*     */       }
/* 260 */       if (this == BlockRegistry.pamtextileGarden)
/*     */       {
/* 262 */         int i = p_149650_2_.nextInt(1);
/*     */         
/* 264 */         if (i == 0)
/*     */         {
/* 266 */           return ItemRegistry.cottonseedItem;
/*     */         }
/* 268 */         return ItemRegistry.cottonseedItem;
/*     */       }
/* 270 */       if (this == BlockRegistry.pamtropicalGarden)
/*     */       {
/* 272 */         int i = p_149650_2_.nextInt(5);
/*     */         
/* 274 */         if (i == 0)
/*     */         {
/* 276 */           return ItemRegistry.pineappleseedItem;
/*     */         }
/* 278 */         if (i == 1)
/*     */         {
/* 280 */           return ItemRegistry.kiwiseedItem;
/*     */         }
/* 282 */         if (i == 2)
/*     */         {
/* 284 */           return Items.melon_seeds;
/*     */         }
/* 286 */         if (i == 3)
/*     */         {
/* 288 */           return ItemRegistry.curryleafseedItem;
/*     */         }
/* 290 */         return ItemRegistry.sesameseedsseedItem;
/*     */       }
/*     */     }
/* 293 */     if (this == BlockRegistry.pamberryGarden)
/*     */     {
/* 295 */       int i = p_149650_2_.nextInt(6);
/*     */       
/* 297 */       if (i == 0)
/*     */       {
/* 299 */         return ItemRegistry.blackberryItem;
/*     */       }
/* 301 */       if (i == 1)
/*     */       {
/* 303 */         return ItemRegistry.blueberryItem;
/*     */       }
/* 305 */       if (i == 2)
/*     */       {
/* 307 */         return ItemRegistry.candleberryItem;
/*     */       }
/* 309 */       if (i == 3)
/*     */       {
/* 311 */         return ItemRegistry.raspberryItem;
/*     */       }
/* 313 */       if (i == 4)
/*     */       {
/* 315 */         return ItemRegistry.strawberryItem;
/*     */       }
/* 317 */       return ItemRegistry.grapeItem;
/*     */     }
/* 319 */     if (this == BlockRegistry.pamgrassGarden)
/*     */     {
/* 321 */       int i = p_149650_2_.nextInt(6);
/*     */       
/* 323 */       if (i == 0)
/*     */       {
/* 325 */         return ItemRegistry.asparagusItem;
/*     */       }
/* 327 */       if (i == 1)
/*     */       {
/* 329 */         return ItemRegistry.barleyItem;
/*     */       }
/* 331 */       if (i == 2)
/*     */       {
/* 333 */         return ItemRegistry.oatsItem;
/*     */       }
/* 335 */       if (i == 3)
/*     */       {
/* 337 */         return ItemRegistry.ryeItem;
/*     */       }
/* 339 */       if (i == 4)
/*     */       {
/* 341 */         return ItemRegistry.cornItem;
/*     */       }
/* 343 */       return ItemRegistry.bambooshootItem;
/*     */     }
/* 345 */     if (this == BlockRegistry.pamgourdGarden)
/*     */     {
/* 347 */       int i = p_149650_2_.nextInt(5);
/*     */       
/* 349 */       if (i == 0)
/*     */       {
/* 351 */         return ItemRegistry.cantaloupeItem;
/*     */       }
/* 353 */       if (i == 1)
/*     */       {
/* 355 */         return ItemRegistry.cucumberItem;
/*     */       }
/* 357 */       if (i == 2)
/*     */       {
/* 359 */         return ItemRegistry.wintersquashItem;
/*     */       }
/* 361 */       if (i == 3)
/*     */       {
/* 363 */         return ItemRegistry.zucchiniItem;
/*     */       }
/* 365 */       return Item.getItemFromBlock(Blocks.pumpkin);
/*     */     }
/* 367 */     if (this == BlockRegistry.pamgroundGarden)
/*     */     {
/* 369 */       int i = p_149650_2_.nextInt(11);
/*     */       
/* 371 */       if (i == 0)
/*     */       {
/* 373 */         return ItemRegistry.beetItem;
/*     */       }
/* 375 */       if (i == 1)
/*     */       {
/* 377 */         return ItemRegistry.onionItem;
/*     */       }
/* 379 */       if (i == 2)
/*     */       {
/* 381 */         return ItemRegistry.parsnipItem;
/*     */       }
/* 383 */       if (i == 3)
/*     */       {
/* 385 */         return ItemRegistry.peanutItem;
/*     */       }
/* 387 */       if (i == 4)
/*     */       {
/* 389 */         return ItemRegistry.radishItem;
/*     */       }
/* 391 */       if (i == 5)
/*     */       {
/* 393 */         return ItemRegistry.rutabagaItem;
/*     */       }
/* 395 */       if (i == 6)
/*     */       {
/* 397 */         return ItemRegistry.sweetpotatoItem;
/*     */       }
/* 399 */       if (i == 7)
/*     */       {
/* 401 */         return ItemRegistry.turnipItem;
/*     */       }
/* 403 */       if (i == 8)
/*     */       {
/* 405 */         return ItemRegistry.rhubarbItem;
/*     */       }
/* 407 */       if (i == 9)
/*     */       {
/* 409 */         return Items.potato;
/*     */       }
/* 411 */       return Items.carrot;
/*     */     }
/* 413 */     if (this == BlockRegistry.pamherbGarden)
/*     */     {
/* 415 */       int i = p_149650_2_.nextInt(8);
/*     */       
/* 417 */       if (i == 0)
/*     */       {
/* 419 */         return ItemRegistry.celeryItem;
/*     */       }
/* 421 */       if (i == 1)
/*     */       {
/* 423 */         return ItemRegistry.garlicItem;
/*     */       }
/* 425 */       if (i == 2)
/*     */       {
/* 427 */         return ItemRegistry.gingerItem;
/*     */       }
/* 429 */       if (i == 3)
/*     */       {
/* 431 */         return ItemRegistry.spiceleafItem;
/*     */       }
/* 433 */       if (i == 4)
/*     */       {
/* 435 */         return ItemRegistry.ediblerootItem;
/*     */       }
/* 437 */       if (i == 5)
/*     */       {
/* 439 */         return ItemRegistry.tealeafItem;
/*     */       }
/* 441 */       if (i == 6)
/*     */       {
/* 443 */         return ItemRegistry.coffeebeanItem;
/*     */       }
/* 445 */       return ItemRegistry.mustardseedsItem;
/*     */     }
/* 447 */     if (this == BlockRegistry.pamleafyGarden)
/*     */     {
/* 449 */       int i = p_149650_2_.nextInt(9);
/*     */       
/* 451 */       if (i == 0)
/*     */       {
/* 453 */         return ItemRegistry.broccoliItem;
/*     */       }
/* 455 */       if (i == 1)
/*     */       {
/* 457 */         return ItemRegistry.cauliflowerItem;
/*     */       }
/* 459 */       if (i == 2)
/*     */       {
/* 461 */         return ItemRegistry.leekItem;
/*     */       }
/* 463 */       if (i == 3)
/*     */       {
/* 465 */         return ItemRegistry.lettuceItem;
/*     */       }
/* 467 */       if (i == 4)
/*     */       {
/* 469 */         return ItemRegistry.scallionItem;
/*     */       }
/* 471 */       if (i == 5)
/*     */       {
/* 473 */         return ItemRegistry.artichokeItem;
/*     */       }
/* 475 */       if (i == 6)
/*     */       {
/* 477 */         return ItemRegistry.brusselsproutItem;
/*     */       }
/* 479 */       if (i == 7)
/*     */       {
/* 481 */         return ItemRegistry.cabbageItem;
/*     */       }
/* 483 */       return ItemRegistry.spinachItem;
/*     */     }
/* 485 */     if (this == BlockRegistry.pamstalkGarden)
/*     */     {
/* 487 */       int i = p_149650_2_.nextInt(8);
/*     */       
/* 489 */       if (i == 0)
/*     */       {
/* 491 */         return ItemRegistry.beanItem;
/*     */       }
/* 493 */       if (i == 1)
/*     */       {
/* 495 */         return ItemRegistry.soybeanItem;
/*     */       }
/* 497 */       if (i == 2)
/*     */       {
/* 499 */         return ItemRegistry.bellpepperItem;
/*     */       }
/* 501 */       if (i == 3)
/*     */       {
/* 503 */         return ItemRegistry.chilipepperItem;
/*     */       }
/* 505 */       if (i == 4)
/*     */       {
/* 507 */         return ItemRegistry.eggplantItem;
/*     */       }
/* 509 */       if (i == 5)
/*     */       {
/* 511 */         return ItemRegistry.okraItem;
/*     */       }
/* 513 */       if (i == 6)
/*     */       {
/* 515 */         return ItemRegistry.peasItem;
/*     */       }
/* 517 */       return ItemRegistry.tomatoItem;
/*     */     }
/* 519 */     if (this == BlockRegistry.pamtextileGarden)
/*     */     {
/* 521 */       int i = p_149650_2_.nextInt(1);
/*     */       
/* 523 */       if (i == 0)
/*     */       {
/* 525 */         return ItemRegistry.cottonItem;
/*     */       }
/* 527 */       return ItemRegistry.cottonItem;
/*     */     }
/* 529 */     if (this == BlockRegistry.pamtropicalGarden)
/*     */     {
/* 531 */       int i = p_149650_2_.nextInt(5);
/*     */       
/* 533 */       if (i == 0)
/*     */       {
/* 535 */         return ItemRegistry.pineappleItem;
/*     */       }
/* 537 */       if (i == 1)
/*     */       {
/* 539 */         return ItemRegistry.kiwiItem;
/*     */       }
/* 541 */       if (i == 2)
/*     */       {
/* 543 */         return Items.melon;
/*     */       }
/* 545 */       if (i == 3)
/*     */       {
/* 547 */         return ItemRegistry.curryleafItem;
/*     */       }
/* 549 */       return ItemRegistry.sesameseedsItem;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 554 */     return ItemRegistry.whitemushroomItem;
/*     */   }
/*     */   
/*     */   public int quantityDropped(Random p_149745_1_)
/*     */   {
/* 559 */     return BlockRegistry.gardendropAmount;
/*     */   }
/*     */   
public void updateTick(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_)
{
	if (BlockRegistry.enablegardenSpread == true)
	{
    if (p_149674_5_.nextInt(BlockRegistry.gardenspreadRate) == 0)
    {
        byte b0 = 4;
        int l = 5;
        int i1;
        int j1;
        int k1;
        
        int i = this.getDamageValue(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_);

        for (i1 = p_149674_2_ - b0; i1 <= p_149674_2_ + b0; ++i1)
        {
            for (j1 = p_149674_4_ - b0; j1 <= p_149674_4_ + b0; ++j1)
            {
                for (k1 = p_149674_3_ - 1; k1 <= p_149674_3_ + 1; ++k1)
                {
                    if (p_149674_1_.getBlock(i1, k1, j1) == this)
                    {
                        --l;

                        if (l <= 0)
                        {
                            return;
                        }
                    }
                }
            }
        }

        i1 = p_149674_2_ + p_149674_5_.nextInt(3) - 1;
        j1 = p_149674_3_ + p_149674_5_.nextInt(2) - p_149674_5_.nextInt(2);
        k1 = p_149674_4_ + p_149674_5_.nextInt(3) - 1;

        for (int l1 = 0; l1 < 4; ++l1)
        {
            if (p_149674_1_.isAirBlock(i1, j1, k1) && this.canBlockStay(p_149674_1_, i1, j1, k1))
            {
                p_149674_2_ = i1;
                p_149674_3_ = j1;
                p_149674_4_ = k1;
            }

            i1 = p_149674_2_ + p_149674_5_.nextInt(3) - 1;
            j1 = p_149674_3_ + p_149674_5_.nextInt(2) - p_149674_5_.nextInt(2);
            k1 = p_149674_4_ + p_149674_5_.nextInt(3) - 1;
        }

        if (p_149674_1_.isAirBlock(i1, j1, k1) && this.canBlockStay(p_149674_1_, i1, j1, k1))
        {
            p_149674_1_.setBlock(i1, j1, k1, this, i, 2);
        }
    }
	}
}
/*     */   public boolean onBlockActivated(World world, int par2, int par3, int par4, EntityPlayer player, int par6, float par7, float par8, float par9)
/*     */   {
/* 625 */     int meta = world.getBlockMetadata(par2, par3, par4);
/*     */     
/* 627 */     if (meta == 0)
/*     */     {
/* 629 */       if (meta == 0)
/*     */       {
/* 631 */         dropBlockAsItem(world, par2, par3, par4, new ItemStack(this, 1, 0));
/* 632 */         world.setBlockToAir(par2, par3, par4);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 637 */     return false;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void registerBlockIcons(IIconRegister par1IconRegister)
/*     */   {
/* 643 */     if (this == BlockRegistry.pamberryGarden)
/*     */     {
/* 645 */       this.blockIcon = par1IconRegister.registerIcon("harvestcraft:berrygarden0");
/*     */     }
/* 647 */     if (this == BlockRegistry.pamgrassGarden)
/*     */     {
/* 649 */       this.blockIcon = par1IconRegister.registerIcon("harvestcraft:grassgarden0");
/*     */     }
/* 651 */     if (this == BlockRegistry.pamgourdGarden)
/*     */     {
/* 653 */       this.blockIcon = par1IconRegister.registerIcon("harvestcraft:gourdgarden0");
/*     */     }
/* 655 */     if (this == BlockRegistry.pamgroundGarden)
/*     */     {
/* 657 */       this.blockIcon = par1IconRegister.registerIcon("harvestcraft:groundgarden0");
/*     */     }
/* 659 */     if (this == BlockRegistry.pamherbGarden)
/*     */     {
/* 661 */       this.blockIcon = par1IconRegister.registerIcon("harvestcraft:herbgarden0");
/*     */     }
/* 663 */     if (this == BlockRegistry.pamleafyGarden)
/*     */     {
/* 665 */       this.blockIcon = par1IconRegister.registerIcon("harvestcraft:leafygarden0");
/*     */     }
/* 667 */     if (this == BlockRegistry.pamstalkGarden)
/*     */     {
/* 669 */       this.blockIcon = par1IconRegister.registerIcon("harvestcraft:stalkgarden0");
/*     */     }
/* 671 */     if (this == BlockRegistry.pamtextileGarden)
/*     */     {
/* 673 */       this.blockIcon = par1IconRegister.registerIcon("harvestcraft:textilegarden0");
/*     */     }
/* 675 */     if (this == BlockRegistry.pamtropicalGarden)
/*     */     {
/* 677 */       this.blockIcon = par1IconRegister.registerIcon("harvestcraft:tropicalgarden0");
/*     */     }
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon getIcon(int par1, int par2) {
/* 683 */     return this.blockIcon;
/*     */   }
/*     */   
/*     */ 
/*     */   public EnumPlantType getPlantType(World world, int x, int y, int z)
/*     */   {
/* 689 */     return EnumPlantType.Plains;
/*     */   }
/*     */   
/*     */ 
/*     */   public Block getPlant(IBlockAccess world, int x, int y, int z)
/*     */   {
/* 695 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getPlantMetadata(IBlockAccess world, int x, int y, int z)
/*     */   {
/* 701 */     return world.getBlockMetadata(x, y, z);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List)
/*     */   {
/* 709 */     for (int i = 0; i < 1; i++)
/*     */     {
/* 711 */       par3List.add(new ItemStack(par1, 1, i));
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Modding\Desktop\Pam's HarvestCraft 1.7.10k.deobf.jar!\com\pam\harvestcraft\BlockPamNormalGarden.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */