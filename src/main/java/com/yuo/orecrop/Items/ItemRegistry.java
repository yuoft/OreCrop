package com.yuo.orecrop.Items;

import com.yuo.orecrop.Blocks.BlockRegistry;
import com.yuo.orecrop.OreCrop;
import com.yuo.orecrop.tab.ModGroup;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

//物品注册管理器
public class ItemRegistry {
	//创建注册器。ForgeRegistries.ITEMS代表了我们要注册的是物品，第二个参数填入的应该是你的modId。
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, OreCrop.MODID);
	public static final Item.Properties GROUP = new Item.Properties().group(ModGroup.myGroup);
	//注册物品。一个是「注册名」，还有一个就是你要注册对象的实例
	public static RegistryObject<Item> voidSeed = ITEMS.register("void_seed", OrdinaryItem::new);
	public static RegistryObject<Item> diamondNugget = ITEMS.register("diamond_nugget", OrdinaryItem::new);
	public static RegistryObject<Item> emeraldNugget = ITEMS.register("emerald_nugget", OrdinaryItem::new);
	public static RegistryObject<Item> lapisNugget = ITEMS.register("lapis_nugget", OrdinaryItem::new);
	public static RegistryObject<Item> coalNugget = ITEMS.register("coal_nugget", OrdinaryItem::new);
	public static RegistryObject<Item> quartzNugget = ITEMS.register("quartz_nugget", OrdinaryItem::new);
	public static RegistryObject<Item> redstoneNugget = ITEMS.register("redstone_nugget", OrdinaryItem::new);
	public static RegistryObject<Item> netheriteNugget = ITEMS.register("netherite_nugget", OrdinaryItem::new);
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
			() -> new CustomSapling(BlockRegistry.customSapling.get(), GROUP));

	//普通作物种子
	public static RegistryObject<BlockItem> coalCropSeed = ITEMS.register("coal_crop_seed",
			() -> new BlockNamedItem(BlockRegistry.coalCrop.get(), GROUP));
	public static RegistryObject<BlockItem> diamondCropSeed = ITEMS.register("diamond_crop_seed",
			() -> new BlockNamedItem(BlockRegistry.diamondCrop.get(), GROUP));
	public static RegistryObject<BlockItem> emeraldCropSeed = ITEMS.register("emerald_crop_seed",
			() -> new BlockNamedItem(BlockRegistry.emeraldCrop.get(), GROUP));
	public static RegistryObject<BlockItem> goldCropSeed = ITEMS.register("gold_crop_seed",
			() -> new BlockNamedItem(BlockRegistry.goldCrop.get(), GROUP));
	public static RegistryObject<BlockItem> ironCropSeed = ITEMS.register("iron_crop_seed",
			() -> new BlockNamedItem(BlockRegistry.ironCrop.get(), GROUP));
	public static RegistryObject<BlockItem> lapisCropSeed = ITEMS.register("lapis_crop_seed",
			() -> new BlockNamedItem(BlockRegistry.lapisCrop.get(), GROUP));
	public static RegistryObject<BlockItem> quartzCropSeed = ITEMS.register("quartz_crop_seed",
			() -> new BlockNamedItem(BlockRegistry.quartzCrop.get(), GROUP));
	public static RegistryObject<BlockItem> redstoneCropSeed = ITEMS.register("redstone_crop_seed",
			() -> new BlockNamedItem(BlockRegistry.redstoneCrop.get(), GROUP));
	public static RegistryObject<BlockItem> netheriteCropSeed = ITEMS.register("netherite_crop_seed",
			() -> new BlockNamedItem(BlockRegistry.netheriteCrop.get(), GROUP));

	//矿石树
	public static RegistryObject<BlockItem> oreLog = ITEMS.register("ore_log",
			() -> new BlockItem(BlockRegistry.oreLog.get(), GROUP));
	public static RegistryObject<BlockItem> coalLeaf = ITEMS.register("coal_leaf",
			() -> new BlockItem(BlockRegistry.coalLeaf.get(), GROUP));
	public static RegistryObject<BlockItem> coalSapling = ITEMS.register("coal_sapling",
			() -> new BlockItem(BlockRegistry.coalSapling.get(), GROUP));
	public static RegistryObject<BlockItem> diamondLeaf = ITEMS.register("diamond_leaf",
			() -> new BlockItem(BlockRegistry.diamondLeaf.get(), GROUP));
	public static RegistryObject<BlockItem> diamondSapling = ITEMS.register("diamond_sapling",
			() -> new BlockItem(BlockRegistry.diamondSapling.get(), GROUP));
	public static RegistryObject<BlockItem> emeraldLeaf = ITEMS.register("emerald_leaf",
			() -> new BlockItem(BlockRegistry.emeraldLeaf.get(), GROUP));
	public static RegistryObject<BlockItem> emeraldSapling = ITEMS.register("emerald_sapling",
			() -> new BlockItem(BlockRegistry.emeraldSapling.get(), GROUP));
	public static RegistryObject<BlockItem> goldLeaf = ITEMS.register("gold_leaf",
			() -> new BlockItem(BlockRegistry.goldLeaf.get(), GROUP));
	public static RegistryObject<BlockItem> goldSapling = ITEMS.register("gold_sapling",
			() -> new BlockItem(BlockRegistry.goldSapling.get(), GROUP));
	public static RegistryObject<BlockItem> ironLeaf = ITEMS.register("iron_leaf",
			() -> new BlockItem(BlockRegistry.ironLeaf.get(), GROUP));
	public static RegistryObject<BlockItem> ironSapling = ITEMS.register("iron_sapling",
			() -> new BlockItem(BlockRegistry.ironSapling.get(), GROUP));
	public static RegistryObject<BlockItem> lapisLeaf = ITEMS.register("lapis_leaf",
			() -> new BlockItem(BlockRegistry.lapisLeaf.get(), GROUP));
	public static RegistryObject<BlockItem> lapisSapling = ITEMS.register("lapis_sapling",
			() -> new BlockItem(BlockRegistry.lapisSapling.get(), GROUP));
	public static RegistryObject<BlockItem> quartzLeaf = ITEMS.register("quartz_leaf",
			() -> new BlockItem(BlockRegistry.quartzLeaf.get(), GROUP));
	public static RegistryObject<BlockItem> quartzSapling = ITEMS.register("quartz_sapling",
			() -> new BlockItem(BlockRegistry.quartzSapling.get(), GROUP));
	public static RegistryObject<BlockItem> redstoneldLeaf = ITEMS.register("redstone_leaf",
			() -> new BlockItem(BlockRegistry.redstoneLeaf.get(), GROUP));
	public static RegistryObject<BlockItem> redstoneSapling = ITEMS.register("redstone_sapling",
			() -> new BlockItem(BlockRegistry.redstoneSapling.get(), GROUP));
	public static RegistryObject<BlockItem> netheriteLeaf = ITEMS.register("netherite_leaf",
			() -> new BlockItem(BlockRegistry.netheriteLeaf.get(), GROUP));
	public static RegistryObject<BlockItem> netheriteSapling = ITEMS.register("netherite_sapling",
			() -> new BlockItem(BlockRegistry.netheriteSapling.get(), GROUP));

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
	public static RegistryObject<Item> copperFruit;
	public static RegistryObject<BlockItem> copperCropSeed;
	public static RegistryObject<BlockItem> copperLeaf;
	public static RegistryObject<BlockItem> copperSapling;

	public static void registerSpaceArmsItem(){
		rubyNugget = ITEMS.register("ruby_nugget", OrdinaryItem::new);
		rubyFruit = ITEMS.register("ruby_fruit", OrdinaryItem::new);
		rubyCropSeed = ITEMS.register("ruby_crop_seed", () -> new BlockNamedItem(BlockRegistry.rubyCrop.get(), GROUP));
		rubyLeaf = ITEMS.register("ruby_leaf", () -> new BlockItem(BlockRegistry.rubyLeaf.get(), GROUP));
		rubySapling = ITEMS.register("ruby_sapling", () -> new BlockItem(BlockRegistry.rubySapling.get(), GROUP));
		dragonNugget = ITEMS.register("dragon_nugget", OrdinaryItem::new);
		dragonFruit = ITEMS.register("dragon_fruit", OrdinaryItem::new);
		dragonCropSeed = ITEMS.register("dragon_crop_seed", () -> new BlockNamedItem(BlockRegistry.dragonCrop.get(), GROUP));
		dragonLeaf = ITEMS.register("dragon_leaf", () -> new BlockItem(BlockRegistry.dragonLeaf.get(), GROUP));
		dragonSapling = ITEMS.register("dragon_sapling", () -> new BlockItem(BlockRegistry.dragonSapling.get(), GROUP));
		xrayNugget = ITEMS.register("xray_nugget", OrdinaryItem::new);
		xrayFruit = ITEMS.register("xray_fruit", OrdinaryItem::new);
		xrayCropSeed = ITEMS.register("xray_crop_seed", () -> new BlockNamedItem(BlockRegistry.xrayCrop.get(), GROUP));
		xrayLeaf = ITEMS.register("xray_leaf", () -> new BlockItem(BlockRegistry.xrayLeaf.get(), GROUP));
		xraySapling = ITEMS.register("xray_sapling", () -> new BlockItem(BlockRegistry.xraySapling.get(), GROUP));
		superNugget = ITEMS.register("super_nugget", OrdinaryItem::new);
		superFruit = ITEMS.register("super_fruit", OrdinaryItem::new);
		superCropSeed = ITEMS.register("super_crop_seed", () -> new BlockNamedItem(BlockRegistry.superCrop.get(), GROUP));
		superLeaf = ITEMS.register("super_leaf", () -> new BlockItem(BlockRegistry.superLeaf.get(), GROUP));
		superSapling = ITEMS.register("super_sapling", () -> new BlockItem(BlockRegistry.superSapling.get(), GROUP));
		spaceNugget = ITEMS.register("space_nugget", OrdinaryItem::new);
		spaceFruit = ITEMS.register("space_fruit", OrdinaryItem::new);
		spaceCropSeed = ITEMS.register("space_crop_seed", () -> new BlockNamedItem(BlockRegistry.spaceCrop.get(), GROUP));
		spaceLeaf = ITEMS.register("space_leaf", () -> new BlockItem(BlockRegistry.spaceLeaf.get(), GROUP));
		spaceSapling = ITEMS.register("space_sapling", () -> new BlockItem(BlockRegistry.spaceSapling.get(), GROUP));
	}

	public static void registerIafItem(){
		silverFruit = ITEMS.register("silver_fruit", OrdinaryItem::new);
		silverCropSeed = ITEMS.register("silver_crop_seed", () -> new BlockNamedItem(BlockRegistry.silverCrop.get(), GROUP));
		silverLeaf = ITEMS.register("silver_leaf", () -> new BlockItem(BlockRegistry.silverLeaf.get(), GROUP));
		silverSapling = ITEMS.register("silver_sapling", () -> new BlockItem(BlockRegistry.silverSapling.get(), GROUP));
		copperFruit = ITEMS.register("copper_fruit", OrdinaryItem::new);
		copperCropSeed = ITEMS.register("copper_crop_seed", () -> new BlockNamedItem(BlockRegistry.copperCrop.get(), GROUP));
		copperLeaf = ITEMS.register("copper_leaf", () -> new BlockItem(BlockRegistry.copperLeaf.get(), GROUP));
		copperSapling = ITEMS.register("copper_sapling", () -> new BlockItem(BlockRegistry.copperSapling.get(), GROUP));
	}
}
