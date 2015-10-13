/*    */ package com.pam.harvestcraft;
/*    */ 
/*    */ import net.minecraft.item.EnumAction;
/*    */ import net.minecraft.item.ItemFood;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class ItemPamPotionFood
/*    */   extends ItemFood
/*    */ {
/*    */   public ItemPamPotionFood(int par2, float par3, boolean par4)
/*    */   {
/* 12 */     super(par2, par3, par4);
/* 13 */     setCreativeTab(harvestcraft.tabHarvestCraft);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public EnumAction getItemUseAction(ItemStack par1ItemStack)
/*    */   {
/* 22 */     return EnumAction.drink;
/*    */   }
/*    */ }


/* Location:              C:\Users\Modding\Desktop\Pam's HarvestCraft 1.7.10k.deobf.jar!\com\pam\harvestcraft\ItemPamPotionFood.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */