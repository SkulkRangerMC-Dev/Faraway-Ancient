package net.skulkrange.faraway.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.skulkrange.faraway.FarawayMod;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.skulkrange.faraway.block.custom.AncientBerryBushBlock;
import net.skulkrange.faraway.block.custom.AncientFlammableRotatablePillarBlock;
import net.skulkrange.faraway.item.FarawayAncientItems;

import java.util.function.Supplier;

public class FarawayAncientBlocks {

        public static final DeferredRegister<Block> BLOCKS =
                DeferredRegister.create(ForgeRegistries.BLOCKS, FarawayMod.MOD_ID);

        public static final RegistryObject<Block> ANCIENT_GRASS = registerBlock("ancient_grass",
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.GRASS_BLOCK).sound(SoundType.ROOTED_DIRT)));
        public static final RegistryObject<Block> ANCIENT_DIRT = registerBlock("ancient_dirt",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT).sound(SoundType.ROOTED_DIRT)));
        public static final RegistryObject<Block> ANCIENT_RESIN_ORE = registerBlock("ancient_resin_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COPPER_ORE).strength(1f).sound(SoundType.STONE)));
        public static final RegistryObject<Block> ANCIENT_BERRY_BUSH = registerBlock("ancient_berry_bush",
                () -> new AncientBerryBushBlock( BlockBehaviour.Properties.copy(Blocks.SWEET_BERRY_BUSH).strength(.5f).sound(SoundType.SWEET_BERRY_BUSH).noLootTable()));
        public static final RegistryObject<Block> MARBLE = registerBlock("marble",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COAL_ORE).strength(4.5F, 3.0F).sound(SoundType.STONE)));

    public static final RegistryObject<Block> ATHENWOOD_LOG = registerBlock("athenwood_log",
            () -> new AncientFlammableRotatablePillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).strength(3f).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> ATHENWOOD = registerBlock("athenwood",
            () -> new AncientFlammableRotatablePillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).strength(3f).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> STRIPPED_ATHENWOOD_LOG = registerBlock("stripped_athenwood_log",
            () -> new AncientFlammableRotatablePillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG).strength(3f).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> STRIPPED_ATHENWOOD = registerBlock("stripped_athenwood",
            () -> new AncientFlammableRotatablePillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG).strength(3f).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> ATHENWOOD_PLANKS = registerBlock("athenwood_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.WOOD)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            });
    public static final RegistryObject<Block> ATHENWOOD_LEAVES = registerBlock("athenwood_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).sound(SoundType.WOOD)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });

        private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
            RegistryObject<T> toReturn = BLOCKS.register(name, block);
            registerBlockItem(name, toReturn);
            return toReturn;
        }

        private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
            return FarawayAncientItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        }

        public static void register(IEventBus eventBus) {
            BLOCKS.register(eventBus);
        }
    }