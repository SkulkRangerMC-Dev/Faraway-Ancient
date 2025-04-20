package net.skulkrange.faraway.worldgen.biome.surface;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.skulkrange.faraway.block.FarawayAncientBlocks;
import net.skulkrange.faraway.worldgen.biome.AncientBiomes;

public class AncientSurfaceRules {
    private static final SurfaceRules.RuleSource DIRT = makeStateRule(Blocks.DIRT);
    private static final SurfaceRules.RuleSource GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final SurfaceRules.RuleSource STONE = makeStateRule(Blocks.STONE);
    private static final SurfaceRules.RuleSource ANCIENT_GRASS = makeStateRule(FarawayAncientBlocks.ANCIENT_GRASS.get());
    private static final SurfaceRules.RuleSource ANCIENT_DIRT = makeStateRule(FarawayAncientBlocks.ANCIENT_DIRT.get());
    private static final SurfaceRules.RuleSource MARBLE = makeStateRule(FarawayAncientBlocks.MARBLE.get());


    public static SurfaceRules.RuleSource makeRules() {
        SurfaceRules.ConditionSource isAtOrAboveWaterLevel = SurfaceRules.waterBlockCheck(-1, 0);

        SurfaceRules.RuleSource grassSurface = SurfaceRules.sequence(SurfaceRules.ifTrue(isAtOrAboveWaterLevel, GRASS_BLOCK), DIRT);

        return SurfaceRules.sequence(
                SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(AncientBiomes.ANCIENT_PLAINS),
                                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, ANCIENT_GRASS)),
                        SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, MARBLE)),


                // Default to a grass and dirt surface
                // SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, grassSurface),
                SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, ANCIENT_DIRT),
                SurfaceRules.ifTrue(SurfaceRules.DEEP_UNDER_FLOOR, STONE)
        );
    }

    private static SurfaceRules.RuleSource makeStateRule(Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }
}
