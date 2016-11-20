package com.spiderfrog.lifeboat.server;

import eu.the5zig.mod.server.ServerInstance;

public class lifeboatInstance extends ServerInstance {

	@Override
	public void registerListeners() {
	}

	@Override
	public String getName() {
		return "PC-Lifeboat";
	}

	@Override
	public String getConfigName() {
		return "lifeboat";
	}

	@Override
	public boolean handleServer(String host, int port) {
		return host.equals("us.oc.tc") || host.equals("oc.tc") || host.equals("pc.lbsg.net") || host.equals("eu.oc.tc");
	}	
}
