/*     */ package com.pam.harvestcraft;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.inventory.InventoryCrafting;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.item.crafting.IRecipe;
/*     */ import net.minecraft.item.crafting.ShapedRecipes;
/*     */ import net.minecraft.item.crafting.ShapelessRecipes;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.oredict.ShapelessOreRecipe;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CraftingManagerPamPot
/*     */ {
/*  24 */   private static final CraftingManagerPamPot instance = new CraftingManagerPamPot();
/*     */   
/*     */ 
/*  27 */   private List recipes = new ArrayList();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static final CraftingManagerPamPot getInstance()
/*     */   {
/*  35 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */   private CraftingManagerPamPot()
/*     */   {
/*  41 */     this.recipes = new ArrayList();
/*  42 */     if (ItemRegistry.enablesaltfromwaterbucketrecipe)
/*     */     {
/*  44 */       this.recipes.add(new ShapelessOreRecipe(ItemRegistry.saltItem, new Object[] { "listAllwater" }));
/*     */     }
/*     */     
/*     */ 
/*  48 */     this.recipes.add(new ShapelessOreRecipe(Items.sugar, new Object[] { "foodHoneydrop" }));
/*  49 */     this.recipes.add(new ShapelessOreRecipe(Items.sugar, new Object[] { "dropHoney" }));
/*     */     
/*  51 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.waxItem, new Object[] { ItemRegistry.candleberryItem, ItemRegistry.candleberryItem, ItemRegistry.candleberryItem, ItemRegistry.candleberryItem }));
/*     */     
/*  53 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.cheeseItem, new Object[] { "listAllmilk", "foodSalt" }));
/*  54 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.icecreamItem, new Object[] { "listAllmilk", "foodSalt", Items.snowball }));
/*  55 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.applesauceItem, new Object[] { Items.apple }));
/*  56 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.pumpkinsoupItem, new Object[] { Blocks.pumpkin, "listAllReplaceheavycream", "foodStock" }));
/*  57 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.carrotsoupItem, new Object[] { Items.carrot, "listAllReplaceheavycream", "foodStock" }));
/*  58 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.potatosoupItem, new Object[] { Items.potato, "foodSalt", "foodStock" }));
/*  59 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.chickennoodlesoupItem, new Object[] { "listAllchickenraw", Items.carrot, "foodPasta", "foodStock" }));
/*  60 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.hotdogItem, new Object[] { "listAllporkraw", Items.bread }));
/*  61 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.potroastItem, new Object[] { "listAllbeefraw", Items.potato, Items.carrot, "foodStock" }));
/*  62 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.boiledeggItem, new Object[] { "listAllegg" }));
/*  63 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.spidereyesoupItem, new Object[] { Items.spider_eye, "foodStock" }));
/*  64 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.vegetablesoupItem, new Object[] { Items.potato, Items.carrot, "listAllmushroom", "foodStock" }));
/*  65 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.vegetablesoupItem, new Object[] { Items.potato, Items.carrot, "listAllmushroom", "foodStock" }));
/*  66 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.vegetablesoupItem, new Object[] { Items.potato, Items.carrot, "listAllmushroom", "foodStock" }));
/*  67 */     this.recipes.add(new ShapelessOreRecipe(new ItemStack(ItemRegistry.stockItem, 3, 0), new Object[] { Items.bone }));
/*  68 */     this.recipes.add(new ShapelessOreRecipe(new ItemStack(ItemRegistry.stockItem, 3, 0), new Object[] { "listAllmeatraw" }));
/*  69 */     this.recipes.add(new ShapelessOreRecipe(new ItemStack(ItemRegistry.stockItem, 3, 0), new Object[] { "listAllveggie" }));
/*  70 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.tomatosoupItem, new Object[] { "cropTomato", "foodStock" }));
/*  71 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.onionsoupItem, new Object[] { "cropOnion", "foodStock", "foodGrilledcheese" }));
/*  72 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.vinegarItem, new Object[] { "foodGrapejuice" }));
/*  73 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.picklesItem, new Object[] { "cropCucumber", "foodSalt", "foodVinegar" }));
/*  74 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.cucumbersoupItem, new Object[] { "cropCucumber", "foodStock", "listAllReplaceheavycream" }));
/*  75 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.marinatedcucumbersItem, new Object[] { "cropCucumber", "cropOnion", Items.sugar, "foodVinegar" }));
/*  76 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.ricesoupItem, new Object[] { "cropRice", "foodStock" }));
/*  77 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.bakedbeansItem, new Object[] { "cropBean", "listAllporkcooked", Items.sugar }));
/*  78 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.beansandriceItem, new Object[] { "cropBean", "cropRice", "cropOnion", "listAllporkcooked" }));
/*  79 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.beansandriceItem, new Object[] { "cropBean", "cropRice", "cropBellpepper", "listAllporkcooked" }));
/*  80 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.beansandriceItem, new Object[] { "cropBean", "cropRice", "cropChilipepper", "listAllporkcooked" }));
/*  81 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.chiliItem, new Object[] { "cropBean", "cropOnion", "listAllbeefcooked" }));
/*  82 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.chiliItem, new Object[] { "cropBean", "cropBellpepper", "listAllbeefcooked" }));
/*  83 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.chiliItem, new Object[] { "cropBean", "cropChilipepper", "listAllbeefcooked" }));
/*  84 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.pickledbeetsItem, new Object[] { "cropBeet", "foodVinegar", "foodSalt" }));
/*  85 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.beetsoupItem, new Object[] { "cropBeet", "cropOnion", "foodBlackpepper", "listAllmilk" }));
/*  86 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.broccolimacItem, new Object[] { "cropBroccoli", "foodPasta", "foodCheese" }));
/*  87 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.creamedbroccolisoupItem, new Object[] { "cropBroccoli", Items.carrot, "foodFlour", "foodBlackpepper", "foodStock" }));
/*  88 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.steamedpeasItem, new Object[] { "cropPeas", "listAllwater", "foodSalt" }));
/*  89 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.splitpeasoupItem, new Object[] { "cropPeas", "listAllporkcooked", "foodBlackpepper", "foodStock" }));
/*  90 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.turnipsoupItem, new Object[] { "cropTurnip", Blocks.pumpkin, "foodButter", "foodStock" }));
/*  91 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.celerysoupItem, new Object[] { "cropCelery", "cropOnion", Items.carrot, "foodStock" }));
/*  92 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.asparagussoupItem, new Object[] { "cropAsparagus", "cropOnion", "foodButter", "foodStock" }));
/*  93 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.creamofavocadosoupItem, new Object[] { "cropAvocado", "listAllReplaceheavycream", "cropLime", "cropSpiceleaf", "foodStock" }));
/*  94 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.chickencurryItem, new Object[] { "cropCoconut", "foodPlainyogurt", "listAllchickenraw", "cropSpiceleaf", "cropChilipepper", "cropRice", "foodGroundcinnamon", "cropGarlic" }));
/*  95 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.marshmellowsItem, new Object[] { Items.sugar, "listAllwater", "listAllegg" }));
/*  96 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.donutItem, new Object[] { "foodDough", "foodOliveoil" }));
/*  97 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.cactussoupItem, new Object[] { Blocks.cactus, "foodStock" }));
/*  98 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.seedsoupItem, new Object[] { "listAllseed", "foodStock" }));
/*  99 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.friedchickenItem, new Object[] { "listAllchickenraw", "foodFlour", "cropSpiceleaf", "foodBlackpepper", "foodOliveoil" }));
/* 100 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.meatystewItem, new Object[] { "listAllmeatraw", "foodFlour", "foodStock" }));
/* 101 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.gardensoupItem, new Object[] { "foodStock", "listAllveggie", "listAllveggie" }));
/* 102 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.cherrysodaItem, new Object[] { "foodBubblywater", Items.sugar, "foodCherryjuice" }));
/* 103 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.colasodaItem, new Object[] { "foodBubblywater", Items.sugar, "cropSpiceleaf" }));
/* 104 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.gingersodaItem, new Object[] { "foodBubblywater", Items.sugar, "cropGinger" }));
/* 105 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.grapesodaItem, new Object[] { "foodBubblywater", Items.sugar, "foodGrapejuice" }));
/* 106 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.lemonlimesodaItem, new Object[] { "foodBubblywater", Items.sugar, "cropLemon", "foodLimejuice" }));
/* 107 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.orangesodaItem, new Object[] { "foodBubblywater", Items.sugar, "foodOrangejuice" }));
/* 108 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.rootbeersodaItem, new Object[] { "foodBubblywater", Items.sugar, "cropEdibleroot" }));
/* 109 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.strawberrysodaItem, new Object[] { "foodBubblywater", Items.sugar, "foodStrawberryjuice" }));
/* 110 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.oldworldveggiesoupItem, new Object[] { "foodStock", "cropOnion", "cropPeas", "cropBarley" }));
/* 111 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.lambbarleysoupItem, new Object[] { "foodStock", "listAllmuttonraw", "cropOnion", Items.carrot, "cropBarley" }));
/* 112 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.leekbaconsoupItem, new Object[] { "cropLeek", "listAllporkcooked", Items.potato, "listAllReplaceheavycream" }));
/*     */     
/*     */ 
/* 115 */     Collections.sort(this.recipes, new RecipeSorterPamPot(this));
/*     */   }
/*     */   
/*     */ 
@SuppressWarnings({ "rawtypes", "unchecked" })
public ShapedRecipes addRecipe(ItemStack par1ItemStack, Object ... par2ArrayOfObj)
{
         String s = "";
         int i = 0;
         int j = 0;
         int k = 0;

         if (par2ArrayOfObj[i] instanceof String[])
         {
                 String[] astring = (String[])((String[])par2ArrayOfObj[i++]);

                 for (int l = 0; l < astring.length; ++l)
                 {
                         String s1 = astring[l];
                         ++k;
                         j = s1.length();
                         s = s + s1;
                 }
         }
         else
         {
                 while (par2ArrayOfObj[i] instanceof String)
                 {
                         String s2 = (String)par2ArrayOfObj[i++];
                         ++k;
                         j = s2.length();
                         s = s + s2;
                 }
         }

         HashMap hashmap;

         for (hashmap = new HashMap(); i < par2ArrayOfObj.length; i += 2)
         {
                 Character character = (Character)par2ArrayOfObj[i];
                 ItemStack itemstack1 = null;

                 if (par2ArrayOfObj[i + 1] instanceof Item)
                 {
                         itemstack1 = new ItemStack((Item)par2ArrayOfObj[i + 1]);
                 }
                 else if (par2ArrayOfObj[i + 1] instanceof Block)
                 {
                         itemstack1 = new ItemStack((Block)par2ArrayOfObj[i + 1], 1, 32767);
                 }
                 else if (par2ArrayOfObj[i + 1] instanceof ItemStack)
                 {
                         itemstack1 = (ItemStack)par2ArrayOfObj[i + 1];
                 }

                 hashmap.put(character, itemstack1);
         }

         ItemStack[] aitemstack = new ItemStack[j * k];

         for (int i1 = 0; i1 < j * k; ++i1)
         {
                 char c0 = s.charAt(i1);

                 if (hashmap.containsKey(Character.valueOf(c0)))
                 {
                         aitemstack[i1] = ((ItemStack)hashmap.get(Character.valueOf(c0))).copy();
                 }
                 else
                 {
                         aitemstack[i1] = null;
                 }
         }

         ShapedRecipes shapedrecipes = new ShapedRecipes(j, k, aitemstack, par1ItemStack);
         this.recipes.add(shapedrecipes);
         return shapedrecipes;
}

@SuppressWarnings({ "rawtypes", "unchecked" })
public void addShapelessRecipe(ItemStack par1ItemStack, Object ... par2ArrayOfObj)
{
         ArrayList arraylist = new ArrayList();
         Object[] aobject = par2ArrayOfObj;
         int i = par2ArrayOfObj.length;

         for (int j = 0; j < i; ++j)
         {
                 Object object1 = aobject[j];

                 if (object1 instanceof ItemStack)
                 {
                         arraylist.add(((ItemStack)object1).copy());
                 }
                 else if (object1 instanceof Item)
                 {
                         arraylist.add(new ItemStack((Item)object1));
                 }
                 else
                 {
                         if (!(object1 instanceof Block))
                         {
                                 throw new RuntimeException("Invalid shapeless recipy!");
                         }

                         arraylist.add(new ItemStack((Block)object1));
                 }
         }

         this.recipes.add(new ShapelessRecipes(par1ItemStack, arraylist));
}

public ItemStack findMatchingRecipe(InventoryCrafting par1InventoryCrafting, World par2World)
{
    int i = 0;
    ItemStack itemstack = null;
    ItemStack itemstack1 = null;
    int j;

    for (j = 0; j < par1InventoryCrafting.getSizeInventory(); ++j)
    {
        ItemStack itemstack2 = par1InventoryCrafting.getStackInSlot(j);

        if (itemstack2 != null)
        {
            if (i == 0)
            {
                itemstack = itemstack2;
            }

            if (i == 1)
            {
                itemstack1 = itemstack2;
            }

            ++i;
        }
    }

    if (i == 2 && itemstack.getItem() == itemstack1.getItem() && itemstack.stackSize == 1 && itemstack1.stackSize == 1 && itemstack.getItem().isRepairable())
    {
        Item item = itemstack.getItem();
        int j1 = item.getMaxDamage() - itemstack.getItemDamageForDisplay();
        int k = item.getMaxDamage() - itemstack1.getItemDamageForDisplay();
        int l = j1 + k + item.getMaxDamage() * 5 / 100;
        int i1 = item.getMaxDamage() - l;

        if (i1 < 0)
        {
            i1 = 0;
        }

        return new ItemStack(itemstack.getItem(), 1, i1);
    }
    else
    {
        for (j = 0; j < this.recipes.size(); ++j)
        {
            IRecipe irecipe = (IRecipe)this.recipes.get(j);

            if (irecipe.matches(par1InventoryCrafting, par2World))
            {
                return irecipe.getCraftingResult(par1InventoryCrafting);
            }
        }

        return null;
    }
}
/*     */   public List getRecipeList()
/*     */   {
/* 290 */     return this.recipes;
/*     */   }
/*     */ }


/* Location:              C:\Users\Modding\Desktop\Pam's HarvestCraft 1.7.10k.deobf.jar!\com\pam\harvestcraft\CraftingManagerPamPot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */