/*     */ package com.pam.harvestcraft;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockFlower;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.EnumPlantType;
/*     */ import net.minecraftforge.common.IPlantable;
/*     */ 
/*     */ public class BlockPamDesertGarden
/*     */   extends BlockFlower
/*     */   implements IPlantable
/*     */ {
/*     */   protected BlockPamDesertGarden(int par2)
/*     */   {
/*  27 */     super(par2);
/*  28 */     float var4 = 0.2F;
/*  29 */     setBlockBounds(0.5F - var4, 0.0F, 0.5F - var4, 0.5F + var4, var4 * 3.0F, 0.5F + var4);
/*  30 */     setStepSound(Block.soundTypeGrass);
/*  31 */     setTickRandomly(true);
/*  32 */     this.setCreativeTab(harvestcraft.tabHarvestCraft2);
/*     */   }
/*     */   
/*     */   protected boolean func_149854_a(Block p_149854_1_)
/*     */   {
/*  37 */     return p_149854_1_ == Blocks.sand;
/*     */   }
/*     */   
/*     */   public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
/*     */   {
/*  42 */     if (BlockRegistry.gardensdropSeeds == true)
/*     */     {
/*  44 */       return ItemRegistry.cactusfruitseedItem;
/*     */     }
/*  46 */     return ItemRegistry.cactusfruitItem;
/*     */   }
/*     */   
/*     */   public int quantityDropped(Random p_149745_1_)
/*     */   {
/*  51 */     return BlockRegistry.gardendropAmount;
/*     */   }
/*     */   
public void updateTick(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_)
{
	if (BlockRegistry.enablegardenSpread == true)
	{
    if (p_149674_5_.nextInt(BlockRegistry.gardenspreadRate) == 0)
    {
        byte b0 = 4;
        int l = 5;
        int i1;
        int j1;
        int k1;
        
        int i = this.getDamageValue(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_);

        for (i1 = p_149674_2_ - b0; i1 <= p_149674_2_ + b0; ++i1)
        {
            for (j1 = p_149674_4_ - b0; j1 <= p_149674_4_ + b0; ++j1)
            {
                for (k1 = p_149674_3_ - 1; k1 <= p_149674_3_ + 1; ++k1)
                {
                    if (p_149674_1_.getBlock(i1, k1, j1) == this)
                    {
                        --l;

                        if (l <= 0)
                        {
                            return;
                        }
                    }
                }
            }
        }

        i1 = p_149674_2_ + p_149674_5_.nextInt(3) - 1;
        j1 = p_149674_3_ + p_149674_5_.nextInt(2) - p_149674_5_.nextInt(2);
        k1 = p_149674_4_ + p_149674_5_.nextInt(3) - 1;

        for (int l1 = 0; l1 < 4; ++l1)
        {
            if (p_149674_1_.isAirBlock(i1, j1, k1) && this.canBlockStay(p_149674_1_, i1, j1, k1))
            {
                p_149674_2_ = i1;
                p_149674_3_ = j1;
                p_149674_4_ = k1;
            }

            i1 = p_149674_2_ + p_149674_5_.nextInt(3) - 1;
            j1 = p_149674_3_ + p_149674_5_.nextInt(2) - p_149674_5_.nextInt(2);
            k1 = p_149674_4_ + p_149674_5_.nextInt(3) - 1;
        }

        if (p_149674_1_.isAirBlock(i1, j1, k1) && this.canBlockStay(p_149674_1_, i1, j1, k1))
        {
            p_149674_1_.setBlock(i1, j1, k1, this, i, 2);
        }
    }
	}
}
/*     */   public boolean onBlockActivated(World world, int par2, int par3, int par4, EntityPlayer player, int par6, float par7, float par8, float par9)
/*     */   {
/* 117 */     int meta = world.getBlockMetadata(par2, par3, par4);
/*     */     
/* 119 */     if (meta == 0)
/*     */     {
/* 121 */       if (meta == 0)
/*     */       {
/* 123 */         dropBlockAsItem(world, par2, par3, par4, new ItemStack(this, 1, 0));
/* 124 */         world.setBlockToAir(par2, par3, par4);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 129 */     return false;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void registerBlockIcons(IIconRegister par1IconRegister)
/*     */   {
/* 135 */     this.blockIcon = par1IconRegister.registerIcon("harvestcraft:desertgarden0");
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon getIcon(int par1, int par2) {
/* 140 */     return this.blockIcon;
/*     */   }
/*     */   
/*     */ 
/*     */   public EnumPlantType getPlantType(World world, int x, int y, int z)
/*     */   {
/* 146 */     return EnumPlantType.Desert;
/*     */   }
/*     */   
/*     */ 
/*     */   public Block getPlant(IBlockAccess world, int x, int y, int z)
/*     */   {
/* 152 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getPlantMetadata(IBlockAccess world, int x, int y, int z)
/*     */   {
/* 158 */     return world.getBlockMetadata(x, y, z);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List)
/*     */   {
/* 167 */     for (int i = 0; i < 1; i++)
/*     */     {
/* 169 */       par3List.add(new ItemStack(par1, 1, i));
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Modding\Desktop\Pam's HarvestCraft 1.7.10k.deobf.jar!\com\pam\harvestcraft\BlockPamDesertGarden.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */