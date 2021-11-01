package me.jaskowicz.minecrafttoue4.Commands;

import me.jaskowicz.minecrafttoue4.MinecraftToUE4;
import me.jaskowicz.minecrafttoue4.Utils.User;
import me.jaskowicz.minecrafttoue4.UtilsExtra.MathsUtil;
import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class MinecraftToUE4Command implements CommandExecutor {

    private Plugin plugin = MinecraftToUE4.getPlugin(MinecraftToUE4.class);

    private File exportDir = new File(plugin.getDataFolder(), "Exports");

    private String getHelpMenu() {
        return ChatColor.WHITE + "/mctoue4 help " + ChatColor.GRAY + "|" + ChatColor.WHITE + "Shows this menu." + "\n"
                + ChatColor.WHITE + "/mctoue4 export <filename> " + ChatColor.GRAY + "|" + ChatColor.WHITE + " Exports all blocks from position 1 to position 2 into a text document that you name." + "\n";
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player pl;
        User u;

        if (!(sender instanceof Player)) {
            sender.sendMessage(MinecraftToUE4.prefix + ChatColor.RED + "You can not do these commands as console.");
            return true;
        } else {
            pl = (Player) sender;
            u = MinecraftToUE4.USERS.get(pl.getUniqueId());
        }

        if (command.getName().equalsIgnoreCase("MinecraftToUE4")) {
            if (args.length == 0) {
                pl.sendMessage(getHelpMenu());
            } else if(args.length == 1) {
                if(args[0].equalsIgnoreCase("help")) {
                    pl.sendMessage(getHelpMenu());
                } else {
                    pl.sendMessage(getHelpMenu());
                }
            } else if(args.length == 2) {
                if (args[0].equalsIgnoreCase("export")) {

                    if(u.getLoc1() == null || u.getLoc2() == null) {
                        pl.sendMessage(MinecraftToUE4.prefix + ChatColor.RED + "You don't have all locations set!");

                        return true;
                    }

                    String file = args[1];

                    pl.sendMessage(MinecraftToUE4.prefix + ChatColor.YELLOW + "Exporting build into the file: '" + file + ".txt'");

                    if (!new File(exportDir + File.separator + file + ".txt").exists()) {
                        File exportFile = new File(exportDir + File.separator + file + ".txt");
                        try {
                            boolean created = exportFile.createNewFile();

                            if(created) {
                                pl.sendMessage(MinecraftToUE4.prefix + ChatColor.YELLOW + "Created file successfully...");
                            } else {
                                pl.sendMessage(MinecraftToUE4.prefix + ChatColor.RED + "Failed to create file.");
                                return true;
                            }
                        } catch (IOException e) {
                            pl.sendMessage(MinecraftToUE4.prefix + ChatColor.RED + "An error occurred when trying to create the file.");
                            e.printStackTrace();
                        }
                    }

                    try {
                        FileWriter myWriter = new FileWriter(exportDir + File.separator + file + ".txt");

                        List<Block> blocks = MathsUtil.blocksBetweenLocations(u.getLoc1(), u.getLoc2());

                        for(Block block : blocks) {
                            if (!block.getType().name().equalsIgnoreCase("air")) {
                                myWriter.write(block.getType().name() + "," + block.getX() + "," + block.getZ() + "," + block.getY() + "\n");
                            }
                        }

                        myWriter.close();
                        pl.sendMessage(MinecraftToUE4.prefix + ChatColor.GREEN + "Exported successfully!");
                    } catch (IOException e) {
                        pl.sendMessage(MinecraftToUE4.prefix + ChatColor.RED + "An error occurred when trying to write to file.");
                        e.printStackTrace();
                    }
                } else {
                    pl.sendMessage(getHelpMenu());
                }
            } else {
                pl.sendMessage(getHelpMenu());
            }
        }

        return true;
    }
}
