package com.yuo.orecrop;

import com.yuo.orecrop.Blocks.BlockRegistry;
import com.yuo.orecrop.Blocks.Stem.AttachedStemCrop;
import com.yuo.orecrop.Blocks.Stem.StemCrop;
import com.yuo.orecrop.Blocks.Tree.OreSapling;
import com.yuo.orecrop.Items.ItemRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.CropsBlock;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.entity.LivingEntity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("orecrop")
public class OreCrop {
	public static final String MODID = "orecrop";
    public static boolean IS_SPACE_ARMS = false;
    public static boolean IS_ICE_AND_FIRE = false;
	public OreCrop() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        IS_SPACE_ARMS = checkMod("spacearms");
        IS_ICE_AND_FIRE = checkMod("iceandfire");
        if (IS_SPACE_ARMS){
            BlockRegistry.registerSpaceArmsItem();
            ItemRegistry.registerSpaceArmsItem();
        }
        if (IS_ICE_AND_FIRE){
            BlockRegistry.registerIafItem();
            ItemRegistry.registerIafItem();
        }

		//注册至mod总线
        ItemRegistry.ITEMS.register(modEventBus);
        BlockRegistry.BLOCKS.register(modEventBus);
        modEventBus.addListener(this::clientSetup);
    }
    @SubscribeEvent
    public void clientSetup(final FMLClientSetupEvent event) {
        //透明方块的渲染
        for (RegistryObject<Block> entry : BlockRegistry.BLOCKS.getEntries()){
            if (entry.get() instanceof StemCrop || entry.get() instanceof AttachedStemCrop
                    || entry.get() instanceof CropsBlock || entry.get() instanceof OreSapling){
                RenderTypeLookup.setRenderLayer(entry.get(), RenderType.getCutout());
            }
        }
    }

    /**
     * 检查mod
     * @param modId 模组id
     * @return 存在 true
     */
    private boolean checkMod(String modId){
        return ModList.get().isLoaded(modId);
    }
}
