package me.nik.serverstuff.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;


public class Signs implements Listener {


    @EventHandler
    public void onPlayerClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (event.getClickedBlock() != null && player.getWorld().getName().equals("Hub")) {
            if (event.getClickedBlock().getType().equals(Material.WALL_SIGN)) {
                Sign sign = (Sign) event.getClickedBlock().getState();

                if (sign.getLine(1).contains("Join map")) {                        // Easy workaround to avoid false teleports and errors

                    String stringFromSign = ChatColor.stripColor(sign.getLine(2).replaceAll("\\s", ""));
                    String mergedString = stringFromSign.charAt(0) + stringFromSign.toLowerCase().substring(1);
                    String worldName = parseSignString(mergedString);

                    player.performCommand("mvtp " + worldName);
                    player.getInventory().clear();
                    player.performCommand("strafes");

                }
            }
        }
    }

    private String parseSignString(String name) {
        String result = name;
        switch (name) {
            case "2beeor!2bee":
                result = "2bee";
                break;
            case "Enchlagoon":
                result = "Lagoon";
                break;
            case "Higherdims":
                result = "Dimensions";
                break;
            default:
                break;
        }
        return result;
    }
}
