package net.skulkrange.faraway.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.util.ITeleporter;
import net.skulkrange.faraway.worldgen.dimension.FarawayDimensions; // adjust based on where FARAWAY_DIM_TYPE is defined

import java.util.function.Function;

public class AncientKnowledgeStone extends Item {

    public AncientKnowledgeStone(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        System.out.println("Ancient Knowledge Stone used!");
        Player player = context.getPlayer();
        Level level = context.getLevel();
        BlockPos clickedPos = context.getClickedPos();
        ItemStack itemStack = context.getItemInHand();

        if (!level.isClientSide() && player instanceof ServerPlayer serverPlayer) {
            ServerLevel destination = serverPlayer.server.getLevel(FarawayDimensions.FARAWAYDIM_LEVEL_KEY);
            if (destination != null) {
                serverPlayer.changeDimension(destination, new ITeleporter() {
                    @Override
                    public Entity placeEntity(Entity entity, ServerLevel currentWorld, ServerLevel newWorld, float yaw, Function<Boolean, Entity> repositionEntity) {
                        Entity teleportedEntity = repositionEntity.apply(false);
                        teleportedEntity.setPos(clickedPos.getX(), clickedPos.getY() + 1, clickedPos.getZ());
                        return teleportedEntity;
                    }
                });
                itemStack.shrink(1);
                return InteractionResult.SUCCESS;
            }
        }

        return InteractionResult.FAIL;
    }
}
