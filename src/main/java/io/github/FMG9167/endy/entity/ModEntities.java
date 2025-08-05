package io.github.FMG9167.endy.entity;

import io.github.FMG9167.endy.Endy;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<EndyEntity> ENDY = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(Endy.MOD_ID, "endy"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, EndyEntity::new)
                    .dimensions(EntityDimensions.fixed(2f, 2f)).build());
    public static void registerModEntities() {
    }
}
