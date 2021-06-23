package com.yuo.orecrop;

import com.yuo.orecrop.Blocks.BlockRegistry;
import com.yuo.orecrop.Blocks.Stem.AttachedStemCrop;
import com.yuo.orecrop.Blocks.Stem.StemCrop;
import com.yuo.orecrop.Items.ItemRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.CropsBlock;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("orecrop")
public class OreCrop {
	public static final String MODID = "orecrop";
	public OreCrop() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		//注册至mod总线
        ItemRegistry.ITEMS.register(modEventBus);
        BlockRegistry.BLOCKS.register(modEventBus);
        modEventBus.addListener(this::clientSetup);
    }
    @SubscribeEvent
    public void clientSetup(final FMLClientSetupEvent event) {
	    //透明方块的渲染
        for (RegistryObject r : BlockRegistry.BLOCKS.getEntries()){
            if (r.get() instanceof StemCrop || r.get() instanceof AttachedStemCrop || r.get() instanceof CropsBlock){
                RenderTypeLookup.setRenderLayer((Block) r.get(), RenderType.getCutout());
            }
        }
    }
}
