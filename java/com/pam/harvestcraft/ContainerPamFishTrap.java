package com.pam.harvestcraft;
 
import java.util.List;
 
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
 
public class ContainerPamFishTrap extends Container {
 
        private TileEntityPamFishTrap fishtrap;
        private int lastProduceTime = 0;
        private int lastRunTime = 0;
        private int lastBeeRunTime = 0;
 
        public ContainerPamFishTrap(InventoryPlayer inv, TileEntityPamFishTrap tepa) {
                this.fishtrap = tepa;
 
                for (int x = 0; x < 6; x++) {
                        for (int y = 0; y < 3; y++) {
                                this.addSlotToContainer(new SlotPamResult(inv.player, tepa, y
                                                + x * 3, 62 + 18 * x, 17 + 18 * y));
                        }
                }
 
                this.addSlotToContainer(new SlotPamFishTrap(inv.player, tepa, 18, 26, 35));
 
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
                        if (this.lastProduceTime != this.fishtrap.produceTime) {
                                crafter.sendProgressBarUpdate(this, 1, this.fishtrap.produceTime);
                        }
 
                        if (this.lastRunTime != this.fishtrap.runTime) {
                                crafter.sendProgressBarUpdate(this, 2, this.fishtrap.runTime);
                        }
 
                        if (this.lastBeeRunTime != this.fishtrap.currentBeeRunTime) {
                                crafter.sendProgressBarUpdate(this, 3,
                                                this.fishtrap.currentBeeRunTime);
                        }
                }
 
                this.lastProduceTime = this.fishtrap.produceTime;
                this.lastRunTime = this.fishtrap.runTime;
                this.lastBeeRunTime = this.fishtrap.currentBeeRunTime;
        }
 
        public void updateProgressBar(int event, int val) {
                if (event == 1) {
                        this.fishtrap.produceTime = val;
                } else if (event == 2) {
                        this.fishtrap.runTime = val;
                } else if (event == 3) {
                        this.fishtrap.currentBeeRunTime = val;
                }
        }
 
        public boolean canInteractWith(EntityPlayer player) {
                return this.fishtrap.isUseableByPlayer(player);
        }
 
        public ItemStack transferStackInSlot(EntityPlayer player,
                int slotId)
                {
					return null;
        	
                }
}