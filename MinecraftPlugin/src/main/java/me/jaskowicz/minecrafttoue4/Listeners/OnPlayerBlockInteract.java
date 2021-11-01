package me.jaskowicz.minecrafttoue4.Listeners;

import me.jaskowicz.minecrafttoue4.MinecraftToUE4;
import me.jaskowicz.minecrafttoue4.Utils.User;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;

public class OnPlayerBlockInteract implements Listener {

    private Plugin plugin = MinecraftToUE4.getPlugin(MinecraftToUE4.class);

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        User user = MinecraftToUE4.USERS.get(player.getUniqueId());

        if(event.getAction() == Action.LEFT_CLICK_BLOCK) {
            if (event.getClickedBlock() != null && player.getInventory().getItemInMainHand().getType() == Material.GOLDEN_AXE) {

                user.setLoc1(event.getClickedBlock().getLocation());
                player.sendMessage(MinecraftToUE4.prefix + ChatColor.YELLOW + "Position 1 set.");

                event.setCancelled(true);
            }
        } else if(event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (event.getClickedBlock() != null && player.getInventory().getItemInMainHand().getType() == Material.GOLDEN_AXE) {

                user.setLoc2(event.getClickedBlock().getLocation());
                player.sendMessage(MinecraftToUE4.prefix + ChatColor.YELLOW + "Position 2 set.");

                event.setCancelled(true);
            }
        }
    }
}