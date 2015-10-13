/*     */ package com.pam.harvestcraft;
/*     */ 
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class TileEntityMarket extends TileEntity implements IInventory
/*     */ {
/*  12 */   private ItemStack paySlot = null;
/*     */   
/*  14 */   public int stockNum = 0;
/*     */   
/*  16 */   private boolean isTrading = false;
/*     */   
/*     */ 
/*     */   public int getSizeInventory()
/*     */   {
/*  21 */     return 1;
/*     */   }
/*     */   
/*     */ 
/*     */   public ItemStack getStackInSlot(int par1)
/*     */   {
/*  27 */     return this.paySlot;
/*     */   }
/*     */   
/*     */ 
/*     */   public ItemStack decrStackSize(int par1, int par2)
/*     */   {
/*  33 */     if (this.paySlot != null)
/*     */     {
/*     */ 
/*     */ 
/*  37 */       if (this.paySlot.stackSize <= par2)
/*     */       {
/*  39 */         ItemStack var3 = this.paySlot;
/*  40 */         this.paySlot = null;
/*  41 */         this.markDirty();
/*  42 */         return var3;
/*     */       }
/*  44 */       ItemStack var3 = this.paySlot.splitStack(par2);
/*     */       
/*  46 */       if (this.paySlot.stackSize == 0)
/*     */       {
/*  48 */         this.paySlot = null;
/*     */       }
/*     */       
/*  51 */       this.markDirty();
/*  52 */       return var3;
/*     */     }
/*  54 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */   public ItemStack getStackInSlotOnClosing(int par1)
/*     */   {
/*  60 */     if (this.paySlot != null)
/*     */     {
/*  62 */       ItemStack var2 = this.paySlot;
/*  63 */       this.paySlot = null;
/*  64 */       return var2;
/*     */     }
/*  66 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */   public void setInventorySlotContents(int par1, ItemStack par2ItemStack)
/*     */   {
/*  72 */     this.paySlot = par2ItemStack;
/*     */     
/*  74 */     if ((par2ItemStack != null) && (par2ItemStack.stackSize > getInventoryStackLimit()))
/*     */     {
/*  76 */       par2ItemStack.stackSize = getInventoryStackLimit();
/*     */     }
/*     */     
/*  79 */     this.markDirty();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getInvName()
/*     */   {
/*  87 */     return "Market";
/*     */   }
/*     */   
/*     */   public void takeEmeraldFromSlot(int price)
/*     */   {
/*  92 */     if (this.paySlot != null)
/*     */     {
/*  94 */       this.paySlot.stackSize -= price;
/*     */     }
/*  96 */     this.markDirty();
/*     */   }
/*     */   
/*     */   public void clearInventory()
/*     */   {
/* 101 */     this.paySlot = null;
/*     */   }
/*     */   
/*     */ 
/*     */   public void readFromNBT(NBTTagCompound par1NBTTagCompound)
/*     */   {
/* 107 */     super.readFromNBT(par1NBTTagCompound);
/* 108 */     this.stockNum = par1NBTTagCompound.getInteger("StockNum");
/*     */   }
/*     */   
/*     */ 
/*     */   public void writeToNBT(NBTTagCompound par1NBTTagCompound)
/*     */   {
/* 114 */     super.writeToNBT(par1NBTTagCompound);
/* 115 */     par1NBTTagCompound.setInteger("StockNum", this.stockNum);
/*     */   }
/*     */   
/*     */   public void setBrowsingInfo(int stockNum)
/*     */   {
/* 120 */     this.stockNum = stockNum;
/*     */   }
/*     */   
/*     */   public int getBrowsingInfo()
/*     */   {
/* 125 */     return this.stockNum;
/*     */   }
/*     */   
/*     */   public void setTrading(boolean isUsing)
/*     */   {
/* 130 */     this.isTrading = isUsing;
/*     */   }
/*     */   
/*     */   public boolean isTrading()
/*     */   {
/* 135 */     return this.isTrading;
/*     */   }
/*     */   
/*     */   public int getInventoryStackLimit()
/*     */   {
/* 140 */     return 64;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer)
/*     */   {
/* 146 */     return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) == this;
/*     */   }
/*     */   
/*     */ 
/*     */   public void updateContainingBlockInfo()
/*     */   {
/* 152 */     super.updateContainingBlockInfo();
/*     */   }
/*     */   
/*     */ 
/*     */   public void updateEntity()
/*     */   {
/* 158 */     super.updateEntity();
/*     */   }
/*     */   
/*     */ 
/*     */   public void func_70295_k_() {}
/*     */   
/*     */ 
/*     */   public void func_70305_f()
/*     */   {
/* 167 */     setTrading(false);
/*     */   }
/*     */   
/*     */ 
/*     */   public void invalidate()
/*     */   {
/* 173 */     updateContainingBlockInfo();
/* 174 */     super.invalidate();
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isItemValidForSlot(int i, ItemStack itemstack)
/*     */   {
/* 180 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public String getInventoryName()
/*     */   {
/* 186 */     return "Market";
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isInventoryNameLocalized()
/*     */   {
/* 192 */     return false;
/*     */   }
/*     */
@Override
public boolean hasCustomInventoryName() {
	// TODO Auto-generated method stub
	return false;
}
@Override
public void openInventory() {
	// TODO Auto-generated method stub
	
}
@Override
public void closeInventory() {
	// TODO Auto-generated method stub
	
} }


/* Location:              C:\Users\Modding\Desktop\Pam's HarvestCraft 1.7.10k.deobf.jar!\com\pam\harvestcraft\TileEntityMarket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */