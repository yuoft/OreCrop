package com.yuo.orecrop.Event;

import com.yuo.orecrop.Items.ItemRegistry;
import com.yuo.orecrop.OreCrop;
import net.minecraft.block.BlockState;
import net.minecraft.block.TallGrassBlock;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.util.text.event.HoverEvent;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Random;
import java.util.UUID;

/**
 * 事件处理类
 */
@Mod.EventBusSubscriber(modid = OreCrop.MODID)
public class EventHandler {
    //贫矿种子掉落
    @SubscribeEvent
    public static void setBlock(BlockEvent.BreakEvent event){
        PlayerEntity player = event.getPlayer();
        World world = player.world;
        BlockPos pos = event.getPos();
        BlockState state = world.getBlockState(pos);
        EffectInstance luck = player.getActivePotionEffect(new EffectInstance(Effects.LUCK).getPotion());
        if (state.getBlock() instanceof TallGrassBlock){
            Random random = new Random();
            int lv = luck == null ? 0 : luck.getAmplifier();
            if (random.nextDouble() < 0.1 + lv * 0.1 && !world.isRemote){
                ItemEntity itemEntity = new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(),
                        new ItemStack(ItemRegistry.voidSeed.get(), 1));
                world.addEntity(itemEntity);
            }
        }
    }
    //玩家登入
    @SubscribeEvent
    public static void playerLogin(PlayerEvent.PlayerLoggedInEvent event){
        PlayerEntity player = event.getPlayer();
        //发送消息
        player.sendMessage(new TranslationTextComponent("orecrop.message.login")
                .setStyle(Style.EMPTY.setHoverEvent(HoverEvent.Action.SHOW_TEXT.deserialize(new TranslationTextComponent("orecrop.message.login0")))
                        .setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://space.bilibili.com/21854371"))), UUID.randomUUID());
    }
}

