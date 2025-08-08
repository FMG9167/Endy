package io.github.FMG9167.endy.entity;

import net.fabricmc.fabric.api.biome.v1.BiomeModification;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.world.biome.BiomeKeys;

public class ModEntityGeneration {
    public static void addSpawns() {
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.THE_END, BiomeKeys.END_MIDLANDS, BiomeKeys.END_HIGHLANDS, BiomeKeys.END_BARRENS, BiomeKeys.SMALL_END_ISLANDS), SpawnGroup.MONSTER,
                ModEntities.ENDY, 1, 1, 5);
        BiomeModifications.addSpawn(BiomeSelectors.all(), SpawnGroup.MONSTER, ModEntities.ENDY, 30, 1, 2);
    }
}
