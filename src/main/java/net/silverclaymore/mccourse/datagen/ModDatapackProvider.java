package net.silverclaymore.mccourse.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.silverclaymore.mccourse.MCCourseMod;
import net.silverclaymore.mccourse.trim.ModTrimMaterials;
import net.silverclaymore.mccourse.trim.ModTrimPatterns;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

// This code overlaps with ModWorldGenProvider and it is not used otherwise BUILDER will be registered twice

public class ModDatapackProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.TRIM_MATERIAL, ModTrimMaterials::bootstrap)
            .add(Registries.TRIM_PATTERN, ModTrimPatterns::bootstrap);
    public ModDatapackProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(MCCourseMod.MOD_ID));

    }
}