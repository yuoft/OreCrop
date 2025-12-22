package com.yuo.orecrop.Event;

import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;

import java.util.List;
import java.util.Set;

public class ModLootTableProvider extends LootTableProvider {
    public ModLootTableProvider(PackOutput output, Set<ResourceLocation> locations, List<SubProviderEntry> entries) {
        super(output, locations, entries);
    }
}
