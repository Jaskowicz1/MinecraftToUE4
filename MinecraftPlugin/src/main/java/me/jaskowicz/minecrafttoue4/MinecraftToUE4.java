package me.jaskowicz.minecrafttoue4;

import me.jaskowicz.minecrafttoue4.Commands.MinecraftToUE4Command;
import me.jaskowicz.minecrafttoue4.Listeners.BlockListeners;
import me.jaskowicz.minecrafttoue4.Listeners.OnPlayerBlockInteract;
import me.jaskowicz.minecrafttoue4.Listeners.PlayerConnections;
import me.jaskowicz.minecrafttoue4.Utils.User;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.HashMap;
import java.util.UUID;

public final class MinecraftToUE4 extends JavaPlugin {

    public static HashMap<UUID, User> USERS = new HashMap<UUID, User>();

    private final File exportDir = new File(getDataFolder(), "Exports");

    public static String prefix = ChatColor.GREEN + "[MinecraftToUE4]" + ChatColor.GRAY + " » " + ChatColor.RESET;
    public static String noPerms = ChatColor.RED + "You lack the permissions to run this command.";

    @Override
    public void onEnable() {

        Bukkit.getServer().getPluginManager().registerEvents(new PlayerConnections(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new BlockListeners(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new OnPlayerBlockInteract(), this);

        if (!exportDir.exists()) {
            boolean created = exportDir.mkdirs();

            if(created) {
                getLogger().info("Created export directory.");
            } else {
                getLogger().info("Failed to create export directory.");
            }
        }

        this.getCommand("minecrafttoue4").setExecutor(new MinecraftToUE4Command());

        getLogger().info("Minecraft To UE4 has been enabled!");
        getLogger().info("Made & Developed by: Archie Jaskowicz.");
    }

    @Override
    public void onDisable() {
        getLogger().info("Minecraft To UE4 has been Disabled.");
        getLogger().info("Made by: Archie Jaskowicz.");
        saveConfig();
    }
}
