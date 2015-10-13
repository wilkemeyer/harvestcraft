/*     */ package com.pam.harvestcraft;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.inventory.Container;
/*     */ import net.minecraft.inventory.ICrafting;
/*     */ import net.minecraft.inventory.Slot;
/*     */ import net.minecraft.item.ItemStack;
/*     */ 
/*     */ public class ContainerPamPresser
/*     */   extends Container
/*     */ {
/*     */   private TileEntityPamPresser combPresser;
/*  17 */   private int lastCookTime = 0;
/*  18 */   private int lastBurnTime = 0;
/*  19 */   private int lastCombPresserBurnTime = 0;
/*     */   
public ContainerPamPresser(InventoryPlayer par1InventoryPlayer, TileEntityPamPresser par2TileEntityCombPresser) {
    this.combPresser = par2TileEntityCombPresser;
    this.addSlotToContainer(new SlotPamPresser(par1InventoryPlayer.player, par2TileEntityCombPresser, 0, 80, 23));
    this.addSlotToContainer(new SlotPamResult(par1InventoryPlayer.player, par2TileEntityCombPresser, 1, 62, 54));
    this.addSlotToContainer(new SlotPamResult(par1InventoryPlayer.player, par2TileEntityCombPresser, 2, 98, 54));

    int var3;
    for (var3 = 0; var3 < 3; ++var3) {
        for (int var4 = 0; var4 < 9; ++var4) {
            this.addSlotToContainer(new Slot(par1InventoryPlayer, var4 + var3 * 9 + 9, 8 + var4 * 18, 84 + var3 * 18));
        }
    }

    for (var3 = 0; var3 < 9; ++var3) {
        this.addSlotToContainer(new Slot(par1InventoryPlayer, var3, 8 + var3 * 18, 142));
    }

}
/*     */   public void detectAndSendChanges()
/*     */   {
/*  42 */     super.detectAndSendChanges();
/*     */     
/*  44 */     for (int var1 = 0; var1 < this.crafters.size(); var1++) {
/*  45 */       ICrafting var2 = (ICrafting)this.crafters.get(var1);
/*  46 */       if (this.lastCookTime != this.combPresser.combPresserCookTime) {
/*  47 */         var2.sendProgressBarUpdate(this, 0, this.combPresser.combPresserCookTime);
/*     */       }
/*     */       
/*  50 */       if (this.lastBurnTime != this.combPresser.combPresserBurnTime) {
/*  51 */         var2.sendProgressBarUpdate(this, 1, this.combPresser.combPresserBurnTime);
/*     */       }
/*     */       
/*  54 */       if (this.lastCombPresserBurnTime != this.combPresser.currentCombPresserBurnTime) {
/*  55 */         var2.sendProgressBarUpdate(this, 2, this.combPresser.currentCombPresserBurnTime);
/*     */       }
/*     */     }
/*     */     
/*  59 */     this.lastCookTime = this.combPresser.combPresserCookTime;
/*  60 */     this.lastBurnTime = this.combPresser.combPresserBurnTime;
/*  61 */     this.lastCombPresserBurnTime = this.combPresser.currentCombPresserBurnTime;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void updateProgressBar(int par1, int par2) {
/*  66 */     if (par1 == 0) {
/*  67 */       this.combPresser.combPresserCookTime = par2;
/*     */     }
/*     */     
/*  70 */     if (par1 == 1) {
/*  71 */       this.combPresser.combPresserBurnTime = par2;
/*     */     }
/*     */     
/*  74 */     if (par1 == 2) {
/*  75 */       this.combPresser.currentCombPresserBurnTime = par2;
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean canInteractWith(EntityPlayer par1EntityPlayer)
/*     */   {
/*  81 */     return this.combPresser.isUseableByPlayer(par1EntityPlayer);
/*     */   }
/*     */   
/*     */   public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int slotIndex)
/*     */   {
/*  86 */     ItemStack itemStack = null;
/*  87 */     Slot slot = (Slot)this.inventorySlots.get(slotIndex);
/*  88 */     if ((slot != null) && (slot.getHasStack())) {
/*  89 */       ItemStack slotStack = slot.getStack();
/*  90 */       itemStack = slotStack.copy();
/*     */       
/*  92 */       if (slotIndex >= 3) {
/*  93 */         if ((slotStack.getItem() == ItemRegistry.soybeanItem) || (slotStack.getItem() == ItemRegistry.silkentofuItem) || (slotStack.getItem() == ItemRegistry.soymilkItem)) {
/*  94 */           if (!mergeItemStack(slotStack, 0, 1, false))
/*     */           {
/*  96 */             return null;
/*     */           }
/*  98 */         } else if ((slotIndex >= 3) && (slotIndex < 30))
/*     */         {
/* 100 */           if (!mergeItemStack(slotStack, 30, 39, false)) {
/* 101 */             return null;
/*     */           }
/* 103 */         } else if ((slotIndex >= 30) && (slotIndex < 39) && (!mergeItemStack(slotStack, 3, 30, false)))
/*     */         {
/* 105 */           return null;
/*     */         }
/* 107 */       } else if (!mergeItemStack(slotStack, 3, 39, false))
/*     */       {
/* 109 */         return null;
/*     */       }
/*     */       
/* 112 */       if (slotStack.stackSize == 0) {
/* 113 */         slot.putStack(null);
/*     */       } else {
/* 115 */         slot.onSlotChanged();
/*     */       }
/*     */       
/* 118 */       if (slotStack.stackSize == itemStack.stackSize) {
/* 119 */         return null;
/*     */       }
/*     */       
/* 122 */       slot.onPickupFromSlot(entityPlayer, slotStack);
/*     */     }
/*     */     
/* 125 */     return itemStack;
/*     */   }
/*     */ }


/* Location:              C:\Users\Modding\Desktop\Pam's HarvestCraft 1.7.10k.deobf.jar!\com\pam\harvestcraft\ContainerPamPresser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */