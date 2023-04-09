package me.nik.serverstuff;

import me.nik.serverstuff.Commands.SelfPermissions;
import me.nik.serverstuff.Commands.fly;
import me.nik.serverstuff.Commands.hub;
import me.nik.serverstuff.Listeners.Joins;
import me.nik.serverstuff.Listeners.Signs;
import me.nik.serverstuff.Locations.LoadLocations;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class ServerStuff extends JavaPlugin {

    PluginManager manager = getServer().getPluginManager();
    LoadLocations spawns = new LoadLocations();

    @Override
    public void onEnable() {
        getLogger().info("Enabling server background stuff.");

        spawns.setLocations();                                              // Load all map spawns in a HashMap, to access in Signs

        manager.registerEvents(new Joins(), this);
        manager.registerEvents(new Signs(), this);

        getCommand("getreal").setExecutor(new SelfPermissions());
        getCommand("hub").setExecutor(new hub());
        getCommand("fly").setExecutor(new fly());

    }

    @Override
    public void onDisable() {
        getLogger().info("Disabling server background stuff.");
    }
}
