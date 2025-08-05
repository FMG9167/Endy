package io.github.FMG9167.endy.entity;

import io.github.FMG9167.endy.Endy;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class EndyRenderer extends MobEntityRenderer<EndyEntity, EndyModel<EndyEntity>> {
    private static final Identifier TEXTURE = new Identifier(Endy.MOD_ID, "textures/entity/endy.png");

    public EndyRenderer(EntityRendererFactory.Context context) {
        super(context, new EndyModel<>(context.getPart(ModModelLayers.ENDY)), 0.6f);
    }

    @Override
    public Identifier getTexture(EndyEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(EndyEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.scale(1f, 1f, 1f);

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}