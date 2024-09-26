package com.yuo.orecrop.Items;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.text.ITextComponent;

public class CustomSapling extends BlockItem {
    public CustomSapling(Block block, Item.Properties properties) {
        super(block, properties);
    }

    public String getTranslationKey() {
        return this.getDefaultTranslationKey();
    }

    @Override
    public Rarity getRarity(ItemStack p_77613_1_) {
        return Rarity.EPIC;
    }

    @Override
    public ITextComponent getName() {
        return super.getName();
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return true;
    }
}
