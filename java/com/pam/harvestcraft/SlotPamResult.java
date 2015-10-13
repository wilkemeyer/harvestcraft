/*    */ package com.pam.harvestcraft;
/*    */ 
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.inventory.IInventory;
/*    */ import net.minecraft.inventory.Slot;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class SlotPamResult extends Slot
/*    */ {
/*    */   private EntityPlayer thePlayer;
/*    */   
/*    */   public SlotPamResult(EntityPlayer par1EntityPlayer, IInventory par2IInventory, int par3, int par4, int par5)
/*    */   {
/* 14 */     super(par2IInventory, par3, par4, par5);
/* 15 */     this.thePlayer = par1EntityPlayer;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean isItemValid(ItemStack par1ItemStack)
/*    */   {
/* 23 */     return false;
/*    */   }
/*    */   
/*    */   public void onPickupFromSlot(EntityPlayer par1EntityPlayer, ItemStack par2ItemStack)
/*    */   {
/* 28 */     super.onPickupFromSlot(par1EntityPlayer, par2ItemStack);
/*    */   }
/*    */ }


/* Location:              C:\Users\Modding\Desktop\Pam's HarvestCraft 1.7.10k.deobf.jar!\com\pam\harvestcraft\SlotPamResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */