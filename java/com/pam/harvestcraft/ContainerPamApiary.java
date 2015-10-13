/*     */ package com.pam.harvestcraft;
/*     */ 
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.inventory.Container;
/*     */ import net.minecraft.inventory.ICrafting;
/*     */ import net.minecraft.inventory.Slot;
/*     */ import net.minecraft.item.ItemStack;
/*     */ 
/*     */ public class ContainerPamApiary extends Container
/*     */ {
/*     */   private TileEntityPamApiary apiary;
/*  13 */   private int lastProduceTime = 0;
/*  14 */   private int lastRunTime = 0;
/*  15 */   private int lastBeeRunTime = 0;
/*     */   
/*     */   public ContainerPamApiary(InventoryPlayer inv, TileEntityPamApiary tepa) {
/*  18 */     this.apiary = tepa;
/*     */     
/*  20 */     for (int x = 0; x < 6; x++) {
/*  21 */       for (int y = 0; y < 3; y++) {
/*  22 */         addSlotToContainer(new SlotPamResult(inv.player, tepa, y + x * 3, 62 + 18 * x, 17 + 18 * y));
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*  27 */     addSlotToContainer(new SlotPamApiary(inv.player, tepa, 18, 26, 35));
/*     */     
/*  29 */     for (int i = 0; i < 3; i++) {
/*  30 */       for (int j = 0; j < 9; j++) {
/*  31 */         addSlotToContainer(new Slot(inv, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*  36 */     for (int i = 0; i < 9; i++) {
/*  37 */       addSlotToContainer(new Slot(inv, i, 8 + i * 18, 142));
/*     */     }
/*     */   }
/*     */   
/*     */   public void detectAndSendChanges()
/*     */   {
/*  43 */     super.detectAndSendChanges();
/*     */     
/*  45 */     for (int i = 0; i < this.crafters.size(); i++) {
/*  46 */       ICrafting crafter = (ICrafting)this.crafters.get(i);
/*  47 */       if (this.lastProduceTime != this.apiary.produceTime) {
/*  48 */         crafter.sendProgressBarUpdate(this, 1, this.apiary.produceTime);
/*     */       }
/*     */       
/*  51 */       if (this.lastRunTime != this.apiary.runTime) {
/*  52 */         crafter.sendProgressBarUpdate(this, 2, this.apiary.runTime);
/*     */       }
/*     */       
/*  55 */       if (this.lastBeeRunTime != this.apiary.currentBeeRunTime) {
/*  56 */         crafter.sendProgressBarUpdate(this, 3, this.apiary.currentBeeRunTime);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*  61 */     this.lastProduceTime = this.apiary.produceTime;
/*  62 */     this.lastRunTime = this.apiary.runTime;
/*  63 */     this.lastBeeRunTime = this.apiary.currentBeeRunTime;
/*     */   }
/*     */   
/*     */   public void updateProgressBar(int event, int val) {
/*  67 */     if (event == 1) {
/*  68 */       this.apiary.produceTime = val;
/*  69 */     } else if (event == 2) {
/*  70 */       this.apiary.runTime = val;
/*  71 */     } else if (event == 3) {
/*  72 */       this.apiary.currentBeeRunTime = val;
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean canInteractWith(EntityPlayer player) {
/*  77 */     return this.apiary.isUseableByPlayer(player);
/*     */   }
/*     */   
/*     */   public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int slotIndex)
/*     */   {
/*  82 */     ItemStack itemStack = null;
/*  83 */     Slot slot = (Slot)this.inventorySlots.get(slotIndex);
/*  84 */     if ((slot != null) && (slot.getHasStack())) {
/*  85 */       ItemStack slotStack = slot.getStack();
/*  86 */       itemStack = slotStack.copy();
/*     */       
/*  88 */       if (slotIndex >= 19) {
/*  89 */         if (slotStack.getItem() == ItemRegistry.queenbeeItem) {
/*  90 */           if (!mergeItemStack(slotStack, 18, 19, false))
/*     */           {
/*  92 */             return null;
/*     */           }
/*  94 */         } else if ((slotIndex >= 19) && (slotIndex < 46))
/*     */         {
/*  96 */           if (!mergeItemStack(slotStack, 46, 55, false)) {
/*  97 */             return null;
/*     */           }
/*  99 */         } else if ((slotIndex >= 46) && (slotIndex < 55) && (!mergeItemStack(slotStack, 19, 46, false)))
/*     */         {
/* 101 */           return null;
/*     */         }
/* 103 */       } else if (!mergeItemStack(slotStack, 19, 55, false))
/*     */       {
/* 105 */         return null;
/*     */       }
/*     */       
/* 108 */       if (slotStack.stackSize == 0) {
/* 109 */         slot.putStack(null);
/*     */       } else {
/* 111 */         slot.onSlotChanged();
/*     */       }
/*     */       
/* 114 */       if (slotStack.stackSize == itemStack.stackSize) {
/* 115 */         return null;
/*     */       }
/*     */       
/* 118 */       slot.onPickupFromSlot(entityPlayer, slotStack);
/*     */     }
/*     */     
/* 121 */     return itemStack;
/*     */   }
/*     */ }


/* Location:              C:\Users\Modding\Desktop\Pam's HarvestCraft 1.7.10k.deobf.jar!\com\pam\harvestcraft\ContainerPamApiary.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */