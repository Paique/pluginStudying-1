package com.paiique.pluginstudying.commandLogic;

import net.kyori.adventure.text.ComponentLike;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;


import java.util.UUID;

public class GrabTheSun {
    private static boolean playerIsHoldingTheSun = false;
    private static UUID playerUUID;


    public void init(Plugin plugin) {


        new BukkitRunnable() {
            long timeToSet;
            @Override
            public void run() {

                if (!playerIsHoldingTheSun) {
                    this.cancel();
                }

            Player player = plugin.getServer().getPlayer(playerUUID);


                double getPlayerCamY = player.getLocation().getDirection().getY();
                double getPlayerCamSide = player.getFacing().getDirection().getX();

                if (getPlayerCamSide == -1.0) {
                    long time = (long) ((getPlayerCamY * -1 + 2.995) * 4000);
                    timeToSet = (time != 0 ? time : 6000)  ;
                } else {
                    timeToSet = (long) ((player.getLocation().getDirection().getY()) * 4000);
                }

                player.getWorld().setTime(timeToSet);

            }

        }.runTaskTimer(plugin, 1, 1);
    }

    public static boolean getPlayerIsHoldingTheSun() {
        return playerIsHoldingTheSun;
    }

    public static void setPlayerIsHoldingTheSun(boolean bool) {
        playerIsHoldingTheSun = bool;
    }

    public static void setPlayerUUID(UUID uuid) {
        playerUUID = uuid;
    }
}