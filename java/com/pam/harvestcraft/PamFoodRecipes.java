package com.pam.harvestcraft;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class PamFoodRecipes 

{
	public static String[] cropName = new String[]
			   {"cropAsparagus", "cropBarley", "cropBean", "cropBeet", "cropBroccoli", "cropCauliflower", "cropCelery", 
			   "cropCranberry", "cropGarlic", "cropGinger", "cropLeek", "cropLettuce", "cropOats", "cropOnion", "cropParsnip", "cropPeanut", 
			   "cropPineapple", "cropRadish", "cropRice", "cropRutabaga", "cropRye", "cropScallion", "cropSoybean", "cropSpiceleaf", 
			   "cropSweetpotato", "cropTea", "cropTurnip", "cropWhitemushroom", 
			   
			   "cropArtichoke", "cropBellpepper", "cropBlackberry", "cropBlueberry", "cropBrusselsprout", 
			   "cropCabbage", "cropCactusfruit", "cropCandleberry", "cropCantaloupe", "cropChilipepper", 
			   "cropCoffee", "cropCorn", "cropCotton", "cropCucumber", "cropEggplant", "cropGrape", "cropKiwi", 
			   "cropMustard", "cropOkra", "cropPeas", "cropRaspberry", "cropRhubarb", "cropSeaweed", "cropStrawberry", 
			   "cropTomato", "cropWintersquash", "cropZucchini", "cropBambooshoot", "cropSpinach"};
	
	
	
	
	
	
	@SuppressWarnings("unchecked")
	public static void getRecipes()
	{
		
		
		for(int i = 0; i < 8; ++i)
		{
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(BlockRegistry.PamTemperateSaplings[i], ItemRegistry.PamTemperateFruits[i], new ItemStack(Blocks.sapling, 1, 0)));
		}
		for(int i = 0; i < 24; ++i)
		{
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(BlockRegistry.PamWarmSaplings[i], ItemRegistry.PamWarmFruits[i], new ItemStack(Blocks.sapling, 1, 3)));
		}
		
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(BlockRegistry.pamcinnamonSapling, ItemRegistry.cinnamonItem, new ItemStack(Blocks.sapling, 1, 3)));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(BlockRegistry.pampaperbarkSapling, Items.paper, new ItemStack(Blocks.sapling, 1, 3)));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(BlockRegistry.pammapleSapling, ItemRegistry.maplesyrupItem, new ItemStack(Blocks.sapling, 1, 1)));
		
		if (ItemRegistry.enablecroptoseedRecipe)
		{
			for(int i = 0; i < 57; ++i)
			{
				if (!(BlockRegistry.enablecropspecialplanting && (ItemRegistry.PamCropItems[i] == ItemRegistry.cranberryItem
						|| ItemRegistry.PamCropItems[i] == ItemRegistry.riceItem
						|| ItemRegistry.PamCropItems[i] == ItemRegistry.seaweedItem)))
				{
					CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.PamSeeds[i], ItemRegistry.PamCropItems[i]));
				}
			}
		}
		for(int i = 0; i < 57; ++i)
		{
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(ItemRegistry.PamCropItems[i], 2), cropName[i], cropName[i]));
		}
		
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(ItemRegistry.sunflowerseedsItem, 2, 0), new ItemStack(Blocks.double_plant, 1, 0), new ItemStack(Blocks.double_plant, 1, 0)));
		
		if (ItemRegistry.enablesaltfromwaterbucketrecipe)
		{
			CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.saltItem, "toolPot", "listAllwater"));
		}
		
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.freshwaterItem, "listAllwater"));
		
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(Items.sugar, "toolPot", "foodHoneydrop"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(Items.sugar, "toolPot", "dropHoney"));
		
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(Items.fish, "listAllfishraw"));
		
		//Fresh Items
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(ItemRegistry.freshwaterItem, 1), Items.water_bucket));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(ItemRegistry.freshmilkItem, ItemRegistry.freshmilkfrombucket), Items.milk_bucket));
		
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(Items.cake, 1), new Object[] {
			"AAA", "BEB", "CCC", 'A', "listAllmilk", 'B', "honeyEqualssugar", 'C', "flourEqualswheat", 'E', "listAllegg"}));
		
		
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(Items.mushroom_stew, Items.bowl, "listAllmushroom", "listAllmushroom"));
		
		GameRegistry.addSmelting(ItemRegistry.doughItem, new ItemStack(Items.bread, 1, 0), 0.1F);
		GameRegistry.addSmelting(Items.bread, new ItemStack(ItemRegistry.toastItem, 1, 0), 0.1F);
		GameRegistry.addSmelting(Items.pumpkin_seeds, new ItemStack(ItemRegistry.roastedpumpkinseedsItem, 1, 0), 0.1F);
		GameRegistry.addSmelting(Blocks.brown_mushroom, new ItemStack(ItemRegistry.grilledmushroomItem, 1, 0), 0.1F);
		GameRegistry.addSmelting(Blocks.red_mushroom, new ItemStack(ItemRegistry.grilledmushroomItem, 1, 0), 0.1F);
		
		GameRegistry.addSmelting(ItemRegistry.muttonrawItem, new ItemStack(ItemRegistry.muttoncookedItem, 1, 0), 0.1F);
		GameRegistry.addSmelting(ItemRegistry.calamarirawItem, new ItemStack(ItemRegistry.calamaricookedItem, 1, 0), 0.1F);
	  
		GameRegistry.addSmelting(ItemRegistry.asparagusItem, new ItemStack(ItemRegistry.grilledasparagusItem, 1, 0), 0.1F);
		GameRegistry.addSmelting(ItemRegistry.riceItem, new ItemStack(ItemRegistry.ricecakeItem, 1, 0), 0.1F);
		GameRegistry.addSmelting(ItemRegistry.tealeafItem, new ItemStack(ItemRegistry.teaItem, 1, 0), 0.1F);
		GameRegistry.addSmelting(ItemRegistry.cornItem, new ItemStack(ItemRegistry.popcornItem, 1, 0), 0.1F);
		GameRegistry.addSmelting(ItemRegistry.sweetpotatoItem, new ItemStack(ItemRegistry.bakedsweetpotatoItem, 1, 0), 0.1F);
		GameRegistry.addSmelting(ItemRegistry.coffeebeanItem, new ItemStack(ItemRegistry.coffeeItem, 1, 0), 0.1F);
		GameRegistry.addSmelting(ItemRegistry.eggplantItem, new ItemStack(ItemRegistry.grilledeggplantItem, 1, 0), 0.1F);
		GameRegistry.addSmelting(ItemRegistry.grapeItem, new ItemStack(ItemRegistry.raisinsItem, 1, 0), 0.1F);
		GameRegistry.addSmelting(ItemRegistry.whitemushroomItem, new ItemStack(ItemRegistry.grilledmushroomItem, 1, 0), 0.1F);
		GameRegistry.addSmelting(ItemRegistry.coconutItem, new ItemStack(ItemRegistry.toastedcoconutItem, 1, 0), 0.1F);
		GameRegistry.addSmelting(ItemRegistry.vanillabeanItem, new ItemStack(ItemRegistry.vanillaItem, 1, 0), 0.1F);
		GameRegistry.addSmelting(ItemRegistry.chestnutItem, new ItemStack(ItemRegistry.roastedchestnutItem, 1, 0), 0.1F);
		
		GameRegistry.addSmelting(ItemRegistry.anchovyrawItem, new ItemStack(Items.cooked_fished, 1, 0), 0.1F);
    	GameRegistry.addSmelting(ItemRegistry.bassrawItem, new ItemStack(Items.cooked_fished, 1, 0), 0.1F);
    	GameRegistry.addSmelting(ItemRegistry.carprawItem, new ItemStack(Items.cooked_fished, 1, 0), 0.1F);
    	GameRegistry.addSmelting(ItemRegistry.catfishrawItem, new ItemStack(Items.cooked_fished, 1, 0), 0.1F);
    	GameRegistry.addSmelting(ItemRegistry.charrrawItem, new ItemStack(Items.cooked_fished, 1, 0), 0.1F);
    	GameRegistry.addSmelting(ItemRegistry.eelrawItem, new ItemStack(Items.cooked_fished, 1, 0), 0.1F);
    	GameRegistry.addSmelting(ItemRegistry.grouperrawItem, new ItemStack(Items.cooked_fished, 1, 0), 0.1F);
    	GameRegistry.addSmelting(ItemRegistry.herringrawItem, new ItemStack(Items.cooked_fished, 1, 0), 0.1F);
    	GameRegistry.addSmelting(ItemRegistry.mudfishrawItem, new ItemStack(Items.cooked_fished, 1, 0), 0.1F);
    	GameRegistry.addSmelting(ItemRegistry.perchrawItem, new ItemStack(Items.cooked_fished, 1, 0), 0.1F);
    	GameRegistry.addSmelting(ItemRegistry.snapperrawItem, new ItemStack(Items.cooked_fished, 1, 0), 0.1F);
    	GameRegistry.addSmelting(ItemRegistry.tilapiarawItem, new ItemStack(Items.cooked_fished, 1, 0), 0.1F);
    	GameRegistry.addSmelting(ItemRegistry.troutrawItem, new ItemStack(Items.cooked_fished, 1, 0), 0.1F);
    	GameRegistry.addSmelting(ItemRegistry.tunarawItem, new ItemStack(Items.cooked_fished, 1, 0), 0.1F);
    	GameRegistry.addSmelting(ItemRegistry.walleyerawItem, new ItemStack(Items.cooked_fished, 1, 0), 0.1F);
    	
    	
    	GameRegistry.addSmelting(ItemRegistry.clamrawItem, new ItemStack(ItemRegistry.clamcookedItem, 1, 0), 0.1F);
		GameRegistry.addSmelting(ItemRegistry.crabrawItem, new ItemStack(ItemRegistry.crabcookedItem, 1, 0), 0.1F);
		GameRegistry.addSmelting(ItemRegistry.crayfishrawItem, new ItemStack(ItemRegistry.crayfishcookedItem, 1, 0), 0.1F);
		GameRegistry.addSmelting(ItemRegistry.frograwItem, new ItemStack(ItemRegistry.frogcookedItem, 1, 0), 0.1F);
		GameRegistry.addSmelting(ItemRegistry.octopusrawItem, new ItemStack(ItemRegistry.octopuscookedItem, 1, 0), 0.1F);
		GameRegistry.addSmelting(ItemRegistry.scalloprawItem, new ItemStack(ItemRegistry.scallopcookedItem, 1, 0), 0.1F);
		GameRegistry.addSmelting(ItemRegistry.shrimprawItem, new ItemStack(ItemRegistry.shrimpcookedItem, 1, 0), 0.1F);
		GameRegistry.addSmelting(ItemRegistry.snailrawItem, new ItemStack(ItemRegistry.snailcookedItem, 1, 0), 0.1F);
		GameRegistry.addSmelting(ItemRegistry.turtlerawItem, new ItemStack(ItemRegistry.turtlecookedItem, 1, 0), 0.1F);
    	 
		
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.flourItem, "toolMortarandpestle", Items.wheat));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.flourItem, "toolMortarandpestle", "cropRice"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.flourItem, "toolMortarandpestle", Items.potato));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.flourItem, "toolMortarandpestle", "cropRye"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.flourItem, "toolMortarandpestle", "cropOats"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.flourItem, "toolMortarandpestle", "cropBarley"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.doughItem, "toolMixingbowl", "listAllwater", "foodFlour", "foodSalt"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.doughItem, "toolMixingbowl", "listAllwater", "foodFlour", "dustSalt"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.doughItem, "toolMixingbowl", "listAllwater", "foodFlour", "itemSalt"));
		
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.pastaItem, "toolMixingbowl", "foodDough", "foodButter"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.heavycreamItem, "toolMixingbowl", "listAllmilk"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.butterItem, "toolSaucepan", "listAllheavycream", "foodSalt"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.butterItem, "toolSaucepan", "listAllheavycream", "dustSalt"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.butterItem, "toolSaucepan", "listAllheavycream", "itemSalt"));

		
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.cheeseItem, "toolPot", "listAllmilk", "foodSalt"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.cheeseItem, "toolPot", "listAllmilk", "dustSalt"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.cheeseItem, "toolPot", "listAllmilk", "itemSalt"));


		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.icecreamItem, "toolMixingbowl", "listAllmilk", "foodSalt", Items.snowball));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.icecreamItem, "toolMixingbowl", "listAllmilk", "dustSalt", Items.snowball));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.icecreamItem, "toolMixingbowl", "listAllmilk", "itemSalt", Items.snowball));

		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.grilledcheeseItem, "toolSkillet", "foodToast", "foodButter", "foodCheese"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.applesauceItem, "toolPot", "cropApple"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.applejuiceItem, "toolJuicer", "cropApple"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.applepieItem, "toolBakeware", "cropApple", "listAllsugar", "foodDough"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.caramelappleItem, "cropApple", "foodCaramel", "stickWood"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.pumpkinbreadItem, "toolBakeware", Blocks.pumpkin, "listAllsugar", "foodDough"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.pumpkinsoupItem, "toolPot", Blocks.pumpkin, "listAllheavycream", "foodStock"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.melonjuiceItem, "toolJuicer", Items.melon));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.melonsmoothieItem, "toolJuicer", Items.melon, Items.snowball));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.carrotjuiceItem, "toolJuicer", Items.carrot));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.carrotcakeItem, "toolBakeware", Items.carrot, "listAllsugar", "foodDough"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.carrotsoupItem, "toolPot", Items.carrot, "listAllheavycream", "foodStock"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.glazedcarrotsItem, "toolSaucepan", Items.carrot, "foodButter", "listAllsugar"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.butteredpotatoItem, Items.baked_potato, "foodButter"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.loadedbakedpotatoItem, "foodButteredpotato", "listAllporkcooked", "foodCheese"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.mashedpotatoesItem, "toolMixingbowl", "foodButteredpotato", "foodSalt"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.mashedpotatoesItem, "toolMixingbowl", "foodButteredpotato", "dustSalt"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.mashedpotatoesItem, "toolMixingbowl", "foodButteredpotato", "itemSalt"));

		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.potatosaladItem, "toolCuttingboard", Items.baked_potato, "foodMayo"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.potatosoupItem, "toolPot", Items.potato, "foodSalt", "foodStock"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.potatosoupItem, "toolPot", Items.potato, "dustSalt", "foodStock"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.potatosoupItem, "toolPot", Items.potato, "itemSalt", "foodStock"));

		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.friesItem, "toolBakeware", Items.potato, "foodSalt"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.friesItem, "toolBakeware", Items.potato, "dustSalt"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.friesItem, "toolBakeware", Items.potato, "itemSalt"));

		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.stuffedmushroomItem, "toolBakeware", "listAllmushroom", "foodCheese", "foodToast"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.stuffedmushroomItem, "toolBakeware", "listAllmushroom", "foodCheese", "foodToast"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.stuffedmushroomItem, "toolBakeware", "listAllmushroom", "foodCheese", "foodToast"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.grilledmushroomItem, "toolSkillet", "listAllmushroom"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.chickensandwichItem, "toolSkillet", "listAllchickenraw", Items.bread, "foodMayo"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.chickennoodlesoupItem, "toolPot", "listAllchickenraw", Items.carrot, "foodPasta", "foodStock"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.chickenpotpieItem, "toolBakeware", "listAllchickenraw", Items.potato, Items.carrot, "foodDough"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.breadedporkchopItem, "toolSkillet", "listAllporkraw", "foodFlour"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.hotdogItem, "toolPot", "listAllporkraw", Items.bread));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.bakedhamItem, "toolBakeware", "listAllporkraw", "cropApple", "listAllsugar"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.hamburgerItem, "toolSkillet", "listAllbeefraw", "foodToast"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.cheeseburgerItem, "foodHamburger", "foodCheese"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.baconcheeseburgerItem, "foodCheeseburger", "listAllporkcooked"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.potroastItem, "toolPot", "listAllbeefraw", Items.potato, Items.carrot, "foodStock"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.fishsandwichItem, "toolSkillet", "listAllfishraw", "foodMayo", Items.bread));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.fishsticksItem, "toolBakeware", "listAllfishraw", "foodFlour"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.fishandchipsItem, "foodFishsticks", "foodFries"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.mayoItem, "toolJuicer", "listAllegg"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.friedeggItem, "toolSkillet", "listAllegg"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.scrambledeggItem, "toolSaucepan", "listAllegg"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.boiledeggItem, "toolPot", "listAllegg"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.eggsaladItem, "toolCuttingboard", "foodBoiledegg", "foodMayo"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.caramelItem, "toolSaucepan", "listAllsugar"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.taffyItem, "toolSaucepan", "listAllsugar", "listAllwater", "foodSalt"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.taffyItem, "toolSaucepan", "listAllsugar", "listAllwater", "dustSalt"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.taffyItem, "toolSaucepan", "listAllsugar", "listAllwater", "itemSalt"));

		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.spidereyesoupItem, "toolPot", Items.spider_eye, "foodStock"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.zombiejerkyItem, Items.rotten_flesh, "foodSalt", "foodSalt"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.zombiejerkyItem, Items.rotten_flesh, "dustSalt", "dustSalt"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.zombiejerkyItem, Items.rotten_flesh, "itemSalt", "itemSalt"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.zombiejerkyItem, Items.rotten_flesh, "itemSalt", "dustSalt"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.zombiejerkyItem, Items.rotten_flesh, "itemSalt", "foodSalt"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.zombiejerkyItem, Items.rotten_flesh, "foodSalt", "dustSalt"));

		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.cocoapowderItem, "toolMortarandpestle", new ItemStack(Items.dye, 1, 3)));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.chocolatebarItem, "toolSaucepan", "foodCocoapowder", "foodButter", "listAllmilk"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.hotchocolateItem, "toolJuicer", "foodCocoapowder", "listAllmilk"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.chocolateicecreamItem, "toolMixingbowl", "listAllicecream", "foodCocoapowder"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.vegetablesoupItem, "toolPot", Items.potato, Items.carrot, "listAllmushroom", "foodStock"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.vegetablesoupItem, "toolPot", Items.potato, Items.carrot, "listAllmushroom", "foodStock"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.vegetablesoupItem, "toolPot", Items.potato, Items.carrot, "listAllmushroom", "foodStock"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(ItemRegistry.stockItem, 3, 0), "toolPot", Items.bone));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(ItemRegistry.stockItem, 3, 0), "toolPot", "listAllmeatraw"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(ItemRegistry.stockItem, 3, 0), "toolPot", "listAllveggie"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.fruitsaladItem, "toolCuttingboard", "listAllfruit", "listAllfruit"));
		
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.spagettiItem, "toolSaucepan", "cropTomato", "foodPasta", "cropSpiceleaf"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.spagettiandmeatballsItem, "toolMixingbowl", "foodSpagetti", "listAllbeefcooked"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.tomatosoupItem, "toolPot", "cropTomato", "foodStock"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.ketchupItem, "toolJuicer", "cropTomato"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.chickenparmasanItem, "toolBakeware", "listAllchickencooked", "cropTomato", "foodCheese"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.pizzaItem, "toolBakeware", "foodDough", "cropTomato", "foodCheese", "listAllporkraw"));
		
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.springsaladItem, "toolCuttingboard", "cropLettuce", Items.carrot));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.springsaladItem, "toolCuttingboard", "cropLettuce", "cropOnion"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.springsaladItem, "toolCuttingboard", "cropLettuce", "cropRadish"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.springsaladItem, "toolCuttingboard", "cropLettuce", "cropCucumber"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.springsaladItem, "toolCuttingboard", "cropLettuce", "cropBellpepper"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.springsaladItem, "toolCuttingboard", "cropLettuce", "cropSpiceleaf"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.springsaladItem, "toolCuttingboard", "cropLettuce", "cropZucchini"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.springsaladItem, "toolCuttingboard", "cropLettuce", "cropASparagus"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.springsaladItem, "toolCuttingboard", "cropLettuce", "cropBroccoli"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.springsaladItem, "toolCuttingboard", "cropLettuce", "cropPeas"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.springsaladItem, "toolCuttingboard", "cropLettuce", "cropTomato"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.springsaladItem, "toolCuttingboard", "cropLettuce", "cropSunflower"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.springsaladItem, "toolCuttingboard", "cropLettuce", "cropWalnut"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.springsaladItem, "toolCuttingboard", "cropLettuce", "cropCauliflower"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.springsaladItem, "toolCuttingboard", "cropLettuce", "cropRhubarb"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.porklettucewrapItem, "toolCuttingboard", "cropLettuce", "listAllporkcooked"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.fishlettucewrapItem, "toolCuttingboard", "cropLettuce", "listAllfishcooked"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.bltItem, "toolCuttingboard", "cropLettuce", "cropTomato", "listAllporkcooked", "foodToast"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.leafychickensandwichItem, "foodChickensandwich", "cropLettuce"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.leafyfishsandwichItem, "foodFishsandwich", "cropLettuce"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.deluxecheeseburgerItem, "foodCheeseburger", "cropLettuce", "cropTomato"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.delightedmealItem, "foodDeluxecheeseburger", "foodFries", "listAllsmoothie"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.delightedmealItem, "foodDeluxecheeseburger", "foodZucchinifries", "listAllsmoothie"));
	 
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.onionsoupItem, "toolPot", "cropOnion", "foodStock", "foodGrilledcheese"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.potatocakesItem, "toolSkillet", "cropOnion", Items.potato, "foodButter"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.hashItem, "toolSkillet", "cropOnion", "listAllbeefcooked", Items.potato, "foodKetchup"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.braisedonionsItem, "toolSaucepan", "cropOnion", "foodButter", "foodStock"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.heartybreakfastItem, "listAllporkcooked", "foodFriedegg", "foodToast", "foodPotatocakes", "listAlljuice"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.heartybreakfastItem, "listAllporkcooked", "foodFriedegg", "foodToast", "foodPotatocakes", "foodChocolatemilk"));

		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.cornonthecobItem, "cropCorn", "foodButter"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.cornmealItem, "toolMortarandpestle", "cropCorn"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.cornbreadItem, "toolSkillet", "foodCornmeal", "listAllegg", "listAllmilk"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.tortillaItem, "toolSkillet", "foodCornmeal", "listAllwater"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.nachoesItem, "toolCuttingboard", "foodTortilla", "foodCheese"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.tacoItem, "toolCuttingboard", "listAllbeefcooked", "cropLettuce", "foodCheese", "foodTortilla"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.fishtacoItem, "toolCuttingboard", "listAllfishcooked", "cropLettuce", "foodCheese", "foodTortilla"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.creamedcornItem, "toolSaucepan", "cropCorn", "cropOnion", "foodHeavycream"));
		
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.strawberrysmoothieItem, "toolJuicer", "cropStrawberry", Items.snowball));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.strawberrypieItem, "toolBakeware", "cropStrawberry", "foodDough", "listAllsugar"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.strawberrysaladItem, "cropStrawberry", "foodFruitsalad"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.strawberryjuiceItem, "toolJuicer", "cropStrawberry"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.chocolatestrawberryItem, "toolSaucepan", "cropStrawberry", "foodChocolatebar"));
		
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.peanutbutterItem, "toolJuicer", "cropPeanut"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.trailmixItem, "listAllseed", "listAllseed", "listAllseed", "listAllseed", "listAllseed", "listAllseed", "foodRaisins", "foodChocolatebar"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.trailmixItem, "foodSaltedsunflowerseeds", "foodRaisins", "foodChocolatebar"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.trailmixItem, "listAllnut", "listAllnut", "foodRaisins", "foodChocolatebar"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.trailmixItem, "foodRoastedpumpkinseeds", "foodRaisins", "foodChocolatebar"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.pbandjItem, "toolCuttingboard", "foodPeanutbutter", "foodGrapejelly", Items.bread));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.peanutbuttercookiesItem, "toolBakeware", "foodPeanutbutter", "foodFlour", "listAllegg", "listAllsugar"));

		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.grapejuiceItem, "toolJuicer", "cropGrape"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.vinegarItem, "toolPot", "foodGrapejuice"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.grapejellyItem, "toolSaucepan", "cropGrape", "listAllsugar"));		
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.grapesaladItem, "cropGrape", "foodFruitsalad"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.raisincookiesItem, "toolBakeware", "foodFlour", "listAllegg", "listAllsugar", "foodRaisins"));
		
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.picklesItem, "toolPot", "cropCucumber", "foodSalt", "foodVinegar"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.picklesItem, "toolPot", "cropCucumber", "dustSalt", "foodVinegar"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.picklesItem, "toolPot", "cropCucumber", "itemSalt", "foodVinegar"));

		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.cucumbersaladItem, "toolCuttingboard", "cropCucumber", "foodSpringsalad"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.cucumbersoupItem, "toolPot", "cropCucumber", "foodStock", "listAllheavycream"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.vegetarianlettucewrapItem, "toolCuttingboard", "cropCucumber", "cropLettuce", "cropTomato"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.marinatedcucumbersItem, "toolPot", "cropCucumber", "cropOnion", "listAllsugar", "foodVinegar"));
		
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.ricesoupItem, "toolPot", "cropRice", "foodStock"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.friedriceItem, "toolSkillet", "cropRice", Items.carrot, "listAllegg", "cropOnion"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.mushroomrisottoItem, "toolBakeware", "cropRice", "listAllmushroom", "cropOnion", "foodCheese"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.curryItem, "toolSaucepan", "cropRice", "foodSalt", "cropChilipepper", "foodCoconutmilk", "cropSpiceleaf"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.curryItem, "toolSaucepan", "cropRice", "dustSalt", "cropChilipepper", "foodCoconutmilk", "cropSpiceleaf"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.curryItem, "toolSaucepan", "cropRice", "itemSalt", "cropChilipepper", "foodCoconutmilk", "cropSpiceleaf"));

		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.rainbowcurryItem, "toolSkillet", "cropRice", "flowerRed", "flowerYellow", "flowerOrange", "flowerGreen", "flowerPurple", "flowerBlue"));
		
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.refriedbeansItem, "toolSkillet", "cropBean", "cropOnion", "foodButter"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.bakedbeansItem, "toolPot", "cropBean", "listAllporkcooked", "listAllsugar"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.beansandriceItem, "toolPot", "cropBean", "cropRice", "cropOnion", "listAllporkcooked"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.beansandriceItem, "toolPot", "cropBean", "cropRice", "cropBellpepper", "listAllporkcooked"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.beansandriceItem, "toolPot", "cropBean", "cropRice", "cropChilipepper", "listAllporkcooked"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.chiliItem, "toolPot", "cropBean", "cropOnion", "listAllbeefcooked"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.chiliItem, "toolPot", "cropBean", "cropBellpepper", "listAllbeefcooked"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.chiliItem, "toolPot", "cropBean", "cropChilipepper", "listAllbeefcooked"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.beanburritoItem, "toolSkillet", "cropBean", "foodTortilla", "cropRice", "foodCheese"));
		
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.stuffedpepperItem, "toolBakeware", "cropBellpepper", "cropTomato", "cropRice"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.veggiestirfryItem, "toolSkillet", "cropBellpepper", Items.carrot, "cropRice", "cropOnion", "cropBean"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.veggiestirfryItem, "toolSkillet", "cropBellpepper", Items.carrot, "cropRice", "cropOnion", "cropChilipepper"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.veggiestirfryItem, "toolSkillet", "cropBellpepper", Items.carrot, "cropRice", "cropOnion", "listAllmushroom"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.veggiestirfryItem, "toolSkillet", "cropBellpepper", Items.carrot, "cropRice", "cropOnion", "listAllmushroom"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.veggiestirfryItem, "toolSkillet", "cropBellpepper", Items.carrot, "cropRice", "cropOnion", "listAllmushroom"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.grilledskewersItem, "toolCuttingboard", "cropBellpepper", "cropOnion", Items.carrot, "stickWood"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.supremepizzaItem, "toolCuttingboard", "foodPizza", "cropBellpepper", "cropOnion", "cropSpiceleaf"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.omeletItem, "toolSkillet", "listAllegg", "cropBellpepper", "cropOnion"));
	 
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.hotwingsItem, "toolSkillet", "cropChilipepper", "listAllchickencooked", "foodButter"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.chilipoppersItem, "toolBakeware", "cropChilipepper", "foodFlour", "foodCheese"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.extremechiliItem, "foodChili", "cropChilipepper"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.chilichocolateItem, "toolMixingbowl", "foodChocolatebar", "cropChilipepper"));
	 
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(ItemRegistry.lemonaideItem, 1), "toolJuicer", "cropLemon"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(ItemRegistry.lemonbarItem, 1), "toolBakeware", "cropLemon", "foodDough", "listAllsugar"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(ItemRegistry.fishdinnerItem, 1), "toolSkillet", "cropLemon", "foodFlour", "listAllfishraw", "foodMayo"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(ItemRegistry.lemonsmoothieItem, 1), "toolJuicer", "cropLemon", Items.snowball));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(ItemRegistry.lemonmeringueItem, 1), "toolBakeware", "cropLemon", "listAllsugar", "foodDough", "listAllheavycream"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(ItemRegistry.candiedlemonItem, 1), "toolBakeware", "cropLemon", "listAllsugar"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(ItemRegistry.lemonchickenItem, 1), "toolBakeware", "cropLemon", "listAllchickenraw", "foodButter"));
		
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.blueberrysmoothieItem, "toolJuicer", "cropBlueberry", Items.snowball));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.blueberrypieItem, "toolBakeware", "cropBlueberry", "foodDough", "listAllsugar"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.blueberrymuffinItem, "toolBakeware", "cropBlueberry", "foodFlour", "listAllegg"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.blueberryjuiceItem, "toolJuicer", "cropBlueberry"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.pancakesItem, "toolSkillet", "foodFlour", "listAllegg", "listAllmilk"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.blueberrypancakesItem, "cropBlueberry", "foodPancakes"));
		
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(ItemRegistry.cherryjuiceItem, 1), "toolJuicer", "cropCherry"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(ItemRegistry.cherrypieItem, 1), "toolBakeware", "cropCherry", "foodDough", "listAllsugar"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(ItemRegistry.chocolatecherryItem, 1), "toolSaucepan", "cropCherry", "foodChocolatebar"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(ItemRegistry.cherrysmoothieItem, 1), "toolJuicer", "cropCherry", Items.snowball));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(ItemRegistry.cheesecakeItem, 1), "toolBakeware", "foodFlour", "listAllheavycream", "listAllsugar", "listAllegg"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(ItemRegistry.cherrycheesecakeItem, 1), "cropCherry", "foodCheesecake"));
		
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.stuffedeggplantItem, "toolBakeware", "cropEggplant", "cropOnion", "cropBellpepper", "foodButter", "listAllegg"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.stuffedeggplantItem, "toolBakeware", "cropEggplant", "cropGarlic"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.eggplantparmItem, "toolBakeware", "cropEggplant", "cropTomato", "foodPasta", "foodCheese"));
		
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.raspberryicedteaItem, "cropTea", Items.snowball, "cropRaspberry"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.chaiteaItem, "cropTea", "foodGroundcinnamon", "foodBlackpepper"));
		
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.espressoItem, "cropCoffee", "cropCoffee", "cropCoffee", "listAllsugar"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.coffeeconlecheItem, "foodEspresso", "listAllmilk", "foodGroundcinnamon"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.mochaicecreamItem, "toolMixingbowl", "listAllicecream", "cropCoffee", "foodCocoapowder"));
		
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.pickledbeetsItem, "toolPot", "cropBeet", "foodVinegar", "foodSalt"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.pickledbeetsItem, "toolPot", "cropBeet", "foodVinegar", "dustSalt"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.pickledbeetsItem, "toolPot", "cropBeet", "foodVinegar", "itemSalt"));

		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.beetsaladItem, "toolMixingbowl", "cropBeet", "cropLettuce", "foodVinegar", "foodCheese"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.beetsoupItem, "toolPot", "cropBeet", "cropOnion", "foodBlackpepper", "listAllmilk"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.bakedbeetsItem, "toolBakeware", "cropBeet", "foodButter", "foodBlackpepper"));
		
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.broccolimacItem, "toolPot", "cropBroccoli", "foodPasta", "foodCheese"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.broccolindipItem, "toolMixingbowl", "cropBroccoli", "cropOnion", "listAllheavycream"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.creamedbroccolisoupItem, "toolPot", "cropBroccoli", Items.carrot, "foodFlour", "foodBlackpepper", "foodStock"));
		
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.sweetpotatopieItem, "toolBakeware", "cropSweetpotato", "foodDough", "foodGroundcinnamon", "foodMarshmellows"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.candiedsweetpotatoesItem, "toolSaucepan", "cropSweetpotato", "listAllsugar", "foodGroundcinnamon"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.mashedsweetpotatoesItem, "toolSaucepan", "cropSweetpotato", "foodButter"));
		
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.steamedpeasItem, "toolPot", "cropPeas", "listAllwater", "foodSalt"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.steamedpeasItem, "toolPot", "cropPeas", "listAllwater", "dustSalt"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.steamedpeasItem, "toolPot", "cropPeas", "listAllwater", "itemSalt"));

		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.splitpeasoupItem, "toolPot", "cropPeas", "listAllporkcooked", "foodBlackpepper", "foodStock"));
		
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.pineappleupsidedowncakeItem, "toolBakeware", "cropPineapple", "foodDough", "cropCherry", "cropWalnut"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.pineapplehamItem, "toolBakeware", "cropPineapple", "listAllporkraw", "cropCherry", "listAllsugar"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.pineappleyogurtItem, "cropPineapple", "foodPlainyogurt"));
		
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.turnipsoupItem, "toolPot", "cropTurnip", Blocks.pumpkin, "foodButter", "foodStock"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.roastedrootveggiemedleyItem, "toolBakeware", "cropTurnip", Items.carrot, "cropOnion", "cropSpiceleaf"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.roastedrootveggiemedleyItem, "toolBakeware", Blocks.pumpkin, Items.carrot, "cropOnion", "cropSpiceleaf"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.roastedrootveggiemedleyItem, "toolBakeware", Items.potato, Items.carrot, "cropOnion", "cropSpiceleaf"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.roastedrootveggiemedleyItem, "toolBakeware", "cropSweetpotato", Items.carrot, "cropOnion", "cropSpiceleaf"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.roastedrootveggiemedleyItem, "toolBakeware", "cropRadish", Items.carrot, "cropOnion", "cropSpiceleaf"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.roastedrootveggiemedleyItem, "toolBakeware", "cropParsnip", Items.carrot, "cropOnion", "cropSpiceleaf"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.bakedturnipsItem, "toolBakeware", "cropTurnip", "foodButter", "foodSalt", "foodBlackpepper"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.bakedturnipsItem, "toolBakeware", "cropTurnip", "foodButter", "dustSalt", "foodBlackpepper"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.bakedturnipsItem, "toolBakeware", "cropTurnip", "foodButter", "itemSalt", "foodBlackpepper"));

		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.gingerbreadItem, "toolBakeware", "cropGinger", "foodFlour", "foodButter", "listAllegg", "foodGroundcinnamon"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.gingersnapsItem, "toolBakeware", "cropGinger", "foodFlour", "listAllsugar"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.candiedgingerItem, "toolSaucepan", "cropGinger", "listAllsugar"));
		
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.mustardItem, "toolJuicer", "cropMustard"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.softpretzelandmustardItem, "foodSoftpretzel", "foodMustard"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.spicymustardporkItem, "toolSaucepan", "foodMustard", "listAllporkraw", "foodBlackpepper"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.spicymustardporkItem, "toolSaucepan", "foodMustard", "listAllporkraw", "cropGarlic"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.spicymustardporkItem, "toolSaucepan", "foodMustard", "listAllporkraw", "foodSalt"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.spicymustardporkItem, "toolSaucepan", "foodMustard", "listAllporkraw", "dustSalt"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.spicymustardporkItem, "toolSaucepan", "foodMustard", "listAllporkraw", "itemSalt"));

		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.spicygreensItem, "toolSaucepan", "foodMustard", "cropLettuce", "foodBlackpepper", "cropGarlic", "foodOliveoil", "cropOnion"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.spicygreensItem, "toolSaucepan", "foodMustard", "cropBroccoli", "foodBlackpepper", "cropGarlic", "foodOliveoil", "cropOnion"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.spicygreensItem, "toolSaucepan", "foodMustard", "cropPeas", "foodBlackpepper", "cropGarlic", "foodOliveoil", "cropOnion"));
		
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.garlicbreadItem, "cropGarlic", "foodToast", "foodButter"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.garlicmashedpotatoesItem, "foodMashedpotatoes", "cropGarlic"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.garlicchickenItem, "toolBakeware", "cropGarlic", "cropGarlic", "cropGarlic", "foodOliveoil", "listAllchickenraw"));
		
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.summerradishsaladItem, "toolMixingbowl", "cropRadish", "cropOnion", "cropCucumber", "foodVinegar"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.summersquashwithradishItem, "toolMixingbowl", "cropRadish", "cropZucchini", Blocks.pumpkin, "cropSpiceleaf", "foodOliveoil"));
		
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.celeryandpeanutbutterItem, "cropCelery", "foodPeanutbutter"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.chickencelerycasseroleItem, "toolBakeware", "cropCelery", "listAllchickenraw", "cropGarlic", Items.carrot, "listAllmushroom"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.chickencelerycasseroleItem, "toolBakeware", "cropCelery", "listAllchickenraw", "cropGarlic", Items.carrot, "listAllmushroom"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.chickencelerycasseroleItem, "toolBakeware", "cropCelery", "listAllchickenraw", "cropGarlic", Items.carrot, "listAllmushroom"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.peasandceleryItem, "toolMixingbowl", "cropCelery", "cropPeas", "cropLemon", "foodBlackpepper"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.celerysoupItem, "toolPot", "cropCelery", "cropOnion", Items.carrot, "foodStock"));
		
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.zucchinibreadItem, "toolBakeware", "cropZucchini", "foodDough", "foodGroundcinnamon", "cropWalnut"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.zucchinifriesItem, "toolBakeware", "cropZucchini", "foodToast", "foodCheese", "listAllegg"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.zestyzucchiniItem, "toolBakeware", "cropZucchini", "foodPasta", "cropChilipepper", "cropGarlic", "foodCheese"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.zucchinibakeItem, "toolBakeware", "cropZucchini", "cropTomato", "foodToast", "cropCorn", "foodCheese"));
		
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.asparagusquicheItem, "toolSkillet", "cropAsparagus", "listAllegg", "cropOnion", "foodCheese"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.asparagussoupItem, "toolPot", "cropAsparagus", "cropOnion", "foodButter", "foodStock"));
		
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.walnutraisinbreadItem, "toolBakeware", "cropWalnut", "foodRaisins", "foodDough", "foodGroundcinnamon"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.candiedwalnutsItem, "toolSaucepan", "cropWalnut", "foodVanilla", "foodGroundcinnamon", "listAllsugar"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.brownieItem, "toolBakeware", "cropWalnut", "foodFlour", "listAllegg", "foodButter", "listAllsugar", "foodCocoapowder", "foodVanilla"));
		
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.papayajuiceItem, "toolJuicer", "cropPapaya"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.papayasmoothieItem, "toolJuicer", "cropPapaya", Items.snowball));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.papayayogurtItem, "cropPapaya", "foodPlainyogurt"));
		
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.starfruitjuiceItem, "toolJuicer", "cropStarfruit"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.starfruitsmoothieItem, "toolJuicer", "cropStarfruit", Items.snowball));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.starfruityogurtItem, "cropStarfruit", "foodPlainyogurt"));
		
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.guacamoleItem, "toolCuttingboard", "cropAvocado", "cropChilipepper", "cropTomato", "cropOnion", "cropSpiceleaf"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.creamofavocadosoupItem, "toolPot", "cropAvocado", "listAllheavycream", "cropLime", "cropSpiceleaf", "foodStock"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.avocadoburritoItem, "toolCuttingboard", "cropAvocado", "foodTortilla", "foodCheese", "listAllchickencooked"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.avocadoburritoItem, "toolCuttingboard", "cropAvocado", "foodTortilla", "foodCheese", "listAllporkcooked"));
		
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.poachedpearItem, "toolSaucepan", "cropPear", "foodVanilla", "listAllsugar"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.fruitcrumbleItem, "toolBakeware", "listAllfruit", "foodGroundcinnamon", "foodFlour", "foodButter"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.pearyogurtItem, "cropPear", "foodPlainyogurt"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.plumyogurtItem, "cropPlum", "foodPlainyogurt"));
		
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.bananasplitItem, "toolMixingbowl", "cropBanana", "foodCocoapowder", "cropCherry", "listAllicecream", "cropStrawberry"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.banananutbreadItem, "toolBakeware", "cropBanana", "foodFlour", "cropWalnut", "listAllmilk", "foodSalt"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.banananutbreadItem, "toolBakeware", "cropBanana", "foodFlour", "cropWalnut", "listAllmilk", "dustSalt"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.banananutbreadItem, "toolBakeware", "cropBanana", "foodFlour", "cropWalnut", "listAllmilk", "itemSalt"));

		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.bananasmoothieItem, "toolJuicer", "cropBanana", Items.snowball));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.bananayogurtItem, "cropBanana", "foodPlainyogurt"));
		
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.coconutmilkItem, "toolJuicer", "cropCoconut"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.chickencurryItem, "toolPot", "cropCoconut", "foodPlainyogurt", "listAllchickenraw", "cropSpiceleaf", "cropChilipepper", "cropRice", "foodGroundcinnamon", "cropGarlic"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.coconutshrimpItem, "toolSkillet", "cropCoconut", "listAllegg", "foodFlour", "foodShrimpraw", "foodOliveoil"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.coconutshrimpItem, "toolSkillet", "cropCoconut", "listAllegg", "foodFlour", "foodRawshrimp", "foodOliveoil"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.coconutyogurtItem, "cropCoconut", "foodPlainyogurt"));
		
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.orangejuiceItem, "toolJuicer", "cropOrange"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.orangechickenItem, "toolSaucepan", "cropOrange", "listAllchickenraw", "listAllsugar", "cropRice", "cropBroccoli"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.orangesmoothieItem, "toolJuicer", "cropOrange", Items.snowball));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.orangeyogurtItem, "cropOrange", "foodPlainyogurt"));
		
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.peachjuiceItem, "toolJuicer", "cropPeach"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.peachcobblerItem, "toolBakeware", "cropPeach", "listAllsugar", "foodDough"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.peachsmoothieItem, "toolJuicer", "cropPeach", Items.snowball));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.peachyogurtItem, "cropPeach", "foodPlainyogurt"));
		
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.limejuiceItem, "toolJuicer", "cropLime"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.keylimepieItem, "toolBakeware", "cropLime", "listAllheavycream", "listAllsugar", "foodDough"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.limesmoothieItem, "toolJuicer", "cropLime", Items.snowball));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.limeyogurtItem, "cropLime", "foodPlainyogurt"));
		
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.mangojuiceItem, "toolJuicer", "cropMango"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.mangosmoothieItem, "toolJuicer", "cropMango", Items.snowball));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.mangoyogurtItem, "cropMango", "foodPlainyogurt"));
		
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.pomegranatejuiceItem, "toolJuicer", "cropPomegranate"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.pomegranatesmoothieItem, "toolJuicer", "cropPomegranate", Items.snowball));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.pomegranateyogurtItem, "cropPomegranate", "foodPlainyogurt"));
		
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.vanillayogurtItem, "foodVanilla", "foodPlainyogurt"));
		
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.cinnamonrollItem, "toolBakeware", "foodGroundcinnamon", "listAllsugar", "foodDough"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.frenchtoastItem, "toolSkillet", "foodGroundcinnamon", "foodToast", "listAllsugar", "listAllegg"));
		
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.marshmellowsItem, "toolPot", "listAllsugar", "listAllwater", "listAllegg"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.donutItem, "toolPot", "foodDough", "foodOliveoil"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.chocolatedonutItem, "foodDonut", "foodChocolatebar"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.powdereddonutItem, "foodDonut", "listAllsugar"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.jellydonutItem, "foodDonut", "foodGrapejelly"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.frosteddonutItem, "foodDonut", "listAllsugar", new ItemStack(Items.dye, 1, 1), new ItemStack(Items.dye, 1, 2), new ItemStack(Items.dye, 1, 11)));
		
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.cactussoupItem, "toolPot", Blocks.cactus, "foodStock"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.wafflesItem, "toolSkillet", "foodFlour", "listAllegg", "listAllmilk", "foodButter"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.seedsoupItem, "toolPot", "listAllseed", "foodStock"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.softpretzelItem, "toolBakeware", "foodDough", "foodButter", "foodSalt"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.softpretzelItem, "toolBakeware", "foodDough", "foodButter", "dustSalt"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.softpretzelItem, "toolBakeware", "foodDough", "foodButter", "itemSalt"));

		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.jellybeansItem, "toolSaucepan", "listAllsugar", new ItemStack(Items.dye, 1, 1), new ItemStack(Items.dye, 1, 11)));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.biscuitItem, "toolBakeware", "foodDough", "foodButter"));
		
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.creamcookieItem, "toolBakeware", "foodDough", "listAllheavycream", "listAllsugar", "foodCocoapowder"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.jaffaItem, "toolBakeware", "listAllegg", "listAllsugar", "foodFlour", "foodChocolatebar", "cropOrange"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.friedchickenItem, "toolPot", "listAllchickenraw", "foodFlour", "cropSpiceleaf", "foodBlackpepper", "foodOliveoil"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.chocolatesprinklecakeItem, "toolBakeware", "foodCocoapowder", "listAllsugar", "foodDough", new ItemStack(Items.dye, 1, 1), new ItemStack(Items.dye, 1, 2), new ItemStack(Items.dye, 1, 11)));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.redvelvetcakeItem, "toolBakeware", "listAllmilk", "foodFlour", "listAllheavycream", "listAllsugar", "listAllegg", new ItemStack(Items.dye, 1, 1), new ItemStack(Items.dye, 1, 1)));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.footlongItem, "toolCuttingboard", Items.bread, "listAllbeefcooked", "cropLettuce", "cropTomato", "foodMayo"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.footlongItem, "toolCuttingboard", Items.bread, "listAllchickencooked", "cropLettuce", "cropTomato", "foodMayo"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.footlongItem, "toolCuttingboard", Items.bread, "listAllporkcooked", "cropLettuce", "cropTomato", "foodMayo"));
		
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.blueberryyogurtItem, "cropBlueberry", "foodPlainyogurt"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.lemonyogurtItem, "cropLemon", "foodPlainyogurt"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.cherryyogurtItem, "cropCherry", "foodPlainyogurt"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.strawberryyogurtItem, "cropStrawberry", "foodPlainyogurt"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.grapeyogurtItem, "cropGrape", "foodPlainyogurt"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.chocolateyogurtItem, "foodCocoapowder", "foodPlainyogurt"));
		
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.blackberryjuiceItem, "toolJuicer", "cropBlackberry"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.blackberrycobblerItem, "cropBlackberry", "toolBakeware", "listAllsugar", "foodDough"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.blackberrysmoothieItem, "toolJuicer", "cropBlackberry", Items.snowball));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.blackberryyogurtItem, "cropBlackberry", "foodPlainyogurt"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.chocolatemilkItem, "listAllmilk", "foodCocoapowder"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.pumpkinyogurtItem, Blocks.pumpkin, "foodPlainyogurt"));
		
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.raspberryjuiceItem, "toolJuicer", "cropRaspberry"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.raspberrypieItem, "cropRaspberry", "toolBakeware", "listAllsugar", "foodDough"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.raspberrysmoothieItem, "toolJuicer", "cropRaspberry", Items.snowball));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.raspberryyogurtItem, "cropRaspberry", "foodPlainyogurt"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.cinnamonsugardonutItem, "foodDonut", "listAllsugar", "foodGroundcinnamon"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.melonyogurtItem, Items.melon, "foodPlainyogurt"));
		
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.kiwijuiceItem, "toolJuicer", "cropKiwi"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.kiwismoothieItem, "toolJuicer", "cropKiwi", Items.snowball));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.kiwiyogurtItem, "cropKiwi", "foodPlainyogurt"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(ItemRegistry.plainyogurtItem, 4, 0), "listAllmilk", Items.leather));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.appleyogurtItem, "cropApple", "foodPlainyogurt"));
		
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.saltedsunflowerseedsItem, "cropSunflower", "foodSalt"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.saltedsunflowerseedsItem, "cropSunflower", "dustSalt"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.saltedsunflowerseedsItem, "cropSunflower", "itemSalt"));

		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.sunflowerwheatrollsItem, "toolBakeware", "cropSunflower", "foodFlour", "listAllegg", "foodSalt", "foodOliveoil"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.sunflowerwheatrollsItem, "toolBakeware", "cropSunflower", "foodFlour", "listAllegg", "dustSalt", "foodOliveoil"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.sunflowerwheatrollsItem, "toolBakeware", "cropSunflower", "foodFlour", "listAllegg", "itemSalt", "foodOliveoil"));

		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.sunflowerbroccolisaladItem, "toolCuttingboard", "cropSunflower", "cropBroccoli", "foodMayo", "listAllsugar", "listAllporkcooked"));
		
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.cranberryjuiceItem, "toolJuicer", "cropCranberry", "listAllsugar"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.cranberrysauceItem, "toolPot", "cropCranberry", "listAllsugar"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.cranberrybarItem, "toolBakeware", "cropCranberry", "listAllsugar", "foodDough"));
		
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.peppermintItem, "toolSaucepan", "cropSpiceleaf", "listAllsugar"));
		
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.cactusfruitjuiceItem, "toolJuicer", "cropCactusfruit"));
		
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.blackpepperItem, "toolMortarandpestle", "cropPeppercorn"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.groundcinnamonItem, "toolMortarandpestle", "cropCinnamon"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.groundnutmegItem, "toolMortarandpestle", "cropNutmeg"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.oliveoilItem, "toolJuicer", "cropOlive"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.oliveoilItem, "toolJuicer", "cropSunflower"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.oliveoilItem, "toolJuicer", "cropWalnut"));
		
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.baklavaItem, "toolBakeware", "foodDough", "cropWalnut", "cropCinnamon", "foodButter", "listAllsugar"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.gummybearsItem, "toolSaucepan", "listAllsugar", new ItemStack(Items.dye, 1, 1), new ItemStack(Items.dye, 1, 2)));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.baconmushroomburgerItem, "foodBaconcheeseburger", "listAllmushroom"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.baconmushroomburgerItem, "foodBaconcheeseburger", "cropWhitemushroom"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.fruitpunchItem, "toolJuicer", "listAllfruit", "listAllsugar"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.meatystewItem, "toolPot", "listAllmeatraw", "foodFlour", "foodStock"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.mixedsaladItem, "toolCuttingboard", "listAllveggie", "listAllveggie", "foodSaladdressing"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.pinacoladaItem, "toolJuicer", "cropCoconut", "cropPineapple"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.saladdressingItem, "toolJuicer", "foodOliveoil", "foodSalt", "foodVinegar"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.saladdressingItem, "toolJuicer", "foodOliveoil", "dustSalt", "foodVinegar"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.saladdressingItem, "toolJuicer", "foodOliveoil", "itemSalt", "foodVinegar"));

		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.saladdressingItem, "toolJuicer", "foodMayo", "cropSpiceleaf", "cropSpiceleaf"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.shepardspieItem, "toolBakeware", "listAllmeatraw", Items.potato, Items.carrot, "foodDough", "cropPeas"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.eggnogItem, "toolJuicer", "listAllegg", "foodGroundnutmeg", "cropCinnamon", "listAllheavycream"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.custardItem, "toolSaucepan", "listAllegg", "foodGroundnutmeg", "cropCinnamon", "listAllheavycream"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.sushiItem, "toolCuttingboard", "listAllfishraw", "cropSeaweed", "cropRice"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.gardensoupItem, "toolPot", "foodStock", "listAllveggie", "listAllveggie"));
		
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.applejellyItem, "toolSaucepan", "cropApple", "listAllsugar"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.blackberryjellyItem, "toolSaucepan", "cropBlackberry", "listAllsugar"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.blueberryjellyItem, "toolSaucepan", "cropBlueberry", "listAllsugar"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.cherryjellyItem, "toolSaucepan", "cropCherry", "listAllsugar"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.cranberryjellyItem, "toolSaucepan", "cropCranberry", "listAllsugar"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.kiwijellyItem, "toolSaucepan", "cropKiwi", "listAllsugar"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.lemonjellyItem, "toolSaucepan", "cropLemon", "listAllsugar"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.limejellyItem, "toolSaucepan", "cropLime", "listAllsugar"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.mangojellyItem, "toolSaucepan", "cropMango", "listAllsugar"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.orangejellyItem, "toolSaucepan", "cropOrange", "listAllsugar"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.papayajellyItem, "toolSaucepan", "cropPapaya", "listAllsugar"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.peachjellyItem, "toolSaucepan", "cropPeach", "listAllsugar"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.pomegranatejellyItem, "toolSaucepan", "cropPomegranate", "listAllsugar"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.raspberryjellyItem, "toolSaucepan", "cropRaspberry", "listAllsugar"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.starfruitjellyItem, "toolSaucepan", "cropStarfruit", "listAllsugar"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.strawberryjellyItem, "toolSaucepan", "cropStrawberry", "listAllsugar"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.watermelonjellyItem, "toolSaucepan", Items.melon, Items.melon, "listAllsugar"));
	
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.applejellysandwichItem, "toolCuttingboard", "foodPeanutbutter", "foodApplejelly", Items.bread));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.blackberryjellysandwichItem, "toolCuttingboard", "foodPeanutbutter", "foodBlackberryjelly", Items.bread));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.blueberryjellysandwichItem, "toolCuttingboard", "foodPeanutbutter", "foodBlueberryjelly", Items.bread));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.cherryjellysandwichItem, "toolCuttingboard", "foodPeanutbutter", "foodCherryjelly", Items.bread));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.cranberryjellysandwichItem, "toolCuttingboard", "foodPeanutbutter", "foodCranberryjelly", Items.bread));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.kiwijellysandwichItem, "toolCuttingboard", "foodPeanutbutter", "foodKiwijelly", Items.bread));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.lemonjellysandwichItem, "toolCuttingboard", "foodPeanutbutter", "foodLemonjelly", Items.bread));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.limejellysandwichItem, "toolCuttingboard", "foodPeanutbutter", "foodLimejelly", Items.bread));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.mangojellysandwichItem, "toolCuttingboard", "foodPeanutbutter", "foodMangojelly", Items.bread));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.orangejellysandwichItem, "toolCuttingboard", "foodPeanutbutter", "foodOrangejelly", Items.bread));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.papayajellysandwichItem, "toolCuttingboard", "foodPeanutbutter", "foodPapayajelly", Items.bread));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.peachjellysandwichItem, "toolCuttingboard", "foodPeanutbutter", "foodPeachjelly", Items.bread));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.pomegranatejellysandwichItem, "toolCuttingboard", "foodPeanutbutter", "foodPomegranatejelly", Items.bread));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.raspberryjellysandwichItem, "toolCuttingboard", "foodPeanutbutter", "foodRaspberryjelly", Items.bread));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.starfruitjellysandwichItem, "toolCuttingboard", "foodPeanutbutter", "foodStarfruitjelly", Items.bread));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.strawberryjellysandwichItem, "toolCuttingboard", "foodPeanutbutter", "foodStrawberryjelly", Items.bread));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.watermelonjellysandwichItem, "toolCuttingboard", "foodPeanutbutter", "foodWatermelonjelly", Items.bread));
	
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.cherrysodaItem, "toolPot", "foodBubblywater", "listAllsugar", "foodCherryjuice"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.colasodaItem, "toolPot", "foodBubblywater", "listAllsugar", "cropSpiceleaf"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.gingersodaItem, "toolPot", "foodBubblywater", "listAllsugar", "cropGinger"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.grapesodaItem, "toolPot", "foodBubblywater", "listAllsugar", "foodGrapejuice"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.lemonlimesodaItem, "toolPot", "foodBubblywater", "listAllsugar", "cropLemon", "foodLimejuice"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.orangesodaItem, "toolPot", "foodBubblywater", "listAllsugar", "foodOrangejuice"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.rootbeersodaItem, "toolPot", "foodBubblywater", "listAllsugar", "cropEdibleroot"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.strawberrysodaItem, "toolPot", "foodBubblywater", "listAllsugar", "foodStrawberryjuice"));
		
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.caramelicecreamItem, "toolMixingbowl", "listAllicecream", "foodCaramel"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.mintchocolatechipicemcreamItem, "toolMixingbowl", "listAllicecream", "cropSpiceleaf", "foodChocolatebar"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.strawberryicecreamItem, "toolMixingbowl", "listAllicecream", "cropStrawberry"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.vanillaicecreamItem, "toolMixingbowl", "listAllicecream", "foodVanilla"));
		
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.ediblerootItem, "toolCuttingboard", "cropSpiceleaf"));
	
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.gingerchickenItem, "toolSaucepan", "listAllchickenraw", "cropGinger", "cropScallion", "foodHoneydrop"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.gingerchickenItem, "toolSaucepan", "listAllchickenraw", "cropGinger", "cropScallion", "dropHoney"));
		
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.oldworldveggiesoupItem, "toolPot", "foodStock", "cropOnion", "cropPeas", "cropBarley"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.spicebunItem, "toolBakeware", "foodFlour", "listAllmilk", "foodGroundnutmeg", "foodGroundcinnamon", "foodRaisins"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.gingeredrhubarbtartItem, "toolBakeware", "foodDough", "cropRhubarb", "cropGinger", "listAllsugar", "listAllegg"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.lambbarleysoupItem, "toolPot", "foodStock", "listAllmuttonraw", "cropOnion", Items.carrot, "cropBarley"));		
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.honeylemonlambItem, "toolBakeware", "listAllmuttonraw", "cropLemon", "foodMustard", "foodHoneydrop"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.honeylemonlambItem, "toolBakeware", "listAllmuttonraw", "cropLemon", "foodMustard", "dropHoney"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.pumpkinoatsconesItem, "toolBakeware", "foodFlour", "cropOats", Blocks.pumpkin, "foodButter"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.beefjerkyItem, "listAllbeefraw", "foodSalt"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.beefjerkyItem, "listAllbeefraw", "dustSalt"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.beefjerkyItem, "listAllbeefraw", "itemSalt"));

		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.plumjuiceItem, "toolJuicer", "cropPlum"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.pearjuiceItem, "toolJuicer", "cropPear"));
		
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.ovenroastedcauliflowerItem, "toolBakeware", "cropCauliflower", "foodOliveoil", "cropGarlic", "cropLemon"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.leekbaconsoupItem, "toolPot", "cropLeek", "listAllporkcooked", Items.potato, "listAllheavycream"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.herbbutterparsnipsItem, "toolSaucepan", "cropParsnip", "foodButter", "cropSpiceleaf"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.scallionbakedpotatoItem, Items.baked_potato, "cropScallion", "listAllheavycream"));
	
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.bamboosteamedriceItem, "toolPot", "cropRice", "cropBambooshoot"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.sweetpotatosouffleItem, "toolBakeware", "cropSweetpotato", "cropPecan", "foodDough", "foodButter"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.cashewchickenItem, "toolSaucepan", "listAllchickenraw", "cropCashew", "cropRice", "listAllpepper"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.apricotjuiceItem, "toolJuicer", "cropApricot"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.apricotyogurtItem, "cropApricot", "foodPlainyogurt"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.apricotglazedporkItem, "listAllporkcooked", "foodApricotjelly" ));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.apricotjellyItem, "toolSaucepan", "cropApricot", "listAllsugar"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.apricotjellysandwichItem, "toolCuttingboard", "foodPeanutbutter", "foodApricotjelly", Items.bread));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.apricotsmoothieItem, "toolJuicer", "cropApricot", Items.snowball));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.figbarItem, "toolBakeware", "cropFig", "listAllsugar", "foodDough"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.figjellyItem, "toolSaucepan", "cropFig", "listAllsugar"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.figjellysandwichItem, "toolCuttingboard", "foodPeanutbutter", "foodFigjelly", Items.bread));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.figsmoothieItem, "toolJuicer", "cropFig", Items.snowball));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.figyogurtItem, "cropFig", "foodPlainyogurt"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.figjuiceItem, "toolJuicer", "cropFig"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.grapefruitjuiceItem, "toolJuicer", "cropGrapefruit"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.grapefruitjellyItem, "toolSaucepan", "cropGrapefruit", "listAllsugar"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.grapefruitjellysandwichItem, "toolCuttingboard", "foodPeanutbutter", "foodGrapefruitjelly", Items.bread));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.grapefruitsmoothieItem, "toolJuicer", "cropGrapefruit", Items.snowball));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.grapefruityogurtItem, "cropGrapefruit", "foodPlainyogurt"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.grapefruitsodaItem, "toolPot", "foodBubblywater", "listAllsugar", "foodGrapefruitjuice"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.citrussaladItem, "toolCuttingboard", "listAllcitrus", "cropLettuce"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.pecanpieItem, "toolBakeware", "cropPecan", "foodDough", "listAllsugar", "foodButter"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.pralinesItem, "toolSaucepan", "cropPecan", "listAllsugar"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.persimmonjuiceItem, "toolJuicer", "cropPersimmon"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.persimmonyogurtItem, "cropPersimmon", "foodPlainyogurt"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.persimmonsmoothieItem, "toolJuicer", "cropPersimmon", Items.snowball));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.persimmonjellyItem, "toolSaucepan", "cropPersimmon", "listAllsugar"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.persimmonjellysandwichItem, "toolCuttingboard", "foodPeanutbutter", "foodPersimmonjelly", Items.bread));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.pistachiobakedsalmonItem, "toolBakeware", "cropPistachio", "salmonRaw"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.baconwrappeddatesItem, "toolBakeware", "cropDate", "listAllporkcooked"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.datenutbreadItem, "toolBakeware", "cropDate", "foodDough", "listAllnut"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.maplesyruppancakesItem, "foodPancakes", "cropMaplesyrup"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.maplesyrupwafflesItem, "foodWaffles", "cropMaplesyrup"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.maplesausageItem, "listAllbeefraw", "cropSpiceleaf", "cropMaplesyrup"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.mapleoatmealItem, "toolMixingbowl", "cropOats", "cropMaplesyrup"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.peachesandcreamoatmealItem, "toolMixingbowl", "cropOats", "cropPeach", "listAllheavycream"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.cinnamonappleoatmealItem, "toolMixingbowl", "cropOats", "foodGroundcinnamon", "cropApple")); 
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.maplecandiedbaconItem, "toolBakeware", "listAllporkcooked", "cropMaplesyrup"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.toastsandwichItem, "foodToast", "foodToast"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.potatoandcheesepirogiItem, "toolSkillet", "foodDough", "cropPotato", "foodCheese"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.zeppoleItem, "toolPot", "foodOliveoil", "foodDough", "foodGroundcinnamon"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.sausageinbreadItem, "foodMaplesausage", Items.bread, "foodKetchup", "cropOnion"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.chocolatecaramelfudgeItem, "toolBakeware", "foodChocolatebar", "foodCaramel"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.lavendershortbreadItem, "toolBakeware", "dyePurple", "foodDough"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.beefwellingtonItem, "listAllbeefraw", "foodDough", "listAllmushroom", "cropSpinach"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.epicbaconItem, "listAllporkcooked", "dyeRed", "dyeOrange", "dyeYellow", "dyeGreen", "dyeBlue", "dyePurple", "dyeMagenta"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.manjuuItem, "toolMixingbowl", "listAllsugar", "cropRice", "cropBean"));
		
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.chickengumboItem, "toolPot", "cropOkra", "listAllchickenraw", "cropCelery", "cropOnion", "foodStock", "cropSpiceleaf", "cropBellpepper"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.generaltsochickenItem, "toolSkillet", "listAllchickenraw", "cropBroccoli", "listAllsugar", "foodFlour", "cropChilipepper", "cropRice"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.californiarollItem, "toolCuttingboard", "listAllfishraw", "cropAvocado", "cropCucumber", "cropSeaweed", "cropRice"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.futomakiItem, "toolCuttingboard", "foodBoiledegg", "cropCucumber", "cropWintersquash", "cropRadish", "cropSeaweed", "cropGinger", "cropRice"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.beansontoastItem, "toolCuttingboard", "foodToast", "foodButter", "foodBakedbeans"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.vegemiteItem, "toolPot", "listAllsugar", "cropBarley", "listAllwater", "cropSpiceleaf"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.honeycombchocolatebarItem, "toolSaucepan", "foodChocolatebar", "materialHoneycomb"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.cherrycoconutchocolatebarItem, "toolSaucepan", "foodChocolatebar", "cropCherry", "foodToastedcoconut"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.fairybreadItem, "toolBakeware", Items.bread, "foodButter", "dyeRed", "dyeGreen", "dyeYellow"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.lamingtonItem, "toolBakeware", "foodDough", "foodChocolatebar", "foodToastedcoconut"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.timtamItem, "toolBakeware", "listAllsugar", "foodFlour", "listAllmilk", "foodChocolatebar"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.meatpieItem, "toolBakeware", "listAllbeefraw", "foodDough", "cropOnion", "cropGarlic", "foodBlackpepper", "foodStock"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.chikorollItem, "toolPot", "foodOliveoil", "foodDough", "listAllchickencooked", "cropCarrot", "cropCabbage", "cropLeek", "cropOnion"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.damperItem, "toolBakeware", "foodFlour", "listAllmilk", "foodSalt", "foodButter"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.damperItem, "toolBakeware", "foodFlour", "listAllmilk", "oreSalt", "foodButter"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.damperItem, "toolBakeware", "foodFlour", "listAllmilk", "dustSalt", "foodButter"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.damperItem, "toolBakeware", "foodFlour", "listAllmilk", "itemSalt", "foodButter"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.beetburgerItem, "toolCuttingboard", "listAllbeefcooked", "cropBeet", "foodFriedegg", "listAllporkcooked", "cropPineapple", "foodToast"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.pavlovaItem, "toolBakeware", "listAllegg", "listAllsugar", "cropLemon", "listAllheavycream", "cropStrawberry"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.pavlovaItem, "toolBakeware", "listAllegg", "listAllsugar", "cropLemon", "listAllheavycream", "cropStrawberry"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.gherkinItem, "toolPot", "foodVinegar", "foodSalt", "cropSpiceleaf", "cropCucumber"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.gherkinItem, "toolPot", "foodVinegar", "oreSalt", "cropSpiceleaf", "cropCucumber"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.gherkinItem, "toolPot", "foodVinegar", "dustSalt", "cropSpiceleaf", "cropCucumber"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.gherkinItem, "toolPot", "foodVinegar", "itemSalt", "cropSpiceleaf", "cropCucumber"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.mcpamItem, "toolCuttingboard", "listAllbeefcooked", "cropLettuce", "foodPickles", "cropOnion", "foodToast", "foodSaladdressing"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.mcpamItem, "toolCuttingboard", "listAllbeefcooked", "cropLettuce", "foodGherkin", "cropOnion", "foodToast", "foodSaladdressing"));

		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.ceasarsaladItem, "toolMixingbowl", "cropLettuce", "foodToast", "foodCheese", "cropGarlic", "foodBlackpepper"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.chaoscookieItem, "toolBakeware", "foodFlour", "foodChocolatebar", new ItemStack(Items.dye, 1, 5)));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.chocolatebaconItem, "toolSaucepan", "listAllporkcooked", "foodChocolatebar"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.lambkebabItem, "toolCuttingboard", "listAllmuttoncooked", "cropOnion", "cropBellpepper", "stickWood"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.nutellaItem, "toolSaucepan", "foodChocolatebar", "foodGroundnutmeg"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.snickersbarItem, "toolSaucepan", "foodChocolatebar", "cropPeanut", "foodOliveoil"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.spinachpieItem, "toolBakeware", "foodDough", "cropSpinach", "foodCheese", "foodToast"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.steamedspinachItem, "toolPot", "cropSpinach", "listAllwater"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.vegemiteontoastItem, "toolCuttingboard", "foodVegemite", "foodToast"));
		
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.holidaycakeItem, "toolBakeware", "listAllegg", "listAllsugar", "cropCherry", "listAllheavycream", "cropSpiceleaf"));

		
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.appleciderItem, "toolPot", "cropApple", "listAllsugar"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.bangersandmashItem, "toolSkillet", "foodPorksausage", "foodMashedpotatoes"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.batteredsausageItem, "toolPot", "foodPorksausage", "foodBatter"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.batterItem, "toolMixingbowl", "foodFlour", "listAllegg"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.chorizoItem, "toolCuttingboard", "listAllporkcooked", "cropSpiceleaf", "cropGarlic", "foodSalt"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.chorizoItem, "toolCuttingboard", "listAllporkcooked", "cropSpiceleaf", "cropGarlic", "dustSalt"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.chorizoItem, "toolCuttingboard", "listAllporkcooked", "cropSpiceleaf", "cropGarlic", "itemSalt"));

		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.coleslawItem, "toolMixingbowl", "cropCabbage", "cropCarrot", "foodMayo", "foodBlackpepper"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.energydrinkItem, "toolPot", "foodBubblywater", "listAllsugar", Items.redstone));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.friedonionsItem, "toolPot", "cropOnion", "foodOliveoil"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.meatfeastpizzaItem, "toolPot", "foodPizza", "foodPepperoni", "foodPorksausage", "listAllbeefcooked", Items.cooked_chicken));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.mincepieItem, "toolBakeware", "listAllbeefcooked", "listAllfruit", "listAllnut", "foodDough", "foodButter"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.onionhamburgerItem, "toolCuttingboard", "foodHamburger", "foodFriedonions"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.pepperoniItem, "toolCuttingboard", "listAllporkcooked", "cropSpiceleaf", "cropBellpepper", "foodSalt"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.pepperoniItem, "toolCuttingboard", "listAllporkcooked", "cropSpiceleaf", "cropBellpepper", "dustSalt"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.pepperoniItem, "toolCuttingboard", "listAllporkcooked", "cropSpiceleaf", "cropBellpepper", "itemSalt"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.pickledonionsItem, "toolPot", "cropOnion", "foodSalt", "foodVinegar"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.pickledonionsItem, "toolPot", "cropOnion", "dustSalt", "foodVinegar"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.pickledonionsItem, "toolPot", "cropOnion", "itemSalt", "foodVinegar"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.porksausageItem, "toolCuttingboard", "listAllporkcooked", "cropSpiceleaf", "foodSalt"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.porksausageItem, "toolCuttingboard", "listAllporkcooked", "cropSpiceleaf", "dustSalt"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.porksausageItem, "toolCuttingboard", "listAllporkcooked", "cropSpiceleaf", "itemSalt"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.raspberrytrifleItem, "toolBakeware", "cropRaspberry", "listAllheavycream", "foodVanilla", "foodDough"));

		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(ItemRegistry.pumpkincheesecakeItem, 1), Blocks.pumpkin, "foodCheesecake"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.pumpkinmuffinItem, "toolBakeware", Blocks.pumpkin, "foodFlour", "listAllegg"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.suaderoItem, "toolCuttingboard", "listAllbeefcooked", "foodOliveoil"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.randomtacoItem, "toolCuttingboard", "listAllbeefcooked", "cropOnion", "foodCheese", "cropAvocado", "cropSpiceleaf", "foodLimejuice", "foodTortilla"));
	
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.strawberrymilkshakeItem, "toolJuicer", "listAllmilk", "cropStrawberry", Items.snowball));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.chocolatemilkshakeItem, "toolJuicer", "listAllmilk", "foodCocoapowder", Items.snowball));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.bananamilkshakeItem, "toolJuicer", "listAllmilk", "cropBanana", Items.snowball));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.cornflakesItem, "toolMixingbowl", "listAllmilk", "cropCorn"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.coleslawburgerItem, "toolCuttingboard", "foodHamburger", "foodColeslaw"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.roastchickenItem, "toolBakeware", "listAllchickenraw", "foodSalt", "foodBlackpepper"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.roastpotatoesItem, "toolBakeware", "cropPotato", "foodSalt", "foodBlackpepper"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.sundayroastItem, "toolBakeware", "foodRoastchicken", "foodRoastpotatoes", "listAllgreenveggie"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.bbqpulledporkItem, "toolCuttingboard", "listAllporkcooked", "foodToast", "cropTomato", "cropSpiceleaf"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.lambwithmintsauceItem, "toolBakeware", "listAllmuttonraw", "cropSpiceleaf", "foodVinegar", "listAllsugar"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.steakandchipsItem, "toolSkillet", "listAllbeefraw", "foodFries"));
		
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.cherryicecreamItem, "toolMixingbowl", "listAllicecream", "cropCherry"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ItemRegistry.pistachioicecreamItem, "toolMixingbowl", "listAllicecream", "cropPistachio"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(ItemRegistry.neapolitanicecreamItem, 3), "foodChocolateicecream", "foodStrawberryicecream", "foodVanillaicecream"));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(ItemRegistry.spumoniicecreamItem, 3), "foodCherryicecream", "foodPistachioicecream", "foodVanillaicecream"));
	}
	
}
