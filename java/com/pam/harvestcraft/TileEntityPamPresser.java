/*     */ package com.pam.harvestcraft;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.inventory.ISidedInventory;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.network.NetworkManager;
/*     */ import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class TileEntityPamPresser extends TileEntity implements ISidedInventory
/*     */ {
/*  17 */   private ItemStack[] combPresserItemStacks = new ItemStack[3];
/*     */   public int combPresserBurnTime;
/*     */   public int currentCombPresserBurnTime;
/*     */   public int combPresserCookTime;
/*  21 */   public int meta = 0;
/*     */   
/*  23 */   private static final int[] slots_top = { 0 };
/*  24 */   private static final int[] slots_bottom = { 2, 1 };
/*     */   
/*     */   public int getSizeInventory()
/*     */   {
/*  28 */     return this.combPresserItemStacks.length;
/*     */   }
/*     */   
/*     */   public ItemStack getStackInSlot(int par1) {
/*  32 */     return this.combPresserItemStacks[par1];
/*     */   }
/*     */   
/*     */   public ItemStack decrStackSize(int par1, int par2) {
/*  36 */     if (this.combPresserItemStacks[par1] != null)
/*     */     {
/*  38 */       if (this.combPresserItemStacks[par1].stackSize <= par2) {
/*  39 */         ItemStack var3 = this.combPresserItemStacks[par1];
/*  40 */         this.combPresserItemStacks[par1] = null;
/*  41 */         return var3;
/*     */       }
/*  43 */       ItemStack var3 = this.combPresserItemStacks[par1].splitStack(par2);
/*  44 */       if (this.combPresserItemStacks[par1].stackSize == 0) {
/*  45 */         this.combPresserItemStacks[par1] = null;
/*     */       }
/*     */       
/*  48 */       return var3;
/*     */     }
/*     */     
/*  51 */     return null;
/*     */   }
/*     */   
/*     */   public void setInventorySlotContents(int par1, ItemStack par2ItemStack)
/*     */   {
/*  56 */     this.combPresserItemStacks[par1] = par2ItemStack;
/*  57 */     if ((par2ItemStack != null) && (par2ItemStack.stackSize > getInventoryStackLimit())) {
/*  58 */       par2ItemStack.stackSize = getInventoryStackLimit();
/*     */     }
/*     */   }
/*     */   
/*     */   public String getInvName()
/*     */   {
/*  64 */     return "Presser";
/*     */   }
/*     */   
/*     */   public void readFromNBT(NBTTagCompound par1NBTTagCompound) {
/*  68 */     super.readFromNBT(par1NBTTagCompound);
/*  69 */     NBTTagList var2 = par1NBTTagCompound.getTagList("Items", 10);
/*  70 */     this.combPresserItemStacks = new ItemStack[getSizeInventory()];
/*     */     
/*  72 */     for (int var3 = 0; var3 < var2.tagCount(); var3++) {
/*  73 */       NBTTagCompound var4 = var2.getCompoundTagAt(var3);
/*  74 */       byte var5 = var4.getByte("Slot");
/*  75 */       if ((var5 >= 0) && (var5 < this.combPresserItemStacks.length)) {
/*  76 */         this.combPresserItemStacks[var5] = ItemStack.loadItemStackFromNBT(var4);
/*     */       }
/*     */     }
/*     */     
/*  80 */     this.combPresserBurnTime = par1NBTTagCompound.getShort("BurnTime");
/*  81 */     this.combPresserCookTime = par1NBTTagCompound.getShort("CookTime");
/*  82 */     this.currentCombPresserBurnTime = getItemBurnTime(this.combPresserItemStacks[1]);
/*     */   }
/*     */   
/*     */   public void writeToNBT(NBTTagCompound par1NBTTagCompound) {
/*  86 */     super.writeToNBT(par1NBTTagCompound);
/*  87 */     par1NBTTagCompound.setShort("BurnTime", (short)this.combPresserBurnTime);
/*  88 */     par1NBTTagCompound.setShort("CookTime", (short)this.combPresserCookTime);
/*  89 */     NBTTagList var2 = new NBTTagList();
/*     */     
/*  91 */     for (int var3 = 0; var3 < this.combPresserItemStacks.length; var3++) {
/*  92 */       if (this.combPresserItemStacks[var3] != null) {
/*  93 */         NBTTagCompound var4 = new NBTTagCompound();
/*  94 */         var4.setByte("Slot", (byte)var3);
/*  95 */         this.combPresserItemStacks[var3].writeToNBT(var4);
/*  96 */         var2.appendTag(var4);
/*     */       }
/*     */     }
/*     */     
/* 100 */     par1NBTTagCompound.setTag("Items", var2);
/*     */   }
/*     */   
/*     */   public int getInventoryStackLimit() {
/* 104 */     return 64;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int getCookProgressScaled(int par1) {
/* 109 */     return this.combPresserCookTime * par1 / 125;
/*     */   }
/*     */   
/*     */   public boolean isBurning() {
/* 113 */     return this.combPresserBurnTime > 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public void updateEntity()
/*     */   {
/* 119 */     boolean var2 = false;
/* 120 */     if (this.combPresserBurnTime > 0)
/*     */     {
/* 122 */       this.combPresserBurnTime -= 1;
/*     */     }
/*     */     
/* 125 */     if (!this.worldObj.isRemote) {
/* 126 */       if ((this.combPresserBurnTime == 0) && (canRun()))
/*     */       {
/* 128 */         this.currentCombPresserBurnTime = (this.combPresserBurnTime = getItemBurnTime(this.combPresserItemStacks[1]));
/*     */       }
/*     */       
/*     */ 
/* 132 */       if (canRun())
/*     */       {
/* 134 */         BlockPamPresser.updateBlockState(true, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
/* 135 */         this.combPresserCookTime += 1;
/* 136 */         if (this.combPresserCookTime == 125)
/*     */         {
/* 138 */           this.combPresserCookTime = 0;
/* 139 */           pressComb();
/* 140 */           var2 = true;
/*     */         }
/*     */       } else {
/* 143 */         BlockPamPresser.updateBlockState(false, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
/* 144 */         this.combPresserCookTime = 0;
/*     */       }
/*     */       
/* 147 */       if (var2 != this.combPresserBurnTime > 0)
/*     */       {
/* 149 */         var2 = true;
/*     */       }
/*     */     }
/*     */     
/* 153 */     if (var2) {
/* 154 */       this.markDirty();
/*     */     }
/*     */   }
/*     */   
/*     */   public int getDamage(ItemStack par1ItemStack)
/*     */   {
/* 160 */     return par1ItemStack.getItemDamage();
/*     */   }
/*     */   
/*     */   private boolean canRun()
/*     */   {
/* 165 */     if (this.combPresserItemStacks[0] == null)
/*     */     {
/* 167 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 171 */     ItemStack itemstack = PresserRecipes.smelting().getSmeltingResult(this.combPresserItemStacks[0]);
/* 172 */     if (itemstack == null) return false;
/* 173 */     if (this.combPresserItemStacks[1] == null) return true;
/* 174 */     if (!this.combPresserItemStacks[1].isItemEqual(itemstack)) return false;
/* 175 */     int result = this.combPresserItemStacks[1].stackSize + itemstack.stackSize;
/* 176 */     return (result <= getInventoryStackLimit()) && (result <= this.combPresserItemStacks[1].getMaxStackSize());
/*     */   }
/*     */   
/*     */ 
/*     */   public void pressComb()
/*     */   {
/* 182 */     if (canRun())
/*     */     {
/* 184 */       ItemStack itemstack = PresserRecipes.smelting().getSmeltingResult(this.combPresserItemStacks[0]);
/*     */       
/* 186 */       if (this.combPresserItemStacks[1] == null)
/*     */       {
/* 188 */         this.combPresserItemStacks[1] = itemstack.copy();
/*     */       }
/* 190 */       else if (this.combPresserItemStacks[1].getItem() == itemstack.getItem())
/*     */       {
/* 192 */         this.combPresserItemStacks[1].stackSize += itemstack.stackSize;
/*     */       }
/*     */       
/* 195 */       this.combPresserItemStacks[0].stackSize -= 1;
/*     */       
/* 197 */       if (this.combPresserItemStacks[0].stackSize <= 0)
/*     */       {
/* 199 */         this.combPresserItemStacks[0] = null;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private int getItemBurnTime(ItemStack par0ItemStack) {
/* 205 */     return 300;
/*     */   }
/*     */   
/*     */   public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer) {
/* 209 */     return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) == this;
/*     */   }
/*     */   
/*     */   public void openChest() {}
/*     */   
/*     */   public void closeChest() {}
/*     */   
/*     */   public ItemStack getStackInSlotOnClosing(int var1) {
/* 217 */     return null;
/*     */   }
/*     */   
/*     */   public boolean isInvNameLocalized() {
/* 221 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isStackValidForSlot(int i, ItemStack itemstack) {
/* 225 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isItemValidForSlot(int par1, ItemStack par2ItemStack)
/*     */   {
/* 233 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int[] func_94128_d(int par1)
/*     */   {
/* 242 */     return par1 == 1 ? slots_top : par1 == 0 ? slots_bottom : slots_top;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean canInsertItem(int par1, ItemStack par2ItemStack, int par3)
/*     */   {
/* 251 */     return isItemValidForSlot(par1, par2ItemStack);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean canExtractItem(int par1, ItemStack par2ItemStack, int par3)
/*     */   {
/* 260 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public String getInventoryName()
/*     */   {
/* 266 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isInventoryNameLocalized()
/*     */   {
/* 272 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void func_70295_k_() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void func_70305_f() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public net.minecraft.network.Packet getDescriptionPacket()
/*     */   {
/* 289 */     NBTTagCompound tag = new NBTTagCompound();
/* 290 */     writeToNBT(tag);
/* 291 */     return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 1, tag);
/*     */   }
/*     */   
/*     */   public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet)
/*     */   {
/* 296 */     readFromNBT(packet.func_148857_g());
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


/* Location:              C:\Users\Modding\Desktop\Pam's HarvestCraft 1.7.10k.deobf.jar!\com\pam\harvestcraft\TileEntityPamPresser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */