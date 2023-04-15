package me.nik.serverstuff.Commands;

import me.nik.serverstuff.ServerStuff;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;


public class Restarter implements CommandExecutor {

    ServerStuff plugin;
    private int timeCount = 4;
    public Restarter(ServerStuff instance) {
        this.plugin = instance;
    }
    BukkitRunnable restarter = new BukkitRunnable() {

        @Override
        public void run() {
            switch (timeCount) {
                case 0:
                    cancel();
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "restart");
                    break;
                case 1:
                    for (Player player : Bukkit.getOnlinePlayers()) {
                        player.sendMessage("§C§L[RESTARTING] §3The server will restart in §6§L" + timeCount + " §3minute! §C§L[RESTARTING]");
                    }
                    break;
                default:
                    for (Player player : Bukkit.getOnlinePlayers()) {
                        player.sendMessage("§C§L[RESTARTING] §3The server will restart in §6§L" + timeCount + " §3minutes! §C§L[RESTARTING]");
                    }
                    break;
            }
            timeCount--;
        }
    };

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof ConsoleCommandSender) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                player.sendMessage("§C§L[RESTARTING] §3The server will restart in §6§L5 §3minutes! §C§L[RESTARTING]");
                if (args.length > 0) {
                    player.sendMessage("§3" + String.join(" ", args));
                }
            }
            restarter.runTaskTimer(plugin, 20*60, 20*60);  // 20tick/sec * seconds
        } else {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                player.sendMessage("§CNOOOOOOOOAARRRGHRHRH");
            }
        }
        return true;
    }

}
