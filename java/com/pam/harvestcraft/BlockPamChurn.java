/*     */ package com.pam.harvestcraft;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockContainer;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.inventory.Container;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ public class BlockPamChurn
/*     */   extends BlockContainer
/*     */ {
/*  28 */   private final Random field_149933_a = new Random();
/*     */   private final boolean field_149932_b;
/*     */   private static boolean field_149934_M;
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon field_149935_N;
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon field_149936_O;
/*     */   private static final String __OBFID = "CL_00000248";
/*     */   
/*     */   public BlockPamChurn(boolean p_i45407_1_) {
/*  38 */     super(Material.wood);
/*  39 */     this.field_149932_b = p_i45407_1_;
/*     */   }
/*     */   
/*     */   public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
/*     */   {
/*  44 */     return Item.getItemFromBlock(BlockRegistry.pamChurn);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onBlockAdded(World p_149726_1_, int p_149726_2_, int p_149726_3_, int p_149726_4_)
/*     */   {
/*  52 */     super.onBlockAdded(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_);
/*  53 */     func_149930_e(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_);
/*     */   }
/*     */   
/*     */   private void func_149930_e(World p_149930_1_, int p_149930_2_, int p_149930_3_, int p_149930_4_)
/*     */   {
/*  58 */     if (!p_149930_1_.isRemote)
/*     */     {
/*  60 */       Block block = p_149930_1_.getBlock(p_149930_2_, p_149930_3_, p_149930_4_ - 1);
/*  61 */       Block block1 = p_149930_1_.getBlock(p_149930_2_, p_149930_3_, p_149930_4_ + 1);
/*  62 */       Block block2 = p_149930_1_.getBlock(p_149930_2_ - 1, p_149930_3_, p_149930_4_);
/*  63 */       Block block3 = p_149930_1_.getBlock(p_149930_2_ + 1, p_149930_3_, p_149930_4_);
/*  64 */       byte b0 = 3;
/*     */       
/*  66 */       if ((block.func_149730_j()) && (!block1.func_149730_j()))
/*     */       {
/*  68 */         b0 = 3;
/*     */       }
/*     */       
/*  71 */       if ((block1.func_149730_j()) && (!block.func_149730_j()))
/*     */       {
/*  73 */         b0 = 2;
/*     */       }
/*     */       
/*  76 */       if ((block2.func_149730_j()) && (!block3.func_149730_j()))
/*     */       {
/*  78 */         b0 = 5;
/*     */       }
/*     */       
/*  81 */       if ((block3.func_149730_j()) && (!block2.func_149730_j()))
/*     */       {
/*  83 */         b0 = 4;
/*     */       }
/*     */       
/*  86 */       p_149930_1_.setBlockMetadataWithNotify(p_149930_2_, p_149930_3_, p_149930_4_, b0, 2);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon getIcon(int p_149691_1_, int p_149691_2_)
/*     */   {
/*  96 */     return p_149691_1_ != p_149691_2_ ? this.blockIcon : p_149691_1_ == 0 ? this.field_149935_N : p_149691_1_ == 1 ? this.field_149935_N : this.field_149936_O;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void registerBlockIcons(IIconRegister p_149651_1_)
/*     */   {
/* 102 */     this.blockIcon = p_149651_1_.registerIcon("harvestcraft:churnside");
/* 103 */     this.field_149936_O = p_149651_1_.registerIcon(this.field_149932_b ? "harvestcraft:churnfronton" : "harvestcraft:churnfrontoff");
/* 104 */     this.field_149935_N = p_149651_1_.registerIcon("harvestcraft:churntop");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
/*     */   {
/* 112 */     par5EntityPlayer.openGui(harvestcraft.instance, 6, par1World, par2, par3, par4);
/* 113 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void updateChurnBlockState(boolean p_149931_0_, World p_149931_1_, int p_149931_2_, int p_149931_3_, int p_149931_4_)
/*     */   {
/* 121 */     int l = p_149931_1_.getBlockMetadata(p_149931_2_, p_149931_3_, p_149931_4_);
/* 122 */     TileEntity tileentity = p_149931_1_.getTileEntity(p_149931_2_, p_149931_3_, p_149931_4_);
/* 123 */     field_149934_M = true;
/*     */     
/* 125 */     if (p_149931_0_)
/*     */     {
/* 127 */       p_149931_1_.setBlock(p_149931_2_, p_149931_3_, p_149931_4_, BlockRegistry.pamChurnon);
/*     */     }
/*     */     else
/*     */     {
/* 131 */       p_149931_1_.setBlock(p_149931_2_, p_149931_3_, p_149931_4_, BlockRegistry.pamChurn);
/*     */     }
/*     */     
/* 134 */     field_149934_M = false;
/* 135 */     p_149931_1_.setBlockMetadataWithNotify(p_149931_2_, p_149931_3_, p_149931_4_, l, 2);
/*     */     
/* 137 */     if (tileentity != null)
/*     */     {
/* 139 */       tileentity.validate();
/* 140 */       p_149931_1_.setTileEntity(p_149931_2_, p_149931_3_, p_149931_4_, tileentity);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_)
/*     */   {
/* 149 */     return new TileEntityChurn();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onBlockPlacedBy(World p_149689_1_, int p_149689_2_, int p_149689_3_, int p_149689_4_, EntityLivingBase p_149689_5_, ItemStack p_149689_6_)
/*     */   {
/* 157 */     int l = MathHelper.floor_double(p_149689_5_.rotationYaw * 4.0F / 360.0F + 0.5D) & 0x3;
/*     */     
/* 159 */     if (l == 0)
/*     */     {
/* 161 */       p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, 2, 2);
/*     */     }
/*     */     
/* 164 */     if (l == 1)
/*     */     {
/* 166 */       p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, 5, 2);
/*     */     }
/*     */     
/* 169 */     if (l == 2)
/*     */     {
/* 171 */       p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, 3, 2);
/*     */     }
/*     */     
/* 174 */     if (l == 3)
/*     */     {
/* 176 */       p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, 4, 2);
/*     */     }
/*     */     
/* 179 */     if (p_149689_6_.hasDisplayName())
/*     */     {
/* 181 */       ((TileEntityChurn)p_149689_1_.getTileEntity(p_149689_2_, p_149689_3_, p_149689_4_)).func_145951_a(p_149689_6_.getDisplayName());
/*     */     }
/*     */   }
/*     */   
/*     */   public void breakBlock(World p_149749_1_, int p_149749_2_, int p_149749_3_, int p_149749_4_, Block p_149749_5_, int p_149749_6_)
/*     */   {
/* 187 */     if (!field_149934_M)
/*     */     {
/* 189 */       TileEntityChurn tileentitychurn = (TileEntityChurn)p_149749_1_.getTileEntity(p_149749_2_, p_149749_3_, p_149749_4_);
/*     */       
/* 191 */       if (tileentitychurn != null)
/*     */       {
/* 193 */         for (int i1 = 0; i1 < tileentitychurn.getSizeInventory(); i1++)
/*     */         {
/* 195 */           ItemStack itemstack = tileentitychurn.getStackInSlot(i1);
/*     */           
/* 197 */           if (itemstack != null)
/*     */           {
/* 199 */             float f = this.field_149933_a.nextFloat() * 0.8F + 0.1F;
/* 200 */             float f1 = this.field_149933_a.nextFloat() * 0.8F + 0.1F;
/* 201 */             float f2 = this.field_149933_a.nextFloat() * 0.8F + 0.1F;
/*     */             
/* 203 */             while (itemstack.stackSize > 0)
/*     */             {
/* 205 */               int j1 = this.field_149933_a.nextInt(21) + 10;
/*     */               
/* 207 */               if (j1 > itemstack.stackSize)
/*     */               {
/* 209 */                 j1 = itemstack.stackSize;
/*     */               }
/*     */               
/* 212 */               itemstack.stackSize -= j1;
/* 213 */               EntityItem entityitem = new EntityItem(p_149749_1_, p_149749_2_ + f, p_149749_3_ + f1, p_149749_4_ + f2, new ItemStack(itemstack.getItem(), j1, itemstack.getItemDamage()));
/*     */               
/* 215 */               if (itemstack.hasTagCompound())
/*     */               {
/* 217 */                 entityitem.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
/*     */               }
/*     */               
/* 220 */               float f3 = 0.05F;
/* 221 */               entityitem.motionX = ((float)this.field_149933_a.nextGaussian() * f3);
/* 222 */               entityitem.motionY = ((float)this.field_149933_a.nextGaussian() * f3 + 0.2F);
/* 223 */               entityitem.motionZ = ((float)this.field_149933_a.nextGaussian() * f3);
/* 224 */               p_149749_1_.spawnEntityInWorld(entityitem);
/*     */             }
/*     */           }
/*     */         }
/*     */         
/* 229 */         p_149749_1_.func_147453_f(p_149749_2_, p_149749_3_, p_149749_4_, p_149749_5_);
/*     */       }
/*     */     }
/*     */     
/* 233 */     super.breakBlock(p_149749_1_, p_149749_2_, p_149749_3_, p_149749_4_, p_149749_5_, p_149749_6_);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean hasComparatorInputOverride()
/*     */   {
/* 245 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getComparatorInputOverride(World p_149736_1_, int p_149736_2_, int p_149736_3_, int p_149736_4_, int p_149736_5_)
/*     */   {
/* 254 */     return Container.calcRedstoneFromInventory((IInventory)p_149736_1_.getTileEntity(p_149736_2_, p_149736_3_, p_149736_4_));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_)
/*     */   {
/* 263 */     return Item.getItemFromBlock(BlockRegistry.pamChurn);
/*     */   }
/*     */ }


/* Location:              C:\Users\Modding\Desktop\Pam's HarvestCraft 1.7.10k.deobf.jar!\com\pam\harvestcraft\BlockPamChurn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */