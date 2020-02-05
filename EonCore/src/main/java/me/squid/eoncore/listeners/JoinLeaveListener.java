package me.squid.eoncore.listeners;

import me.squid.eoncore.EonCore;
import me.squid.eoncore.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.Objects;

public class JoinLeaveListener implements Listener {

    EonCore plugin;

    public JoinLeaveListener(EonCore plugin) {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void JoinMessage(PlayerJoinEvent e){
        Player p = e.getPlayer();
        if (p.hasPlayedBefore()){
            e.setJoinMessage(Utils.chat(Objects.requireNonNull(plugin.getConfig().getString("Join-Message"))
            .replace("<player>", p.getName())));
        } else {
            e.setJoinMessage(Utils.chat(Objects.requireNonNull(plugin.getConfig().getString("Welcome-Message"))
            .replace("<player>", p.getName())));
        }
        p.sendTitle(Utils.chat("&5&lEon Survival"), Utils.chat("&bWelcome " + p.getName()) + "!", 30, 30, 30);
    }

    @EventHandler
    public void LeaveMessage(PlayerQuitEvent e){
        Player p = e.getPlayer();
        e.setQuitMessage(Utils.chat(Objects.requireNonNull(plugin.getConfig().getString("Leave-Message"))
        .replace("<player>", p.getName())));
    }
}
