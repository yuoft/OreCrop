package com.yuo.orecrop.Items;

import com.yuo.orecrop.tab.ModGroup;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

/**
 * 通用普通物品
 */
public class OrdinaryItem extends Item{

	public OrdinaryItem() {
		super(new Properties().group(ModGroup.myGroup)); //设置物品所在 创造模式物品栏
	}

}
