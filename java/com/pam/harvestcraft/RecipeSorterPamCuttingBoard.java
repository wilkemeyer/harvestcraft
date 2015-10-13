/*    */ package com.pam.harvestcraft;
/*    */ 
/*    */ import java.util.Comparator;
/*    */ import net.minecraft.item.crafting.IRecipe;
/*    */ import net.minecraft.item.crafting.ShapedRecipes;
/*    */ import net.minecraft.item.crafting.ShapelessRecipes;
/*    */ 
/*    */ 
/*    */ class RecipeSorterPamCuttingBoard
/*    */   implements Comparator
/*    */ {
/*    */   final CraftingManagerPamCuttingBoard craftingmanangerpamcuttingboard;
/*    */   
/*    */   RecipeSorterPamCuttingBoard(CraftingManagerPamCuttingBoard craftingmanangerpamcuttingboard)
/*    */   {
/* 16 */     this.craftingmanangerpamcuttingboard = craftingmanangerpamcuttingboard;
/*    */   }
/*    */   
/*    */   public int compareRecipes(IRecipe par1IRecipe, IRecipe par2IRecipe)
/*    */   {
/* 21 */     return par2IRecipe.getRecipeSize() > par1IRecipe.getRecipeSize() ? 1 : par2IRecipe.getRecipeSize() < par1IRecipe.getRecipeSize() ? -1 : ((par2IRecipe instanceof ShapelessRecipes)) && ((par1IRecipe instanceof ShapedRecipes)) ? -1 : ((par1IRecipe instanceof ShapelessRecipes)) && ((par2IRecipe instanceof ShapedRecipes)) ? 1 : 0;
/*    */   }
/*    */   
/*    */   public int compare(Object par1Obj, Object par2Obj)
/*    */   {
/* 26 */     return compareRecipes((IRecipe)par1Obj, (IRecipe)par2Obj);
/*    */   }
/*    */ }


/* Location:              C:\Users\Modding\Desktop\Pam's HarvestCraft 1.7.10k.deobf.jar!\com\pam\harvestcraft\RecipeSorterPamCuttingBoard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */