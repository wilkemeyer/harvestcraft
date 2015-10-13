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
/*     */ public class BlockPamMushroomGarden
/*     */   extends BlockFlower implements IPlantable
/*     */ {
/*     */   public IIcon[] icons;
/*     */   
/*     */   protected BlockPamMushroomGarden(int par2)
/*     */   {
/*  28 */     super(par2);
/*  29 */     float var4 = 0.2F;
/*  30 */     setBlockBounds(0.5F - var4, 0.0F, 0.5F - var4, 0.5F + var4, var4 * 3.0F, 0.5F + var4);
/*  31 */     setStepSound(Block.soundTypeGrass);
/*  32 */     setTickRandomly(true);
/*  33 */     this.setCreativeTab(harvestcraft.tabHarvestCraft2);
/*     */   }
/*     */   
/*     */   protected boolean func_149854_a(Block p_149854_1_)
/*     */   {
/*  38 */     return p_149854_1_ == Blocks.log;
/*     */   }
/*     */   
/*     */   public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
/*     */   {
/*  43 */     if (BlockRegistry.gardensdropSeeds == true)
/*     */     {
/*  45 */       return ItemRegistry.whitemushroomseedItem;
/*     */     }
/*  47 */     int i = p_149650_2_.nextInt(3);
/*     */     
/*  49 */     if (i == 0)
/*     */     {
/*  51 */       return Item.getItemFromBlock(Blocks.brown_mushroom);
/*     */     }
/*  53 */     if (i == 1)
/*     */     {
/*  55 */       return Item.getItemFromBlock(Blocks.red_mushroom);
/*     */     }
/*  57 */     return ItemRegistry.whitemushroomItem;
/*     */   }
/*     */   
/*     */   public int quantityDropped(Random p_149745_1_)
/*     */   {
/*  62 */     return BlockRegistry.gardendropAmount;
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
/* 128 */     int meta = world.getBlockMetadata(par2, par3, par4);
/*     */     
/* 130 */     if (meta == 0)
/*     */     {
/* 132 */       if (meta == 0)
/*     */       {
/* 134 */         dropBlockAsItem(world, par2, par3, par4, new ItemStack(this, 1, 0));
/* 135 */         world.setBlockToAir(par2, par3, par4);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 140 */     return false;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void registerBlockIcons(IIconRegister par1IconRegister)
/*     */   {
/* 146 */     this.blockIcon = par1IconRegister.registerIcon("harvestcraft:mushroomgarden0");
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon getIcon(int par1, int par2) {
/* 151 */     return this.blockIcon;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public EnumPlantType getPlantType(World world, int x, int y, int z)
/*     */   {
/* 158 */     return EnumPlantType.Plains;
/*     */   }
/*     */   
/*     */ 
/*     */   public Block getPlant(IBlockAccess world, int x, int y, int z)
/*     */   {
/* 164 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getPlantMetadata(IBlockAccess world, int x, int y, int z)
/*     */   {
/* 170 */     return world.getBlockMetadata(x, y, z);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List)
/*     */   {
/* 179 */     for (int i = 0; i < 1; i++)
/*     */     {
/* 181 */       par3List.add(new ItemStack(par1, 1, i));
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Modding\Desktop\Pam's HarvestCraft 1.7.10k.deobf.jar!\com\pam\harvestcraft\BlockPamMushroomGarden.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */