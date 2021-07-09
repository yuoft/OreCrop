package com.yuo.orecrop.Blocks;

import com.yuo.orecrop.Blocks.Crop.OreCropBlock;
import com.yuo.orecrop.Blocks.Stem.*;
import com.yuo.orecrop.Blocks.Tree.*;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

//方块注册
public class BlockRegistry {
	//同物品
	@SuppressWarnings("deprecation")
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, com.yuo.orecrop.OreCrop.MODID);//DeferredRegister.create(ForgeRegistries.BLOCKS, "spacearms");
	private static Block.Properties STEM = Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.0f).tickRandomly().sound(SoundType.PLANT)
				.doesNotBlockMovement();
    public static final Block.Properties LOG = Block.Properties.from(Blocks.BIRCH_LOG); //树干
    public static final Block.Properties LEAF = Block.Properties.from(Blocks.BIRCH_LEAVES); //树叶
    public static final Block.Properties SAPLING = Block.Properties.from(Blocks.BIRCH_SAPLING); //树苗
    //作物
	public static RegistryObject<Block> coalLeanOre = BLOCKS.register("coal_lean_ore", () -> {
		return new CoalStemGrown(Block.Properties.from(Blocks.COAL_ORE));
	});
	public static RegistryObject<Block> diamondLeanOre = BLOCKS.register("diamond_lean_ore", () -> {
		return new DiamondStemGrown(Block.Properties.from(Blocks.DIAMOND_ORE));
	});
	public static RegistryObject<Block> emeraldLeanOre = BLOCKS.register("emerald_lean_ore", () -> {
		return new EmeraldStemGrown(Block.Properties.from(Blocks.EMERALD_ORE));
	});
	public static RegistryObject<Block> goldLeanOre = BLOCKS.register("gold_lean_ore", () -> {
		return new GoldStemGrown(Block.Properties.from(Blocks.GOLD_ORE));
	});
	public static RegistryObject<Block> ironLeanOre = BLOCKS.register("iron_lean_ore", () -> {
		return new IronStemGrown(Block.Properties.from(Blocks.IRON_ORE));
	});
	public static RegistryObject<Block> lapisLeanOre = BLOCKS.register("lapis_lean_ore", () -> {
		return new LapisStemGrown(Block.Properties.from(Blocks.LAPIS_ORE));
	});
	public static RegistryObject<Block> quartzLeanOre = BLOCKS.register("quartz_lean_ore", () -> {
		return new QuartzStemGrown(Block.Properties.from(Blocks.NETHER_QUARTZ_ORE));
	});
	public static RegistryObject<Block> redstoneLeanOre = BLOCKS.register("redstone_lean_ore", () -> {
		return new RedstoneStemGrown(Block.Properties.from(Blocks.REDSTONE_ORE));
	});
	//作物 连接茎
    public static RegistryObject<Block> attCoalStem = BLOCKS.register("att_coal_stem", () -> {
        return new AttachedStemCrop((StemGrownBlock) coalLeanOre.get(),STEM);
    });
    public static RegistryObject<Block> attDiamondStem = BLOCKS.register("att_diamond_stem", () -> {
        return new AttachedStemCrop((StemGrownBlock) diamondLeanOre.get(),STEM);
    });
    public static RegistryObject<Block> attEmeraldStem = BLOCKS.register("att_emerald_stem", () -> {
        return new AttachedStemCrop((StemGrownBlock) emeraldLeanOre.get(),STEM);
    });
    public static RegistryObject<Block> attGoldStem = BLOCKS.register("att_gold_stem", () -> {
        return new AttachedStemCrop((StemGrownBlock) goldLeanOre.get(),STEM);
    });
    public static RegistryObject<Block> attIronlStem = BLOCKS.register("att_iron_stem", () -> {
        return new AttachedStemCrop((StemGrownBlock) ironLeanOre.get(),STEM);
    });
    public static RegistryObject<Block> attLapisStem = BLOCKS.register("att_lapis_stem", () -> {
        return new AttachedStemCrop((StemGrownBlock) lapisLeanOre.get(),STEM);
    });
    public static RegistryObject<Block> attQuartzStem = BLOCKS.register("att_quartz_stem", () -> {
        return new AttachedStemCrop((StemGrownBlock) quartzLeanOre.get(),STEM);
    });
    public static RegistryObject<Block> attRedstoneStem = BLOCKS.register("att_redstone_stem", () -> {
        return new AttachedStemCrop((StemGrownBlock) redstoneLeanOre.get(),STEM);
    });
    //作物方块 茎
    public static RegistryObject<Block> coalStem = BLOCKS.register("coal_stem", () -> {
        return new StemCrop(STEM, (StemGrownBlock) coalLeanOre.get());
    });
    public static RegistryObject<Block> diamondStem = BLOCKS.register("diamond_stem", () -> {
        return new StemCrop(STEM, (StemGrownBlock) diamondLeanOre.get());
    });
    public static RegistryObject<Block> emeraldStem = BLOCKS.register("emerald_stem", () -> {
        return new StemCrop(STEM, (StemGrownBlock) emeraldLeanOre.get());
    });
    public static RegistryObject<Block> goldStem = BLOCKS.register("gold_stem", () -> {
        return new StemCrop(STEM, (StemGrownBlock) goldLeanOre.get());
    });
    public static RegistryObject<Block> ironStem = BLOCKS.register("iron_stem", () -> {
        return new StemCrop(STEM, (StemGrownBlock) ironLeanOre.get());
    });
    public static RegistryObject<Block> lapisStem = BLOCKS.register("lapis_stem", () -> {
        return new StemCrop(STEM, (StemGrownBlock) lapisLeanOre.get());
    });
    public static RegistryObject<Block> quartzStem = BLOCKS.register("quartz_stem", () -> {
        return new StemCrop(STEM, (StemGrownBlock) quartzLeanOre.get());
    });
    public static RegistryObject<Block> redstoneStem = BLOCKS.register("redstone_stem", () -> {
        return new StemCrop(STEM, (StemGrownBlock) redstoneLeanOre.get());
    });

    //普通作物
    public static RegistryObject<Block> coalCrop = BLOCKS.register("coal_crop", () -> {
        return new OreCropBlock(STEM);
    });
    public static RegistryObject<Block> diamondCrop = BLOCKS.register("diamond_crop", () -> {
        return new OreCropBlock(STEM);
    });
    public static RegistryObject<Block> emeraldCrop = BLOCKS.register("emerald_crop", () -> {
        return new OreCropBlock(STEM);
    });
    public static RegistryObject<Block> goldCrop = BLOCKS.register("gold_crop", () -> {
        return new OreCropBlock(STEM);
    });
    public static RegistryObject<Block> ironCrop = BLOCKS.register("iron_crop", () -> {
        return new OreCropBlock(STEM);
    });
    public static RegistryObject<Block> lapisCrop = BLOCKS.register("lapis_crop", () -> {
        return new OreCropBlock(STEM);
    });
    public static RegistryObject<Block> quartzCrop = BLOCKS.register("quartz_crop", () -> {
        return new OreCropBlock(STEM);
    });
    public static RegistryObject<Block> redstoneCrop = BLOCKS.register("redstone_crop", () -> {
        return new OreCropBlock(STEM);
    });

    //树木
    public static RegistryObject<Block> oreLog = BLOCKS.register("ore_log", () -> {
        return new LogBlock(MaterialColor.WOOD, LOG);
    });
    public static RegistryObject<Block> coalLeaf = BLOCKS.register("coal_leaf", () -> {
        return new LeavesBlock(LEAF);
    });
    public static RegistryObject<Block> coalSapling = BLOCKS.register("coal_sapling", () -> {
        return new OreSapling(() -> new CoalTree(), SAPLING);
    });
    public static RegistryObject<Block> diamondLeaf = BLOCKS.register("diamond_leaf", () -> {
        return new LeavesBlock(LEAF);
    });
    public static RegistryObject<Block> diamondSapling = BLOCKS.register("diamond_sapling", () -> {
        return new OreSapling(() -> new DiamondTree(), SAPLING);
    });
    public static RegistryObject<Block> emeraldLeaf = BLOCKS.register("emerald_leaf", () -> {
        return new LeavesBlock(LEAF);
    });
    public static RegistryObject<Block> emeraldSapling = BLOCKS.register("emerald_sapling", () -> {
        return new OreSapling(() -> new EmeraldTree(), SAPLING);
    });
    public static RegistryObject<Block> goldLeaf = BLOCKS.register("gold_leaf", () -> {
        return new LeavesBlock(LEAF);
    });
    public static RegistryObject<Block> goldSapling = BLOCKS.register("gold_sapling", () -> {
        return new OreSapling(() -> new GoldTree(), SAPLING);
    });
    public static RegistryObject<Block> ironLeaf = BLOCKS.register("iron_leaf", () -> {
        return new LeavesBlock(LEAF);
    });
    public static RegistryObject<Block> ironSapling = BLOCKS.register("iron_sapling", () -> {
        return new OreSapling(() -> new IronTree(), SAPLING);
    });
    public static RegistryObject<Block> lapisLeaf = BLOCKS.register("lapis_leaf", () -> {
        return new LeavesBlock(LEAF);
    });
    public static RegistryObject<Block> lapisSapling = BLOCKS.register("lapis_sapling", () -> {
        return new OreSapling(() -> new LapisTree(), SAPLING);
    });
    public static RegistryObject<Block> quartzLeaf = BLOCKS.register("quartz_leaf", () -> {
        return new LeavesBlock(LEAF);
    });
    public static RegistryObject<Block> quartzSapling = BLOCKS.register("quartz_sapling", () -> {
        return new OreSapling(() -> new QuartzTree(), SAPLING);
    });
    public static RegistryObject<Block> redstoneLeaf = BLOCKS.register("redstone_leaf", () -> {
        return new LeavesBlock(LEAF);
    });
    public static RegistryObject<Block> redstoneSapling = BLOCKS.register("redstone_sapling", () -> {
        return new OreSapling(() -> new RedstoneTree(), SAPLING);
    });
}
