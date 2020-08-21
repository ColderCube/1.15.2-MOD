package com.coldercube.oremod.objects.items;

import java.lang.reflect.Method;
import java.util.Optional;

import com.coldercube.oremod.OreMod.OreModItemGroup;

import net.minecraft.entity.Entity;
import net.minecraft.entity.Pose;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.extensions.IForgeDimension.SleepResult;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper.UnableToFindFieldException;

public class SleepingBagItem extends Item {

	public SleepingBagItem(DyeColor color) {
		super((new Properties()).group(OreModItemGroup.instance).maxStackSize(1));
	}

	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		if (worldIn.isRemote) {
			return ActionResult.resultSuccess(playerIn.getHeldItem(handIn));
		} else {
			SleepResult sleepResult = worldIn.dimension.canSleepAt(playerIn, playerIn.getPosition());
			if (!sleepResult.equals(SleepResult.DENY) && !sleepResult.equals(SleepResult.BED_EXPLODES)) {
				if (!playerIn.onGround) {
					playerIn.sendStatusMessage(new TranslationTextComponent("message.cant_sleep_in_air", new Object[0]),
							true);
					return ActionResult.resultSuccess(playerIn.getHeldItem(handIn));
				} else {
					net.minecraft.entity.player.PlayerEntity.SleepResult sleepResult1 = this.trySleep(playerIn);
					if (sleepResult1 != null) {
						playerIn.sendStatusMessage(sleepResult1.getMessage(), true);

					}
					return ActionResult.resultSuccess(playerIn.getHeldItem(handIn));
				}
			} else {
				playerIn.sendStatusMessage(new TranslationTextComponent("message.cant_sleep_here", new Object[0]),
						true);
				return ActionResult.resultSuccess(playerIn.getHeldItem(handIn));
			}
		}
	}

	public net.minecraft.entity.player.PlayerEntity.SleepResult trySleep(PlayerEntity player) {
		net.minecraft.entity.player.PlayerEntity.SleepResult ret = ForgeEventFactory.onPlayerSleepInBed(player,
				Optional.empty());
		if (ret != null) {
			return ret;
		} else {
			BlockPos pos = player.getPosition();
			if (!player.isSleeping() && player.isAlive()) {
				if (!player.world.dimension.isSurfaceWorld()) {
					return net.minecraft.entity.player.PlayerEntity.SleepResult.NOT_POSSIBLE_HERE;
				} else if (!ForgeEventFactory.fireSleepingTimeCheck(player, Optional.empty())) {
					return net.minecraft.entity.player.PlayerEntity.SleepResult.NOT_POSSIBLE_NOW;
				} else {
					if (!player.isCreative()) {
						double width = 8.0D;
						double height = 5.0D;
						if (!player.world.getEntitiesWithinAABB(MonsterEntity.class,
								new AxisAlignedBB((double) pos.getX() - width, (double) pos.getY() - height,
										(double) pos.getZ() - width, (double) pos.getX() + width,
										(double) pos.getY() + height, (double) pos.getZ() + width),
								(monsterEntity) -> {
									return monsterEntity.isPreventingPlayerRest(player);
								}).isEmpty()) {
							return net.minecraft.entity.player.PlayerEntity.SleepResult.NOT_SAFE;
						}
					}

					player.takeStat(Stats.CUSTOM.get(Stats.TIME_SINCE_REST));
					if (player.isPassenger()) {
						player.stopRiding();
					}

					try {
						Method setPose1 = ObfuscationReflectionHelper.findMethod(Entity.class, "setPose",
								new Class[] { Pose.class });
						setPose1.invoke(player, Pose.SLEEPING);
					} catch (Exception var9) {
					}

					player.setBedPosition(pos.rotate(Rotation.CLOCKWISE_180));
					player.setMotion(Vec3d.ZERO);
					player.isAirBorne = true;

					try {
						ObfuscationReflectionHelper.setPrivateValue(PlayerEntity.class, player, 0, "sleepTimer");
					} catch (UnableToFindFieldException var8) {
					}

					if (player.world instanceof ServerWorld) {
						((ServerWorld) player.world).updateAllPlayersSleepingFlag();
					}

					return null;
				}
			} else {
				return net.minecraft.entity.player.PlayerEntity.SleepResult.OTHER_PROBLEM;

			}
		}
	}
}
