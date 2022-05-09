package com.yuo.orecrop.Blocks.Crop;

import com.yuo.orecrop.Blocks.BlockRegistry;
import com.yuo.orecrop.Items.ItemRegistry;
import com.yuo.orecrop.OreCrop;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropsBlock;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class OreCropBlock extends CropsBlock{

    public OreCropBlock(Properties builder) {
        super(builder);
    }

    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        if (entityIn instanceof LivingEntity && entityIn.getType() != EntityType.FOX && entityIn.getType() != EntityType.BEE) {
            entityIn.setMotionMultiplier(state, new Vector3d(0.8F, 0.75D, 0.8F));
            if (!worldIn.isRemote && state.get(AGE) > 0 && (entityIn.lastTickPosX != entityIn.getPosX() || entityIn.lastTickPosZ != entityIn.getPosZ())) {
                double d0 = Math.abs(entityIn.getPosX() - entityIn.lastTickPosX);
                double d1 = Math.abs(entityIn.getPosZ() - entityIn.lastTickPosZ);
                if (d0 >= (double)0.003F || d1 >= (double)0.003F) {
                    entityIn.attackEntityFrom(DamageSource.SWEET_BERRY_BUSH, 2.0F);
                }
            }
        }
    }

    //破坏掉落
    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        if (getAge(state) < 7) return Collections.singletonList(new ItemStack(this)); //不成熟，不掉落产物
        Item item = null;
        Block block = state.getBlock();
        if (block.equals(BlockRegistry.coalCrop.get())) item = ItemRegistry.coalFruit.get();
        if (block.equals(BlockRegistry.diamondCrop.get())) item = ItemRegistry.diamondFruit.get();
        if (block.equals(BlockRegistry.emeraldCrop.get())) item = ItemRegistry.emeraldFruit.get();
        if (block.equals(BlockRegistry.goldCrop.get()))  item = ItemRegistry.goldFruit.get();
        if (block.equals(BlockRegistry.ironCrop.get()))  item = ItemRegistry.ironFruit.get();
        if (block.equals(BlockRegistry.lapisCrop.get())) item = ItemRegistry.lapisFruit.get();
        if (block.equals(BlockRegistry.quartzCrop.get()))  item = ItemRegistry.quartzFruit.get();
        if (block.equals(BlockRegistry.redstoneCrop.get())) item = ItemRegistry.redstoneFruit.get();
        if (block.equals(BlockRegistry.netheriteCrop.get())) item = ItemRegistry.netheriteFruit.get();
        if (OreCrop.IS_SPACE_ARMS){
            if (block.equals(BlockRegistry.rubyCrop.get())) item = ItemRegistry.rubyFruit.get();
            if (block.equals(BlockRegistry.xrayCrop.get())) item = ItemRegistry.xrayFruit.get();
            if (block.equals(BlockRegistry.dragonCrop.get())) item = ItemRegistry.dragonFruit.get();
            if (block.equals(BlockRegistry.superCrop.get())) item = ItemRegistry.superFruit.get();
            if (block.equals(BlockRegistry.spaceCrop.get())) item = ItemRegistry.spaceFruit.get();
        }
        if (OreCrop.IS_ICE_AND_FIRE){
            if (block.equals(BlockRegistry.silverCrop.get())) item = ItemRegistry.silverFruit.get();
            if (block.equals(BlockRegistry.copperCrop.get())) item = ItemRegistry.copperFruit.get();
        }
        ItemStack stack = new ItemStack(item, MathHelper.nextInt(RANDOM, 1, 5));
        List<ItemStack> list = new ArrayList<>();
        list.add(stack);
        list.add(new ItemStack(this)); //破坏只掉一个种子
        return list;
    }

    //生长时间不同
    @Override
    public void grow(World worldIn, BlockPos pos, BlockState state) {
        Block block = state.getBlock();
        int k = 0;
        if (block.equals(BlockRegistry.coalCrop.get()) || block.equals(BlockRegistry.quartzCrop.get())
                || block.equals(BlockRegistry.lapisCrop.get()))
            k = MathHelper.nextInt(RANDOM, 2, 5);
        else if (block.equals(BlockRegistry.diamondCrop.get()) || block.equals(BlockRegistry.emeraldCrop.get()))
            k = MathHelper.nextInt(RANDOM, 1, 4);
        else if (block.equals(BlockRegistry.netheriteCrop.get()))
            k = MathHelper.nextInt(RANDOM, 1, 3);
        else if (OreCrop.IS_SPACE_ARMS){
            if (block.equals(BlockRegistry.rubyCrop.get())){
                k = MathHelper.nextInt(RANDOM, 1, 4);
            }else if (block.equals(BlockRegistry.xrayCrop.get()) || block.equals(BlockRegistry.dragonCrop.get())){
                k = MathHelper.nextInt(RANDOM, 0, 3);
            }else if (block.equals(BlockRegistry.superCrop.get()) || block.equals(BlockRegistry.spaceCrop.get())){
                k = MathHelper.nextInt(RANDOM, 0, 2);
            }
        }else if (OreCrop.IS_ICE_AND_FIRE){
            if (block.equals(BlockRegistry.silverCrop.get()) || block.equals(BlockRegistry.copperCrop.get())){
                k = MathHelper.nextInt(RANDOM, 1, 4);
            }
        } else k = MathHelper.nextInt(RANDOM, 2, 4);
        int i = this.getAge(state) + k;
        int j = this.getMaxAge();
        if (i > j) {
            i = j;
        }
        worldIn.setBlockState(pos, this.withAge(i), 2);
    }
    //玩家右键矿石作物收获
    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (getAge(state) != 7) return ActionResultType.FAIL;
        if (state.getBlock() instanceof OreCropBlock && !worldIn.isRemote){
            Block block = state.getBlock();
            Item item = null;
            Item blockItem = null;
            //根据不同作物，给予不同物品
            if (block.equals(BlockRegistry.coalCrop.get())) {
                item = ItemRegistry.coalFruit.get();
                blockItem = ItemRegistry.coalCropSeed.get();
            }
            if (block.equals(BlockRegistry.diamondCrop.get())) {
                item = ItemRegistry.diamondFruit.get();
                blockItem = ItemRegistry.diamondCropSeed.get();
            }
            if (block.equals(BlockRegistry.emeraldCrop.get())) {
                item = ItemRegistry.emeraldFruit.get();
                blockItem = ItemRegistry.emeraldCropSeed.get();
            }
            if (block.equals(BlockRegistry.goldCrop.get())) {
                item = ItemRegistry.goldFruit.get();
                blockItem = ItemRegistry.goldCropSeed.get();
            }
            if (block.equals(BlockRegistry.ironCrop.get())) {
                item = ItemRegistry.ironFruit.get();
                blockItem = ItemRegistry.ironCropSeed.get();
            }
            if (block.equals(BlockRegistry.lapisCrop.get())) {
                item = ItemRegistry.lapisFruit.get();
                blockItem = ItemRegistry.lapisCropSeed.get();
            }
            if (block.equals(BlockRegistry.quartzCrop.get())) {
                item = ItemRegistry.quartzFruit.get();
                blockItem = ItemRegistry.quartzCropSeed.get();
            }
            if (block.equals(BlockRegistry.redstoneCrop.get())){
                item = ItemRegistry.redstoneFruit.get();
                blockItem = ItemRegistry.redstoneCropSeed.get();
            }
            if (block.equals(BlockRegistry.netheriteCrop.get())){
                item = ItemRegistry.netheriteFruit.get();
                blockItem = ItemRegistry.netheriteCropSeed.get();
            }
            if (OreCrop.IS_SPACE_ARMS){
                if (block.equals(BlockRegistry.rubyCrop.get())){
                    item = ItemRegistry.rubyFruit.get();
                    blockItem = ItemRegistry.rubyCropSeed.get();
                }
                if (block.equals(BlockRegistry.dragonCrop.get())){
                    item = ItemRegistry.dragonFruit.get();
                    blockItem = ItemRegistry.dragonCropSeed.get();
                }
                if (block.equals(BlockRegistry.xrayCrop.get())){
                    item = ItemRegistry.xrayFruit.get();
                    blockItem = ItemRegistry.xrayCropSeed.get();
                }
                if (block.equals(BlockRegistry.superCrop.get())){
                    item = ItemRegistry.superFruit.get();
                    blockItem = ItemRegistry.superCropSeed.get();
                }
                if (block.equals(BlockRegistry.spaceCrop.get())){
                    item = ItemRegistry.spaceFruit.get();
                    blockItem = ItemRegistry.spaceCropSeed.get();
                }
            }
            if (OreCrop.IS_ICE_AND_FIRE){
                if (block.equals(BlockRegistry.silverCrop.get())){
                    item = ItemRegistry.silverFruit.get();
                    blockItem = ItemRegistry.silverCropSeed.get();
                }
                if (block.equals(BlockRegistry.copperCrop.get())){
                    item = ItemRegistry.copperFruit.get();
                    blockItem = ItemRegistry.copperCropSeed.get();
                }
            }
            int fortune = EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE, player.getActiveItemStack());
            ItemStack stack = new ItemStack(item, MathHelper.nextInt(RANDOM, 1 + MathHelper.nextInt(RANDOM, 0, fortune),
                    8 + 3 * (MathHelper.nextInt(RANDOM, 0, fortune) + 1)));
            OreCropBlock block1 = (OreCropBlock) state.getBlock();
            worldIn.setBlockState(pos, block1.withAge(0), 2); //设置作物为初始状态
            ItemEntity itemEntity = new ItemEntity(worldIn, pos.getX(), pos.getY(), pos.getZ(), stack);
            worldIn.addEntity(itemEntity);
            if (RANDOM.nextDouble() > 0.9d - 0.06 * fortune){ //5%概率额外掉落种子
                ItemStack stack1 = new ItemStack(blockItem, MathHelper.nextInt(RANDOM, 0, 4) + RANDOM.nextInt(fortune));
                ItemEntity itemEntity1 = new ItemEntity(worldIn, pos.getX(), pos.getY(), pos.getZ(), stack1);
                worldIn.addEntity(itemEntity1);
            }
        }
        return ActionResultType.SUCCESS;
    }
    //不能使用骨粉催熟
    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
        return false;
    }
}
