package me.nik.serverstuff;

import me.nik.serverstuff.Commands.SelfPermissions;
import me.nik.serverstuff.Commands.Fly;
import me.nik.serverstuff.Commands.Hub;
import me.nik.serverstuff.Commands.Restarter;
import me.nik.serverstuff.Listeners.Joins;
import me.nik.serverstuff.Listeners.Signs;
import me.nik.serverstuff.Worlds.WorldLoader;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class ServerStuff extends JavaPlugin {

    PluginManager manager = getServer().getPluginManager();
    WorldLoader loader = new WorldLoader(this);

    @Override
    public void onEnable() {
        getLogger().info("Enabling server background stuff.");

        getConfig().options().copyDefaults(true);
        saveConfig();
        loader.loadFromConfig();

        manager.registerEvents(new Joins(), this);
        manager.registerEvents(new Signs(), this);

        getCommand("getreal").setExecutor(new SelfPermissions());
        getCommand("hub").setExecutor(new Hub());
        getCommand("fly").setExecutor(new Fly());
        getCommand("restarter").setExecutor(new Restarter(this));

    }

    @Override
    public void onDisable() {
        saveConfig();
        getLogger().info("Disabling server background stuff.");
    }
}
