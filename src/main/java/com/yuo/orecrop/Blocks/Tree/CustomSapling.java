package com.yuo.orecrop.Blocks.Tree;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

import java.util.Random;

public class CustomSapling extends Block {
    public CustomSapling() {
        super(Properties.from(Blocks.OAK_SAPLING).notSolid());
    }

    @Override
    public BlockState updatePostPlacement(BlockState state, Direction direction, BlockState state1, IWorld world, BlockPos pos, BlockPos pos1) {
        return !state.isValidPosition(world, pos) ? Blocks.AIR.getDefaultState() : super.updatePostPlacement(state, direction, state1, world, pos, pos1);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader blockReader, BlockPos pos, ISelectionContext context) {
        return Block.makeCuboidShape(2.0, 0.0, 2.0, 14.0, 12.0, 14.0);
    }

    //能否放置
    @Override
    public boolean isValidPosition(BlockState state, IWorldReader worldReader, BlockPos pos) {
        BlockPos blockpos = pos.down();
        return !worldReader.isAirBlock(blockpos);
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult traceResult) {
        ItemStack heldItem = player.getHeldItem(hand);
        if (!heldItem.isEmpty() && heldItem.getItem() == Items.BONE_MEAL) {//骨粉
            for (int i = 0; i < 10; i++){
                world.addParticle(ParticleTypes.COMPOSTER, pos.getX() + world.rand.nextDouble() / 2, pos.getY() + world.rand.nextDouble() / 2, pos.getZ() + world.rand.nextDouble() / 2, 0.05D, 0.05D, 0.05D);
            }
            growTree(world, pos.down(), world.getBlockState(pos.down()), RANDOM);
            heldItem.shrink(1);
            player.swingArm(hand);
            return ActionResultType.SUCCESS;
        }
        return super.onBlockActivated(state, world, pos, player, hand, traceResult);
    }

    public static void growTree(World world, BlockPos pos, BlockState state, Random rand) {
        // 树干
        int height = 4 + rand.nextInt(4);
        for (int i = pos.getY() + 1; i < pos.getY() + height + 1; i++) {
            world.setBlockState(new BlockPos(pos.getX(), i, pos.getZ()), state);
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
                            world.setBlockState(blockpos, state);
                    }
                }
            }
        }
    }
}
