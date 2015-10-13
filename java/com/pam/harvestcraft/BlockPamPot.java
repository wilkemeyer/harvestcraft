/*     */ package com.pam.harvestcraft;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class BlockPamPot extends Block
/*     */ {
/*     */   private IIcon top;
/*     */   private IIcon middle;
/*     */   private IIcon bottom;
/*     */   
/*     */   public BlockPamPot()
/*     */   {
/*  25 */     super(Material.iron);
/*  26 */     setStepSound(Block.soundTypeMetal);
/*  27 */     setTickRandomly(true);
/*  28 */     setBlockBoundsForItemRender();
/*  29 */     this.setCreativeTab(harvestcraft.tabHarvestCraft);
/*     */   }
/*     */   
/*     */   public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
/*     */   {
/*  34 */     return ItemRegistry.potItem;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setBlockBoundsForItemRender()
/*     */   {
/*  41 */     setBlockBounds(0.25F, 0.0F, 0.25F, 0.75F, 0.4F, 0.75F);
/*     */   }
/*     */   
/*     */ 
/*     */   public int quantityDropped(Random random)
/*     */   {
/*  47 */     return 1;
/*     */   }
/*     */   
/*     */   public boolean isOpaqueCube()
/*     */   {
/*  52 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getRenderType()
/*     */   {
/*  60 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean renderAsNormalBlock()
/*     */   {
/*  68 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
/*     */   {
/*  76 */     par5EntityPlayer.openGui(harvestcraft.instance, 3, par1World, par2, par3, par4);
/*  77 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void registerBlockIcons(IIconRegister par1IconRegister)
/*     */   {
/*  84 */     this.middle = par1IconRegister.registerIcon("harvestcraft:potsidebottom");
/*  85 */     this.top = par1IconRegister.registerIcon("harvestcraft:pottop");
/*  86 */     this.bottom = par1IconRegister.registerIcon("harvestcraft:potsidebottom");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon getIcon(int par1, int par2)
/*     */   {
/*  96 */     switch (par1)
/*     */     {
/*     */     case 0: 
/*  99 */       return this.bottom;
/*     */     case 1: 
/* 101 */       return this.top;
/*     */     }
/* 103 */     return this.middle;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
/*     */   {
/* 116 */     byte b0 = 0;
/* 117 */     float f = 0.0625F;
/* 118 */     return AxisAlignedBB.getBoundingBox(par2 + this.minX, par3 + this.minY, par4 + this.minZ, par2 + this.maxX, par3 + b0 * f, par4 + this.maxZ);
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean canPlaceBlockOn(Block p_149854_1_)
/*     */   {
/* 124 */     return (p_149854_1_ == Blocks.furnace) || (p_149854_1_ == Blocks.lit_furnace) || (p_149854_1_ == BlockRegistry.pamOven) || (p_149854_1_ == BlockRegistry.pamOvenon);
/*     */   }
/*     */   
/*     */   public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
/*     */   {
/* 129 */     return (super.canPlaceBlockAt(par1World, par2, par3, par4)) && (canBlockStay(par1World, par2, par3, par4));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
/*     */   {
/* 138 */     func_111046_k(par1World, par2, par3, par4);
/*     */   }
/*     */   
/*     */   private boolean func_111046_k(World par1World, int par2, int par3, int par4)
/*     */   {
/* 143 */     if (!canBlockStay(par1World, par2, par3, par4))
/*     */     {
/* 145 */       dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
/* 146 */       par1World.setBlockToAir(par2, par3, par4);
/* 147 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 151 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean canBlockStay(World par1World, int par2, int par3, int par4)
/*     */   {
/* 160 */     return (par1World.getBlock(par2, par3 - 1, par4) == Blocks.furnace) || (par1World.getBlock(par2, par3 - 1, par4) == Blocks.lit_furnace) || (par1World.getBlock(par2, par3 - 1, par4) == BlockRegistry.pamOven) || (par1World.getBlock(par2, par3 - 1, par4) == BlockRegistry.pamOvenon);
/*     */   }
/*     */   
/*     */ 
/*     */   public void onNeighborBlockChange(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_)
/*     */   {
/* 166 */     if (!canBlockStay(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_))
/*     */     {
/* 168 */       p_149695_1_.func_147480_a(p_149695_2_, p_149695_3_, p_149695_4_, false);
/* 169 */       dropBlockAsItem(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_, p_149695_1_.getBlockMetadata(p_149695_2_, p_149695_3_, p_149695_4_), 0);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
/*     */   {
/* 181 */     return par5 == 1 ? true : super.shouldSideBeRendered(par1IBlockAccess, par2, par3, par4, par5);
/*     */   }
/*     */ }


/* Location:              C:\Users\Modding\Desktop\Pam's HarvestCraft 1.7.10k.deobf.jar!\com\pam\harvestcraft\BlockPamPot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */