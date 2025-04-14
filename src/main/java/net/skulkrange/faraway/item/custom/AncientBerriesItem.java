package net.skulkrange.faraway.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.skulkrange.faraway.item.FarawayAncientItems;
import net.skulkrange.faraway.block.FarawayAncientBlocks;
import javax.annotation.Nullable;

public class AncientBerriesItem extends Item {
    public AncientBerriesItem(Properties pProperties) {
        super(pProperties);
    }

    public InteractionResult useOn(BlockPlaceContext context) {
        if (context.getItemInHand().getItem() != this) {
            return InteractionResult.FAIL;
        }

        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        ItemStack stack = context.getItemInHand();

        // Check if the clicked block is dirt, grass, or mycelium
        BlockState clickedState = level.getBlockState(pos);
        if (isSoil(clickedState) && level.getBlockState(pos.above()).isAir() && FarawayAncientBlocks.ANCIENT_BERRY_BUSH.get().defaultBlockState().canSurvive(level, pos.above())) {
            // Place the bush on the block above
            level.setBlock(pos.above(), FarawayAncientBlocks.ANCIENT_BERRY_BUSH.get().defaultBlockState(), 3);
            if (level instanceof ServerLevel) {
                ((ServerLevel) level).gameEvent(GameEvent.BLOCK_PLACE, pos.above(), GameEvent.Context.of(context.getPlayer(), FarawayAncientBlocks.ANCIENT_BERRY_BUSH.get().defaultBlockState()));
            }
            stack.shrink(1);
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.FAIL;
    }

    // Helper method to check if a block is dirt, grass, or mycelium
    private boolean isSoil(BlockState state) {
        return state.is(BlockTags.DIRT);
    }
}