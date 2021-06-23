package com.yuo.orecrop.gen;

import com.yuo.orecrop.Blocks.BlockRegistry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * 矿物生成
 */
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class OreSpawn {
	@SubscribeEvent
    public static void oreGenerate(FMLCommonSetupEvent event) {
        for (Biome biome : ForgeRegistries.BIOMES) { //主世界
            biome.addFeature(Decoration.UNDERGROUND_ORES,
                    Feature.ORE.withConfiguration(
                            new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                                    BlockRegistry.coalLeanOre.get().getDefaultState(), 17))
							.withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(16, 0, 0, 128)))
            		);
            biome.addFeature(Decoration.UNDERGROUND_ORES,
            		Feature.ORE.withConfiguration(
            				new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
            						BlockRegistry.diamondLeanOre.get().getDefaultState(), 8))
            				.withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(2, 0, 0, 16)))
            		);
            biome.addFeature(Decoration.UNDERGROUND_ORES,
            		Feature.ORE.withConfiguration(
            				new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
            						BlockRegistry.emeraldLeanOre.get().getDefaultState(), 6))
							.withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(4, 48, 0, 80)))
            		);
            biome.addFeature(Decoration.UNDERGROUND_ORES,
            		Feature.ORE.withConfiguration(
            				new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
            						BlockRegistry.goldLeanOre.get().getDefaultState(), 10))
							.withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(6, 0, 0, 32)))
            		);
            biome.addFeature(Decoration.UNDERGROUND_ORES,
            		Feature.ORE.withConfiguration(
            				new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
            						BlockRegistry.ironLeanOre.get().getDefaultState(), 15))
							.withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(16, 0, 0, 128)))
            		);
            biome.addFeature(Decoration.UNDERGROUND_ORES,
            		Feature.ORE.withConfiguration(
            				new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
            						BlockRegistry.lapisLeanOre.get().getDefaultState(), 10))
							.withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(8, 0, 0, 16)))
            		);
            biome.addFeature(Decoration.UNDERGROUND_ORES,
            		Feature.ORE.withConfiguration(
            				new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
            						BlockRegistry.quartzLeanOre.get().getDefaultState(), 6))
							.withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(6, 16, 0, 32)))
            		);
            biome.addFeature(Decoration.UNDERGROUND_ORES,
            		Feature.ORE.withConfiguration(
            				new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
            						BlockRegistry.redstoneLeanOre.get().getDefaultState(), 10))
							.withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(8, 0, 0, 16)))
            		);
        }
    }
}
