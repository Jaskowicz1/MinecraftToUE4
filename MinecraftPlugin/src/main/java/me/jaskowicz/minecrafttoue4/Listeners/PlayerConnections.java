package me.jaskowicz.minecrafttoue4.Listeners;

import me.jaskowicz.minecrafttoue4.MinecraftToUE4;
import me.jaskowicz.minecrafttoue4.Utils.User;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;

public class PlayerConnections implements Listener {

    private Plugin plugin = MinecraftToUE4.getPlugin(MinecraftToUE4.class);

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player pl = e.getPlayer();

        MinecraftToUE4.USERS.put(pl.getUniqueId(), new User(pl));
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e) {
        Player pl = e.getPlayer();

        MinecraftToUE4.USERS.remove(pl.getUniqueId());
    }

    @EventHandler
    public void onPlayerKicked(PlayerKickEvent e) {
        Player pl = e.getPlayer();

        MinecraftToUE4.USERS.remove(pl.getUniqueId());
    }
}
