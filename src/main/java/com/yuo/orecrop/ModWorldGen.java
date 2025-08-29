package com.yuo.orecrop;

import com.yuo.orecrop.Blocks.Tree.ModConfigFeatures;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModWorldGen extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, ModConfigFeatures::bootstrap);

    public ModWorldGen(PackOutput output, CompletableFuture<Provider> registries) {
        super(output, registries, BUILDER, Set.of(OreCrop.MOD_ID));
    }
}