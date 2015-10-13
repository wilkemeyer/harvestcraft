/*    */ package com.pam.harvestcraft;
/*    */ 
/*    */ import cpw.mods.fml.common.event.FMLPreInitializationEvent;
/*    */ import cpw.mods.fml.common.eventhandler.EventBus;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class CommonProxy
/*    */ {
/*    */   public void registerHandlers(FMLPreInitializationEvent event)
/*    */   {
/* 11 */     net.minecraftforge.common.MinecraftForge.EVENT_BUS.register(new EventHandler());
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void registerRenderInformation(FMLPreInitializationEvent event) {}
/*    */   
/*    */ 
/*    */   public World getClientWorld()
/*    */   {
/* 21 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Modding\Desktop\Pam's HarvestCraft 1.7.10k.deobf.jar!\com\pam\harvestcraft\CommonProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */