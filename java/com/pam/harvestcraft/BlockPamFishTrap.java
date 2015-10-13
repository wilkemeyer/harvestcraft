/*     */ package com.pam.harvestcraft;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockContainer;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ public class BlockPamFishTrap
/*     */   extends BlockContainer
/*     */ {
/*     */   private IIcon top;
/*     */   private IIcon middle;
/*     */   private IIcon bottom;
/*  25 */   private final Random field_149933_a = new Random();
/*     */   private static boolean field_149934_M;
/*     */   
/*     */   public BlockPamFishTrap()
/*     */   {
/*  30 */     super(Material.wood);
/*  31 */     setStepSound(Block.soundTypeWood);
/*  32 */     this.setCreativeTab(harvestcraft.tabHarvestCraft);
/*     */   }
/*     */   
/*     */ 
/*     */   public TileEntity createNewTileEntity(World world)
/*     */   {
/*  38 */     return new TileEntityPamFishTrap();
/*     */   }
/*     */   
/*     */   public void breakBlock(World p_149749_1_, int p_149749_2_, int p_149749_3_, int p_149749_4_, Block p_149749_5_, int p_149749_6_)
/*     */   {
/*  43 */     if (!field_149934_M)
/*     */     {
/*  45 */       TileEntityPamFishTrap tileentitypamfishtrap = (TileEntityPamFishTrap)p_149749_1_.getTileEntity(p_149749_2_, p_149749_3_, p_149749_4_);
/*     */       
/*  47 */       if (tileentitypamfishtrap != null)
/*     */       {
/*  49 */         for (int i1 = 0; i1 < tileentitypamfishtrap.getSizeInventory(); i1++)
/*     */         {
/*  51 */           ItemStack itemstack = tileentitypamfishtrap.getStackInSlot(i1);
/*     */           
/*  53 */           if (itemstack != null)
/*     */           {
/*  55 */             float f = this.field_149933_a.nextFloat() * 0.8F + 0.1F;
/*  56 */             float f1 = this.field_149933_a.nextFloat() * 0.8F + 0.1F;
/*  57 */             float f2 = this.field_149933_a.nextFloat() * 0.8F + 0.1F;
/*     */             
/*  59 */             while (itemstack.stackSize > 0)
/*     */             {
/*  61 */               int j1 = this.field_149933_a.nextInt(21) + 10;
/*     */               
/*  63 */               if (j1 > itemstack.stackSize)
/*     */               {
/*  65 */                 j1 = itemstack.stackSize;
/*     */               }
/*     */               
/*  68 */               itemstack.stackSize -= j1;
/*  69 */               EntityItem entityitem = new EntityItem(p_149749_1_, p_149749_2_ + f, p_149749_3_ + f1, p_149749_4_ + f2, new ItemStack(itemstack.getItem(), j1, itemstack.getItemDamage()));
/*     */               
/*  71 */               if (itemstack.hasTagCompound())
/*     */               {
/*  73 */                 entityitem.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
/*     */               }
/*     */               
/*  76 */               float f3 = 0.05F;
/*  77 */               entityitem.motionX = ((float)this.field_149933_a.nextGaussian() * f3);
/*  78 */               entityitem.motionY = ((float)this.field_149933_a.nextGaussian() * f3 + 0.2F);
/*  79 */               entityitem.motionZ = ((float)this.field_149933_a.nextGaussian() * f3);
/*  80 */               p_149749_1_.spawnEntityInWorld(entityitem);
/*     */             }
/*     */           }
/*     */         }
/*     */         
/*  85 */         p_149749_1_.func_147453_f(p_149749_2_, p_149749_3_, p_149749_4_, p_149749_5_);
/*     */       }
/*     */     }
/*     */     
/*  89 */     super.breakBlock(p_149749_1_, p_149749_2_, p_149749_3_, p_149749_4_, p_149749_5_, p_149749_6_);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float xCoord, float yCoord, float zCoord)
/*     */   {
/*  97 */     TileEntity tile = world.getTileEntity(x, y, z);
/*     */     
/*  99 */     if ((tile == null) || (player.isSneaking()))
/*     */     {
/* 101 */       return false;
/*     */     }
/*     */     
/* 104 */     player.openGui(harvestcraft.instance, 9, world, x, y, z);
/*     */     
/* 106 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void registerBlockIcons(IIconRegister par1IconRegister)
/*     */   {
/* 113 */     this.middle = par1IconRegister.registerIcon("harvestcraft:fishtrap");
/* 114 */     this.top = par1IconRegister.registerIcon("harvestcraft:fishtrap");
/* 115 */     this.bottom = par1IconRegister.registerIcon("harvestcraft:fishtrap");
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon getIcon(int par1, int par2)
/*     */   {
/* 121 */     switch (par1)
/*     */     {
/*     */     case 0: 
/* 124 */       return this.bottom;
/*     */     case 1: 
/* 126 */       return this.top;
/*     */     }
/* 128 */     return this.middle;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public TileEntity createNewTileEntity(World var1, int var2)
/*     */   {
/* 135 */     return new TileEntityPamFishTrap();
/*     */   }
/*     */ }


/* Location:              C:\Users\Modding\Desktop\Pam's HarvestCraft 1.7.10k.deobf.jar!\com\pam\harvestcraft\BlockPamFishTrap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */