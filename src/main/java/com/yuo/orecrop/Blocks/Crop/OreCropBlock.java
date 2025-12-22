package com.yuo.orecrop.Blocks.Crop;

import com.yuo.orecrop.Blocks.OreCropBlocks;
import com.yuo.orecrop.Items.OreCropItems;
import com.yuo.orecrop.OreCrop;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.storage.loot.LootParams.Builder;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class OreCropBlock extends SweetBerryBushBlock {

    public OreCropBlock(Properties builder) {
        super(builder);
    }

    @Override
    public void entityInside(BlockState state, Level worldIn, BlockPos pos, Entity entityIn) {
        if (entityIn instanceof LivingEntity && entityIn.getType() != EntityType.FOX && entityIn.getType() != EntityType.BEE) {
            entityIn.makeStuckInBlock(state, new Vec3(0.8F, 0.75D, 0.8F));
            if (!worldIn.isClientSide && state.getValue(AGE) > 0 && (entityIn.xOld != entityIn.getBlockX() || entityIn.zOld != entityIn.getBlockZ())) {
                double d0 = Math.abs(entityIn.getBlockX() - entityIn.xOld);
                double d1 = Math.abs(entityIn.getBlockZ() - entityIn.zOld);
                if (d0 >= (double)0.003F || d1 >= (double)0.003F) {
                    entityIn.hurt(worldIn.damageSources().sweetBerryBush(), 2.0F);
                }
            }
        }
    }

    //破坏掉落
    @Override
    public List<ItemStack> getDrops(BlockState state, Builder builder) {
        if (getAge(state) < 3) return Collections.singletonList(new ItemStack(this)); //不成熟，不掉落产物
        Item item = null;
        Block block = state.getBlock();
        if (block.equals(OreCropBlocks.coalCrop.get())) item = OreCropItems.coalFruit.get();
        if (block.equals(OreCropBlocks.diamondCrop.get())) item = OreCropItems.diamondFruit.get();
        if (block.equals(OreCropBlocks.emeraldCrop.get())) item = OreCropItems.emeraldFruit.get();
        if (block.equals(OreCropBlocks.goldCrop.get()))  item = OreCropItems.goldFruit.get();
        if (block.equals(OreCropBlocks.ironCrop.get()))  item = OreCropItems.ironFruit.get();
        if (block.equals(OreCropBlocks.lapisCrop.get())) item = OreCropItems.lapisFruit.get();
        if (block.equals(OreCropBlocks.quartzCrop.get()))  item = OreCropItems.quartzFruit.get();
        if (block.equals(OreCropBlocks.redstoneCrop.get())) item = OreCropItems.redstoneFruit.get();
        if (block.equals(OreCropBlocks.netheriteCrop.get())) item = OreCropItems.netheriteFruit.get();
        if (block.equals(OreCropBlocks.copperCrop.get())) item = OreCropItems.copperFruit.get();
        if (OreCrop.IS_SPACE_ARMS){
            if (block.equals(OreCropBlocks.rubyCrop.get())) item = OreCropItems.rubyFruit.get();
            if (block.equals(OreCropBlocks.xrayCrop.get())) item = OreCropItems.xrayFruit.get();
            if (block.equals(OreCropBlocks.dragonCrop.get())) item = OreCropItems.dragonFruit.get();
            if (block.equals(OreCropBlocks.superCrop.get())) item = OreCropItems.superFruit.get();
            if (block.equals(OreCropBlocks.spaceCrop.get())) item = OreCropItems.spaceFruit.get();
        }
        if (OreCrop.IS_ICE_AND_FIRE){
            if (block.equals(OreCropBlocks.silverCrop.get())) item = OreCropItems.silverFruit.get();
        }
        if (OreCrop.IS_BOT){
            if (block.equals(OreCropBlocks.manasteelCrop.get())) item = OreCropItems.manasteelFruit.get();
            if (block.equals(OreCropBlocks.terrasteelCrop.get())) item = OreCropItems.terrasteelFruit.get();
            if (block.equals(OreCropBlocks.elementiumCrop.get())) item = OreCropItems.elementiumFruit.get();
            if (block.equals(OreCropBlocks.gaiaCrop.get())) item = OreCropItems.gaiaFruit.get();
        }
        if (OreCrop.IS_DE){
            if (block.equals(OreCropBlocks.draconiumCrop.get())) item = OreCropItems.draconiumFruit.get();
            if (block.equals(OreCropBlocks.awakenedDraconiumCrop.get())) item = OreCropItems.awakenedDraconiumFruit.get();
        }

        ItemStack stack = new ItemStack(item, Mth.nextInt(builder.getLevel().random, 1, 5));
        List<ItemStack> list = new ArrayList<>();
        list.add(stack);
        list.add(new ItemStack(this)); //破坏只掉一个种子
        return list;
    }

    @Override
    public void performBonemeal(ServerLevel world, RandomSource random, BlockPos pos, BlockState state) {
        int i = Math.min(this.getMaxAge(), this.getAge(state) + random.nextInt(2));
        world.setBlock(pos, this.withAge(i), 2);
    }

    //玩家右键矿石作物收获

    @Override
    public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult hit) {
        if (getAge(state) != 3) return InteractionResult.PASS;
        if (state.getBlock() instanceof OreCropBlock && !worldIn.isClientSide){
            Block block = state.getBlock();
            Item item = null;
            Item blockItem = null;
            //根据不同作物，给予不同物品
            if (block.equals(OreCropBlocks.coalCrop.get())) {
                item = OreCropItems.coalFruit.get();
                blockItem = OreCropItems.coalCropSeed.get();
            }
            if (block.equals(OreCropBlocks.diamondCrop.get())) {
                item = OreCropItems.diamondFruit.get();
                blockItem = OreCropItems.diamondCropSeed.get();
            }
            if (block.equals(OreCropBlocks.emeraldCrop.get())) {
                item = OreCropItems.emeraldFruit.get();
                blockItem = OreCropItems.emeraldCropSeed.get();
            }
            if (block.equals(OreCropBlocks.goldCrop.get())) {
                item = OreCropItems.goldFruit.get();
                blockItem = OreCropItems.goldCropSeed.get();
            }
            if (block.equals(OreCropBlocks.ironCrop.get())) {
                item = OreCropItems.ironFruit.get();
                blockItem = OreCropItems.ironCropSeed.get();
            }
            if (block.equals(OreCropBlocks.lapisCrop.get())) {
                item = OreCropItems.lapisFruit.get();
                blockItem = OreCropItems.lapisCropSeed.get();
            }
            if (block.equals(OreCropBlocks.quartzCrop.get())) {
                item = OreCropItems.quartzFruit.get();
                blockItem = OreCropItems.quartzCropSeed.get();
            }
            if (block.equals(OreCropBlocks.redstoneCrop.get())){
                item = OreCropItems.redstoneFruit.get();
                blockItem = OreCropItems.redstoneCropSeed.get();
            }
            if (block.equals(OreCropBlocks.netheriteCrop.get())){
                item = OreCropItems.netheriteFruit.get();
                blockItem = OreCropItems.netheriteCropSeed.get();
            }
            if (OreCrop.IS_SPACE_ARMS){
                if (block.equals(OreCropBlocks.rubyCrop.get())){
                    item = OreCropItems.rubyFruit.get();
                    blockItem = OreCropItems.rubyCropSeed.get();
                }
                if (block.equals(OreCropBlocks.dragonCrop.get())){
                    item = OreCropItems.dragonFruit.get();
                    blockItem = OreCropItems.dragonCropSeed.get();
                }
                if (block.equals(OreCropBlocks.xrayCrop.get())){
                    item = OreCropItems.xrayFruit.get();
                    blockItem = OreCropItems.xrayCropSeed.get();
                }
                if (block.equals(OreCropBlocks.superCrop.get())){
                    item = OreCropItems.superFruit.get();
                    blockItem = OreCropItems.superCropSeed.get();
                }
                if (block.equals(OreCropBlocks.spaceCrop.get())){
                    item = OreCropItems.spaceFruit.get();
                    blockItem = OreCropItems.spaceCropSeed.get();
                }
            }
            if (OreCrop.IS_ICE_AND_FIRE){
                if (block.equals(OreCropBlocks.silverCrop.get())){
                    item = OreCropItems.silverFruit.get();
                    blockItem = OreCropItems.silverCropSeed.get();
                }
                if (block.equals(OreCropBlocks.copperCrop.get())){
                    item = OreCropItems.copperFruit.get();
                    blockItem = OreCropItems.copperCropSeed.get();
                }
            }
            if (OreCrop.IS_BOT){
                if (block.equals(OreCropBlocks.manasteelCrop.get())){
                    item = OreCropItems.manasteelFruit.get();
                    blockItem = OreCropItems.manasteelCropSeed.get();
                }
                if (block.equals(OreCropBlocks.terrasteelCrop.get())){
                    item = OreCropItems.terrasteelFruit.get();
                    blockItem = OreCropItems.terrasteelCropSeed.get();
                }
                if (block.equals(OreCropBlocks.elementiumCrop.get())){
                    item = OreCropItems.elementiumFruit.get();
                    blockItem = OreCropItems.elementiumCropSeed.get();
                }
                if (block.equals(OreCropBlocks.gaiaCrop.get())){
                    item = OreCropItems.gaiaFruit.get();
                    blockItem = OreCropItems.gaiaCropSeed.get();
                }
            }
            if (OreCrop.IS_DE){
                if (block.equals(OreCropBlocks.awakenedDraconiumCrop.get())){
                    item = OreCropItems.awakenedDraconiumFruit.get();
                    blockItem = OreCropItems.awakenedDraconiumCropSeed.get();
                }
                if (block.equals(OreCropBlocks.draconiumCrop.get())){
                    item = OreCropItems.draconiumFruit.get();
                    blockItem = OreCropItems.draconiumCropSeed.get();
                }
            }

            if (item == null) item = ItemStack.EMPTY.getItem();
            if (blockItem == null) blockItem = ItemStack.EMPTY.getItem();

            RandomSource random = worldIn.random;
            int fortune = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.BLOCK_FORTUNE, player.getUseItem());
            int num = Mth.nextInt(random, 1 + Mth.nextInt(random, 0, fortune),
                    8 + 3 * (Mth.nextInt(random, 0, fortune) + 1));
            popResource(worldIn, pos, new ItemStack(item, num));
            worldIn.playSound(null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + random.nextFloat() * 0.4F);
            worldIn.setBlock(pos, state.setValue(AGE, 0), 2);//设置作物为初始状态

            if (random.nextDouble() > 0.9d - 0.06 * fortune){ //5%概率额外掉落种子
                popResource(worldIn, pos, new ItemStack(blockItem, 1));
            }
        }
        return InteractionResult.SUCCESS;
    }
    //不能使用骨粉催熟

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos p_222560_, BlockState p_222561_) {
        return random.nextDouble() < 0.2d;
    }

    public int getMaxAge() {
        return 3;
    }

    protected int getAge(BlockState state) {
        return state.getValue(this.getAgeProperty());
    }

    public BlockState withAge(int i) {
        return this.defaultBlockState().setValue(this.getAgeProperty(), i);
    }

    public IntegerProperty getAgeProperty() {
        return AGE;
    }
}
