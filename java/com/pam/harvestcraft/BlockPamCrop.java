/*     */ package com.pam.harvestcraft;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockCrops;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.EnumPlantType;
/*     */ import net.minecraftforge.common.IPlantable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockPamCrop
/*     */   extends BlockCrops
/*     */   implements IPlantable
/*     */ {
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon[] field_149868_a;
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon getIcon(int p_149691_1_, int p_149691_2_)
/*     */   {
/*  34 */     if (p_149691_2_ < 7)
/*     */     {
/*  36 */       if (p_149691_2_ == 6)
/*     */       {
/*  38 */         p_149691_2_ = 5;
/*     */       }
/*     */       
/*  41 */       return this.field_149868_a[(p_149691_2_ >> 1)];
/*     */     }
/*     */     
/*     */ 
/*  45 */     return this.field_149868_a[3];
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean onBlockActivated(World world, int par2, int par3, int par4, EntityPlayer player, int par6, float par7, float par8, float par9)
/*     */   {
/*  53 */     if (BlockRegistry.rightclickmatureshowcropHearts == true)
/*     */     {
/*  55 */       int meta = world.getBlockMetadata(par2, par3, par4);
/*     */       
/*  57 */       if (meta == 7)
/*     */       {
/*  59 */         float f = par2 + 0.5F;
/*  60 */         float f1 = par3 + 0.0F + 0.375F;
/*  61 */         float f2 = par4 + 0.5F;
/*  62 */         float f3 = 0.52F;
/*  63 */         float f4 = 0.3F;
/*  64 */         world.spawnParticle("heart", f - f3, f1, f2 + f4, 0.0D, 0.0D, 0.0D);
/*     */       }
/*     */     }
/*  67 */     if (BlockRegistry.rightclickharvestCrop == true)
/*     */     {
/*  69 */       int meta = world.getBlockMetadata(par2, par3, par4);
/*     */       
/*  71 */       if (meta == 7)
/*     */       {
/*  73 */         if (meta == 7)
/*     */         {
/*  75 */           dropBlockAsItem(world, par2, par3, par4, meta, 0);
/*  76 */           world.setBlock(par2, par3, par4, this, 0, 2);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*  82 */     return false;
/*     */   }
/*     */   
/*     */   public int quantityDropped(Random p_149745_1_)
/*     */   {
/*  87 */     if (BlockRegistry.rightclickharvestCrop == true)
/*     */     {
/*  89 */       return 0;
/*     */     }
/*     */     
/*  92 */     return 1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected boolean func_149854_a(Block p_149854_1_)
/*     */   {
/* 100 */     if (this == BlockRegistry.pamcactusfruitCrop)
/*     */     {
/* 102 */       return p_149854_1_ == Blocks.sand;
/*     */     }
/* 104 */     if (this == BlockRegistry.pamwhitemushroomCrop)
/*     */     {
/* 106 */       return p_149854_1_ == Blocks.log;
/*     */     }
/* 108 */     if (this == BlockRegistry.pamcranberryCrop)
/*     */     {
/* 110 */       return p_149854_1_ == Blocks.water;
/*     */     }
/* 112 */     if (this == BlockRegistry.pamriceCrop)
/*     */     {
/* 114 */       return p_149854_1_ == Blocks.water;
/*     */     }
/* 116 */     if (this == BlockRegistry.pamseaweedCrop)
/*     */     {
/* 118 */       return p_149854_1_ == Blocks.water;
/*     */     }
/* 120 */     if (this == BlockRegistry.pamwaterchestnutCrop)
/*     */     {
/* 122 */       return p_149854_1_ == Blocks.water;
/*     */     }
/*     */     
/* 125 */     if (this == BlockRegistry.pamcactusfruitCrop)
/*     */     {
/* 127 */       return p_149854_1_ == Blocks.farmland;
/*     */     }
/* 129 */     if (this == BlockRegistry.pamwhitemushroomCrop)
/*     */     {
/* 131 */       return p_149854_1_ == Blocks.farmland;
/*     */     }
/* 133 */     if (this == BlockRegistry.pamcranberryCrop)
/*     */     {
/* 135 */       return p_149854_1_ == Blocks.farmland;
/*     */     }
/* 137 */     if (this == BlockRegistry.pamriceCrop)
/*     */     {
/* 139 */       return p_149854_1_ == Blocks.farmland;
/*     */     }
/* 141 */     if (this == BlockRegistry.pamseaweedCrop)
/*     */     {
/* 143 */       return p_149854_1_ == Blocks.farmland;
/*     */     }
/* 145 */     if (this == BlockRegistry.pamwaterchestnutCrop)
/*     */     {
/* 147 */       return p_149854_1_ == Blocks.farmland;
/*     */     }
/* 149 */     return p_149854_1_ == Blocks.farmland;
/*     */   }
/*     */   
/*     */ 
/*     */   protected Item func_149866_i()
/*     */   {
/* 155 */     if (BlockRegistry.cropsdropSeeds == true)
/*     */     {
/*     */ 
/* 158 */       if (this == BlockRegistry.pamblackberryCrop)
/*     */       {
/* 160 */         return ItemRegistry.blackberryseedItem;
/*     */       }
/* 162 */       if (this == BlockRegistry.pamblueberryCrop)
/*     */       {
/* 164 */         return ItemRegistry.blueberryseedItem;
/*     */       }
/* 166 */       if (this == BlockRegistry.pamcandleberryCrop)
/*     */       {
/* 168 */         return ItemRegistry.candleberryseedItem;
/*     */       }
/* 170 */       if (this == BlockRegistry.pamraspberryCrop)
/*     */       {
/* 172 */         return ItemRegistry.raspberryseedItem;
/*     */       }
/* 174 */       if (this == BlockRegistry.pamstrawberryCrop)
/*     */       {
/* 176 */         return ItemRegistry.strawberryseedItem;
/*     */       }
/* 178 */       if (this == BlockRegistry.pamgrapeCrop)
/*     */       {
/* 180 */         return ItemRegistry.grapeseedItem;
/*     */       }
/*     */       
/* 183 */       if (this == BlockRegistry.pamcactusfruitCrop)
/*     */       {
/* 185 */         return ItemRegistry.cactusfruitseedItem;
/*     */       }
/*     */       
/* 188 */       if (this == BlockRegistry.pamasparagusCrop)
/*     */       {
/* 190 */         return ItemRegistry.asparagusseedItem;
/*     */       }
/* 192 */       if (this == BlockRegistry.pambarleyCrop)
/*     */       {
/* 194 */         return ItemRegistry.barleyseedItem;
/*     */       }
/* 196 */       if (this == BlockRegistry.pamoatsCrop)
/*     */       {
/* 198 */         return ItemRegistry.oatsseedItem;
/*     */       }
/* 200 */       if (this == BlockRegistry.pamryeCrop)
/*     */       {
/* 202 */         return ItemRegistry.ryeseedItem;
/*     */       }
/* 204 */       if (this == BlockRegistry.pamcornCrop)
/*     */       {
/* 206 */         return ItemRegistry.cornseedItem;
/*     */       }
/* 208 */       if (this == BlockRegistry.pambambooshootCrop)
/*     */       {
/* 210 */         return ItemRegistry.bambooshootseedItem;
/*     */       }
/*     */       
/* 213 */       if (this == BlockRegistry.pamcantaloupeCrop)
/*     */       {
/* 215 */         return ItemRegistry.cantaloupeseedItem;
/*     */       }
/* 217 */       if (this == BlockRegistry.pamcucumberCrop)
/*     */       {
/* 219 */         return ItemRegistry.cucumberseedItem;
/*     */       }
/* 221 */       if (this == BlockRegistry.pamwintersquashCrop)
/*     */       {
/* 223 */         return ItemRegistry.wintersquashseedItem;
/*     */       }
/* 225 */       if (this == BlockRegistry.pamzucchiniCrop)
/*     */       {
/* 227 */         return ItemRegistry.zucchiniseedItem;
/*     */       }
/*     */       
/* 230 */       if (this == BlockRegistry.pambeetCrop)
/*     */       {
/* 232 */         return ItemRegistry.beetseedItem;
/*     */       }
/* 234 */       if (this == BlockRegistry.pamonionCrop)
/*     */       {
/* 236 */         return ItemRegistry.onionseedItem;
/*     */       }
/* 238 */       if (this == BlockRegistry.pamparsnipCrop)
/*     */       {
/* 240 */         return ItemRegistry.parsnipseedItem;
/*     */       }
/* 242 */       if (this == BlockRegistry.pampeanutCrop)
/*     */       {
/* 244 */         return ItemRegistry.peanutseedItem;
/*     */       }
/* 246 */       if (this == BlockRegistry.pamradishCrop)
/*     */       {
/* 248 */         return ItemRegistry.radishseedItem;
/*     */       }
/* 250 */       if (this == BlockRegistry.pamrutabagaCrop)
/*     */       {
/* 252 */         return ItemRegistry.rutabagaseedItem;
/*     */       }
/* 254 */       if (this == BlockRegistry.pamsweetpotatoCrop)
/*     */       {
/* 256 */         return ItemRegistry.sweetpotatoseedItem;
/*     */       }
/* 258 */       if (this == BlockRegistry.pamturnipCrop)
/*     */       {
/* 260 */         return ItemRegistry.turnipseedItem;
/*     */       }
/* 262 */       if (this == BlockRegistry.pamrhubarbCrop)
/*     */       {
/* 264 */         return ItemRegistry.rhubarbseedItem;
/*     */       }
/*     */       
/* 267 */       if (this == BlockRegistry.pamceleryCrop)
/*     */       {
/* 269 */         return ItemRegistry.celeryseedItem;
/*     */       }
/* 271 */       if (this == BlockRegistry.pamgarlicCrop)
/*     */       {
/* 273 */         return ItemRegistry.garlicseedItem;
/*     */       }
/* 275 */       if (this == BlockRegistry.pamgingerCrop)
/*     */       {
/* 277 */         return ItemRegistry.gingerseedItem;
/*     */       }
/* 279 */       if (this == BlockRegistry.pamspiceleafCrop)
/*     */       {
/* 281 */         return ItemRegistry.spiceleafseedItem;
/*     */       }
/* 283 */       if (this == BlockRegistry.pamtealeafCrop)
/*     */       {
/* 285 */         return ItemRegistry.teaseedItem;
/*     */       }
/* 287 */       if (this == BlockRegistry.pamcoffeebeanCrop)
/*     */       {
/* 289 */         return ItemRegistry.coffeeseedItem;
/*     */       }
/* 291 */       if (this == BlockRegistry.pammustardseedsCrop)
/*     */       {
/* 293 */         return ItemRegistry.mustardseedItem;
/*     */       }
/*     */       
/* 296 */       if (this == BlockRegistry.pambroccoliCrop)
/*     */       {
/* 298 */         return ItemRegistry.broccoliseedItem;
/*     */       }
/* 300 */       if (this == BlockRegistry.pamcauliflowerCrop)
/*     */       {
/* 302 */         return ItemRegistry.cauliflowerseedItem;
/*     */       }
/* 304 */       if (this == BlockRegistry.pamleekCrop)
/*     */       {
/* 306 */         return ItemRegistry.leekseedItem;
/*     */       }
/* 308 */       if (this == BlockRegistry.pamlettuceCrop)
/*     */       {
/* 310 */         return ItemRegistry.lettuceseedItem;
/*     */       }
/* 312 */       if (this == BlockRegistry.pamscallionCrop)
/*     */       {
/* 314 */         return ItemRegistry.scallionseedItem;
/*     */       }
/* 316 */       if (this == BlockRegistry.pamartichokeCrop)
/*     */       {
/* 318 */         return ItemRegistry.artichokeseedItem;
/*     */       }
/* 320 */       if (this == BlockRegistry.pambrusselsproutCrop)
/*     */       {
/* 322 */         return ItemRegistry.brusselsproutseedItem;
/*     */       }
/* 324 */       if (this == BlockRegistry.pamcabbageCrop)
/*     */       {
/* 326 */         return ItemRegistry.cabbageseedItem;
/*     */       }
/* 328 */       if (this == BlockRegistry.pamspinachCrop)
/*     */       {
/* 330 */         return ItemRegistry.spinachseedItem;
/*     */       }
/*     */       
/* 333 */       if (this == BlockRegistry.pamwhitemushroomCrop)
/*     */       {
/* 335 */         return ItemRegistry.whitemushroomseedItem;
/*     */       }
/*     */       
/* 338 */       if (this == BlockRegistry.pambeanCrop)
/*     */       {
/* 340 */         return ItemRegistry.beanseedItem;
/*     */       }
/* 342 */       if (this == BlockRegistry.pamsoybeanCrop)
/*     */       {
/* 344 */         return ItemRegistry.soybeanseedItem;
/*     */       }
/* 346 */       if (this == BlockRegistry.pambellpepperCrop)
/*     */       {
/* 348 */         return ItemRegistry.bellpepperseedItem;
/*     */       }
/* 350 */       if (this == BlockRegistry.pamchilipepperCrop)
/*     */       {
/* 352 */         return ItemRegistry.chilipepperseedItem;
/*     */       }
/* 354 */       if (this == BlockRegistry.pameggplantCrop)
/*     */       {
/* 356 */         return ItemRegistry.eggplantseedItem;
/*     */       }
/* 358 */       if (this == BlockRegistry.pamokraCrop)
/*     */       {
/* 360 */         return ItemRegistry.okraseedItem;
/*     */       }
/* 362 */       if (this == BlockRegistry.pampeasCrop)
/*     */       {
/* 364 */         return ItemRegistry.peasseedItem;
/*     */       }
/* 366 */       if (this == BlockRegistry.pamtomatoCrop)
/*     */       {
/* 368 */         return ItemRegistry.tomatoseedItem;
/*     */       }
/*     */       
/* 371 */       if (this == BlockRegistry.pamcottonCrop)
/*     */       {
/* 373 */         return ItemRegistry.cottonseedItem;
/*     */       }
/*     */       
/* 376 */       if (this == BlockRegistry.pampineappleCrop)
/*     */       {
/* 378 */         return ItemRegistry.pineappleseedItem;
/*     */       }
/* 380 */       if (this == BlockRegistry.pamkiwiCrop)
/*     */       {
/* 382 */         return ItemRegistry.kiwiseedItem;
/*     */       }
/* 384 */       if (this == BlockRegistry.pamcurryleafCrop)
/*     */       {
/* 386 */         return ItemRegistry.curryleafseedItem;
/*     */       }
/* 388 */       if (this == BlockRegistry.pamsesameseedsCrop)
/*     */       {
/* 390 */         return ItemRegistry.sesameseedsseedItem;
/*     */       }
/*     */       
/* 393 */       if (!BlockRegistry.enablecropspecialplanting) {
/* 394 */         if (this == BlockRegistry.pamcranberryCrop)
/*     */         {
/* 396 */           return ItemRegistry.cranberryseedItem;
/*     */         }
/* 398 */         if (this == BlockRegistry.pamriceCrop)
/*     */         {
/* 400 */           return ItemRegistry.riceseedItem;
/*     */         }
/* 402 */         if (this == BlockRegistry.pamseaweedCrop)
/*     */         {
/* 404 */           return ItemRegistry.seaweedseedItem;
/*     */         }
/*     */       } else {
/* 407 */         if (this == BlockRegistry.pamcranberryCrop)
/*     */         {
/* 409 */           return ItemRegistry.cranberryItem;
/*     */         }
/* 411 */         if (this == BlockRegistry.pamriceCrop)
/*     */         {
/* 413 */           return ItemRegistry.riceItem;
/*     */         }
/* 415 */         if (this == BlockRegistry.pamseaweedCrop)
/*     */         {
/* 417 */           return ItemRegistry.seaweedItem;
/*     */         }
/* 419 */         if (this == BlockRegistry.pamwaterchestnutCrop)
/*     */         {
/* 421 */           return ItemRegistry.waterchestnutItem;
/*     */         }
/*     */       }
/*     */     }
/* 425 */     if (!BlockRegistry.cropsdropSeeds)
/*     */     {
/*     */ 
/* 428 */       if (this == BlockRegistry.pamblackberryCrop)
/*     */       {
/* 430 */         return ItemRegistry.blackberryItem;
/*     */       }
/* 432 */       if (this == BlockRegistry.pamblueberryCrop)
/*     */       {
/* 434 */         return ItemRegistry.blueberryItem;
/*     */       }
/* 436 */       if (this == BlockRegistry.pamcandleberryCrop)
/*     */       {
/* 438 */         return ItemRegistry.candleberryItem;
/*     */       }
/* 440 */       if (this == BlockRegistry.pamraspberryCrop)
/*     */       {
/* 442 */         return ItemRegistry.raspberryItem;
/*     */       }
/* 444 */       if (this == BlockRegistry.pamstrawberryCrop)
/*     */       {
/* 446 */         return ItemRegistry.strawberryItem;
/*     */       }
/* 448 */       if (this == BlockRegistry.pamgrapeCrop)
/*     */       {
/* 450 */         return ItemRegistry.grapeItem;
/*     */       }
/*     */       
/* 453 */       if (this == BlockRegistry.pamcactusfruitCrop)
/*     */       {
/* 455 */         return ItemRegistry.cactusfruitItem;
/*     */       }
/*     */       
/* 458 */       if (this == BlockRegistry.pamasparagusCrop)
/*     */       {
/* 460 */         return ItemRegistry.asparagusItem;
/*     */       }
/* 462 */       if (this == BlockRegistry.pambarleyCrop)
/*     */       {
/* 464 */         return ItemRegistry.barleyItem;
/*     */       }
/* 466 */       if (this == BlockRegistry.pamoatsCrop)
/*     */       {
/* 468 */         return ItemRegistry.oatsItem;
/*     */       }
/* 470 */       if (this == BlockRegistry.pamryeCrop)
/*     */       {
/* 472 */         return ItemRegistry.ryeItem;
/*     */       }
/* 474 */       if (this == BlockRegistry.pamcornCrop)
/*     */       {
/* 476 */         return ItemRegistry.cornItem;
/*     */       }
/* 478 */       if (this == BlockRegistry.pambambooshootCrop)
/*     */       {
/* 480 */         return ItemRegistry.bambooshootItem;
/*     */       }
/*     */       
/* 483 */       if (this == BlockRegistry.pamcantaloupeCrop)
/*     */       {
/* 485 */         return ItemRegistry.cantaloupeItem;
/*     */       }
/* 487 */       if (this == BlockRegistry.pamcucumberCrop)
/*     */       {
/* 489 */         return ItemRegistry.cucumberItem;
/*     */       }
/* 491 */       if (this == BlockRegistry.pamwintersquashCrop)
/*     */       {
/* 493 */         return ItemRegistry.wintersquashItem;
/*     */       }
/* 495 */       if (this == BlockRegistry.pamzucchiniCrop)
/*     */       {
/* 497 */         return ItemRegistry.zucchiniItem;
/*     */       }
/*     */       
/* 500 */       if (this == BlockRegistry.pambeetCrop)
/*     */       {
/* 502 */         return ItemRegistry.beetItem;
/*     */       }
/* 504 */       if (this == BlockRegistry.pamonionCrop)
/*     */       {
/* 506 */         return ItemRegistry.onionItem;
/*     */       }
/* 508 */       if (this == BlockRegistry.pamparsnipCrop)
/*     */       {
/* 510 */         return ItemRegistry.parsnipItem;
/*     */       }
/* 512 */       if (this == BlockRegistry.pampeanutCrop)
/*     */       {
/* 514 */         return ItemRegistry.peanutItem;
/*     */       }
/* 516 */       if (this == BlockRegistry.pamradishCrop)
/*     */       {
/* 518 */         return ItemRegistry.radishItem;
/*     */       }
/* 520 */       if (this == BlockRegistry.pamrutabagaCrop)
/*     */       {
/* 522 */         return ItemRegistry.rutabagaItem;
/*     */       }
/* 524 */       if (this == BlockRegistry.pamsweetpotatoCrop)
/*     */       {
/* 526 */         return ItemRegistry.sweetpotatoItem;
/*     */       }
/* 528 */       if (this == BlockRegistry.pamturnipCrop)
/*     */       {
/* 530 */         return ItemRegistry.turnipItem;
/*     */       }
/* 532 */       if (this == BlockRegistry.pamrhubarbCrop)
/*     */       {
/* 534 */         return ItemRegistry.rhubarbItem;
/*     */       }
/*     */       
/* 537 */       if (this == BlockRegistry.pamceleryCrop)
/*     */       {
/* 539 */         return ItemRegistry.celeryItem;
/*     */       }
/* 541 */       if (this == BlockRegistry.pamgarlicCrop)
/*     */       {
/* 543 */         return ItemRegistry.garlicItem;
/*     */       }
/* 545 */       if (this == BlockRegistry.pamgingerCrop)
/*     */       {
/* 547 */         return ItemRegistry.gingerItem;
/*     */       }
/* 549 */       if (this == BlockRegistry.pamspiceleafCrop)
/*     */       {
/* 551 */         return ItemRegistry.spiceleafItem;
/*     */       }
/* 553 */       if (this == BlockRegistry.pamtealeafCrop)
/*     */       {
/* 555 */         return ItemRegistry.tealeafItem;
/*     */       }
/* 557 */       if (this == BlockRegistry.pamcoffeebeanCrop)
/*     */       {
/* 559 */         return ItemRegistry.coffeebeanItem;
/*     */       }
/* 561 */       if (this == BlockRegistry.pammustardseedsCrop)
/*     */       {
/* 563 */         return ItemRegistry.mustardseedsItem;
/*     */       }
/*     */       
/* 566 */       if (this == BlockRegistry.pambroccoliCrop)
/*     */       {
/* 568 */         return ItemRegistry.broccoliItem;
/*     */       }
/* 570 */       if (this == BlockRegistry.pamcauliflowerCrop)
/*     */       {
/* 572 */         return ItemRegistry.cauliflowerItem;
/*     */       }
/* 574 */       if (this == BlockRegistry.pamleekCrop)
/*     */       {
/* 576 */         return ItemRegistry.leekItem;
/*     */       }
/* 578 */       if (this == BlockRegistry.pamlettuceCrop)
/*     */       {
/* 580 */         return ItemRegistry.lettuceItem;
/*     */       }
/* 582 */       if (this == BlockRegistry.pamscallionCrop)
/*     */       {
/* 584 */         return ItemRegistry.scallionItem;
/*     */       }
/* 586 */       if (this == BlockRegistry.pamartichokeCrop)
/*     */       {
/* 588 */         return ItemRegistry.artichokeItem;
/*     */       }
/* 590 */       if (this == BlockRegistry.pambrusselsproutCrop)
/*     */       {
/* 592 */         return ItemRegistry.brusselsproutItem;
/*     */       }
/* 594 */       if (this == BlockRegistry.pamcabbageCrop)
/*     */       {
/* 596 */         return ItemRegistry.cabbageItem;
/*     */       }
/* 598 */       if (this == BlockRegistry.pamspinachCrop)
/*     */       {
/* 600 */         return ItemRegistry.spinachItem;
/*     */       }
/*     */       
/* 603 */       if (this == BlockRegistry.pamwhitemushroomCrop)
/*     */       {
/* 605 */         return ItemRegistry.whitemushroomItem;
/*     */       }
/*     */       
/* 608 */       if (this == BlockRegistry.pambeanCrop)
/*     */       {
/* 610 */         return ItemRegistry.beanItem;
/*     */       }
/* 612 */       if (this == BlockRegistry.pamsoybeanCrop)
/*     */       {
/* 614 */         return ItemRegistry.soybeanItem;
/*     */       }
/* 616 */       if (this == BlockRegistry.pambellpepperCrop)
/*     */       {
/* 618 */         return ItemRegistry.bellpepperItem;
/*     */       }
/* 620 */       if (this == BlockRegistry.pamchilipepperCrop)
/*     */       {
/* 622 */         return ItemRegistry.chilipepperItem;
/*     */       }
/* 624 */       if (this == BlockRegistry.pameggplantCrop)
/*     */       {
/* 626 */         return ItemRegistry.eggplantItem;
/*     */       }
/* 628 */       if (this == BlockRegistry.pamokraCrop)
/*     */       {
/* 630 */         return ItemRegistry.okraItem;
/*     */       }
/* 632 */       if (this == BlockRegistry.pampeasCrop)
/*     */       {
/* 634 */         return ItemRegistry.peasItem;
/*     */       }
/* 636 */       if (this == BlockRegistry.pamtomatoCrop)
/*     */       {
/* 638 */         return ItemRegistry.tomatoItem;
/*     */       }
/*     */       
/* 641 */       if (this == BlockRegistry.pamcottonCrop)
/*     */       {
/* 643 */         return ItemRegistry.cottonItem;
/*     */       }
/*     */       
/* 646 */       if (this == BlockRegistry.pampineappleCrop)
/*     */       {
/* 648 */         return ItemRegistry.pineappleItem;
/*     */       }
/* 650 */       if (this == BlockRegistry.pamkiwiCrop)
/*     */       {
/* 652 */         return ItemRegistry.kiwiItem;
/*     */       }
/* 654 */       if (this == BlockRegistry.pamcurryleafCrop)
/*     */       {
/* 656 */         return ItemRegistry.curryleafItem;
/*     */       }
/* 658 */       if (this == BlockRegistry.pamsesameseedsCrop)
/*     */       {
/* 660 */         return ItemRegistry.sesameseedsItem;
/*     */       }
/*     */       
/* 663 */       if (this == BlockRegistry.pamcranberryCrop)
/*     */       {
/* 665 */         return ItemRegistry.cranberryItem;
/*     */       }
/* 667 */       if (this == BlockRegistry.pamriceCrop)
/*     */       {
/* 669 */         return ItemRegistry.riceItem;
/*     */       }
/* 671 */       if (this == BlockRegistry.pamseaweedCrop)
/*     */       {
/* 673 */         return ItemRegistry.seaweedItem;
/*     */       }
/* 675 */       if (this == BlockRegistry.pamwaterchestnutCrop)
/*     */       {
/* 677 */         return ItemRegistry.waterchestnutItem;
/*     */       }
/*     */     }
/* 680 */     return Items.wheat_seeds;
/*     */   }
/*     */   
/*     */ 
/*     */   protected Item func_149865_P()
/*     */   {
/* 686 */     if (this == BlockRegistry.pamblackberryCrop)
/*     */     {
/* 688 */       return ItemRegistry.blackberryItem;
/*     */     }
/* 690 */     if (this == BlockRegistry.pamblueberryCrop)
/*     */     {
/* 692 */       return ItemRegistry.blueberryItem;
/*     */     }
/* 694 */     if (this == BlockRegistry.pamcandleberryCrop)
/*     */     {
/* 696 */       return ItemRegistry.candleberryItem;
/*     */     }
/* 698 */     if (this == BlockRegistry.pamraspberryCrop)
/*     */     {
/* 700 */       return ItemRegistry.raspberryItem;
/*     */     }
/* 702 */     if (this == BlockRegistry.pamstrawberryCrop)
/*     */     {
/* 704 */       return ItemRegistry.strawberryItem;
/*     */     }
/* 706 */     if (this == BlockRegistry.pamgrapeCrop)
/*     */     {
/* 708 */       return ItemRegistry.grapeItem;
/*     */     }
/*     */     
/* 711 */     if (this == BlockRegistry.pamcactusfruitCrop)
/*     */     {
/* 713 */       return ItemRegistry.cactusfruitItem;
/*     */     }
/*     */     
/* 716 */     if (this == BlockRegistry.pamasparagusCrop)
/*     */     {
/* 718 */       return ItemRegistry.asparagusItem;
/*     */     }
/* 720 */     if (this == BlockRegistry.pambarleyCrop)
/*     */     {
/* 722 */       return ItemRegistry.barleyItem;
/*     */     }
/* 724 */     if (this == BlockRegistry.pamoatsCrop)
/*     */     {
/* 726 */       return ItemRegistry.oatsItem;
/*     */     }
/* 728 */     if (this == BlockRegistry.pamryeCrop)
/*     */     {
/* 730 */       return ItemRegistry.ryeItem;
/*     */     }
/* 732 */     if (this == BlockRegistry.pamcornCrop)
/*     */     {
/* 734 */       return ItemRegistry.cornItem;
/*     */     }
/* 736 */     if (this == BlockRegistry.pambambooshootCrop)
/*     */     {
/* 738 */       return ItemRegistry.bambooshootItem;
/*     */     }
/*     */     
/* 741 */     if (this == BlockRegistry.pamcantaloupeCrop)
/*     */     {
/* 743 */       return ItemRegistry.cantaloupeItem;
/*     */     }
/* 745 */     if (this == BlockRegistry.pamcucumberCrop)
/*     */     {
/* 747 */       return ItemRegistry.cucumberItem;
/*     */     }
/* 749 */     if (this == BlockRegistry.pamwintersquashCrop)
/*     */     {
/* 751 */       return ItemRegistry.wintersquashItem;
/*     */     }
/* 753 */     if (this == BlockRegistry.pamzucchiniCrop)
/*     */     {
/* 755 */       return ItemRegistry.zucchiniItem;
/*     */     }
/*     */     
/* 758 */     if (this == BlockRegistry.pambeetCrop)
/*     */     {
/* 760 */       return ItemRegistry.beetItem;
/*     */     }
/* 762 */     if (this == BlockRegistry.pamonionCrop)
/*     */     {
/* 764 */       return ItemRegistry.onionItem;
/*     */     }
/* 766 */     if (this == BlockRegistry.pamparsnipCrop)
/*     */     {
/* 768 */       return ItemRegistry.parsnipItem;
/*     */     }
/* 770 */     if (this == BlockRegistry.pampeanutCrop)
/*     */     {
/* 772 */       return ItemRegistry.peanutItem;
/*     */     }
/* 774 */     if (this == BlockRegistry.pamradishCrop)
/*     */     {
/* 776 */       return ItemRegistry.radishItem;
/*     */     }
/* 778 */     if (this == BlockRegistry.pamrutabagaCrop)
/*     */     {
/* 780 */       return ItemRegistry.rutabagaItem;
/*     */     }
/* 782 */     if (this == BlockRegistry.pamsweetpotatoCrop)
/*     */     {
/* 784 */       return ItemRegistry.sweetpotatoItem;
/*     */     }
/* 786 */     if (this == BlockRegistry.pamturnipCrop)
/*     */     {
/* 788 */       return ItemRegistry.turnipItem;
/*     */     }
/* 790 */     if (this == BlockRegistry.pamrhubarbCrop)
/*     */     {
/* 792 */       return ItemRegistry.rhubarbItem;
/*     */     }
/*     */     
/* 795 */     if (this == BlockRegistry.pamceleryCrop)
/*     */     {
/* 797 */       return ItemRegistry.celeryItem;
/*     */     }
/* 799 */     if (this == BlockRegistry.pamgarlicCrop)
/*     */     {
/* 801 */       return ItemRegistry.garlicItem;
/*     */     }
/* 803 */     if (this == BlockRegistry.pamgingerCrop)
/*     */     {
/* 805 */       return ItemRegistry.gingerItem;
/*     */     }
/* 807 */     if (this == BlockRegistry.pamspiceleafCrop)
/*     */     {
/* 809 */       return ItemRegistry.spiceleafItem;
/*     */     }
/* 811 */     if (this == BlockRegistry.pamtealeafCrop)
/*     */     {
/* 813 */       return ItemRegistry.tealeafItem;
/*     */     }
/* 815 */     if (this == BlockRegistry.pamcoffeebeanCrop)
/*     */     {
/* 817 */       return ItemRegistry.coffeebeanItem;
/*     */     }
/* 819 */     if (this == BlockRegistry.pammustardseedsCrop)
/*     */     {
/* 821 */       return ItemRegistry.mustardseedsItem;
/*     */     }
/*     */     
/* 824 */     if (this == BlockRegistry.pambroccoliCrop)
/*     */     {
/* 826 */       return ItemRegistry.broccoliItem;
/*     */     }
/* 828 */     if (this == BlockRegistry.pamcauliflowerCrop)
/*     */     {
/* 830 */       return ItemRegistry.cauliflowerItem;
/*     */     }
/* 832 */     if (this == BlockRegistry.pamleekCrop)
/*     */     {
/* 834 */       return ItemRegistry.leekItem;
/*     */     }
/* 836 */     if (this == BlockRegistry.pamlettuceCrop)
/*     */     {
/* 838 */       return ItemRegistry.lettuceItem;
/*     */     }
/* 840 */     if (this == BlockRegistry.pamscallionCrop)
/*     */     {
/* 842 */       return ItemRegistry.scallionItem;
/*     */     }
/* 844 */     if (this == BlockRegistry.pamartichokeCrop)
/*     */     {
/* 846 */       return ItemRegistry.artichokeItem;
/*     */     }
/* 848 */     if (this == BlockRegistry.pambrusselsproutCrop)
/*     */     {
/* 850 */       return ItemRegistry.brusselsproutItem;
/*     */     }
/* 852 */     if (this == BlockRegistry.pamcabbageCrop)
/*     */     {
/* 854 */       return ItemRegistry.cabbageItem;
/*     */     }
/* 856 */     if (this == BlockRegistry.pamspinachCrop)
/*     */     {
/* 858 */       return ItemRegistry.spinachItem;
/*     */     }
/*     */     
/* 861 */     if (this == BlockRegistry.pamwhitemushroomCrop)
/*     */     {
/* 863 */       return ItemRegistry.whitemushroomItem;
/*     */     }
/*     */     
/* 866 */     if (this == BlockRegistry.pambeanCrop)
/*     */     {
/* 868 */       return ItemRegistry.beanItem;
/*     */     }
/* 870 */     if (this == BlockRegistry.pamsoybeanCrop)
/*     */     {
/* 872 */       return ItemRegistry.soybeanItem;
/*     */     }
/* 874 */     if (this == BlockRegistry.pambellpepperCrop)
/*     */     {
/* 876 */       return ItemRegistry.bellpepperItem;
/*     */     }
/* 878 */     if (this == BlockRegistry.pamchilipepperCrop)
/*     */     {
/* 880 */       return ItemRegistry.chilipepperItem;
/*     */     }
/* 882 */     if (this == BlockRegistry.pameggplantCrop)
/*     */     {
/* 884 */       return ItemRegistry.eggplantItem;
/*     */     }
/* 886 */     if (this == BlockRegistry.pamokraCrop)
/*     */     {
/* 888 */       return ItemRegistry.okraItem;
/*     */     }
/* 890 */     if (this == BlockRegistry.pampeasCrop)
/*     */     {
/* 892 */       return ItemRegistry.peasItem;
/*     */     }
/* 894 */     if (this == BlockRegistry.pamtomatoCrop)
/*     */     {
/* 896 */       return ItemRegistry.tomatoItem;
/*     */     }
/*     */     
/* 899 */     if (this == BlockRegistry.pamcottonCrop)
/*     */     {
/* 901 */       return ItemRegistry.cottonItem;
/*     */     }
/*     */     
/* 904 */     if (this == BlockRegistry.pampineappleCrop)
/*     */     {
/* 906 */       return ItemRegistry.pineappleItem;
/*     */     }
/*     */     
/* 909 */     if (this == BlockRegistry.pamkiwiCrop)
/*     */     {
/* 911 */       return ItemRegistry.kiwiItem;
/*     */     }
/* 913 */     if (this == BlockRegistry.pamcurryleafCrop)
/*     */     {
/* 915 */       return ItemRegistry.curryleafItem;
/*     */     }
/* 917 */     if (this == BlockRegistry.pamsesameseedsCrop)
/*     */     {
/* 919 */       return ItemRegistry.sesameseedsItem;
/*     */     }
/*     */     
/* 922 */     if (this == BlockRegistry.pamcranberryCrop)
/*     */     {
/* 924 */       return ItemRegistry.cranberryItem;
/*     */     }
/* 926 */     if (this == BlockRegistry.pamriceCrop)
/*     */     {
/* 928 */       return ItemRegistry.riceItem;
/*     */     }
/* 930 */     if (this == BlockRegistry.pamseaweedCrop)
/*     */     {
/* 932 */       return ItemRegistry.seaweedItem;
/*     */     }
/* 934 */     if (this == BlockRegistry.pamwaterchestnutCrop)
/*     */     {
/* 936 */       return ItemRegistry.waterchestnutItem;
/*     */     }
/* 938 */     return Items.wheat;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void registerBlockIcons(IIconRegister p_149651_1_)
/*     */   {
/* 946 */     this.field_149868_a = new IIcon[4];
/*     */     
/* 948 */     for (int i = 0; i < this.field_149868_a.length; i++)
/*     */     {
/* 950 */       this.field_149868_a[i] = p_149651_1_.registerIcon("harvestcraft:" + getTextureName() + "crop_" + i);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z)
/*     */   {
/* 957 */     if (BlockRegistry.enablecropspecialplanting)
/*     */     {
/* 959 */       if (this == BlockRegistry.pamcactusfruitCrop)
/*     */       {
/* 961 */         return EnumPlantType.Desert;
/*     */       }
/* 963 */       if (this == BlockRegistry.pamriceCrop)
/*     */       {
/* 965 */         return EnumPlantType.Water;
/*     */       }
/* 967 */       if (this == BlockRegistry.pamcranberryCrop)
/*     */       {
/* 969 */         return EnumPlantType.Water;
/*     */       }
/* 971 */       if (this == BlockRegistry.pamseaweedCrop)
/*     */       {
/* 973 */         return EnumPlantType.Water;
/*     */       }
/* 975 */       if (this == BlockRegistry.pamwaterchestnutCrop)
/*     */       {
/* 977 */         return EnumPlantType.Water;
/*     */       }
/*     */     }
/*     */     
/* 981 */     return EnumPlantType.Crop;
/*     */   }
/*     */   
/*     */ 
/*     */   public Block getPlant(IBlockAccess world, int x, int y, int z)
/*     */   {
/* 987 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getPlantMetadata(IBlockAccess world, int x, int y, int z)
/*     */   {
/* 993 */     return world.getBlockMetadata(x, y, z);
/*     */   }
/*     */ }


/* Location:              C:\Users\Modding\Desktop\Pam's HarvestCraft 1.7.10k.deobf.jar!\com\pam\harvestcraft\BlockPamCrop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */