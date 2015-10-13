/*    */ package com.pam.harvestcraft;
/*    */ 
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.ItemEditableBook;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ import net.minecraft.nbt.NBTTagList;
/*    */ import net.minecraft.nbt.NBTTagString;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class ItemPamBook
/*    */   extends ItemEditableBook
/*    */ {
/*    */   public ItemPamBook()
/*    */   {
/* 17 */     setMaxStackSize(1);
/*    */   }
/*    */   
/*    */ 
/*    */   private NBTTagList putTableOfContents(NBTTagList bookTagList)
/*    */   {
/* 23 */     NBTTagCompound tag = new NBTTagCompound();
/* 24 */     NBTTagList bookPages = new NBTTagList();
/* 25 */     bookPages.appendTag(new NBTTagString("Page 1"));
/*    */     
/* 27 */     return bookTagList;
/*    */   }
/*    */   
/*    */   public void onUpdate(ItemStack itemStack, World world, Entity entity, int unknownInt, boolean unknownBool)
/*    */   {
/* 32 */     NBTTagList bookTagList = new NBTTagList();
/* 33 */     NBTTagCompound tag = new NBTTagCompound();
/* 34 */     bookTagList = putTableOfContents(bookTagList);
/*    */     
/* 36 */     itemStack.setTagInfo("pages", bookTagList);
/* 37 */     itemStack.setTagInfo("author", new NBTTagString("Pam"));
/* 38 */     itemStack.setTagInfo("title", new NBTTagString("HarvestCraft Cookbook"));
/* 39 */     itemStack = PamOtherRecipes.book;
/*    */   }
/*    */   
/*    */   public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
/*    */   {
/* 44 */     par3EntityPlayer.displayGUIBook(par1ItemStack);
/* 45 */     return par1ItemStack;
/*    */   }
/*    */ }


/* Location:              C:\Users\Modding\Desktop\Pam's HarvestCraft 1.7.10k.deobf.jar!\com\pam\harvestcraft\ItemPamBook.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */