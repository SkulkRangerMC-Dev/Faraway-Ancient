package net.skulkrange.faraway.datagen;

import net.skulkrange.faraway.FarawayMod;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.skulkrange.faraway.worldgen.biome.AncientBiomes;
import net.skulkrange.faraway.worldgen.dimension.FarawayDimensions;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class FarawayWorldGenProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.DIMENSION_TYPE, FarawayDimensions::bootstrapType)
            .add(Registries.BIOME, AncientBiomes::boostrap)
            .add(Registries.LEVEL_STEM, FarawayDimensions::bootstrapStem);

    public FarawayWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(FarawayMod.MOD_ID));
    }
}