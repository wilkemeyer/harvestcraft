/*     */ package com.pam.harvestcraft;
/*     */ 
/*     */ import cpw.mods.fml.common.registry.GameRegistry;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.inventory.ISidedInventory;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TileEntityChurn
/*     */   extends TileEntity
/*     */   implements ISidedInventory
/*     */ {
/*  24 */   private static final int[] slotsTop = { 0 };
/*  25 */   private static final int[] slotsBottom = { 2, 1 };
/*  26 */   private static final int[] slotsSides = { 1 };
/*     */   
/*  28 */   private ItemStack[] churnItemStacks = new ItemStack[3];
/*     */   
/*     */   public int churnBurnTime;
/*     */   
/*     */   public int currentItemBurnTime;
/*     */   
/*     */   public int churnCookTime;
/*     */   
/*     */   private String field_145958_o;
/*     */   
/*     */   private static final String __OBFID = "CL_00000357";
/*     */   
/*     */ 
/*     */   public int getSizeInventory()
/*     */   {
/*  43 */     return this.churnItemStacks.length;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public ItemStack getStackInSlot(int p_70301_1_)
/*     */   {
/*  51 */     return this.churnItemStacks[p_70301_1_];
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public ItemStack decrStackSize(int p_70298_1_, int p_70298_2_)
/*     */   {
/*  60 */     if (this.churnItemStacks[p_70298_1_] != null)
/*     */     {
/*     */ 
/*     */ 
/*  64 */       if (this.churnItemStacks[p_70298_1_].stackSize <= p_70298_2_)
/*     */       {
/*  66 */         ItemStack itemstack = this.churnItemStacks[p_70298_1_];
/*  67 */         this.churnItemStacks[p_70298_1_] = null;
/*  68 */         return itemstack;
/*     */       }
/*     */       
/*     */ 
/*  72 */       ItemStack itemstack = this.churnItemStacks[p_70298_1_].splitStack(p_70298_2_);
/*     */       
/*  74 */       if (this.churnItemStacks[p_70298_1_].stackSize == 0)
/*     */       {
/*  76 */         this.churnItemStacks[p_70298_1_] = null;
/*     */       }
/*     */       
/*  79 */       return itemstack;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  84 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public ItemStack getStackInSlotOnClosing(int p_70304_1_)
/*     */   {
/*  94 */     if (this.churnItemStacks[p_70304_1_] != null)
/*     */     {
/*  96 */       ItemStack itemstack = this.churnItemStacks[p_70304_1_];
/*  97 */       this.churnItemStacks[p_70304_1_] = null;
/*  98 */       return itemstack;
/*     */     }
/*     */     
/*     */ 
/* 102 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setInventorySlotContents(int p_70299_1_, ItemStack p_70299_2_)
/*     */   {
/* 111 */     this.churnItemStacks[p_70299_1_] = p_70299_2_;
/*     */     
/* 113 */     if ((p_70299_2_ != null) && (p_70299_2_.stackSize > getInventoryStackLimit()))
/*     */     {
/* 115 */       p_70299_2_.stackSize = getInventoryStackLimit();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getInventoryName()
/*     */   {
/* 124 */     return isInventoryNameLocalized() ? this.field_145958_o : "Churn";
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isInventoryNameLocalized()
/*     */   {
/* 132 */     return (this.field_145958_o != null) && (this.field_145958_o.length() > 0);
/*     */   }
/*     */   
/*     */   public void func_145951_a(String p_145951_1_)
/*     */   {
/* 137 */     this.field_145958_o = p_145951_1_;
/*     */   }
/*     */   
/*     */   public void readFromNBT(NBTTagCompound p_145839_1_)
/*     */   {
/* 142 */     super.readFromNBT(p_145839_1_);
/* 143 */     NBTTagList nbttaglist = p_145839_1_.getTagList("Items", 10);
/* 144 */     this.churnItemStacks = new ItemStack[getSizeInventory()];
/*     */     
/* 146 */     for (int i = 0; i < nbttaglist.tagCount(); i++)
/*     */     {
/* 148 */       NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
/* 149 */       byte b0 = nbttagcompound1.getByte("Slot");
/*     */       
/* 151 */       if ((b0 >= 0) && (b0 < this.churnItemStacks.length))
/*     */       {
/* 153 */         this.churnItemStacks[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
/*     */       }
/*     */     }
/*     */     
/* 157 */     this.churnBurnTime = p_145839_1_.getShort("BurnTime");
/* 158 */     this.churnCookTime = p_145839_1_.getShort("CookTime");
/* 159 */     this.currentItemBurnTime = getItemBurnTime(this.churnItemStacks[1]);
/*     */     
/* 161 */     if (p_145839_1_.hasKey("CustomName", 8))
/*     */     {
/* 163 */       this.field_145958_o = p_145839_1_.getString("CustomName");
/*     */     }
/*     */   }
/*     */   
/*     */   public void writeToNBT(NBTTagCompound p_145841_1_)
/*     */   {
/* 169 */     super.writeToNBT(p_145841_1_);
/* 170 */     p_145841_1_.setShort("BurnTime", (short)this.churnBurnTime);
/* 171 */     p_145841_1_.setShort("CookTime", (short)this.churnCookTime);
/* 172 */     NBTTagList nbttaglist = new NBTTagList();
/*     */     
/* 174 */     for (int i = 0; i < this.churnItemStacks.length; i++)
/*     */     {
/* 176 */       if (this.churnItemStacks[i] != null)
/*     */       {
/* 178 */         NBTTagCompound nbttagcompound1 = new NBTTagCompound();
/* 179 */         nbttagcompound1.setByte("Slot", (byte)i);
/* 180 */         this.churnItemStacks[i].writeToNBT(nbttagcompound1);
/* 181 */         nbttaglist.appendTag(nbttagcompound1);
/*     */       }
/*     */     }
/*     */     
/* 185 */     p_145841_1_.setTag("Items", nbttaglist);
/*     */     
/* 187 */     if (isInventoryNameLocalized())
/*     */     {
/* 189 */       p_145841_1_.setString("CustomName", this.field_145958_o);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getInventoryStackLimit()
/*     */   {
/* 198 */     return 64;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int getCookProgressScaled(int p_145953_1_)
/*     */   {
/* 208 */     return this.churnCookTime * p_145953_1_ / 200;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int getBurnTimeRemainingScaled(int p_145955_1_)
/*     */   {
/* 218 */     if (this.currentItemBurnTime == 0)
/*     */     {
/* 220 */       this.currentItemBurnTime = 200;
/*     */     }
/*     */     
/* 223 */     return this.churnBurnTime * p_145955_1_ / this.currentItemBurnTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isBurning()
/*     */   {
/* 231 */     return this.churnBurnTime > 0;
/*     */   }
/*     */   
/*     */   public void updateEntity()
/*     */   {
/* 236 */     boolean flag = this.churnBurnTime > 0;
/* 237 */     boolean flag1 = false;
/*     */     
/* 239 */     if (this.churnBurnTime > 0)
/*     */     {
/* 241 */       this.churnBurnTime -= 1;
/*     */     }
/*     */     
/* 244 */     if (!this.worldObj.isRemote)
/*     */     {
/* 246 */       if ((this.churnBurnTime != 0) || ((this.churnItemStacks[1] != null) && (this.churnItemStacks[0] != null)))
/*     */       {
/* 248 */         if ((this.churnBurnTime == 0) && (canSmelt()))
/*     */         {
/* 250 */           this.currentItemBurnTime = (this.churnBurnTime = getItemBurnTime(this.churnItemStacks[1]));
/*     */           
/* 252 */           if (this.churnBurnTime > 0)
/*     */           {
/* 254 */             flag1 = true;
/*     */             
/* 256 */             if (this.churnItemStacks[1] != null)
/*     */             {
/* 258 */               this.churnItemStacks[1].stackSize -= 1;
/*     */               
/* 260 */               if (this.churnItemStacks[1].stackSize == 0)
/*     */               {
/* 262 */                 this.churnItemStacks[1] = this.churnItemStacks[1].getItem().getContainerItem(this.churnItemStacks[1]);
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */         
/* 268 */         if ((isBurning()) && (canSmelt()))
/*     */         {
/* 270 */           this.churnCookTime += 1;
/*     */           
/* 272 */           if (this.churnCookTime == 200)
/*     */           {
/* 274 */             this.churnCookTime = 0;
/* 275 */             smeltItem();
/* 276 */             flag1 = true;
/*     */           }
/*     */         }
/*     */         else
/*     */         {
/* 281 */           this.churnCookTime = 0;
/*     */         }
/*     */       }
/*     */       
/* 285 */       if (flag != this.churnBurnTime > 0)
/*     */       {
/* 287 */         flag1 = true;
/* 288 */         BlockPamChurn.updateChurnBlockState(this.churnBurnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
/*     */       }
/*     */     }
/*     */     
/* 292 */     if (flag1)
/*     */     {
/* 294 */       this.markDirty();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean canSmelt()
/*     */   {
/* 303 */     if (this.churnItemStacks[0] == null)
/*     */     {
/* 305 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 309 */     ItemStack itemstack = ChurnRecipes.smelting().getSmeltingResult(this.churnItemStacks[0]);
/* 310 */     if (itemstack == null) return false;
/* 311 */     if (this.churnItemStacks[2] == null) return true;
/* 312 */     if (!this.churnItemStacks[2].isItemEqual(itemstack)) return false;
/* 313 */     int result = this.churnItemStacks[2].stackSize + itemstack.stackSize;
/* 314 */     return (result <= getInventoryStackLimit()) && (result <= this.churnItemStacks[2].getMaxStackSize());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void smeltItem()
/*     */   {
/* 323 */     if (canSmelt())
/*     */     {
/* 325 */       ItemStack itemstack = ChurnRecipes.smelting().getSmeltingResult(this.churnItemStacks[0]);
/*     */       
/* 327 */       if (this.churnItemStacks[2] == null)
/*     */       {
/* 329 */         this.churnItemStacks[2] = itemstack.copy();
/*     */       }
/* 331 */       else if (this.churnItemStacks[2].getItem() == itemstack.getItem())
/*     */       {
/* 333 */         this.churnItemStacks[2].stackSize += itemstack.stackSize;
/*     */       }
/*     */       
/* 336 */       this.churnItemStacks[0].stackSize -= 1;
/*     */       
/* 338 */       if (this.churnItemStacks[0].stackSize <= 0)
/*     */       {
/* 340 */         this.churnItemStacks[0] = null;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getItemBurnTime(ItemStack p_145952_0_)
/*     */   {
/* 351 */     if (p_145952_0_ == null)
/*     */     {
/* 353 */       return 0;
/*     */     }
/*     */     
/*     */ 
/* 357 */     Item item = p_145952_0_.getItem();
/*     */     
/*     */ 
/* 360 */     if (item == ItemRegistry.saltItem) { return 1600;
/*     */     }
/* 362 */     return GameRegistry.getFuelValue(p_145952_0_);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isItemFuel(ItemStack p_145954_0_)
/*     */   {
/* 372 */     return getItemBurnTime(p_145954_0_) > 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isUseableByPlayer(EntityPlayer p_70300_1_)
/*     */   {
/* 380 */     return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) == this;
/*     */   }
/*     */   
/*     */ 
/*     */   public void func_70295_k_() {}
/*     */   
/*     */ 
/*     */   public void func_70305_f() {}
/*     */   
/*     */ 
/*     */   public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_)
/*     */   {
/* 392 */     return p_94041_1_ != 2;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int[] func_94128_d(int p_94128_1_)
/*     */   {
/* 401 */     return p_94128_1_ == 1 ? slotsTop : p_94128_1_ == 0 ? slotsBottom : slotsSides;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean canInsertItem(int p_102007_1_, ItemStack p_102007_2_, int p_102007_3_)
/*     */   {
/* 410 */     return isItemValidForSlot(p_102007_1_, p_102007_2_);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean canExtractItem(int p_102008_1_, ItemStack p_102008_2_, int p_102008_3_)
/*     */   {
/* 419 */     return (p_102008_3_ != 0) || (p_102008_1_ != 1) || (p_102008_2_.getItem() == Items.bucket);
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
	
}
@Override
public int[] getAccessibleSlotsFromSide(int p_94128_1_)
{
    return p_94128_1_ == 0 ? slotsBottom : (p_94128_1_ == 1 ? slotsTop : slotsSides);
}
}


/* Location:              C:\Users\Modding\Desktop\Pam's HarvestCraft 1.7.10k.deobf.jar!\com\pam\harvestcraft\TileEntityChurn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */