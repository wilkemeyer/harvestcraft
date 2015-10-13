/*    */ package com.pam.harvestcraft;
/*    */ 
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.ItemFood;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ItemPamCakeFood
/*    */   extends ItemFood
/*    */ {
/*    */   public Block cake;
/*    */   
/*    */   public ItemPamCakeFood(int p_i45339_1_, float p_i45339_2_, boolean p_i45339_3_, Block cake)
/*    */   {
/* 27 */     super(p_i45339_1_, p_i45339_2_, p_i45339_3_);
/* 28 */     this.cake = cake;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
/*    */   {
/* 34 */     if (par7 != 1)
/*    */     {
/* 36 */       return false;
/*    */     }
/* 38 */     if ((par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack)) && (par2EntityPlayer.canPlayerEdit(par4, par5 + 1, par6, par7, par1ItemStack)))
/*    */     {
/*    */ 
/*    */ 
/* 42 */       par3World.setBlock(par4, par5 + 1, par6, this.cake);
/* 43 */       par1ItemStack.stackSize -= 1;
/* 44 */       return true;
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 49 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Modding\Desktop\Pam's HarvestCraft 1.7.10k.deobf.jar!\com\pam\harvestcraft\ItemPamCakeFood.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */