/*     */ package com.pam.harvestcraft;
/*     */ 
/*     */ import java.util.List;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.inventory.Container;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.inventory.InventoryCraftResult;
/*     */ import net.minecraft.inventory.InventoryCrafting;
/*     */ import net.minecraft.inventory.Slot;
/*     */ import net.minecraft.inventory.SlotCrafting;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class ContainerPamCuttingBoard extends Container
/*     */ {
/*  17 */   public InventoryCrafting craftMatrix = new InventoryCrafting(this, 3, 3);
/*  18 */   public IInventory craftResult = new InventoryCraftResult();
/*     */   private World worldObj;
/*     */   private int posX;
/*     */   private int posY;
/*     */   private int posZ;
/*     */   
public ContainerPamCuttingBoard(InventoryPlayer par1InventoryPlayer, World par2World, int par3, int par4, int par5)
{
    this.worldObj = par2World;
    this.posX = par3;
    this.posY = par4;
    this.posZ = par5;
    this.addSlotToContainer(new SlotCrafting(par1InventoryPlayer.player, this.craftMatrix, this.craftResult, 0, 124, 35));
    int l;
    int i1;

    for (l = 0; l < 3; ++l)
    {
        for (i1 = 0; i1 < 3; ++i1)
        {
            this.addSlotToContainer(new Slot(this.craftMatrix, i1 + l * 3, 30 + i1 * 18, 17 + l * 18));
        }
    }

    for (l = 0; l < 3; ++l)
    {
        for (i1 = 0; i1 < 9; ++i1)
        {
            this.addSlotToContainer(new Slot(par1InventoryPlayer, i1 + l * 9 + 9, 8 + i1 * 18, 84 + l * 18));
        }
    }

    for (l = 0; l < 9; ++l)
    {
        this.addSlotToContainer(new Slot(par1InventoryPlayer, l, 8 + l * 18, 142));
    }

    this.onCraftMatrixChanged(this.craftMatrix);
}

/*     */   public void onCraftMatrixChanged(IInventory par1IInventory)
/*     */   {
/*  63 */     this.craftResult.setInventorySlotContents(0, CraftingManagerPamCuttingBoard.getInstance().findMatchingRecipe(this.craftMatrix, this.worldObj));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onContainerClosed(EntityPlayer par1EntityPlayer)
/*     */   {
/*  71 */     super.onContainerClosed(par1EntityPlayer);
/*     */     
/*  73 */     if (!this.worldObj.isRemote)
/*     */     {
/*  75 */       for (int i = 0; i < 9; i++)
/*     */       {
/*  77 */         ItemStack itemstack = this.craftMatrix.getStackInSlotOnClosing(i);
/*     */         
/*  79 */         if (itemstack != null)
/*     */         {
/*  81 */           par1EntityPlayer.dropPlayerItemWithRandomChoice(itemstack, false);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean canInteractWith(EntityPlayer par1EntityPlayer)
/*     */   {
/*  90 */     return this.worldObj.getBlock(this.posX, this.posY, this.posZ) == BlockRegistry.pamcuttingBoard;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
/*     */   {
/*  98 */     ItemStack itemstack = null;
/*  99 */     Slot slot = (Slot)this.inventorySlots.get(par2);
/*     */     
/* 101 */     if ((slot != null) && (slot.getHasStack()))
/*     */     {
/* 103 */       ItemStack itemstack1 = slot.getStack();
/* 104 */       itemstack = itemstack1.copy();
/*     */       
/* 106 */       if (par2 == 0)
/*     */       {
/* 108 */         if (!mergeItemStack(itemstack1, 10, 46, true))
/*     */         {
/* 110 */           return null;
/*     */         }
/*     */         
/* 113 */         slot.onSlotChange(itemstack1, itemstack);
/*     */       }
/* 115 */       else if ((par2 >= 10) && (par2 < 37))
/*     */       {
/* 117 */         if (!mergeItemStack(itemstack1, 37, 46, false))
/*     */         {
/* 119 */           return null;
/*     */         }
/*     */       }
/* 122 */       else if ((par2 >= 37) && (par2 < 46))
/*     */       {
/* 124 */         if (!mergeItemStack(itemstack1, 10, 37, false))
/*     */         {
/* 126 */           return null;
/*     */         }
/*     */       }
/* 129 */       else if (!mergeItemStack(itemstack1, 10, 46, false))
/*     */       {
/* 131 */         return null;
/*     */       }
/*     */       
/* 134 */       if (itemstack1.stackSize == 0)
/*     */       {
/* 136 */         slot.putStack((ItemStack)null);
/*     */       }
/*     */       else
/*     */       {
/* 140 */         slot.onSlotChanged();
/*     */       }
/*     */       
/* 143 */       if (itemstack1.stackSize == itemstack.stackSize)
/*     */       {
/* 145 */         return null;
/*     */       }
/*     */       
/* 148 */       slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
/*     */     }
/*     */     
/* 151 */     return itemstack;
/*     */   }
/*     */   
/*     */   public boolean func_94530_a(ItemStack par1ItemStack, Slot par2Slot)
/*     */   {
/* 156 */     return (par2Slot.inventory != this.craftResult) && (super.func_94530_a(par1ItemStack, par2Slot));
/*     */   }
/*     */ }


/* Location:              C:\Users\Modding\Desktop\Pam's HarvestCraft 1.7.10k.deobf.jar!\com\pam\harvestcraft\ContainerPamCuttingBoard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */