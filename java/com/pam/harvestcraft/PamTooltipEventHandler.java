/*    */ package com.pam.harvestcraft;
/*    */ 
/*    */ import cpw.mods.fml.common.eventhandler.SubscribeEvent;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.StatCollector;
/*    */ import net.minecraftforge.event.entity.player.ItemTooltipEvent;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PamTooltipEventHandler
/*    */ {
/*    */   @SubscribeEvent
/*    */   public void onItemTooltip(ItemTooltipEvent event)
/*    */   {
/* 21 */     List<String> toolTipStringsToAdd = new ArrayList();
/* 22 */     if (event.itemStack != null)
/*    */     {
/* 24 */       String tooltip = localize("tooltip.harvestcraft." + event.itemStack.getUnlocalizedName());
/* 25 */       if (tooltip != null)
/*    */       {
/* 27 */         if (tooltip.contains("\\n"))
/*    */         {
/* 29 */           String[] tooltips = tooltip.split("\\\\n");
/* 30 */           int i = 0; for (int e = tooltips.length; i < e; i++) {
/* 31 */             toolTipStringsToAdd.add(tooltips[i]);
/*    */           }
/*    */         }
/*    */         else {
/* 35 */           toolTipStringsToAdd.add(tooltip);
/*    */         }
/*    */       }
/*    */     }
/* 39 */     event.toolTip.addAll(toolTipStringsToAdd);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static String localize(String s)
/*    */   {
/* 46 */     if (!StatCollector.canTranslate(s))
/* 47 */       return null;
/* 48 */     return StatCollector.translateToLocal(s);
/*    */   }
/*    */ }


/* Location:              C:\Users\Modding\Desktop\Pam's HarvestCraft 1.7.10k.deobf.jar!\com\pam\harvestcraft\PamTooltipEventHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */