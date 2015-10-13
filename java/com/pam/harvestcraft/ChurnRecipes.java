/*     */ package com.pam.harvestcraft;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ChurnRecipes
/*     */ {
/*  18 */   private static final ChurnRecipes smeltingBase = new ChurnRecipes();
/*     */   
/*  20 */   private Map smeltingList = new HashMap();
/*  21 */   private Map experienceList = new HashMap();
/*     */   
/*     */ 
/*     */   private static final String __OBFID = "CL_00000085";
/*     */   
/*     */ 
/*     */   public static ChurnRecipes smelting()
/*     */   {
/*  29 */     return smeltingBase;
/*     */   }
/*     */   
/*     */   private ChurnRecipes()
/*     */   {
/*  34 */     func_151396_a(ItemRegistry.freshmilkItem, new ItemStack(ItemRegistry.butterItem), 0.1F);
/*     */   }
/*     */   
/*     */ 
/*     */   public void func_151393_a(Block p_151393_1_, ItemStack p_151393_2_, float p_151393_3_)
/*     */   {
/*  40 */     func_151396_a(Item.getItemFromBlock(p_151393_1_), p_151393_2_, p_151393_3_);
/*     */   }
/*     */   
/*     */   public void func_151396_a(Item p_151396_1_, ItemStack p_151396_2_, float p_151396_3_)
/*     */   {
/*  45 */     func_151394_a(new ItemStack(p_151396_1_, 1, 32767), p_151396_2_, p_151396_3_);
/*     */   }
/*     */   
/*     */   public void func_151394_a(ItemStack p_151394_1_, ItemStack p_151394_2_, float p_151394_3_)
/*     */   {
/*  50 */     this.smeltingList.put(p_151394_1_, p_151394_2_);
/*  51 */     this.experienceList.put(p_151394_2_, Float.valueOf(p_151394_3_));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public ItemStack getSmeltingResult(ItemStack p_151395_1_)
/*     */   {
/*  59 */     Iterator iterator = this.smeltingList.entrySet().iterator();
/*     */     
/*     */     Map.Entry entry;
/*     */     do
/*     */     {
/*  64 */       if (!iterator.hasNext())
/*     */       {
/*  66 */         return null;
/*     */       }
/*     */       
/*  69 */       entry = (Map.Entry)iterator.next();
/*     */     }
/*  71 */     while (!func_151397_a(p_151395_1_, (ItemStack)entry.getKey()));
/*     */     
/*  73 */     return (ItemStack)entry.getValue();
/*     */   }
/*     */   
/*     */   private boolean func_151397_a(ItemStack p_151397_1_, ItemStack p_151397_2_)
/*     */   {
/*  78 */     return (p_151397_2_.getItem() == p_151397_1_.getItem()) && ((p_151397_2_.getItemDamage() == 32767) || (p_151397_2_.getItemDamage() == p_151397_1_.getItemDamage()));
/*     */   }
/*     */   
/*     */   public Map getSmeltingList()
/*     */   {
/*  83 */     return this.smeltingList;
/*     */   }
/*     */   
/*     */   public float func_151398_b(ItemStack p_151398_1_)
/*     */   {
/*  88 */     float ret = p_151398_1_.getItem().getSmeltingExperience(p_151398_1_);
/*  89 */     if (ret != -1.0F) { return ret;
/*     */     }
/*  91 */     Iterator iterator = this.experienceList.entrySet().iterator();
/*     */     
/*     */     Map.Entry entry;
/*     */     do
/*     */     {
/*  96 */       if (!iterator.hasNext())
/*     */       {
/*  98 */         return 0.0F;
/*     */       }
/*     */       
/* 101 */       entry = (Map.Entry)iterator.next();
/*     */     }
/* 103 */     while (!func_151397_a(p_151398_1_, (ItemStack)entry.getKey()));
/*     */     
/* 105 */     return ((Float)entry.getValue()).floatValue();
/*     */   }
/*     */ }


/* Location:              C:\Users\Modding\Desktop\Pam's HarvestCraft 1.7.10k.deobf.jar!\com\pam\harvestcraft\ChurnRecipes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */