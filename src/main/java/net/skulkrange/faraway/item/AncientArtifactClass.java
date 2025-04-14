package net.skulkrange.faraway.item;

import net.skulkrange.faraway.FarawayMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.skulkrange.faraway.block.FarawayAncientBlocks;

public class AncientArtifactClass {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FarawayMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TUTORIAL_TAB = CREATIVE_MODE_TABS.register("tutorial_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(FarawayAncientArtifacts.SHOVEL_HEAD.get()))
                    .title(Component.translatable("faraway.ancient_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(FarawayAncientArtifacts.SHOVEL_HEAD.get());
                        pOutput.accept(FarawayAncientArtifacts.KNOWLEDGE_STONE.get());

                        pOutput.accept(FarawayAncientArtifacts.HELIOS_DISC.get());
                        pOutput.accept(FarawayAncientArtifacts.HELIOS_DISC.get());

                        pOutput.accept(FarawayAncientItems.ANCIENT_SHOVEL.get());
                        pOutput.accept(FarawayAncientItems.RESIN.get());
                        pOutput.accept(FarawayAncientItems.ANCIENT_BERRIES.get());

                        pOutput.accept(FarawayAncientBlocks.ANCIENT_DIRT.get());
                        pOutput.accept(FarawayAncientBlocks.ANCIENT_GRASS.get());
                        pOutput.accept(FarawayAncientBlocks.ANCIENT_RESIN_ORE.get());




                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}