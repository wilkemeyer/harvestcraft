/*    */ package com.pam.harvestcraft;
/*    */ 
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.item.ItemArmor;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ class ItemPamArmor extends ItemArmor
/*    */ {
/*    */   public ItemPamArmor(net.minecraft.item.ItemArmor.ArmorMaterial enumarmormaterial, int k)
/*    */   {
/* 11 */     super(enumarmormaterial, 0, k);
/* 12 */     this.maxStackSize = 1;
/* 13 */     setCreativeTab(harvestcraft.tabHarvestCraft);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
/*    */   {
/* 21 */     String layer = "1";
/* 22 */     if (slot == 2) {
/* 23 */       layer = "2";
/*    */     }
/* 25 */     return "harvestcraft:textures/armor/hardenedleather_" + layer + ".png";
/*    */   }
/*    */ }


/* Location:              C:\Users\Modding\Desktop\Pam's HarvestCraft 1.7.10k.deobf.jar!\com\pam\harvestcraft\ItemPamArmor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */