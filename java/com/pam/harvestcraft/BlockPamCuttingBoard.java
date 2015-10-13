/*     */ package com.pam.harvestcraft;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class BlockPamCuttingBoard extends Block
/*     */ {
/*     */   private IIcon top;
/*     */   private IIcon middle;
/*     */   private IIcon bottom;
/*     */   
/*     */   public BlockPamCuttingBoard()
/*     */   {
/*  24 */     super(Material.wood);
/*  25 */     setStepSound(Block.soundTypeWood);
/*  26 */     setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.0625F, 1.0F);
/*  27 */     setTickRandomly(true);
/*  28 */     func_111047_d(0);
/*  29 */     this.setCreativeTab(harvestcraft.tabHarvestCraft);
/*     */   }
/*     */   
/*     */   public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
/*     */   {
/*  34 */     return ItemRegistry.cuttingboardItem;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
/*     */   {
/*  42 */     par5EntityPlayer.openGui(harvestcraft.instance, 2, par1World, par2, par3, par4);
/*  43 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void registerBlockIcons(IIconRegister par1IconRegister)
/*     */   {
/*  50 */     this.middle = par1IconRegister.registerIcon("harvestcraft:cuttingboardsidebottom");
/*  51 */     this.top = par1IconRegister.registerIcon("harvestcraft:cuttingboardtop");
/*  52 */     this.bottom = par1IconRegister.registerIcon("harvestcraft:cuttingboardsidebottom");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon getIcon(int par1, int par2)
/*     */   {
/*  62 */     switch (par1)
/*     */     {
/*     */     case 0: 
/*  65 */       return this.bottom;
/*     */     case 1: 
/*  67 */       return this.top;
/*     */     }
/*  69 */     return this.middle;
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
/*  82 */     byte b0 = 0;
/*  83 */     float f = 0.0625F;
/*  84 */     return AxisAlignedBB.getBoundingBox(par2 + this.minX, par3 + this.minY, par4 + this.minZ, par2 + this.maxX, par3 + b0 * f, par4 + this.maxZ);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isOpaqueCube()
/*     */   {
/*  93 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean renderAsNormalBlock()
/*     */   {
/* 101 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBlockBoundsForItemRender()
/*     */   {
/* 109 */     func_111047_d(0);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
/*     */   {
/* 117 */     func_111047_d(par1IBlockAccess.getBlockMetadata(par2, par3, par4));
/*     */   }
/*     */   
/*     */   protected void func_111047_d(int par1)
/*     */   {
/* 122 */     byte b0 = 0;
/* 123 */     float f = 1 * (1 + b0) / 16.0F;
/* 124 */     setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, f, 1.0F);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
/*     */   {
/* 132 */     return (super.canPlaceBlockAt(par1World, par2, par3, par4)) && (canBlockStay(par1World, par2, par3, par4));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
/*     */   {
/* 141 */     func_111046_k(par1World, par2, par3, par4);
/*     */   }
/*     */   
/*     */   private boolean func_111046_k(World par1World, int par2, int par3, int par4)
/*     */   {
/* 146 */     if (!canBlockStay(par1World, par2, par3, par4))
/*     */     {
/* 148 */       dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
/* 149 */       par1World.setBlockToAir(par2, par3, par4);
/* 150 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 154 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean canBlockStay(World par1World, int par2, int par3, int par4)
/*     */   {
/* 163 */     return !par1World.isAirBlock(par2, par3 - 1, par4);
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
/* 174 */     return par5 == 1 ? true : super.shouldSideBeRendered(par1IBlockAccess, par2, par3, par4, par5);
/*     */   }
/*     */ }


/* Location:              C:\Users\Modding\Desktop\Pam's HarvestCraft 1.7.10k.deobf.jar!\com\pam\harvestcraft\BlockPamCuttingBoard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */