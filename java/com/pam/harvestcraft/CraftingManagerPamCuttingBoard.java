/*     */ package com.pam.harvestcraft;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
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
/*     */ public class CraftingManagerPamCuttingBoard
/*     */ {
/*  22 */   private static final CraftingManagerPamCuttingBoard instance = new CraftingManagerPamCuttingBoard();
/*     */   
/*     */ 
/*  25 */   private List recipes = new ArrayList();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static final CraftingManagerPamCuttingBoard getInstance()
/*     */   {
/*  33 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */   private CraftingManagerPamCuttingBoard()
/*     */   {
/*  39 */     this.recipes = new ArrayList();
/*     */     
/*     */ 
/*  42 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.potatosaladItem, new Object[] { Items.baked_potato, "foodMayo" }));
/*  43 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.eggsaladItem, new Object[] { "foodBoiledegg", "foodMayo" }));
/*  44 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.fruitsaladItem, new Object[] { "listAllfruit", "listAllfruit" }));
/*  45 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.springsaladItem, new Object[] { "cropLettuce", Items.carrot }));
/*  46 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.springsaladItem, new Object[] { "cropLettuce", "cropOnion" }));
/*  47 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.springsaladItem, new Object[] { "cropLettuce", "cropRadish" }));
/*  48 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.springsaladItem, new Object[] { "cropLettuce", "cropCucumber" }));
/*  49 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.springsaladItem, new Object[] { "cropLettuce", "cropBellpepper" }));
/*  50 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.springsaladItem, new Object[] { "cropLettuce", "cropSpiceleaf" }));
/*  51 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.springsaladItem, new Object[] { "cropLettuce", "cropZucchini" }));
/*  52 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.springsaladItem, new Object[] { "cropLettuce", "cropAsparagus" }));
/*  53 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.springsaladItem, new Object[] { "cropLettuce", "cropBroccoli" }));
/*  54 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.springsaladItem, new Object[] { "cropLettuce", "cropPeas" }));
/*  55 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.springsaladItem, new Object[] { "cropLettuce", "cropTomato" }));
/*  56 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.springsaladItem, new Object[] { "cropLettuce", "cropSunflower" }));
/*  57 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.springsaladItem, new Object[] { "cropLettuce", "cropWalnut" }));
/*  58 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.springsaladItem, new Object[] { "cropLettuce", "cropCauliflower" }));
/*  59 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.springsaladItem, new Object[] { "cropLettuce", "cropRhubarb" }));
/*  60 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.porklettucewrapItem, new Object[] { "cropLettuce", "listAllporkcooked" }));
/*  61 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.fishlettucewrapItem, new Object[] { "cropLettuce", "listAllfishcooked" }));
/*  62 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.bltItem, new Object[] { "cropLettuce", "cropTomato", "listAllporkcooked", "foodToast" }));
/*  63 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.nachoesItem, new Object[] { "foodTortilla", "foodCheese" }));
/*  64 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.pbandjItem, new Object[] { "foodPeanutbutter", "foodGrapejelly", Items.bread }));
/*  65 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.cucumbersaladItem, new Object[] { "cropCucumber", "foodSpringsalad" }));
/*  66 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.vegetarianlettucewrapItem, new Object[] { "cropCucumber", "cropLettuce", "cropTomato" }));
/*  67 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.grilledskewersItem, new Object[] { "cropBellpepper", "cropOnion", Items.carrot, Items.stick }));
/*  68 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.supremepizzaItem, new Object[] { "foodPizza", "cropBellpepper", "cropOnion", "cropSpiceleaf" }));
/*  69 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.guacamoleItem, new Object[] { "cropAvocado", "cropChilipepper", "cropTomato", "cropOnion", "cropSpiceleaf" }));
/*  70 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.avocadoburritoItem, new Object[] { "cropAvocado", "foodTortilla", "foodCheese", Items.cooked_chicken }));
/*  71 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.avocadoburritoItem, new Object[] { "cropAvocado", "foodTortilla", "foodCheese", Items.cooked_porkchop }));
/*  72 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.footlongItem, new Object[] { Items.bread, "listAllmeatcooked", "cropLettuce", "cropTomato", "foodMayo" }));
/*  73 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.mixedsaladItem, new Object[] { "listAllveggie", "listAllveggie", "foodSaladdressing" }));
/*  74 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.sushiItem, new Object[] { "listAllfishraw", "cropSeaweed", "cropRice" }));
/*  75 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.applejellysandwichItem, new Object[] { "foodPeanutbutter", "foodApplejelly", Items.bread }));
/*  76 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.blackberryjellysandwichItem, new Object[] { "foodPeanutbutter", "foodBlackberryjelly", Items.bread }));
/*  77 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.blueberryjellysandwichItem, new Object[] { "foodPeanutbutter", "foodBlueberryjelly", Items.bread }));
/*  78 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.cherryjellysandwichItem, new Object[] { "foodPeanutbutter", "foodCherryjelly", Items.bread }));
/*  79 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.cranberryjellysandwichItem, new Object[] { "foodPeanutbutter", "foodCranberryjelly", Items.bread }));
/*  80 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.kiwijellysandwichItem, new Object[] { "foodPeanutbutter", "foodKiwijelly", Items.bread }));
/*  81 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.lemonjellysandwichItem, new Object[] { "foodPeanutbutter", "foodLemonjelly", Items.bread }));
/*  82 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.limejellysandwichItem, new Object[] { "foodPeanutbutter", "foodLimejelly", Items.bread }));
/*  83 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.mangojellysandwichItem, new Object[] { "foodPeanutbutter", "foodMangojelly", Items.bread }));
/*  84 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.orangejellysandwichItem, new Object[] { "foodPeanutbutter", "foodOrangejelly", Items.bread }));
/*  85 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.papayajellysandwichItem, new Object[] { "foodPeanutbutter", "foodPapayajelly", Items.bread }));
/*  86 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.peachjellysandwichItem, new Object[] { "foodPeanutbutter", "foodPeachjelly", Items.bread }));
/*  87 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.pomegranatejellysandwichItem, new Object[] { "foodPeanutbutter", "foodPomegranatejelly", Items.bread }));
/*  88 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.raspberryjellysandwichItem, new Object[] { "foodPeanutbutter", "foodRaspberryjelly", Items.bread }));
/*  89 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.starfruitjellysandwichItem, new Object[] { "foodPeanutbutter", "foodStarfruitjelly", Items.bread }));
/*  90 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.strawberryjellysandwichItem, new Object[] { "foodPeanutbutter", "foodStrawberryjelly", Items.bread }));
/*  91 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.watermelonjellysandwichItem, new Object[] { "foodPeanutbutter", "foodWatermelonjelly", Items.bread }));
/*  92 */     this.recipes.add(new ShapelessOreRecipe(ItemRegistry.ediblerootItem, new Object[] { "cropSpiceleaf" }));
/*     */     
/*  94 */     Collections.sort(this.recipes, new RecipeSorterPamCuttingBoard(this));
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

/*     */ 
/*     */   public void addShapelessRecipe(ItemStack par1ItemStack, Object... par2ArrayOfObj)
/*     */   {
/* 175 */     ArrayList arraylist = new ArrayList();
/* 176 */     Object[] aobject = par2ArrayOfObj;
/* 177 */     int i = par2ArrayOfObj.length;
/*     */     
/* 179 */     for (int j = 0; j < i; j++)
/*     */     {
/* 181 */       Object object1 = aobject[j];
/*     */       
/* 183 */       if ((object1 instanceof ItemStack))
/*     */       {
/* 185 */         arraylist.add(((ItemStack)object1).copy());
/*     */       }
/* 187 */       else if ((object1 instanceof Item))
/*     */       {
/* 189 */         arraylist.add(new ItemStack((Item)object1));
/*     */       }
/*     */       else
/*     */       {
/* 193 */         if (!(object1 instanceof Block))
/*     */         {
/* 195 */           throw new RuntimeException("Invalid shapeless recipy!");
/*     */         }
/*     */         
/* 198 */         arraylist.add(new ItemStack((Block)object1));
/*     */       }
/*     */     }
/*     */     
/* 202 */     this.recipes.add(new ShapelessRecipes(par1ItemStack, arraylist));
/*     */   }
/*     */   
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

/*     */ 
/*     */   public List getRecipeList()
/*     */   {
/* 269 */     return this.recipes;
/*     */   }
/*     */ }


/* Location:              C:\Users\Modding\Desktop\Pam's HarvestCraft 1.7.10k.deobf.jar!\com\pam\harvestcraft\CraftingManagerPamCuttingBoard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */