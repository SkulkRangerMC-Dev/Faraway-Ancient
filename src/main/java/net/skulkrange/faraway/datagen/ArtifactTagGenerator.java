package net.skulkrange.faraway.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.skulkrange.faraway.FarawayMod;
import net.skulkrange.faraway.item.FarawayAncientArtifacts;
import net.skulkrange.faraway.item.FarawayAncientItems;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ArtifactTagGenerator extends ItemTagsProvider {
    public ArtifactTagGenerator(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider, CompletableFuture<TagLookup<Block>> pBlockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, FarawayMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ItemTags.MUSIC_DISCS)
                .add(FarawayAncientArtifacts.TEMPLE_SUNRISE_DISC.get())
                .add(FarawayAncientArtifacts.HELIOS_DISC.get());

        this.tag(ItemTags.FOX_FOOD)
                .add(FarawayAncientItems.ANCIENT_BERRIES.get());

    }
}
