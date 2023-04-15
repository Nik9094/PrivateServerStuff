package me.nik.serverstuff.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length > 0 ) {
                player.sendMessage("§CAAARGH ONLY USE /fly");
            } else {
                if (player.getAllowFlight()) {
                    player.setAllowFlight(false);
                    player.sendMessage("§AYou can no longer fly!");
                } else {
                    player.setAllowFlight(true);
                    player.sendMessage("§AYou can now fly! §FRemember to turn it off before starting a run :)");
                }
            }
        }
        return true;
    }
}
