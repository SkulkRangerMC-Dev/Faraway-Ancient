package net.skulkrange.faraway.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.skulkrange.faraway.FarawayMod;

public class FarawayTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_ANCIENT_SHOVEL = tag("needs_ancient_shovel");


        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(FarawayMod.MOD_ID, name));
        }
    }

    public static class Items {

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(FarawayMod.MOD_ID, name));
        }
    }
}