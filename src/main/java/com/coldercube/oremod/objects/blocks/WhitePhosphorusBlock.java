package com.coldercube.oremod.objects.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion.Mode;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class WhitePhosphorusBlock extends Block{

	public WhitePhosphorusBlock(Properties properties) {
		super(properties);
	}
	
	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
		if(!worldIn.isRemote) {
			ServerWorld world = (ServerWorld)worldIn;
			double x = pos.getX();
			double y = pos.getY();
			double z = pos.getZ();
			world.createExplosion((Entity)null, x, y, z, 5, Mode.DESTROY);
		} else {
			super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
			
		}		
	}
	

}
