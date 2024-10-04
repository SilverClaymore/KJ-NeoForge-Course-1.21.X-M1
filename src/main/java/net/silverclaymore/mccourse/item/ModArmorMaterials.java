package net.silverclaymore.mccourse.item;

import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.silverclaymore.mccourse.MCCourseMod;

import java.util.EnumMap;
import java.util.List;

public class ModArmorMaterials {
    public static final DeferredRegister<ArmorMaterial> ARMOR_MATERIALS =
            DeferredRegister.create(Registries.ARMOR_MATERIAL, MCCourseMod.MOD_ID);

    public static final Holder<ArmorMaterial> BLACK_OPAL =
            ARMOR_MATERIALS.register("black_opal", () -> new ArmorMaterial(
                    Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                        map.put(ArmorItem.Type.BOOTS, 2);
                        map.put(ArmorItem.Type.LEGGINGS, 4);
                        map.put(ArmorItem.Type.CHESTPLATE, 6);
                        map.put(ArmorItem.Type.HELMET, 2);
                        map.put(ArmorItem.Type.BODY, 4);
                    }), 20, SoundEvents.ARMOR_EQUIP_IRON, () -> Ingredient.of(ModItems.BLACK_OPAL.get()),
                    List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(MCCourseMod.MOD_ID, "black_opal"))),
                    0,0));

    public static final Holder<ArmorMaterial> BISMUTH =
            ARMOR_MATERIALS.register("bismuth", () -> new ArmorMaterial(
                    Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                        map.put(ArmorItem.Type.BOOTS, 5);
                        map.put(ArmorItem.Type.LEGGINGS, 7);
                        map.put(ArmorItem.Type.CHESTPLATE, 9);
                        map.put(ArmorItem.Type.HELMET, 5);
                        map.put(ArmorItem.Type.BODY, 11);
                    }), 16, SoundEvents.ARMOR_EQUIP_IRON, () -> Ingredient.of(ModItems.BISMUTH.get()),
                    List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(MCCourseMod.MOD_ID, "bismuth"))),
                    2f,0.1f));

    public static final Holder<ArmorMaterial> ALEXANDRITE =
            ARMOR_MATERIALS.register("alexandrite", () -> new ArmorMaterial(
                    Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                        map.put(ArmorItem.Type.BOOTS, 5);
                        map.put(ArmorItem.Type.LEGGINGS, 7);
                        map.put(ArmorItem.Type.CHESTPLATE, 9);
                        map.put(ArmorItem.Type.HELMET, 5);
                        map.put(ArmorItem.Type.BODY, 11);
                    }), 15, SoundEvents.ARMOR_EQUIP_IRON, () -> Ingredient.of(ModItems.ALEXANDRITE.get()),
                    List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(MCCourseMod.MOD_ID, "alexandrite"))),
                    4f,0.1f));

    public static final Holder<ArmorMaterial> PINK_GARNET =
            ARMOR_MATERIALS.register("pink_garnet", () -> new ArmorMaterial(
                    Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                        map.put(ArmorItem.Type.BOOTS, 2);
                        map.put(ArmorItem.Type.LEGGINGS, 4);
                        map.put(ArmorItem.Type.CHESTPLATE, 6);
                        map.put(ArmorItem.Type.HELMET, 2);
                        map.put(ArmorItem.Type.BODY, 4);
                    }), 20, SoundEvents.ARMOR_EQUIP_DIAMOND, () -> Ingredient.of(ModItems.ALEXANDRITE.get()),
                    List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(MCCourseMod.MOD_ID, "pink_garnet"))),
                    0,0));

    //pink_garnet

    public static void register (IEventBus eventBus){
        ARMOR_MATERIALS.register(eventBus);
    }
}
