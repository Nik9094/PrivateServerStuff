package me.nik.serverstuff;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Maintenance implements CommandExecutor {

    ServerStuff plugin;
    private int timeCount = 4;

    public Maintenance(ServerStuff instance) {
        this.plugin = instance;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof ConsoleCommandSender) {
            Bukkit.getLogger().info("§4[MAINTENANCE] §3Server is going under maintenance in §65 §3minutes! §4[MAINTENANCE]");
            Bukkit.getLogger().info("§3" + String.join(" ", args));
            for (Player player : Bukkit.getOnlinePlayers()) {
                player.sendMessage("§4§L[MAINTENANCE] §3Server is going under maintenance in §65 §3minutes! §4§L[MAINTENANCE]");
                if (args.length > 0) {
                    player.sendMessage("§3" + String.join(" ", args));
                }
            }
            maintrun.runTaskTimer(plugin, 20*60, 20*60);
        } else {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                player.sendMessage("§cNOOOAAOORGRGGAGHRGGHAH");
            }
        }
        return true;
    }

    BukkitRunnable maintrun = new BukkitRunnable() {
        @Override
        public void run() {
            switch (timeCount) {
                case 0:
                    cancel();
                    Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "whitelist on");
                    Bukkit.getServer().spigot().restart();
                    break;
                case 1:
                    Bukkit.getLogger().info("§4[MAINTENANCE] §3Server is going under maintenance §6" + timeCount + " §3minute! §4[MAINTENANCE]");
                    for (Player player : Bukkit.getOnlinePlayers()) {
                        player.sendMessage("§4§L[MAINTENANCE] §3Server is going under maintenance in §6" + timeCount + " §3minute! §4§L[MAINTENANCE]");
                    }
                    break;
                default:
                    Bukkit.getLogger().info("§4[MAINTENANCE] §3Server is going under maintenance in §6" + timeCount + " §3minutes! §4[MAINTENANCE]");
                    for (Player player : Bukkit.getOnlinePlayers()) {
                        player.sendMessage("§4§L[MAINTENANCE] §3Server is going under maintenance in §6" + timeCount + " §3minutes! §4§L[MAINTENANCE]");
                    }
                    break;
            }
            timeCount--;
        }
    };

}
