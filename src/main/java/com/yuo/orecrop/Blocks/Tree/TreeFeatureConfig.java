package com.yuo.orecrop.Blocks.Tree;

import com.yuo.orecrop.Blocks.BlockRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.FeatureSpread;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.TwoLayerFeature;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;

/**
 * 矿石树木生成配置
 */
public enum TreeFeatureConfig implements IFeatureConfig {

    COAL_TREE(BlockRegistry.oreLog.get().getDefaultState(), BlockRegistry.coalLeaf.get().getDefaultState(), "coal_tree"),
    DIAMOND_TREE(BlockRegistry.oreLog.get().getDefaultState(), BlockRegistry.diamondLeaf.get().getDefaultState(), "diamond_tree"),
    EMERALD_TREE(BlockRegistry.oreLog.get().getDefaultState(), BlockRegistry.emeraldLeaf.get().getDefaultState(), "emerald_tree"),
    GOLD_TREE(BlockRegistry.oreLog.get().getDefaultState(), BlockRegistry.goldLeaf.get().getDefaultState(), "gold_tree"),
    IRON_TREE(BlockRegistry.oreLog.get().getDefaultState(), BlockRegistry.ironLeaf.get().getDefaultState(), "iron_tree"),
    LAPIS_TREE(BlockRegistry.oreLog.get().getDefaultState(), BlockRegistry.lapisLeaf.get().getDefaultState(), "lapis_tree"),
    QUARTZ_TREE(BlockRegistry.oreLog.get().getDefaultState(), BlockRegistry.quartzLeaf.get().getDefaultState(), "quartz_tree"),
    NETHERITE_TREE(BlockRegistry.oreLog.get().getDefaultState(), BlockRegistry.netheriteLeaf.get().getDefaultState(), "netherite_tree"),
    REDSTONE_TREE(BlockRegistry.oreLog.get().getDefaultState(), BlockRegistry.redstoneLeaf.get().getDefaultState(), "redstone_tree");

    private final BlockState log;
    private final BlockState leaves;
    private final String name;
    private final BaseTreeFeatureConfig config;

    private TreeFeatureConfig(BlockState logIn, BlockState leavesIn, String name){
        this.log = logIn;
        this.leaves = leavesIn;
        this.name = name;
        this.config = (new BaseTreeFeatureConfig.Builder(
                new SimpleBlockStateProvider(log), //树木
                new SimpleBlockStateProvider(leaves), //树叶
                new BlobFoliagePlacer(FeatureSpread.func_242252_a(2), FeatureSpread.func_242252_a(0), 5),
                new StraightTrunkPlacer(5,2,3),
                new TwoLayerFeature(1,0,1))).setIgnoreVines().build();
    }

    public static BaseTreeFeatureConfig byName(String name) {
        for(TreeFeatureConfig treeFeatureConfig : values()) {
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

    public BaseTreeFeatureConfig getConfig() {
        return config;
    }
}
