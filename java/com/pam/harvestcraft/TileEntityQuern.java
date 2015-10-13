/*     */ package com.pam.harvestcraft;
/*     */ 
/*     */ import cpw.mods.fml.common.registry.GameRegistry;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
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
/*     */ public class TileEntityQuern
/*     */   extends TileEntity
/*     */   implements ISidedInventory
/*     */ {
/*  24 */   private static final int[] slotsTop = { 0 };
/*  25 */   private static final int[] slotsBottom = { 2, 1 };
/*  26 */   private static final int[] slotsSides = { 1 };
/*     */   
/*  28 */   private ItemStack[] quernItemStacks = new ItemStack[3];
/*     */   
/*     */   public int quernBurnTime;
/*     */   
/*     */   public int currentItemBurnTime;
/*     */   
/*     */   public int quernCookTime;
/*     */   
/*     */   private String field_145958_o;
/*     */   
/*     */   private static final String __OBFID = "CL_00000357";
/*     */   
/*     */ 
/*     */   public int getSizeInventory()
/*     */   {
/*  43 */     return this.quernItemStacks.length;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public ItemStack getStackInSlot(int p_70301_1_)
/*     */   {
/*  51 */     return this.quernItemStacks[p_70301_1_];
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public ItemStack decrStackSize(int p_70298_1_, int p_70298_2_)
/*     */   {
/*  60 */     if (this.quernItemStacks[p_70298_1_] != null)
/*     */     {
/*     */ 
/*     */ 
/*  64 */       if (this.quernItemStacks[p_70298_1_].stackSize <= p_70298_2_)
/*     */       {
/*  66 */         ItemStack itemstack = this.quernItemStacks[p_70298_1_];
/*  67 */         this.quernItemStacks[p_70298_1_] = null;
/*  68 */         return itemstack;
/*     */       }
/*     */       
/*     */ 
/*  72 */       ItemStack itemstack = this.quernItemStacks[p_70298_1_].splitStack(p_70298_2_);
/*     */       
/*  74 */       if (this.quernItemStacks[p_70298_1_].stackSize == 0)
/*     */       {
/*  76 */         this.quernItemStacks[p_70298_1_] = null;
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
/*  94 */     if (this.quernItemStacks[p_70304_1_] != null)
/*     */     {
/*  96 */       ItemStack itemstack = this.quernItemStacks[p_70304_1_];
/*  97 */       this.quernItemStacks[p_70304_1_] = null;
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
/* 111 */     this.quernItemStacks[p_70299_1_] = p_70299_2_;
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
/* 124 */     return isInventoryNameLocalized() ? this.field_145958_o : "Quern";
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
/* 144 */     this.quernItemStacks = new ItemStack[getSizeInventory()];
/*     */     
/* 146 */     for (int i = 0; i < nbttaglist.tagCount(); i++)
/*     */     {
/* 148 */       NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
/* 149 */       byte b0 = nbttagcompound1.getByte("Slot");
/*     */       
/* 151 */       if ((b0 >= 0) && (b0 < this.quernItemStacks.length))
/*     */       {
/* 153 */         this.quernItemStacks[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
/*     */       }
/*     */     }
/*     */     
/* 157 */     this.quernBurnTime = p_145839_1_.getShort("BurnTime");
/* 158 */     this.quernCookTime = p_145839_1_.getShort("CookTime");
/* 159 */     this.currentItemBurnTime = getItemBurnTime(this.quernItemStacks[1]);
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
/* 170 */     p_145841_1_.setShort("BurnTime", (short)this.quernBurnTime);
/* 171 */     p_145841_1_.setShort("CookTime", (short)this.quernCookTime);
/* 172 */     NBTTagList nbttaglist = new NBTTagList();
/*     */     
/* 174 */     for (int i = 0; i < this.quernItemStacks.length; i++)
/*     */     {
/* 176 */       if (this.quernItemStacks[i] != null)
/*     */       {
/* 178 */         NBTTagCompound nbttagcompound1 = new NBTTagCompound();
/* 179 */         nbttagcompound1.setByte("Slot", (byte)i);
/* 180 */         this.quernItemStacks[i].writeToNBT(nbttagcompound1);
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
/* 208 */     return this.quernCookTime * p_145953_1_ / 200;
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
/* 223 */     return this.quernBurnTime * p_145955_1_ / this.currentItemBurnTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isBurning()
/*     */   {
/* 231 */     return this.quernBurnTime > 0;
/*     */   }
/*     */   
/*     */   public void updateEntity()
/*     */   {
/* 236 */     boolean flag = this.quernBurnTime > 0;
/* 237 */     boolean flag1 = false;
/*     */     
/* 239 */     if (this.quernBurnTime > 0)
/*     */     {
/* 241 */       this.quernBurnTime -= 1;
/*     */     }
/*     */     
/* 244 */     if (!this.worldObj.isRemote)
/*     */     {
/* 246 */       if ((this.quernBurnTime != 0) || ((this.quernItemStacks[1] != null) && (this.quernItemStacks[0] != null)))
/*     */       {
/* 248 */         if ((this.quernBurnTime == 0) && (canSmelt()))
/*     */         {
/* 250 */           this.currentItemBurnTime = (this.quernBurnTime = getItemBurnTime(this.quernItemStacks[1]));
/*     */           
/* 252 */           if (this.quernBurnTime > 0)
/*     */           {
/* 254 */             flag1 = true;
/*     */             
/* 256 */             if (this.quernItemStacks[1] != null)
/*     */             {
/* 258 */               this.quernItemStacks[1].stackSize -= 1;
/*     */               
/* 260 */               if (this.quernItemStacks[1].stackSize == 0)
/*     */               {
/* 262 */                 this.quernItemStacks[1] = this.quernItemStacks[1].getItem().getContainerItem(this.quernItemStacks[1]);
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */         
/* 268 */         if ((isBurning()) && (canSmelt()))
/*     */         {
/* 270 */           this.quernCookTime += 1;
/*     */           
/* 272 */           if (this.quernCookTime == 200)
/*     */           {
/* 274 */             this.quernCookTime = 0;
/* 275 */             smeltItem();
/* 276 */             flag1 = true;
/*     */           }
/*     */         }
/*     */         else
/*     */         {
/* 281 */           this.quernCookTime = 0;
/*     */         }
/*     */       }
/*     */       
/* 285 */       if (flag != this.quernBurnTime > 0)
/*     */       {
/* 287 */         flag1 = true;
/* 288 */         BlockPamQuern.updateQuernBlockState(this.quernBurnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
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
/* 303 */     if (this.quernItemStacks[0] == null)
/*     */     {
/* 305 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 309 */     ItemStack itemstack = QuernRecipes.smelting().getSmeltingResult(this.quernItemStacks[0]);
/* 310 */     if (itemstack == null) return false;
/* 311 */     if (this.quernItemStacks[2] == null) return true;
/* 312 */     if (!this.quernItemStacks[2].isItemEqual(itemstack)) return false;
/* 313 */     int result = this.quernItemStacks[2].stackSize + itemstack.stackSize;
/* 314 */     return (result <= getInventoryStackLimit()) && (result <= this.quernItemStacks[2].getMaxStackSize());
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
/* 325 */       ItemStack itemstack = QuernRecipes.smelting().getSmeltingResult(this.quernItemStacks[0]);
/*     */       
/* 327 */       if (this.quernItemStacks[2] == null)
/*     */       {
/* 329 */         this.quernItemStacks[2] = itemstack.copy();
/*     */       }
/* 331 */       else if (this.quernItemStacks[2].getItem() == itemstack.getItem())
/*     */       {
/* 333 */         this.quernItemStacks[2].stackSize += itemstack.stackSize;
/*     */       }
/*     */       
/* 336 */       this.quernItemStacks[0].stackSize -= 1;
/*     */       
/* 338 */       if (this.quernItemStacks[0].stackSize <= 0)
/*     */       {
/* 340 */         this.quernItemStacks[0] = null;
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
/* 360 */     if (item == Item.getItemFromBlock(Blocks.stone_pressure_plate)) { return 1600;
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
public int[] getAccessibleSlotsFromSide(int p_94128_1_) {
	// TODO Auto-generated method stub
	return null;
} }


/* Location:              C:\Users\Modding\Desktop\Pam's HarvestCraft 1.7.10k.deobf.jar!\com\pam\harvestcraft\TileEntityQuern.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */