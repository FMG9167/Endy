package io.github.FMG9167.endy;

import io.github.FMG9167.endy.entity.EndyEntity;
import io.github.FMG9167.endy.entity.ModEntities;
import io.github.FMG9167.endy.entity.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;

public class Endy implements ModInitializer {

    public static final String MOD_ID = "endy";

    @Override
    public void onInitialize() {
        ModWorldGeneration.generateModWorldGen();
        FabricDefaultAttributeRegistry.register(ModEntities.ENDY, EndyEntity.createEndyAttributes());
    }
}
