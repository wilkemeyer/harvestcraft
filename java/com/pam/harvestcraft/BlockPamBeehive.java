/*    */ package com.pam.harvestcraft;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.util.IIcon;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BlockPamBeehive
/*    */   extends Block
/*    */ {
/*    */   private IIcon top;
/*    */   private IIcon middle;
/*    */   private IIcon bottom;
/*    */   
/*    */   public BlockPamBeehive(Material par2Material)
/*    */   {
/* 24 */     super(par2Material);
/* 25 */     setStepSound(Block.soundTypeWood);
/* 26 */     this.setCreativeTab(harvestcraft.tabHarvestCraft);
/*    */   }
/*    */   
/*    */   public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
/*    */   {
/* 31 */     return ItemRegistry.queenbeeItem;
/*    */   }
/*    */   
/*    */ 
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void registerBlockIcons(IIconRegister par1IconRegister)
/*    */   {
/* 38 */     this.middle = par1IconRegister.registerIcon("harvestcraft:beehiveside");
/* 39 */     this.top = par1IconRegister.registerIcon("harvestcraft:beehivetop");
/* 40 */     this.bottom = par1IconRegister.registerIcon("harvestcraft:beehivebottom");
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   @SideOnly(Side.CLIENT)
/*    */   public IIcon getIcon(int par1, int par2)
/*    */   {
/* 50 */     switch (par1)
/*    */     {
/*    */     case 0: 
/* 53 */       return this.bottom;
/*    */     case 1: 
/* 55 */       return this.top;
/*    */     }
/* 57 */     return this.middle;
/*    */   }
/*    */ }


/* Location:              C:\Users\Modding\Desktop\Pam's HarvestCraft 1.7.10k.deobf.jar!\com\pam\harvestcraft\BlockPamBeehive.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */