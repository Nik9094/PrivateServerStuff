package me.nik.serverstuff.Listeners;

import me.nik.serverstuff.Locations.LoadLocations;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;


public class Signs implements Listener {

    LoadLocations loc = new LoadLocations();

    @EventHandler
    public void onPlayerClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getClickedBlock() != null && player.getWorld().getName().equals("Hub")) {
            if (event.getClickedBlock().getType().equals(Material.WALL_SIGN)) {
                Sign sign = (Sign) event.getClickedBlock().getState();

                if (sign.getLine(1).contains("Join map")) {                                                                     // Easy workaround to avoid false teleports and errors
                    String stringFromSign = ChatColor.stripColor(sign.getLine(2));
                    String worldName = "DR_" + stringFromSign.charAt(0) + stringFromSign.toLowerCase().substring(1);
                    Location dest = loc.getLocationFromList(worldName);

                    player.teleport(dest);
                    player.getInventory().clear();
                    Bukkit.dispatchCommand(player, "strafes");

                }
            }
        }
    }
}
