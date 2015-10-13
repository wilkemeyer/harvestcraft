/*    */ package com.pam.harvestcraft;
/*    */ 
/*    */ import cpw.mods.fml.common.eventhandler.SubscribeEvent;
/*    */ import net.minecraft.entity.passive.EntityOcelot;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraftforge.event.entity.player.EntityInteractEvent;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PamGreenHeartTaming
/*    */ {
/*    */   public static double rand;
/*    */   
/*    */   @SubscribeEvent
/*    */   public void entityInteractEvent(EntityInteractEvent event)
/*    */   {
/* 17 */     if ((event.entity instanceof EntityOcelot))
/*    */     {
/* 19 */       if (event.entityPlayer.getItemInUse() == null) {}
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Modding\Desktop\Pam's HarvestCraft 1.7.10k.deobf.jar!\com\pam\harvestcraft\PamGreenHeartTaming.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */