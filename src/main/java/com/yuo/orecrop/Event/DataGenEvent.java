package com.yuo.orecrop.Event;

import com.yuo.orecrop.ModWorldGen;
import com.yuo.orecrop.OreCrop;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = OreCrop.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenEvent {

    @SubscribeEvent
    public static void addLoot(GatherDataEvent event){
        boolean b = event.includeServer();
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        CompletableFuture<Provider> lookupProvider = event.getLookupProvider();
        generator.addProvider(b, new ModWorldGen(output, lookupProvider));
        generator.addProvider(b, new ModTagProvider(output, lookupProvider));
        generator.addProvider(b, new ModLootTableProvider(output, Collections.emptySet(), List.of(new LootTableProvider.SubProviderEntry(ModBlockLTProvider::new, LootContextParamSets.BLOCK))));
    }
}
