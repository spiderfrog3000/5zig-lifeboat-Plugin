package com.spiderfrog.lifeboat.items;

import com.spiderfrog.lifeboat.Values;

import eu.the5zig.mod.The5zigAPI;
import eu.the5zig.mod.modules.AbstractModuleItem;
import eu.the5zig.mod.render.RenderLocation;

public class KillsModuleItem extends AbstractModuleItem {

	@Override
	public void render(int x, int y, RenderLocation renderLocation, boolean dummy) {

		The5zigAPI.getAPI().getRenderHelper().drawString(getPrefix() + Values.kills, x, y);
	}

	@Override
	public int getWidth(boolean dummy) {
		return The5zigAPI.getAPI().getRenderHelper().getStringWidth(getPrefix() + Values.kills);
	}

	@Override
	public int getHeight(boolean dummy) {
		return 10;
	}

	@Override
	public String getName() {
		return "Kills";
	}
	@Override
	public String getTranslation() {
		return "lifeboatkills";
	}
}
