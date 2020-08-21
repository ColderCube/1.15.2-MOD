package com.coldercube.oremod.events;

import com.coldercube.oremod.objects.items.SleepingBagItem;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.GameRules;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.event.entity.player.SleepingLocationCheckEvent;
import net.minecraftforge.eventbus.api.Event.Result;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class SleepEvent {
	@SubscribeEvent
	public void sleepTick(PlayerTickEvent event) {
		if (event.player.world instanceof ServerWorld) {
			ServerWorld serverWorld = (ServerWorld) event.player.world;
			if (event.player.isSleeping() && event.player.getSleepTimer() >= 100) {
				if (serverWorld.getGameRules().getBoolean(GameRules.DO_DAYLIGHT_CYCLE)) {
					long l = serverWorld.getDayTime() + 24000L;
					serverWorld.setDayTime(l - l % 24000L);
				}

				serverWorld.getPlayers().stream().filter(LivingEntity::isSleeping).forEach(PlayerEntity::wakeUp);
				if (serverWorld.getGameRules().getBoolean(GameRules.DO_WEATHER_CYCLE)) {
					serverWorld.getDimension().resetRainAndThunder();
				}

				serverWorld.getServer().getPlayerList().sendMessage(
						(new TranslationTextComponent("message.sleep", new Object[] { event.player.getDisplayName() }))
								.applyTextStyle(TextFormatting.YELLOW));
			}
		}

	}

	@SubscribeEvent
	public void sleepCheck(SleepingLocationCheckEvent event) {
		if (event.getEntityLiving() instanceof PlayerEntity) {
			PlayerEntity playerEntity = (PlayerEntity) event.getEntityLiving();
			Hand[] var3 = Hand.values();
			int var4 = var3.length;

			for (int var5 = 0; var5 < var4; ++var5) {
				Hand hand = var3[var5];
				if (playerEntity.getHeldItem(hand).getItem() instanceof SleepingBagItem) {
					event.setResult(Result.ALLOW);
					return;
				}
			}
		}

	}

}
