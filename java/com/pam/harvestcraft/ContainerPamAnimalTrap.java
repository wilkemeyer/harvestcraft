package com.pam.harvestcraft;
 
import java.util.List;
 
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
 
public class ContainerPamAnimalTrap extends Container {
 
        private TileEntityPamAnimalTrap animaltrap;
        private int lastProduceTime = 0;
        private int lastRunTime = 0;
        private int lastBeeRunTime = 0;
 
        public ContainerPamAnimalTrap(InventoryPlayer inv, TileEntityPamAnimalTrap tepa) {
                this.animaltrap = tepa;
 
                for (int x = 0; x < 6; x++) {
                        for (int y = 0; y < 3; y++) {
                                this.addSlotToContainer(new SlotPamResult(inv.player, tepa, y
                                                + x * 3, 62 + 18 * x, 17 + 18 * y));
                        }
                }
 
                this.addSlotToContainer(new SlotPamAnimalTrap(inv.player, tepa, 18, 26, 35));
 
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
                        if (this.lastProduceTime != this.animaltrap.produceTime) {
                                crafter.sendProgressBarUpdate(this, 1, this.animaltrap.produceTime);
                        }
 
                        if (this.lastRunTime != this.animaltrap.runTime) {
                                crafter.sendProgressBarUpdate(this, 2, this.animaltrap.runTime);
                        }
 
                        if (this.lastBeeRunTime != this.animaltrap.currentBeeRunTime) {
                                crafter.sendProgressBarUpdate(this, 3,
                                                this.animaltrap.currentBeeRunTime);
                        }
                }
 
                this.lastProduceTime = this.animaltrap.produceTime;
                this.lastRunTime = this.animaltrap.runTime;
                this.lastBeeRunTime = this.animaltrap.currentBeeRunTime;
        }
 
        public void updateProgressBar(int event, int val) {
                if (event == 1) {
                        this.animaltrap.produceTime = val;
                } else if (event == 2) {
                        this.animaltrap.runTime = val;
                } else if (event == 3) {
                        this.animaltrap.currentBeeRunTime = val;
                }
        }
 
        public boolean canInteractWith(EntityPlayer player) {
                return this.animaltrap.isUseableByPlayer(player);
        }
 
        public ItemStack transferStackInSlot(EntityPlayer player,
                int slotId)
                {
					return null;
        	
                }
}