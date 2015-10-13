/*    */ package com.pam.harvestcraft;
/*    */ 
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.BlockOre;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.world.IBlockAccess;
/*    */ 
/*    */ 
/*    */ public class BlockPamSalt
/*    */   extends BlockOre
/*    */ {
/*    */   public int quantityDropped(Random p_149745_1_)
/*    */   {
/* 15 */     if (this == BlockRegistry.pamSalt)
/*    */     {
/* 17 */       return this == BlockRegistry.pamSalt ? 1 + p_149745_1_.nextInt(3) : 1;
/*    */     }
/* 19 */     return 1;
/*    */   }
/*    */   
/*    */   public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
/*    */   {
/* 24 */     if (this == BlockRegistry.pamSalt)
/*    */     {
/* 26 */       return ItemRegistry.saltItem;
/*    */     }
/* 28 */     return Item.getItemFromBlock(BlockRegistry.pamcompressedsaltBlock);
/*    */   }
/*    */   
/*    */ 
/* 32 */   private Random rand = new Random();
/*    */   
/*    */   public int getExpDrop(IBlockAccess p_149690_1_, int p_149690_5_, int p_149690_7_)
/*    */   {
/* 36 */     if (this == BlockRegistry.pamSalt)
/*    */     {
/* 38 */       if (getItemDropped(p_149690_5_, this.rand, p_149690_7_) != Item.getItemFromBlock(this))
/*    */       {
/* 40 */         int j1 = 0;
/*    */         
/* 42 */         if (this == BlockRegistry.pamSalt)
/*    */         {
/* 44 */           j1 = MathHelper.getRandomIntegerInRange(this.rand, 0, 2);
/*    */         }
/*    */         
/* 47 */         return j1;
/*    */       }
/*    */       
/* 50 */       return 0;
/*    */     }
/* 52 */     return 0;
/*    */   }
/*    */ }


/* Location:              C:\Users\Modding\Desktop\Pam's HarvestCraft 1.7.10k.deobf.jar!\com\pam\harvestcraft\BlockPamSalt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */