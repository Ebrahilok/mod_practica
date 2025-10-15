package net.ebramig.tutorialmod;
import com.mojang.logging.LogUtils;
import net.ebramig.tutorialmod.block.ModBlocks;
import net.ebramig.tutorialmod.item.ModCreativeModeTabs;
import net.ebramig.tutorialmod.item.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
//Tutorial
//■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
//★El valor coincide con META-INF/mods.toml★
@Mod(TutorialMod.MOD_ID)
public class TutorialMod {
    //★Guardar ID Mod Referencia★
    public static final String MOD_ID = "tutorialmod";
    //★Guardar slf4j logger★
    private static final Logger LOGGER = LogUtils.getLogger();
    public TutorialMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);
        //★Registro de eventos y eventos del juego★
        MinecraftForge.EVENT_BUS.register(this);
        ModCreativeModeTabs.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        //★Registrar Items en modo creativo★
        modEventBus.addListener(this::addCreative);
        //=Registro configuracion de forge=
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    //★BLOCK_CREATIVE FE_Data★
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.ALEXANDRITE);
        }
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.DRIPPYFACE);
        }
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.ROCKGRASS);
        }
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.PURPLEROCK);
        }
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.YELLOWASPHALT);
        }
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.DIRTYBLOCK);
        }
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.ASPHALTBLOCK);
        }
        if(event.getTabKey()==CreativeModeTabs.BUILDING_BLOCKS){
            event.accept(ModBlocks.UADEOBLOCK);
        }
    }

    //EVT_BUS_SERVER
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    //★Guardar registro★
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
