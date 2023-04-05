package me.nik.serverstuff;

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

        event.setJoinMessage("§2§L+ §3" + playerName);

        if (!player.hasPlayedBefore())
            player.sendMessage("§A§LWelcome§F " + playerName + "! §cRead the book I've just given you to avoid losing your sanity.");
        else
            player.sendMessage("§A§LWelcome back!");

        giveBook(player, makeBook());
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        event.setQuitMessage("§4§L- §3" + player.getName());
    }

    private ItemStack makeBook() {
        ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
        BookMeta bookmeta = (BookMeta) book.getItemMeta();

        bookmeta.setAuthor("nik9094");
        bookmeta.setTitle("§BInfo & how this works");

        ArrayList<String> pages = new ArrayList<>();
        pages.add(0,"§2§L      :SETUP:      \n" + "§A§NRun the command\n§A§L'/getreal'\n§A§Nto start off.\n§0(not necessary if you've joined before)\n\n" + "§AShould be all you need! §0This command is temporary while I figure out something better.");
        pages.add(1, "§5§L      :RULES:      \n" + "§41. §0Just don't crash this server please I'm already losing money since I can't technically ask money.\n\n" + "§42. §0Yeah and don't request too much from me for this (reason: see above + lazy)");
        bookmeta.setPages(pages);
        book.setItemMeta(bookmeta);
        return book;

    }

    private void giveBook(Player player, ItemStack book) {
        BookMeta meta = (BookMeta) book.getItemMeta();
        if (meta == null) {
            player.sendMessage("§CSomething happened wit da book :skull:");
        } else {
            player.getInventory().setItem(0, book);
        }
    }
}
