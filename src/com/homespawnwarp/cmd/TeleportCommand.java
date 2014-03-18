package com.homespawnwarp.cmd;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import com.homespawnwarp.plugin.HomeSpawnWarp;
import com.homespawnwarp.tool.Teleportation;
import com.homespawnwarp.tool.TeleportationType;
import com.homespawnwarp.tool.Tools;

public abstract class TeleportCommand extends AbstractCommand {

	protected double[] price = new double[5];

	public TeleportCommand(HomeSpawnWarp plugin, String commandPermission,
			boolean isDefaultPermitted, boolean isConsoleSendable) {
		super(plugin, commandPermission, isDefaultPermitted, isConsoleSendable);
	}

	protected void teleportPlayer(Player player, Location l,
			TeleportationType type, double price) {
		Teleportation.teleportPlayer(player, l, type, price);
	}

	public void setupPrices() {
		for (int i = 0; i < price.length; i++) {
			price[i] = Tools.getConfig().getDouble("prices." + getName() + i);
			//Warpto is just warpto
		}
	}

	protected double getPrice(Player player) {

		return 0;
		// hasPerm(sender, permission, true, false)// TODO
	}
}
