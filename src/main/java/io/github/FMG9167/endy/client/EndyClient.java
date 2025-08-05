package io.github.FMG9167.endy.client;

import io.github.FMG9167.endy.entity.EndyModel;
import io.github.FMG9167.endy.entity.EndyRenderer;
import io.github.FMG9167.endy.entity.ModEntities;
import io.github.FMG9167.endy.entity.ModModelLayers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class EndyClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        EntityRendererRegistry.register(ModEntities.ENDY, EndyRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.ENDY, EndyModel::getTexturedModelData);
    }
}
