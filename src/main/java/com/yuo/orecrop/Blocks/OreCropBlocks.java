package com.yuo.orecrop.Blocks;

import com.yuo.orecrop.Blocks.Crop.OreCropBlock;
import com.yuo.orecrop.Blocks.Tree.CustomSapling;
import com.yuo.orecrop.Blocks.Tree.ModTrees;
import com.yuo.orecrop.Blocks.Tree.OreSapling;
import com.yuo.orecrop.OreCrop;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

//方块注册
public class OreCropBlocks {
	//同物品
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, OreCrop.MOD_ID);
	private static final Block.Properties STEM = Block.Properties.of().mapColor(MapColor.PLANT).strength(0.0f).randomTicks().sound(SoundType.PINK_PETALS)
            .noCollission().pushReaction(PushReaction.DESTROY);
    //      无碰撞 活塞破坏
    public static final Block.Properties LOG = Block.Properties.copy(Blocks.BIRCH_LOG); //树干
    public static final Block.Properties LEAF = Block.Properties.copy(Blocks.BIRCH_LEAVES); //树叶
    public static final Block.Properties SAPLING = Block.Properties.copy(Blocks.BIRCH_SAPLING); //树苗

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

    public static RegistryObject<Block> customSapling = BLOCKS.register("custom_sapling", CustomSapling::new);

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
    public static RegistryObject<Block> copperCrop = BLOCKS.register("copper_crop", () -> new OreCropBlock(STEM));

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
    public static RegistryObject<Block> copperLeaf = BLOCKS.register("copper_leaf", () -> new LeavesBlock(LEAF));
    public static RegistryObject<Block> copperSapling = BLOCKS.register("copper_sapling", () -> new OreSapling(new ModTrees.CopperTree(), SAPLING));

    public static RegistryObject<Block> awakenedDraconiumCrop;
    public static RegistryObject<Block> awakenedDraconiumLeaf;
    public static RegistryObject<Block> awakenedDraconiumSapling;
    public static RegistryObject<Block> draconiumCrop;
    public static RegistryObject<Block> draconiumLeaf;
    public static RegistryObject<Block> draconiumSapling;

    public static RegistryObject<Block> manasteelCrop;
    public static RegistryObject<Block> manasteelLeaf;
    public static RegistryObject<Block> manasteelSapling;
    public static RegistryObject<Block> terrasteelCrop;
    public static RegistryObject<Block> terrasteelLeaf;
    public static RegistryObject<Block> terrasteelSapling;
    public static RegistryObject<Block> elementiumCrop;
    public static RegistryObject<Block> elementiumLeaf;
    public static RegistryObject<Block> elementiumSapling;
    public static RegistryObject<Block> gaiaCrop;
    public static RegistryObject<Block> gaiaLeaf;
    public static RegistryObject<Block> gaiaSapling;

    public static void registerSpaceArmsBlock(){
        rubyCrop = BLOCKS.register("ruby_crop", () -> new OreCropBlock(STEM));
        dragonCrop = BLOCKS.register("dragon_crop", () -> new OreCropBlock(STEM));
        xrayCrop = BLOCKS.register("xray_crop", () -> new OreCropBlock(STEM));
        superCrop = BLOCKS.register("super_crop", () -> new OreCropBlock(STEM));
        spaceCrop = BLOCKS.register("space_crop", () -> new OreCropBlock(STEM));
        rubyLeaf = BLOCKS.register("ruby_leaf", () -> new LeavesBlock(LEAF));
//        rubySapling = BLOCKS.register("ruby_sapling", () -> new OreSapling(new ModTrees.RubyTree(), SAPLING));
//        dragonLeaf = BLOCKS.register("dragon_leaf", () -> new LeavesBlock(LEAF));
//        dragonSapling = BLOCKS.register("dragon_sapling", () -> new OreSapling(new ModTrees.DragonTree(), SAPLING));
//        xrayLeaf = BLOCKS.register("xray_leaf", () -> new LeavesBlock(LEAF));
//        xraySapling = BLOCKS.register("xray_sapling", () -> new OreSapling(new ModTrees.XrayTree(), SAPLING));
//        superLeaf = BLOCKS.register("super_leaf", () -> new LeavesBlock(LEAF));
//        superSapling = BLOCKS.register("super_sapling", () -> new OreSapling(new ModTrees.SuperTree(), SAPLING));
//        spaceLeaf = BLOCKS.register("space_leaf", () -> new LeavesBlock(LEAF));
//        spaceSapling = BLOCKS.register("space_sapling", () -> new OreSapling(new ModTrees.SpaceTree(), SAPLING));
    }

    public static void registerIafBlock(){
        silverCrop = BLOCKS.register("silver_crop", () -> new OreCropBlock(STEM));
        silverLeaf = BLOCKS.register("silver_leaf", () -> new LeavesBlock(LEAF));
        silverSapling = BLOCKS.register("silver_sapling", () -> new OreSapling(new ModTrees.SilverTree(), SAPLING));
    }

    public static void registerBotBlock(){
        manasteelCrop = BLOCKS.register("manasteel_crop", () -> new OreCropBlock(STEM));
        manasteelLeaf = BLOCKS.register("manasteel_leaf", () -> new LeavesBlock(LEAF));
        manasteelSapling = BLOCKS.register("manasteel_sapling", () -> new OreSapling(new ModTrees.ManasteelTree(), SAPLING));
        terrasteelCrop = BLOCKS.register("terrasteel_crop", () -> new OreCropBlock(STEM));
        terrasteelLeaf = BLOCKS.register("terrasteel_leaf", () -> new LeavesBlock(LEAF));
        terrasteelSapling = BLOCKS.register("terrasteel_sapling", () -> new OreSapling(new ModTrees.TerrasteelTree(), SAPLING));
        elementiumCrop = BLOCKS.register("elementium_crop", () -> new OreCropBlock(STEM));
        elementiumLeaf = BLOCKS.register("elementium_leaf", () -> new LeavesBlock(LEAF));
        elementiumSapling = BLOCKS.register("elementium_sapling", () -> new OreSapling(new ModTrees.ElementiumTree(), SAPLING));
        gaiaCrop = BLOCKS.register("gaia_crop", () -> new OreCropBlock(STEM));
        gaiaLeaf = BLOCKS.register("gaia_leaf", () -> new LeavesBlock(LEAF));
        gaiaSapling = BLOCKS.register("gaia_sapling", () -> new OreSapling(new ModTrees.GaiaTree(), SAPLING));
    }

    public static void registerDEBlock(){
        awakenedDraconiumCrop = BLOCKS.register("awakened_draconium_crop", () -> new OreCropBlock(STEM));
        awakenedDraconiumLeaf = BLOCKS.register("awakened_draconium_leaf", () -> new LeavesBlock(LEAF));
        awakenedDraconiumSapling = BLOCKS.register("awakened_draconium_sapling", () -> new OreSapling(new ModTrees.AwakenedDraconiumTree(), SAPLING));
        draconiumCrop = BLOCKS.register("draconium_crop", () -> new OreCropBlock(STEM));
        draconiumLeaf = BLOCKS.register("draconium_leaf", () -> new LeavesBlock(LEAF));
        draconiumSapling = BLOCKS.register("draconium_sapling", () -> new OreSapling(new ModTrees.DraconiumTree(), SAPLING));
    }
}
