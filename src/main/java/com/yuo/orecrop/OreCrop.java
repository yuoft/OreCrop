package com.yuo.orecrop;

import com.yuo.orecrop.Blocks.OreCropBlocks;
import com.yuo.orecrop.Items.OreCropItems;
import com.yuo.orecrop.Proxy.ClientProxy;
import com.yuo.orecrop.Proxy.CommonProxy;
import com.yuo.orecrop.Proxy.IProxy;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("orecrop")
public class OreCrop {
	public static final String MOD_ID = "orecrop";
    public static boolean IS_SPACE_ARMS = false;
    public static boolean IS_ICE_AND_FIRE = false;
    public static boolean IS_BOT = false;
    public static boolean IS_DE = false;
    public static final IProxy proxy = DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> CommonProxy::new);
    @SuppressWarnings("removal")
    public OreCrop() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        IS_SPACE_ARMS = checkMod("spacearms");
        IS_ICE_AND_FIRE = checkMod("iceandfire");
        IS_BOT = checkMod("botania");
        IS_DE = checkMod("draconicevolution");
        if (IS_SPACE_ARMS){
            OreCropBlocks.registerSpaceArmsBlock();
            OreCropItems.registerSpaceArmsItem();
        }
        if (IS_ICE_AND_FIRE){
            OreCropBlocks.registerIafBlock();
            OreCropItems.registerIafItem();
        }
        if (IS_BOT){
            OreCropBlocks.registerBotBlock();
            OreCropItems.registerBotItem();
        }
        if (IS_DE){
            OreCropBlocks.registerDEBlock();
            OreCropItems.registerDEItem();
        }

		//注册至mod总线
        OreCropItems.ITEMS.register(modEventBus);
        OreCropBlocks.BLOCKS.register(modEventBus);
        OreCropTabs.TABS.register(modEventBus);
        proxy.registerHandlers();

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
