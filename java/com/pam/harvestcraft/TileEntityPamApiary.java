package com.pam.harvestcraft;
 
import java.util.Random;
 

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.BlockFlower;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
 
public class TileEntityPamApiary extends TileEntity implements IInventory {
 
        private ItemStack[] inventory = new ItemStack[19];
        public int runTime = 0;
        public int currentBeeRunTime = 0;
        public int produceTime = 0;
 
        public int getSizeInventory() {
                return this.inventory.length;
        }
 
        public ItemStack getStackInSlot(int slot) {
                return this.inventory[slot];
        }
 
        public ItemStack decrStackSize(int slot, int amount) {
                // There's nothing in the slot, so nothing can be taken out.
                if (inventory[slot] == null) {
                        setInventorySlotContents(slot, null);
                        return null;
                }
                // There's not enough to remove, so just take out as much as we have.
                if (inventory[slot].stackSize <= amount) {
                        ItemStack stack = inventory[slot];
                        setInventorySlotContents(slot, null);
                        return stack;
                }
 
                // Finally, the expected case. Remove <amount> items from the stack and
                // then return those items.
                ItemStack stack = inventory[slot].splitStack(amount);
 
                // This shouldn't happen, but just in case, this will stop ghost items
                // from appearing.
                if (inventory[slot].stackSize <= 0) {
                        setInventorySlotContents(slot, null);
                }
 
                markDirty();
 
                return stack;
        }
 
        public void setInventorySlotContents(int slot, ItemStack stack) {
                this.inventory[slot] = stack;
                if (stack != null && stack.stackSize > this.getInventoryStackLimit()) {
                        stack.stackSize = this.getInventoryStackLimit();
                }
 
        }
 
        public String getInvName() {
                return "Apiary";
        }
 
        public void readFromNBT(NBTTagCompound nbt) {
                super.readFromNBT(nbt);
                NBTTagList invTag = nbt.getTagList("Items", 10);
                this.inventory = new ItemStack[this.getSizeInventory()];
 
                for (int i = 0; i < invTag.tagCount(); ++i) {
                        NBTTagCompound stackTag = (NBTTagCompound) invTag
                                        .getCompoundTagAt(i);
                        byte slot = stackTag.getByte("Slot");
                        if (slot >= 0 && slot < this.inventory.length) {
                                this.inventory[slot] = ItemStack.loadItemStackFromNBT(stackTag);
                        }
                }
 
                this.runTime = nbt.getShort("RunTime");
                this.produceTime = nbt.getShort("ProduceTime");
                this.currentBeeRunTime = this.getRunTime(this.inventory[1]);
        }
 
        public void writeToNBT(NBTTagCompound nbt) {
                super.writeToNBT(nbt);
                nbt.setShort("RunTime", (short) this.runTime);
                nbt.setShort("ProduceTime", (short) this.produceTime);
                NBTTagList intTag = new NBTTagList();
 
                for (int i = 0; i < this.inventory.length; ++i) {
                        if (this.inventory[i] != null) {
                                NBTTagCompound stackTag = new NBTTagCompound();
                                stackTag.setByte("Slot", (byte) i);
                                this.inventory[i].writeToNBT(stackTag);
                                intTag.appendTag(stackTag);
                        }
                }
 
                nbt.setTag("Items", intTag);
        }
 
        public int getInventoryStackLimit() {
                return 64;
        }
 
        public int getRunTime() {
                byte radius = 2;
                int speed = 3500;
                World world = super.worldObj;
                int varX = super.xCoord;
                int varY = super.yCoord;
                int varZ = super.zCoord;
 
                for (int offsetX = -radius; offsetX <= radius; ++offsetX) {
                        for (int offsetZ = -radius; offsetZ <= radius; ++offsetZ) {
                                if (offsetX * offsetX + offsetZ * offsetZ <= radius * radius
                                                && (offsetX != -(radius - 1) || offsetZ != -(radius - 1))
                                                && (offsetX != radius - 1 || offsetZ != radius - 1)
                                                && (offsetX != radius - 1 || offsetZ != -(radius - 1))
                                                && (offsetX != -(radius - 1) || offsetZ != radius - 1)) {
                                        Block blockAtCoords = world.getBlock(varX + offsetX, varY,
                                                        varZ + offsetZ);
                                        if (blockAtCoords instanceof BlockFlower || blockAtCoords instanceof BlockCrops
                                        		|| blockAtCoords instanceof BlockPamCrop || blockAtCoords instanceof BlockPamNormalGarden) {
                                                speed = (int) ((double) speed * 0.95D);
                                        }
 
                                        if (world.getBlock(varX + offsetX, varY, varZ + offsetZ) == BlockRegistry.pamApiary) {
                                                speed = (int) ((double) speed / 0.85D);
                                        }
                                }
                        }
                }
 
                return speed;
        }
 
        public void updateEntity() {
                boolean isRunning = this.runTime > 0;
                boolean needsUpdate = false;
 
                if (isRunning) {
                        --this.runTime;
                }
 
                ItemStack queenBee = this.inventory[18];
 
                if (!super.worldObj.isRemote) {
                        if (this.runTime == 0 && this.canRun()) {
                                this.currentBeeRunTime = this.runTime = this
                                                .getRunTime(queenBee);
                                if (this.runTime > 0) {
                                        needsUpdate = true;
                                        if (queenBee != null) {
                                                if (queenBee.getItem().getContainerItem() != null) {
                                                        queenBee = new ItemStack(queenBee.getItem()
                                                                        .setFull3D());
                                                } else {
                                                        queenBee.stackSize -= 0;
                                                }
 
                                                if (queenBee.stackSize == 0) {
                                                        queenBee = null;
                                                }
                                        }
                                }
                        }
 
                        if (this.canRun()) {
                                this.produceTime++;
 
                                if (this.produceTime >= Math.floor(this.getRunTime())) {
                                        this.produceTime = 0;
                                        this.run();
                                        needsUpdate = true;
                                }
                        } else {
                                this.produceTime = 0;
                        }
 
                        if (isRunning != this.runTime > 0) {
                                needsUpdate = true;
                        }
                }
 
                if (needsUpdate) {
                        markDirty();
                        worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
                }
 
        }
 
        private boolean canRun() {
                if (this.inventory[18] != null) {
                        if (this.inventory[18].getItem() == ItemRegistry.queenbeeItem) {
                                if (this.inventory[18].getItemDamage() != this.inventory[18]
                                                .getMaxDamage())
                                        return true;
                        }
                } else
                        return false;
                return false;
        }
 
        public ItemStack getComb() {
                Random rnd = new Random();
                int rndnum = rnd.nextInt(100);
                if (this.inventory[18] != null) {
                        if (this.inventory[18].getItem() == ItemRegistry.queenbeeItem) {
                                if (this.inventory[18].getItemDamage() == 17)
                                        return new ItemStack(ItemRegistry.grubItem);
                        }
                        if (rndnum < 50) {
                                return new ItemStack(ItemRegistry.waxcombItem);
                        } else if (rndnum >= 50 && rndnum < 95) {
                                return new ItemStack(ItemRegistry.honeycombItem);
                        }
                        return new ItemStack(ItemRegistry.grubItem);
                }
                return null;
 
        }
 
        public void run() {
                this.inventory[18].attemptDamageItem(1, null);
                ItemStack itemProduced = this.getComb();
                for (int i = 0; i < 18; ++i) {
                        if (this.inventory[i] == null) {
                                this.inventory[i] = itemProduced.copy();
                                break;
                        }
                }
        }
 
        int getRunTime(ItemStack stack) {
                if (stack == null) {
                        return 0;
                }
 
                if (stack.getItem() == ItemRegistry.queenbeeItem) {
                        return 3200;
                }
 
                return 0;
        }
 
        public boolean isUseableByPlayer(EntityPlayer player) {
                if (worldObj.getTileEntity(xCoord, yCoord, zCoord) != this) {
                        return false;
                }
                return player
                                .getDistanceSq(xCoord + 0.5D, yCoord + 0.5D, zCoord + 0.5D) <= 64.0D;
        }
 
        public void openChest() {
        }
 
        public void closeChest() {
        }
 
        public ItemStack getStackInSlotOnClosing(int slot) {
                return null;
        }
 
        public boolean isInvNameLocalized() {
                return false;
        }
 
        public boolean isStackValidForSlot(int slot, ItemStack stack) {
                // No automation.
                return false;
        }
 
        @Override
        public boolean isItemValidForSlot(int slot, ItemStack stack) {
                return false;
        }
 
        @Override
        public String getInventoryName() {
                return null;
        }
 
        @Override
        public boolean hasCustomInventoryName() {
                return false;
        }
 
        @Override
        public void openInventory() {
        }
 
        @Override
        public Packet getDescriptionPacket() {
                NBTTagCompound tag = new NBTTagCompound();
                this.writeToNBT(tag);
                return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, tag);
        }
 
        @Override
        public void onDataPacket(NetworkManager net,
                        S35PacketUpdateTileEntity packet) {
                readFromNBT(packet.func_148857_g());
        }
 
        @Override
        public void closeInventory() {
        }
}