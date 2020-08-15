package com.coldercube.oremod.objects.blocks;

import java.util.Random;

import com.coldercube.oremod.init.BlockInit;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

public class ModOreBlock extends Block {

	public ModOreBlock(Properties properties) {
		super(properties);
	}

	protected int getExp(Random rand) {
		if (this == BlockInit.RUBY_ORE.get()) {
			return MathHelper.nextInt(rand, 4, 6);
		} else {
			return 0;
		}
	}

	@Override
	public int getExpDrop(BlockState state, IWorldReader world, BlockPos pos, int fortune, int silktouch) {
		return silktouch == 0 ? this.getExp(this.RANDOM) : 0;
		//return super.getExpDrop(state, world, pos, fortune, silktouch);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void spawnAdditionalDrops(BlockState state, World worldIn, BlockPos pos, ItemStack stack) {
		super.spawnAdditionalDrops(state, worldIn, pos, stack);
	}

}
