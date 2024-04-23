package com.example;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.LoggerFactory;

public class ExampleModClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		FabricLoader.getInstance().getModContainer("modid").map(
			container -> {
				boolean bool = ResourceManagerHelper.registerBuiltinResourcePack(
					new Identifier("modid", "packid"),
					container,
					Text.of("test"),
					ResourcePackActivationType.ALWAYS_ENABLED
				);
				LoggerFactory.getLogger("modid").error(String.valueOf(bool));
				return bool;
			}
		);
	}
}