package com.yuo.orecrop.Event;

import com.yuo.orecrop.Blocks.BlockRegistry;
import com.yuo.orecrop.Blocks.Crop.OreCropBlock;
import com.yuo.orecrop.Items.ItemRegistry;
import com.yuo.orecrop.OreCrop;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.TallGrassBlock;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Random;

/**
 * 事件处理类
 */
@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = OreCrop.MODID)
public class EventHandler {
    //贫矿种子掉落
    @SubscribeEvent
    public static void setBlock(BlockEvent.BreakEvent event){
        World world = event.getWorld().getWorld();
        BlockPos pos = event.getPos();
        BlockState state = world.getBlockState(pos);
        if (state.getBlock() instanceof TallGrassBlock){
            Random random = new Random();
            if (random.nextInt(100) > 94 && !world.isRemote){
                ItemEntity itemEntity = new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(),
                        new ItemStack(ItemRegistry.stemSeed.get(), 1));
                world.addEntity(itemEntity);
            }
        }
    }
}

