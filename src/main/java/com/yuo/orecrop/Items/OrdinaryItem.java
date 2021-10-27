package com.yuo.orecrop.Items;

import com.yuo.orecrop.tab.ModGroup;
import net.minecraft.item.Item;

/**
 * 通用普通物品
 */
public class OrdinaryItem extends Item{

	public OrdinaryItem() {
		super(new Properties().group(ModGroup.myGroup)); //设置物品所在 创造模式物品栏
	}

}
