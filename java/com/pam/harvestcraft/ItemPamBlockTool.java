/*     */ package com.pam.harvestcraft;
/*     */ 
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.Block.SoundType;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemPamBlockTool
/*     */   extends Item
/*     */ {
/*     */   public final Block spawnID;
/*     */   
/*     */   public ItemPamBlockTool(Block par2Block)
/*     */   {
/*  21 */     setMaxStackSize(1);
/*  22 */     this.spawnID = par2Block;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean doesContainerItemLeaveCraftingGrid(ItemStack par1ItemStack)
/*     */   {
/*  28 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean placeBlockAt(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int metadata)
/*     */   {
/*  34 */     if (!world.setBlock(x, y, z, this.spawnID, metadata, 3))
/*     */     {
/*  36 */       return false;
/*     */     }
/*     */     
/*  39 */     if (world.getBlock(x, y, z) == this.spawnID)
/*     */     {
/*  41 */       this.spawnID.onBlockPlacedBy(world, x, y, z, player, stack);
/*  42 */       this.spawnID.onPostBlockPlaced(world, x, y, z, metadata);
/*     */     }
/*     */     
/*  45 */     return true;
/*     */   }
/*     */   
/*     */   public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
/*     */   {
/*  50 */     Block block = par3World.getBlock(par4, par5, par6);
/*     */     
/*  52 */     if ((block == Blocks.snow_layer) && ((par3World.getBlockMetadata(par4, par5, par6) & 0x7) < 1))
/*     */     {
/*  54 */       par7 = 1;
/*     */     }
/*  56 */     else if ((block != Blocks.vine) && (block != Blocks.tallgrass) && (block != Blocks.deadbush) && (!block.isReplaceable(par3World, par4, par5, par6)))
/*     */     {
/*  58 */       if (par7 == 0)
/*     */       {
/*  60 */         par5--;
/*     */       }
/*     */       
/*  63 */       if (par7 == 1)
/*     */       {
/*  65 */         par5++;
/*     */       }
/*     */       
/*  68 */       if (par7 == 2)
/*     */       {
/*  70 */         par6--;
/*     */       }
/*     */       
/*  73 */       if (par7 == 3)
/*     */       {
/*  75 */         par6++;
/*     */       }
/*     */       
/*  78 */       if (par7 == 4)
/*     */       {
/*  80 */         par4--;
/*     */       }
/*     */       
/*  83 */       if (par7 == 5)
/*     */       {
/*  85 */         par4++;
/*     */       }
/*     */     }
/*     */     
/*  89 */     if (par1ItemStack.stackSize == 0)
/*     */     {
/*  91 */       return false;
/*     */     }
/*  93 */     if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack))
/*     */     {
/*  95 */       return false;
/*     */     }
/*  97 */     if ((par5 == 255) && (this.spawnID.getMaterial().isSolid()))
/*     */     {
/*  99 */       return false;
/*     */     }
/* 101 */     if (par3World.canPlaceEntityOnSide(this.spawnID, par4, par5, par6, false, par7, par2EntityPlayer, par1ItemStack))
/*     */     {
/* 103 */       int i1 = getMetadata(par1ItemStack.getItemDamage());
/* 104 */       int j1 = this.spawnID.onBlockPlaced(par3World, par4, par5, par6, par7, par8, par9, par10, i1);
/*     */       
/* 106 */       if (placeBlockAt(par1ItemStack, par2EntityPlayer, par3World, par4, par5, par6, par7, par8, par9, par10, j1))
/*     */       {
/* 108 */         par3World.playSoundEffect(par4 + 0.5F, par5 + 0.5F, par6 + 0.5F, this.spawnID.stepSound.func_150496_b(), (this.spawnID.stepSound.getVolume() + 1.0F) / 2.0F, this.spawnID.stepSound.getPitch() * 0.8F);
/* 109 */         par1ItemStack.stackSize -= 1;
/*     */       }
/*     */       
/* 112 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 116 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Modding\Desktop\Pam's HarvestCraft 1.7.10k.deobf.jar!\com\pam\harvestcraft\ItemPamBlockTool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */