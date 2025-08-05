package io.github.FMG9167.endy.entity;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class EndyModel<T extends EndyEntity> extends SinglePartEntityModel<T> {
    private final ModelPart Endy;
    public EndyModel(ModelPart root) {
        this.Endy = root.getChild("Endy");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData Endy = modelPartData.addChild("Endy", ModelPartBuilder.create(), ModelTransform.of(0.0F, 24.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        ModelPartData leg4 = Endy.addChild("leg4", ModelPartBuilder.create().uv(0, 38).cuboid(-3.0F, -3.0F, 1.0F, 10.0F, 24.0F, 10.0F, new Dilation(0.0F))
                .uv(64, 106).cuboid(-7.0F, 1.0F, 1.0F, 4.0F, 4.0F, 2.0F, new Dilation(0.0F))
                .uv(80, 80).cuboid(-10.0F, -4.0F, -6.0F, 8.0F, 6.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(11.0F, -21.0F, 7.0F));

        ModelPartData cube_r1 = leg4.addChild("cube_r1", ModelPartBuilder.create().uv(12, 110).cuboid(-3.0F, -4.0F, -1.0F, 4.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, 5.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        ModelPartData leg3 = Endy.addChild("leg3", ModelPartBuilder.create().uv(40, 38).cuboid(-7.0F, -3.0F, 1.0F, 10.0F, 24.0F, 10.0F, new Dilation(0.0F))
                .uv(40, 106).cuboid(3.0F, 1.0F, 1.0F, 4.0F, 4.0F, 2.0F, new Dilation(0.0F))
                .uv(80, 66).cuboid(2.0F, -4.0F, -6.0F, 8.0F, 6.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(-11.0F, -21.0F, 7.0F));

        ModelPartData cube_r2 = leg3.addChild("cube_r2", ModelPartBuilder.create().uv(112, 6).cuboid(-3.0F, -4.0F, -1.0F, 4.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, 5.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        ModelPartData leg2 = Endy.addChild("leg2", ModelPartBuilder.create().uv(52, 106).cuboid(3.0F, 1.0F, -3.0F, 4.0F, 4.0F, 2.0F, new Dilation(0.0F))
                .uv(0, 72).cuboid(-7.0F, -3.0F, -11.0F, 10.0F, 24.0F, 10.0F, new Dilation(0.0F))
                .uv(80, 52).cuboid(2.0F, -4.0F, -2.0F, 8.0F, 6.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(-11.0F, -21.0F, -7.0F));

        ModelPartData cube_r3 = leg2.addChild("cube_r3", ModelPartBuilder.create().uv(112, 0).cuboid(-3.0F, -4.0F, -1.0F, 4.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, 5.0F, 2.0F, 0.0F, -1.5708F, 0.0F));

        ModelPartData leg1 = Endy.addChild("leg1", ModelPartBuilder.create().uv(40, 72).cuboid(-3.0F, -3.0F, -11.0F, 10.0F, 24.0F, 10.0F, new Dilation(0.0F))
                .uv(0, 110).cuboid(-7.0F, 1.0F, -3.0F, 4.0F, 4.0F, 2.0F, new Dilation(0.0F))
                .uv(80, 38).cuboid(-10.0F, -4.0F, -2.0F, 8.0F, 6.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(11.0F, -21.0F, -7.0F));

        ModelPartData cube_r4 = leg1.addChild("cube_r4", ModelPartBuilder.create().uv(24, 110).cuboid(-3.0F, -4.0F, -1.0F, 4.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, 5.0F, 2.0F, 0.0F, -1.5708F, 0.0F));

        ModelPartData head = Endy.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-14.0F, -5.0F, -14.0F, 28.0F, 10.0F, 28.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -27.0F, 0.0F));

        ModelPartData gem = Endy.addChild("gem", ModelPartBuilder.create().uv(80, 94).cuboid(-4.0F, -2.0F, -4.0F, 8.0F, 3.0F, 8.0F, new Dilation(0.0F))
                .uv(0, 106).cuboid(-4.0F, -1.0F, -6.0F, 8.0F, 1.0F, 2.0F, new Dilation(0.0F))
                .uv(20, 106).cuboid(-4.0F, -1.0F, 4.0F, 8.0F, 1.0F, 2.0F, new Dilation(0.0F))
                .uv(80, 105).cuboid(4.0F, -1.0F, -4.0F, 2.0F, 1.0F, 8.0F, new Dilation(0.0F))
                .uv(100, 105).cuboid(-6.0F, -1.0F, -4.0F, 2.0F, 1.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -32.0F, 0.0F));
        return TexturedModelData.of(modelData, 128, 128);
    }
    @Override
    public void setAngles(EndyEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);

        this.animateMovement(ModAnimations.ENDY_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.updateAnimation(entity.idleAnimationState, ModAnimations.ENDY_IDLE, ageInTicks, 1f);
        this.updateAnimation(entity.attackAnimationState, ModAnimations.ENDY_ATTACK, ageInTicks, 1f);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        Endy.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart getPart() {
        return Endy;
    }
}