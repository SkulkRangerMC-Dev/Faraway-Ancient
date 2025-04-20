package net.skulkrange.faraway.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.skulkrange.faraway.FarawayMod;
import net.skulkrange.faraway.block.FarawayAncientBlocks;
import net.skulkrange.faraway.util.FarawayTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class AncientBlockTagGenerator extends BlockTagsProvider {
    public AncientBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, FarawayMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(FarawayTags.Blocks.NEEDS_ANCIENT_SHOVEL)
                .add(FarawayAncientBlocks.ANCIENT_DIRT.get()).addTag(BlockTags.DIRT)
                .add(FarawayAncientBlocks.ANCIENT_GRASS.get()).addTag(BlockTags.DIRT);

    this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .add(FarawayAncientBlocks.ANCIENT_RESIN_ORE.get())
            .add(FarawayAncientBlocks.MARBLE.get());

    }
}
