/*    */ package com.pam.harvestcraft;
import cpw.mods.fml.common.eventhandler.Event;
/*    */ 
/*    */ import cpw.mods.fml.common.eventhandler.Event.Result;
/*    */ import cpw.mods.fml.common.eventhandler.SubscribeEvent;
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraftforge.event.entity.player.BonemealEvent;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PamHarvestBonemealEvent
/*    */ {
/*    */   public static Block[] PamSaplings;
/*    */   public static Block[] PamGardens;
/*    */   
/*    */   @SubscribeEvent
/*    */   public void onUseBonemeal(BonemealEvent event)
/*    */   {
/* 23 */     World world = event.world;
/*    */     
/* 25 */     int x = event.x;
/* 26 */     int y = event.y;
/* 27 */     int z = event.z;
/*    */     
/* 29 */     Block block = event.block;
/* 30 */     int meta = event.world.getBlockMetadata(x, y, z);
/*    */     
/* 32 */     Random rand = new Random();
/* 33 */     if ((!event.world.isRemote) && (!event.isCanceled()) && (event.getResult() != Event.Result.ALLOW))
/*    */     {
/*    */ 
/*    */ 
/* 37 */       if (((event.world.getBlock(x, y, z) instanceof BlockPamFruit)) && (!event.world.isRemote))
/*    */       {
/* 39 */         ((BlockPamFruit)event.block).fertilize(event.world, event.x, event.y, event.z);
/* 40 */         event.setResult(Event.Result.ALLOW);
/*    */       }
/*    */       
/* 43 */       if (((event.world.getBlock(x, y, z) instanceof BlockPamSapling)) && (!event.world.isRemote))
/*    */       {
/* 45 */         ((BlockPamSapling)event.block).markOrGrowMarked(event.world, event.x, event.y, event.z, event.world.rand);
/* 46 */         event.setResult(Event.Result.ALLOW);
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Modding\Desktop\Pam's HarvestCraft 1.7.10k.deobf.jar!\com\pam\harvestcraft\PamHarvestBonemealEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */