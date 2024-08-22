package com.yuo.orecrop.Proxy;

import com.yuo.orecrop.Blocks.BlockRegistry;
import com.yuo.orecrop.Blocks.Tree.OreSapling;
import net.minecraft.block.Block;
import net.minecraft.block.CropsBlock;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

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
        for (RegistryObject<Block> entry : BlockRegistry.BLOCKS.getEntries()){
            if (entry.get() instanceof SweetBerryBushBlock || entry.get() instanceof OreSapling)
                RenderTypeLookup.setRenderLayer(entry.get(), RenderType.getCutout());
        }
    }
}
