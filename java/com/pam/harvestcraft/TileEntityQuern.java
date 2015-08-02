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

public class TileEntityQuern extends TileEntity implements ISidedInventory
{
    private static final int[] slotsTop = new int[] {0};
    private static final int[] slotsBottom = new int[] {2, 1};
    private static final int[] slotsSides = new int[] {1};
    /** The ItemStacks that hold the items currently being used in the quern */
    private ItemStack[] quernItemStacks = new ItemStack[3];
    /** The number of ticks that the quern will keep burning */
    public int quernBurnTime;
    /** The number of ticks that a fresh copy of the currently-burning item would keep the quern burning for */
    public int currentItemBurnTime;
    /** The number of ticks that the current item has been cooking for */
    public int quernCookTime;
    private String field_145958_o;
    private static final String __OBFID = "CL_00000357";

    /**
     * Returns the number of slots in the inventory.
     */
    public int getSizeInventory()
    {
        return this.quernItemStacks.length;
    }

    /**
     * Returns the stack in slot i
     */
    public ItemStack getStackInSlot(int p_70301_1_)
    {
        return this.quernItemStacks[p_70301_1_];
    }

    /**
     * Removes from an inventory slot (first arg) up to a specified number (second arg) of items and returns them in a
     * new stack.
     */
    public ItemStack decrStackSize(int p_70298_1_, int p_70298_2_)
    {
        if (this.quernItemStacks[p_70298_1_] != null)
        {
            ItemStack itemstack;

            if (this.quernItemStacks[p_70298_1_].stackSize <= p_70298_2_)
            {
                itemstack = this.quernItemStacks[p_70298_1_];
                this.quernItemStacks[p_70298_1_] = null;
                return itemstack;
            }
            else
            {
                itemstack = this.quernItemStacks[p_70298_1_].splitStack(p_70298_2_);

                if (this.quernItemStacks[p_70298_1_].stackSize == 0)
                {
                    this.quernItemStacks[p_70298_1_] = null;
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
        if (this.quernItemStacks[p_70304_1_] != null)
        {
            ItemStack itemstack = this.quernItemStacks[p_70304_1_];
            this.quernItemStacks[p_70304_1_] = null;
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
        this.quernItemStacks[p_70299_1_] = p_70299_2_;

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
        return this.hasCustomInventoryName() ? this.field_145958_o : "Quern";
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
        this.quernItemStacks = new ItemStack[this.getSizeInventory()];

        for (int i = 0; i < nbttaglist.tagCount(); ++i)
        {
            NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
            byte b0 = nbttagcompound1.getByte("Slot");

            if (b0 >= 0 && b0 < this.quernItemStacks.length)
            {
                this.quernItemStacks[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
            }
        }

        this.quernBurnTime = p_145839_1_.getShort("BurnTime");
        this.quernCookTime = p_145839_1_.getShort("CookTime");
        this.currentItemBurnTime = getItemBurnTime(this.quernItemStacks[1]);

        if (p_145839_1_.hasKey("CustomName", 8))
        {
            this.field_145958_o = p_145839_1_.getString("CustomName");
        }
    }

    public void writeToNBT(NBTTagCompound p_145841_1_)
    {
        super.writeToNBT(p_145841_1_);
        p_145841_1_.setShort("BurnTime", (short)this.quernBurnTime);
        p_145841_1_.setShort("CookTime", (short)this.quernCookTime);
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < this.quernItemStacks.length; ++i)
        {
            if (this.quernItemStacks[i] != null)
            {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte)i);
                this.quernItemStacks[i].writeToNBT(nbttagcompound1);
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
        return this.quernCookTime * p_145953_1_ / 200;
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

        return this.quernBurnTime * p_145955_1_ / this.currentItemBurnTime;
    }

    /**
     * Quern isBurning
     */
    public boolean isBurning()
    {
        return this.quernBurnTime > 0;
    }

    public void updateEntity()
    {
        boolean flag = this.quernBurnTime > 0;
        boolean flag1 = false;

        if (this.quernBurnTime > 0)
        {
            --this.quernBurnTime;
        }

        if (!this.worldObj.isRemote)
        {
            if (this.quernBurnTime != 0 || this.quernItemStacks[1] != null && this.quernItemStacks[0] != null)
            {
                if (this.quernBurnTime == 0 && this.canSmelt())
                {
                    this.currentItemBurnTime = this.quernBurnTime = getItemBurnTime(this.quernItemStacks[1]);

                    if (this.quernBurnTime > 0)
                    {
                        flag1 = true;

                        if (this.quernItemStacks[1] != null)
                        {
                            --this.quernItemStacks[1].stackSize;

                            if (this.quernItemStacks[1].stackSize == 0)
                            {
                                this.quernItemStacks[1] = quernItemStacks[1].getItem().getContainerItem(quernItemStacks[1]);
                            }
                        }
                    }
                }

                if (this.isBurning() && this.canSmelt())
                {
                    ++this.quernCookTime;

                    if (this.quernCookTime == 200)
                    {
                        this.quernCookTime = 0;
                        this.smeltItem();
                        flag1 = true;
                    }
                }
                else
                {
                    this.quernCookTime = 0;
                }
            }

            if (flag != this.quernBurnTime > 0)
            {
                flag1 = true;
                BlockPamQuern.updateQuernBlockState(this.quernBurnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
            }
        }

        if (flag1)
        {
            this.markDirty();
        }
    }

    /**
     * Returns true if the quern can smelt an item, i.e. has a source item, destination stack isn't full, etc.
     */
    private boolean canSmelt()
    {
        if (this.quernItemStacks[0] == null)
        {
            return false;
        }
        else
        {
            ItemStack itemstack = QuernRecipes.smelting().getSmeltingResult(this.quernItemStacks[0]);
            if (itemstack == null) return false;
            if (this.quernItemStacks[2] == null) return true;
            if (!this.quernItemStacks[2].isItemEqual(itemstack)) return false;
            int result = quernItemStacks[2].stackSize + itemstack.stackSize;
            return result <= getInventoryStackLimit() && result <= this.quernItemStacks[2].getMaxStackSize(); //Forge BugFix: Make it respect stack sizes properly.
        }
    }

    /**
     * Turn one item from the quern source stack into the appropriate smelted item in the quern result stack
     */
    public void smeltItem()
    {
        if (this.canSmelt())
        {
            ItemStack itemstack = QuernRecipes.smelting().getSmeltingResult(this.quernItemStacks[0]);

            if (this.quernItemStacks[2] == null)
            {
                this.quernItemStacks[2] = itemstack.copy();
            }
            else if (this.quernItemStacks[2].getItem() == itemstack.getItem())
            {
                this.quernItemStacks[2].stackSize += itemstack.stackSize; // Forge BugFix: Results may have multiple items
            }

            --this.quernItemStacks[0].stackSize;

            if (this.quernItemStacks[0].stackSize <= 0)
            {
                this.quernItemStacks[0] = null;
            }
        }
    }

    /**
     * Returns the number of ticks that the supplied fuel item will keep the quern burning, or 0 if the item isn't
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

            
            if (item == Item.getItemFromBlock(Blocks.stone_pressure_plate)) return 1600;

            return GameRegistry.getFuelValue(p_145952_0_);
        }
    }

    public static boolean isItemFuel(ItemStack p_145954_0_)
    {
        /**
         * Returns the number of ticks that the supplied fuel item will keep the quern burning, or 0 if the item isn't
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

