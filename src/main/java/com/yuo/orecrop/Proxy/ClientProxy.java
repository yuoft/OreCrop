package com.yuo.orecrop.Proxy;

import com.yuo.orecrop.Blocks.OreCropBlocks;
import com.yuo.orecrop.Blocks.Tree.OreSapling;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.entity.DisplayRenderer;
import net.minecraft.client.renderer.entity.DisplayRenderer.BlockDisplayRenderer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegistryObject;

/**
 * 客户端属性注册
 */
public class ClientProxy implements IProxy {

    @Override
    public void registerHandlers() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        modBus.addListener(this::clientSetup);
    }

    @SubscribeEvent
    public void clientSetup(final FMLClientSetupEvent event) {
        //透明方块的渲染
        for (RegistryObject<Block> entry : OreCropBlocks.BLOCKS.getEntries()){
            if (entry.get() instanceof SweetBerryBushBlock || entry.get() instanceof OreSapling)
                ItemBlockRenderTypes.setRenderLayer(entry.get(), RenderType.cutout());
        }

        ItemBlockRenderTypes.setRenderLayer(OreCropBlocks.customSapling.get(), RenderType.cutout());
    }
}
