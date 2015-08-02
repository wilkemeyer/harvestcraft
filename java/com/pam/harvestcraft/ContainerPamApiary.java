package com.pam.harvestcraft;
 
import java.util.List;
 
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
 
public class ContainerPamApiary extends Container {
 
        private TileEntityPamApiary apiary;
        private int lastProduceTime = 0;
        private int lastRunTime = 0;
        private int lastBeeRunTime = 0;
 
        public ContainerPamApiary(InventoryPlayer inv, TileEntityPamApiary tepa) {
                this.apiary = tepa;
 
                for (int x = 0; x < 6; x++) {
                        for (int y = 0; y < 3; y++) {
                                this.addSlotToContainer(new SlotPamResult(inv.player, tepa, y
                                                + x * 3, 62 + 18 * x, 17 + 18 * y));
                        }
                }
 
                this.addSlotToContainer(new SlotPamApiary(inv.player, tepa, 18, 26, 35));
 
                for (int i = 0; i < 3; ++i) {
                        for (int j = 0; j < 9; ++j) {
                                this.addSlotToContainer(new Slot(inv, j + i * 9 + 9,
                                                8 + j * 18, 84 + i * 18));
                        }
                }
 
                for (int i = 0; i < 9; ++i) {
                        this.addSlotToContainer(new Slot(inv, i, 8 + i * 18, 142));
                }
 
        }
 
        public void detectAndSendChanges() {
                super.detectAndSendChanges();
 
                for (int i = 0; i < crafters.size(); i++) {
                        ICrafting crafter = (ICrafting) crafters.get(i);
                        if (this.lastProduceTime != this.apiary.produceTime) {
                                crafter.sendProgressBarUpdate(this, 1, this.apiary.produceTime);
                        }
 
                        if (this.lastRunTime != this.apiary.runTime) {
                                crafter.sendProgressBarUpdate(this, 2, this.apiary.runTime);
                        }
 
                        if (this.lastBeeRunTime != this.apiary.currentBeeRunTime) {
                                crafter.sendProgressBarUpdate(this, 3,
                                                this.apiary.currentBeeRunTime);
                        }
                }
 
                this.lastProduceTime = this.apiary.produceTime;
                this.lastRunTime = this.apiary.runTime;
                this.lastBeeRunTime = this.apiary.currentBeeRunTime;
        }
 
        public void updateProgressBar(int event, int val) {
                if (event == 1) {
                        this.apiary.produceTime = val;
                } else if (event == 2) {
                        this.apiary.runTime = val;
                } else if (event == 3) {
                        this.apiary.currentBeeRunTime = val;
                }
        }
 
        public boolean canInteractWith(EntityPlayer player) {
                return this.apiary.isUseableByPlayer(player);
        }
        
        public ItemStack transferStackInSlot(EntityPlayer player,
                int slotId)
                {
					return null;
        	
                }
 
        /*
         * public ItemStack transferStackInSlot(EntityPlayer player,
                        int slotId) 
        {
                ItemStack copyStack = null;
                Slot slot = (Slot) this.inventorySlots.get(slotId);
 
                if (slot != null && slot.getHasStack()) 
                {
                        ItemStack origStack = slot.getStack();
                        copyStack = origStack.copy();
 
                        if (slotId <= 17) 
                        {
                                if (!this.mergeItemStack(origStack, 19, 55, true)) 
                                {
                                        return null;
                                }
                                slot.onSlotChange(origStack, copyStack);
                        } else if (slotId != 18) 
                        {
                                if (origStack.getItem() == ItemRegistry.queenbeeItem) 
                                {
                                        if (!this.mergeItemStack(origStack, 17, 18, false)) 
                                        {
                                                return null;
                                        }
                                } else if (slotId >= 19 && slotId < 46) 
                                {
                                        if (!this.mergeItemStack(origStack, 33, 42, false)) 
                                        {
                                                return null;
                                        }
                                } else if (slotId >= 47 && slotId < 55
                                                && !this.mergeItemStack(origStack, 19, 55, false)) 
                                {
                                        return null;
                                }
                        } else if (!this.mergeItemStack(origStack, 19, 55, false)) 
                        {
                                return null;
                        }
 
                        if (origStack.stackSize <= 0) 
                        {
                                slot.putStack(null);
                        } else 
                        {
                                slot.onSlotChanged();
                        }
 
                        if (origStack.stackSize == copyStack.stackSize) 
                        {
                                return null;
                        }
 
                        slot.onPickupFromSlot(player, origStack);
                }
 
                return copyStack;
        }
        */
}
        