package com.spiderfrog.lifeboat.items;

import com.spiderfrog.lifeboat.Values;

import eu.the5zig.mod.The5zigAPI;
import eu.the5zig.mod.modules.AbstractModuleItem;
import eu.the5zig.mod.render.RenderLocation;

public class TimeModuleItem extends AbstractModuleItem {

	@Override
	public int getHeight(boolean arg0) {
		return 10;
	}

	@Override
	public int getWidth(boolean arg0) {
		return The5zigAPI.getAPI().getRenderHelper().getStringWidth(getPrefix() + Values.Time);
	}

	@Override
	public void render(int x, int y, RenderLocation renderLocation, boolean dummy) {
		The5zigAPI.getAPI().getRenderHelper().drawString(getPrefix() + Values.Time.replace("§a", "").replace("§8", "").replace("§6", ""), x, y);
	}
	
	@Override
	public String getName() {
		return "Time";
	}
	
	@Override
	public String getTranslation() {
		return "lifeboattime";
	}
}
