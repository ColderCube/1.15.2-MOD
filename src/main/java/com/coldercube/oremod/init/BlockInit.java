package com.coldercube.oremod.init;

import com.coldercube.oremod.OreMod;
import com.coldercube.oremod.objects.blocks.WhitePhosphorusBlock;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, OreMod.modid);

	// ORE
	public static final RegistryObject<Block> COPPER_ORE = BLOCKS.register("copper_ore", // COPPERY colour
			() -> new Block(Block.Properties.create(Material.ROCK).sound(SoundType.STONE)));

	public static final RegistryObject<Block> RUBY_ORE = BLOCKS.register("ruby_ore", // REDISH colour
			() -> new Block(Block.Properties.create(Material.ROCK).sound(SoundType.STONE)));

	public static final RegistryObject<Block> SILVER_ORE = BLOCKS.register("silver_ore", // WHITY colour
			() -> new Block(Block.Properties.create(Material.ROCK).sound(SoundType.STONE)));

	public static final RegistryObject<Block> TIN_ORE = BLOCKS.register("tin_ore", // a bit less white than silver but
																					// WHITE colour
			() -> new Block(Block.Properties.create(Material.ROCK).sound(SoundType.STONE)));

	public static final RegistryObject<Block> ALUMINIUM_ORE = BLOCKS.register("aluminium_ore", // less white than
																								// everything
			() -> new Block(Block.Properties.create(Material.ROCK).sound(SoundType.STONE)));

	public static final RegistryObject<Block> URANIUM_ORE = BLOCKS.register("uranium_ore", // GREEN colour
			() -> new Block(Block.Properties.create(Material.ROCK).sound(SoundType.STONE)));

	public static final RegistryObject<Block> COBALT_ORE = BLOCKS.register("cobalt_ore", // BLUE colour as an Ore
			() -> new Block(Block.Properties.create(Material.ROCK).sound(SoundType.STONE)));

	public static final RegistryObject<Block> PLATINUM_ORE = BLOCKS.register("platinum_ore",
			() -> new Block(Block.Properties.create(Material.ROCK).sound(SoundType.STONE)));

	// BLOCK

	public static final RegistryObject<Block> WHITE_PHOSPHORUS_BLOCK = BLOCKS.register("white_phosphorus", // Pure White
			() -> new WhitePhosphorusBlock(
					Block.Properties.create(Material.CLAY).hardnessAndResistance(0.1f).lightValue(13)));

	public static final RegistryObject<Block> LIMESTONE = BLOCKS.register("limestone",
			() -> new Block(Block.Properties.create(Material.ROCK).sound(SoundType.GROUND))); // Lime + Yellow

	public static final RegistryObject<Block> MARBLE = BLOCKS.register("marble",
			() -> new Block(Block.Properties.create(Material.ROCK).sound(SoundType.GROUND))); // IDK :(

}
