package net.silverclaymore.mccourse.block.custom;

import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.silverclaymore.mccourse.item.ModItems;
import org.jetbrains.annotations.NotNull;

public class CauliflowerCropBlock extends CropBlock {
    public static final int MAX_AGE = 6;
    public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 6);

    public CauliflowerCropBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0));
    }

    @Override
    protected @NotNull ItemLike getBaseSeedId() { return ModItems.CAULIFLOWER_SEEDS; }

    @Override
    public @NotNull IntegerProperty getAgeProperty() { return AGE; }

    @Override
    public int getMaxAge() { return MAX_AGE; }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) { builder.add(AGE); }
}
