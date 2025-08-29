package com.yuo.orecrop.Items;

import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;

public class CustomSapling extends BlockItem {
    public CustomSapling(Block block, Item.Properties properties) {
        super(block, properties);
    }

    @Override
    public Rarity getRarity(ItemStack stack) {
        return Rarity.EPIC;
    }

    //附魔光效
    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }
}
