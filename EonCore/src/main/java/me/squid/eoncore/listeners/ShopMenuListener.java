package me.squid.eoncore.listeners;

import me.squid.eoncore.EonCore;
import me.squid.eoncore.menus.ShopMenu;
import me.squid.eoncore.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.Objects;

public class ShopMenuListener implements Listener {

    EonCore plugin;
    ShopMenu shopMenu = new ShopMenu();

    public ShopMenuListener(EonCore plugin) {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onShopClick(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();

        if (e.getView().getTitle().equalsIgnoreCase(Utils.chat("&5&lEon Shop"))){
            switch (Objects.requireNonNull(e.getCurrentItem()).getType()){
                case OAK_PLANKS:
                    p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_HARP, 1, 1);
                    p.openInventory(shopMenu.Blocks());
                    break;
                case OAK_BOAT:
                    p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_HARP, 1, 1);
                    // Open Misc Inventory
                    p.closeInventory();
                    break;
                case BARRIER:
                    p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_HARP, 1, 1);
                    p.closeInventory();
                    break;
            }
            e.setCancelled(true);
        }
    }
}
