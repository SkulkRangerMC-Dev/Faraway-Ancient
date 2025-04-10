package net.skulkrange.faraway;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;
import net.skulkrange.faraway.item.FarawayAncientArtifacts;
import net.skulkrange.faraway.util.FarawayTags;

import java.util.List;

public class FarawayArtifactToolTier {
    public static final Tier ANCIENT = TierSortingRegistry.registerTier(
            new ForgeTier(5,1500,5f,4f,25,
                    FarawayTags.Blocks.NEEDS_ANCIENT_SHOVEL, () -> Ingredient.of(FarawayAncientArtifacts.SHOVEL_HEAD.get())),
            new ResourceLocation(FarawayMod.MOD_ID, "shovel_head"), List.of(Tiers.NETHERITE), List.of());

}
