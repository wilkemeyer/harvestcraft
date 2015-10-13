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
import net.minecraft.item.ItemFishFood;
/*     */ import net.minecraft.item.ItemFishFood.FishType;
/*     */ import net.minecraft.item.ItemStack;
/*     */ 
/*     */ 
/*     */ public class OvenRecipes
/*     */ {
/*  18 */   private static final OvenRecipes smeltingBase = new OvenRecipes();
/*     */   
/*  20 */   private Map smeltingList = new HashMap();
/*  21 */   private Map experienceList = new HashMap();
/*     */   
/*     */ 
/*     */   private static final String __OBFID = "CL_00000085";
/*     */   
/*     */ 
/*     */   public static OvenRecipes smelting()
/*     */   {
/*  29 */     return smeltingBase;
/*     */   }
/*     */   
/*     */   private OvenRecipes()
/*     */   {
/*  34 */     func_151396_a(Items.porkchop, new ItemStack(Items.cooked_porkchop), 0.1F);
/*  35 */     func_151396_a(Items.beef, new ItemStack(Items.cooked_beef), 0.1F);
/*  36 */     func_151396_a(Items.chicken, new ItemStack(Items.cooked_chicken), 0.1F);
/*  37 */     func_151393_a(Blocks.cactus, new ItemStack(Items.dye, 1, 2), 0.1F);
/*  38 */     func_151396_a(Items.potato, new ItemStack(Items.baked_potato), 0.1F);
/*  39 */     func_151396_a(ItemRegistry.doughItem, new ItemStack(Items.bread, 1, 0), 0.1F);
/*  40 */     func_151396_a(Items.bread, new ItemStack(ItemRegistry.toastItem, 1, 0), 0.1F);
/*  41 */     func_151396_a(Items.pumpkin_seeds, new ItemStack(ItemRegistry.roastedpumpkinseedsItem, 1, 0), 0.1F);
/*  42 */     func_151393_a(Blocks.brown_mushroom, new ItemStack(ItemRegistry.grilledmushroomItem, 1, 0), 0.1F);
/*  43 */     func_151393_a(Blocks.red_mushroom, new ItemStack(ItemRegistry.grilledmushroomItem, 1, 0), 0.1F);
/*     */     
/*  45 */     func_151396_a(ItemRegistry.muttonrawItem, new ItemStack(ItemRegistry.muttoncookedItem, 1, 0), 0.1F);
/*  46 */     func_151396_a(ItemRegistry.calamarirawItem, new ItemStack(ItemRegistry.calamaricookedItem, 1, 0), 0.1F);
/*  47 */     func_151396_a(ItemRegistry.turkeyrawItem, new ItemStack(ItemRegistry.turkeycookedItem, 1, 0), 0.1F);
/*  48 */     func_151396_a(ItemRegistry.rabbitrawItem, new ItemStack(ItemRegistry.rabbitcookedItem, 1, 0), 0.1F);
/*  49 */     func_151396_a(ItemRegistry.venisonrawItem, new ItemStack(ItemRegistry.venisoncookedItem, 1, 0), 0.1F);
/*     */     
/*  51 */     func_151396_a(ItemRegistry.asparagusItem, new ItemStack(ItemRegistry.grilledasparagusItem, 1, 0), 0.1F);
/*  52 */     func_151396_a(ItemRegistry.riceItem, new ItemStack(ItemRegistry.ricecakeItem, 1, 0), 0.1F);
/*  53 */     func_151396_a(ItemRegistry.tealeafItem, new ItemStack(ItemRegistry.teaItem, 1, 0), 0.1F);
/*  54 */     func_151396_a(ItemRegistry.cornItem, new ItemStack(ItemRegistry.popcornItem, 1, 0), 0.1F);
/*  55 */     func_151396_a(ItemRegistry.sweetpotatoItem, new ItemStack(ItemRegistry.bakedsweetpotatoItem, 1, 0), 0.1F);
/*  56 */     func_151396_a(ItemRegistry.coffeebeanItem, new ItemStack(ItemRegistry.coffeeItem, 1, 0), 0.1F);
/*  57 */     func_151396_a(ItemRegistry.eggplantItem, new ItemStack(ItemRegistry.grilledeggplantItem, 1, 0), 0.1F);
/*  58 */     func_151396_a(ItemRegistry.grapeItem, new ItemStack(ItemRegistry.raisinsItem, 1, 0), 0.1F);
/*  59 */     func_151396_a(ItemRegistry.whitemushroomItem, new ItemStack(ItemRegistry.grilledmushroomItem, 1, 0), 0.1F);
/*  60 */     func_151396_a(ItemRegistry.coconutItem, new ItemStack(ItemRegistry.toastedcoconutItem, 1, 0), 0.1F);
/*  61 */     func_151396_a(ItemRegistry.vanillabeanItem, new ItemStack(ItemRegistry.vanillaItem, 1, 0), 0.1F);
/*  62 */     func_151396_a(ItemRegistry.chestnutItem, new ItemStack(ItemRegistry.roastedchestnutItem, 1, 0), 0.1F);
/*  63 */     func_151396_a(ItemRegistry.sesameseedsItem, new ItemStack(ItemRegistry.toastedsesameseedsItem, 1, 0), 0.1F);
/*  64 */     ItemFishFood.FishType[] afishtype = ItemFishFood.FishType.values();
/*  65 */     int i = afishtype.length;
/*     */     
/*  67 */     for (int j = 0; j < i; j++)
/*     */     {
/*  69 */       ItemFishFood.FishType fishtype = afishtype[j];
/*     */       
/*  71 */       if (fishtype.func_150973_i())
/*     */       {
/*  73 */         func_151394_a(new ItemStack(Items.fish, 1, fishtype.func_150976_a()), new ItemStack(Items.cooked_fished, 1, fishtype.func_150976_a()), 0.35F);
/*     */       }
/*     */     }
/*     */     
/*  77 */     func_151396_a(ItemRegistry.anchovyrawItem, new ItemStack(Items.cooked_fished, 1, 0), 0.1F);
/*  78 */     func_151396_a(ItemRegistry.bassrawItem, new ItemStack(Items.cooked_fished, 1, 0), 0.1F);
/*  79 */     func_151396_a(ItemRegistry.carprawItem, new ItemStack(Items.cooked_fished, 1, 0), 0.1F);
/*  80 */     func_151396_a(ItemRegistry.catfishrawItem, new ItemStack(Items.cooked_fished, 1, 0), 0.1F);
/*  81 */     func_151396_a(ItemRegistry.charrrawItem, new ItemStack(Items.cooked_fished, 1, 0), 0.1F);
/*  82 */     func_151396_a(ItemRegistry.eelrawItem, new ItemStack(Items.cooked_fished, 1, 0), 0.1F);
/*  83 */     func_151396_a(ItemRegistry.grouperrawItem, new ItemStack(Items.cooked_fished, 1, 0), 0.1F);
/*  84 */     func_151396_a(ItemRegistry.herringrawItem, new ItemStack(Items.cooked_fished, 1, 0), 0.1F);
/*  85 */     func_151396_a(ItemRegistry.mudfishrawItem, new ItemStack(Items.cooked_fished, 1, 0), 0.1F);
/*  86 */     func_151396_a(ItemRegistry.perchrawItem, new ItemStack(Items.cooked_fished, 1, 0), 0.1F);
/*  87 */     func_151396_a(ItemRegistry.snapperrawItem, new ItemStack(Items.cooked_fished, 1, 0), 0.1F);
/*  88 */     func_151396_a(ItemRegistry.tilapiarawItem, new ItemStack(Items.cooked_fished, 1, 0), 0.1F);
/*  89 */     func_151396_a(ItemRegistry.troutrawItem, new ItemStack(Items.cooked_fished, 1, 0), 0.1F);
/*  90 */     func_151396_a(ItemRegistry.tunarawItem, new ItemStack(Items.cooked_fished, 1, 0), 0.1F);
/*  91 */     func_151396_a(ItemRegistry.walleyerawItem, new ItemStack(Items.cooked_fished, 1, 0), 0.1F);
/*     */     
/*  93 */     func_151396_a(ItemRegistry.clamrawItem, new ItemStack(ItemRegistry.clamcookedItem, 1, 0), 0.1F);
/*  94 */     func_151396_a(ItemRegistry.crabrawItem, new ItemStack(ItemRegistry.crabcookedItem, 1, 0), 0.1F);
/*  95 */     func_151396_a(ItemRegistry.crayfishrawItem, new ItemStack(ItemRegistry.crayfishcookedItem, 1, 0), 0.1F);
/*  96 */     func_151396_a(ItemRegistry.frograwItem, new ItemStack(ItemRegistry.frogcookedItem, 1, 0), 0.1F);
/*  97 */     func_151396_a(ItemRegistry.octopusrawItem, new ItemStack(ItemRegistry.octopuscookedItem, 1, 0), 0.1F);
/*  98 */     func_151396_a(ItemRegistry.scalloprawItem, new ItemStack(ItemRegistry.scallopcookedItem, 1, 0), 0.1F);
/*  99 */     func_151396_a(ItemRegistry.shrimprawItem, new ItemStack(ItemRegistry.shrimpcookedItem, 1, 0), 0.1F);
/* 100 */     func_151396_a(ItemRegistry.snailrawItem, new ItemStack(ItemRegistry.snailcookedItem, 1, 0), 0.1F);
/* 101 */     func_151396_a(ItemRegistry.turtlerawItem, new ItemStack(ItemRegistry.turtlecookedItem, 1, 0), 0.1F);
/*     */   }
/*     */   
/*     */   public void func_151393_a(Block p_151393_1_, ItemStack p_151393_2_, float p_151393_3_)
/*     */   {
/* 106 */     func_151396_a(Item.getItemFromBlock(p_151393_1_), p_151393_2_, p_151393_3_);
/*     */   }
/*     */   
/*     */   public void func_151396_a(Item p_151396_1_, ItemStack p_151396_2_, float p_151396_3_)
/*     */   {
/* 111 */     func_151394_a(new ItemStack(p_151396_1_, 1, 32767), p_151396_2_, p_151396_3_);
/*     */   }
/*     */   
/*     */   public void func_151394_a(ItemStack p_151394_1_, ItemStack p_151394_2_, float p_151394_3_)
/*     */   {
/* 116 */     this.smeltingList.put(p_151394_1_, p_151394_2_);
/* 117 */     this.experienceList.put(p_151394_2_, Float.valueOf(p_151394_3_));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public ItemStack getSmeltingResult(ItemStack p_151395_1_)
/*     */   {
/* 125 */     Iterator iterator = this.smeltingList.entrySet().iterator();
/*     */     
/*     */     Map.Entry entry;
/*     */     do
/*     */     {
/* 130 */       if (!iterator.hasNext())
/*     */       {
/* 132 */         return null;
/*     */       }
/*     */       
/* 135 */       entry = (Map.Entry)iterator.next();
/*     */     }
/* 137 */     while (!func_151397_a(p_151395_1_, (ItemStack)entry.getKey()));
/*     */     
/* 139 */     return (ItemStack)entry.getValue();
/*     */   }
/*     */   
/*     */   private boolean func_151397_a(ItemStack p_151397_1_, ItemStack p_151397_2_)
/*     */   {
/* 144 */     return (p_151397_2_.getItem() == p_151397_1_.getItem()) && ((p_151397_2_.getItemDamage() == 32767) || (p_151397_2_.getItemDamage() == p_151397_1_.getItemDamage()));
/*     */   }
/*     */   
/*     */   public Map getSmeltingList()
/*     */   {
/* 149 */     return this.smeltingList;
/*     */   }
/*     */   
/*     */   public float func_151398_b(ItemStack p_151398_1_)
/*     */   {
/* 154 */     float ret = p_151398_1_.getItem().getSmeltingExperience(p_151398_1_);
/* 155 */     if (ret != -1.0F) { return ret;
/*     */     }
/* 157 */     Iterator iterator = this.experienceList.entrySet().iterator();
/*     */     
/*     */     Map.Entry entry;
/*     */     do
/*     */     {
/* 162 */       if (!iterator.hasNext())
/*     */       {
/* 164 */         return 0.0F;
/*     */       }
/*     */       
/* 167 */       entry = (Map.Entry)iterator.next();
/*     */     }
/* 169 */     while (!func_151397_a(p_151398_1_, (ItemStack)entry.getKey()));
/*     */     
/* 171 */     return ((Float)entry.getValue()).floatValue();
/*     */   }
/*     */ }


/* Location:              C:\Users\Modding\Desktop\Pam's HarvestCraft 1.7.10k.deobf.jar!\com\pam\harvestcraft\OvenRecipes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */