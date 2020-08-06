package com.coldercube.oremod.init;

import com.coldercube.oremod.OreMod;
import com.coldercube.oremod.OreMod.OreModItemGroup;
import com.coldercube.oremod.objects.items.UraniumIngotItem;

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
	

}