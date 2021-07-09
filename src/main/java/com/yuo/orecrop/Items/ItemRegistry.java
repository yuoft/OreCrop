package com.yuo.orecrop.Items;

import com.yuo.orecrop.Blocks.BlockRegistry;
import com.yuo.orecrop.Items.OrdinaryItem;
import com.yuo.orecrop.OreCrop;
import com.yuo.orecrop.tab.ModGroup;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

//物品注册管理器
public class ItemRegistry {
	//创建注册器。ForgeRegistries.ITEMS代表了我们要注册的是物品，第二个参数填入的应该是你的modId。
	@SuppressWarnings("deprecation")
	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, OreCrop.MODID);
	public static final Item.Properties GROUP = new Item.Properties().group(ModGroup.myGroup);
	//注册物品。一个是「注册名」，还有一个就是你要注册对象的实例
	public static RegistryObject<Item> stemSeed = ITEMS.register("stem_seed", () -> {
		return new OrdinaryItem();
	});
	public static RegistryObject<Item> diamondNugget = ITEMS.register("diamond_nugget", () -> {
		return new OrdinaryItem();
	});
	public static RegistryObject<Item> emeraldNugget = ITEMS.register("emerald_nugget", () -> {
		return new OrdinaryItem();
	});
	public static RegistryObject<Item> lapisNugget = ITEMS.register("lapis_nugget", () -> {
		return new OrdinaryItem();
	});
	public static RegistryObject<Item> coalNugget = ITEMS.register("coal_nugget", () -> {
		return new OrdinaryItem();
	});
	public static RegistryObject<Item> quartzNugget = ITEMS.register("quartz_nugget", () -> {
		return new OrdinaryItem();
	});
	public static RegistryObject<Item> redstoneNugget = ITEMS.register("redstone_nugget", () -> {
		return new OrdinaryItem();
	});
	public static RegistryObject<Item> coalFruit = ITEMS.register("coal_fruit", () -> {
		return new OrdinaryItem();
	});
	public static RegistryObject<Item> diamondFruit = ITEMS.register("diamond_fruit", () -> {
		return new OrdinaryItem();
	});
	public static RegistryObject<Item> emeraldFruit = ITEMS.register("emerald_fruit", () -> {
		return new OrdinaryItem();
	});
	public static RegistryObject<Item> goldFruit = ITEMS.register("gold_fruit", () -> {
		return new OrdinaryItem();
	});
	public static RegistryObject<Item> ironFruit = ITEMS.register("iron_fruit", () -> {
		return new OrdinaryItem();
	});
	public static RegistryObject<Item> lapisFruit = ITEMS.register("lapis_fruit", () -> {
		return new OrdinaryItem();
	});
	public static RegistryObject<Item> quartzFruit = ITEMS.register("quartz_fruit", () -> {
		return new OrdinaryItem();
	});
	public static RegistryObject<Item> redstoneFruit = ITEMS.register("redstone_fruit", () -> {
		return new OrdinaryItem();
	});
	public static RegistryObject<Item> cropSeed = ITEMS.register("crop_seed", () -> {
		return new OrdinaryItem();
	});
	public static RegistryObject<Item> oreSapling = ITEMS.register("ore_sapling", () -> {
		return new OrdinaryItem();
	});

	//注册方块物品
	public static RegistryObject<BlockItem> coalLeanOre = ITEMS.register("coal_lean_ore", () ->{
		return new BlockItem(BlockRegistry.coalLeanOre.get(), GROUP);
	});
	public static RegistryObject<BlockItem> diamondLeanOre = ITEMS.register("diamond_lean_ore", () ->{
		return new BlockItem(BlockRegistry.diamondLeanOre.get(), GROUP);
	});
	public static RegistryObject<BlockItem> emeraldLeanOre = ITEMS.register("emerald_lean_ore", () ->{
		return new BlockItem(BlockRegistry.emeraldLeanOre.get(), GROUP);
	});
	public static RegistryObject<BlockItem> goldLeanOre = ITEMS.register("gold_lean_ore", () ->{
		return new BlockItem(BlockRegistry.goldLeanOre.get(), GROUP);
	});
	public static RegistryObject<BlockItem> ironLeanOre = ITEMS.register("iron_lean_ore", () ->{
		return new BlockItem(BlockRegistry.ironLeanOre.get(), GROUP);
	});
	public static RegistryObject<BlockItem> lapisLeanOre = ITEMS.register("lapis_lean_ore", () ->{
		return new BlockItem(BlockRegistry.lapisLeanOre.get(), GROUP);
	});
	public static RegistryObject<BlockItem> quartzLeanOre = ITEMS.register("quartz_lean_ore", () ->{
		return new BlockItem(BlockRegistry.quartzLeanOre.get(), GROUP);
	});
	public static RegistryObject<BlockItem> redstoneLeanOre = ITEMS.register("redstone_lean_ore", () ->{
		return new BlockItem(BlockRegistry.redstoneLeanOre.get(), GROUP);
	});
	//茎作物种子
	public static RegistryObject<BlockItem> coalStemSeed = ITEMS.register("coal_stem_seed", () ->{
		return new BlockItem(BlockRegistry.coalStem.get(), GROUP);
	});
	public static RegistryObject<BlockItem> diamondStemSeed = ITEMS.register("diamond_stem_seed", () ->{
		return new BlockItem(BlockRegistry.diamondStem.get(), GROUP);
	});
	public static RegistryObject<BlockItem> emeraldStemSeed = ITEMS.register("emerald_stem_seed", () ->{
		return new BlockItem(BlockRegistry.emeraldStem.get(), GROUP);
	});
	public static RegistryObject<BlockItem> goldStemSeed = ITEMS.register("gold_stem_seed", () ->{
		return new BlockItem(BlockRegistry.goldStem.get(), GROUP);
	});
	public static RegistryObject<BlockItem> ironStemSeed = ITEMS.register("iron_stem_seed", () ->{
		return new BlockItem(BlockRegistry.ironStem.get(), GROUP);
	});
	public static RegistryObject<BlockItem> lapisStemSeed = ITEMS.register("lapis_stem_seed", () ->{
		return new BlockItem(BlockRegistry.lapisStem.get(), GROUP);
	});
	public static RegistryObject<BlockItem> quartzStemSeed = ITEMS.register("quartz_stem_seed", () ->{
		return new BlockItem(BlockRegistry.quartzStem.get(), GROUP);
	});
	public static RegistryObject<BlockItem> redstoneStemSeed = ITEMS.register("redstone_stem_seed", () ->{
		return new BlockItem(BlockRegistry.redstoneStem.get(), GROUP);
	});
	//普通作物种子
	public static RegistryObject<BlockItem> coalCropSeed = ITEMS.register("coal_crop_seed", () ->{
		return new BlockItem(BlockRegistry.coalCrop.get(), GROUP);
	});
	public static RegistryObject<BlockItem> diamondCropSeed = ITEMS.register("diamond_crop_seed", () ->{
		return new BlockItem(BlockRegistry.diamondCrop.get(), GROUP);
	});
	public static RegistryObject<BlockItem> emeraldCropSeed = ITEMS.register("emerald_crop_seed", () ->{
		return new BlockItem(BlockRegistry.emeraldCrop.get(), GROUP);
	});
	public static RegistryObject<BlockItem> goldCropSeed = ITEMS.register("gold_crop_seed", () ->{
		return new BlockItem(BlockRegistry.goldCrop.get(), GROUP);
	});
	public static RegistryObject<BlockItem> ironCropSeed = ITEMS.register("iron_crop_seed", () ->{
		return new BlockItem(BlockRegistry.ironCrop.get(), GROUP);
	});
	public static RegistryObject<BlockItem> lapisCropSeed = ITEMS.register("lapis_crop_seed", () ->{
		return new BlockItem(BlockRegistry.lapisCrop.get(), GROUP);
	});
	public static RegistryObject<BlockItem> quartzCropSeed = ITEMS.register("quartz_crop_seed", () ->{
		return new BlockItem(BlockRegistry.quartzCrop.get(), GROUP);
	});
	public static RegistryObject<BlockItem> redstoneCropSeed = ITEMS.register("redstone_crop_seed", () ->{
		return new BlockItem(BlockRegistry.redstoneCrop.get(), GROUP);
	});

	//矿石树
	public static RegistryObject<BlockItem> oreLog = ITEMS.register("ore_log", () ->{
		return new BlockItem(BlockRegistry.oreLog.get(), GROUP);
	});
	public static RegistryObject<BlockItem> coalLeaf = ITEMS.register("coal_leaf", () ->{
		return new BlockItem(BlockRegistry.coalLeaf.get(), GROUP);
	});
	public static RegistryObject<BlockItem> coalSapling = ITEMS.register("coal_sapling", () ->{
		return new BlockItem(BlockRegistry.coalSapling.get(), GROUP);
	});
	public static RegistryObject<BlockItem> diamondLeaf = ITEMS.register("diamond_leaf", () ->{
		return new BlockItem(BlockRegistry.diamondLeaf.get(), GROUP);
	});
	public static RegistryObject<BlockItem> diamondSapling = ITEMS.register("diamond_sapling", () ->{
		return new BlockItem(BlockRegistry.diamondSapling.get(), GROUP);
	});
	public static RegistryObject<BlockItem> emeraldLeaf = ITEMS.register("emerald_leaf", () ->{
		return new BlockItem(BlockRegistry.emeraldLeaf.get(), GROUP);
	});
	public static RegistryObject<BlockItem> emeraldSapling = ITEMS.register("emerald_sapling", () ->{
		return new BlockItem(BlockRegistry.emeraldSapling.get(), GROUP);
	});
	public static RegistryObject<BlockItem> goldLeaf = ITEMS.register("gold_leaf", () ->{
		return new BlockItem(BlockRegistry.goldLeaf.get(), GROUP);
	});
	public static RegistryObject<BlockItem> goldSapling = ITEMS.register("gold_sapling", () ->{
		return new BlockItem(BlockRegistry.goldSapling.get(), GROUP);
	});
	public static RegistryObject<BlockItem> ironLeaf = ITEMS.register("iron_leaf", () ->{
		return new BlockItem(BlockRegistry.ironLeaf.get(), GROUP);
	});
	public static RegistryObject<BlockItem> ironSapling = ITEMS.register("iron_sapling", () ->{
		return new BlockItem(BlockRegistry.ironSapling.get(), GROUP);
	});
	public static RegistryObject<BlockItem> lapisLeaf = ITEMS.register("lapis_leaf", () ->{
		return new BlockItem(BlockRegistry.lapisLeaf.get(), GROUP);
	});
	public static RegistryObject<BlockItem> lapisSapling = ITEMS.register("lapis_sapling", () ->{
		return new BlockItem(BlockRegistry.lapisSapling.get(), GROUP);
	});
	public static RegistryObject<BlockItem> quartzLeaf = ITEMS.register("quartz_leaf", () ->{
		return new BlockItem(BlockRegistry.quartzLeaf.get(), GROUP);
	});
	public static RegistryObject<BlockItem> quartzSapling = ITEMS.register("quartz_sapling", () ->{
		return new BlockItem(BlockRegistry.quartzSapling.get(), GROUP);
	});
	public static RegistryObject<BlockItem> redstoneldLeaf = ITEMS.register("redstone_leaf", () ->{
		return new BlockItem(BlockRegistry.redstoneLeaf.get(), GROUP);
	});
	public static RegistryObject<BlockItem> redstoneSapling = ITEMS.register("redstone_sapling", () ->{
		return new BlockItem(BlockRegistry.redstoneSapling.get(), GROUP);
	});
}
