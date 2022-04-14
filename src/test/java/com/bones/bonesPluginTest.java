package com.bones;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class bonesPluginTest
{
	public static void main(String[] args) throws Exception
	{
			ExternalPluginManager.loadBuiltin(bonesPlugin.class);
			RuneLite.main(args);
	}
}