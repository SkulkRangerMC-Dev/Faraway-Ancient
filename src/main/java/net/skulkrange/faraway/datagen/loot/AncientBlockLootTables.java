package net.skulkrange.faraway.datagen.loot;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import net.skulkrange.faraway.item.FarawayAncientArtifacts;
import net.skulkrange.faraway.item.FarawayAncientBlocks;
import net.skulkrange.faraway.item.FarawayAncientItems;

import java.util.Set;

public class AncientBlockLootTables extends BlockLootSubProvider {
    public AncientBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(FarawayAncientBlocks.ANCIENT_DIRT.get());

        this.add(FarawayAncientBlocks.ANCIENT_GRASS.get(),
                block -> createAncientGrassDrops(FarawayAncientBlocks.ANCIENT_GRASS.get(), FarawayAncientBlocks.ANCIENT_DIRT.get()));

        this.add(FarawayAncientBlocks.ANCIENT_RESIN_ORE.get(),
                block -> createCopperLikeOreDrops(FarawayAncientBlocks.ANCIENT_RESIN_ORE.get(), FarawayAncientItems.RESIN.get()));
    }

    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    protected LootTable.Builder createAncientGrassDrops(Block pBlock, Block block) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(block)));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return FarawayAncientBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}