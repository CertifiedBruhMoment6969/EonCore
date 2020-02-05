package me.squid.eoncore.listeners;

import me.squid.eoncore.EonCore;
import me.squid.eoncore.menus.BanGUI;
import me.squid.eoncore.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.Objects;

public class PunishmentGUIListener implements Listener {

    EonCore plugin;
    BanGUI banGUI = new BanGUI();

    public PunishmentGUIListener(EonCore plugin){
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPunishmentClick(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();

        if (e.getView().getTitle().equalsIgnoreCase(Utils.chat("&b&lPunishment Menu"))) {
            String name = Objects.requireNonNull(Objects.requireNonNull(e.getClickedInventory()).getItem(4)).getItemMeta().getDisplayName();
            switch (Objects.requireNonNull(e.getCurrentItem()).getType()){
                case BLUE_WOOL:
                    p.closeInventory();
                    p.openInventory(banGUI.MuteGUI(name));
                    break;
                case IRON_BARS:
                    p.openInventory(banGUI.JailGUI(name));
                    break;
                case LIGHT_BLUE_WOOL:
                    p.closeInventory();
                    p.openInventory(banGUI.BanGUI(name));
                    break;
                case RED_CONCRETE:
                    p.sendMessage(Utils.chat("&bThis is probably the problem"));
                    p.closeInventory();
                    p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1, 1);
                    break;
                default:
                    e.setCancelled(true);
                    break;
            }
            e.setCancelled(true);
        }
    }

}
