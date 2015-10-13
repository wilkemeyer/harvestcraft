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
/*     */ 
/*     */ public class BlockPamWaterGarden
/*     */   extends BlockFlower
/*     */   implements IPlantable
/*     */ {
/*     */   public IIcon[] icons;
/*     */   
/*     */   protected BlockPamWaterGarden(int par2)
/*     */   {
/*  30 */     super(par2);
/*  31 */     float var4 = 0.2F;
/*  32 */     setBlockBounds(0.5F - var4, 0.0F, 0.5F - var4, 0.5F + var4, var4 * 3.0F, 0.5F + var4);
/*  33 */     setStepSound(Block.soundTypeGrass);
/*  34 */     setTickRandomly(true);
/*  35 */     this.setCreativeTab(harvestcraft.tabHarvestCraft2);
/*     */   }
/*     */   
/*     */   protected boolean func_149854_a(Block p_149854_1_)
/*     */   {
/*  40 */     return p_149854_1_ == Blocks.water;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getRenderType()
/*     */   {
/*  47 */     return 23;
/*     */   }
/*     */   
/*     */   public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
/*     */   {
/*  52 */     if (BlockRegistry.gardensdropSeeds == true)
/*     */     {
/*  54 */       int i = p_149650_2_.nextInt(13);
/*     */       
/*  56 */       if (i == 0)
/*     */       {
/*  58 */         if (BlockRegistry.enablecropspecialplanting) {
/*  59 */           return ItemRegistry.cranberryItem;
/*     */         }
/*  61 */         return ItemRegistry.cranberryseedItem;
/*     */       }
/*     */       
/*  64 */       if (i == 1)
/*     */       {
/*  66 */         if (BlockRegistry.enablecropspecialplanting) {
/*  67 */           return ItemRegistry.riceItem;
/*     */         }
/*  69 */         return ItemRegistry.riceseedItem;
/*     */       }
/*     */       
/*  72 */       if (i == 2)
/*     */       {
/*  74 */         if (BlockRegistry.enablecropspecialplanting) {
/*  75 */           return ItemRegistry.seaweedItem;
/*     */         }
/*  77 */         return ItemRegistry.seaweedseedItem;
/*     */       }
/*     */       
/*  80 */       if (i == 3)
/*     */       {
/*  82 */         return ItemRegistry.clamrawItem;
/*     */       }
/*  84 */       if (i == 4)
/*     */       {
/*  86 */         return ItemRegistry.crabrawItem;
/*     */       }
/*  88 */       if (i == 5)
/*     */       {
/*  90 */         return ItemRegistry.crayfishrawItem;
/*     */       }
/*  92 */       if (i == 6)
/*     */       {
/*  94 */         return ItemRegistry.frograwItem;
/*     */       }
/*  96 */       if (i == 7)
/*     */       {
/*  98 */         return ItemRegistry.scalloprawItem;
/*     */       }
/* 100 */       if (i == 8)
/*     */       {
/* 102 */         return ItemRegistry.shrimprawItem;
/*     */       }
/* 104 */       if (i == 9)
/*     */       {
/* 106 */         return ItemRegistry.turtlerawItem;
/*     */       }
/* 108 */       if (i == 10)
/*     */       {
/* 110 */         if (BlockRegistry.enablecropspecialplanting) {
/* 111 */           return ItemRegistry.waterchestnutItem;
/*     */         }
/* 113 */         return ItemRegistry.waterchestnutseedItem;
/*     */       }
/*     */       
/* 116 */       if (i == 9)
/*     */       {
/* 118 */         return ItemRegistry.snailrawItem;
/*     */       }
/* 120 */       return ItemRegistry.greenheartfishItem;
/*     */     }
/*     */     
/* 123 */     int i = p_149650_2_.nextInt(13);
/*     */     
/* 125 */     if (i == 0)
/*     */     {
/* 127 */       return ItemRegistry.cranberryItem;
/*     */     }
/* 129 */     if (i == 1)
/*     */     {
/* 131 */       return ItemRegistry.riceItem;
/*     */     }
/* 133 */     if (i == 2)
/*     */     {
/* 135 */       return ItemRegistry.seaweedItem;
/*     */     }
/* 137 */     if (i == 3)
/*     */     {
/* 139 */       return ItemRegistry.clamrawItem;
/*     */     }
/* 141 */     if (i == 4)
/*     */     {
/* 143 */       return ItemRegistry.crabrawItem;
/*     */     }
/* 145 */     if (i == 5)
/*     */     {
/* 147 */       return ItemRegistry.crayfishrawItem;
/*     */     }
/* 149 */     if (i == 6)
/*     */     {
/* 151 */       return ItemRegistry.frograwItem;
/*     */     }
/* 153 */     if (i == 7)
/*     */     {
/* 155 */       return ItemRegistry.scalloprawItem;
/*     */     }
/* 157 */     if (i == 8)
/*     */     {
/* 159 */       return ItemRegistry.shrimprawItem;
/*     */     }
/* 161 */     if (i == 9)
/*     */     {
/* 163 */       return ItemRegistry.turtlerawItem;
/*     */     }
/* 165 */     if (i == 10)
/*     */     {
/* 167 */       return ItemRegistry.waterchestnutItem;
/*     */     }
/* 169 */     if (i == 11)
/*     */     {
/* 171 */       return ItemRegistry.snailrawItem;
/*     */     }
/* 173 */     return ItemRegistry.greenheartfishItem;
/*     */   }
/*     */   
/*     */ 
/*     */   public int quantityDropped(Random p_149745_1_)
/*     */   {
/* 179 */     return BlockRegistry.gardendropAmount;
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
/* 245 */     int meta = world.getBlockMetadata(par2, par3, par4);
/*     */     
/* 247 */     if (meta == 0)
/*     */     {
/* 249 */       if (meta == 0)
/*     */       {
/* 251 */         dropBlockAsItem(world, par2, par3, par4, new ItemStack(this, 1, 0));
/* 252 */         world.setBlockToAir(par2, par3, par4);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 257 */     return false;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void registerBlockIcons(IIconRegister par1IconRegister)
/*     */   {
/* 263 */     this.blockIcon = par1IconRegister.registerIcon("harvestcraft:watergarden0");
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon getIcon(int par1, int par2) {
/* 268 */     return this.blockIcon;
/*     */   }
/*     */   
/*     */ 
/*     */   public EnumPlantType getPlantType(World world, int x, int y, int z)
/*     */   {
/* 274 */     return EnumPlantType.Water;
/*     */   }
/*     */   
/*     */ 
/*     */   public Block getPlant(IBlockAccess world, int x, int y, int z)
/*     */   {
/* 280 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getPlantMetadata(IBlockAccess world, int x, int y, int z)
/*     */   {
/* 286 */     return world.getBlockMetadata(x, y, z);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List)
/*     */   {
/* 295 */     for (int i = 0; i < 1; i++)
/*     */     {
/* 297 */       par3List.add(new ItemStack(par1, 1, i));
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Modding\Desktop\Pam's HarvestCraft 1.7.10k.deobf.jar!\com\pam\harvestcraft\BlockPamWaterGarden.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */