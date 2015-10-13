/*     */ package com.pam.harvestcraft;
/*     */ 
/*     */ import java.util.List;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.item.crafting.CraftingManager;
/*     */ import net.minecraftforge.oredict.ShapelessOreRecipe;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PamFoodFishingCraftRecipes
/*     */ {
/*     */   public static void getRecipes()
/*     */   {
/*  15 */     CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.fishsandwichItem, new Object[] { "toolSkillet", "FC.Salmon", "foodMayo", Items.bread }));
/*  16 */     CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.fishsticksItem, new Object[] { "toolBakeware", "FC.Salmon", "foodFlour" }));
/*  17 */     CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.stockItem, new Object[] { "toolPot", "FC.Salmon", "toolMixingbowl" }));
/*  18 */     CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(ItemRegistry.fishdinnerItem, 1), new Object[] { "toolSkillet", "cropLemon", "foodFlour", "FC.Salmon", "foodMayo" }));
/*  19 */     CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.sushiItem, new Object[] { "toolCuttingboard", "FC.Salmon", "cropRice" }));
/*     */     
/*  21 */     CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.fishlettucewrapItem, new Object[] { "toolCuttingboard", "cropLettuce", "FC.SalmonCooked" }));
/*  22 */     CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.fishtacoItem, new Object[] { "FC.SalmonCooked", "cropLettuce", "foodCheese", "foodTortilla" }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  27 */     CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.fishsandwichItem, new Object[] { "toolSkillet", "FC.Catfish", "foodMayo", Items.bread }));
/*  28 */     CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.fishsticksItem, new Object[] { "toolBakeware", "FC.Catfish", "foodFlour" }));
/*  29 */     CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.stockItem, new Object[] { "toolPot", "FC.Catfish", "toolMixingbowl" }));
/*  30 */     CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(ItemRegistry.fishdinnerItem, 1), new Object[] { "toolSkillet", "cropLemon", "foodFlour", "FC.Catfish", "foodMayo" }));
/*  31 */     CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.sushiItem, new Object[] { "toolCuttingboard", "FC.Catfish", "cropRice" }));
/*     */     
/*  33 */     CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.fishlettucewrapItem, new Object[] { "toolCuttingboard", "cropLettuce", "FC.CatfishCooked" }));
/*  34 */     CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.fishtacoItem, new Object[] { "FC.CatfishCooked", "cropLettuce", "foodCheese", "foodTortilla" }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  39 */     CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.fishsandwichItem, new Object[] { "toolSkillet", "FC.Bluegill", "foodMayo", Items.bread }));
/*  40 */     CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.fishsticksItem, new Object[] { "toolBakeware", "FC.Bluegill", "foodFlour" }));
/*  41 */     CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.stockItem, new Object[] { "toolPot", "FC.Bluegill", "toolMixingbowl" }));
/*  42 */     CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(ItemRegistry.fishdinnerItem, 1), new Object[] { "toolSkillet", "cropLemon", "foodFlour", "FC.Bluegill", "foodMayo" }));
/*  43 */     CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.sushiItem, new Object[] { "toolCuttingboard", "FC.Bluegill", "cropRice" }));
/*     */     
/*  45 */     CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.fishlettucewrapItem, new Object[] { "toolCuttingboard", "cropLettuce", "FC.BluegillCooked" }));
/*  46 */     CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.fishtacoItem, new Object[] { "FC.BluegillCooked", "cropLettuce", "foodCheese", "foodTortilla" }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  51 */     CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.fishsandwichItem, new Object[] { "toolSkillet", "FC.Suckerfish", "foodMayo", Items.bread }));
/*  52 */     CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.fishsticksItem, new Object[] { "toolBakeware", "FC.Suckerfish", "foodFlour" }));
/*  53 */     CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.stockItem, new Object[] { "toolPot", "FC.Suckerfish", "toolMixingbowl" }));
/*  54 */     CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(ItemRegistry.fishdinnerItem, 1), new Object[] { "toolSkillet", "cropLemon", "foodFlour", "FC.Suckerfish", "foodMayo" }));
/*  55 */     CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.sushiItem, new Object[] { "toolCuttingboard", "FC.Suckerfish", "cropRice" }));
/*     */     
/*  57 */     CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.fishlettucewrapItem, new Object[] { "toolCuttingboard", "cropLettuce", "FC.SuckerfishCooked" }));
/*  58 */     CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.fishtacoItem, new Object[] { "FC.SuckerfishCooked", "cropLettuce", "foodCheese", "foodTortilla" }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  63 */     CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.fishsandwichItem, new Object[] { "toolSkillet", "FC.Carp", "foodMayo", Items.bread }));
/*  64 */     CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.fishsticksItem, new Object[] { "toolBakeware", "FC.Carp", "foodFlour" }));
/*  65 */     CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.stockItem, new Object[] { "toolPot", "FC.Carp", "toolMixingbowl" }));
/*  66 */     CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(ItemRegistry.fishdinnerItem, 1), new Object[] { "toolSkillet", "cropLemon", "foodFlour", "FC.Carp", "foodMayo" }));
/*  67 */     CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.sushiItem, new Object[] { "toolCuttingboard", "FC.Carp", "cropRice" }));
/*     */     
/*  69 */     CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.fishlettucewrapItem, new Object[] { "toolCuttingboard", "cropLettuce", "FC.CarpCooked" }));
/*  70 */     CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.fishtacoItem, new Object[] { "FC.CarpCooked", "cropLettuce", "foodCheese", "foodTortilla" }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  75 */     CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.fishsandwichItem, new Object[] { "toolSkillet", "FC.Bass", "foodMayo", Items.bread }));
/*  76 */     CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.fishsticksItem, new Object[] { "toolBakeware", "FC.Bass", "foodFlour" }));
/*  77 */     CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.stockItem, new Object[] { "toolPot", "FC.Bass", "toolMixingbowl" }));
/*  78 */     CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(ItemRegistry.fishdinnerItem, 1), new Object[] { "toolSkillet", "cropLemon", "foodFlour", "FC.Bass", "foodMayo" }));
/*  79 */     CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.sushiItem, new Object[] { "toolCuttingboard", "FC.Bass", "cropRice" }));
/*     */     
/*  81 */     CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.fishlettucewrapItem, new Object[] { "toolCuttingboard", "cropLettuce", "FC.BassCooked" }));
/*  82 */     CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.fishtacoItem, new Object[] { "FC.BassCooked", "cropLettuce", "foodCheese", "foodTortilla" }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  87 */     CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.fishsandwichItem, new Object[] { "toolSkillet", "FC.Pike", "foodMayo", Items.bread }));
/*  88 */     CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.fishsticksItem, new Object[] { "toolBakeware", "FC.Pike", "foodFlour" }));
/*  89 */     CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.stockItem, new Object[] { "toolPot", "FC.Pike", "toolMixingbowl" }));
/*  90 */     CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(ItemRegistry.fishdinnerItem, 1), new Object[] { "toolSkillet", "cropLemon", "foodFlour", "FC.Pike", "foodMayo" }));
/*  91 */     CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.sushiItem, new Object[] { "toolCuttingboard", "FC.Pike", "cropRice" }));
/*     */     
/*  93 */     CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.fishlettucewrapItem, new Object[] { "toolCuttingboard", "cropLettuce", "FC.PikeCooked" }));
/*  94 */     CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.fishtacoItem, new Object[] { "FC.PikeCooked", "cropLettuce", "foodCheese", "foodTortilla" }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  99 */     CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.fishsandwichItem, new Object[] { "toolSkillet", "FC.Peacock_Bass", "foodMayo", Items.bread }));
/* 100 */     CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.fishsticksItem, new Object[] { "toolBakeware", "FC.Peacock_Bass", "foodFlour" }));
/* 101 */     CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.stockItem, new Object[] { "toolPot", "FC.Peacock_Bass", "toolMixingbowl" }));
/* 102 */     CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(ItemRegistry.fishdinnerItem, 1), new Object[] { "toolSkillet", "cropLemon", "foodFlour", "FC.Peacock_Bass", "foodMayo" }));
/* 103 */     CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.sushiItem, new Object[] { "toolCuttingboard", "FC.Peacock_Bass", "cropRice" }));
/*     */     
/* 105 */     CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.fishlettucewrapItem, new Object[] { "toolCuttingboard", "cropLettuce", "FC.Peacock_BassCooked" }));
/* 106 */     CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.fishtacoItem, new Object[] { "FC.Peacock_BassCooked", "cropLettuce", "foodCheese", "foodTortilla" }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 111 */     CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.fishsandwichItem, new Object[] { "toolSkillet", "FC.Small_Piranha", "foodMayo", Items.bread }));
/* 112 */     CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.fishsticksItem, new Object[] { "toolBakeware", "FC.Small_Piranha", "foodFlour" }));
/* 113 */     CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.stockItem, new Object[] { "toolPot", "FC.Small_Piranha", "toolMixingbowl" }));
/* 114 */     CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(ItemRegistry.fishdinnerItem, 1), new Object[] { "toolSkillet", "cropLemon", "foodFlour", "FC.Small_Piranha", "foodMayo" }));
/* 115 */     CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.sushiItem, new Object[] { "toolCuttingboard", "FC.Small_Piranha", "cropRice" }));
/*     */     
/* 117 */     CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.fishlettucewrapItem, new Object[] { "toolCuttingboard", "cropLettuce", "FC.Small_PiranhaCooked" }));
/* 118 */     CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.fishtacoItem, new Object[] { "FC.Small_PiranhaCooked", "cropLettuce", "foodCheese", "foodTortilla" }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 123 */     CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.fishsandwichItem, new Object[] { "toolSkillet", "FC.Goldfish", "foodMayo", Items.bread }));
/* 124 */     CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.fishsticksItem, new Object[] { "toolBakeware", "FC.Goldfish", "foodFlour" }));
/* 125 */     CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.stockItem, new Object[] { "toolPot", "FC.Goldfish", "toolMixingbowl" }));
/* 126 */     CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(ItemRegistry.fishdinnerItem, 1), new Object[] { "toolSkillet", "cropLemon", "foodFlour", "FC.Goldfish", "foodMayo" }));
/* 127 */     CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.sushiItem, new Object[] { "toolCuttingboard", "FC.Goldfish", "cropRice" }));
/*     */     
/* 129 */     CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.fishlettucewrapItem, new Object[] { "toolCuttingboard", "cropLettuce", "FC.GoldfishCooked" }));
/* 130 */     CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.fishtacoItem, new Object[] { "FC.GoldfishCooked", "cropLettuce", "foodCheese", "foodTortilla" }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 135 */     CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.fishsandwichItem, new Object[] { "toolSkillet", "FC.Tuna_StripRaw", "foodMayo", Items.bread }));
/* 136 */     CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.fishsticksItem, new Object[] { "toolBakeware", "FC.Tuna_StripRaw", "foodFlour" }));
/* 137 */     CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.stockItem, new Object[] { "toolPot", "FC.Tuna_StripRaw", "toolMixingbowl" }));
/* 138 */     CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(ItemRegistry.fishdinnerItem, 1), new Object[] { "toolSkillet", "cropLemon", "foodFlour", "FC.Tuna_StripRaw", "foodMayo" }));
/* 139 */     CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.sushiItem, new Object[] { "toolCuttingboard", "FC.Tuna_StripRaw", "cropRice" }));
/*     */     
/* 141 */     CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.fishlettucewrapItem, new Object[] { "toolCuttingboard", "cropLettuce", "FC.Tuna_StripCooked" }));
/* 142 */     CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.fishtacoItem, new Object[] { "FC.Tuna_StripCooked", "cropLettuce", "foodCheese", "foodTortilla" }));
/*     */   }
/*     */ }


/* Location:              C:\Users\Modding\Desktop\Pam's HarvestCraft 1.7.10k.deobf.jar!\com\pam\harvestcraft\PamFoodFishingCraftRecipes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */