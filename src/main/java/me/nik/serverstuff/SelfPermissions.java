package me.nik.serverstuff;

//import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SelfPermissions implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            player.sendMessage("/lp user " + player.getName() + " group parent add player");
            //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "/lp user " + player.getName() + " group parent add player");
        }
        return true;
    }
}
