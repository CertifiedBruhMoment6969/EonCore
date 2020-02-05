package me.squid.eoncore.listeners;

import me.squid.eoncore.EonCore;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Phantom;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

public class DisablePhantomListener implements Listener {

    EonCore plugin;

    public DisablePhantomListener(EonCore plugin) {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPhantomSpawn(EntitySpawnEvent e){
        Entity entity = e.getEntity();

        if (entity instanceof Phantom){
            entity.remove();
        }
    }
}
