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
	public static RegistryObject<Item> crop_seed = ITEMS.register("crop_seed", () -> {
		return new OrdinaryItem();
	});

	//注册方块物品
	public static RegistryObject<BlockItem> coalLeanOre = ITEMS.register("coal_lean_ore", () ->{
		return new BlockItem(BlockRegistry.coalLeanOre.get(), new Item.Properties().group(ModGroup.myGroup));
	});
	public static RegistryObject<BlockItem> diamondLeanOre = ITEMS.register("diamond_lean_ore", () ->{
		return new BlockItem(BlockRegistry.diamondLeanOre.get(), new Item.Properties().group(ModGroup.myGroup));
	});
	public static RegistryObject<BlockItem> emeraldLeanOre = ITEMS.register("emerald_lean_ore", () ->{
		return new BlockItem(BlockRegistry.emeraldLeanOre.get(), new Item.Properties().group(ModGroup.myGroup));
	});
	public static RegistryObject<BlockItem> goldLeanOre = ITEMS.register("gold_lean_ore", () ->{
		return new BlockItem(BlockRegistry.goldLeanOre.get(), new Item.Properties().group(ModGroup.myGroup));
	});
	public static RegistryObject<BlockItem> ironLeanOre = ITEMS.register("iron_lean_ore", () ->{
		return new BlockItem(BlockRegistry.ironLeanOre.get(), new Item.Properties().group(ModGroup.myGroup));
	});
	public static RegistryObject<BlockItem> lapisLeanOre = ITEMS.register("lapis_lean_ore", () ->{
		return new BlockItem(BlockRegistry.lapisLeanOre.get(), new Item.Properties().group(ModGroup.myGroup));
	});
	public static RegistryObject<BlockItem> quartzLeanOre = ITEMS.register("quartz_lean_ore", () ->{
		return new BlockItem(BlockRegistry.quartzLeanOre.get(), new Item.Properties().group(ModGroup.myGroup));
	});
	public static RegistryObject<BlockItem> redstoneLeanOre = ITEMS.register("redstone_lean_ore", () ->{
		return new BlockItem(BlockRegistry.redstoneLeanOre.get(), new Item.Properties().group(ModGroup.myGroup));
	});
	//茎作物种子
	public static RegistryObject<BlockItem> coalStemSeed = ITEMS.register("coal_stem_seed", () ->{
		return new BlockItem(BlockRegistry.coalStem.get(), new Item.Properties().group(ModGroup.myGroup));
	});
	public static RegistryObject<BlockItem> diamondStemSeed = ITEMS.register("diamond_stem_seed", () ->{
		return new BlockItem(BlockRegistry.diamondStem.get(), new Item.Properties().group(ModGroup.myGroup));
	});
	public static RegistryObject<BlockItem> emeraldStemSeed = ITEMS.register("emerald_stem_seed", () ->{
		return new BlockItem(BlockRegistry.emeraldStem.get(), new Item.Properties().group(ModGroup.myGroup));
	});
	public static RegistryObject<BlockItem> goldStemSeed = ITEMS.register("gold_stem_seed", () ->{
		return new BlockItem(BlockRegistry.goldStem.get(), new Item.Properties().group(ModGroup.myGroup));
	});
	public static RegistryObject<BlockItem> ironStemSeed = ITEMS.register("iron_stem_seed", () ->{
		return new BlockItem(BlockRegistry.ironStem.get(), new Item.Properties().group(ModGroup.myGroup));
	});
	public static RegistryObject<BlockItem> lapisStemSeed = ITEMS.register("lapis_stem_seed", () ->{
		return new BlockItem(BlockRegistry.lapisStem.get(), new Item.Properties().group(ModGroup.myGroup));
	});
	public static RegistryObject<BlockItem> quartzStemSeed = ITEMS.register("quartz_stem_seed", () ->{
		return new BlockItem(BlockRegistry.quartzStem.get(), new Item.Properties().group(ModGroup.myGroup));
	});
	public static RegistryObject<BlockItem> redstoneStemSeed = ITEMS.register("redstone_stem_seed", () ->{
		return new BlockItem(BlockRegistry.redstoneStem.get(), new Item.Properties().group(ModGroup.myGroup));
	});
	//普通作物种子
	public static RegistryObject<BlockItem> coalCropSeed = ITEMS.register("coal_crop_seed", () ->{
		return new BlockItem(BlockRegistry.coalCrop.get(), new Item.Properties().group(ModGroup.myGroup));
	});
	public static RegistryObject<BlockItem> diamondCropSeed = ITEMS.register("diamond_crop_seed", () ->{
		return new BlockItem(BlockRegistry.diamondCrop.get(), new Item.Properties().group(ModGroup.myGroup));
	});
	public static RegistryObject<BlockItem> emeraldCropSeed = ITEMS.register("emerald_crop_seed", () ->{
		return new BlockItem(BlockRegistry.emeraldCrop.get(), new Item.Properties().group(ModGroup.myGroup));
	});
	public static RegistryObject<BlockItem> goldCropSeed = ITEMS.register("gold_crop_seed", () ->{
		return new BlockItem(BlockRegistry.goldCrop.get(), new Item.Properties().group(ModGroup.myGroup));
	});
	public static RegistryObject<BlockItem> ironCropSeed = ITEMS.register("iron_crop_seed", () ->{
		return new BlockItem(BlockRegistry.ironCrop.get(), new Item.Properties().group(ModGroup.myGroup));
	});
	public static RegistryObject<BlockItem> lapisCropSeed = ITEMS.register("lapis_crop_seed", () ->{
		return new BlockItem(BlockRegistry.lapisCrop.get(), new Item.Properties().group(ModGroup.myGroup));
	});
	public static RegistryObject<BlockItem> quartzCropSeed = ITEMS.register("quartz_crop_seed", () ->{
		return new BlockItem(BlockRegistry.quartzCrop.get(), new Item.Properties().group(ModGroup.myGroup));
	});
	public static RegistryObject<BlockItem> redstoneCropSeed = ITEMS.register("redstone_crop_seed", () ->{
		return new BlockItem(BlockRegistry.redstoneCrop.get(), new Item.Properties().group(ModGroup.myGroup));
	});
}
