package com.coldercube.oremod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.coldercube.oremod.init.BlockInit;
import com.coldercube.oremod.init.ItemInit;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;

@Mod("oremod")
@Mod.EventBusSubscriber(modid = OreMod.modid, bus = Bus.MOD)
public class OreMod {
	// Main logger
	public static final Logger LOGGER = LogManager.getLogger();
	public OreMod instance = this;
	public static final String modid = "oremod";

	public OreMod() {
		final IEventBus eventbus = FMLJavaModLoadingContext.get().getModEventBus();
		eventbus.addListener(this::setup);
		eventbus.addListener(this::doClientStuff);

		ItemInit.ITEMS.register(eventbus);
		LOGGER.info("Registered Item");
		BlockInit.BLOCKS.register(eventbus);
		LOGGER.info("Registered Block");

		MinecraftForge.EVENT_BUS.register(this);
		LOGGER.info("Registered Mod to Event Bus");
	}

	private void setup(final FMLCommonSetupEvent event) {

	}

	private void doClientStuff(final FMLClientSetupEvent event) {
	}

	@SubscribeEvent
	public void onServerStarting(FMLServerStartingEvent event) {

	}
	

	@SubscribeEvent
	public static void onRegisterItem(final RegistryEvent.Register<Item> event) {
		final IForgeRegistry<Item> registry = event.getRegistry();

		BlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
			final Item.Properties properties = new Item.Properties().group(OreModItemGroup.instance);
			final BlockItem blockItem = new BlockItem(block, properties);
			blockItem.setRegistryName(block.getRegistryName());
			registry.register(blockItem);
		});

		LOGGER.info("Registered BlockItems!");
	}

	public static class OreModItemGroup extends ItemGroup {
		public static final ItemGroup instance = new OreModItemGroup(ItemGroup.GROUPS.length, "oremodtab");

		private OreModItemGroup(int index, String label) {
			super(index, label);
		}

		@Override
		public ItemStack createIcon() {

			return new ItemStack(BlockInit.COPPER_ORE.get());
		}

	}

}
