package me.nik.serverstuff.Worlds;

import com.onarandombox.MultiverseCore.MultiverseCore;
import com.onarandombox.MultiverseCore.api.MVWorldManager;
import me.nik.serverstuff.ServerStuff;
import org.bukkit.*;

public class WorldLoader {

    ServerStuff plugin;

    public WorldLoader(ServerStuff instance) {
        this.plugin = instance;
    }
    MultiverseCore core = (MultiverseCore) Bukkit.getServer().getPluginManager().getPlugin("Multiverse-Core");
    MVWorldManager worldManager = core.getMVWorldManager();

    public void loadFromConfig() {
        for (String worldName : plugin.getConfig().getKeys(false)) {
            if (plugin.getConfig().get(worldName).equals(true)) {
                worldManager.loadWorld(worldName);
                plugin.getLogger().info("Loaded " + worldName);
            } else {
                plugin.getLogger().info("!!!!!!!!!!Don't load this one: " + worldName);
            }
        }
    }
}
