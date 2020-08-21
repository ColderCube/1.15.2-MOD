package com.coldercube.oremod.init;

import com.coldercube.oremod.OreMod;
import com.coldercube.oremod.objects.blocks.ModOreBlock;
import com.coldercube.oremod.objects.blocks.WhitePhosphorusBlock;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, OreMod.modid);

	// ORE
	public static final RegistryObject<Block> COPPER_ORE = BLOCKS.register("copper_ore", // COPPERY colour
			() -> new ModOreBlock(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).harvestLevel(1)
					.harvestTool(ToolType.PICKAXE).hardnessAndResistance(3.0F, 3.0F)));

	public static final RegistryObject<Block> RUBY_ORE = BLOCKS.register("ruby_ore", // REDISH colour
			() -> new ModOreBlock(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).harvestLevel(2)
					.harvestTool(ToolType.PICKAXE).hardnessAndResistance(3.0F, 3.0F)));

	public static final RegistryObject<Block> SILVER_ORE = BLOCKS.register("silver_ore", // WHITY colour
			() -> new ModOreBlock(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).harvestLevel(1)
					.harvestTool(ToolType.PICKAXE).hardnessAndResistance(3.0F, 3.0F)));

	public static final RegistryObject<Block> TIN_ORE = BLOCKS.register("tin_ore", // a bit less white than silver but
																					// WHITE colour
			() -> new ModOreBlock(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).harvestLevel(1)
					.harvestTool(ToolType.PICKAXE).hardnessAndResistance(3.0F, 3.0F)));

	public static final RegistryObject<Block> ALUMINIUM_ORE = BLOCKS.register("aluminium_ore", // less white than
																								// everything
			() -> new ModOreBlock(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).harvestLevel(1)
					.harvestTool(ToolType.PICKAXE).hardnessAndResistance(3.0F, 3.0F)));

	public static final RegistryObject<Block> URANIUM_ORE = BLOCKS.register("uranium_ore", // GREEN colour
			() -> new ModOreBlock(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).harvestLevel(2)
					.harvestTool(ToolType.PICKAXE).hardnessAndResistance(3.0F, 3.0F)));

	public static final RegistryObject<Block> COBALT_ORE = BLOCKS.register("cobalt_ore", // BLUE colour as an Ore
			() -> new ModOreBlock(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).harvestLevel(2)
					.harvestTool(ToolType.PICKAXE).hardnessAndResistance(3.0F, 3.0F)));

	public static final RegistryObject<Block> PLATINUM_ORE = BLOCKS.register("platinum_ore",
			() -> new ModOreBlock(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).harvestLevel(3)
					.harvestTool(ToolType.PICKAXE).hardnessAndResistance(3.0F, 3.0F)));

	// BLOCK

	public static final RegistryObject<Block> WHITE_PHOSPHORUS_BLOCK = BLOCKS.register("white_phosphorus", // Pure White
			() -> new WhitePhosphorusBlock(Block.Properties.create(Material.CLAY).hardnessAndResistance(0.1f)
					.lightValue(13).harvestLevel(1).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.0F, 3.0F)));

	public static final RegistryObject<Block> LIMESTONE = BLOCKS.register("limestone",
			() -> new Block(Block.Properties.create(Material.ROCK).sound(SoundType.GROUND).harvestLevel(0)
					.harvestTool(ToolType.PICKAXE).hardnessAndResistance(3.5F, 3.0F))); // Lime +
	// Yellow

	public static final RegistryObject<Block> MARBLE = BLOCKS.register("marble",
			() -> new Block(Block.Properties.create(Material.ROCK).sound(SoundType.GROUND).harvestLevel(0)
					.harvestTool(ToolType.PICKAXE).hardnessAndResistance(3.0F, 3.0F))); // IDK :(
}
