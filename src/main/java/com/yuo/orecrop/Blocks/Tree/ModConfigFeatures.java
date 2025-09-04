package com.yuo.orecrop.Blocks.Tree;

import com.yuo.orecrop.OreCrop;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;

public class ModConfigFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> COAL_TREE = createKey(TreeFeatureConfigs.COAL_TREE.getName());
    public static final ResourceKey<ConfiguredFeature<?, ?>> IRON_TREE = createKey(TreeFeatureConfigs.IRON_TREE.getName());
    public static final ResourceKey<ConfiguredFeature<?, ?>> GOLD_TREE = createKey(TreeFeatureConfigs.GOLD_TREE.getName());
    public static final ResourceKey<ConfiguredFeature<?, ?>> DIAMOND_TREE = createKey(TreeFeatureConfigs.DIAMOND_TREE.getName());
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHERITE_TREE = createKey(TreeFeatureConfigs.NETHERITE_TREE.getName());
    public static final ResourceKey<ConfiguredFeature<?, ?>> EMERALD_TREE = createKey(TreeFeatureConfigs.EMERALD_TREE.getName());
    public static final ResourceKey<ConfiguredFeature<?, ?>> LAPIS_TREE = createKey(TreeFeatureConfigs.LAPIS_TREE.getName());
    public static final ResourceKey<ConfiguredFeature<?, ?>> QUARTZ_TREE = createKey(TreeFeatureConfigs.QUARTZ_TREE.getName());
    public static final ResourceKey<ConfiguredFeature<?, ?>> REDSTONE_TREE = createKey(TreeFeatureConfigs.REDSTONE_TREE.getName());
    public static final ResourceKey<ConfiguredFeature<?, ?>> COPPER_TREE = createKey(TreeFeatureConfigs.COPPER_TREE.getName());
    public static final ResourceKey<ConfiguredFeature<?, ?>> SILVER_TREE = createKey(TreeFeatureConfigs.SILVER_TREE.getName());

    public static final ResourceKey<ConfiguredFeature<?, ?>> MANASTEEL_TREE = createKey(TreeFeatureConfigs.MANASTEEL_TREE.getName());
    public static final ResourceKey<ConfiguredFeature<?, ?>> TERRASTEEL_TREE = createKey(TreeFeatureConfigs.TERRASTEEL_TREE.getName());
    public static final ResourceKey<ConfiguredFeature<?, ?>> ELEMENTIUM_TREE = createKey(TreeFeatureConfigs.ELEMENTIUM_TREE.getName());
    public static final ResourceKey<ConfiguredFeature<?, ?>> GAIA_TREE = createKey(TreeFeatureConfigs.GAIA_TREE.getName());
    public static final ResourceKey<ConfiguredFeature<?, ?>> AWAKENED_DRACONIUM_TREE = createKey(TreeFeatureConfigs.AWAKENED_DRACONIUM_TREE.getName());
    public static final ResourceKey<ConfiguredFeature<?, ?>> DRACONIUM_TREE = createKey(TreeFeatureConfigs.DRACONIUM_TREE.getName());


    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        FeatureUtils.register(context, COAL_TREE, Feature.TREE, TreeFeatureConfigs.COAL_TREE.getConfig());
        FeatureUtils.register(context, IRON_TREE, Feature.TREE, TreeFeatureConfigs.IRON_TREE.getConfig());
        FeatureUtils.register(context, GOLD_TREE, Feature.TREE, TreeFeatureConfigs.GOLD_TREE.getConfig());
        FeatureUtils.register(context, DIAMOND_TREE, Feature.TREE, TreeFeatureConfigs.DIAMOND_TREE.getConfig());
        FeatureUtils.register(context, NETHERITE_TREE, Feature.TREE, TreeFeatureConfigs.NETHERITE_TREE.getConfig());
        FeatureUtils.register(context, EMERALD_TREE, Feature.TREE, TreeFeatureConfigs.EMERALD_TREE.getConfig());
        FeatureUtils.register(context, LAPIS_TREE, Feature.TREE, TreeFeatureConfigs.LAPIS_TREE.getConfig());
        FeatureUtils.register(context, QUARTZ_TREE, Feature.TREE, TreeFeatureConfigs.QUARTZ_TREE.getConfig());
        FeatureUtils.register(context, REDSTONE_TREE, Feature.TREE, TreeFeatureConfigs.REDSTONE_TREE.getConfig());
        FeatureUtils.register(context, COPPER_TREE, Feature.TREE, TreeFeatureConfigs.COPPER_TREE.getConfig());
        FeatureUtils.register(context, SILVER_TREE, Feature.TREE, TreeFeatureConfigs.SILVER_TREE.getConfig());

        FeatureUtils.register(context, MANASTEEL_TREE, Feature.TREE, TreeFeatureConfigs.MANASTEEL_TREE.getConfig());
        FeatureUtils.register(context, TERRASTEEL_TREE, Feature.TREE, TreeFeatureConfigs.TERRASTEEL_TREE.getConfig());
        FeatureUtils.register(context, ELEMENTIUM_TREE, Feature.TREE, TreeFeatureConfigs.ELEMENTIUM_TREE.getConfig());
        FeatureUtils.register(context, GAIA_TREE, Feature.TREE, TreeFeatureConfigs.GAIA_TREE.getConfig());
        FeatureUtils.register(context, AWAKENED_DRACONIUM_TREE, Feature.TREE, TreeFeatureConfigs.AWAKENED_DRACONIUM_TREE.getConfig());
        FeatureUtils.register(context, DRACONIUM_TREE, Feature.TREE, TreeFeatureConfigs.DRACONIUM_TREE.getConfig());
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> createKey(String pName) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(OreCrop.MOD_ID,pName));
    }
}
