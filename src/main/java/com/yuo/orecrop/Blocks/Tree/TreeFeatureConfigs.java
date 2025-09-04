package com.yuo.orecrop.Blocks.Tree;

import com.yuo.orecrop.Blocks.OreCropBlocks;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration.TreeConfigurationBuilder;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

import java.util.stream.Stream;

/**
 * 矿石树木生成配置
 */
public enum TreeFeatureConfigs implements FeatureConfiguration {

    COAL_TREE(OreCropBlocks.oreLog.get().defaultBlockState(), OreCropBlocks.coalLeaf.get().defaultBlockState(), "coal_tree"),
    DIAMOND_TREE(OreCropBlocks.oreLog.get().defaultBlockState(), OreCropBlocks.diamondLeaf.get().defaultBlockState(), "diamond_tree"),
    EMERALD_TREE(OreCropBlocks.oreLog.get().defaultBlockState(), OreCropBlocks.emeraldLeaf.get().defaultBlockState(), "emerald_tree"),
    GOLD_TREE(OreCropBlocks.oreLog.get().defaultBlockState(), OreCropBlocks.goldLeaf.get().defaultBlockState(), "gold_tree"),
    IRON_TREE(OreCropBlocks.oreLog.get().defaultBlockState(), OreCropBlocks.ironLeaf.get().defaultBlockState(), "iron_tree"),
    LAPIS_TREE(OreCropBlocks.oreLog.get().defaultBlockState(), OreCropBlocks.lapisLeaf.get().defaultBlockState(), "lapis_tree"),
    QUARTZ_TREE(OreCropBlocks.oreLog.get().defaultBlockState(), OreCropBlocks.quartzLeaf.get().defaultBlockState(), "quartz_tree"),
    NETHERITE_TREE(OreCropBlocks.oreLog.get().defaultBlockState(), OreCropBlocks.netheriteLeaf.get().defaultBlockState(), "netherite_tree"),
//    RUBY_TREE(BlockRegistry.oreLog.get().defaultBlockState(), BlockRegistry.rubyLeaf.get().defaultBlockState(), "ruby_tree"),
//    DRAGON_TREE(BlockRegistry.oreLog.get().defaultBlockState(), BlockRegistry.dragonLeaf.get().defaultBlockState(), "dragon_tree"),
//    XRAY_TREE(BlockRegistry.oreLog.get().defaultBlockState(), BlockRegistry.xrayLeaf.get().defaultBlockState(), "xray_tree"),
//    SUPER_TREE(BlockRegistry.oreLog.get().defaultBlockState(), BlockRegistry.superLeaf.get().defaultBlockState(), "super_tree"),
//    SPACE_TREE(BlockRegistry.oreLog.get().defaultBlockState(), BlockRegistry.spaceLeaf.get().defaultBlockState(), "space_tree"),
    SILVER_TREE(OreCropBlocks.oreLog.get().defaultBlockState(), OreCropBlocks.silverLeaf.get().defaultBlockState(), "silver_tree"),
    COPPER_TREE(OreCropBlocks.oreLog.get().defaultBlockState(), OreCropBlocks.copperLeaf.get().defaultBlockState(), "copper_tree"),
    REDSTONE_TREE(OreCropBlocks.oreLog.get().defaultBlockState(), OreCropBlocks.redstoneLeaf.get().defaultBlockState(), "redstone_tree"),


    MANASTEEL_TREE(OreCropBlocks.oreLog.get().defaultBlockState(), OreCropBlocks.manasteelLeaf.get().defaultBlockState(), "manasteel_tree"),
    TERRASTEEL_TREE(OreCropBlocks.oreLog.get().defaultBlockState(), OreCropBlocks.terrasteelLeaf.get().defaultBlockState(), "terrasteel_tree"),
    ELEMENTIUM_TREE(OreCropBlocks.oreLog.get().defaultBlockState(), OreCropBlocks.elementiumLeaf.get().defaultBlockState(), "elementium_tree"),
    GAIA_TREE(OreCropBlocks.oreLog.get().defaultBlockState(), OreCropBlocks.gaiaLeaf.get().defaultBlockState(), "gaia_tree"),
    AWAKENED_DRACONIUM_TREE(OreCropBlocks.oreLog.get().defaultBlockState(), OreCropBlocks.awakenedDraconiumLeaf.get().defaultBlockState(), "awakened_draconium_tree"),
    DRACONIUM_TREE(OreCropBlocks.oreLog.get().defaultBlockState(), OreCropBlocks.draconiumLeaf.get().defaultBlockState(), "draconium_tree");

    private final BlockState log;
    private final BlockState leaves;
    private final String name;
    private final TreeConfiguration config;

    TreeFeatureConfigs(BlockState logIn, BlockState leavesIn, String name){
        this.log = logIn;
        this.leaves = leavesIn;
        this.name = name;
        this.config = (new TreeConfigurationBuilder(
                BlockStateProvider.simple(log), //树木
                new StraightTrunkPlacer(5,2,3),
                BlockStateProvider.simple(leaves), //树叶
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 5),
                new TwoLayersFeatureSize(1, 0, 1))).ignoreVines().build();
    }

    public static TreeConfiguration byName(String name) {
        for(TreeFeatureConfigs treeFeatureConfig : values()) {
            if (treeFeatureConfig.getName().equals(name)) {
                return treeFeatureConfig.config;
            }
        }

        throw new IllegalArgumentException("config error '" + name + "'");
    }

    public String getName() {
        return this.name;
    }
    public BlockState getLog() {
        return log;
    }

    public BlockState getLeaves() {
        return leaves;
    }

    public TreeConfiguration getConfig() {
        return config;
    }

    /**
     * 获取一个新配置
     * @param log 树木
     * @param leaf 树叶
     * @return 配置
     */
    public static TreeConfiguration getTree(BlockState log, BlockState leaf){
        return (new TreeConfigurationBuilder(
                BlockStateProvider.simple(log), //树木
                new StraightTrunkPlacer(5,2,3),
                BlockStateProvider.simple(leaf), //树叶
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 5),
                new TwoLayersFeatureSize(1, 0, 1))).ignoreVines().build();
    }

    @Override
    public Stream<ConfiguredFeature<?, ?>> getFeatures() {
        return FeatureConfiguration.super.getFeatures();
    }
}
