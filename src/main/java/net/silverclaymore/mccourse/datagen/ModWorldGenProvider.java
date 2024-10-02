package net.silverclaymore.mccourse.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.silverclaymore.mccourse.MCCourseMod;
import net.silverclaymore.mccourse.trim.ModTrimMaterials;
import net.silverclaymore.mccourse.trim.ModTrimPatterns;
import net.silverclaymore.mccourse.worldgen.ModBiomeModifiers;
import net.silverclaymore.mccourse.worldgen.ModConfiguredFeatures;
import net.silverclaymore.mccourse.worldgen.ModPlacedFeatures;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModWorldGenProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap)
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ModBiomeModifiers::bootstrap)
            .add(Registries.TRIM_MATERIAL, ModTrimMaterials::bootstrap) // in the lecture this was inside ModDatapackProvider
            .add(Registries.TRIM_PATTERN, ModTrimPatterns::bootstrap) // in the lecture this was inside ModDatapackProvider
            ;

    public ModWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(MCCourseMod.MOD_ID));
    }
}