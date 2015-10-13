package com.pam.harvestcraft;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityChurn extends TileEntity implements ISidedInventory
{
    private static final int[] slotsTop = new int[] {0};
    private static final int[] slotsBottom = new int[] {2, 1};
    private static final int[] slotsSides = new int[] {1};
    /** The ItemStacks that hold the items currently being used in the churn */
    private ItemStack[] churnItemStacks = new ItemStack[3];
    /** The number of ticks that the churn will keep burning */
    public int churnBurnTime;
    /** The number of ticks that a fresh copy of the currently-burning item would keep the churn burning for */
    public int currentItemBurnTime;
    /** The number of ticks that the current item has been cooking for */
    public int churnCookTime;
    private String field_145958_o;
    private static final String __OBFID = "CL_00000357";

    /**
     * Returns the number of slots in the inventory.
     */
    public int getSizeInventory()
    {
        return this.churnItemStacks.length;
    }

    /**
     * Returns the stack in slot i
     */
    public ItemStack getStackInSlot(int p_70301_1_)
    {
        return this.churnItemStacks[p_70301_1_];
    }

    /**
     * Removes from an inventory slot (first arg) up to a specified number (second arg) of items and returns them in a
     * new stack.
     */
    public ItemStack decrStackSize(int p_70298_1_, int p_70298_2_)
    {
        if (this.churnItemStacks[p_70298_1_] != null)
        {
            ItemStack itemstack;

            if (this.churnItemStacks[p_70298_1_].stackSize <= p_70298_2_)
            {
                itemstack = this.churnItemStacks[p_70298_1_];
                this.churnItemStacks[p_70298_1_] = null;
                return itemstack;
            }
            else
            {
                itemstack = this.churnItemStacks[p_70298_1_].splitStack(p_70298_2_);

                if (this.churnItemStacks[p_70298_1_].stackSize == 0)
                {
                    this.churnItemStacks[p_70298_1_] = null;
                }

                return itemstack;
            }
        }
        else
        {
            return null;
        }
    }

    /**
     * When some containers are closed they call this on each slot, then drop whatever it returns as an EntityItem -
     * like when you close a workbench GUI.
     */
    public ItemStack getStackInSlotOnClosing(int p_70304_1_)
    {
        if (this.churnItemStacks[p_70304_1_] != null)
        {
            ItemStack itemstack = this.churnItemStacks[p_70304_1_];
            this.churnItemStacks[p_70304_1_] = null;
            return itemstack;
        }
        else
        {
            return null;
        }
    }

    /**
     * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
     */
    public void setInventorySlotContents(int p_70299_1_, ItemStack p_70299_2_)
    {
        this.churnItemStacks[p_70299_1_] = p_70299_2_;

        if (p_70299_2_ != null && p_70299_2_.stackSize > this.getInventoryStackLimit())
        {
            p_70299_2_.stackSize = this.getInventoryStackLimit();
        }
    }

    /**
     * Returns the name of the inventory
     */
    public String getInventoryName()
    {
        return this.hasCustomInventoryName() ? this.field_145958_o : "Churn";
    }

    /**
     * Returns if the inventory is named
     */
    public boolean hasCustomInventoryName()
    {
        return this.field_145958_o != null && this.field_145958_o.length() > 0;
    }

    public void func_145951_a(String p_145951_1_)
    {
        this.field_145958_o = p_145951_1_;
    }

    public void readFromNBT(NBTTagCompound p_145839_1_)
    {
        super.readFromNBT(p_145839_1_);
        NBTTagList nbttaglist = p_145839_1_.getTagList("Items", 10);
        this.churnItemStacks = new ItemStack[this.getSizeInventory()];

        for (int i = 0; i < nbttaglist.tagCount(); ++i)
        {
            NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
            byte b0 = nbttagcompound1.getByte("Slot");

            if (b0 >= 0 && b0 < this.churnItemStacks.length)
            {
                this.churnItemStacks[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
            }
        }

        this.churnBurnTime = p_145839_1_.getShort("BurnTime");
        this.churnCookTime = p_145839_1_.getShort("CookTime");
        this.currentItemBurnTime = getItemBurnTime(this.churnItemStacks[1]);

        if (p_145839_1_.hasKey("CustomName", 8))
        {
            this.field_145958_o = p_145839_1_.getString("CustomName");
        }
    }

    public void writeToNBT(NBTTagCompound p_145841_1_)
    {
        super.writeToNBT(p_145841_1_);
        p_145841_1_.setShort("BurnTime", (short)this.churnBurnTime);
        p_145841_1_.setShort("CookTime", (short)this.churnCookTime);
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < this.churnItemStacks.length; ++i)
        {
            if (this.churnItemStacks[i] != null)
            {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte)i);
                this.churnItemStacks[i].writeToNBT(nbttagcompound1);
                nbttaglist.appendTag(nbttagcompound1);
            }
        }

        p_145841_1_.setTag("Items", nbttaglist);

        if (this.hasCustomInventoryName())
        {
            p_145841_1_.setString("CustomName", this.field_145958_o);
        }
    }

    /**
     * Returns the maximum stack size for a inventory slot.
     */
    public int getInventoryStackLimit()
    {
        return 64;
    }

    /**
     * Returns an integer between 0 and the passed value representing how close the current item is to being completely
     * cooked
     */
    @SideOnly(Side.CLIENT)
    public int getCookProgressScaled(int p_145953_1_)
    {
        return this.churnCookTime * p_145953_1_ / 200;
    }

    /**
     * Returns an integer between 0 and the passed value representing how much burn time is left on the current fuel
     * item, where 0 means that the item is exhausted and the passed value means that the item is fresh
     */
    @SideOnly(Side.CLIENT)
    public int getBurnTimeRemainingScaled(int p_145955_1_)
    {
        if (this.currentItemBurnTime == 0)
        {
            this.currentItemBurnTime = 200;
        }

        return this.churnBurnTime * p_145955_1_ / this.currentItemBurnTime;
    }

    /**
     * Churn isBurning
     */
    public boolean isBurning()
    {
        return this.churnBurnTime > 0;
    }

    public void updateEntity()
    {
        boolean flag = this.churnBurnTime > 0;
        boolean flag1 = false;

        if (this.churnBurnTime > 0)
        {
            --this.churnBurnTime;
        }

        if (!this.worldObj.isRemote)
        {
            if (this.churnBurnTime != 0 || this.churnItemStacks[1] != null && this.churnItemStacks[0] != null)
            {
                if (this.churnBurnTime == 0 && this.canSmelt())
                {
                    this.currentItemBurnTime = this.churnBurnTime = getItemBurnTime(this.churnItemStacks[1]);

                    if (this.churnBurnTime > 0)
                    {
                        flag1 = true;

                        if (this.churnItemStacks[1] != null)
                        {
                            --this.churnItemStacks[1].stackSize;

                            if (this.churnItemStacks[1].stackSize == 0)
                            {
                                this.churnItemStacks[1] = churnItemStacks[1].getItem().getContainerItem(churnItemStacks[1]);
                            }
                        }
                    }
                }

                if (this.isBurning() && this.canSmelt())
                {
                    ++this.churnCookTime;

                    if (this.churnCookTime == 200)
                    {
                        this.churnCookTime = 0;
                        this.smeltItem();
                        flag1 = true;
                    }
                }
                else
                {
                    this.churnCookTime = 0;
                }
            }

            if (flag != this.churnBurnTime > 0)
            {
                flag1 = true;
                BlockPamChurn.updateChurnBlockState(this.churnBurnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
            }
        }

        if (flag1)
        {
            this.markDirty();
        }
    }

    /**
     * Returns true if the churn can smelt an item, i.e. has a source item, destination stack isn't full, etc.
     */
    private boolean canSmelt()
    {
        if (this.churnItemStacks[0] == null)
        {
            return false;
        }
        else
        {
            ItemStack itemstack = ChurnRecipes.smelting().getSmeltingResult(this.churnItemStacks[0]);
            if (itemstack == null) return false;
            if (this.churnItemStacks[2] == null) return true;
            if (!this.churnItemStacks[2].isItemEqual(itemstack)) return false;
            int result = churnItemStacks[2].stackSize + itemstack.stackSize;
            return result <= getInventoryStackLimit() && result <= this.churnItemStacks[2].getMaxStackSize(); //Forge BugFix: Make it respect stack sizes properly.
        }
    }

    /**
     * Turn one item from the churn source stack into the appropriate smelted item in the churn result stack
     */
    public void smeltItem()
    {
        if (this.canSmelt())
        {
            ItemStack itemstack = ChurnRecipes.smelting().getSmeltingResult(this.churnItemStacks[0]);

            if (this.churnItemStacks[2] == null)
            {
                this.churnItemStacks[2] = itemstack.copy();
            }
            else if (this.churnItemStacks[2].getItem() == itemstack.getItem())
            {
                this.churnItemStacks[2].stackSize += itemstack.stackSize; // Forge BugFix: Results may have multiple items
            }

            --this.churnItemStacks[0].stackSize;

            if (this.churnItemStacks[0].stackSize <= 0)
            {
                this.churnItemStacks[0] = null;
            }
        }
    }

    /**
     * Returns the number of ticks that the supplied fuel item will keep the churn burning, or 0 if the item isn't
     * fuel
     */
    public static int getItemBurnTime(ItemStack p_145952_0_)
    {
        if (p_145952_0_ == null)
        {
            return 0;
        }
        else
        {
            Item item = p_145952_0_.getItem();

            
            if (item == ItemRegistry.saltItem) return 1600;

            return GameRegistry.getFuelValue(p_145952_0_);
        }
    }

    public static boolean isItemFuel(ItemStack p_145954_0_)
    {
        /**
         * Returns the number of ticks that the supplied fuel item will keep the churn burning, or 0 if the item isn't
         * fuel
         */
        return getItemBurnTime(p_145954_0_) > 0;
    }

    /**
     * Do not make give this method the name canInteractWith because it clashes with Container
     */
    public boolean isUseableByPlayer(EntityPlayer p_70300_1_)
    {
        return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : p_70300_1_.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
    }

    public void openInventory() {}

    public void closeInventory() {}

    /**
     * Returns true if automation is allowed to insert the given stack (ignoring stack size) into the given slot.
     */
    public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_)
    {
        return p_94041_1_ == 2 ? false : (p_94041_1_ == 1 ? isItemFuel(p_94041_2_) : true);
    }

    /**
     * Returns an array containing the indices of the slots that can be accessed by automation on the given side of this
     * block.
     */
    public int[] getAccessibleSlotsFromSide(int p_94128_1_)
    {
        return p_94128_1_ == 0 ? slotsBottom : (p_94128_1_ == 1 ? slotsTop : slotsSides);
    }

    /**
     * Returns true if automation can insert the given item in the given slot from the given side. Args: Slot, item,
     * side
     */
    public boolean canInsertItem(int p_102007_1_, ItemStack p_102007_2_, int p_102007_3_)
    {
        return this.isItemValidForSlot(p_102007_1_, p_102007_2_);
    }

    /**
     * Returns true if automation can extract the given item in the given slot from the given side. Args: Slot, item,
     * side
     */
    public boolean canExtractItem(int p_102008_1_, ItemStack p_102008_2_, int p_102008_3_)
    {
        return p_102008_3_ != 0 || p_102008_1_ != 1 || p_102008_2_.getItem() == Items.bucket;
    }
}