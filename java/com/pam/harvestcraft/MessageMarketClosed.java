/*    */ package com.pam.harvestcraft;
/*    */ 
/*    */ import cpw.mods.fml.common.network.simpleimpl.IMessage;
/*    */ import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
/*    */ import cpw.mods.fml.common.network.simpleimpl.MessageContext;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.player.EntityPlayerMP;
/*    */ import net.minecraft.network.NetHandlerPlayServer;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class MessageMarketClosed implements IMessage, IMessageHandler<MessageMarketClosed, IMessage>
/*    */ {
/*    */   private int x;
/*    */   private int y;
/*    */   private int z;
/*    */   
/*    */   public MessageMarketClosed() {}
/*    */   
/*    */   public MessageMarketClosed(int x, int y, int z)
/*    */   {
/* 23 */     this.x = x;
/* 24 */     this.y = y;
/* 25 */     this.z = z;
/*    */   }
/*    */   
/*    */ 
/*    */   public void fromBytes(ByteBuf buf)
/*    */   {
/* 31 */     this.x = buf.readInt();
/* 32 */     this.y = buf.readInt();
/* 33 */     this.z = buf.readInt();
/*    */   }
/*    */   
/*    */ 
/*    */   public void toBytes(ByteBuf buf)
/*    */   {
/* 39 */     buf.writeInt(this.x);
/* 40 */     buf.writeInt(this.y);
/* 41 */     buf.writeInt(this.z);
/*    */   }
/*    */   
/*    */ 
/*    */   public IMessage onMessage(MessageMarketClosed message, MessageContext ctx)
/*    */   {
/* 47 */     EntityPlayerMP player = ctx.getServerHandler().playerEntity;
/*    */     
/* 49 */     TileEntity tile_entity = player.worldObj.getTileEntity(message.x, message.y, message.z);
/* 50 */     if ((tile_entity instanceof TileEntityMarket))
/*    */     {
/* 52 */       TileEntityMarket tileEntityMarket = (TileEntityMarket)tile_entity;
/*    */       
/* 54 */       if (tileEntityMarket.getStackInSlot(0) != null)
/*    */       {
/* 56 */         player.entityDropItem(tileEntityMarket.getStackInSlot(0), 1.0F);
/* 57 */         tileEntityMarket.setInventorySlotContents(0, null);
/*    */       }
/* 59 */       tileEntityMarket.setTrading(false);
/*    */     }
/* 61 */     player.worldObj.markBlockForUpdate(message.x, message.y, message.z);
/* 62 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Modding\Desktop\Pam's HarvestCraft 1.7.10k.deobf.jar!\com\pam\harvestcraft\MessageMarketClosed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */