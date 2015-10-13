package thaumcraft.api.wands;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import thaumcraft.api.aspects.AspectList;

public abstract interface IWandFocus
{
  public abstract int getFocusColor();
  
  public abstract IIcon getFocusDepthLayerIcon();
  
  public abstract IIcon getOrnament();
  
  public abstract WandFocusAnimation getAnimation();
  
  public abstract AspectList getVisCost();
  
  public abstract boolean isVisCostPerTick();
  
  public abstract ItemStack onFocusRightClick(ItemStack paramItemStack, World paramWorld, EntityPlayer paramEntityPlayer, MovingObjectPosition paramMovingObjectPosition);
  
  public abstract void onUsingFocusTick(ItemStack paramItemStack, EntityPlayer paramEntityPlayer, int paramInt);
  
  public abstract void onPlayerStoppedUsingFocus(ItemStack paramItemStack, World paramWorld, EntityPlayer paramEntityPlayer, int paramInt);
  
  public abstract String getSortingHelper(ItemStack paramItemStack);
  
  public abstract boolean onFocusBlockStartBreak(ItemStack paramItemStack, int paramInt1, int paramInt2, int paramInt3, EntityPlayer paramEntityPlayer);
  
  public abstract boolean acceptsEnchant(int paramInt);
  
  public static enum WandFocusAnimation
  {
    WAVE,  CHARGE;
    
    private WandFocusAnimation() {}
  }
}


/* Location:              C:\Users\Modding\Desktop\Pam's HarvestCraft 1.7.10k.deobf.zip.jar!\thaumcraft\api\wands\IWandFocus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */