/*     */ package com.pam.harvestcraft;
/*     */ 
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockLiquid;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TileEntityPamFishTrap
/*     */   extends TileEntity
/*     */   implements IInventory
/*     */ {
/*  28 */   private ItemStack[] inventory = new ItemStack[19];
/*  29 */   public int runTime = 0;
/*  30 */   public int currentBeeRunTime = 0;
/*  31 */   public int produceTime = 0;
/*     */   
/*     */   public int getSizeInventory() {
/*  34 */     return this.inventory.length;
/*     */   }
/*     */   
/*     */   public ItemStack getStackInSlot(int slot) {
/*  38 */     return this.inventory[slot];
/*     */   }
/*     */   
/*     */   public ItemStack decrStackSize(int slot, int amount)
/*     */   {
/*  43 */     if (this.inventory[slot] == null) {
/*  44 */       setInventorySlotContents(slot, null);
/*  45 */       return null;
/*     */     }
/*     */     
/*  48 */     if (this.inventory[slot].stackSize <= amount) {
/*  49 */       ItemStack stack = this.inventory[slot];
/*  50 */       setInventorySlotContents(slot, null);
/*  51 */       return stack;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  56 */     ItemStack stack = this.inventory[slot].splitStack(amount);
/*     */     
/*     */ 
/*     */ 
/*  60 */     if (this.inventory[slot].stackSize <= 0) {
/*  61 */       setInventorySlotContents(slot, null);
/*     */     }
/*     */     
/*  64 */     this.markDirty();
/*     */     
/*  66 */     return stack;
/*     */   }
/*     */   
/*     */   public void setInventorySlotContents(int slot, ItemStack stack) {
/*  70 */     this.inventory[slot] = stack;
/*  71 */     if ((stack != null) && (stack.stackSize > getInventoryStackLimit())) {
/*  72 */       stack.stackSize = getInventoryStackLimit();
/*     */     }
/*     */   }
/*     */   
/*     */   public String getInvName()
/*     */   {
/*  78 */     return "Apiary";
/*     */   }
/*     */   
/*     */   public void readFromNBT(NBTTagCompound nbt) {
/*  82 */     super.readFromNBT(nbt);
/*  83 */     NBTTagList invTag = nbt.getTagList("Items", 10);
/*  84 */     this.inventory = new ItemStack[getSizeInventory()];
/*     */     
/*  86 */     for (int i = 0; i < invTag.tagCount(); i++) {
/*  87 */       NBTTagCompound stackTag = invTag.getCompoundTagAt(i);
/*     */       
/*  89 */       byte slot = stackTag.getByte("Slot");
/*  90 */       if ((slot >= 0) && (slot < this.inventory.length)) {
/*  91 */         this.inventory[slot] = ItemStack.loadItemStackFromNBT(stackTag);
/*     */       }
/*     */     }
/*     */     
/*  95 */     this.runTime = nbt.getShort("RunTime");
/*  96 */     this.produceTime = nbt.getShort("ProduceTime");
/*  97 */     this.currentBeeRunTime = getRunTime(this.inventory[1]);
/*     */   }
/*     */   
/*     */   public void writeToNBT(NBTTagCompound nbt) {
/* 101 */     super.writeToNBT(nbt);
/* 102 */     nbt.setShort("RunTime", (short)this.runTime);
/* 103 */     nbt.setShort("ProduceTime", (short)this.produceTime);
/* 104 */     NBTTagList intTag = new NBTTagList();
/*     */     
/* 106 */     for (int i = 0; i < this.inventory.length; i++) {
/* 107 */       if (this.inventory[i] != null) {
/* 108 */         NBTTagCompound stackTag = new NBTTagCompound();
/* 109 */         stackTag.setByte("Slot", (byte)i);
/* 110 */         this.inventory[i].writeToNBT(stackTag);
/* 111 */         intTag.appendTag(stackTag);
/*     */       }
/*     */     }
/*     */     
/* 115 */     nbt.setTag("Items", intTag);
/*     */   }
/*     */   
/*     */   public int getInventoryStackLimit() {
/* 119 */     return 64;
/*     */   }
/*     */   
/*     */   public int getRunTime() {
/* 123 */     byte radius = 2;
/* 124 */     int speed = 3500;
/* 125 */     World world = this.worldObj;
/* 126 */     int varX = this.xCoord;
/* 127 */     int varY = this.yCoord;
/* 128 */     int varZ = this.zCoord;
/*     */     
/* 130 */     for (int offsetX = -radius; offsetX <= radius; offsetX++) {
/* 131 */       for (int offsetZ = -radius; offsetZ <= radius; offsetZ++) {
/* 132 */         if ((offsetX * offsetX + offsetZ * offsetZ <= radius * radius) && ((offsetX != -(radius - 1)) || (offsetZ != -(radius - 1))) && ((offsetX != radius - 1) || (offsetZ != radius - 1)) && ((offsetX != radius - 1) || (offsetZ != -(radius - 1))) && ((offsetX != -(radius - 1)) || (offsetZ != radius - 1)))
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 137 */           Block blockAtCoords = world.getBlock(varX + offsetX, varY, varZ + offsetZ);
/*     */           
/* 139 */           if ((blockAtCoords instanceof BlockLiquid)) {
/* 140 */             speed = (int)(speed * 0.95D);
/*     */           }
/*     */           
/* 143 */           if (world.getBlock(varX + offsetX, varY, varZ + offsetZ) == BlockRegistry.pamfishTrap) {
/* 144 */             speed = (int)(speed / 0.85D);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 150 */     return speed;
/*     */   }
/*     */   
/*     */   public int countFlowers() {
/* 154 */     byte radius = 2;
/* 155 */     int count = 0;
/* 156 */     World world = this.worldObj;
/* 157 */     int varX = this.xCoord;
/* 158 */     int varY = this.yCoord;
/* 159 */     int varZ = this.zCoord;
/*     */     
/* 161 */     for (int offsetX = -radius; offsetX <= radius; offsetX++) {
/* 162 */       for (int offsetZ = -radius; offsetZ <= radius; offsetZ++) {
/* 163 */         if ((offsetX * offsetX + offsetZ * offsetZ <= radius * radius) && ((offsetX != -(radius - 1)) || (offsetZ != -(radius - 1))) && ((offsetX != radius - 1) || (offsetZ != radius - 1)) && ((offsetX != radius - 1) || (offsetZ != -(radius - 1))) && ((offsetX != -(radius - 1)) || (offsetZ != radius - 1)))
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 168 */           Block blockAtCoords = world.getBlock(varX + offsetX, varY, varZ + offsetZ);
/*     */           
/* 170 */           if ((blockAtCoords instanceof BlockLiquid)) {
/* 171 */             count++;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 177 */     return count;
/*     */   }
/*     */   
/*     */   public void updateEntity() {
/* 181 */     boolean isRunning = this.runTime > 0;
/* 182 */     boolean needsUpdate = false;
/*     */     
/* 184 */     if (isRunning) {
/* 185 */       this.runTime -= 1;
/*     */     }
/*     */     
/* 188 */     ItemStack queenBee = this.inventory[18];
/*     */     
/* 190 */     if (!this.worldObj.isRemote) {
/* 191 */       if ((this.runTime == 0) && (canRun())) {
/* 192 */         this.currentBeeRunTime = (this.runTime = getRunTime(queenBee));
/*     */         
/* 194 */         if (this.runTime > 0) {
/* 195 */           needsUpdate = true;
/* 196 */           if (queenBee != null) {
/* 197 */             if (queenBee.getItem().getContainerItem() != null) {
/* 198 */               queenBee = new ItemStack(queenBee.getItem().setFull3D());
/*     */             }
/*     */             else {
/* 201 */               queenBee.stackSize -= 0;
/*     */             }
/*     */             
/* 204 */             if (queenBee.stackSize == 0) {
/* 205 */               queenBee = null;
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */       
/* 211 */       if (canRun()) {
/* 212 */         this.produceTime += 1;
/*     */         
/* 214 */         if (this.produceTime >= Math.floor(getRunTime())) {
/* 215 */           this.produceTime = 0;
/* 216 */           run();
/* 217 */           needsUpdate = true;
/*     */         }
/*     */       } else {
/* 220 */         this.produceTime = 0;
/*     */       }
/*     */       
/* 223 */       if (isRunning != this.runTime > 0) {
/* 224 */         needsUpdate = true;
/*     */       }
/*     */     }
/*     */     
/* 228 */     if (needsUpdate) {
/* 229 */       this.markDirty();
/* 230 */       this.worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean canRun()
/*     */   {
/* 236 */     if (this.inventory[18] != null) {
/* 237 */       if (this.inventory[18].getItem() == ItemRegistry.fishtrapbaitItem)
/*     */       {
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
/*     */     
/* 251 */     if (this.inventory[18] != null)
/*     */     {
/* 253 */       if (ItemRegistry.enableharvestcraftfish)
/*     */       {
/* 255 */         int rndnum = rnd.nextInt(32);
/* 256 */         switch (rndnum) {
/*     */         case 0: 
/* 258 */           return new ItemStack(Items.fish, 1, 0);
/* 259 */         case 1:  return new ItemStack(Items.fish, 1, 1);
/* 260 */         case 2:  return new ItemStack(Items.fish, 1, 2);
/* 261 */         case 3:  return new ItemStack(Items.fish, 1, 3);
/* 262 */         case 4:  return new ItemStack(ItemRegistry.anchovyrawItem, 1, 0);
/* 263 */         case 5:  return new ItemStack(ItemRegistry.bassrawItem, 1, 0);
/* 264 */         case 6:  return new ItemStack(ItemRegistry.carprawItem, 1, 0);
/* 265 */         case 7:  return new ItemStack(ItemRegistry.catfishrawItem, 1, 0);
/* 266 */         case 8:  return new ItemStack(ItemRegistry.charrrawItem, 1, 0);
/* 267 */         case 9:  return new ItemStack(ItemRegistry.clamrawItem, 1, 0);
/* 268 */         case 10:  return new ItemStack(ItemRegistry.crabrawItem, 1, 0);
/* 269 */         case 11:  return new ItemStack(ItemRegistry.crayfishrawItem, 1, 0);
/* 270 */         case 12:  return new ItemStack(ItemRegistry.eelrawItem, 1, 0);
/* 271 */         case 13:  return new ItemStack(ItemRegistry.frograwItem, 1, 0);
/* 272 */         case 14:  return new ItemStack(ItemRegistry.grouperrawItem, 1, 0);
/* 273 */         case 15:  return new ItemStack(ItemRegistry.herringrawItem, 1, 0);
/* 274 */         case 16:  return new ItemStack(ItemRegistry.jellyfishrawItem, 1, 0);
/* 275 */         case 17:  return new ItemStack(ItemRegistry.mudfishrawItem, 1, 0);
/* 276 */         case 18:  return new ItemStack(ItemRegistry.octopusrawItem, 1, 0);
/* 277 */         case 19:  return new ItemStack(ItemRegistry.perchrawItem, 1, 0);
/* 278 */         case 20:  return new ItemStack(ItemRegistry.scalloprawItem, 1, 0);
/* 279 */         case 21:  return new ItemStack(ItemRegistry.shrimprawItem, 1, 0);
/* 280 */         case 22:  return new ItemStack(ItemRegistry.snailrawItem, 1, 0);
/* 281 */         case 23:  return new ItemStack(ItemRegistry.snapperrawItem, 1, 0);
/* 282 */         case 24:  return new ItemStack(ItemRegistry.tilapiarawItem, 1, 0);
/* 283 */         case 25:  return new ItemStack(ItemRegistry.troutrawItem, 1, 0);
/* 284 */         case 26:  return new ItemStack(ItemRegistry.tunarawItem, 1, 0);
/* 285 */         case 27:  return new ItemStack(ItemRegistry.turtlerawItem, 1, 0);
/* 286 */         case 28:  return new ItemStack(ItemRegistry.walleyerawItem, 1, 0);
/* 287 */         case 29:  return new ItemStack(Items.fish, 1, 0);
/* 288 */         case 30:  return new ItemStack(Items.fish, 1, 0);
/* 289 */         case 31:  return new ItemStack(ItemRegistry.greenheartfishItem, 1, 0);
/*     */         }
/*     */         
/*     */       }
/* 293 */       int rndnum = rnd.nextInt(11);
/* 294 */       switch (rndnum) {
/*     */       case 0: 
/* 296 */         return new ItemStack(Items.fish, 1, 0);
/* 297 */       case 1:  return new ItemStack(Items.fish, 1, 0);
/* 298 */       case 2:  return new ItemStack(Items.fish, 1, 0);
/* 299 */       case 3:  return new ItemStack(Items.fish, 1, 0);
/* 300 */       case 4:  return new ItemStack(Items.fish, 1, 0);
/* 301 */       case 5:  return new ItemStack(Items.fish, 1, 0);
/* 302 */       case 6:  return new ItemStack(Items.fish, 1, 0);
/* 303 */       case 7:  return new ItemStack(Items.fish, 1, 1);
/* 304 */       case 8:  return new ItemStack(Items.fish, 1, 1);
/* 305 */       case 9:  return new ItemStack(Items.fish, 1, 2);
/* 306 */       case 10:  return new ItemStack(Items.fish, 1, 3);
/*     */       }
/*     */     }
/* 309 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */   public void run()
/*     */   {
/* 315 */     ItemStack itemProduced = getComb();
/* 316 */     for (int i = 0; i < 18; i++) {
/* 317 */       if (this.inventory[i] == null) {
/* 318 */         decrStackSize(18, 1);
/* 319 */         this.inventory[i] = itemProduced.copy();
/* 320 */         break;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   int getRunTime(ItemStack stack) {
/* 326 */     if (stack == null) {
/* 327 */       return 0;
/*     */     }
/*     */     
/* 330 */     if (stack.getItem() == ItemRegistry.fishtrapbaitItem) {
/* 331 */       return 3200;
/*     */     }
/*     */     
/* 334 */     return 0;
/*     */   }
/*     */   
/*     */   public boolean isUseableByPlayer(EntityPlayer player) {
/* 338 */     if (this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this) {
/* 339 */       return false;
/*     */     }
/* 341 */     return player.getDistanceSq(this.xCoord + 0.5D, this.yCoord + 0.5D, this.zCoord + 0.5D) <= 64.0D;
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
/* 352 */     return null;
/*     */   }
/*     */   
/*     */   public boolean isInvNameLocalized() {
/* 356 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isStackValidForSlot(int slot, ItemStack stack)
/*     */   {
/* 361 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isItemValidForSlot(int slot, ItemStack stack)
/*     */   {
/* 366 */     return false;
/*     */   }
/*     */   
/*     */   public String getInventoryName()
/*     */   {
/* 371 */     return null;
/*     */   }
/*     */   
/*     */   public boolean isInventoryNameLocalized()
/*     */   {
/* 376 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public void func_70295_k_() {}
/*     */   
/*     */ 
/*     */   public Packet getDescriptionPacket()
/*     */   {
/* 385 */     NBTTagCompound tag = new NBTTagCompound();
/* 386 */     writeToNBT(tag);
/* 387 */     return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 1, tag);
/*     */   }
/*     */   
/*     */ 
/*     */   public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet)
/*     */   {
/* 393 */     readFromNBT(packet.func_148857_g());
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


/* Location:              C:\Users\Modding\Desktop\Pam's HarvestCraft 1.7.10k.deobf.jar!\com\pam\harvestcraft\TileEntityPamFishTrap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */