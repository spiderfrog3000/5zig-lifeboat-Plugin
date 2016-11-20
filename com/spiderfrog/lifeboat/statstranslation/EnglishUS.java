package com.spiderfrog.lifeboat.statstranslation;

import com.spiderfrog.lifeboat.Values;

import eu.the5zig.mod.The5zigMod;
import eu.the5zig.mod.event.ChatEvent;

public class EnglishUS {
	
	public static void ClientChat(ChatEvent e) {
		if(e.getMessage().contains("§aWelcome to the §a§blife§cboat §fNetwork"))
		{
			Values.resetValues();
			Values.Server = "Lobby";
		}
		
		String message = e.getMessage().replace("§a", "").replace("§b", "").replace("§c", "").replace("§d", "").replace("§e", "").replace("§f", "").replace("§1", "").replace("§2", "").replace("§3", "").replace("§4", "").replace("§5", "").replace("§6", "").replace("§7", "").replace("§8", "").replace("§9", "").replace("§0", "").replace("§l", "").replace("§m", "").replace("§o", "").replace("§k", "").replace("§n", "").replace("§r", "");
		
		if(message.startsWith("The match has started!") || message.startsWith("Teleporting you to ["))
		{
			Values.kills = 0;
			Values.deaths = 0;
		}
		
		if(message.startsWith("You joined "))
		{
			Values.team = message.replace("You joined ", "");
		}
		
		String name = The5zigMod.getDataManager().getUsername();
		try
		{
			if(message.contains(name))
			{
				if(message.contains("was slain by " + name))
				{
					++Values.kills;
				}
				if(message.contains("was knocked off a high place by " + name))
				{
					++Values.kills;
				}
				if(message.contains("was shot out of the world by " + name))
				{
					++Values.kills;
				}
				if(message.contains("was knocked out of the world by " + name))
				{
					++Values.kills;
				}
				if(message.contains("was shot off a high place by " + name))
				{
					++Values.kills;
				}
				if(message.contains("was punched out of the world by " + name))
				{
					++Values.kills;
				}
				if(message.contains("was burnt to a crisp by " + name))
				{
					++Values.kills;
				}
				
				if(message.contains(name + " was slain by"))
				{
					++Values.deaths;
				}
				if(message.contains(name + " was knocked off a high place by"))
				{
					++Values.deaths;
				}
				if(message.contains(name + " was shot out of the world by"))
				{
					++Values.deaths;
				}
				if(message.contains(name + " was knocked out of the world by"))
				{
					++Values.deaths;
				}
				if(message.contains(name + " was shot off a high place by"))
				{
					++Values.deaths;
				}
				if(message.contains(name + " was punched out of the world by"))
				{
					++Values.deaths;
				}
				if(message.contains(name + " fell out of the world"))
				{
					++Values.deaths;
				}
				if(message.contains(name + " fell") && message.contains(" blocks and died"))
				{
					++Values.deaths;
				}
				if(message.contains(name + " hit the ground from "))
				{
					++Values.deaths;
				}
				if(message.contains(name + " was burnt to a crisp by"))
				{
					++Values.deaths;
				}
			}
		}
		catch(Exception err)
		{
		}
	}

}
