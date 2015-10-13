/*    */ package com.pam.harvestcraft;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.BlockContainer;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import net.minecraft.util.IIcon;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class BlockPamPresser extends BlockContainer
/*    */ {
/*    */   private IIcon top;
/*    */   private IIcon front;
/*    */   private IIcon middle;
/*    */   private IIcon bottom;
/*    */   
/*    */   public BlockPamPresser()
/*    */   {
/* 25 */     super(Material.wood);
/* 26 */     setStepSound(Block.soundTypeWood);
/* 27 */     this.setCreativeTab(harvestcraft.tabHarvestCraft);
/*    */   }
/*    */   
/*    */   public TileEntity createNewTileEntity(World world) {
/* 31 */     return new TileEntityPamPresser();
/*    */   }
/*    */   
/*    */   public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
/*    */   {
/* 36 */     return Item.getItemFromBlock(BlockRegistry.pamPresser);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float xCoord, float yCoord, float zCoord)
/*    */   {
/* 43 */     TileEntity tile = world.getTileEntity(x, y, z);
/*    */     
/* 45 */     if ((tile == null) || (player.isSneaking()))
/*    */     {
/* 47 */       return false;
/*    */     }
/*    */     
/* 50 */     player.openGui(harvestcraft.instance, 1, world, x, y, z);
/*    */     
/* 52 */     return true;
/*    */   }
/*    */   
/* 55 */   public static void updateBlockState(boolean par0, World par1World, int par2, int par3, int par4) { int var5 = par1World.getBlockMetadata(par2, par3, par4);
/* 56 */     TileEntity var6TileEntity = par1World.getTileEntity(par2, par3, par4);
/* 57 */     if (var6TileEntity != null) {
/* 58 */       if (par0) {
/* 59 */         par1World.setBlock(par2, par3, par4, BlockRegistry.pamPresser);
/*    */       } else {
/* 61 */         par1World.setBlock(par2, par3, par4, BlockRegistry.pamPresser);
/*    */       }
/*    */       
/* 64 */       par1World.setBlockMetadataWithNotify(par2, par3, par4, var5, 2);
/* 65 */       var6TileEntity.validate();
/* 66 */       par1World.setTileEntity(par2, par3, par4, var6TileEntity);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void registerBlockIcons(IIconRegister par1IconRegister)
/*    */   {
/* 74 */     this.middle = par1IconRegister.registerIcon("harvestcraft:presserside");
/* 75 */     this.front = par1IconRegister.registerIcon("harvestcraft:presserfront");
/* 76 */     this.top = par1IconRegister.registerIcon("harvestcraft:pressertop");
/* 77 */     this.bottom = par1IconRegister.registerIcon("harvestcraft:sinkbottom_0");
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   @SideOnly(Side.CLIENT)
/*    */   public IIcon getIcon(int par1, int par2)
/*    */   {
/* 88 */     return par1 != par2 ? this.middle : par1 == 0 ? this.bottom : par1 == 1 ? this.top : this.front;
/*    */   }
/*    */   
/*    */ 
/*    */   public TileEntity createNewTileEntity(World var1, int var2)
/*    */   {
/* 94 */     return new TileEntityPamPresser();
/*    */   }
/*    */ }


/* Location:              C:\Users\Modding\Desktop\Pam's HarvestCraft 1.7.10k.deobf.jar!\com\pam\harvestcraft\BlockPamPresser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */