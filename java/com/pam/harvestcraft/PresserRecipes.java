/*     */ package com.pam.harvestcraft;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PresserRecipes
/*     */ {
/*  18 */   private static final PresserRecipes smeltingBase = new PresserRecipes();
/*     */   
/*     */ 
/*     */ 
/*  22 */   private Map smeltingList = new HashMap();
/*  23 */   private Map experienceList = new HashMap();
/*     */   
/*     */ 
/*     */   private static final String __OBFID = "CL_00000085";
/*     */   
/*     */ 
/*     */   public static PresserRecipes smelting()
/*     */   {
/*  31 */     return smeltingBase;
/*     */   }
/*     */   
/*     */   private PresserRecipes()
/*     */   {
/*  36 */     func_151396_a(ItemRegistry.waxcombItem, new ItemStack(ItemRegistry.beeswaxItem), 0.0F);
/*  37 */     func_151396_a(Items.reeds, new ItemStack(Items.sugar), 0.0F);
/*  38 */     func_151393_a(Blocks.log, new ItemStack(Items.paper), 0.0F);
/*  39 */     func_151396_a(ItemRegistry.honeycombItem, new ItemStack(ItemRegistry.honeyItem), 0.0F);
/*     */     
/*  41 */     func_151396_a(Items.apple, new ItemStack(ItemRegistry.applejuiceItem), 0.0F);
/*  42 */     func_151396_a(ItemRegistry.blackberryItem, new ItemStack(ItemRegistry.blackberryjuiceItem), 0.0F);
/*  43 */     func_151396_a(ItemRegistry.blueberryItem, new ItemStack(ItemRegistry.blueberryjuiceItem), 0.0F);
/*  44 */     func_151396_a(ItemRegistry.cactusfruitItem, new ItemStack(ItemRegistry.cactusfruitjuiceItem), 0.0F);
/*  45 */     func_151396_a(ItemRegistry.cherryItem, new ItemStack(ItemRegistry.cherryjuiceItem), 0.0F);
/*  46 */     func_151396_a(ItemRegistry.cranberryItem, new ItemStack(ItemRegistry.cranberryjuiceItem), 0.0F);
/*  47 */     func_151396_a(ItemRegistry.grapeItem, new ItemStack(ItemRegistry.grapejuiceItem), 0.0F);
/*  48 */     func_151396_a(ItemRegistry.kiwiItem, new ItemStack(ItemRegistry.kiwijuiceItem), 0.0F);
/*  49 */     func_151396_a(ItemRegistry.limeItem, new ItemStack(ItemRegistry.limejuiceItem), 0.0F);
/*  50 */     func_151396_a(ItemRegistry.mangoItem, new ItemStack(ItemRegistry.mangojuiceItem), 0.0F);
/*  51 */     func_151396_a(ItemRegistry.oliveItem, new ItemStack(ItemRegistry.oliveoilItem), 0.0F);
/*  52 */     func_151396_a(ItemRegistry.sunflowerseedsItem, new ItemStack(ItemRegistry.oliveoilItem), 0.0F);
/*  53 */     func_151396_a(ItemRegistry.walnutItem, new ItemStack(ItemRegistry.oliveoilItem), 0.0F);
/*  54 */     func_151396_a(ItemRegistry.orangeItem, new ItemStack(ItemRegistry.orangejuiceItem), 0.0F);
/*  55 */     func_151396_a(ItemRegistry.papayaItem, new ItemStack(ItemRegistry.papayajuiceItem), 0.0F);
/*  56 */     func_151396_a(ItemRegistry.peachItem, new ItemStack(ItemRegistry.peachjuiceItem), 0.0F);
/*  57 */     func_151396_a(ItemRegistry.pomegranateItem, new ItemStack(ItemRegistry.pomegranatejuiceItem), 0.0F);
/*  58 */     func_151396_a(ItemRegistry.starfruitItem, new ItemStack(ItemRegistry.starfruitjuiceItem), 0.0F);
/*  59 */     func_151396_a(ItemRegistry.strawberryItem, new ItemStack(ItemRegistry.strawberryjuiceItem), 0.0F);
/*  60 */     func_151396_a(Items.reeds, new ItemStack(Items.sugar), 0.0F);
/*  61 */     func_151396_a(ItemRegistry.beetItem, new ItemStack(Items.sugar), 0.0F);
/*  62 */     func_151393_a(Blocks.log, new ItemStack(Items.paper), 0.0F);
/*  63 */     func_151396_a(ItemRegistry.freshwaterItem, new ItemStack(ItemRegistry.bubblywaterItem), 0.0F);
/*  64 */     func_151396_a(ItemRegistry.soybeanItem, new ItemStack(ItemRegistry.soymilkItem), 0.0F);
/*  65 */     func_151396_a(ItemRegistry.soymilkItem, new ItemStack(ItemRegistry.silkentofuItem), 0.0F);
/*  66 */     func_151396_a(ItemRegistry.silkentofuItem, new ItemStack(ItemRegistry.firmtofuItem), 0.0F);
/*  67 */     func_151396_a(ItemRegistry.plumItem, new ItemStack(ItemRegistry.plumjuiceItem), 0.0F);
/*  68 */     func_151396_a(ItemRegistry.pearItem, new ItemStack(ItemRegistry.pearjuiceItem), 0.0F);
/*     */     
/*  70 */     func_151396_a(ItemRegistry.apricotItem, new ItemStack(ItemRegistry.apricotjuiceItem), 0.0F);
/*  71 */     func_151396_a(ItemRegistry.figItem, new ItemStack(ItemRegistry.figjuiceItem), 0.0F);
/*  72 */     func_151396_a(ItemRegistry.grapefruitItem, new ItemStack(ItemRegistry.grapefruitjuiceItem), 0.0F);
/*  73 */     func_151396_a(ItemRegistry.persimmonItem, new ItemStack(ItemRegistry.persimmonjuiceItem), 0.0F);
/*     */     
/*  75 */     func_151396_a(ItemRegistry.almondItem, new ItemStack(ItemRegistry.freshmilkItem), 0.0F);
/*     */     
/*  77 */     func_151396_a(ItemRegistry.sesameseedsItem, new ItemStack(ItemRegistry.oliveoilItem), 0.0F);
/*     */   }
/*     */   
/*     */ 
/*     */   public void func_151393_a(Block p_151393_1_, ItemStack p_151393_2_, float p_151393_3_)
/*     */   {
/*  83 */     func_151396_a(Item.getItemFromBlock(p_151393_1_), p_151393_2_, p_151393_3_);
/*     */   }
/*     */   
/*     */   public void func_151396_a(Item p_151396_1_, ItemStack p_151396_2_, float p_151396_3_)
/*     */   {
/*  88 */     func_151394_a(new ItemStack(p_151396_1_, 1, 32767), p_151396_2_, p_151396_3_);
/*     */   }
/*     */   
/*     */   public void func_151394_a(ItemStack p_151394_1_, ItemStack p_151394_2_, float p_151394_3_)
/*     */   {
/*  93 */     this.smeltingList.put(p_151394_1_, p_151394_2_);
/*  94 */     this.experienceList.put(p_151394_2_, Float.valueOf(p_151394_3_));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public ItemStack getSmeltingResult(ItemStack p_151395_1_)
/*     */   {
/* 102 */     Iterator iterator = this.smeltingList.entrySet().iterator();
/*     */     
/*     */     Map.Entry entry;
/*     */     do
/*     */     {
/* 107 */       if (!iterator.hasNext())
/*     */       {
/* 109 */         return null;
/*     */       }
/*     */       
/* 112 */       entry = (Map.Entry)iterator.next();
/*     */     }
/* 114 */     while (!func_151397_a(p_151395_1_, (ItemStack)entry.getKey()));
/*     */     
/* 116 */     return (ItemStack)entry.getValue();
/*     */   }
/*     */   
/*     */   private boolean func_151397_a(ItemStack p_151397_1_, ItemStack p_151397_2_)
/*     */   {
/* 121 */     return (p_151397_2_.getItem() == p_151397_1_.getItem()) && ((p_151397_2_.getItemDamage() == 32767) || (p_151397_2_.getItemDamage() == p_151397_1_.getItemDamage()));
/*     */   }
/*     */   
/*     */   public Map getSmeltingList()
/*     */   {
/* 126 */     return this.smeltingList;
/*     */   }
/*     */   
/*     */   public float func_151398_b(ItemStack p_151398_1_)
/*     */   {
/* 131 */     float ret = p_151398_1_.getItem().getSmeltingExperience(p_151398_1_);
/* 132 */     if (ret != -1.0F) { return ret;
/*     */     }
/* 134 */     Iterator iterator = this.experienceList.entrySet().iterator();
/*     */     
/*     */     Map.Entry entry;
/*     */     do
/*     */     {
/* 139 */       if (!iterator.hasNext())
/*     */       {
/* 141 */         return 0.0F;
/*     */       }
/*     */       
/* 144 */       entry = (Map.Entry)iterator.next();
/*     */     }
/* 146 */     while (!func_151397_a(p_151398_1_, (ItemStack)entry.getKey()));
/*     */     
/* 148 */     return ((Float)entry.getValue()).floatValue();
/*     */   }
/*     */ }


/* Location:              C:\Users\Modding\Desktop\Pam's HarvestCraft 1.7.10k.deobf.jar!\com\pam\harvestcraft\PresserRecipes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */