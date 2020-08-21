package com.coldercube.oremod.init;

import com.coldercube.oremod.OreMod;
import com.coldercube.oremod.OreMod.OreModItemGroup;
import com.coldercube.oremod.objects.items.SleepingBagItem;
import com.coldercube.oremod.objects.items.UraniumIngotItem;

import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {
	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, OreMod.modid);

	public static final RegistryObject<Item> COPPER_INGOT = ITEMS.register("copper_ingot",
			() -> new Item(new Item.Properties().group(OreModItemGroup.instance)));

	public static final RegistryObject<Item> RUBY = ITEMS.register("ruby",
			() -> new Item(new Item.Properties().group(OreModItemGroup.instance)));

	public static final RegistryObject<Item> SILVER_INGOT = ITEMS.register("silver_ingot",
			() -> new Item(new Item.Properties().group(OreModItemGroup.instance)));

	public static final RegistryObject<Item> TIN_INGOT = ITEMS.register("tin_ingot",
			() -> new Item(new Item.Properties().group(OreModItemGroup.instance)));

	public static final RegistryObject<Item> ALUMINIUM_INGOT = ITEMS.register("aluminium_ingot",
			() -> new Item(new Item.Properties().group(OreModItemGroup.instance)));

	public static final RegistryObject<Item> URANIUM_INGOT = ITEMS.register("uranium_ingot",
			() -> new UraniumIngotItem(new Item.Properties().group(OreModItemGroup.instance)));

	public static final RegistryObject<Item> COBALT_INGOT = ITEMS.register("cobalt_ingot",
			() -> new Item(new Item.Properties().group(OreModItemGroup.instance)));

	// Sleeping Bags
	public static final RegistryObject<Item> WHITE_SLEEPING_BAG = ITEMS.register("white_sleeping_bag",
			() -> new SleepingBagItem(DyeColor.WHITE));
	public static final RegistryObject<Item> ORANGE_SLEEPING_BAG = ITEMS.register("orange_sleeping_bag",
			() -> new SleepingBagItem(DyeColor.ORANGE));
	public static final RegistryObject<Item> MAGENTA_SLEEPING_BAG = ITEMS.register("magenta_sleeping_bag",
			() -> new SleepingBagItem(DyeColor.MAGENTA));
	public static final RegistryObject<Item> LIGHT_BLUE_SLEEPING_BAG = ITEMS.register("light_blue_sleeping_bag",
			() -> new SleepingBagItem(DyeColor.LIGHT_BLUE));
	public static final RegistryObject<Item> YELLOW_SLEEPING_BAG = ITEMS.register("yellow_sleeping_bag",
			() -> new SleepingBagItem(DyeColor.YELLOW));
	public static final RegistryObject<Item> LIME_SLEEPING_BAG = ITEMS.register("lime_sleeping_bag",
			() -> new SleepingBagItem(DyeColor.LIME));
	public static final RegistryObject<Item> PINK_SLEEPING_BAG = ITEMS.register("pink_sleeping_bag",
			() -> new SleepingBagItem(DyeColor.PINK));
	public static final RegistryObject<Item> GRAY_SLEEPING_BAG = ITEMS.register("gray_sleeping_bag",
			() -> new SleepingBagItem(DyeColor.GRAY));
	public static final RegistryObject<Item> LIGHT_GRAY_SLEEPING_BAG = ITEMS.register("light_gray_sleeping_bag",
			() -> new SleepingBagItem(DyeColor.LIGHT_GRAY));
	public static final RegistryObject<Item> CYAN_SLEEPING_BAG = ITEMS.register("cyan_sleeping_bag",
			() -> new SleepingBagItem(DyeColor.CYAN));
	public static final RegistryObject<Item> PURPLE_SLEEPING_BAG = ITEMS.register("purple_sleeping_bag",
			() -> new SleepingBagItem(DyeColor.PURPLE));
	public static final RegistryObject<Item> BLUE_SLEEPING_BAG = ITEMS.register("blue_sleeping_bag",
			() -> new SleepingBagItem(DyeColor.BLUE));
	public static final RegistryObject<Item> BROWN_SLEEPING_BAG = ITEMS.register("brown_sleeping_bag",
			() -> new SleepingBagItem(DyeColor.BROWN));
	public static final RegistryObject<Item> GREEN_SLEEPING_BAG = ITEMS.register("green_sleeping_bag",
			() -> new SleepingBagItem(DyeColor.GREEN));
	public static final RegistryObject<Item> RED_SLEEPING_BAG = ITEMS.register("red_sleeping_bag",
			() -> new SleepingBagItem(DyeColor.RED));
	public static final RegistryObject<Item> BLACK_SLEEPING_BAG = ITEMS.register("black_sleeping_bag",
			() -> new SleepingBagItem(DyeColor.BLACK));

}