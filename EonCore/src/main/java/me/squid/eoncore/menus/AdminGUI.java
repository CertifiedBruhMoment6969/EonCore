package me.squid.eoncore.menus;

import me.squid.eoncore.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class AdminGUI {

    public Inventory GUI () {
        Inventory inv = Bukkit.createInventory(null, 27, Utils.chat("&5&lEon Admin GUI"));

        Utils.createItem(inv, Material.PLAYER_HEAD, 1, 12, "&b&lBan GUI");
        Utils.createItem(inv, Material.PAPER, 1, 14, "&bReload Config");
        Utils.createItem(inv, Material.CLOCK, 1, 16, Utils.chat("&bChange Time/Weather"));

        return inv;
    }

    public Inventory WeatherTimeGUI(Player p){
        Inventory inv = Bukkit.createInventory(null, 27, Utils.chat("&b&lWeather/Time Menu"));
        String weather = null;
        if (p.getWorld().isThundering()){
            weather = "Stormy";
        } else {
            weather = "Sunny";
        }

        Utils.createItem(inv, Material.LIGHT_BLUE_CONCRETE, 1, 2, "&aChange to Day");
        Utils.createItem(inv, Material.GREEN_CONCRETE, 1, 8, "&aChange to Sunny");
        Utils.createItem(inv, Material.CLOCK, 1, 14, "&bCurrent Time and Setting", "&aTime: " + p.getWorld().getTime()
        , "&5Weather: " + weather);
        Utils.createItem(inv, Material.GRAY_CONCRETE, 1, 20, "&7Change to Night");
        Utils.createItem(inv, Material.LIGHT_GRAY_CONCRETE, 1, 26, "&7Change to Stormy");

        return inv;
    }

}
