package net.silverclaymore.mccourse.worldgen.tree;

import net.minecraft.world.level.block.grower.TreeGrower;
import net.silverclaymore.mccourse.MCCourseMod;
import net.silverclaymore.mccourse.worldgen.ModConfiguredFeatures;

import java.util.Optional;

public class ModTreeGrowers {
    public static final TreeGrower EBONY = new TreeGrower(MCCourseMod.MOD_ID + ":ebony",
            Optional.empty(), Optional.of(ModConfiguredFeatures.EBONY_KEY), Optional.empty());
}
