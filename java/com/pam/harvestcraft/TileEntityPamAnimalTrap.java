/*     */ package com.pam.harvestcraft;
/*     */ 
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockDirt;
/*     */ import net.minecraft.block.BlockGrass;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.network.NetworkManager;
/*     */ import net.minecraft.network.Packet;
/*     */ import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TileEntityPamAnimalTrap
/*     */   extends TileEntity
/*     */   implements IInventory
/*     */ {
/*  26 */   private ItemStack[] inventory = new ItemStack[19];
/*  27 */   public int runTime = 0;
/*  28 */   public int currentBeeRunTime = 0;
/*  29 */   public int produceTime = 0;
/*     */   
/*     */   public int getSizeInventory() {
/*  32 */     return this.inventory.length;
/*     */   }
/*     */   
/*     */   public ItemStack getStackInSlot(int slot) {
/*  36 */     return this.inventory[slot];
/*     */   }
/*     */   
/*     */   public ItemStack decrStackSize(int slot, int amount)
/*     */   {
/*  41 */     if (this.inventory[slot] == null) {
/*  42 */       setInventorySlotContents(slot, null);
/*  43 */       return null;
/*     */     }
/*     */     
/*  46 */     if (this.inventory[slot].stackSize <= amount) {
/*  47 */       ItemStack stack = this.inventory[slot];
/*  48 */       setInventorySlotContents(slot, null);
/*  49 */       return stack;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  54 */     ItemStack stack = this.inventory[slot].splitStack(amount);
/*     */     
/*     */ 
/*     */ 
/*  58 */     if (this.inventory[slot].stackSize <= 0) {
/*  59 */       setInventorySlotContents(slot, null);
/*     */     }
/*     */     
/*  62 */     this.markDirty();
/*     */     
/*  64 */     return stack;
/*     */   }
/*     */   
/*     */   public void setInventorySlotContents(int slot, ItemStack stack) {
/*  68 */     this.inventory[slot] = stack;
/*  69 */     if ((stack != null) && (stack.stackSize > getInventoryStackLimit())) {
/*  70 */       stack.stackSize = getInventoryStackLimit();
/*     */     }
/*     */   }
/*     */   
/*     */   public String getInvName()
/*     */   {
/*  76 */     return "Apiary";
/*     */   }
/*     */   
/*     */   public void readFromNBT(NBTTagCompound nbt) {
/*  80 */     super.readFromNBT(nbt);
/*  81 */     NBTTagList invTag = nbt.getTagList("Items", 10);
/*  82 */     this.inventory = new ItemStack[getSizeInventory()];
/*     */     
/*  84 */     for (int i = 0; i < invTag.tagCount(); i++) {
/*  85 */       NBTTagCompound stackTag = invTag.getCompoundTagAt(i);
/*     */       
/*  87 */       byte slot = stackTag.getByte("Slot");
/*  88 */       if ((slot >= 0) && (slot < this.inventory.length)) {
/*  89 */         this.inventory[slot] = ItemStack.loadItemStackFromNBT(stackTag);
/*     */       }
/*     */     }
/*     */     
/*  93 */     this.runTime = nbt.getShort("RunTime");
/*  94 */     this.produceTime = nbt.getShort("ProduceTime");
/*  95 */     this.currentBeeRunTime = getRunTime(this.inventory[1]);
/*     */   }
/*     */   
/*     */   public void writeToNBT(NBTTagCompound nbt) {
/*  99 */     super.writeToNBT(nbt);
/* 100 */     nbt.setShort("RunTime", (short)this.runTime);
/* 101 */     nbt.setShort("ProduceTime", (short)this.produceTime);
/* 102 */     NBTTagList intTag = new NBTTagList();
/*     */     
/* 104 */     for (int i = 0; i < this.inventory.length; i++) {
/* 105 */       if (this.inventory[i] != null) {
/* 106 */         NBTTagCompound stackTag = new NBTTagCompound();
/* 107 */         stackTag.setByte("Slot", (byte)i);
/* 108 */         this.inventory[i].writeToNBT(stackTag);
/* 109 */         intTag.appendTag(stackTag);
/*     */       }
/*     */     }
/*     */     
/* 113 */     nbt.setTag("Items", intTag);
/*     */   }
/*     */   
/*     */   public int getInventoryStackLimit() {
/* 117 */     return 64;
/*     */   }
/*     */   
/*     */   public int getRunTime() {
/* 121 */     byte radius = 2;
/* 122 */     int speed = 3500;
/* 123 */     World world = this.worldObj;
/* 124 */     int varX = this.xCoord;
/* 125 */     int varY = this.yCoord;
/* 126 */     int varZ = this.zCoord;
/*     */     
/* 128 */     for (int offsetX = -radius; offsetX <= radius; offsetX++) {
/* 129 */       for (int offsetZ = -radius; offsetZ <= radius; offsetZ++) {
/* 130 */         if ((offsetX * offsetX + offsetZ * offsetZ <= radius * radius) && ((offsetX != -(radius - 1)) || (offsetZ != -(radius - 1))) && ((offsetX != radius - 1) || (offsetZ != radius - 1)) && ((offsetX != radius - 1) || (offsetZ != -(radius - 1))) && ((offsetX != -(radius - 1)) || (offsetZ != radius - 1)))
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 135 */           Block blockAtCoords = world.getBlock(varX + offsetX, varY, varZ + offsetZ);
/*     */           
/* 137 */           if (((blockAtCoords instanceof BlockDirt)) || ((blockAtCoords instanceof BlockGrass))) {
/* 138 */             speed = (int)(speed * 0.95D);
/*     */           }
/*     */           
/* 141 */           if (world.getBlock(varX + offsetX, varY, varZ + offsetZ) == BlockRegistry.pamanimalTrap) {
/* 142 */             speed = (int)(speed / 0.85D);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 148 */     return speed;
/*     */   }
/*     */   
/*     */   public int countFlowers() {
/* 152 */     byte radius = 2;
/* 153 */     int count = 0;
/* 154 */     World world = this.worldObj;
/* 155 */     int varX = this.xCoord;
/* 156 */     int varY = this.yCoord;
/* 157 */     int varZ = this.zCoord;
/*     */     
/* 159 */     for (int offsetX = -radius; offsetX <= radius; offsetX++) {
/* 160 */       for (int offsetZ = -radius; offsetZ <= radius; offsetZ++) {
/* 161 */         if ((offsetX * offsetX + offsetZ * offsetZ <= radius * radius) && ((offsetX != -(radius - 1)) || (offsetZ != -(radius - 1))) && ((offsetX != radius - 1) || (offsetZ != radius - 1)) && ((offsetX != radius - 1) || (offsetZ != -(radius - 1))) && ((offsetX != -(radius - 1)) || (offsetZ != radius - 1)))
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 166 */           Block blockAtCoords = world.getBlock(varX + offsetX, varY, varZ + offsetZ);
/*     */           
/* 168 */           if (((blockAtCoords instanceof BlockDirt)) || ((blockAtCoords instanceof BlockGrass))) {
/* 169 */             count++;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 175 */     return count;
/*     */   }
/*     */   
/*     */   public void updateEntity() {
/* 179 */     boolean isRunning = this.runTime > 0;
/* 180 */     boolean needsUpdate = false;
/*     */     
/* 182 */     if (isRunning) {
/* 183 */       this.runTime -= 1;
/*     */     }
/*     */     
/* 186 */     ItemStack queenBee = this.inventory[18];
/*     */     
/* 188 */     if (!this.worldObj.isRemote) {
/* 189 */       if ((this.runTime == 0) && (canRun())) {
/* 190 */         this.currentBeeRunTime = (this.runTime = getRunTime(queenBee));
/*     */         
/* 192 */         if (this.runTime > 0) {
/* 193 */           needsUpdate = true;
/* 194 */           if (queenBee != null) {
/* 195 */             if (queenBee.getItem().getContainerItem() != null) {
/* 196 */               queenBee = new ItemStack(queenBee.getItem().setFull3D());
/*     */             }
/*     */             else {
/* 199 */               queenBee.stackSize -= 0;
/*     */             }
/*     */             
/* 202 */             if (queenBee.stackSize == 0) {
/* 203 */               queenBee = null;
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */       
/* 209 */       if (canRun()) {
/* 210 */         this.produceTime += 1;
/*     */         
/* 212 */         if (this.produceTime >= Math.floor(getRunTime())) {
/* 213 */           this.produceTime = 0;
/* 214 */           run();
/* 215 */           needsUpdate = true;
/*     */         }
/*     */       } else {
/* 218 */         this.produceTime = 0;
/*     */       }
/*     */       
/* 221 */       if (isRunning != this.runTime > 0) {
/* 222 */         needsUpdate = true;
/*     */       }
/*     */     }
/*     */     
/* 226 */     if (needsUpdate) {
/* 227 */       this.markDirty();
/* 228 */       this.worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean canRun()
/*     */   {
/* 234 */     if (this.inventory[18] != null) {
/* 235 */       if ((this.inventory[18].getItem() == ItemRegistry.grainbaitItem) || (this.inventory[18].getItem() == ItemRegistry.fruitbaitItem) || (this.inventory[18].getItem() == ItemRegistry.veggiebaitItem))
/*     */       {
/*     */ 
/*     */ 
/* 239 */         if (countFlowers() >= 5) {
/* 240 */           return true;
/*     */         }
/*     */       }
/*     */     } else
/* 244 */       return false;
/* 245 */     return false;
/*     */   }
/*     */   
/*     */   public ItemStack getComb() {
/* 249 */     Random rnd = new Random();
/* 250 */     if (this.inventory[18] != null)
/*     */     {
/* 252 */       if (this.inventory[18].getItem() == ItemRegistry.grainbaitItem)
/*     */       {
/* 254 */         int rndnum = rnd.nextInt(11);
/* 255 */         switch (rndnum) {
/*     */         case 0: 
/* 257 */           return new ItemStack(ItemRegistry.turkeyrawItem, 1, 0);
/* 258 */         case 1:  return new ItemStack(Items.beef, 1, 0);
/* 259 */         case 2:  return new ItemStack(Items.chicken, 1, 0);
/* 260 */         case 3:  return new ItemStack(Items.leather, 1, 0);
/* 261 */         case 4:  return new ItemStack(Items.feather, 1, 0);
/* 262 */         case 5:  return new ItemStack(Items.egg, 1, 0);
/* 263 */         case 6:  return new ItemStack(Items.bone, 1, 0);
/* 264 */         case 7:  return new ItemStack(Items.chicken, 1, 0);
/* 265 */         case 8:  return new ItemStack(Items.chicken, 1, 0);
/* 266 */         case 9:  return new ItemStack(ItemRegistry.turkeyrawItem, 1, 0);
/* 267 */         case 10:  return new ItemStack(Items.feather, 1, 0);
/*     */         }
/*     */         
/*     */       }
/* 271 */       if (this.inventory[18].getItem() == ItemRegistry.fruitbaitItem)
/*     */       {
/* 273 */         int rndnum = rnd.nextInt(11);
/* 274 */         switch (rndnum) {
/*     */         case 0: 
/* 276 */           return new ItemStack(ItemRegistry.rabbitrawItem, 1, 0);
/* 277 */         case 1:  return new ItemStack(Items.leather, 1, 0);
/* 278 */         case 2:  return new ItemStack(Items.feather, 1, 0);
/* 279 */         case 3:  return new ItemStack(Items.egg, 1, 0);
/* 280 */         case 4:  return new ItemStack(Items.bone, 1, 0);
/* 281 */         case 5:  return new ItemStack(ItemRegistry.rabbitrawItem, 1, 0);
/* 282 */         case 6:  return new ItemStack(ItemRegistry.rabbitrawItem, 1, 0);
/* 283 */         case 7:  return new ItemStack(Items.chicken, 1, 0);
/* 284 */         case 8:  return new ItemStack(Items.chicken, 1, 0);
/* 285 */         case 9:  return new ItemStack(Items.chicken, 1, 0);
/* 286 */         case 10:  return new ItemStack(Items.feather, 1, 0);
/*     */         }
/*     */       }
/* 289 */       if (this.inventory[18].getItem() == ItemRegistry.veggiebaitItem)
/*     */       {
/* 291 */         int rndnum = rnd.nextInt(11);
/* 292 */         switch (rndnum) {
/*     */         case 0: 
/* 294 */           return new ItemStack(ItemRegistry.venisonrawItem, 1, 0);
/* 295 */         case 1:  return new ItemStack(ItemRegistry.muttonrawItem, 1, 0);
/* 296 */         case 2:  return new ItemStack(Items.porkchop, 1, 0);
/* 297 */         case 3:  return new ItemStack(Items.leather, 1, 0);
/* 298 */         case 4:  return new ItemStack(Items.feather, 1, 0);
/* 299 */         case 5:  return new ItemStack(Items.egg, 1, 0);
/* 300 */         case 6:  return new ItemStack(Items.bone, 1, 0);
/* 301 */         case 7:  return new ItemStack(Items.chicken, 1, 0);
/* 302 */         case 8:  return new ItemStack(Items.chicken, 1, 0);
/* 303 */         case 9:  return new ItemStack(Items.chicken, 1, 0);
/* 304 */         case 10:  return new ItemStack(Items.feather, 1, 0);
/*     */         }
/*     */       }
/*     */     }
/* 308 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */   public void run()
/*     */   {
/* 314 */     ItemStack itemProduced = getComb();
/* 315 */     for (int i = 0; i < 18; i++) {
/* 316 */       if (this.inventory[i] == null) {
/* 317 */         decrStackSize(18, 1);
/* 318 */         this.inventory[i] = itemProduced.copy();
/* 319 */         break;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   int getRunTime(ItemStack stack)
/*     */   {
/* 327 */     if (stack == null) {
/* 328 */       return 0;
/*     */     }
/*     */     
/* 331 */     if ((stack.getItem() == ItemRegistry.grainbaitItem) || (stack.getItem() == ItemRegistry.fruitbaitItem) || (stack.getItem() == ItemRegistry.veggiebaitItem))
/*     */     {
/*     */ 
/* 334 */       return 3200;
/*     */     }
/*     */     
/* 337 */     return 0;
/*     */   }
/*     */   
/*     */   public boolean isUseableByPlayer(EntityPlayer player) {
/* 341 */     if (this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this) {
/* 342 */       return false;
/*     */     }
/* 344 */     return player.getDistanceSq(this.xCoord + 0.5D, this.yCoord + 0.5D, this.zCoord + 0.5D) <= 64.0D;
/*     */   }
/*     */   
/*     */ 
/*     */   public void openChest() {}
/*     */   
/*     */ 
/*     */   public void closeChest() {}
/*     */   
/*     */   public ItemStack getStackInSlotOnClosing(int slot)
/*     */   {
/* 355 */     return null;
/*     */   }
/*     */   
/*     */   public boolean isInvNameLocalized() {
/* 359 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isStackValidForSlot(int slot, ItemStack stack)
/*     */   {
/* 364 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isItemValidForSlot(int slot, ItemStack stack)
/*     */   {
/* 369 */     return false;
/*     */   }
/*     */   
/*     */   public String getInventoryName()
/*     */   {
/* 374 */     return null;
/*     */   }
/*     */   
/*     */   public boolean isInventoryNameLocalized()
/*     */   {
/* 379 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public void func_70295_k_() {}
/*     */   
/*     */ 
/*     */   public Packet getDescriptionPacket()
/*     */   {
/* 388 */     NBTTagCompound tag = new NBTTagCompound();
/* 389 */     writeToNBT(tag);
/* 390 */     return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 1, tag);
/*     */   }
/*     */   
/*     */ 
/*     */   public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet)
/*     */   {
/* 396 */     readFromNBT(packet.func_148857_g());
/*     */   }
/*     */   
/*     */   public void func_70305_f() {}
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


/* Location:              C:\Users\Modding\Desktop\Pam's HarvestCraft 1.7.10k.deobf.jar!\com\pam\harvestcraft\TileEntityPamAnimalTrap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */