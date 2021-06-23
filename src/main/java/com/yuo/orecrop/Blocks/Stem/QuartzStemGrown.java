package com.yuo.orecrop.Blocks.Stem;

import com.yuo.orecrop.Blocks.BlockRegistry;
import com.yuo.orecrop.Items.ItemRegistry;
import net.minecraft.block.AttachedStemBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.StemBlock;
import net.minecraft.block.StemGrownBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.storage.loot.LootContext;

import java.util.ArrayList;
import java.util.List;

//作物块
public class QuartzStemGrown extends StemGrownBlock {

    public QuartzStemGrown(Properties properties) {
        super(properties);
    }

    @Override
    public StemBlock getStem() {
        return (StemBlock) BlockRegistry.quartzStem.get();
    }

    @Override
    public AttachedStemBlock getAttachedStem() {
        return (AttachedStemBlock) BlockRegistry.attQuartzStem.get();
    }
    @Override
    public int getExpDrop(BlockState state, IWorldReader world, BlockPos pos, int fortune, int silktouch) {
        return MathHelper.nextInt(RANDOM, 1, 3);
    }
    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        List<ItemStack> loots = new ArrayList<ItemStack>();
        loots.add(new ItemStack(ItemRegistry.quartzNugget.get(), RANDOM.nextInt(5) + 1));
        return loots;
    }
}
