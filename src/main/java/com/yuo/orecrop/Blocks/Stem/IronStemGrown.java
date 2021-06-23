package com.yuo.orecrop.Blocks.Stem;

import com.yuo.orecrop.Blocks.BlockRegistry;
import net.minecraft.block.AttachedStemBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.StemBlock;
import net.minecraft.block.StemGrownBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.world.storage.loot.LootContext;

import java.util.ArrayList;
import java.util.List;

//作物块
public class IronStemGrown extends StemGrownBlock {

    public IronStemGrown(Properties properties) {
        super(properties);
    }

    @Override
    public StemBlock getStem() {
        return (StemBlock) BlockRegistry.ironStem.get();
    }

    @Override
    public AttachedStemBlock getAttachedStem() {
        return (AttachedStemBlock) BlockRegistry.attIronlStem.get();
    }
    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        List<ItemStack> loots = new ArrayList<ItemStack>();
        loots.add(new ItemStack(this, 1));
        return loots;
    }
}
