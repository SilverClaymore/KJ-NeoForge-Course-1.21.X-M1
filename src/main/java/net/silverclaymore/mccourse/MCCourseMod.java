package net.silverclaymore.mccourse;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.silverclaymore.mccourse.block.ModBlocks;
import net.silverclaymore.mccourse.block.entity.ModBlockEntities;
import net.silverclaymore.mccourse.block.entity.renderer.PedestalBlockEntityRenderer;
import net.silverclaymore.mccourse.component.ModDataComponentTypes;
import net.silverclaymore.mccourse.effect.ModEffects;
import net.silverclaymore.mccourse.entity.ModEntities;
import net.silverclaymore.mccourse.entity.client.PenguinRenderer;
import net.silverclaymore.mccourse.fluid.BaseFluidType;
import net.silverclaymore.mccourse.fluid.ModFluidTypes;
import net.silverclaymore.mccourse.fluid.ModFluids;
import net.silverclaymore.mccourse.item.ModArmorMaterials;
import net.silverclaymore.mccourse.item.ModCreativeModeTabs;
import net.silverclaymore.mccourse.item.ModItems;
import net.silverclaymore.mccourse.potion.ModPotions;
import net.silverclaymore.mccourse.sound.ModSounds;
import net.silverclaymore.mccourse.util.ModItemProperties;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.level.FoliageColor;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.silverclaymore.mccourse.villager.ModVillagers;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.world.level.block.Blocks;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(MCCourseMod.MOD_ID)
public class MCCourseMod
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "mccourse";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public MCCourseMod(IEventBus modEventBus, ModContainer modContainer)
    {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        ModCreativeModeTabs.register(modEventBus);

        ModItems.register((modEventBus));
        ModBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);

        ModArmorMaterials.register(modEventBus);

        ModDataComponentTypes.register(modEventBus);

        ModSounds.register(modEventBus);
        ModEffects.register(modEventBus);
        ModPotions.register(modEventBus);
        ModVillagers.register(modEventBus);
        ModEntities.register(modEventBus);

        ModFluidTypes.register(modEventBus);
        ModFluids.register(modEventBus);

        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (ExampleMod) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() -> {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.PETUNIA.getId(), ModBlocks.POTTED_PETUNIA);
        });
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event){

        if(event.getTabKey()== CreativeModeTabs.INGREDIENTS){
            event.accept(ModItems.BLACK_OPAL);
            event.accept(ModItems.RAW_BLACK_OPAL);
            event.accept(ModItems.BISMUTH);
            event.accept(ModItems.RAW_BISMUTH);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            ModItemProperties.addCustomItemProperties();

            event.enqueueWork(() -> {
                ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_BLACK_OPAL_WATER.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_BLACK_OPAL_WATER.get(), RenderType.translucent());
            });

            EntityRenderers.register(ModEntities.PENGUIN.get(), PenguinRenderer::new);
        }

        @SubscribeEvent
        public static void registerColoredBlocks(RegisterColorHandlersEvent.Block event) {
            event.register((pState, pLevel, pPos, pTintIndex) -> pLevel != null &&
                    pPos != null ? BiomeColors.getAverageFoliageColor(pLevel, pPos) : FoliageColor.getDefaultColor(), ModBlocks.COLORED_LEAVES.get());
        }

        @SubscribeEvent
        public static void registerColoredItems(RegisterColorHandlersEvent.Item event) {
            event.register((pStack, pTintIndex) -> FoliageColor.getDefaultColor(), ModBlocks.COLORED_LEAVES);
        }

        @SubscribeEvent
        public static void onClientExtensions(RegisterClientExtensionsEvent event) {
            event.registerFluidType(((BaseFluidType) ModFluidTypes.BLACK_OPAL_WATER_FLUID_TYPE.get()).getClientFluidTypeExtensions(),
                    ModFluidTypes.BLACK_OPAL_WATER_FLUID_TYPE.get());
        }

        @SubscribeEvent
        public static void registerBER(EntityRenderersEvent.RegisterRenderers event) {
            event.registerBlockEntityRenderer(ModBlockEntities.PEDESTAL_BE.get(), PedestalBlockEntityRenderer::new);
        }

    }
}