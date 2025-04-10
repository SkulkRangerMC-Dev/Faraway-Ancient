package net.skulkrange.faraway.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.RecordItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.skulkrange.faraway.FarawayMod;
import net.skulkrange.faraway.sound.AncientSounds;

public class FarawayAncientArtifacts {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FarawayMod.MOD_ID);

    public static final RegistryObject<Item> SHOVEL_HEAD = ITEMS.register("shovel_head",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> KNOWLEDGE_STONE = ITEMS.register("knowledge_stone",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> TEMPLE_SUNRISE_DISC = ITEMS.register("temple_sunrise_disc",
            () -> new RecordItem(6, AncientSounds.TEMPLE_SUNRISE, new Item.Properties().stacksTo(1), 3680));

    public static final RegistryObject<Item> HELIOS_DISC = ITEMS.register("helios_disc",
            () -> new RecordItem(6, AncientSounds.HELIOS, new Item.Properties().stacksTo(1), 3680));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
