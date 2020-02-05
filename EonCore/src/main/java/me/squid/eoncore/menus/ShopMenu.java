package me.squid.eoncore.menus;

import me.squid.eoncore.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;

public class ShopMenu {

    public Inventory Category(){
        Inventory inv = Bukkit.createInventory(null, 27, Utils.chat("&5&lEon Shop"));

        Utils.createItem(inv, Material.OAK_PLANKS, 1, 12, "&b&lBlocks");
        Utils.createItem(inv, Material.OAK_BOAT, 1, 14, "&bMisc");
        Utils.createItem(inv, Material.BARRIER, 1, 16, "&4Exit");

        return inv;
    }

    public Inventory Blocks(){
        Inventory inv = Bukkit.createInventory(null, 27, Utils.chat("&7&lBlocks"));

        Utils.createItem(inv, Material.DIRT, 1, 11, "&fDirt", "&bPrice: $50");

        return inv;
    }




}
