package com.yuo.orecrop.Blocks.Crop;

import com.yuo.orecrop.Blocks.BlockRegistry;
import com.yuo.orecrop.Items.ItemRegistry;
import com.yuo.orecrop.OreCrop;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.state.IntegerProperty;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class OreCropBlock extends SweetBerryBushBlock {

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
        if (getAge(state) < 3) return Collections.singletonList(new ItemStack(this)); //不成熟，不掉落产物
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
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        int i = Math.min(this.getMaxAge(), this.getAge(state) + random.nextInt(2));
        world.setBlockState(pos, this.withAge(i), 2);
    }


    //玩家右键矿石作物收获
    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (getAge(state) != 3) return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
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
            int num = MathHelper.nextInt(RANDOM, 1 + MathHelper.nextInt(RANDOM, 0, fortune),
                    8 + 3 * (MathHelper.nextInt(RANDOM, 0, fortune) + 1));
            spawnAsEntity(worldIn, pos, new ItemStack(item, num));
            worldIn.playSound(null, pos, SoundEvents.ITEM_SWEET_BERRIES_PICK_FROM_BUSH, SoundCategory.BLOCKS, 1.0F, 0.8F + worldIn.rand.nextFloat() * 0.4F);
            worldIn.setBlockState(pos, state.with(AGE, 0), 2);//设置作物为初始状态

            if (RANDOM.nextDouble() > 0.9d - 0.06 * fortune){ //5%概率额外掉落种子
                spawnAsEntity(worldIn, pos, new ItemStack(blockItem, 1));
            }
        }
        return ActionResultType.SUCCESS;
    }
    //不能使用骨粉催熟
    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
        return false;
    }

    public int getMaxAge() {
        return 3;
    }

    protected int getAge(BlockState state) {
        return state.get(this.getAgeProperty());
    }

    public BlockState withAge(int i) {
        return this.getDefaultState().with(this.getAgeProperty(), i);
    }

    public IntegerProperty getAgeProperty() {
        return AGE;
    }
}
