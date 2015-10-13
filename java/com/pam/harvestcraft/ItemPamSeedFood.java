/*     */ package com.pam.harvestcraft;
/*     */ 
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemFood;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.EnumPlantType;
/*     */ import net.minecraftforge.common.IPlantable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemPamSeedFood
/*     */   extends ItemFood
/*     */   implements IPlantable
/*     */ {
/*     */   private Block field_150908_b;
/*     */   private Block soilId;
/*     */   private static final String __OBFID = "CL_00000060";
/*     */   
/*     */   public ItemPamSeedFood(int p_i45351_1_, float p_i45351_2_, Block p_i45351_3_, Block p_i45351_4_)
/*     */   {
/*  26 */     super(p_i45351_1_, p_i45351_2_, false);
/*  27 */     this.field_150908_b = p_i45351_3_;
/*  28 */     this.soilId = p_i45351_4_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
/*     */   {
/*  37 */     if (ItemRegistry.enablecropitemsasseeds)
/*     */     {
/*  39 */       if (par7 != 1)
/*     */       {
/*  41 */         return false;
/*     */       }
/*  43 */       if ((par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack)) && (par2EntityPlayer.canPlayerEdit(par4, par5 + 1, par6, par7, par1ItemStack)))
/*     */       {
/*  45 */         boolean isWaterPlant = (this == ItemRegistry.cranberryItem) || (this == ItemRegistry.riceItem) || (this == ItemRegistry.seaweedItem) || (this == ItemRegistry.waterchestnutItem);
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*  50 */         if ((isWaterPlant) && (BlockRegistry.enablecropspecialplanting))
/*     */         {
/*  52 */           if ((par3World.getBlock(par4, par5 + 1, par6).getMaterial() == Material.water) && (par3World.getBlockMetadata(par4, par5 + 1, par6) == 0) && (par3World.isAirBlock(par4, par5 + 2, par6)))
/*     */           {
/*     */ 
/*     */ 
/*  56 */             par3World.setBlock(par4, par5 + 2, par6, this.field_150908_b);
/*  57 */             par1ItemStack.stackSize -= 1;
/*  58 */             return true;
/*     */           }
/*  60 */         } else if ((par3World.getBlock(par4, par5, par6) == this.soilId) && (par3World.isAirBlock(par4, par5 + 1, par6)))
/*     */         {
/*  62 */           par3World.setBlock(par4, par5 + 1, par6, this.field_150908_b);
/*  63 */           par1ItemStack.stackSize -= 1;
/*  64 */           return true;
/*     */         }
/*     */       }
/*     */     }
/*  68 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z)
/*     */   {
/*  74 */     if (BlockRegistry.enablecropspecialplanting)
/*     */     {
/*  76 */       if (this == ItemRegistry.cactusfruitItem)
/*     */       {
/*  78 */         return EnumPlantType.Desert;
/*     */       }
/*  80 */       if (this == ItemRegistry.cranberryItem)
/*     */       {
/*  82 */         return EnumPlantType.Water;
/*     */       }
/*  84 */       if (this == ItemRegistry.riceItem)
/*     */       {
/*  86 */         return EnumPlantType.Water;
/*     */       }
/*  88 */       if (this == ItemRegistry.seaweedItem)
/*     */       {
/*  90 */         return EnumPlantType.Water;
/*     */       }
/*  92 */       if (this == ItemRegistry.waterchestnutItem)
/*     */       {
/*  94 */         return EnumPlantType.Water;
/*     */       }
/*     */     }
/*  97 */     return EnumPlantType.Crop;
/*     */   }
/*     */   
/*     */ 
/*     */   public Block getPlant(IBlockAccess world, int x, int y, int z)
/*     */   {
/* 103 */     return this.field_150908_b;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getPlantMetadata(IBlockAccess world, int x, int y, int z)
/*     */   {
/* 109 */     return 0;
/*     */   }
/*     */ }


/* Location:              C:\Users\Modding\Desktop\Pam's HarvestCraft 1.7.10k.deobf.jar!\com\pam\harvestcraft\ItemPamSeedFood.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */