package com.pam.harvestcraft;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

public class ItemPamSeedFood extends ItemFood implements IPlantable
{
    private Block field_150908_b;
    /**
     * Block ID of the soil this seed food should be planted on.
     */
    private Block soilId;
    private static final String __OBFID = "CL_00000060";

    public ItemPamSeedFood(int p_i45351_1_, float p_i45351_2_, Block p_i45351_3_, Block p_i45351_4_)
    {
        super(p_i45351_1_, p_i45351_2_, false);
        this.field_150908_b = p_i45351_3_;
        this.soilId = p_i45351_4_;
    }

    /**
     * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
     * True if something happen and false if it don't. This is for ITEMS, not BLOCKS
     */
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
    	if (ItemRegistry.enablecropitemsasseeds)
    	{
	        if (par7 != 1)
	        {
	            return false;
	        }
	        else if (par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack) && par2EntityPlayer.canPlayerEdit(par4, par5 + 1, par6, par7, par1ItemStack))
	        {
	        	boolean isWaterPlant = (this == ItemRegistry.cranberryItem 
	        						 || this == ItemRegistry.riceItem
	        						 || this == ItemRegistry.seaweedItem);
	        	
	        	if (isWaterPlant && BlockRegistry.enablecropspecialplanting)
	        	{
		            if (par3World.getBlock(par4, par5 + 1, par6).getMaterial() == Material.water 
		            	&& par3World.getBlockMetadata(par4, par5 + 1, par6) == 0
		            	&& par3World.isAirBlock(par4, par5 + 2, par6))
		            {
		            	par3World.setBlock(par4, par5 + 2, par6, this.field_150908_b);
		                --par1ItemStack.stackSize;
		                return true;
		            }
	        	} else if (par3World.getBlock(par4, par5, par6) == this.soilId && par3World.isAirBlock(par4, par5 + 1, par6))
	            {
	                par3World.setBlock(par4, par5 + 1, par6, this.field_150908_b);
	                --par1ItemStack.stackSize;
	                return true;
	            }
	        }
    	}
    	return false;
    }

    @Override
    public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z)
    {
    	if (BlockRegistry.enablecropspecialplanting)
    	{
    	if (this == ItemRegistry.cactusfruitItem)
        {
        	return EnumPlantType.Desert;
        }
		if (this == ItemRegistry.cranberryItem)
        {
        	return EnumPlantType.Water;
        }
		if (this == ItemRegistry.riceItem)
        {
        	return EnumPlantType.Water;
        }
		if (this == ItemRegistry.seaweedItem)
        {
        	return EnumPlantType.Water;
        }
    	}
        return EnumPlantType.Crop;
    }

    @Override
    public Block getPlant(IBlockAccess world, int x, int y, int z)
    {
        return field_150908_b;
    }

    @Override
    public int getPlantMetadata(IBlockAccess world, int x, int y, int z)
    {
        return 0;
    }
}