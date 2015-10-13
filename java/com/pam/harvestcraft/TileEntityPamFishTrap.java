package com.pam.harvestcraft;
 
import java.util.Random;
 




import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.BlockLiquid;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
 
public class TileEntityPamFishTrap extends TileEntity implements IInventory {
 
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
                                        if (blockAtCoords instanceof BlockLiquid) {
                                                speed = (int) ((double) speed * 0.95D);
                                        }
 
                                        if (world.getBlock(varX + offsetX, varY, varZ + offsetZ) == BlockRegistry.pamfishTrap) {
                                                speed = (int) ((double) speed / 0.85D);
                                        }
                                }
                        }
                }
 
                return speed;
        }
 
        public int countFlowers() {
                byte radius = 2;
                int count = 0;
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
                                        if (blockAtCoords instanceof BlockLiquid) {
                                                count++;
                                        }
                                }
                        }
                }
 
                return count;
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
                        if (this.inventory[18].getItem() == ItemRegistry.fishtrapbaitItem) {
                                
                                        if (countFlowers() >= 5) {
                                                return true;
                                        }
                        }
                } else
                        return false;
                return false;
        }
 
        public ItemStack getComb() {
                Random rnd = new Random();
                
                if (this.inventory[18] != null) 
                {
                	if (ItemRegistry.enableharvestcraftfish)
                	{
                		int rndnum = rnd.nextInt(32);
                        switch (rndnum)
                        {
                        case 0: return new ItemStack(Items.fish, 1, 0);
                        case 1: return new ItemStack(Items.fish, 1, 1);
                        case 2: return new ItemStack(Items.fish, 1, 2);
                        case 3: return new ItemStack(Items.fish, 1, 3);
                        case 4: return new ItemStack(ItemRegistry.anchovyrawItem, 1, 0);
                        case 5: return new ItemStack(ItemRegistry.bassrawItem, 1, 0);
                        case 6: return new ItemStack(ItemRegistry.carprawItem, 1, 0);
                        case 7: return new ItemStack(ItemRegistry.catfishrawItem, 1, 0);
                        case 8: return new ItemStack(ItemRegistry.charrrawItem, 1, 0);
                        case 9: return new ItemStack(ItemRegistry.clamrawItem, 1, 0);
                        case 10: return new ItemStack(ItemRegistry.crabrawItem, 1, 0);
                        case 11: return new ItemStack(ItemRegistry.crayfishrawItem, 1, 0);
                        case 12: return new ItemStack(ItemRegistry.eelrawItem, 1, 0);
                        case 13: return new ItemStack(ItemRegistry.frograwItem, 1, 0);
                        case 14: return new ItemStack(ItemRegistry.grouperrawItem, 1, 0);
                        case 15: return new ItemStack(ItemRegistry.herringrawItem, 1, 0);
                        case 16: return new ItemStack(ItemRegistry.jellyfishrawItem, 1, 0);
                        case 17: return new ItemStack(ItemRegistry.mudfishrawItem, 1, 0);
                        case 18: return new ItemStack(ItemRegistry.octopusrawItem, 1, 0);
                        case 19: return new ItemStack(ItemRegistry.perchrawItem, 1, 0);
                        case 20: return new ItemStack(ItemRegistry.scalloprawItem, 1, 0);
                        case 21: return new ItemStack(ItemRegistry.shrimprawItem, 1, 0);
                        case 22: return new ItemStack(ItemRegistry.snailrawItem, 1, 0);
                        case 23: return new ItemStack(ItemRegistry.snapperrawItem, 1, 0);
                        case 24: return new ItemStack(ItemRegistry.tilapiarawItem, 1, 0);
                        case 25: return new ItemStack(ItemRegistry.troutrawItem, 1, 0);
                        case 26: return new ItemStack(ItemRegistry.tunarawItem, 1, 0);
                        case 27: return new ItemStack(ItemRegistry.turtlerawItem, 1, 0);
                        case 28: return new ItemStack(ItemRegistry.walleyerawItem, 1, 0);
                        case 29: return new ItemStack(Items.fish, 1, 0);
                        case 30: return new ItemStack(Items.fish, 1, 0);
                        case 31: return new ItemStack(ItemRegistry.greenheartfishItem, 1, 0);
                        }
                	} 
                		
                	int rndnum = rnd.nextInt(11);
                    switch (rndnum)
                    {
                    case 0: return new ItemStack(Items.fish, 1, 0);
                    case 1: return new ItemStack(Items.fish, 1, 0);
                    case 2: return new ItemStack(Items.fish, 1, 0);
                    case 3: return new ItemStack(Items.fish, 1, 0);
                    case 4: return new ItemStack(Items.fish, 1, 0);
                    case 5: return new ItemStack(Items.fish, 1, 0);
                    case 6: return new ItemStack(Items.fish, 1, 0);
                    case 7: return new ItemStack(Items.fish, 1, 1);
                    case 8: return new ItemStack(Items.fish, 1, 1);
                    case 9: return new ItemStack(Items.fish, 1, 2);
                    case 10: return new ItemStack(Items.fish, 1, 3);
                    }
                }
                return null;
 
        }
 
        public void run() {
            
            ItemStack itemProduced = this.getComb();
            for (int i = 0; i < 18; ++i) {
                    if (this.inventory[i] == null) {
                    		this.decrStackSize(18, 1);
                            this.inventory[i] = itemProduced.copy();
                            break;
                    }
            }
    }
 
        int getRunTime(ItemStack stack) {
                if (stack == null) {
                        return 0;
                }
 
                if (stack.getItem() == ItemRegistry.fishtrapbaitItem) {
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