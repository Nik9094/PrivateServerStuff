package me.nik.serverstuff.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import java.util.ArrayList;

public class Joins implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String playerName = player.getName();

        event.setJoinMessage("§2§L+§3 " + playerName);
        player.teleport(new Location(Bukkit.getServer().getWorld("Hub"), 81.5, 15.0, 41.5, -90, 0));

        if (!player.hasPlayedBefore())
            player.sendMessage("§A§LWelcome§F " + playerName + "! §cFor the love of God read the book I've just given you.");
        else
            player.sendMessage("§A§LWelcome back! §cRemember to read the book.");

        giveBook(player, makeBook());
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        event.setQuitMessage("§4§L-§3 " + player.getName());
    }

    public ItemStack makeBook() {
        ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
        BookMeta bookmeta = (BookMeta) book.getItemMeta();

        bookmeta.setAuthor("nik9094");
        bookmeta.setTitle("§7§L｜｜｜ §BInfo & credits §7§L｜｜｜");

        ArrayList<String> pages = new ArrayList<>();
        pages.add(0, "§2§L    :START OFF:   \n" + "§A§L/getreal§0: lets you join and play maps.\n(only run this once, you'll never need it again)\n" + "§A§L/start <mapname>§0: begin a map run\n\n" + "§A§L/refresh§0: get the reset/visibility dyes\n\n" + "§A§L/hub§0: teleport back to hub");
        pages.add(1, "§5§L      :RULES:      \n" + "§41. §0Just don't crash this server or use exploits please, be thankful it's free for you.\n\n" + "§42. §0Only ask me to change maps. Anything else isn't worth it unless vital.");
        pages.add(2, "§3§L      :OTHER:      \n" + "§91. §0Use §A§L/pbs §0to view PBs.\n   Use §A§L/pbs reset <mapname> §0to reset a PB.\n\n" + "§92. §0If something doesn't work properly, LMK.");
        pages.add(3, "§6§L     :CREDITS:     \n" + "§8Strafes: §0Gargant\n" + "§8Timer: §0HowToGHP\n" + "§8Maps:\n- §0skyphonics1666\n§8- §0KaZPro (School)\n" + "§8Everything else: §0me lol donations are welcome\n\n" + "§D§OENJOY!");
        bookmeta.setPages(pages);
        book.setItemMeta(bookmeta);
        return book;

    }

    public void giveBook(Player player, ItemStack book) {
        BookMeta meta = (BookMeta) book.getItemMeta();
        if (meta == null) {
            player.sendMessage("§CSomething happened wit da book :skull:");
        } else {
            player.getInventory().setItem(0, book);
        }
    }
}
