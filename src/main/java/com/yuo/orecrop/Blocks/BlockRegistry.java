package com.yuo.orecrop.Blocks;

import com.yuo.orecrop.Blocks.Crop.OreCropBlock;
import com.yuo.orecrop.Blocks.Tree.ModTrees;
import com.yuo.orecrop.Blocks.Tree.OreSapling;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

//方块注册
public class BlockRegistry {
	//同物品
	@SuppressWarnings("deprecation")
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, com.yuo.orecrop.OreCrop.MODID);
	private static final Block.Properties STEM = Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.0f).tickRandomly().sound(SoundType.PLANT)
				.doesNotBlockMovement();
    public static final Block.Properties LOG = Block.Properties.from(Blocks.BIRCH_LOG); //树干
    public static final Block.Properties LEAF = Block.Properties.from(Blocks.BIRCH_LEAVES); //树叶
    public static final Block.Properties SAPLING = Block.Properties.from(Blocks.BIRCH_SAPLING); //树苗

    //普通作物
    public static RegistryObject<Block> coalCrop = BLOCKS.register("coal_crop", () -> new OreCropBlock(STEM));
    public static RegistryObject<Block> diamondCrop = BLOCKS.register("diamond_crop", () -> new OreCropBlock(STEM));
    public static RegistryObject<Block> emeraldCrop = BLOCKS.register("emerald_crop", () -> new OreCropBlock(STEM));
    public static RegistryObject<Block> goldCrop = BLOCKS.register("gold_crop", () -> new OreCropBlock(STEM));
    public static RegistryObject<Block> ironCrop = BLOCKS.register("iron_crop", () -> new OreCropBlock(STEM));
    public static RegistryObject<Block> lapisCrop = BLOCKS.register("lapis_crop", () -> new OreCropBlock(STEM));
    public static RegistryObject<Block> quartzCrop = BLOCKS.register("quartz_crop", () -> new OreCropBlock(STEM));
    public static RegistryObject<Block> redstoneCrop = BLOCKS.register("redstone_crop", () -> new OreCropBlock(STEM));
    public static RegistryObject<Block> netheriteCrop = BLOCKS.register("netherite_crop", () -> new OreCropBlock(STEM));

    //树木
    public static RegistryObject<Block> oreLog = BLOCKS.register("ore_log", () -> new RotatedPillarBlock(LOG));
    public static RegistryObject<Block> coalLeaf = BLOCKS.register("coal_leaf", () -> new LeavesBlock(LEAF));
    public static RegistryObject<Block> coalSapling = BLOCKS.register("coal_sapling",
            () -> new OreSapling(new ModTrees.CoalTree(), SAPLING));
    public static RegistryObject<Block> diamondLeaf = BLOCKS.register("diamond_leaf", () -> new LeavesBlock(LEAF));
    public static RegistryObject<Block> diamondSapling = BLOCKS.register("diamond_sapling",
            () -> new OreSapling(new ModTrees.DiamondTree(), SAPLING));
    public static RegistryObject<Block> emeraldLeaf = BLOCKS.register("emerald_leaf", () -> new LeavesBlock(LEAF));
    public static RegistryObject<Block> emeraldSapling = BLOCKS.register("emerald_sapling",
            () -> new OreSapling(new ModTrees.EmeraldTree(), SAPLING));
    public static RegistryObject<Block> goldLeaf = BLOCKS.register("gold_leaf", () -> new LeavesBlock(LEAF));
    public static RegistryObject<Block> goldSapling = BLOCKS.register("gold_sapling",
            () -> new OreSapling(new ModTrees.GoldTree(), SAPLING));
    public static RegistryObject<Block> ironLeaf = BLOCKS.register("iron_leaf", () -> new LeavesBlock(LEAF));
    public static RegistryObject<Block> ironSapling = BLOCKS.register("iron_sapling",
            () -> new OreSapling(new ModTrees.IronTree(), SAPLING));
    public static RegistryObject<Block> lapisLeaf = BLOCKS.register("lapis_leaf", () -> new LeavesBlock(LEAF));
    public static RegistryObject<Block> lapisSapling = BLOCKS.register("lapis_sapling",
            () -> new OreSapling(new ModTrees.LapisTree(), SAPLING));
    public static RegistryObject<Block> quartzLeaf = BLOCKS.register("quartz_leaf", () -> new LeavesBlock(LEAF));
    public static RegistryObject<Block> quartzSapling = BLOCKS.register("quartz_sapling",
            () -> new OreSapling(new ModTrees.QuartzTree(), SAPLING));
    public static RegistryObject<Block> redstoneLeaf = BLOCKS.register("redstone_leaf", () -> new LeavesBlock(LEAF));
    public static RegistryObject<Block> redstoneSapling = BLOCKS.register("redstone_sapling",
            () -> new OreSapling(new ModTrees.RedstoneTree(), SAPLING));
    public static RegistryObject<Block> netheriteLeaf = BLOCKS.register("netherite_leaf", () -> new LeavesBlock(LEAF));
    public static RegistryObject<Block> netheriteSapling = BLOCKS.register("netherite_sapling",
            () -> new OreSapling(new ModTrees.NetheriteTree(), SAPLING));

    public static RegistryObject<Block> rubyCrop;
    public static RegistryObject<Block> dragonCrop;
    public static RegistryObject<Block> xrayCrop;
    public static RegistryObject<Block> superCrop;
    public static RegistryObject<Block> spaceCrop;
    public static RegistryObject<Block> silverCrop;
    public static RegistryObject<Block> copperCrop;
    public static RegistryObject<Block> rubyLeaf;
    public static RegistryObject<Block> rubySapling;
    public static RegistryObject<Block> dragonLeaf;
    public static RegistryObject<Block> dragonSapling;
    public static RegistryObject<Block> xrayLeaf;
    public static RegistryObject<Block> xraySapling;
    public static RegistryObject<Block> superLeaf;
    public static RegistryObject<Block> superSapling;
    public static RegistryObject<Block> spaceLeaf;
    public static RegistryObject<Block> spaceSapling;
    public static RegistryObject<Block> silverLeaf;
    public static RegistryObject<Block> silverSapling;
    public static RegistryObject<Block> copperLeaf;
    public static RegistryObject<Block> copperSapling;

    public static void registerSpaceArmsItem(){
        rubyCrop = BLOCKS.register("ruby_crop", () -> new OreCropBlock(STEM));
        dragonCrop = BLOCKS.register("dragon_crop", () -> new OreCropBlock(STEM));
        xrayCrop = BLOCKS.register("xray_crop", () -> new OreCropBlock(STEM));
        superCrop = BLOCKS.register("super_crop", () -> new OreCropBlock(STEM));
        spaceCrop = BLOCKS.register("space_crop", () -> new OreCropBlock(STEM));
        rubyLeaf = BLOCKS.register("ruby_leaf", () -> new LeavesBlock(LEAF));
        rubySapling = BLOCKS.register("ruby_sapling", () -> new OreSapling(new ModTrees.RubyTree(), SAPLING));
        dragonLeaf = BLOCKS.register("dragon_leaf", () -> new LeavesBlock(LEAF));
        dragonSapling = BLOCKS.register("dragon_sapling", () -> new OreSapling(new ModTrees.DragonTree(), SAPLING));
        xrayLeaf = BLOCKS.register("xray_leaf", () -> new LeavesBlock(LEAF));
        xraySapling = BLOCKS.register("xray_sapling", () -> new OreSapling(new ModTrees.XrayTree(), SAPLING));
        superLeaf = BLOCKS.register("super_leaf", () -> new LeavesBlock(LEAF));
        superSapling = BLOCKS.register("super_sapling", () -> new OreSapling(new ModTrees.SuperTree(), SAPLING));
        spaceLeaf = BLOCKS.register("space_leaf", () -> new LeavesBlock(LEAF));
        spaceSapling = BLOCKS.register("space_sapling", () -> new OreSapling(new ModTrees.SpaceTree(), SAPLING));
    }

    public static void registerIafItem(){
        silverCrop = BLOCKS.register("silver_crop", () -> new OreCropBlock(STEM));
        copperCrop = BLOCKS.register("copper_crop", () -> new OreCropBlock(STEM));
        silverLeaf = BLOCKS.register("silver_leaf", () -> new LeavesBlock(LEAF));
        silverSapling = BLOCKS.register("silver_sapling", () -> new OreSapling(new ModTrees.SilverTree(), SAPLING));
        copperLeaf = BLOCKS.register("copper_leaf", () -> new LeavesBlock(LEAF));
        copperSapling = BLOCKS.register("copper_sapling", () -> new OreSapling(new ModTrees.CopperTree(), SAPLING));
    }
}
