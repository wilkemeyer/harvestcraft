package com.pam.harvestcraft;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotPamAnimalTrap extends Slot
{
	private EntityPlayer thePlayer;

  public SlotPamAnimalTrap(EntityPlayer par1EntityPlayer, IInventory par2IInventory, int par3, int par4, int par5)
  {
    super(par2IInventory, par3, par4, par5);
    this.setThePlayer(par1EntityPlayer);
  }

  public int getSlotStackLimit() {
      return 64;
   }

   public boolean isItemValid(ItemStack par1ItemStack) {
      return par1ItemStack.getItem() == ItemRegistry.grainbaitItem ||
    		  par1ItemStack.getItem() == ItemRegistry.veggiebaitItem ||
    				  par1ItemStack.getItem() == ItemRegistry.fruitbaitItem;
   }

   public void onPickupFromSlot(EntityPlayer par1EntityPlayer, ItemStack par2ItemStack) {
      super.onPickupFromSlot(par1EntityPlayer, par2ItemStack);
   }

public EntityPlayer getThePlayer() {
	return thePlayer;
}

public void setThePlayer(EntityPlayer thePlayer) {
	this.thePlayer = thePlayer;
}
}
