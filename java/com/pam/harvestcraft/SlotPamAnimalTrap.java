/*    */ package com.pam.harvestcraft;
/*    */ 
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.inventory.IInventory;
/*    */ import net.minecraft.inventory.Slot;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class SlotPamAnimalTrap
/*    */   extends Slot
/*    */ {
/*    */   private EntityPlayer thePlayer;
/*    */   
/*    */   public SlotPamAnimalTrap(EntityPlayer par1EntityPlayer, IInventory par2IInventory, int par3, int par4, int par5)
/*    */   {
/* 15 */     super(par2IInventory, par3, par4, par5);
/* 16 */     setThePlayer(par1EntityPlayer);
/*    */   }
/*    */   
/*    */   public int getSlotStackLimit() {
/* 20 */     return 64;
/*    */   }
/*    */   
/*    */   public boolean isItemValid(ItemStack par1ItemStack) {
/* 24 */     return (par1ItemStack.getItem() == ItemRegistry.grainbaitItem) || (par1ItemStack.getItem() == ItemRegistry.veggiebaitItem) || (par1ItemStack.getItem() == ItemRegistry.fruitbaitItem);
/*    */   }
/*    */   
/*    */ 
/*    */   public void onPickupFromSlot(EntityPlayer par1EntityPlayer, ItemStack par2ItemStack)
/*    */   {
/* 30 */     super.onPickupFromSlot(par1EntityPlayer, par2ItemStack);
/*    */   }
/*    */   
/*    */   public EntityPlayer getThePlayer() {
/* 34 */     return this.thePlayer;
/*    */   }
/*    */   
/*    */   public void setThePlayer(EntityPlayer thePlayer) {
/* 38 */     this.thePlayer = thePlayer;
/*    */   }
/*    */ }


/* Location:              C:\Users\Modding\Desktop\Pam's HarvestCraft 1.7.10k.deobf.jar!\com\pam\harvestcraft\SlotPamAnimalTrap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */