package com.pam.harvestcraft;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;

public class PamOtherOreDictionaryRegistry 
{
	public static void getRegistry()
	{
		OreDictionary.registerOre("toolPot", ItemRegistry.potItem);
		OreDictionary.registerOre("toolSkillet", ItemRegistry.skilletItem);
		OreDictionary.registerOre("toolSaucepan", ItemRegistry.saucepanItem);
		OreDictionary.registerOre("toolBakeware", ItemRegistry.bakewareItem);
		OreDictionary.registerOre("toolCuttingboard", ItemRegistry.cuttingboardItem);
		OreDictionary.registerOre("toolMortarandpestle", ItemRegistry.mortarandpestleItem);
		OreDictionary.registerOre("toolMixingbowl", ItemRegistry.mixingbowlItem);
		OreDictionary.registerOre("toolJuicer", ItemRegistry.juicerItem);
		
		OreDictionary.registerOre("cropCotton", ItemRegistry.cottonItem);
		OreDictionary.registerOre("seedCotton", ItemRegistry.cottonseedItem);
		OreDictionary.registerOre("materialCloth", ItemRegistry.wovencottonItem);
		
		OreDictionary.registerOre("cropCandle", ItemRegistry.candleberryItem);
		OreDictionary.registerOre("seedCandleberry", ItemRegistry.candleberryseedItem);
		OreDictionary.registerOre("materialPressedwax", ItemRegistry.waxItem);
		OreDictionary.registerOre("materialHardenedleather", ItemRegistry.hardenedleatherItem);
		
		OreDictionary.registerOre("grainBait", ItemRegistry.grainbaitItem);
		OreDictionary.registerOre("veggieBait", ItemRegistry.veggiebaitItem);
		OreDictionary.registerOre("fruitBait", ItemRegistry.fruitbaitItem);
		OreDictionary.registerOre("fishtrapBait", ItemRegistry.fishtrapbaitItem);
		
		OreDictionary.registerOre("dustSalt", ItemRegistry.saltItem);
		OreDictionary.registerOre("itemSalt", ItemRegistry.saltItem);
		
		OreDictionary.registerOre("beeQueen", ItemRegistry.queenbeeItem);
		OreDictionary.registerOre("materialWaxcomb", ItemRegistry.waxcombItem);
		OreDictionary.registerOre("materialHoneycomb", ItemRegistry.honeycombItem);
		OreDictionary.registerOre("foodHoneydrop", ItemRegistry.honeyItem);
		OreDictionary.registerOre("dropHoney", ItemRegistry.honeyItem);
		OreDictionary.registerOre("materialPressedwax", ItemRegistry.beeswaxItem);
		OreDictionary.registerOre("grubBee", ItemRegistry.grubItem);
		
		OreDictionary.registerOre("flowerRed", Blocks.red_flower);
		OreDictionary.registerOre("flowerYellow", Blocks.yellow_flower);
		
		OreDictionary.registerOre("blockTorch", Blocks.torch);
		OreDictionary.registerOre("blockTorch", BlockRegistry.pamcandleDeco1);
		OreDictionary.registerOre("blockTorch", BlockRegistry.pamcandleDeco2);
		OreDictionary.registerOre("blockTorch", BlockRegistry.pamcandleDeco3);
		OreDictionary.registerOre("blockTorch", BlockRegistry.pamcandleDeco4);
		OreDictionary.registerOre("blockTorch", BlockRegistry.pamcandleDeco5);
		OreDictionary.registerOre("blockTorch", BlockRegistry.pamcandleDeco6);
		OreDictionary.registerOre("blockTorch", BlockRegistry.pamcandleDeco7);
		OreDictionary.registerOre("blockTorch", BlockRegistry.pamcandleDeco8);
		OreDictionary.registerOre("blockTorch", BlockRegistry.pamcandleDeco9);
		OreDictionary.registerOre("blockTorch", BlockRegistry.pamcandleDeco10);
		OreDictionary.registerOre("blockTorch", BlockRegistry.pamcandleDeco11);
		OreDictionary.registerOre("blockTorch", BlockRegistry.pamcandleDeco12);
		OreDictionary.registerOre("blockTorch", BlockRegistry.pamcandleDeco13);
		OreDictionary.registerOre("blockTorch", BlockRegistry.pamcandleDeco14);
		OreDictionary.registerOre("blockTorch", BlockRegistry.pamcandleDeco15);
		OreDictionary.registerOre("blockTorch", BlockRegistry.pamcandleDeco16);
		
	}
}
