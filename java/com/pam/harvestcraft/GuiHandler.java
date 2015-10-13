/*    */ package com.pam.harvestcraft;
/*    */ 
/*    */ import cpw.mods.fml.common.network.IGuiHandler;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class GuiHandler
/*    */   implements IGuiHandler
/*    */ {
/*    */   public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
/*    */   {
/* 13 */     TileEntity tileEntity = world.getTileEntity(x, y, z);
/* 14 */     switch (ID) {
/*    */     case 0: 
/* 16 */       return new ContainerPamApiary(player.inventory, (TileEntityPamApiary)tileEntity);
/*    */     
/*    */     case 1: 
/* 19 */       return new ContainerPamPresser(player.inventory, (TileEntityPamPresser)tileEntity);
/*    */     
/*    */     case 2: 
/* 22 */       return new ContainerPamCuttingBoard(player.inventory, world, x, y, z);
/*    */     case 3: 
/* 24 */       return new ContainerPamPot(player.inventory, world, x, y, z);
/*    */     case 4: 
/* 26 */       return new ContainerMarket(player.inventory, (TileEntityMarket)tileEntity);
/*    */     
/*    */     case 5: 
/* 29 */       return new ContainerOven(player.inventory, (TileEntityOven)tileEntity);
/*    */     
/*    */     case 6: 
/* 32 */       return new ContainerChurn(player.inventory, (TileEntityChurn)tileEntity);
/*    */     
/*    */     case 7: 
/* 35 */       return new ContainerQuern(player.inventory, (TileEntityQuern)tileEntity);
/*    */     
/*    */     case 8: 
/* 38 */       return new ContainerPamAnimalTrap(player.inventory, (TileEntityPamAnimalTrap)tileEntity);
/*    */     
/*    */     case 9: 
/* 41 */       return new ContainerPamFishTrap(player.inventory, (TileEntityPamFishTrap)tileEntity);
/*    */     }
/*    */     
/* 44 */     return null;
/*    */   }
/*    */   
/*    */   public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
/*    */   {
/* 49 */     TileEntity tileEntity = world.getTileEntity(x, y, z);
/* 50 */     switch (ID) {
/*    */     case 0: 
/* 52 */       return new GuiPamApiary(player.inventory, (TileEntityPamApiary)tileEntity);
/*    */     
/*    */     case 1: 
/* 55 */       return new GuiPamPresser(player.inventory, (TileEntityPamPresser)tileEntity);
/*    */     
/*    */     case 2: 
/* 58 */       return new GuiPamCuttingBoard(player.inventory, world, x, y, z);
/*    */     case 3: 
/* 60 */       return new GuiPamPot(player.inventory, world, x, y, z);
/*    */     case 4: 
/* 62 */       return new GuiMarket(player.inventory, (TileEntityMarket)tileEntity);
/*    */     
/*    */     case 5: 
/* 65 */       return new GuiOven(player.inventory, (TileEntityOven)tileEntity);
/*    */     
/*    */     case 6: 
/* 68 */       return new GuiChurn(player.inventory, (TileEntityChurn)tileEntity);
/*    */     
/*    */     case 7: 
/* 71 */       return new GuiQuern(player.inventory, (TileEntityQuern)tileEntity);
/*    */     
/*    */     case 8: 
/* 74 */       return new GuiPamAnimalTrap(player.inventory, (TileEntityPamAnimalTrap)tileEntity);
/*    */     
/*    */     case 9: 
/* 77 */       return new GuiPamFishTrap(player.inventory, (TileEntityPamFishTrap)tileEntity);
/*    */     }
/*    */     
/* 80 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Modding\Desktop\Pam's HarvestCraft 1.7.10k.deobf.jar!\com\pam\harvestcraft\GuiHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */