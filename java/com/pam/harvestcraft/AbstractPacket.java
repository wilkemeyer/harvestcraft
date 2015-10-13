package com.pam.harvestcraft;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;

public abstract class AbstractPacket
{
  public abstract void encodeInto(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf);
  
  public abstract void decodeInto(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf);
  
  public abstract void handleClientSide(EntityPlayer paramEntityPlayer);
  
  public abstract void handleServerSide(EntityPlayer paramEntityPlayer);
}


/* Location:              C:\Users\Modding\Desktop\Pam's HarvestCraft 1.7.10k.deobf.jar!\com\pam\harvestcraft\AbstractPacket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */