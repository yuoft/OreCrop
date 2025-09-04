package com.yuo.orecrop.Items;

import com.yuo.orecrop.Blocks.OreCropBlocks;
import com.yuo.orecrop.OreCrop;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

//物品注册管理器
public class OreCropItems {
	//创建注册器。ForgeRegistries.ITEMS代表了我们要注册的是物品，第二个参数填入的应该是你的modId。
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, OreCrop.MOD_ID);
	public static final Item.Properties GROUP = new Item.Properties();
	//注册物品。一个是「注册名」，还有一个就是你要注册对象的实例
	public static RegistryObject<Item> voidSeed = ITEMS.register("void_seed", OrdinaryItem::new);
	public static RegistryObject<Item> diamondNugget = ITEMS.register("diamond_nugget", OrdinaryItem::new);
	public static RegistryObject<Item> emeraldNugget = ITEMS.register("emerald_nugget", OrdinaryItem::new);
	public static RegistryObject<Item> lapisNugget = ITEMS.register("lapis_nugget", OrdinaryItem::new);
	public static RegistryObject<Item> coalNugget = ITEMS.register("coal_nugget", OrdinaryItem::new);
	public static RegistryObject<Item> quartzNugget = ITEMS.register("quartz_nugget", OrdinaryItem::new);
	public static RegistryObject<Item> redstoneNugget = ITEMS.register("redstone_nugget", OrdinaryItem::new);
	public static RegistryObject<Item> netheriteNugget = ITEMS.register("netherite_nugget", OrdinaryItem::new);
	public static RegistryObject<Item> copperNugget = ITEMS.register("copper_nugget", OrdinaryItem::new);
	public static RegistryObject<Item> coalFruit = ITEMS.register("coal_fruit", OrdinaryItem::new);
	public static RegistryObject<Item> diamondFruit = ITEMS.register("diamond_fruit", OrdinaryItem::new);
	public static RegistryObject<Item> emeraldFruit = ITEMS.register("emerald_fruit", OrdinaryItem::new);
	public static RegistryObject<Item> goldFruit = ITEMS.register("gold_fruit", OrdinaryItem::new);
	public static RegistryObject<Item> ironFruit = ITEMS.register("iron_fruit", OrdinaryItem::new);
	public static RegistryObject<Item> lapisFruit = ITEMS.register("lapis_fruit", OrdinaryItem::new);
	public static RegistryObject<Item> quartzFruit = ITEMS.register("quartz_fruit", OrdinaryItem::new);
	public static RegistryObject<Item> redstoneFruit = ITEMS.register("redstone_fruit", OrdinaryItem::new);
	public static RegistryObject<Item> netheriteFruit = ITEMS.register("netherite_fruit", OrdinaryItem::new);
	public static RegistryObject<Item> cropSeed = ITEMS.register("crop_seed", OrdinaryItem::new);
	public static RegistryObject<Item> oreSapling = ITEMS.register("ore_sapling", OrdinaryItem::new);

	//注册方块物品
//	public static RegistryObject<BlockItem> coalLeanOre = ITEMS.register("coal_lean_ore",
//			() -> new BlockItem(BlockRegistry.coalLeanOre.get(), GROUP));

	public static RegistryObject<BlockItem> customSapling = ITEMS.register("custom_sapling",
			() -> new CustomSapling(OreCropBlocks.customSapling.get(), GROUP));

	//普通作物种子
	public static RegistryObject<BlockItem> coalCropSeed = ITEMS.register("coal_crop_seed",
			() -> new ItemNameBlockItem(OreCropBlocks.coalCrop.get(), GROUP));
	public static RegistryObject<BlockItem> diamondCropSeed = ITEMS.register("diamond_crop_seed",
			() -> new ItemNameBlockItem(OreCropBlocks.diamondCrop.get(), GROUP));
	public static RegistryObject<BlockItem> emeraldCropSeed = ITEMS.register("emerald_crop_seed",
			() -> new ItemNameBlockItem(OreCropBlocks.emeraldCrop.get(), GROUP));
	public static RegistryObject<BlockItem> goldCropSeed = ITEMS.register("gold_crop_seed",
			() -> new ItemNameBlockItem(OreCropBlocks.goldCrop.get(), GROUP));
	public static RegistryObject<BlockItem> ironCropSeed = ITEMS.register("iron_crop_seed",
			() -> new ItemNameBlockItem(OreCropBlocks.ironCrop.get(), GROUP));
	public static RegistryObject<BlockItem> lapisCropSeed = ITEMS.register("lapis_crop_seed",
			() -> new ItemNameBlockItem(OreCropBlocks.lapisCrop.get(), GROUP));
	public static RegistryObject<BlockItem> quartzCropSeed = ITEMS.register("quartz_crop_seed",
			() -> new ItemNameBlockItem(OreCropBlocks.quartzCrop.get(), GROUP));
	public static RegistryObject<BlockItem> redstoneCropSeed = ITEMS.register("redstone_crop_seed",
			() -> new ItemNameBlockItem(OreCropBlocks.redstoneCrop.get(), GROUP));
	public static RegistryObject<BlockItem> netheriteCropSeed = ITEMS.register("netherite_crop_seed",
			() -> new ItemNameBlockItem(OreCropBlocks.netheriteCrop.get(), GROUP));

	//矿石树
	public static RegistryObject<BlockItem> oreLog = ITEMS.register("ore_log",
			() -> new BlockItem(OreCropBlocks.oreLog.get(), GROUP));
	public static RegistryObject<BlockItem> coalLeaf = ITEMS.register("coal_leaf",
			() -> new BlockItem(OreCropBlocks.coalLeaf.get(), GROUP));
	public static RegistryObject<BlockItem> coalSapling = ITEMS.register("coal_sapling",
			() -> new BlockItem(OreCropBlocks.coalSapling.get(), GROUP));
	public static RegistryObject<BlockItem> diamondLeaf = ITEMS.register("diamond_leaf",
			() -> new BlockItem(OreCropBlocks.diamondLeaf.get(), GROUP));
	public static RegistryObject<BlockItem> diamondSapling = ITEMS.register("diamond_sapling",
			() -> new BlockItem(OreCropBlocks.diamondSapling.get(), GROUP));
	public static RegistryObject<BlockItem> emeraldLeaf = ITEMS.register("emerald_leaf",
			() -> new BlockItem(OreCropBlocks.emeraldLeaf.get(), GROUP));
	public static RegistryObject<BlockItem> emeraldSapling = ITEMS.register("emerald_sapling",
			() -> new BlockItem(OreCropBlocks.emeraldSapling.get(), GROUP));
	public static RegistryObject<BlockItem> goldLeaf = ITEMS.register("gold_leaf",
			() -> new BlockItem(OreCropBlocks.goldLeaf.get(), GROUP));
	public static RegistryObject<BlockItem> goldSapling = ITEMS.register("gold_sapling",
			() -> new BlockItem(OreCropBlocks.goldSapling.get(), GROUP));
	public static RegistryObject<BlockItem> ironLeaf = ITEMS.register("iron_leaf",
			() -> new BlockItem(OreCropBlocks.ironLeaf.get(), GROUP));
	public static RegistryObject<BlockItem> ironSapling = ITEMS.register("iron_sapling",
			() -> new BlockItem(OreCropBlocks.ironSapling.get(), GROUP));
	public static RegistryObject<BlockItem> lapisLeaf = ITEMS.register("lapis_leaf",
			() -> new BlockItem(OreCropBlocks.lapisLeaf.get(), GROUP));
	public static RegistryObject<BlockItem> lapisSapling = ITEMS.register("lapis_sapling",
			() -> new BlockItem(OreCropBlocks.lapisSapling.get(), GROUP));
	public static RegistryObject<BlockItem> quartzLeaf = ITEMS.register("quartz_leaf",
			() -> new BlockItem(OreCropBlocks.quartzLeaf.get(), GROUP));
	public static RegistryObject<BlockItem> quartzSapling = ITEMS.register("quartz_sapling",
			() -> new BlockItem(OreCropBlocks.quartzSapling.get(), GROUP));
	public static RegistryObject<BlockItem> redstoneldLeaf = ITEMS.register("redstone_leaf",
			() -> new BlockItem(OreCropBlocks.redstoneLeaf.get(), GROUP));
	public static RegistryObject<BlockItem> redstoneSapling = ITEMS.register("redstone_sapling",
			() -> new BlockItem(OreCropBlocks.redstoneSapling.get(), GROUP));
	public static RegistryObject<BlockItem> netheriteLeaf = ITEMS.register("netherite_leaf",
			() -> new BlockItem(OreCropBlocks.netheriteLeaf.get(), GROUP));
	public static RegistryObject<BlockItem> netheriteSapling = ITEMS.register("netherite_sapling",
			() -> new BlockItem(OreCropBlocks.netheriteSapling.get(), GROUP));

	public static RegistryObject<Item> rubyNugget;
	public static RegistryObject<Item> rubyFruit;
	public static RegistryObject<BlockItem> rubyCropSeed;
	public static RegistryObject<BlockItem> rubyLeaf;
	public static RegistryObject<BlockItem> rubySapling;
	public static RegistryObject<Item> dragonNugget;
	public static RegistryObject<Item> dragonFruit;
	public static RegistryObject<BlockItem> dragonCropSeed;
	public static RegistryObject<BlockItem> dragonLeaf;
	public static RegistryObject<BlockItem> dragonSapling;
	public static RegistryObject<Item> xrayNugget;
	public static RegistryObject<Item> xrayFruit;
	public static RegistryObject<BlockItem> xrayCropSeed;
	public static RegistryObject<BlockItem> xrayLeaf;
	public static RegistryObject<BlockItem> xraySapling;
	public static RegistryObject<Item> superNugget;
	public static RegistryObject<Item> superFruit;
	public static RegistryObject<BlockItem> superCropSeed;
	public static RegistryObject<BlockItem> superLeaf;
	public static RegistryObject<BlockItem> superSapling;
	public static RegistryObject<Item> spaceNugget;
	public static RegistryObject<Item> spaceFruit;
	public static RegistryObject<BlockItem> spaceCropSeed;
	public static RegistryObject<BlockItem> spaceLeaf;
	public static RegistryObject<BlockItem> spaceSapling;
	public static RegistryObject<Item> silverFruit;
	public static RegistryObject<BlockItem> silverCropSeed;
	public static RegistryObject<BlockItem> silverLeaf;
	public static RegistryObject<BlockItem> silverSapling;
	public static RegistryObject<Item> copperFruit = ITEMS.register("copper_fruit", OrdinaryItem::new);
	public static RegistryObject<BlockItem> copperCropSeed = ITEMS.register("copper_crop_seed", () -> new ItemNameBlockItem(OreCropBlocks.copperCrop.get(), GROUP));
	public static RegistryObject<BlockItem> copperLeaf = ITEMS.register("copper_leaf", () -> new BlockItem(OreCropBlocks.copperLeaf.get(), GROUP));
	public static RegistryObject<BlockItem> copperSapling = ITEMS.register("copper_sapling", () -> new BlockItem(OreCropBlocks.copperSapling.get(), GROUP));

	public static void registerSpaceArmsItem(){
		rubyNugget = ITEMS.register("ruby_nugget", OrdinaryItem::new);
		rubyFruit = ITEMS.register("ruby_fruit", OrdinaryItem::new);
		rubyCropSeed = ITEMS.register("ruby_crop_seed", () -> new ItemNameBlockItem(OreCropBlocks.rubyCrop.get(), GROUP));
		rubyLeaf = ITEMS.register("ruby_leaf", () -> new BlockItem(OreCropBlocks.rubyLeaf.get(), GROUP));
		rubySapling = ITEMS.register("ruby_sapling", () -> new BlockItem(OreCropBlocks.rubySapling.get(), GROUP));
		dragonNugget = ITEMS.register("dragon_nugget", OrdinaryItem::new);
		dragonFruit = ITEMS.register("dragon_fruit", OrdinaryItem::new);
		dragonCropSeed = ITEMS.register("dragon_crop_seed", () -> new ItemNameBlockItem(OreCropBlocks.dragonCrop.get(), GROUP));
		dragonLeaf = ITEMS.register("dragon_leaf", () -> new BlockItem(OreCropBlocks.dragonLeaf.get(), GROUP));
		dragonSapling = ITEMS.register("dragon_sapling", () -> new BlockItem(OreCropBlocks.dragonSapling.get(), GROUP));
		xrayNugget = ITEMS.register("xray_nugget", OrdinaryItem::new);
		xrayFruit = ITEMS.register("xray_fruit", OrdinaryItem::new);
		xrayCropSeed = ITEMS.register("xray_crop_seed", () -> new ItemNameBlockItem(OreCropBlocks.xrayCrop.get(), GROUP));
		xrayLeaf = ITEMS.register("xray_leaf", () -> new BlockItem(OreCropBlocks.xrayLeaf.get(), GROUP));
		xraySapling = ITEMS.register("xray_sapling", () -> new BlockItem(OreCropBlocks.xraySapling.get(), GROUP));
		superNugget = ITEMS.register("super_nugget", OrdinaryItem::new);
		superFruit = ITEMS.register("super_fruit", OrdinaryItem::new);
		superCropSeed = ITEMS.register("super_crop_seed", () -> new ItemNameBlockItem(OreCropBlocks.superCrop.get(), GROUP));
		superLeaf = ITEMS.register("super_leaf", () -> new BlockItem(OreCropBlocks.superLeaf.get(), GROUP));
		superSapling = ITEMS.register("super_sapling", () -> new BlockItem(OreCropBlocks.superSapling.get(), GROUP));
		spaceNugget = ITEMS.register("space_nugget", OrdinaryItem::new);
		spaceFruit = ITEMS.register("space_fruit", OrdinaryItem::new);
		spaceCropSeed = ITEMS.register("space_crop_seed", () -> new ItemNameBlockItem(OreCropBlocks.spaceCrop.get(), GROUP));
		spaceLeaf = ITEMS.register("space_leaf", () -> new BlockItem(OreCropBlocks.spaceLeaf.get(), GROUP));
		spaceSapling = ITEMS.register("space_sapling", () -> new BlockItem(OreCropBlocks.spaceSapling.get(), GROUP));
	}

	public static void registerIafItem(){
		silverFruit = ITEMS.register("silver_fruit", OrdinaryItem::new);
		silverCropSeed = ITEMS.register("silver_crop_seed", () -> new ItemNameBlockItem(OreCropBlocks.silverCrop.get(), GROUP));
		silverLeaf = ITEMS.register("silver_leaf", () -> new BlockItem(OreCropBlocks.silverLeaf.get(), GROUP));
		silverSapling = ITEMS.register("silver_sapling", () -> new BlockItem(OreCropBlocks.silverSapling.get(), GROUP));
	}

	public static RegistryObject<Item>      awakenedDraconiumFruit;
	public static RegistryObject<BlockItem> awakenedDraconiumCropSeed;
	public static RegistryObject<BlockItem> awakenedDraconiumLeaf;
	public static RegistryObject<BlockItem> awakenedDraconiumSapling;
	public static RegistryObject<Item>      draconiumFruit;
	public static RegistryObject<BlockItem> draconiumCropSeed;
	public static RegistryObject<BlockItem> draconiumLeaf;
	public static RegistryObject<BlockItem> draconiumSapling;

	public static RegistryObject<Item>      manasteelFruit;
	public static RegistryObject<BlockItem> manasteelCropSeed;
	public static RegistryObject<BlockItem> manasteelLeaf;
	public static RegistryObject<BlockItem> manasteelSapling;
	public static RegistryObject<Item>      terrasteelFruit;
	public static RegistryObject<BlockItem> terrasteelCropSeed;
	public static RegistryObject<BlockItem> terrasteelLeaf;
	public static RegistryObject<BlockItem> terrasteelSapling;
	public static RegistryObject<Item>      elementiumFruit;
	public static RegistryObject<BlockItem> elementiumCropSeed;
	public static RegistryObject<BlockItem> elementiumLeaf;
	public static RegistryObject<BlockItem> elementiumSapling;
	public static RegistryObject<Item>      gaiaNugget;
	public static RegistryObject<Item>      gaiaFruit;
	public static RegistryObject<BlockItem> gaiaCropSeed;
	public static RegistryObject<BlockItem> gaiaLeaf;
	public static RegistryObject<BlockItem> gaiaSapling;

	public static void registerDEItem(){
		awakenedDraconiumFruit = ITEMS.register("awakened_draconium_fruit", OrdinaryItem::new);
		awakenedDraconiumCropSeed = ITEMS.register("awakened_draconium_crop_seed", () -> new ItemNameBlockItem(OreCropBlocks.awakenedDraconiumCrop.get(), GROUP));
		awakenedDraconiumLeaf = ITEMS.register("awakened_draconium_leaf", () -> new BlockItem(OreCropBlocks.awakenedDraconiumLeaf.get(), GROUP));
		awakenedDraconiumSapling = ITEMS.register("awakened_draconium_sapling", () -> new BlockItem(OreCropBlocks.awakenedDraconiumSapling.get(), GROUP));
		draconiumFruit = ITEMS.register("draconium_fruit", OrdinaryItem::new);
		draconiumCropSeed = ITEMS.register("draconium_crop_seed", () -> new ItemNameBlockItem(OreCropBlocks.draconiumCrop.get(), GROUP));
		draconiumLeaf = ITEMS.register("draconium_leaf", () -> new BlockItem(OreCropBlocks.draconiumLeaf.get(), GROUP));
		draconiumSapling = ITEMS.register("draconium_sapling", () -> new BlockItem(OreCropBlocks.draconiumSapling.get(), GROUP));
	}

	public static void registerBotItem(){
		manasteelFruit = ITEMS.register("manasteel_fruit", OrdinaryItem::new);
		manasteelCropSeed = ITEMS.register("manasteel_crop_seed", () -> new ItemNameBlockItem(OreCropBlocks.manasteelCrop.get(), GROUP));
		manasteelLeaf = ITEMS.register("manasteel_leaf", () -> new BlockItem(OreCropBlocks.manasteelLeaf.get(), GROUP));
		manasteelSapling = ITEMS.register("manasteel_sapling", () -> new BlockItem(OreCropBlocks.manasteelSapling.get(), GROUP));
		terrasteelFruit = ITEMS.register("terrasteel_fruit", OrdinaryItem::new);
		terrasteelCropSeed = ITEMS.register("terrasteel_crop_seed", () -> new ItemNameBlockItem(OreCropBlocks.terrasteelCrop.get(), GROUP));
		terrasteelLeaf = ITEMS.register("terrasteel_leaf", () -> new BlockItem(OreCropBlocks.terrasteelLeaf.get(), GROUP));
		terrasteelSapling = ITEMS.register("terrasteel_sapling", () -> new BlockItem(OreCropBlocks.terrasteelSapling.get(), GROUP));
		elementiumFruit = ITEMS.register("elementium_fruit", OrdinaryItem::new);
		elementiumCropSeed = ITEMS.register("elementium_crop_seed", () -> new ItemNameBlockItem(OreCropBlocks.elementiumCrop.get(), GROUP));
		elementiumLeaf = ITEMS.register("elementium_leaf", () -> new BlockItem(OreCropBlocks.elementiumLeaf.get(), GROUP));
		elementiumSapling = ITEMS.register("elementium_sapling", () -> new BlockItem(OreCropBlocks.elementiumSapling.get(), GROUP));
		gaiaFruit = ITEMS.register("gaia_nugget", OrdinaryItem::new);
		gaiaFruit = ITEMS.register("gaia_fruit", OrdinaryItem::new);
		gaiaCropSeed = ITEMS.register("gaia_crop_seed", () -> new ItemNameBlockItem(OreCropBlocks.gaiaCrop.get(), GROUP));
		gaiaLeaf = ITEMS.register("gaia_leaf", () -> new BlockItem(OreCropBlocks.gaiaLeaf.get(), GROUP));
		gaiaSapling = ITEMS.register("gaia_sapling", () -> new BlockItem(OreCropBlocks.gaiaSapling.get(), GROUP));
	}
}
