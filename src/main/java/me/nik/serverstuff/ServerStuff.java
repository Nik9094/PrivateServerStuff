package me.nik.serverstuff;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class ServerStuff extends JavaPlugin {

    PluginManager manager = getServer().getPluginManager();

    @Override
    public void onEnable() {
        getLogger().info("Enabling server background stuff.");
        manager.registerEvents(new Joins(), this);
        getCommand("getreal").setExecutor(new SelfPermissions());
        getCommand("hub").setExecutor(new hubCommand());
        getCommand("fly").setExecutor(new flyPerms());
    }

    @Override
    public void onDisable() {
        getLogger().info("Disabling server background stuff.");
    }
}
