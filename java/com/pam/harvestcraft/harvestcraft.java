/*     */ package com.pam.harvestcraft;
/*     */ 
/*     */ import cpw.mods.fml.common.Mod;
/*     */ import cpw.mods.fml.common.Mod.EventHandler;
/*     */ import cpw.mods.fml.common.Mod.Instance;
/*     */ import cpw.mods.fml.common.SidedProxy;
/*     */ import cpw.mods.fml.common.event.FMLInitializationEvent;
/*     */ import cpw.mods.fml.common.event.FMLInterModComms;
/*     */ import cpw.mods.fml.common.event.FMLPostInitializationEvent;
/*     */ import cpw.mods.fml.common.event.FMLPreInitializationEvent;
/*     */ import cpw.mods.fml.common.eventhandler.EventBus;
/*     */ import cpw.mods.fml.common.network.NetworkRegistry;
/*     */ import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
/*     */ import cpw.mods.fml.common.registry.GameRegistry;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraftforge.common.MinecraftForge;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Mod(modid="harvestcraft", name="Pam's HarvestCraft", version="1.7.10j")
/*     */ public class harvestcraft
/*     */ {
/*     */   public static final String modid = "harvestcraft";
/*     */   public static final String version = "1.7.10j";
/*     */   @Mod.Instance("harvestcraft")
/*     */   public static harvestcraft instance;
/*     */   @SidedProxy(clientSide="com.pam.harvestcraft.ClientProxy", serverSide="com.pam.harvestcraft.CommonProxy")
/*     */   public static CommonProxy proxy;
/*  43 */   public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel("harvestcraft");
/*     */   
/*     */ 
/*     */ 
/*  47 */   public static CreativeTabs tabHarvestCraft = new CreativeTabs("tabHarvestCraft")
/*     */   {
/*     */ 
/*     */     public Item getTabIconItem()
/*     */     {
/*  52 */       return ItemRegistry.cuttingboardItem;
/*     */     }
/*     */   };
/*     */   
/*  56 */   public static CreativeTabs tabHarvestCraft2 = new CreativeTabs("tabHarvestCraft2")
/*     */   {
/*     */ 
/*     */     public Item getTabIconItem()
/*     */     {
/*  61 */       return ItemRegistry.lettuceItem;
/*     */     }
/*     */   };
/*     */   
/*  65 */   public static CreativeTabs tabHarvestCraft3 = new CreativeTabs("tabHarvestCraft3")
/*     */   {
/*     */ 
/*     */     public Item getTabIconItem()
/*     */     {
/*  70 */       return ItemRegistry.pbandjItem;
/*     */     }
/*     */   };
/*     */   
/*     */   @Mod.EventHandler
/*     */   public void onPreInit(FMLPreInitializationEvent event)
/*     */   {
/*  77 */     Config.instance.load(event);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  86 */     NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
/*     */     
/*  88 */     BlockRegistry.registerBlocks();
/*  89 */     ItemRegistry.registerItems();
/*  90 */     PamThaumcraftAspectsList.getRegistry();
/*     */     
/*     */ 
/*  93 */     PamFoodRecipes.getRecipes();
/*  94 */     PamOtherRecipes.getRecipes();
/*  95 */     PamFoodFishingCraftRecipes.getRecipes();
/*  96 */     PamFoodOreDictionaryRegistry.getRegistry();
/*  97 */     PamOtherOreDictionaryRegistry.getRegistry();
/*  98 */     PamCropSeedDropRegistry.getSeedDrops();
/*  99 */     PamMFRCompatibility.getRegistry();
/*     */     
/* 101 */     MarketItems.registerItems();
/* 102 */     PacketHandler.init();
/*     */     
/* 104 */     FishRegistry.registerItems();
/*     */     
/* 106 */     GameRegistry.registerTileEntity(TileEntityPamApiary.class, "PamApiary");
/* 107 */     GameRegistry.registerTileEntity(TileEntityPamPresser.class, "PamPresser");
/* 108 */     GameRegistry.registerTileEntity(TileEntityMarket.class, "PamMarket");
/* 109 */     GameRegistry.registerTileEntity(TileEntityOven.class, "PamOven");
/* 110 */     GameRegistry.registerTileEntity(TileEntityChurn.class, "PamChurn");
/* 111 */     GameRegistry.registerTileEntity(TileEntityQuern.class, "PamQuern");
/* 112 */     GameRegistry.registerTileEntity(TileEntityPamAnimalTrap.class, "PamAnimalTrap");
/* 113 */     GameRegistry.registerTileEntity(TileEntityPamFishTrap.class, "PamFishTrap");
/*     */     
/* 115 */     proxy.registerHandlers(event);
/*     */     
/* 117 */     if (ItemRegistry.sheepdropMutton)
/*     */     {
/* 119 */       MinecraftForge.EVENT_BUS.register(new PamSheepDrops());
/*     */     }
/* 121 */     if (ItemRegistry.squiddropCalamari)
/*     */     {
/* 123 */       MinecraftForge.EVENT_BUS.register(new PamSquidDrops());
/*     */     }
/*     */     
/* 126 */     MinecraftForge.EVENT_BUS.register(new PamGreenHeartTaming());
/*     */     
/* 128 */     MinecraftForge.EVENT_BUS.register(new PamHarvestBonemealEvent());
/*     */     
/* 130 */     MinecraftForge.EVENT_BUS.register(new PamTooltipEventHandler());
/*     */   }
/*     */   
/*     */ 
/*     */   @Mod.EventHandler
/*     */   public void init(FMLInitializationEvent event)
/*     */   {
/* 137 */     FMLInterModComms.sendMessage("cfm", "register", "com.pam.harvestcraft.CrayfishCompatibility.registerRecipes");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Mod.EventHandler
/*     */   public void postInit(FMLPostInitializationEvent event) {}
/*     */   
/*     */ 
/*     */   @Mod.EventHandler
/*     */   public void load(FMLInitializationEvent event)
/*     */   {
/*     */     
/*     */     
/* 151 */     if (BlockRegistry.enablesaltGeneration)
/*     */     {
/* 153 */       GameRegistry.registerWorldGenerator(new WorldGenPamSalt(), 1);
/*     */     }
/*     */     
/* 156 */     if (BlockRegistry.enablebeehiveGeneration)
/*     */     {
/* 158 */       GameRegistry.registerWorldGenerator(new PamBeeGenerator(), 0);
/*     */     }
/*     */     
/* 161 */     GameRegistry.registerWorldGenerator(new PamGardenGenerator(), 0);
/* 162 */     GameRegistry.registerWorldGenerator(new PamTreeGenerator(), 0);
/*     */   }
/*     */ }


/* Location:              C:\Users\Modding\Desktop\Pam's HarvestCraft 1.7.10k.deobf.jar!\com\pam\harvestcraft\harvestcraft.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */