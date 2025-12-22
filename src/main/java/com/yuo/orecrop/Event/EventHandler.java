package com.yuo.orecrop.Event;

import com.yuo.orecrop.Items.OreCropItems;
import com.yuo.orecrop.OreCrop;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.ClickEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.HoverEvent;
import net.minecraft.network.chat.Style;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TridentItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.TallGrassBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Random;

/**
 * 事件处理类
 */
@Mod.EventBusSubscriber(modid = OreCrop.MOD_ID)
public class EventHandler {
    //贫矿种子掉落
    @SubscribeEvent
    public static void setBlock(BlockEvent.BreakEvent event){
        Player player = event.getPlayer();
        Level world = player.level();
        BlockPos pos = event.getPos();
        BlockState state = world.getBlockState(pos);
        MobEffectInstance luck = player.getEffect(new MobEffectInstance(MobEffects.LUCK).getEffect());
        if (state.getBlock() instanceof TallGrassBlock){
            Random random = new Random();
            int lv = luck == null ? 0 : luck.getAmplifier();
            if (random.nextDouble() < 0.1 + lv * 0.1 && !world.isClientSide){
                ItemEntity itemEntity = new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(),
                        new ItemStack(OreCropItems.voidSeed.get(), 1));
                world.addFreshEntity(itemEntity);
            }
        }
    }
    //玩家登入
    @SubscribeEvent
    public static void playerLogin(PlayerEvent.PlayerLoggedInEvent event){
        Player player = event.getEntity();
        //发送消息
        player.sendSystemMessage(Component.translatable("orecrop.message.login")
                .setStyle(Style.EMPTY.withHoverEvent(HoverEvent.Action.SHOW_TEXT.deserializeFromLegacy(Component.translatable("orecrop.message.login0")))
                        .withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://space.bilibili.com/21854371"))));
    }
}

