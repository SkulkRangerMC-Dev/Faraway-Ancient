package net.skulkrange.faraway.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShovelItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.skulkrange.faraway.FarawayArtifactToolTier;
import net.skulkrange.faraway.FarawayMod;
import net.skulkrange.faraway.item.custom.AncientBerriesItem;

public class FarawayAncientItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FarawayMod.MOD_ID);

    public static final RegistryObject<Item> ANCIENT_SHOVEL = ITEMS.register("ancient_shovel",
            () -> new ShovelItem(FarawayArtifactToolTier.ANCIENT, 4, 2, new Item.Properties()));

    public static final RegistryObject<Item> RESIN = ITEMS.register("resin",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ANCIENT_BERRIES = ITEMS.register("ancient_berries",
            () -> new AncientBerriesItem(new Item.Properties().food(AncientFoods.MYSTIC_BERRIES)));

    public static final RegistryObject<Item> GYRO_PITA = ITEMS.register("gyro_pita",
            () -> new Item(new Item.Properties().food(AncientFoods.GYRO_PITA)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
