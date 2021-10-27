package com.yuo.orecrop.Blocks.Stem;

import com.yuo.orecrop.Blocks.BlockRegistry;
import net.minecraft.block.AttachedStemBlock;
import net.minecraft.block.StemBlock;
import net.minecraft.block.StemGrownBlock;

//作物块
public class GoldStemGrown extends StemGrownBlock {

    public GoldStemGrown(Properties properties) {
        super(properties);
    }

    @Override
    public StemBlock getStem() {
        return (StemBlock) BlockRegistry.goldStem.get();
    }

    @Override
    public AttachedStemBlock getAttachedStem() {
        return (AttachedStemBlock) BlockRegistry.attGoldStem.get();
    }

}
