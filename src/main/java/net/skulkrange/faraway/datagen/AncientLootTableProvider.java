package net.skulkrange.faraway.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.skulkrange.faraway.datagen.loot.AncientBlockLootTables;

import java.util.List;
import java.util.Set;

public class AncientLootTableProvider {
    public static LootTableProvider create(PackOutput output) {
        return new LootTableProvider(output, Set.of(), List.of(
                new LootTableProvider.SubProviderEntry(AncientBlockLootTables::new, LootContextParamSets.BLOCK)
        ));
    }
}
