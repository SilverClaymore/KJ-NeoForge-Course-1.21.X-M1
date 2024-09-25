package net.silverclaymore.mccourse.component;

import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponentType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.silverclaymore.mccourse.MCCourseMod;

import java.util.function.UnaryOperator;

public class ModDataComponentTypes {
    public static final DeferredRegister<DataComponentType<?>> DATA_COMPONENT_TYPES =
            DeferredRegister.createDataComponents(MCCourseMod.MOD_ID);

    //for the upgrade to 1.21.1 modify with this (the way used here will be deprecated there):
    //DeferredRegister.createDataComponents(Registries.DATA_COMPONENT_TYPE, MCCourseMod.MOD_ID);

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<BlockPos>> COORDINATES = register("coordinates",
            blockPosBuilder -> blockPosBuilder.persistent(BlockPos.CODEC));

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<FoundBlockData>> FOUND_BLOCK = register("found_block",
            builder -> builder.persistent(FoundBlockData.CODEC));

    private static <T>DeferredHolder<DataComponentType<?>, DataComponentType<T>> register(String name, UnaryOperator<DataComponentType.Builder<T>> builderOperator){
        return DATA_COMPONENT_TYPES.register(name, () -> builderOperator.apply(DataComponentType.builder()).build());
    }

    public static void register (IEventBus eventBus){

        DATA_COMPONENT_TYPES.register(eventBus);
    }
}