package com.yuo.orecrop.Blocks.Tree;

import com.yuo.orecrop.Blocks.BlockRegistry;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraftforge.common.IPlantable;

import javax.annotation.Nullable;
import java.util.Random;

public class IronTree extends Tree {
    //树木生成配置
    private static final TreeFeatureConfig ORE_TREE_CONFIG = (new TreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(BlockRegistry.oreLog.get().getDefaultState()), //树木
            new SimpleBlockStateProvider(BlockRegistry.ironLeaf.get().getDefaultState()), //树叶
            new BlobFoliagePlacer(2, 0)))
            .baseHeight(5).heightRandA(2).foliageHeight(3).ignoreVines()   //大小形状
            .setSapling((IPlantable) BlockRegistry.ironSapling.get()).build(); //树苗

    @Nullable
    @Override
    protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean p_225546_2_) {
        return Feature.NORMAL_TREE.withConfiguration(ORE_TREE_CONFIG);
    }
}
