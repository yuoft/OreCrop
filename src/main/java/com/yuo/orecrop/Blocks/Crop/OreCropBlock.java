package com.yuo.orecrop.Blocks.Crop;

import com.yuo.orecrop.Blocks.BlockRegistry;
import com.yuo.orecrop.Items.ItemRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropsBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OreCropBlock extends CropsBlock{

    public OreCropBlock(Properties builder) {
        super(builder);
    }

    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        if (entityIn instanceof LivingEntity && entityIn.getType() != EntityType.FOX && entityIn.getType() != EntityType.BEE) {
            entityIn.setMotionMultiplier(state, new Vec3d((double)0.8F, 0.75D, (double)0.8F));
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
        if (getAge(state) != 7) return null; //为成熟，则不掉落
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
        ItemStack stack = new ItemStack(item, RANDOM.nextInt(2) + 1);
        List<ItemStack> list = new ArrayList<>();
        list.add(stack);
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
            k = MathHelper.nextInt(RANDOM, 1, 3);
        else k = MathHelper.nextInt(RANDOM, 2, 4);
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
            Random random = new Random();
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
            ItemStack stack = new ItemStack(item, random.nextInt(2) + 1);
            OreCropBlock block1 = (OreCropBlock) state.getBlock();
            worldIn.setBlockState(pos, block1.withAge(0), 2); //设置作物为初始状态
            ItemEntity itemEntity = new ItemEntity(worldIn, pos.getX(), pos.getY(), pos.getZ(), stack);
            worldIn.addEntity(itemEntity);
            if (random.nextInt(100) > 94){ //5%概率掉落种子
                ItemStack stack1 = new ItemStack(blockItem, 1);
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
