/*    */ package com.pam.harvestcraft;
/*    */ 
/*    */ import cpw.mods.fml.common.network.NetworkRegistry;
/*    */ import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ 
/*    */ 
/*    */ public class PacketHandler
/*    */ {
/* 10 */   public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel("harvestcraft");
/*    */   
/*    */   public static void init()
/*    */   {
/* 14 */     INSTANCE.registerMessage(MessageMarketBrowse.class, MessageMarketBrowse.class, 0, Side.SERVER);
/* 15 */     INSTANCE.registerMessage(MessageMarketBuy.class, MessageMarketBuy.class, 1, Side.SERVER);
/* 16 */     INSTANCE.registerMessage(MessageMarketClosed.class, MessageMarketClosed.class, 2, Side.SERVER);
/*    */   }
/*    */ }


/* Location:              C:\Users\Modding\Desktop\Pam's HarvestCraft 1.7.10k.deobf.jar!\com\pam\harvestcraft\PacketHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */