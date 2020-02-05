package me.squid.eoncore.files;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;

public class BanMessages {

    private static File file = new File(Bukkit.getServer().getPluginManager().getPlugin("EonCore").getDataFolder(), "BanMessages.yml");
    private static FileConfiguration fileConfig;

    public void setupFile(){

    }

}
