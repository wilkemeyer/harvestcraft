/*     */ package com.pam.harvestcraft;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class QuernRecipes
/*     */ {
/*  18 */   private static final QuernRecipes smeltingBase = new QuernRecipes();
/*     */   
/*  20 */   private Map smeltingList = new HashMap();
/*  21 */   private Map experienceList = new HashMap();
/*     */   
/*     */ 
/*     */   private static final String __OBFID = "CL_00000085";
/*     */   
/*     */ 
/*     */   public static QuernRecipes smelting()
/*     */   {
/*  29 */     return smeltingBase;
/*     */   }
/*     */   
/*     */   private QuernRecipes()
/*     */   {
/*  34 */     func_151396_a(Items.wheat, new ItemStack(ItemRegistry.flourItem), 0.1F);
/*  35 */     func_151396_a(Items.potato, new ItemStack(ItemRegistry.flourItem), 0.1F);
/*  36 */     func_151396_a(ItemRegistry.riceItem, new ItemStack(ItemRegistry.flourItem), 0.1F);
/*  37 */     func_151396_a(ItemRegistry.barleyItem, new ItemStack(ItemRegistry.flourItem), 0.1F);
/*  38 */     func_151396_a(ItemRegistry.oatsItem, new ItemStack(ItemRegistry.flourItem), 0.1F);
/*  39 */     func_151396_a(ItemRegistry.ryeItem, new ItemStack(ItemRegistry.flourItem), 0.1F);
/*     */     
/*  41 */     func_151399_a(new ItemStack(Items.dye, 0, 3), new ItemStack(ItemRegistry.cocoapowderItem), 0.1F);
/*  42 */     func_151396_a(ItemRegistry.cinnamonItem, new ItemStack(ItemRegistry.groundcinnamonItem), 0.1F);
/*  43 */     func_151396_a(ItemRegistry.nutmegItem, new ItemStack(ItemRegistry.groundnutmegItem), 0.1F);
/*  44 */     func_151396_a(ItemRegistry.peppercornItem, new ItemStack(ItemRegistry.blackpepperItem), 0.1F);
/*  45 */     func_151396_a(ItemRegistry.curryleafItem, new ItemStack(ItemRegistry.currypowderItem), 0.1F);
/*     */   }
/*     */   
/*     */ 
/*     */   public void func_151393_a(Block p_151393_1_, ItemStack p_151393_2_, float p_151393_3_)
/*     */   {
/*  51 */     func_151396_a(Item.getItemFromBlock(p_151393_1_), p_151393_2_, p_151393_3_);
/*     */   }
/*     */   
/*     */   public void func_151396_a(Item p_151396_1_, ItemStack p_151396_2_, float p_151396_3_)
/*     */   {
/*  56 */     func_151394_a(new ItemStack(p_151396_1_, 1, 32767), p_151396_2_, p_151396_3_);
/*     */   }
/*     */   
/*     */   public void func_151399_a(ItemStack p_151396_1_, ItemStack p_151396_2_, float p_151396_3_)
/*     */   {
/*  61 */     func_151394_a(p_151396_1_, p_151396_2_, p_151396_3_);
/*     */   }
/*     */   
/*     */   public void func_151394_a(ItemStack p_151394_1_, ItemStack p_151394_2_, float p_151394_3_)
/*     */   {
/*  66 */     this.smeltingList.put(p_151394_1_, p_151394_2_);
/*  67 */     this.experienceList.put(p_151394_2_, Float.valueOf(p_151394_3_));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public ItemStack getSmeltingResult(ItemStack p_151395_1_)
/*     */   {
/*  75 */     Iterator iterator = this.smeltingList.entrySet().iterator();
/*     */     
/*     */     Map.Entry entry;
/*     */     do
/*     */     {
/*  80 */       if (!iterator.hasNext())
/*     */       {
/*  82 */         return null;
/*     */       }
/*     */       
/*  85 */       entry = (Map.Entry)iterator.next();
/*     */     }
/*  87 */     while (!func_151397_a(p_151395_1_, (ItemStack)entry.getKey()));
/*     */     
/*  89 */     return (ItemStack)entry.getValue();
/*     */   }
/*     */   
/*     */   private boolean func_151397_a(ItemStack p_151397_1_, ItemStack p_151397_2_)
/*     */   {
/*  94 */     return (p_151397_2_.getItem() == p_151397_1_.getItem()) && ((p_151397_2_.getItemDamage() == 32767) || (p_151397_2_.getItemDamage() == p_151397_1_.getItemDamage()));
/*     */   }
/*     */   
/*     */   public Map getSmeltingList()
/*     */   {
/*  99 */     return this.smeltingList;
/*     */   }
/*     */   
/*     */   public float func_151398_b(ItemStack p_151398_1_)
/*     */   {
/* 104 */     float ret = p_151398_1_.getItem().getSmeltingExperience(p_151398_1_);
/* 105 */     if (ret != -1.0F) { return ret;
/*     */     }
/* 107 */     Iterator iterator = this.experienceList.entrySet().iterator();
/*     */     
/*     */     Map.Entry entry;
/*     */     do
/*     */     {
/* 112 */       if (!iterator.hasNext())
/*     */       {
/* 114 */         return 0.0F;
/*     */       }
/*     */       
/* 117 */       entry = (Map.Entry)iterator.next();
/*     */     }
/* 119 */     while (!func_151397_a(p_151398_1_, (ItemStack)entry.getKey()));
/*     */     
/* 121 */     return ((Float)entry.getValue()).floatValue();
/*     */   }
/*     */ }


/* Location:              C:\Users\Modding\Desktop\Pam's HarvestCraft 1.7.10k.deobf.jar!\com\pam\harvestcraft\QuernRecipes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */