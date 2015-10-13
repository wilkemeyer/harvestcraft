/*    */ package com.pam.harvestcraft;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.List;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ItemPamBee
/*    */   extends Item
/*    */ {
/*    */   public ItemPamBee()
/*    */   {
/* 19 */     this.maxStackSize = 1;
/* 20 */     setMaxDamage(18);
/* 21 */     isDamageable();
/* 22 */     setCreativeTab(harvestcraft.tabHarvestCraft);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List par3List)
/*    */   {
/* 32 */     par3List.add(new ItemStack(par1, 1, 0));
/* 33 */     par3List.add(new ItemStack(par1, 1, 18));
/*    */   }
/*    */ }


/* Location:              C:\Users\Modding\Desktop\Pam's HarvestCraft 1.7.10k.deobf.jar!\com\pam\harvestcraft\ItemPamBee.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */