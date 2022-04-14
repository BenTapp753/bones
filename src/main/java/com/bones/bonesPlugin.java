package com.bones;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.*;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.ItemSpawned;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

import java.awt.*;

@Slf4j
@PluginDescriptor(
	name = "bones"
)
public class bonesPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private bonesConfig config;

	@Override
	protected void startUp() throws Exception
	{
		log.info("Example started!");
	}

	@Override
	protected void shutDown() throws Exception
	{
		log.info("Example stopped!");
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() == GameState.LOGGED_IN)
		{
			client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "Game launched",null);
		}
	}
	@Subscribe
	public void onItemSpawned(ItemSpawned itemSpawned) {
		TileItem item = itemSpawned.getItem();
		if (item.getId() == ItemID.BONES){
			Toolkit.getDefaultToolkit().beep();
			log.info("Bones received");
			client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "You have received a drop. Bones",null);

		}
	}

	@Provides
	bonesConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(bonesConfig.class);
	}
}
