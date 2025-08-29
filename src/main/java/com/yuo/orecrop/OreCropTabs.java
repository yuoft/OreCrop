package com.yuo.orecrop;

import com.yuo.orecrop.Items.OreCropItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

//创造模式物品栏 实例化
public class OreCropTabs {
	public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, OreCrop.MOD_ID);
	public static final RegistryObject<CreativeModeTab> ORE_CROP_TAB = TABS.register(OreCrop.MOD_ID + "_tab", () -> CreativeModeTab.builder()
			.title(Component.translatable("itemGroup.tab.orecrop"))
			.icon(() -> OreCropItems.diamondSapling.get().getDefaultInstance())
			.displayItems((parameters, output) -> {
				for (RegistryObject<Item> entry : OreCropItems.ITEMS.getEntries()) {
					output.accept(entry.get());
				}


			}).build());
}
