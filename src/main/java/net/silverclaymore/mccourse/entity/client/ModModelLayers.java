package net.silverclaymore.mccourse.entity.client;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.silverclaymore.mccourse.MCCourseMod;

public class ModModelLayers {
    public static final ModelLayerLocation PENGUIN = new ModelLayerLocation(
            ResourceLocation.fromNamespaceAndPath(MCCourseMod.MOD_ID, "penguin"), "main");
}