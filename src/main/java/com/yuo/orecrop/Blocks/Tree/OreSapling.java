package com.yuo.orecrop.Blocks.Tree;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
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
import net.minecraftforge.event.ForgeEventFactory;

public class OreSapling extends SaplingBlock implements BonemealableBlock {

    private final AbstractTreeGrower tree;

    public OreSapling(AbstractTreeGrower treeIn, Properties properties) {
        super(treeIn, properties);
        this.tree = treeIn;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }
    public boolean isValidBonemealTarget(LevelReader var1, BlockPos var2, BlockState var3, boolean var4){
        return true;
    }

    public boolean isBonemealSuccess(Level var1, RandomSource random, BlockPos var3, BlockState var4){
        return random.nextDouble() < 0.1d;
    }

    @Override
    protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
        builder.add(STAGE);
    }

//    @Override
//    public void randomTick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
//        if (world.isAreaLoaded(pos, 1)) {
//            if (world.getMaxLocalRawBrightness(pos.above()) >= 9 && random.nextInt(7) == 0) {
//                this.placeTree(world, pos, state, random);
//            }
//
//        }
//    }
//
//    public void placeTree(ServerLevel world, BlockPos pos, BlockState state, RandomSource rand) {
//        if (state.getValue(STAGE) == 0) {
//            world.setBlock(pos, state.cycle(STAGE), 4);
//        } else {
//            this.tree.growTree(world, world.getChunkSource().getGenerator(), pos, state, rand);
//        }
//    }
}
