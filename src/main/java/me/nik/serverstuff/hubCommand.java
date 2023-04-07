package me.nik.serverstuff;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class hubCommand implements CommandExecutor {
    Joins joins = new Joins();      //Todo: Is this the right way to do it???????
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            Bukkit.dispatchCommand(player, "mvtp hub");
            player.getInventory().clear();
            joins.giveBook(player, joins.makeBook());

        }
        return true;
    }
}