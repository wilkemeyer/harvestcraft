/*     */ package com.pam.harvestcraft;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.block.BlockCake;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.FoodStats;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockPamCake
/*     */   extends BlockCake
/*     */ {
/*     */   private int Bites;
/*     */   
/*     */   public BlockPamCake(int Bites)
/*     */   {
/*  22 */     setTickRandomly(true);
/*  23 */     this.Bites = Bites;
/*     */   }
/*     */   
/*     */   public int Bites(int i)
/*     */   {
/*  28 */     return i;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setBlockBoundsBasedOnState(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_)
/*     */   {
/*  35 */     int l = p_149719_1_.getBlockMetadata(p_149719_2_, p_149719_3_, p_149719_4_);
/*  36 */     float f = 0.0625F;
/*  37 */     float f1 = (1 + l * 2) / 16.0F;
/*  38 */     float f2 = 0.5F;
/*  39 */     setBlockBounds(f1, 0.0F, f, 1.0F - f, f2, 1.0F - f);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBlockBoundsForItemRender()
/*     */   {
/*  47 */     float f = 0.0625F;
/*  48 */     float f1 = 0.5F;
/*  49 */     setBlockBounds(f, 0.0F, f, 1.0F - f, f1, 1.0F - f);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
/*     */   {
/*  58 */     int l = p_149668_1_.getBlockMetadata(p_149668_2_, p_149668_3_, p_149668_4_);
/*  59 */     float f = 0.0625F;
/*  60 */     float f1 = (1 + l * 2) / 16.0F;
/*  61 */     float f2 = 0.5F;
/*  62 */     return AxisAlignedBB.getBoundingBox(p_149668_2_ + f1, p_149668_3_, p_149668_4_ + f, p_149668_2_ + 1 - f, p_149668_3_ + f2 - f, p_149668_4_ + 1 - f);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public AxisAlignedBB getSelectedBoundingBoxFromPool(World p_149633_1_, int p_149633_2_, int p_149633_3_, int p_149633_4_)
/*     */   {
/*  71 */     int l = p_149633_1_.getBlockMetadata(p_149633_2_, p_149633_3_, p_149633_4_);
/*  72 */     float f = 0.0625F;
/*  73 */     float f1 = (1 + l * 2) / 16.0F;
/*  74 */     float f2 = 0.5F;
/*  75 */     return AxisAlignedBB.getBoundingBox(p_149633_2_ + f1, p_149633_3_, p_149633_4_ + f, p_149633_2_ + 1 - f, p_149633_3_ + f2, p_149633_4_ + 1 - f);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean onBlockActivated(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_)
/*     */   {
/*  83 */     func_150036_b(p_149727_1_, p_149727_2_, p_149727_3_, p_149727_4_, p_149727_5_);
/*  84 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onBlockClicked(World p_149699_1_, int p_149699_2_, int p_149699_3_, int p_149699_4_, EntityPlayer p_149699_5_)
/*     */   {
/*  92 */     func_150036_b(p_149699_1_, p_149699_2_, p_149699_3_, p_149699_4_, p_149699_5_);
/*     */   }
/*     */   
/*     */   private void func_150036_b(World p_150036_1_, int p_150036_2_, int p_150036_3_, int p_150036_4_, EntityPlayer p_150036_5_)
/*     */   {
/*  97 */     if (p_150036_5_.canEat(false))
/*     */     {
/*  99 */       p_150036_5_.getFoodStats().addStats(2, 0.1F);
/* 100 */       int l = p_150036_1_.getBlockMetadata(p_150036_2_, p_150036_3_, p_150036_4_) + 1;
/*     */       
/* 102 */       if (l >= this.Bites)
/*     */       {
/* 104 */         p_150036_1_.setBlockToAir(p_150036_2_, p_150036_3_, p_150036_4_);
/*     */       }
/*     */       else
/*     */       {
/* 108 */         p_150036_1_.setBlockMetadataWithNotify(p_150036_2_, p_150036_3_, p_150036_4_, l, 2);
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Modding\Desktop\Pam's HarvestCraft 1.7.10k.deobf.jar!\com\pam\harvestcraft\BlockPamCake.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */