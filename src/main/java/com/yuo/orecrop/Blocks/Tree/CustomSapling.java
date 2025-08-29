package com.yuo.orecrop.Blocks.Tree;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Random;

public class CustomSapling extends Block {
    public CustomSapling() {
        super(Properties.copy(Blocks.OAK_SAPLING).forceSolidOn());
    }

    @Override
    public VoxelShape getShape(BlockState p_60555_, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_) {
        return Block.box(2.0, 0.0, 2.0, 14.0, 12.0, 14.0);
    }

    //能否放置
    @Override
    public boolean canSurvive(BlockState state, LevelReader worldReader, BlockPos pos) {
        BlockPos blockpos = pos.below();
        return !worldReader.getBlockState(blockpos).isAir();
    }

    protected boolean mayPlaceOn(BlockState state, BlockGetter getter, BlockPos pos) {
        return state.is(BlockTags.DIRT) || state.is(Blocks.FARMLAND);
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult traceResult) {
        ItemStack heldItem = player.getItemInHand(hand);
        if (!heldItem.isEmpty() && heldItem.getItem() == Items.BONE_MEAL) {//骨粉
            RandomSource random = world.random;
            for (int i = 0; i < 10; i++){
                world.addParticle(ParticleTypes.COMPOSTER, pos.getX() + random.nextDouble() / 2, pos.getY() + random.nextDouble() / 2, pos.getZ() + random.nextDouble() / 2, 0.05D, 0.05D, 0.05D);
            }
            growTree(world, pos.below(), world.getBlockState(pos.below()), random);
            heldItem.shrink(1);
            player.swing(hand);
            return InteractionResult.SUCCESS;
        }
        return super.use(state, world, pos, player, hand, traceResult);
    }

    //生成树木
    public static void growTree(Level world, BlockPos pos, BlockState state, RandomSource rand) {
        // 树干
        int height = 4 + rand.nextInt(4);
        for (int i = pos.getY() + 1; i < pos.getY() + height + 1; i++) {
            world.setBlockAndUpdate(new BlockPos(pos.getX(), i, pos.getZ()), state);
        }
        // 树叶
        for (int y = pos.getY() + 3 + rand.nextInt(2); y <= pos.getY() + height + 1; ++y) {
            int restHeight = y - (pos.getY() + height + 1); //与树干顶端距离
            int xzSize = 1 - restHeight / 2; //树叶范围
            for (int x = pos.getX() - xzSize; x <= pos.getX() + xzSize; ++x) {
                int xOffset = x - pos.getX();
                for (int z = pos.getZ() - xzSize; z <= pos.getZ() + xzSize; ++z) {
                    int zOffset = z - pos.getZ();
                    if (   Math.abs(xOffset) != xzSize || Math.abs(zOffset) != xzSize // 不在边缘4个点
                            || rand.nextInt(2) != 0 && restHeight != 0) {
                        BlockPos blockpos = new BlockPos(x, y, z);
                            world.setBlockAndUpdate(blockpos, state);
                    }
                }
            }
        }
    }
}
