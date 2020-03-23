package com.farcr.savageandravage.core.registry;

import com.farcr.savageandravage.client.model.CreepieModel;
import com.farcr.savageandravage.client.render.CreepieRenderer;
import com.farcr.savageandravage.common.entity.CreepieEntity;
import com.farcr.savageandravage.core.SavageAndRavage;
import com.farcr.savageandravage.core.util.RegistryUtils;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.entity.CreeperRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static net.minecraft.entity.EntityType.*;

@Mod.EventBusSubscriber(modid = SavageAndRavage.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SREntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = new DeferredRegister<>(ForgeRegistries.ENTITIES, SavageAndRavage.MODID);

    public static RegistryObject<EntityType<CreepieEntity>> CREEPIE = RegistryUtils.createEntity("creepie", () -> EntityType.Builder.<CreepieEntity>create(CreepieEntity::new, EntityClassification.MONSTER).size(0.51F, 1.02F).build("savageandravage:creepie"));

    @OnlyIn(Dist.CLIENT)
    public static void registerRendering() {
        RenderingRegistry.registerEntityRenderingHandler((EntityType<? extends CreepieEntity>)CREEPIE.get(), CreepieRenderer::new);
    }
}
