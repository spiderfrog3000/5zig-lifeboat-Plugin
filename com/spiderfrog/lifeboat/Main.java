package com.spiderfrog.lifeboat;

import com.spiderfrog.lifeboat.items.DeathsModuleItem;
import com.spiderfrog.lifeboat.items.KillsModuleItem;
import com.spiderfrog.lifeboat.items.MapModuleItem;
import com.spiderfrog.lifeboat.items.ServerModuleItem;
import com.spiderfrog.lifeboat.items.TeamModuleItem;
import com.spiderfrog.lifeboat.items.TimeModuleItem;
import com.spiderfrog.lifeboat.server.lifeboatInstance;
import com.spiderfrog.lifeboat.statstranslation.DeutschDE;
import com.spiderfrog.lifeboat.statstranslation.EnglishUS;

import eu.the5zig.mod.The5zigAPI;
import eu.the5zig.mod.event.ChatEvent;
import eu.the5zig.mod.event.EventHandler;
import eu.the5zig.mod.event.EventHandler.Priority;
import eu.the5zig.mod.event.LoadEvent;
import eu.the5zig.mod.event.PlayerListEvent;
import eu.the5zig.mod.plugin.Plugin;

@Plugin(name = "lifeboat-Support", version = "1.4")
public class Main {

	@EventHandler(priority = Priority.NORMAL)
	public void onLoad(LoadEvent event) {
		The5zigAPI.getLogger().info("Load lifeboat Support!");

		The5zigAPI.getAPI().registerServerInstance(this, lifeboatInstance.class);
			
		The5zigAPI.getAPI().registerModuleItem(this, "lifeboatMAP", MapModuleItem.class, "SERVER_LIFEBOAT");
		The5zigAPI.getAPI().registerModuleItem(this, "lifeboatSERVER", ServerModuleItem.class, "SERVER_LIFEBOAT");
		The5zigAPI.getAPI().registerModuleItem(this, "lifeboatTIME", TimeModuleItem.class, "SERVER_LIFEBOAT");
		The5zigAPI.getAPI().registerModuleItem(this, "lifeboatKILLS", KillsModuleItem.class, "SERVER_LIFEBOAT");
		The5zigAPI.getAPI().registerModuleItem(this, "lifeboatDEATHS", DeathsModuleItem.class, "SERVER_LIFEBOAT");
		The5zigAPI.getAPI().registerModuleItem(this, "lifeboatTEAM", TeamModuleItem.class, "SERVER_LIFEBOAT");
		
		The5zigAPI.getLogger().info("Loaded lifeboat Support!");
	}

	@EventHandler(priority = Priority.HIGH)
	public void PlayerList(PlayerListEvent e) {
		
		if(e.getFooter() != null && The5zigAPI.getAPI().isInWorld())
		{
			Values.Server = e.getFooter().split(" ")[5].toString();
			Values.Time = e.getFooter().split(" ")[3].toString();
		}
		if(e.getHeader() != null && The5zigAPI.getAPI().isInWorld())
		{
			Values.mapName = e.getHeader().contains("by") ? e.getHeader().split("by")[0].toString() : e.getHeader().contains("von") ? e.getHeader().split("von")[0].toString(): "None";
		}
	}
	
	@EventHandler(priority = Priority.HIGH)
	public void ClientChat(ChatEvent e) {
		EnglishUS.ClientChat(e);
		DeutschDE.ClientChat(e);
	}
}
