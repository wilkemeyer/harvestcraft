/*     */ package com.pam.harvestcraft;
/*     */ 
/*     */ import cpw.mods.fml.common.FMLCommonHandler;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.item.EntityXPOrb;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.inventory.Slot;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.stats.AchievementList;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class SlotChurn extends Slot
/*     */ {
/*     */   private EntityPlayer thePlayer;
/*     */   private int field_75228_b;
/*     */   private static final String __OBFID = "CL_00001749";
/*     */   
/*     */   public SlotChurn(EntityPlayer p_i1813_1_, IInventory p_i1813_2_, int p_i1813_3_, int p_i1813_4_, int p_i1813_5_)
/*     */   {
/*  22 */     super(p_i1813_2_, p_i1813_3_, p_i1813_4_, p_i1813_5_);
/*  23 */     this.thePlayer = p_i1813_1_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isItemValid(ItemStack p_75214_1_)
/*     */   {
/*  31 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public ItemStack decrStackSize(int p_75209_1_)
/*     */   {
/*  40 */     if (getHasStack())
/*     */     {
/*  42 */       this.field_75228_b += Math.min(p_75209_1_, getStack().stackSize);
/*     */     }
/*     */     
/*  45 */     return super.decrStackSize(p_75209_1_);
/*     */   }
/*     */   
/*     */   public void onPickupFromSlot(EntityPlayer p_82870_1_, ItemStack p_82870_2_)
/*     */   {
/*  50 */     onCrafting(p_82870_2_);
/*  51 */     super.onPickupFromSlot(p_82870_1_, p_82870_2_);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void onCrafting(ItemStack p_75210_1_, int p_75210_2_)
/*     */   {
/*  60 */     this.field_75228_b += p_75210_2_;
/*  61 */     onCrafting(p_75210_1_);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void onCrafting(ItemStack p_75208_1_)
/*     */   {
/*  69 */     p_75208_1_.onCrafting(this.thePlayer.worldObj, this.thePlayer, this.field_75228_b);
/*     */     
/*  71 */     if (!this.thePlayer.worldObj.isRemote)
/*     */     {
/*  73 */       int i = this.field_75228_b;
/*  74 */       float f = ChurnRecipes.smelting().func_151398_b(p_75208_1_);
/*     */       
/*     */ 
/*  77 */       if (f == 0.0F)
/*     */       {
/*  79 */         i = 0;
/*     */       }
/*  81 */       else if (f < 1.0F)
/*     */       {
/*  83 */         int j = net.minecraft.util.MathHelper.floor_float(i * f);
/*     */         
/*  85 */         if ((j < net.minecraft.util.MathHelper.ceiling_float_int(i * f)) && ((float)Math.random() < i * f - j))
/*     */         {
/*  87 */           j++;
/*     */         }
/*     */         
/*  90 */         i = j;
/*     */       }
/*     */       
/*  93 */       while (i > 0)
/*     */       {
/*  95 */         int j = EntityXPOrb.getXPSplit(i);
/*  96 */         i -= j;
/*  97 */         this.thePlayer.worldObj.spawnEntityInWorld(new EntityXPOrb(this.thePlayer.worldObj, this.thePlayer.posX, this.thePlayer.posY + 0.5D, this.thePlayer.posZ + 0.5D, j));
/*     */       }
/*     */     }
/*     */     
/* 101 */     this.field_75228_b = 0;
/*     */     
/* 103 */     FMLCommonHandler.instance().firePlayerSmeltedEvent(this.thePlayer, p_75208_1_);
/*     */     
/* 105 */     if (p_75208_1_.getItem() == Items.iron_ingot)
/*     */     {
/* 107 */       this.thePlayer.addStat(AchievementList.acquireIron, 1);
/*     */     }
/*     */     
/* 110 */     if (p_75208_1_.getItem() == Items.cooked_fished)
/*     */     {
/* 112 */       this.thePlayer.addStat(AchievementList.cookFish, 1);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Modding\Desktop\Pam's HarvestCraft 1.7.10k.deobf.jar!\com\pam\harvestcraft\SlotChurn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */