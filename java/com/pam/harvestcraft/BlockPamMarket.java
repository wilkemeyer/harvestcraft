/*    */ package com.pam.harvestcraft;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.io.PrintStream;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.BlockContainer;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import net.minecraft.util.IIcon;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BlockPamMarket
/*    */   extends BlockContainer
/*    */ {
/*    */   private IIcon top;
/*    */   private IIcon middle;
/*    */   private IIcon bottom;
/*    */   
/*    */   public BlockPamMarket(Material par2Material)
/*    */   {
/* 28 */     super(par2Material);
/* 29 */     setStepSound(Block.soundTypeWood);
/* 30 */     this.setCreativeTab(harvestcraft.tabHarvestCraft);
/*    */   }
/*    */   
/*    */   public TileEntity createNewTileEntity(World world)
/*    */   {
/* 35 */     return new TileEntityMarket();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float xCoord, float yCoord, float zCoord)
/*    */   {
/* 42 */     TileEntity tile = world.getTileEntity(x, y, z);
/*    */     
/* 44 */     if ((tile == null) || (player.isSneaking()))
/*    */     {
/* 46 */       return false;
/*    */     }
/* 48 */     System.out.println("Trying to open");
/* 49 */     player.openGui(harvestcraft.instance, 4, world, x, y, z);
/*    */     
/* 51 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void registerBlockIcons(IIconRegister par1IconRegister)
/*    */   {
/* 58 */     this.middle = par1IconRegister.registerIcon("harvestcraft:marketside");
/* 59 */     this.top = par1IconRegister.registerIcon("harvestcraft:markettop");
/* 60 */     this.bottom = par1IconRegister.registerIcon("harvestcraft:marketbottom");
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   @SideOnly(Side.CLIENT)
/*    */   public IIcon getIcon(int par1, int par2)
/*    */   {
/* 70 */     switch (par1)
/*    */     {
/*    */     case 0: 
/* 73 */       return this.bottom;
/*    */     case 1: 
/* 75 */       return this.top;
/*    */     }
/* 77 */     return this.middle;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_)
/*    */   {
/* 84 */     return new TileEntityMarket();
/*    */   }
/*    */ }


/* Location:              C:\Users\Modding\Desktop\Pam's HarvestCraft 1.7.10k.deobf.jar!\com\pam\harvestcraft\BlockPamMarket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */