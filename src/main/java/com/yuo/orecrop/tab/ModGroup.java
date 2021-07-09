package com.yuo.orecrop.tab;

import com.yuo.orecrop.Items.ItemRegistry;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

//创造模式物品栏
public class ModGroup extends ItemGroup{

	public static ModGroup myGroup = new ModGroup();

	public ModGroup() {
		super( ItemGroup.GROUPS.length, "orecrop"); //页码11开始，名称
	}
	//图标
	@Override
	public ItemStack createIcon() {
		return new ItemStack(Items.DIAMOND_ORE);
	}

}
