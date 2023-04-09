package me.nik.serverstuff.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SelfPermissions implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("getreal.use")) {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + player.getName() + " parent add player");    //Todo: use luckperms API instead
                player.sendMessage("§AYou now have all necessary permissions to play!");
            } else
                player.sendMessage("§CMissing permission getreal.use!");
        }
        return true;
    }
}
