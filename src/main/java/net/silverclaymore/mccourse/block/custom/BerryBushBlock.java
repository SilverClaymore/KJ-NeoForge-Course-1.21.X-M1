package net.silverclaymore.mccourse.block.custom;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class BerryBushBlock extends SweetBerryBushBlock {
    private final Supplier<Item> berryItem;

    public BerryBushBlock(BlockBehaviour.Properties properties, Supplier<Item> berryItem) {
        super(properties);
        this.berryItem = berryItem;
    }

    @Override
    public @NotNull ItemStack getCloneItemStack(@NotNull LevelReader level, @NotNull BlockPos pos, @NotNull BlockState state) {
        return new ItemStack(berryItem.get());
    }

    @Override
    protected @NotNull InteractionResult useWithoutItem(BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull BlockHitResult hitResult) {
        InteractionResult result = InteractionResult.PASS; // default when nothing happens
        int age = state.getValue(AGE);
        boolean mature = age == 3;

        if (age > 1) {
            int dropCount = 1 + level.random.nextInt(2) + (mature ? 1 : 0);
            popResource(level, pos, new ItemStack(berryItem.get(), dropCount));

            level.playSound(null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);
            BlockState newState = state.setValue(AGE, 1);
            level.setBlock(pos, newState, 2);
            level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, newState));
            result = InteractionResult.sidedSuccess(level.isClientSide); // return items based on grow stage
        }

        return result;
    }
}