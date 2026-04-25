package com.yuo.orecrop.Event;

import com.yuo.orecrop.Blocks.OreCropBlocks;
import com.yuo.orecrop.OreCrop;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.VanillaBlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;

import java.util.concurrent.CompletableFuture;

public class ModTagProvider extends VanillaBlockTagsProvider {

    public ModTagProvider(PackOutput output, CompletableFuture<Provider> lookupProvider) {
        super(output, lookupProvider);
    }

    @Override
    protected void addTags(Provider provider) {
        this.tag(BlockTags.LOGS).add(OreCropBlocks.oreLog.get());

        IntrinsicTagAppender<Block> saplings = this.tag(BlockTags.SAPLINGS)
                .add(OreCropBlocks.coalSapling.get())
                .add(OreCropBlocks.diamondSapling.get())
                .add(OreCropBlocks.emeraldSapling.get())
                .add(OreCropBlocks.goldSapling.get())
                .add(OreCropBlocks.ironSapling.get())
                .add(OreCropBlocks.lapisSapling.get())
                .add(OreCropBlocks.quartzSapling.get())
                .add(OreCropBlocks.netheriteSapling.get())
                .add(OreCropBlocks.customSapling.get())
                .add(OreCropBlocks.redstoneSapling.get())
                .add(OreCropBlocks.copperSapling.get());

        IntrinsicTagAppender<Block> leaves = this.tag(BlockTags.LEAVES)
                .add(OreCropBlocks.coalLeaf.get())
                .add(OreCropBlocks.diamondLeaf.get())
                .add(OreCropBlocks.emeraldLeaf.get())
                .add(OreCropBlocks.goldLeaf.get())
                .add(OreCropBlocks.ironLeaf.get())
                .add(OreCropBlocks.lapisLeaf.get())
                .add(OreCropBlocks.quartzLeaf.get())
                .add(OreCropBlocks.netheriteLeaf.get())
                .add(OreCropBlocks.redstoneLeaf.get())
                .add(OreCropBlocks.copperLeaf.get());

        if (OreCrop.IS_ICE_AND_FIRE){
            saplings.add(OreCropBlocks.silverSapling.get());
            leaves.add(OreCropBlocks.silverLeaf.get());
        }

        if (OreCrop.IS_BOT){
            saplings.add(OreCropBlocks.manasteelSapling.get())
                    .add(OreCropBlocks.terrasteelSapling.get())
                    .add(OreCropBlocks.elementiumSapling.get())
                    .add(OreCropBlocks.gaiaSapling.get());
            leaves.add(OreCropBlocks.manasteelLeaf.get())
                    .add(OreCropBlocks.terrasteelLeaf.get())
                    .add(OreCropBlocks.elementiumLeaf.get())
                    .add(OreCropBlocks.gaiaLeaf.get());
        }

        if (OreCrop.IS_DE){
            saplings.add(OreCropBlocks.awakenedDraconiumSapling.get())
                    .add(OreCropBlocks.draconiumSapling.get());
            leaves.add(OreCropBlocks.awakenedDraconiumLeaf.get())
                    .add(OreCropBlocks.draconiumLeaf.get());
        }
        if (OreCrop.IS_SPACE_ARMS){
            saplings.add(OreCropBlocks.rubySapling.get())
                    .add(OreCropBlocks.dragonSapling.get())
                    .add(OreCropBlocks.xraySapling.get())
                    .add(OreCropBlocks.superSapling.get())
                    .add(OreCropBlocks.spaceSapling.get());
            leaves.add(OreCropBlocks.rubyLeaf.get())
                    .add(OreCropBlocks.dragonLeaf.get())
                    .add(OreCropBlocks.xrayLeaf.get())
                    .add(OreCropBlocks.superLeaf.get())
                    .add(OreCropBlocks.spaceLeaf.get());
        }
    }
}
