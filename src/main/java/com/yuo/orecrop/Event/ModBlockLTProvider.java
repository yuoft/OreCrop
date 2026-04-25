package com.yuo.orecrop.Event;

import com.github.alexthe666.iceandfire.item.IafItemRegistry;
import com.yuo.orecrop.Blocks.OreCropBlocks;
import com.yuo.orecrop.Items.OreCropItems;
import com.yuo.orecrop.OreCrop;
import com.yuo.spacearms.Items.SAItems;
import net.minecraft.advancements.critereon.EnchantmentPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds.Ints;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolSingletonContainer;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import org.jetbrains.annotations.NotNull;
import vazkii.botania.common.item.BotaniaItems;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ModBlockLTProvider extends BlockLootSubProvider {
    private static final LootItemCondition.Builder HAS_SILK_TOUCH = MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, Ints.atLeast(1))));
    private static final LootItemCondition.Builder NO_SILK_TOUCH = HAS_SILK_TOUCH.invert();
    private static final float[] NORMAL_LEAVES_INGOT_CHANCES = new float[]{0.05f, 0.15f, 0.35f, 0.55f, 0.99f};
    private static final float[] NORMAL_LEAVES_NUGGET_CHANCES = new float[]{0.1f, 0.3f, 0.5f, 0.7f, 0.999f};
    private static final float[] NORMAL_LEAVES_SAPLING_CHANCES = new float[]{0.05F, 0.0625F, 0.083333336F, 0.1F};
    private static final float[] NORMAL_LEAVES_STICK_CHANCES = new float[]{0.02F, 0.022222223F, 0.025F, 0.033333335F, 0.1F};
    public static final Set<Block> BASE_BLOCKS = Set.of(
            OreCropBlocks.oreLog.get(), OreCropBlocks.customSapling.get(),
            OreCropBlocks.coalLeaf.get(), OreCropBlocks.coalSapling.get(),
            OreCropBlocks.diamondLeaf.get(), OreCropBlocks.diamondSapling.get(),
            OreCropBlocks.emeraldLeaf.get(), OreCropBlocks.emeraldSapling.get(),
            OreCropBlocks.goldLeaf.get(), OreCropBlocks.goldSapling.get(),
            OreCropBlocks.ironLeaf.get(), OreCropBlocks.ironSapling.get(),
            OreCropBlocks.lapisLeaf.get(), OreCropBlocks.lapisSapling.get(),
            OreCropBlocks.quartzLeaf.get(), OreCropBlocks.quartzSapling.get(),
            OreCropBlocks.netheriteLeaf.get(), OreCropBlocks.netheriteSapling.get(),
            OreCropBlocks.redstoneLeaf.get(), OreCropBlocks.redstoneSapling.get(),
            OreCropBlocks.copperLeaf.get(), OreCropBlocks.copperSapling.get());
    private final Set<Block> ALL_BLOCKS;

    protected ModBlockLTProvider() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());

        // 在构造器中初始化所有方块
        Set<Block> blocks = new HashSet<>(BASE_BLOCKS);

        // 根据条件添加其他mod的方块
        if (OreCrop.IS_ICE_AND_FIRE) {
            blocks.addAll(Set.of(OreCropBlocks.silverLeaf.get(), OreCropBlocks.silverSapling.get()));
        }

        if (OreCrop.IS_SPACE_ARMS) {
            blocks.addAll(Set.of(OreCropBlocks.rubyLeaf.get(), OreCropBlocks.rubySapling.get(),
                    OreCropBlocks.dragonLeaf.get(), OreCropBlocks.dragonSapling.get(),
                    OreCropBlocks.xrayLeaf.get(), OreCropBlocks.xraySapling.get(),
                    OreCropBlocks.superLeaf.get(), OreCropBlocks.superSapling.get(),
                    OreCropBlocks.spaceLeaf.get(), OreCropBlocks.spaceSapling.get()));
        }

        if (OreCrop.IS_BOT) {
            blocks.addAll(Set.of(OreCropBlocks.manasteelLeaf.get(), OreCropBlocks.manasteelSapling.get(),
                    OreCropBlocks.terrasteelLeaf.get(), OreCropBlocks.terrasteelSapling.get(),
                    OreCropBlocks.elementiumLeaf.get(), OreCropBlocks.elementiumSapling.get(),
                    OreCropBlocks.gaiaLeaf.get(), OreCropBlocks.gaiaSapling.get()));
        }

        if (OreCrop.IS_DE) {
            blocks.addAll(Set.of(OreCropBlocks.draconiumLeaf.get(), OreCropBlocks.draconiumSapling.get(),
                    OreCropBlocks.awakenedDraconiumLeaf.get(), OreCropBlocks.awakenedDraconiumSapling.get()));
        }

        this.ALL_BLOCKS = Collections.unmodifiableSet(blocks);
    }


    @SuppressWarnings("removal")
    @Override
    protected void generate() {
        add(OreCropBlocks.oreLog.get(), this.createSingleItemTable(OreCropBlocks.oreLog.get()));
        add(OreCropBlocks.customSapling.get(), this.createSingleItemTable(OreCropBlocks.customSapling.get()));

         add(OreCropBlocks.coalSapling.get(), this.createSingleItemTable(OreCropBlocks.coalSapling.get()));
         add(OreCropBlocks.coalLeaf.get(), this.createModLeavesDrops(OreCropBlocks.coalLeaf.get(), OreCropBlocks.coalSapling.get(), Items.COAL, OreCropItems.coalNugget.get(), 5,  NORMAL_LEAVES_STICK_CHANCES));
         add(OreCropBlocks.diamondSapling.get(), this.createSingleItemTable(OreCropBlocks.diamondSapling.get()));
         add(OreCropBlocks.diamondLeaf.get(), this.createModLeavesDrops(OreCropBlocks.diamondLeaf.get(), OreCropBlocks.diamondSapling.get(), Items.DIAMOND, OreCropItems.diamondNugget.get(), 3, NORMAL_LEAVES_STICK_CHANCES));
         add(OreCropBlocks.emeraldSapling.get(), this.createSingleItemTable(OreCropBlocks.emeraldSapling.get()));
         add(OreCropBlocks.emeraldLeaf.get(), this.createModLeavesDrops(OreCropBlocks.emeraldLeaf.get(), OreCropBlocks.emeraldSapling.get(), Items.EMERALD, OreCropItems.emeraldNugget.get(), 3, NORMAL_LEAVES_STICK_CHANCES));
         add(OreCropBlocks.goldSapling.get(), this.createSingleItemTable(OreCropBlocks.goldSapling.get()));
         add(OreCropBlocks.goldLeaf.get(), this.createModLeavesDrops(OreCropBlocks.goldLeaf.get(), OreCropBlocks.goldSapling.get(), Items.GOLD_INGOT, Items.GOLD_NUGGET, 4, NORMAL_LEAVES_STICK_CHANCES));
         add(OreCropBlocks.ironSapling.get(), this.createSingleItemTable(OreCropBlocks.ironSapling.get()));
         add(OreCropBlocks.ironLeaf.get(), this.createModLeavesDrops(OreCropBlocks.ironLeaf.get(), OreCropBlocks.ironSapling.get(), Items.IRON_INGOT, Items.IRON_NUGGET, 4, NORMAL_LEAVES_STICK_CHANCES));
         add(OreCropBlocks.lapisSapling.get(), this.createSingleItemTable(OreCropBlocks.lapisSapling.get()));
         add(OreCropBlocks.lapisLeaf.get(), this.createModLeavesDrops(OreCropBlocks.lapisLeaf.get(), OreCropBlocks.lapisSapling.get(), Items.LAPIS_LAZULI, OreCropItems.lapisNugget.get(), 5,  NORMAL_LEAVES_STICK_CHANCES));
         add(OreCropBlocks.quartzSapling.get(), this.createSingleItemTable(OreCropBlocks.quartzSapling.get()));
         add(OreCropBlocks.quartzLeaf.get(), this.createModLeavesDrops(OreCropBlocks.quartzLeaf.get(), OreCropBlocks.quartzSapling.get(), Items.QUARTZ, OreCropItems.quartzNugget.get(), 5,  NORMAL_LEAVES_STICK_CHANCES));
         add(OreCropBlocks.netheriteSapling.get(), this.createSingleItemTable(OreCropBlocks.netheriteSapling.get()));
         add(OreCropBlocks.netheriteLeaf.get(), this.createModLeavesDrops(OreCropBlocks.netheriteLeaf.get(), OreCropBlocks.netheriteSapling.get(), Items.NETHERITE_SCRAP, OreCropItems.netheriteNugget.get(), 2, NORMAL_LEAVES_STICK_CHANCES));
         add(OreCropBlocks.redstoneSapling.get(), this.createSingleItemTable(OreCropBlocks.redstoneSapling.get()));
         add(OreCropBlocks.redstoneLeaf.get(), this.createModLeavesDrops(OreCropBlocks.redstoneLeaf.get(), OreCropBlocks.redstoneSapling.get(), Items.REDSTONE, OreCropItems.redstoneNugget.get(), 5,  NORMAL_LEAVES_STICK_CHANCES));
         add(OreCropBlocks.copperSapling.get(), this.createSingleItemTable(OreCropBlocks.copperSapling.get()));
         add(OreCropBlocks.copperLeaf.get(), this.createModLeavesDrops(OreCropBlocks.copperLeaf.get(), OreCropBlocks.copperSapling.get(), Items.COPPER_INGOT, OreCropItems.copperNugget.get(),5,  NORMAL_LEAVES_STICK_CHANCES));

        if (OreCrop.IS_ICE_AND_FIRE){
            add(OreCropBlocks.silverSapling.get(), this.createSingleItemTable(OreCropBlocks.silverSapling.get()));
            add(OreCropBlocks.silverLeaf.get(), this.createModLeavesDrops(OreCropBlocks.silverLeaf.get(), OreCropBlocks.silverSapling.get(), IafItemRegistry.SILVER_INGOT.get(), IafItemRegistry.SILVER_NUGGET.get(), 4, NORMAL_LEAVES_STICK_CHANCES));
        }

        if (OreCrop.IS_BOT){
            add(OreCropBlocks.manasteelSapling.get(), this.createSingleItemTable(OreCropBlocks.manasteelSapling.get()));
            add(OreCropBlocks.manasteelLeaf.get(), this.createModLeavesDrops(OreCropBlocks.manasteelLeaf.get(), OreCropBlocks.manasteelSapling.get(), BotaniaItems.manaSteel, BotaniaItems.manasteelNugget, 4, NORMAL_LEAVES_STICK_CHANCES));
            add(OreCropBlocks.terrasteelSapling.get(), this.createSingleItemTable(OreCropBlocks.terrasteelSapling.get()));
            add(OreCropBlocks.terrasteelLeaf.get(), this.createModLeavesDrops(OreCropBlocks.terrasteelLeaf.get(), OreCropBlocks.terrasteelSapling.get(), BotaniaItems.terrasteel, BotaniaItems.terrasteelNugget, 3, NORMAL_LEAVES_STICK_CHANCES));
            add(OreCropBlocks.elementiumSapling.get(), this.createSingleItemTable(OreCropBlocks.elementiumSapling.get()));
            add(OreCropBlocks.elementiumLeaf.get(), this.createModLeavesDrops(OreCropBlocks.elementiumLeaf.get(), OreCropBlocks.elementiumSapling.get(), BotaniaItems.elementium, BotaniaItems.elementiumNugget, 2, NORMAL_LEAVES_STICK_CHANCES));
            add(OreCropBlocks.gaiaSapling.get(), this.createSingleItemTable(OreCropBlocks.gaiaSapling.get()));
            add(OreCropBlocks.gaiaLeaf.get(), this.createModLeavesDrops(OreCropBlocks.gaiaLeaf.get(), OreCropBlocks.gaiaSapling.get(), BotaniaItems.gaiaIngot, OreCropItems.gaiaNugget.get(), 1, NORMAL_LEAVES_STICK_CHANCES));
        }

        if (OreCrop.IS_DE){
            Item draconiumIngot = BuiltInRegistries.ITEM.get(new ResourceLocation("draconicevolution:draconium_ingot"));
            Item draconiumNugget = BuiltInRegistries.ITEM.get(new ResourceLocation("draconicevolution:draconium_nugget"));
            Item awakenedDraconiumIngot = BuiltInRegistries.ITEM.get(new ResourceLocation("draconicevolution:awakened_draconium_ingot"));
            Item awakenedDraconiumNugget = BuiltInRegistries.ITEM.get(new ResourceLocation("draconicevolution:awakened_draconium_nugget"));
            add(OreCropBlocks.draconiumSapling.get(), this.createSingleItemTable(OreCropBlocks.draconiumSapling.get()));
            if (draconiumIngot != Items.AIR && draconiumNugget != Items.AIR){
                add(OreCropBlocks.draconiumLeaf.get(), this.createModLeavesDrops(OreCropBlocks.draconiumLeaf.get(), OreCropBlocks.draconiumSapling.get(), draconiumIngot, draconiumNugget, 2, NORMAL_LEAVES_STICK_CHANCES));
            }

            add(OreCropBlocks.awakenedDraconiumSapling.get(), this.createSingleItemTable(OreCropBlocks.awakenedDraconiumSapling.get()));
            if (awakenedDraconiumIngot != Items.AIR && awakenedDraconiumNugget != Items.AIR){
                add(OreCropBlocks.awakenedDraconiumLeaf.get(), this.createModLeavesDrops(OreCropBlocks.awakenedDraconiumLeaf.get(), OreCropBlocks.awakenedDraconiumSapling.get(), awakenedDraconiumIngot, awakenedDraconiumNugget,1,  NORMAL_LEAVES_STICK_CHANCES));
            }
        }

        if (OreCrop.IS_SPACE_ARMS){
            add(OreCropBlocks.rubySapling.get(), this.createSingleItemTable(OreCropBlocks.rubySapling.get()));
            add(OreCropBlocks.rubyLeaf.get(), this.createModLeavesDrops(OreCropBlocks.rubyLeaf.get(), OreCropBlocks.rubySapling.get(), SAItems.ruby.get(), OreCropItems.rubyNugget.get(), 4, NORMAL_LEAVES_STICK_CHANCES));
            add(OreCropBlocks.dragonSapling.get(), this.createSingleItemTable(OreCropBlocks.dragonSapling.get()));
            add(OreCropBlocks.dragonLeaf.get(), this.createModLeavesDrops(OreCropBlocks.dragonLeaf.get(), OreCropBlocks.dragonSapling.get(), SAItems.dragonCrystal.get(), OreCropItems.dragonNugget.get(), 2, NORMAL_LEAVES_STICK_CHANCES));
            add(OreCropBlocks.xraySapling.get(), this.createSingleItemTable(OreCropBlocks.xraySapling.get()));
            add(OreCropBlocks.xrayLeaf.get(), this.createModLeavesDrops(OreCropBlocks.xrayLeaf.get(), OreCropBlocks.xraySapling.get(), SAItems.xrayIngot.get(), OreCropItems.xrayNugget.get(), 3, NORMAL_LEAVES_STICK_CHANCES));
            add(OreCropBlocks.superSapling.get(), this.createSingleItemTable(OreCropBlocks.superSapling.get()));
            add(OreCropBlocks.superLeaf.get(), this.createModLeavesDrops(OreCropBlocks.superLeaf.get(), OreCropBlocks.superSapling.get(), SAItems.superIngot.get(), OreCropItems.superNugget.get(), 2, NORMAL_LEAVES_STICK_CHANCES));
            add(OreCropBlocks.spaceSapling.get(), this.createSingleItemTable(OreCropBlocks.spaceSapling.get()));
            add(OreCropBlocks.spaceLeaf.get(), this.createModLeavesDrops(OreCropBlocks.spaceLeaf.get(), OreCropBlocks.spaceSapling.get(), SAItems.spaceIngot.get(), OreCropItems.spaceNugget.get(), 1, NORMAL_LEAVES_STICK_CHANCES));
        }
    }

    private LootTable.Builder createModLeavesDrops(Block leaf, Block sapling, Item ingot, Item nugget, int maxDropCount, float... floats) {
        // 基础掉落：树叶本身的掉落（包含树苗）
        LootTable.Builder builder = this.createLeavesDrops(leaf, sapling, floats);

        // 添加矿锭掉落池（无精准采集限制）
        builder.withPool(LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1.0F))
                .when(NO_SILK_TOUCH) // 只有非精准采集时才掉落矿锭
                .add(this.applyExplosionCondition(leaf, LootItem.lootTableItem(ingot)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, maxDropCount))))
                        .when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, NORMAL_LEAVES_INGOT_CHANCES))));

        builder.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(NO_SILK_TOUCH)
                .add(this.applyExplosionCondition(leaf, LootItem.lootTableItem(nugget)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(maxDropCount, maxDropCount * 2))))
                        .when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, NORMAL_LEAVES_NUGGET_CHANCES))));

        return builder;
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return ALL_BLOCKS;
    }
}
