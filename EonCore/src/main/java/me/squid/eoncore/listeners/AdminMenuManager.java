package me.squid.eoncore.listeners;

import me.squid.eoncore.EonCore;
import me.squid.eoncore.menus.AdminGUI;
import me.squid.eoncore.menus.BanGUI;
import me.squid.eoncore.utils.Utils;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.Objects;

public class AdminMenuManager implements Listener {

    EonCore plugin;
    BanGUI banGUI = new BanGUI();
    AdminGUI adminGUI = new AdminGUI();

    public AdminMenuManager(EonCore plugin) {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onAdminMenuClick(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();

        // Main Menu
        if (e.getView().getTitle().equalsIgnoreCase(Utils.chat("&5&lEon Admin GUI"))) {
             switch (Objects.requireNonNull(e.getCurrentItem()).getType()) {
                 case PLAYER_HEAD:
                     p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_HARP, SoundCategory.BLOCKS, 1, 1);
                     p.closeInventory();
                     p.openInventory(banGUI.Players());
                     break;
                 case PAPER:
                     plugin.reloadConfig();
                     p.sendMessage(Utils.chat(plugin.getConfig().getString("Reload-Message")));
                     p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_HARP, SoundCategory.BLOCKS, 1, 1);
                     p.closeInventory();
                     break;
                 case CLOCK:
                     p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_HARP, SoundCategory.BLOCKS, 1, 1);
                     p.closeInventory();
                     p.openInventory(adminGUI.WeatherTimeGUI(p));
                     break;
                 default:
                     e.setCancelled(true);
                     break;
             }
        }

        // Ban GUI
        if (e.getView().getTitle().equalsIgnoreCase(Utils.chat("&5&lPlayer Management"))) {
            if (Objects.requireNonNull(e.getCurrentItem()).getType().equals(Material.PLAYER_HEAD)) {
                String name = Objects.requireNonNull(e.getCurrentItem().getItemMeta()).getDisplayName();
                Player punished = Bukkit.getPlayer(name);
                assert punished != null;
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_HARP, SoundCategory.BLOCKS, 1, 1);
                p.openInventory(banGUI.PunishmentGUI(punished));
            }
            e.setCancelled(true);
        }

        // Weather GUI
        if (e.getView().getTitle().equalsIgnoreCase(Utils.chat("&b&lWeather/Time Menu"))){
            switch (Objects.requireNonNull(e.getCurrentItem()).getType()){
                case LIGHT_BLUE_CONCRETE:
                    p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_HARP, SoundCategory.BLOCKS, 2, 1);
                    p.getWorld().setTime(500);
                    p.sendMessage(Utils.chat(plugin.getConfig().getString("Time-Set-Day")));
                    break;
                case GREEN_CONCRETE:
                    p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_HARP, SoundCategory.BLOCKS, 1, 1);
                    p.getWorld().setThundering(false);
                    p.getWorld().setStorm(false);
                    p.sendMessage(Utils.chat(plugin.getConfig().getString("Weather-Set-Clear")));
                    break;
                case GRAY_CONCRETE:
                    p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, SoundCategory.BLOCKS, 1, 1);
                    p.getWorld().setTime(13000);
                    p.sendMessage(Utils.chat(plugin.getConfig().getString("Time-Set-Night")));
                    break;
                case LIGHT_GRAY_CONCRETE:
                    p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, SoundCategory.BLOCKS, 1, 1);
                    p.getWorld().setStorm(true);
                    p.sendMessage(Utils.chat(plugin.getConfig().getString("Weather-Set-Rain")));
                    break;
            }
            e.setCancelled(true);
        }
    }
}
