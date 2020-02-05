package me.squid.eoncore.commands;

import me.squid.eoncore.EonCore;
import me.squid.eoncore.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;

public class FeedCommand implements CommandExecutor {

    EonCore plugin;

    public FeedCommand(EonCore plugin) {
        this.plugin = plugin;
        Objects.requireNonNull(plugin.getCommand("feed")).setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){
            Player p = (Player) sender;
            if (p.hasPermission(getPermissionNode())){
                if (args.length == 0){
                    p.sendMessage(Utils.chat(plugin.getConfig().getString("Feed-Message")));
                    p.setFoodLevel(20);
                } else if (args.length == 1 && p.hasPermission(getOthersPermNode())){
                    Player target = Bukkit.getPlayer(args[0]);
                    if (target != null) {
                        target.sendMessage(Utils.chat(plugin.getConfig().getString("Feed-Message")));
                        target.setFoodLevel(20);
                        p.sendMessage(Utils.chat(Objects.requireNonNull(plugin.getConfig().getString("Feed-Other"))
                        .replace("<target>", target.getName())));
                    } else {
                        p.sendMessage(Utils.chat(plugin.getConfig().getString("Target-Null")));
                    }
                } else {
                    p.sendMessage(Utils.chat(plugin.getConfig().getString("No-Perms")));
                }
            } else {
                p.sendMessage(Utils.chat(plugin.getConfig().getString("No-Perms")));
            }
        }

        return true;
    }

    public String getPermissionNode() {
        return "eoncommands.feed";
    }

    public String getOthersPermNode(){
        return "eoncommands.feed.others";
    }
}
