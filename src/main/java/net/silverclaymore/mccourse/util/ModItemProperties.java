package net.silverclaymore.mccourse.util;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.silverclaymore.mccourse.MCCourseMod;
import net.silverclaymore.mccourse.component.ModDataComponentTypes;
import net.silverclaymore.mccourse.item.ModItems;

public class ModItemProperties {
    public static void addCustomItemProperties(){
        ItemProperties.register(ModItems.DATA_TABLET.get(), ResourceLocation.fromNamespaceAndPath(MCCourseMod.MOD_ID, "on"),
                (stack, level, entity, seed) -> stack.get(ModDataComponentTypes.FOUND_BLOCK) != null ? 1f : 0f );
    }
}