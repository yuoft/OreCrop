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
    public static class RubyTree extends AbstractTreeGrower{
        @Nullable
        @Override
        protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource randomIn, boolean flag) {
            return ModConfigFeatures.RUBY_TREE;
        }
    }
    public static class DragonTree extends AbstractTreeGrower{
        @Nullable
        @Override
        protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource randomIn, boolean flag) {
            return ModConfigFeatures.DRAGON_TREE;
        }
    }
    public static class XrayTree extends AbstractTreeGrower{
        @Nullable
        @Override
        protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource randomIn, boolean flag) {
            return ModConfigFeatures.XRAY_TREE;
        }
    }
    public static class SuperTree extends AbstractTreeGrower{
        @Nullable
        @Override
        protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource randomIn, boolean flag) {
            return ModConfigFeatures.SUPER_TREE;
        }
    }
    public static class SpaceTree extends AbstractTreeGrower{
        @Nullable
        @Override
        protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource randomIn, boolean flag) {
            return ModConfigFeatures.SPACE_TREE;
        }
    }

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

    //联动1
    public static class AwakenedDraconiumTree extends AbstractTreeGrower{
        @Nullable
        @Override
        protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource randomIn, boolean flag) {
            return ModConfigFeatures.AWAKENED_DRACONIUM_TREE;
        }
    }
    public static class DraconiumTree extends AbstractTreeGrower{
        @Nullable
        @Override
        protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource randomIn, boolean flag) {
            return ModConfigFeatures.DRACONIUM_TREE;
        }
    }
    public static class ManasteelTree extends AbstractTreeGrower{
        @Nullable
        @Override
        protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource randomIn, boolean flag) {
            return ModConfigFeatures.MANASTEEL_TREE;
        }
    }
    public static class TerrasteelTree extends AbstractTreeGrower{
        @Nullable
        @Override
        protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource randomIn, boolean flag) {
            return ModConfigFeatures.TERRASTEEL_TREE;
        }
    }
    public static class ElementiumTree extends AbstractTreeGrower{
        @Nullable
        @Override
        protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource randomIn, boolean flag) {
            return ModConfigFeatures.ELEMENTIUM_TREE;
        }
    }
    public static class GaiaTree extends AbstractTreeGrower{
        @Nullable
        @Override
        protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource randomIn, boolean flag) {
            return ModConfigFeatures.GAIA_TREE;
        }
    }
}
