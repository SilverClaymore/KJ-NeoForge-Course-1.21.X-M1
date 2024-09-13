package net.silverclaymore.mccourse.event;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.silverclaymore.mccourse.MCCourseMod;
import net.silverclaymore.mccourse.entity.ModEntities;
import net.silverclaymore.mccourse.entity.client.ModModelLayers;
import net.silverclaymore.mccourse.entity.client.PenguinModel;
import net.silverclaymore.mccourse.entity.custom.PenguinEntity;

@EventBusSubscriber(modid = MCCourseMod.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.PENGUIN, PenguinModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.PENGUIN.get(), PenguinEntity.createAttributes().build());
    }
}