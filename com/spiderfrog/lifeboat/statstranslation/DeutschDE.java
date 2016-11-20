package com.spiderfrog.lifeboat.statstranslation;

import com.spiderfrog.lifeboat.Values;

import eu.the5zig.mod.The5zigMod;
import eu.the5zig.mod.event.ChatEvent;

public class DeutschDE {
	
	public static void ClientChat(ChatEvent e) {
		String message = e.getMessage().replace("§a", "").replace("§b", "").replace("§c", "").replace("§d", "").replace("§e", "").replace("§f", "").replace("§1", "").replace("§2", "").replace("§3", "").replace("§4", "").replace("§5", "").replace("§6", "").replace("§7", "").replace("§8", "").replace("§9", "").replace("§0", "").replace("§l", "").replace("§m", "").replace("§o", "").replace("§k", "").replace("§n", "").replace("§r", "");
		if(message.contains("Willkommen auf dem lifeboat Network"))
		{
			Values.resetValues();
			Values.Server = "Lobby";
		}
		if(message.startsWith("Das Spiel hat begonnen!") || message.startsWith("Du wirst ["))
		{
			Values.kills = 0;
			Values.deaths = 0;
		}
		
		String name = The5zigMod.getDataManager().getUsername();
		try
		{
			if(message.contains(name))
			{
				if(message.contains("wurde von " + name))
				{
					++Values.kills;
				}
				if(message.contains("wurde durch " + name))
				{
					++Values.kills;
				}
				if(message.contains(name + " wurde von"))
				{
					++Values.deaths;
				}
				if(message.contains(name + " wurde durch"))
				{
					++Values.deaths;
				}
				if(message.contains(name + " ist aus einer Höhe von"))
				{
					++Values.deaths;
				}
				if(message.contains(name + " ist aus der Welt gefallen"))
				{
					++Values.deaths;
				}
				if(message.contains(name + " ist von einem hohen Ort heruntergefallen"))
				{
					++Values.deaths;
				}
				if(message.contains(name + " hat den Boden aus einer Höhe von"))
				{
					++Values.deaths;
				}
			}
		}
		catch(Exception err) {}
	}

}
