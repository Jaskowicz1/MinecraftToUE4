package me.jaskowicz.minecrafttoue4.UtilsExtra;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MathsUtil {

    public static List<Block> blocksBetweenLocations(Location loc1, Location loc2) {
        List<Block> blocks = new ArrayList<Block>();

        int topBlockX = (Math.max(loc1.getBlockX(), loc2.getBlockX()));
        int bottomBlockX = (Math.min(loc1.getBlockX(), loc2.getBlockX()));

        int topBlockY = (Math.max(loc1.getBlockY(), loc2.getBlockY()));
        int bottomBlockY = (Math.min(loc1.getBlockY(), loc2.getBlockY()));

        int topBlockZ = (Math.max(loc1.getBlockZ(), loc2.getBlockZ()));
        int bottomBlockZ = (Math.min(loc1.getBlockZ(), loc2.getBlockZ()));

        for(int x = bottomBlockX; x <= topBlockX; x++)
        {
            for(int z = bottomBlockZ; z <= topBlockZ; z++)
            {
                for(int y = bottomBlockY; y <= topBlockY; y++)
                {
                    Block block = Objects.requireNonNull(loc1.getWorld()).getBlockAt(x, y, z);

                    if(block.getBlockData().getMaterial() != Material.AIR && block.getBlockData().getMaterial() != Material.CAVE_AIR && block.getBlockData().getMaterial() != Material.VOID_AIR) {
                        blocks.add(block);
                    }

                    blocks.add(block);
                }
            }
        }

        return blocks;
    }


}
