/*    */ package com.pam.harvestcraft;
/*    */ 
/*    */ import cpw.mods.fml.client.FMLClientHandler;
/*    */ import cpw.mods.fml.common.event.FMLPreInitializationEvent;
/*    */ import cpw.mods.fml.common.eventhandler.EventBus;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class ClientProxy extends CommonProxy
/*    */ {
/*    */   public void registerRenderInformation(FMLPreInitializationEvent event)
/*    */   {
/* 12 */     TileEntityHandler.registerTileEntityRenderers();
/* 13 */     net.minecraftforge.common.MinecraftForge.EVENT_BUS.register(new EventHandler());
/*    */   }
/*    */   
/*    */   public World getClientWorld()
/*    */   {
/* 18 */     return FMLClientHandler.instance().getClient().theWorld;
/*    */   }
/*    */ }


/* Location:              C:\Users\Modding\Desktop\Pam's HarvestCraft 1.7.10k.deobf.jar!\com\pam\harvestcraft\ClientProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */