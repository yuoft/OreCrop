package com.yuo.orecrop.Blocks.Tree;

import com.yuo.orecrop.Blocks.OreCropBlocks;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;

import javax.annotation.Nullable;

/**
 * 树木生成配置获取
 */
public class ModTrees {

    public static class CoalTree extends AbstractTreeGrower {

        @Nullable
        @Override
        protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource randomIn, boolean flag) {
            return ModConfigFeatures.COAL_TREE;
        }
    }
    public static class DiamondTree extends AbstractTreeGrower{
        
        @Nullable
        @Override
        protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource randomIn, boolean flag) {
            return ModConfigFeatures.DIAMOND_TREE;
        }
    }
    public static class EmeraldTree extends AbstractTreeGrower{
        @Nullable
        @Override
        protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource randomIn, boolean flag) {
            return ModConfigFeatures.EMERALD_TREE;
        }
    }
    public static class GoldTree extends AbstractTreeGrower{
        @Nullable
        @Override
        protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource randomIn, boolean flag) {
            return ModConfigFeatures.GOLD_TREE;
        }
    }
    public static class IronTree extends AbstractTreeGrower{
        @Nullable
        @Override
        protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource randomIn, boolean flag) {
            return ModConfigFeatures.IRON_TREE;
        }
    }
    public static class LapisTree extends AbstractTreeGrower{
        @Nullable
        @Override
        protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource randomIn, boolean flag) {
            return ModConfigFeatures.LAPIS_TREE;
        }
    }
    public static class NetheriteTree extends AbstractTreeGrower{
        @Nullable
        @Override
        protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource randomIn, boolean flag) {
            return ModConfigFeatures.NETHERITE_TREE;
        }
    }
    public static class QuartzTree extends AbstractTreeGrower{
        @Nullable
        @Override
        protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource randomIn, boolean flag) {
            return ModConfigFeatures.QUARTZ_TREE;
        }
    }
    public static class RedstoneTree extends AbstractTreeGrower{
        @Nullable
        @Override
        protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource randomIn, boolean flag) {
            return ModConfigFeatures.REDSTONE_TREE;
        }
    }
    /*
    public static class RubyTree extends AbstractTreeGrower{
        @Nullable
        @Override
        protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource randomIn, boolean flag) {
            return ModConfigFeatures.createKey(TreeFeatureConfigs.getTree(OreCropBlocks.oreLog.get().getDefaultState(), OreCropBlocks.rubyLeaf.get().getDefaultState()));
        }
    }
    public static class DragonTree extends AbstractTreeGrower{
        @Nullable
        @Override
        protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource randomIn, boolean flag) {
            return Feature.TREE.place(TreeFeatureConfigs.getTree(OreCropBlocks.oreLog.get().getDefaultState(), OreCropBlocks.dragonLeaf.get().getDefaultState()));
        }
    }
    public static class XrayTree extends AbstractTreeGrower{
        @Nullable
        @Override
        protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource randomIn, boolean flag) {
            return Feature.TREE.place(TreeFeatureConfigs.getTree(OreCropBlocks.oreLog.get().getDefaultState(), OreCropBlocks.xrayLeaf.get().getDefaultState()));
        }
    }
    public static class SuperTree extends AbstractTreeGrower{
        @Nullable
        @Override
        protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource randomIn, boolean flag) {
            return Feature.TREE.place(TreeFeatureConfigs.getTree(OreCropBlocks.oreLog.get().getDefaultState(), OreCropBlocks.superLeaf.get().getDefaultState()));
        }
    }
    public static class SpaceTree extends AbstractTreeGrower{
        @Nullable
        @Override
        protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource randomIn, boolean flag) {
            return Feature.TREE.place(TreeFeatureConfigs.getTree(OreCropBlocks.oreLog.get().getDefaultState(), OreCropBlocks.spaceLeaf.get().getDefaultState()));
        }
    }*/
    public static class SilverTree extends AbstractTreeGrower{
        @Nullable
        @Override
        protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource randomIn, boolean flag) {
            return ModConfigFeatures.SILVER_TREE;
        }
    }
    public static class CopperTree extends AbstractTreeGrower{
        @Nullable
        @Override
        protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource randomIn, boolean flag) {
            return ModConfigFeatures.COPPER_TREE;
        }
    }
}
