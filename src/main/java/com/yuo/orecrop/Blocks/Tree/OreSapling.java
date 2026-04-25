package com.yuo.orecrop.Blocks.Tree;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class OreSapling extends SaplingBlock implements BonemealableBlock {

    public OreSapling(AbstractTreeGrower treeIn, Properties properties) {
        super(treeIn, properties);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }
    public boolean isValidBonemealTarget(LevelReader var1, BlockPos var2, BlockState var3, boolean var4){
        return true;
    }

    public boolean isBonemealSuccess(Level var1, RandomSource random, BlockPos var3, BlockState var4){
        return random.nextDouble() < 0.15d;
    }

    @Override
    protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
        builder.add(STAGE);
    }
}
