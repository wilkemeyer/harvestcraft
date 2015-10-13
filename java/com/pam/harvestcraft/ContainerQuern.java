/*     */ package com.pam.harvestcraft;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import java.util.List;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.inventory.Container;
/*     */ import net.minecraft.inventory.ICrafting;
/*     */ import net.minecraft.inventory.Slot;
/*     */ import net.minecraft.item.ItemStack;
/*     */ 
/*     */ public class ContainerQuern extends Container
/*     */ {
/*     */   private TileEntityQuern tileQuern;
/*     */   private int lastCookTime;
/*     */   private int lastBurnTime;
/*     */   private int lastItemBurnTime;
/*     */   private static final String __OBFID = "CL_00001748";
/*     */   
public ContainerQuern(InventoryPlayer p_i1812_1_, TileEntityQuern p_i1812_2_)
{
    this.tileQuern = p_i1812_2_;
    this.addSlotToContainer(new Slot(p_i1812_2_, 0, 56, 17));
    this.addSlotToContainer(new Slot(p_i1812_2_, 1, 56, 53));
    this.addSlotToContainer(new SlotQuern(p_i1812_1_.player, p_i1812_2_, 2, 116, 35));
    int i;

    for (i = 0; i < 3; ++i)
    {
        for (int j = 0; j < 9; ++j)
        {
            this.addSlotToContainer(new Slot(p_i1812_1_, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
        }
    }

    for (i = 0; i < 9; ++i)
    {
        this.addSlotToContainer(new Slot(p_i1812_1_, i, 8 + i * 18, 142));
    }
}
/*     */   
public void addCraftingToCrafters(ICrafting p_75132_1_)
{
    super.addCraftingToCrafters(p_75132_1_);
    p_75132_1_.sendProgressBarUpdate(this, 0, this.tileQuern.quernCookTime);
    p_75132_1_.sendProgressBarUpdate(this, 1, this.tileQuern.quernBurnTime);
    p_75132_1_.sendProgressBarUpdate(this, 2, this.tileQuern.currentItemBurnTime);
}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void detectAndSendChanges()
/*     */   {
/*  55 */     super.detectAndSendChanges();
/*     */     
/*  57 */     for (int i = 0; i < this.crafters.size(); i++)
/*     */     {
/*  59 */       ICrafting icrafting = (ICrafting)this.crafters.get(i);
/*     */       
/*  61 */       if (this.lastCookTime != this.tileQuern.quernCookTime)
/*     */       {
/*  63 */         icrafting.sendProgressBarUpdate(this, 0, this.tileQuern.quernCookTime);
/*     */       }
/*     */       
/*  66 */       if (this.lastBurnTime != this.tileQuern.quernBurnTime)
/*     */       {
/*  68 */         icrafting.sendProgressBarUpdate(this, 1, this.tileQuern.quernBurnTime);
/*     */       }
/*     */       
/*  71 */       if (this.lastItemBurnTime != this.tileQuern.currentItemBurnTime)
/*     */       {
/*  73 */         icrafting.sendProgressBarUpdate(this, 2, this.tileQuern.currentItemBurnTime);
/*     */       }
/*     */     }
/*     */     
/*  77 */     this.lastCookTime = this.tileQuern.quernCookTime;
/*  78 */     this.lastBurnTime = this.tileQuern.quernBurnTime;
/*  79 */     this.lastItemBurnTime = this.tileQuern.currentItemBurnTime;
/*     */   }
/*     */   
/*     */   @cpw.mods.fml.relauncher.SideOnly(Side.CLIENT)
/*     */   public void updateProgressBar(int p_75137_1_, int p_75137_2_)
/*     */   {
/*  85 */     if (p_75137_1_ == 0)
/*     */     {
/*  87 */       this.tileQuern.quernCookTime = p_75137_2_;
/*     */     }
/*     */     
/*  90 */     if (p_75137_1_ == 1)
/*     */     {
/*  92 */       this.tileQuern.quernBurnTime = p_75137_2_;
/*     */     }
/*     */     
/*  95 */     if (p_75137_1_ == 2)
/*     */     {
/*  97 */       this.tileQuern.currentItemBurnTime = p_75137_2_;
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean canInteractWith(EntityPlayer p_75145_1_)
/*     */   {
/* 103 */     return this.tileQuern.isUseableByPlayer(p_75145_1_);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public ItemStack transferStackInSlot(EntityPlayer p_82846_1_, int p_82846_2_)
/*     */   {
/* 111 */     ItemStack itemstack = null;
/* 112 */     Slot slot = (Slot)this.inventorySlots.get(p_82846_2_);
/*     */     
/* 114 */     if ((slot != null) && (slot.getHasStack()))
/*     */     {
/* 116 */       ItemStack itemstack1 = slot.getStack();
/* 117 */       itemstack = itemstack1.copy();
/*     */       
/* 119 */       if (p_82846_2_ == 2)
/*     */       {
/* 121 */         if (!mergeItemStack(itemstack1, 3, 39, true))
/*     */         {
/* 123 */           return null;
/*     */         }
/*     */         
/* 126 */         slot.onSlotChange(itemstack1, itemstack);
/*     */       }
/* 128 */       else if ((p_82846_2_ != 1) && (p_82846_2_ != 0))
/*     */       {
/* 130 */         if (QuernRecipes.smelting().getSmeltingResult(itemstack1) != null)
/*     */         {
/* 132 */           if (!mergeItemStack(itemstack1, 0, 1, false))
/*     */           {
/* 134 */             return null;
/*     */           }
/*     */         }
/* 137 */         else if (TileEntityQuern.isItemFuel(itemstack1))
/*     */         {
/* 139 */           if (!mergeItemStack(itemstack1, 1, 2, false))
/*     */           {
/* 141 */             return null;
/*     */           }
/*     */         }
/* 144 */         else if ((p_82846_2_ >= 3) && (p_82846_2_ < 30))
/*     */         {
/* 146 */           if (!mergeItemStack(itemstack1, 30, 39, false))
/*     */           {
/* 148 */             return null;
/*     */           }
/*     */         }
/* 151 */         else if ((p_82846_2_ >= 30) && (p_82846_2_ < 39) && (!mergeItemStack(itemstack1, 3, 30, false)))
/*     */         {
/* 153 */           return null;
/*     */         }
/*     */       }
/* 156 */       else if (!mergeItemStack(itemstack1, 3, 39, false))
/*     */       {
/* 158 */         return null;
/*     */       }
/*     */       
/* 161 */       if (itemstack1.stackSize == 0)
/*     */       {
/* 163 */         slot.putStack((ItemStack)null);
/*     */       }
/*     */       else
/*     */       {
/* 167 */         slot.onSlotChanged();
/*     */       }
/*     */       
/* 170 */       if (itemstack1.stackSize == itemstack.stackSize)
/*     */       {
/* 172 */         return null;
/*     */       }
/*     */       
/* 175 */       slot.onPickupFromSlot(p_82846_1_, itemstack1);
/*     */     }
/*     */     
/* 178 */     return itemstack;
/*     */   }
/*     */ }


/* Location:              C:\Users\Modding\Desktop\Pam's HarvestCraft 1.7.10k.deobf.jar!\com\pam\harvestcraft\ContainerQuern.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */