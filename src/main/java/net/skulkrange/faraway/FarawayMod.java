package net.skulkrange.faraway;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.skulkrange.faraway.item.AncientArtifactClass;
import net.skulkrange.faraway.item.FarawayAncientArtifacts;
import net.skulkrange.faraway.block.FarawayAncientBlocks;
import net.skulkrange.faraway.item.FarawayAncientItems;
import net.skulkrange.faraway.sound.AncientSounds;

import net.skulkrange.faraway.worldgen.biome.surface.AncientSurfaceRules;
import org.slf4j.Logger;
import terrablender.api.SurfaceRuleManager;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(FarawayMod.MOD_ID)
public class FarawayMod
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "faraway";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public FarawayMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        FarawayAncientArtifacts.register(modEventBus);
        FarawayAncientItems.register(modEventBus);
        AncientArtifactClass.register(modEventBus);
        FarawayAncientBlocks.register(modEventBus);

        AncientSounds.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);



    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());


        }
    }
}
