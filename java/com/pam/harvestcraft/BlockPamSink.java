/*     */ package com.pam.harvestcraft;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.inventory.Container;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemArmor;
/*     */ import net.minecraft.item.ItemArmor.ArmorMaterial;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class BlockPamSink
/*     */   extends Block
/*     */ {
/*     */   private IIcon[] top;
/*     */   private IIcon[] middle;
/*     */   private IIcon[] bottom;
/*     */   
/*     */   protected BlockPamSink()
/*     */   {
/*  32 */     super(Material.wood);
/*  33 */     setStepSound(Block.soundTypeWood);
/*  34 */     this.setCreativeTab(harvestcraft.tabHarvestCraft);
/*     */   }
/*     */   
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void registerBlockIcons(IIconRegister par1IconRegister)
/*     */   {
/*  41 */     this.top = new IIcon[4];
/*  42 */     this.middle = new IIcon[4];
/*  43 */     this.bottom = new IIcon[4];
/*  44 */     for (int i = 0; i < this.middle.length; i++)
/*     */     {
/*  46 */       this.middle[i] = par1IconRegister.registerIcon("harvestcraft:sinkside_" + i);
/*     */     }
/*     */     
/*     */ 
/*  50 */     for (int i = 0; i < this.top.length; i++)
/*     */     {
/*  52 */       this.top[i] = par1IconRegister.registerIcon("harvestcraft:sinktop_" + i);
/*     */     }
/*     */     
/*     */ 
/*  56 */     for (int i = 0; i < this.bottom.length; i++)
/*     */     {
/*  58 */       this.bottom[i] = par1IconRegister.registerIcon("harvestcraft:sinkbottom_" + i);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon getIcon(int par1, int par2)
/*     */   {
/*  70 */     switch (par1)
/*     */     {
/*     */     case 0: 
/*  73 */       return this.bottom[par2];
/*     */     case 1: 
/*  75 */       return this.top[par2];
/*     */     }
/*  77 */     return this.middle[par2];
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
/*     */   {
/*  84 */     if (par1World.isRemote)
/*     */     {
/*  86 */       return true;
/*     */     }
/*     */     
/*     */ 
/*  90 */     ItemStack itemstack = par5EntityPlayer.inventory.getCurrentItem();
/*     */     
/*  92 */     if (itemstack == null)
/*     */     {
/*  94 */       return true;
/*     */     }
/*     */     
/*     */ 
/*  98 */     if (itemstack.getItem() == Items.bucket)
/*     */     {
/* 100 */       ItemStack waterBucket = new ItemStack(Items.water_bucket, 1, 0);
/* 101 */       itemstack.stackSize -= 1;
/* 102 */       if (itemstack.stackSize <= 0)
/*     */       {
/* 104 */         par5EntityPlayer.inventory.setInventorySlotContents(par5EntityPlayer.inventory.currentItem, waterBucket);
/* 105 */       } else if (!par5EntityPlayer.inventory.addItemStackToInventory(waterBucket)) {
/* 106 */         par1World.spawnEntityInWorld(new EntityItem(par1World, par2 + 0.5D, par3 + 1.5D, par4 + 0.5D, waterBucket));
/*     */       }
/* 108 */       par5EntityPlayer.inventoryContainer.detectAndSendChanges();
/*     */     }
/* 110 */     else if (itemstack.getItem() == Items.glass_bottle)
/*     */     {
/* 112 */       ItemStack waterBottle = new ItemStack(Items.potionitem, 1, 0);
/* 113 */       itemstack.stackSize -= 1;
/* 114 */       if (itemstack.stackSize <= 0)
/*     */       {
/* 116 */         par5EntityPlayer.inventory.setInventorySlotContents(par5EntityPlayer.inventory.currentItem, waterBottle);
/* 117 */       } else if (!par5EntityPlayer.inventory.addItemStackToInventory(waterBottle)) {
/* 118 */         par1World.spawnEntityInWorld(new EntityItem(par1World, par2 + 0.5D, par3 + 1.5D, par4 + 0.5D, waterBottle));
/*     */       }
/* 120 */       par5EntityPlayer.inventoryContainer.detectAndSendChanges();
/*     */     }
/* 122 */     else if (((itemstack.getItem() instanceof ItemArmor)) && (((ItemArmor)itemstack.getItem()).getArmorMaterial() == ItemArmor.ArmorMaterial.CLOTH))
/*     */     {
/* 124 */       ItemArmor itemarmor = (ItemArmor)itemstack.getItem();
/* 125 */       itemarmor.removeColor(itemstack);
/* 126 */       return true;
/*     */     }
/* 128 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int damageDropped(int i)
/*     */   {
/* 138 */     return i;
/*     */   }
/*     */   
/*     */   public int quantityDropped(Random random)
/*     */   {
/* 143 */     return 1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List)
/*     */   {
/* 151 */     for (int i = 0; i < 4; i++)
/*     */     {
/* 153 */       par3List.add(new ItemStack(par1, 1, i));
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Modding\Desktop\Pam's HarvestCraft 1.7.10k.deobf.jar!\com\pam\harvestcraft\BlockPamSink.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */