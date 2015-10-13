/*    */ package com.pam.harvestcraft;
/*    */ 
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class ItemPamTool
/*    */   extends Item
/*    */ {
/*    */   public ItemPamTool()
/*    */   {
/* 11 */     setMaxStackSize(1);
/*    */   }
/*    */   
/*    */   public boolean doesContainerItemLeaveCraftingGrid(ItemStack par1ItemStack)
/*    */   {
/* 16 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Modding\Desktop\Pam's HarvestCraft 1.7.10k.deobf.jar!\com\pam\harvestcraft\ItemPamTool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */