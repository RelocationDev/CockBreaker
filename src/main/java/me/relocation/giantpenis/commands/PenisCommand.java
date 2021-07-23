package me.relocation.giantpenis.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PenisCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("retard");
            return true;
        }

        if (args.length != 3) {
            sender.sendMessage("retard");
            return true;
        }

        Player player = (Player) sender;

        int size = Integer.parseInt(args[0]) / 2;
        int girth = Integer.parseInt(args[1]);
        int height = Integer.parseInt(args[2]);

        for (int x = player.getLocation().getBlockX(); x < player.getLocation().getBlockX() + size; x++) {
            player.getWorld().getBlockAt(x, player.getLocation().getBlockY(), player.getLocation().getBlockZ()).setType(Material.STONE);
        }

        for (int x = player.getLocation().getBlockX(); x > player.getLocation().getBlockX() - size; x--) {
            player.getWorld().getBlockAt(x, player.getLocation().getBlockY(), player.getLocation().getBlockZ()).setType(Material.STONE);
        }

        for (int y = player.getLocation().getBlockY(); y < player.getLocation().getBlockY() + height; y++) {
            player.getWorld().getBlockAt(player.getLocation().getBlockX(), y, player.getLocation().getBlockZ()).setType(Material.STONE);
        }

        for (int z = player.getLocation().getBlockZ(); z < player.getLocation().getBlockZ() + girth; z++) {
            for (int x = player.getLocation().getBlockX(); x < player.getLocation().getBlockX() + size; x++) {
                player.getWorld().getBlockAt(x, player.getLocation().getBlockY(), z).setType(Material.STONE);
            }
            for (int x = player.getLocation().getBlockX(); x > player.getLocation().getBlockX() - size; x--) {
                player.getWorld().getBlockAt(x, player.getLocation().getBlockY(), z).setType(Material.STONE);
            }
            for (int y = player.getLocation().getBlockY(); y < player.getLocation().getBlockY() + height; y++) {
                player.getWorld().getBlockAt(player.getLocation().getBlockX(), y, z).setType(Material.STONE);
            }
        }

        return false;
    }

}
