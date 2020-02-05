package me.squid.eoncore.menus;

import me.squid.eoncore.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class BanGUI {

    public Inventory Players() {
        Inventory inv = Bukkit.createInventory(null, 45, Utils.chat("&5&lPlayer Management"));

        for (Player player : Bukkit.getOnlinePlayers()) {
            ItemStack item;
            item = new ItemStack(Material.PLAYER_HEAD, 1);
            ItemMeta meta = item.getItemMeta();

            meta.setDisplayName(player.getName());
            ArrayList<String> lore = new ArrayList<>();
            lore.add("Health: " + player.getHealth());
            lore.add("Gamemode: " + player.getGameMode());
            lore.add("Flying: " + player.getAllowFlight());
            meta.setLore(lore);
            item.setItemMeta(meta);
            inv.addItem(item);
        }

        return inv;
    }

    public Inventory ReasonGUI(Player punished) {
        Inventory inv = Bukkit.createInventory(null, 27, Utils.chat("&4Reasons"));

        return inv;
    }

    public Inventory PunishmentGUI(Player punished) {
        Inventory inv = Bukkit.createInventory(null, 45, Utils.chat("&b&lPunishment Menu"));

        Utils.createItem(inv, Material.PLAYER_HEAD, 1, 5, ChatColor.RED + punished.getName());
        Utils.createItem(inv, Material.BLUE_WOOL, 1, 21, Utils.chat("&bMute"));
        Utils.createItem(inv, Material.IRON_BARS, 1, 23, Utils.chat("&fJail"));
        Utils.createItem(inv, Material.LIGHT_BLUE_WOOL, 1, 25, Utils.chat("&4Ban"));
        Utils.createItem(inv, Material.RED_CONCRETE, 1, 39, Utils.chat("&4&lPermanent Ban"));
        Utils.createItem(inv, Material.RED_TERRACOTTA, 1, 41, "&4&lPermanent Mute");
        Utils.createItem(inv, Material.RED_WOOL, 1, 43, ChatColor.DARK_RED + "Permanent IP Ban");

        return inv;
    }

    public Inventory MuteGUI(String name) {
        Inventory inv = Bukkit.createInventory(null, 27, Utils.chat("&b&lMute Menu"));

        Utils.createItem(inv, Material.PLAYER_HEAD, 1, 5, "&4" + name);

        return inv;
    }

    public Inventory JailGUI(String name) {
        Inventory inv = Bukkit.createInventory(null, 27, Utils.chat("&f&lJail Menu"));

        Utils.createItem(inv, Material.PLAYER_HEAD, 1, 5, "&4" + name);

        return inv;
    }

    public Inventory BanGUI(String name){
        Inventory inv = Bukkit.createInventory(null, 27, Utils.chat("&4&lBan Menu"));

        Utils.createItem(inv, Material.PLAYER_HEAD, 1, 5, "&4" + name);

        return inv;
    }

}
