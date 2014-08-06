package com.homespawnwarp.util;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public final class TeleportRequest implements Runnable {

	private Player player;
	private Player targetPlayer;
	private Location thenLocation;
	private static final int timeOut = 20;

	public TeleportRequest(Player player, Player targetPlayer) {
		this.player = player;
		this.targetPlayer = targetPlayer;
		this.thenLocation = targetPlayer.getLocation();
	}

	public boolean arePlayersOnline() {
		return player.isOnline() && targetPlayer.isOnline();
	}

	public Player getSender() {
		return player;
	}
	
	@Override
	public void run() {
		targetPlayer.sendMessage(ChatColor.AQUA + player.getName()
				+ Tools.getMessage("teleport-to-you"));
		try {
			Thread.sleep(timeOut * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Teleportation.removeRequest(targetPlayer);
	}

	public Location getLocation() {
		return thenLocation;
	}
}