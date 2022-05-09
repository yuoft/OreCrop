package com.yuo.orecrop.Blocks.Tree;

import com.yuo.orecrop.Blocks.BlockRegistry;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;

import javax.annotation.Nullable;
import java.util.Random;

/**
 * 树木生成配置获取
 */
public class ModTrees {
    public static class CoalTree extends Tree{
        @Nullable
        @Override
        protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean flag) {
            return Feature.TREE.withConfiguration(TreeFeatureConfig.COAL_TREE.getConfig());
        }
    }
    public static class DiamondTree extends Tree{
        @Nullable
        @Override
        protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean flag) {
            return Feature.TREE.withConfiguration(TreeFeatureConfig.DIAMOND_TREE.getConfig());
        }
    }
    public static class EmeraldTree extends Tree{
        @Nullable
        @Override
        protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean flag) {
            return Feature.TREE.withConfiguration(TreeFeatureConfig.EMERALD_TREE.getConfig());
        }
    }
    public static class GoldTree extends Tree{
        @Nullable
        @Override
        protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean flag) {
            return Feature.TREE.withConfiguration(TreeFeatureConfig.GOLD_TREE.getConfig());
        }
    }
    public static class IronTree extends Tree{
        @Nullable
        @Override
        protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean flag) {
            return Feature.TREE.withConfiguration(TreeFeatureConfig.IRON_TREE.getConfig());
        }
    }
    public static class LapisTree extends Tree{
        @Nullable
        @Override
        protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean flag) {
            return Feature.TREE.withConfiguration(TreeFeatureConfig.LAPIS_TREE.getConfig());
        }
    }
    public static class NetheriteTree extends Tree{
        @Nullable
        @Override
        protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean flag) {
            return Feature.TREE.withConfiguration(TreeFeatureConfig.NETHERITE_TREE.getConfig());
        }
    }
    public static class QuartzTree extends Tree{
        @Nullable
        @Override
        protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean flag) {
            return Feature.TREE.withConfiguration(TreeFeatureConfig.QUARTZ_TREE.getConfig());
        }
    }
    public static class RedstoneTree extends Tree{
        @Nullable
        @Override
        protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean flag) {
            return Feature.TREE.withConfiguration(TreeFeatureConfig.REDSTONE_TREE.getConfig());
        }
    }
    public static class RubyTree extends Tree{
        @Nullable
        @Override
        protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean flag) {
            return Feature.TREE.withConfiguration(TreeFeatureConfig.getTree(BlockRegistry.oreLog.get().getDefaultState(), BlockRegistry.rubyLeaf.get().getDefaultState()));
        }
    }
    public static class DragonTree extends Tree{
        @Nullable
        @Override
        protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean flag) {
            return Feature.TREE.withConfiguration(TreeFeatureConfig.getTree(BlockRegistry.oreLog.get().getDefaultState(), BlockRegistry.dragonLeaf.get().getDefaultState()));
        }
    }
    public static class XrayTree extends Tree{
        @Nullable
        @Override
        protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean flag) {
            return Feature.TREE.withConfiguration(TreeFeatureConfig.getTree(BlockRegistry.oreLog.get().getDefaultState(), BlockRegistry.xrayLeaf.get().getDefaultState()));
        }
    }
    public static class SuperTree extends Tree{
        @Nullable
        @Override
        protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean flag) {
            return Feature.TREE.withConfiguration(TreeFeatureConfig.getTree(BlockRegistry.oreLog.get().getDefaultState(), BlockRegistry.superLeaf.get().getDefaultState()));
        }
    }
    public static class SpaceTree extends Tree{
        @Nullable
        @Override
        protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean flag) {
            return Feature.TREE.withConfiguration(TreeFeatureConfig.getTree(BlockRegistry.oreLog.get().getDefaultState(), BlockRegistry.spaceLeaf.get().getDefaultState()));
        }
    }
    public static class SilverTree extends Tree{
        @Nullable
        @Override
        protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean flag) {
            return Feature.TREE.withConfiguration(TreeFeatureConfig.getTree(BlockRegistry.oreLog.get().getDefaultState(), BlockRegistry.silverLeaf.get().getDefaultState()));
        }
    }
    public static class CopperTree extends Tree{
        @Nullable
        @Override
        protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean flag) {
            return Feature.TREE.withConfiguration(TreeFeatureConfig.getTree(BlockRegistry.oreLog.get().getDefaultState(), BlockRegistry.copperLeaf.get().getDefaultState()));
        }
    }
}
