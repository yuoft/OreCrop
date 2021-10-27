package com.yuo.orecrop.Blocks.Stem;

import com.yuo.orecrop.Blocks.BlockRegistry;
import net.minecraft.block.AttachedStemBlock;
import net.minecraft.block.StemBlock;
import net.minecraft.block.StemGrownBlock;

//作物块
public class NetheriteStemGrown extends StemGrownBlock {

    public NetheriteStemGrown(Properties properties) {
        super(properties);
    }

    @Override
    public StemBlock getStem() {
        return (StemBlock) BlockRegistry.netheriteStem.get();
    }

    @Override
    public AttachedStemBlock getAttachedStem() {
        return (AttachedStemBlock) BlockRegistry.attNetheriteStem.get();
    }

}
