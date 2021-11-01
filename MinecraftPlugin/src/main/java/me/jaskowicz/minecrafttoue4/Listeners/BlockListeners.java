package me.jaskowicz.minecrafttoue4.Listeners;

import me.jaskowicz.minecrafttoue4.MinecraftToUE4;
import me.jaskowicz.minecrafttoue4.Utils.User;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockListeners implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        Player pl = e.getPlayer();
        User user = MinecraftToUE4.USERS.get(pl.getUniqueId());

        if(pl.getInventory().getItemInMainHand().getType() == Material.GOLDEN_AXE) {

            user.setLoc1(e.getBlock().getLocation());
            pl.sendMessage(MinecraftToUE4.prefix + ChatColor.YELLOW + "Position 1 set.");

            e.setCancelled(true);
        }
    }
}
