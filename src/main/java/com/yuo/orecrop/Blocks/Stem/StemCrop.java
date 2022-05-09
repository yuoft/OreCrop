package com.yuo.orecrop.Blocks.Stem;

import com.yuo.orecrop.Blocks.BlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.StemBlock;
import net.minecraft.block.StemGrownBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.server.ServerWorld;

import java.util.Collections;
import java.util.List;
import java.util.Random;

//作物茎
public class StemCrop extends StemBlock{

	public StemCrop(Properties builder, StemGrownBlock block) {
		super( block,builder);
	}

	@Override
	public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
		Block block = state.getBlock();
		int k = 0;
		if (block.equals(BlockRegistry.coalStem.get()) || block.equals(BlockRegistry.quartzStem.get())
				|| block.equals(BlockRegistry.lapisStem.get()))
			k = MathHelper.nextInt(RANDOM, 3, 6);
		else if (block.equals(BlockRegistry.diamondStem.get()) || block.equals(BlockRegistry.emeraldStem.get()))
			k = MathHelper.nextInt(RANDOM, 2, 4);
		else if (block.equals(BlockRegistry.netheriteStem.get()))
			k = MathHelper.nextInt(RANDOM, 1, 3);
		else k = MathHelper.nextInt(RANDOM, 3, 5);
		int i = Math.min(7, state.get(AGE) + k);
		BlockState blockstate = state.with(AGE, i);
		worldIn.setBlockState(pos, blockstate, 2);
		if (i == 7) {
			blockstate.tick(worldIn, pos, worldIn.rand);
		}
	}

	@Override
	public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
		return Collections.singletonList(new ItemStack(this));
	}
}
