package com.mowmaster.moblootblock.Blocks;

import com.mowmaster.moblootblock.Configs.MobLootBlockConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.SpawnerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;

import java.util.Objects;

public class BaseMobLootBlockItem extends BlockItem {
    public BaseMobLootBlockItem(Block p_40565_, Properties p_40566_) {
        super(p_40565_, p_40566_);
    }

    private EntityType getTypeFromBlock()
    {
        if(this.getBlock() instanceof BaseMobLootBlock baseMobLootBlock)
        {
            return EntityType.byString(baseMobLootBlock.getResourceLocationAssignedMob()).get();
        }

        return null;
    }

    public InteractionResult useOn(UseOnContext p_43223_) {
        if(getTypeFromBlock() != null)
        {
            Level level = p_43223_.getLevel();
            if (!(level instanceof ServerLevel)) {
                return super.useOn(p_43223_);
            }
            else {

                ItemStack itemstack = p_43223_.getItemInHand();
                BlockPos blockpos = p_43223_.getClickedPos();
                Direction direction = p_43223_.getClickedFace();
                BlockState blockstate = level.getBlockState(blockpos);

                if(MobLootBlockConfig.COMMON.moblootblock_allowSpawnerChanging.get())
                {
                    if (blockstate.is(Blocks.SPAWNER)) {
                        BlockEntity blockentity = level.getBlockEntity(blockpos);
                        if (blockentity instanceof SpawnerBlockEntity) {
                            SpawnerBlockEntity spawnerblockentity = (SpawnerBlockEntity)blockentity;
                            EntityType<?> entitytype1 = getTypeFromBlock();
                            spawnerblockentity.setEntityId(entitytype1, level.getRandom());
                            blockentity.setChanged();
                            level.sendBlockUpdated(blockpos, blockstate, blockstate, 3);
                            level.gameEvent(p_43223_.getPlayer(), GameEvent.BLOCK_CHANGE, blockpos);
                            itemstack.shrink(1);
                            return InteractionResult.CONSUME;
                        }
                    }
                }

                if(MobLootBlockConfig.COMMON.moblootblock_allowMobSpawning.get())
                {
                    if(p_43223_.getPlayer().isCrouching())
                    {
                        BlockPos blockpos1;
                        if (blockstate.getCollisionShape(level, blockpos).isEmpty()) {
                            blockpos1 = blockpos;
                        } else {
                            blockpos1 = blockpos.relative(direction);
                        }

                        EntityType<?> entitytype = getTypeFromBlock();
                        if (entitytype.spawn((ServerLevel)level, itemstack, p_43223_.getPlayer(), blockpos1, MobSpawnType.SPAWN_EGG, true, !Objects.equals(blockpos, blockpos1) && direction == Direction.UP) != null) {
                            itemstack.shrink(1);
                            level.gameEvent(p_43223_.getPlayer(), GameEvent.ENTITY_PLACE, blockpos);
                        }

                        return InteractionResult.CONSUME;
                    }
                }
            }
        }

        return super.useOn(p_43223_);
    }
}
