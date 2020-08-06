package com.coldercube.oremod.objects.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

public class UraniumIngotItem extends Item {

	public UraniumIngotItem(Properties properties) {
		super(properties);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		PlayerEntity player = (PlayerEntity) entityIn;
		if (!worldIn.isRemote) {
			if (player.isPotionActive(Effects.POISON)) {
				int duration_left = player.getActivePotionEffect(Effects.POISON).getDuration();
				if (duration_left <= 2) {
					player.addPotionEffect(new EffectInstance(Effects.POISON, 900));
				}
			} else {
				super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
			}
		}

	}

}
