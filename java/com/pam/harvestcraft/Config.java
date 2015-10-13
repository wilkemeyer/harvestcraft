/*    */ package com.pam.harvestcraft;
/*    */ 
/*    */ import cpw.mods.fml.common.event.FMLPreInitializationEvent;
/*    */ import net.minecraftforge.common.config.Configuration;
/*    */ import net.minecraftforge.common.config.Property;
/*    */ 
/*    */ 
/*    */ public class Config
/*    */ {
/* 10 */   public static final Config instance = new Config();
/*    */   
/*    */   public static final String CATEGORY_CROPS = "crops";
/*    */   public static final String CATEGORY_GARDENS = "gardens";
/*    */   public static final String CATEGORY_FRUIT_TREES = "fruit trees";
/*    */   public static final String CATEGORY_SALT = "salt";
/*    */   public static final String CATEGORY_BEE = "beekeeping";
/*    */   public static final String CATEGORY_MARKET_SALES = "market sales";
/*    */   public static final String CATEGORY_MARKET_PRICES = "market prices";
/*    */   public static final String CATEGORY_MARKET_CURRENCY = "market currency";
/*    */   public static final String CATEGORY_CANDLES = "candles";
/*    */   public static final String CATEGORY_DIMENSIONS = "dimensions";
/*    */   public static final String CATEGORY_SEEDS = "seeds";
/*    */   public static final String CATEGORY_MISC_RECIPES = "miscellaneous recipes";
/*    */   
/*    */   public void load(FMLPreInitializationEvent event)
/*    */   {
/* 27 */     Configuration config = new Configuration(event.getSuggestedConfigurationFile());
/* 28 */     config.load();
/* 29 */     BlockRegistry.initBlocks(event, config);
/* 30 */     ItemRegistry.initItems(event, config);
/*    */     
/* 32 */     Property someProperty = config.get("market currency", "ignore", "ignore");
/* 33 */     Property someProperty2 = config.get("market currency", "ignore2", "ignore");
/* 34 */     Property someProperty3 = config.get("market currency", "ignore3", "ignore");
/*    */     
/*    */ 
/* 37 */     someProperty.comment = "Assign market currency as follows 0:Emerald, 1:Diamond, 2:Gold Ingot, 3:Gold Nugget, 4:Iron Ingot";
/* 38 */     someProperty2.comment = "Assign market currency as follows 5:Wheat Seeds (seeds), 5:Oak Sapling (temperate fruit tree), 5:Jungle Sapling (tropical fruit tree), 5:Spruce Sapling (coniferous fruit tree), 5:Egg (animals)";
/* 39 */     someProperty3.comment = "Assign market currency as follows 6:Apple (temperate/tropical fruit tree), 7:Cocoa Beans (tropical fruit tree)";
/* 40 */     if (config.hasChanged())
/*    */     {
/* 42 */       config.save();
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Modding\Desktop\Pam's HarvestCraft 1.7.10k.deobf.jar!\com\pam\harvestcraft\Config.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */