package net.silverclaymore.mccourse.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;
import net.neoforged.neoforge.event.village.WandererTradesEvent;
import net.neoforged.neoforge.server.command.ConfigCommand;
import net.silverclaymore.mccourse.MCCourseMod;
import net.silverclaymore.mccourse.command.ReturnHomeCommand;
import net.silverclaymore.mccourse.command.SetHomeCommand;
import net.silverclaymore.mccourse.item.ModItems;
import net.silverclaymore.mccourse.item.custom.HammerItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.level.BlockEvent;
import net.silverclaymore.mccourse.potion.ModPotions;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@EventBusSubscriber(modid = MCCourseMod.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class ModEvents {

    // Done with the help of https://github.com/CoFH/CoFHCore/blob/1.19.x/src/main/java/cofh/core/event/AreaEffectEvents.java
    // Don't be a jerk License
    private static final Set<BlockPos> HARVESTED_BLOCKS = new HashSet<>();

    @SubscribeEvent
    public static void onHammerUsage(BlockEvent.BreakEvent event) {
        Player player = event.getPlayer();
        ItemStack mainHandItem = player.getMainHandItem();

        if (mainHandItem.getItem() instanceof HammerItem hammer && player instanceof ServerPlayer serverPlayer) {
            BlockPos initialBlockPos = event.getPos();
            if (HARVESTED_BLOCKS.contains(initialBlockPos)) {
                return;
            }

            for (BlockPos pos : HammerItem.getBlocksToBeDestroyed(1, initialBlockPos, serverPlayer)) {
                if (pos == initialBlockPos || !hammer.isCorrectToolForDrops(mainHandItem, event.getLevel().getBlockState(pos))) {
                    continue;
                }

                HARVESTED_BLOCKS.add(pos);
                serverPlayer.gameMode.destroyBlock(pos);
                HARVESTED_BLOCKS.remove(pos);
            }
        }
    }

    @SubscribeEvent
    public static void livingDamage(LivingDamageEvent.Pre event) {
        if (event.getEntity() instanceof Sheep sheep) {
            if (event.getSource().getDirectEntity() instanceof Player player) {
                if (player.getMainHandItem().getItem() == ModItems.METAL_DETECTOR.get()) {
                    player.sendSystemMessage(Component.literal(player.getName().getString() + " just hit a freaking Sheep with a Metal Detector!"));
                }

                if (player.getMainHandItem().getItem() == ModItems.TOMATO.get()) {
                    player.sendSystemMessage(Component.literal(player.getName().getString() + " just hit a freaking Sheep with a tomato!"));
                    sheep.addEffect(new MobEffectInstance(MobEffects.JUMP, 600, 50));
                    player.getMainHandItem().shrink(1);
                }

                if (player.getMainHandItem().getItem() == Items.END_ROD) {
                    player.sendSystemMessage(Component.literal(player.getName().getString() + " just hit a freaking Sheep with AN END ROD WHAT?!!"));
                    sheep.addEffect(new MobEffectInstance(MobEffects.POISON, 600, 50));
                    player.getMainHandItem().shrink(1);
                }
            }
        }
    }

    @SubscribeEvent
    public static void onCommandsRegister(RegisterCommandsEvent event) {
        new SetHomeCommand(event.getDispatcher());
        new ReturnHomeCommand(event.getDispatcher());

        ConfigCommand.register(event.getDispatcher());
    }

    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event) {
        event.getEntity().getPersistentData().putIntArray("mccourse.homepos",
                event.getOriginal().getPersistentData().getIntArray("mccourse.homepos"));
    }

    @SubscribeEvent
    public static void onBrewingRecipeRegister(RegisterBrewingRecipesEvent event) {
        PotionBrewing.Builder builder = event.getBuilder();

        builder.addMix(Potions.AWKWARD, Items.SLIME_BALL, ModPotions.SLIMEY_POTION);
    }


    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if(event.getType() == VillagerProfession.FARMER) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 3),
                    new ItemStack(ModItems.TOMATO.get(), 8), 8, 4, 0.05f
            ));

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.DIAMOND, 6),
                    new ItemStack(ModItems.CHAINSAW.get(), 1), 1, 9, 0.05f
            ));

            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.ENDER_PEARL, 12),
                    new ItemStack(ModItems.RAW_BLACK_OPAL.get(), 1), 1, 9, 0.05f
            ));
        }

        if(event.getType() == VillagerProfession.TOOLSMITH) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 1),
                    new ItemStack(ModItems.CHAINSAW.get(), 1), 1, 9, 0.05f
            ));
        }
    }

    @SubscribeEvent
    public static void addWanderingTrades(WandererTradesEvent event) {
        List<VillagerTrades.ItemListing> genericTrades = event.getGenericTrades();
        List<VillagerTrades.ItemListing> rareTrades = event.getRareTrades();

        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 12),
                new ItemStack(ModItems.RADIATION_STAFF.get(), 1), 1, 10, 0.2f
        ));

        rareTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemCost(Items.NETHERITE_INGOT, 8),
                new ItemStack(ModItems.BAR_BRAWL_MUSIC_DISC.get(), 1), 1, 10, 0.2f
        ));
    }
}