/*    */ package com.pam.harvestcraft;
/*    */ 
/*    */ import java.util.List;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.inventory.Container;
/*    */ import net.minecraft.inventory.IInventory;
/*    */ import net.minecraft.inventory.Slot;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class ContainerMarket extends Container
/*    */ {
/*    */   public ContainerMarket(IInventory par1IInventory, IInventory par2IInventory)
/*    */   {
/* 14 */     par2IInventory.openInventory();
/*    */     
/* 16 */     addSlotToContainer(new Slot(par2IInventory, 0, 113, 38));
/*    */     
/* 18 */     for (int i = 0; i < 3; i++)
/*    */     {
/* 20 */       for (int j = 0; j < 9; j++)
/*    */       {
/* 22 */         addSlotToContainer(new Slot(par1IInventory, j + i * 9 + 9, j * 18 + 8, i * 18 + 95));
/*    */       }
/*    */     }
/*    */     
/* 26 */     for (int i = 0; i < 9; i++)
/*    */     {
/* 28 */       addSlotToContainer(new Slot(par1IInventory, i, i * 18 + 8, 153));
/*    */     }
/*    */   }
/*    */   
/*    */   public boolean canInteractWith(EntityPlayer par1EntityPlayer)
/*    */   {
/* 34 */     return true;
/*    */   }
/*    */   
/*    */   public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int slotIndex)
/*    */   {
/* 39 */     ItemStack itemStack = null;
/* 40 */     Slot slot = (Slot)this.inventorySlots.get(slotIndex);
/* 41 */     if ((slot != null) && (slot.getHasStack())) {
/* 42 */       ItemStack slotStack = slot.getStack();
/* 43 */       itemStack = slotStack.copy();
/*    */       
/* 45 */       if (slotIndex >= 1) {
/* 46 */         if (slotStack.getItem() == net.minecraft.init.Items.emerald) {
/* 47 */           if (!mergeItemStack(slotStack, 0, 1, false))
/*    */           {
/* 49 */             return null;
/*    */           }
/* 51 */         } else if ((slotIndex >= 1) && (slotIndex < 28))
/*    */         {
/* 53 */           if (!mergeItemStack(slotStack, 27, 37, false)) {
/* 54 */             return null;
/*    */           }
/* 56 */         } else if ((slotIndex >= 1) && (slotIndex < 37) && (!mergeItemStack(slotStack, 1, 28, false)))
/*    */         {
/* 58 */           return null;
/*    */         }
/* 60 */       } else if (!mergeItemStack(slotStack, 1, 37, false))
/*    */       {
/* 62 */         return null;
/*    */       }
/*    */       
/* 65 */       if (slotStack.stackSize == 0) {
/* 66 */         slot.putStack(null);
/*    */       } else {
/* 68 */         slot.onSlotChanged();
/*    */       }
/*    */       
/* 71 */       if (slotStack.stackSize == itemStack.stackSize) {
/* 72 */         return null;
/*    */       }
/*    */       
/* 75 */       slot.onPickupFromSlot(entityPlayer, slotStack);
/*    */     }
/*    */     
/* 78 */     return itemStack;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void onContainerClosed(EntityPlayer par1EntityPlayer)
/*    */   {
/* 86 */     super.onContainerClosed(par1EntityPlayer);
/*    */   }
/*    */ }


/* Location:              C:\Users\Modding\Desktop\Pam's HarvestCraft 1.7.10k.deobf.jar!\com\pam\harvestcraft\ContainerMarket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */