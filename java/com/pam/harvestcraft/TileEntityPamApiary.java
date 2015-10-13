/*     */ package com.pam.harvestcraft;
/*     */ 
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockCrops;
/*     */ import net.minecraft.block.BlockFlower;
/*     */ import net.minecraft.entity.player.EntityPlayer;
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
/*     */ public class TileEntityPamApiary
/*     */   extends TileEntity implements IInventory
/*     */ {
/*  22 */   private ItemStack[] inventory = new ItemStack[19];
/*  23 */   public int runTime = 0;
/*  24 */   public int currentBeeRunTime = 0;
/*  25 */   public int produceTime = 0;
/*     */   
/*     */   public int getSizeInventory() {
/*  28 */     return this.inventory.length;
/*     */   }
/*     */   
/*     */   public ItemStack getStackInSlot(int slot) {
/*  32 */     return this.inventory[slot];
/*     */   }
/*     */   
/*     */   public ItemStack decrStackSize(int slot, int amount)
/*     */   {
/*  37 */     if (this.inventory[slot] == null) {
/*  38 */       setInventorySlotContents(slot, null);
/*  39 */       return null;
/*     */     }
/*     */     
/*  42 */     if (this.inventory[slot].stackSize <= amount) {
/*  43 */       ItemStack stack = this.inventory[slot];
/*  44 */       setInventorySlotContents(slot, null);
/*  45 */       return stack;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  50 */     ItemStack stack = this.inventory[slot].splitStack(amount);
/*     */     
/*     */ 
/*     */ 
/*  54 */     if (this.inventory[slot].stackSize <= 0) {
/*  55 */       setInventorySlotContents(slot, null);
/*     */     }
/*     */     
/*  58 */     this.markDirty();
/*     */     
/*  60 */     return stack;
/*     */   }
/*     */   
/*     */   public void setInventorySlotContents(int slot, ItemStack stack) {
/*  64 */     this.inventory[slot] = stack;
/*  65 */     if ((stack != null) && (stack.stackSize > getInventoryStackLimit())) {
/*  66 */       stack.stackSize = getInventoryStackLimit();
/*     */     }
/*     */   }
/*     */   
/*     */   public String getInvName()
/*     */   {
/*  72 */     return "Apiary";
/*     */   }
/*     */   
/*     */   public void readFromNBT(NBTTagCompound nbt) {
/*  76 */     super.readFromNBT(nbt);
/*  77 */     NBTTagList invTag = nbt.getTagList("Items", 10);
/*  78 */     this.inventory = new ItemStack[getSizeInventory()];
/*     */     
/*  80 */     for (int i = 0; i < invTag.tagCount(); i++) {
/*  81 */       NBTTagCompound stackTag = invTag.getCompoundTagAt(i);
/*     */       
/*  83 */       byte slot = stackTag.getByte("Slot");
/*  84 */       if ((slot >= 0) && (slot < this.inventory.length)) {
/*  85 */         this.inventory[slot] = ItemStack.loadItemStackFromNBT(stackTag);
/*     */       }
/*     */     }
/*     */     
/*  89 */     this.runTime = nbt.getShort("RunTime");
/*  90 */     this.produceTime = nbt.getShort("ProduceTime");
/*  91 */     this.currentBeeRunTime = getRunTime(this.inventory[1]);
/*     */   }
/*     */   
/*     */   public void writeToNBT(NBTTagCompound nbt) {
/*  95 */     super.writeToNBT(nbt);
/*  96 */     nbt.setShort("RunTime", (short)this.runTime);
/*  97 */     nbt.setShort("ProduceTime", (short)this.produceTime);
/*  98 */     NBTTagList intTag = new NBTTagList();
/*     */     
/* 100 */     for (int i = 0; i < this.inventory.length; i++) {
/* 101 */       if (this.inventory[i] != null) {
/* 102 */         NBTTagCompound stackTag = new NBTTagCompound();
/* 103 */         stackTag.setByte("Slot", (byte)i);
/* 104 */         this.inventory[i].writeToNBT(stackTag);
/* 105 */         intTag.appendTag(stackTag);
/*     */       }
/*     */     }
/*     */     
/* 109 */     nbt.setTag("Items", intTag);
/*     */   }
/*     */   
/*     */   public int getInventoryStackLimit() {
/* 113 */     return 64;
/*     */   }
/*     */   
/*     */   public int getRunTime() {
/* 117 */     byte radius = 2;
/* 118 */     int speed = 3500;
/* 119 */     World world = this.worldObj;
/* 120 */     int varX = this.xCoord;
/* 121 */     int varY = this.yCoord;
/* 122 */     int varZ = this.zCoord;
/*     */     
/* 124 */     for (int offsetX = -radius; offsetX <= radius; offsetX++) {
/* 125 */       for (int offsetZ = -radius; offsetZ <= radius; offsetZ++) {
/* 126 */         if ((offsetX * offsetX + offsetZ * offsetZ <= radius * radius) && ((offsetX != -(radius - 1)) || (offsetZ != -(radius - 1))) && ((offsetX != radius - 1) || (offsetZ != radius - 1)) && ((offsetX != radius - 1) || (offsetZ != -(radius - 1))) && ((offsetX != -(radius - 1)) || (offsetZ != radius - 1)))
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 131 */           Block blockAtCoords = world.getBlock(varX + offsetX, varY, varZ + offsetZ);
/*     */           
/* 133 */           if (((blockAtCoords instanceof BlockFlower)) || ((blockAtCoords instanceof BlockCrops)) || ((blockAtCoords instanceof BlockPamCrop)) || ((blockAtCoords instanceof BlockPamNormalGarden)))
/*     */           {
/* 135 */             speed = (int)(speed * 0.95D);
/*     */           }
/*     */           
/* 138 */           if (world.getBlock(varX + offsetX, varY, varZ + offsetZ) == BlockRegistry.pamApiary) {
/* 139 */             speed = (int)(speed / 0.85D);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 145 */     return speed;
/*     */   }
/*     */   
/*     */   public void updateEntity() {
/* 149 */     boolean isRunning = this.runTime > 0;
/* 150 */     boolean needsUpdate = false;
/*     */     
/* 152 */     if (isRunning) {
/* 153 */       this.runTime -= 1;
/*     */     }
/*     */     
/* 156 */     ItemStack queenBee = this.inventory[18];
/*     */     
/* 158 */     if (!this.worldObj.isRemote) {
/* 159 */       if ((this.runTime == 0) && (canRun())) {
/* 160 */         this.currentBeeRunTime = (this.runTime = getRunTime(queenBee));
/*     */         
/* 162 */         if (this.runTime > 0) {
/* 163 */           needsUpdate = true;
/* 164 */           if (queenBee != null) {
/* 165 */             if (queenBee.getItem().getContainerItem() != null) {
/* 166 */               queenBee = new ItemStack(queenBee.getItem().setFull3D());
/*     */             }
/*     */             else {
/* 169 */               queenBee.stackSize -= 0;
/*     */             }
/*     */             
/* 172 */             if (queenBee.stackSize == 0) {
/* 173 */               queenBee = null;
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */       
/* 179 */       if (canRun()) {
/* 180 */         this.produceTime += 1;
/*     */         
/* 182 */         if (this.produceTime >= Math.floor(getRunTime())) {
/* 183 */           this.produceTime = 0;
/* 184 */           run();
/* 185 */           needsUpdate = true;
/*     */         }
/*     */       } else {
/* 188 */         this.produceTime = 0;
/*     */       }
/*     */       
/* 191 */       if (isRunning != this.runTime > 0) {
/* 192 */         needsUpdate = true;
/*     */       }
/*     */     }
/*     */     
/* 196 */     if (needsUpdate) {
/* 197 */      this.markDirty();
/* 198 */       this.worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean canRun()
/*     */   {
/* 204 */     if (this.inventory[18] != null) {
/* 205 */       if ((this.inventory[18].getItem() == ItemRegistry.queenbeeItem) && 
/* 206 */         (this.inventory[18].getItemDamage() != this.inventory[18].getMaxDamage()))
/*     */       {
/* 208 */         return true;
/*     */       }
/*     */     } else
/* 211 */       return false;
/* 212 */     return false;
/*     */   }
/*     */   
/*     */   public ItemStack getComb() {
/* 216 */     Random rnd = new Random();
/* 217 */     int rndnum = rnd.nextInt(100);
/* 218 */     if (this.inventory[18] != null) {
/* 219 */       if ((this.inventory[18].getItem() == ItemRegistry.queenbeeItem) && 
/* 220 */         (this.inventory[18].getItemDamage() == 17)) {
/* 221 */         return new ItemStack(ItemRegistry.grubItem);
/*     */       }
/* 223 */       if (rndnum < 50)
/* 224 */         return new ItemStack(ItemRegistry.waxcombItem);
/* 225 */       if ((rndnum >= 50) && (rndnum < 95)) {
/* 226 */         return new ItemStack(ItemRegistry.honeycombItem);
/*     */       }
/* 228 */       return new ItemStack(ItemRegistry.grubItem);
/*     */     }
/* 230 */     return null;
/*     */   }
/*     */   
/*     */   public void run()
/*     */   {
/* 235 */     this.inventory[18].attemptDamageItem(1, null);
/* 236 */     ItemStack itemProduced = getComb();
/* 237 */     for (int i = 0; i < 18; i++) {
/* 238 */       if (this.inventory[i] == null) {
/* 239 */         this.inventory[i] = itemProduced.copy();
/* 240 */         break;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   int getRunTime(ItemStack stack) {
/* 246 */     if (stack == null) {
/* 247 */       return 0;
/*     */     }
/*     */     
/* 250 */     if (stack.getItem() == ItemRegistry.queenbeeItem) {
/* 251 */       return 3200;
/*     */     }
/*     */     
/* 254 */     return 0;
/*     */   }
/*     */   
/*     */   public boolean isUseableByPlayer(EntityPlayer player) {
/* 258 */     if (this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this) {
/* 259 */       return false;
/*     */     }
/* 261 */     return player.getDistanceSq(this.xCoord + 0.5D, this.yCoord + 0.5D, this.zCoord + 0.5D) <= 64.0D;
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
/* 272 */     return null;
/*     */   }
/*     */   
/*     */   public boolean isInvNameLocalized() {
/* 276 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isStackValidForSlot(int slot, ItemStack stack)
/*     */   {
/* 281 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isItemValidForSlot(int slot, ItemStack stack)
/*     */   {
/* 286 */     return false;
/*     */   }
/*     */   
/*     */   public String getInventoryName()
/*     */   {
/* 291 */     return null;
/*     */   }
/*     */   
/*     */   public boolean isInventoryNameLocalized()
/*     */   {
/* 296 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public void func_70295_k_() {}
/*     */   
/*     */ 
/*     */   public Packet getDescriptionPacket()
/*     */   {
/* 305 */     NBTTagCompound tag = new NBTTagCompound();
/* 306 */     writeToNBT(tag);
/* 307 */     return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 1, tag);
/*     */   }
/*     */   
/*     */ 
/*     */   public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet)
/*     */   {
/* 313 */     readFromNBT(packet.func_148857_g());
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


/* Location:              C:\Users\Modding\Desktop\Pam's HarvestCraft 1.7.10k.deobf.jar!\com\pam\harvestcraft\TileEntityPamApiary.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */