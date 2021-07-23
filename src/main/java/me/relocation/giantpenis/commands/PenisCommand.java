package me.relocation.giantpenis.commands;

import com.boydti.fawe.FaweAPI;
import com.boydti.fawe.object.FaweQueue;
import me.relocation.giantpenis.GiantPenis;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PenisCommand implements CommandExecutor {

    private final GiantPenis plugin;

    public PenisCommand(GiantPenis plugin) {
        this.plugin = plugin;
    }

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

        Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> {
            FaweQueue queue = FaweAPI.createQueue(player.getWorld().getName(), false);
            for (int x = player.getLocation().getBlockX(); x < player.getLocation().getBlockX() + size; x++) {
                queue.setBlock(x, player.getLocation().getBlockY(), player.getLocation().getBlockZ(), 1);
            }

            for (int x = player.getLocation().getBlockX(); x > player.getLocation().getBlockX() - size; x--) {
                queue.setBlock(x, player.getLocation().getBlockY(), player.getLocation().getBlockZ(), 1);
            }

            for (int y = player.getLocation().getBlockY(); y < player.getLocation().getBlockY() + height; y++) {
                queue.setBlock(player.getLocation().getBlockX(), y, player.getLocation().getBlockZ(), 1);
            }

            for (int z = player.getLocation().getBlockZ(); z < player.getLocation().getBlockZ() + girth; z++) {
                for (int x = player.getLocation().getBlockX(); x < player.getLocation().getBlockX() + size; x++) {
                    queue.setBlock(x, player.getLocation().getBlockY(), z, 1);
                }
                for (int x = player.getLocation().getBlockX(); x > player.getLocation().getBlockX() - size; x--) {
                    queue.setBlock(x, player.getLocation().getBlockY(), z, 1);
                }
                for (int y = player.getLocation().getBlockY(); y < player.getLocation().getBlockY() + height; y++) {
                    queue.setBlock(player.getLocation().getBlockX(), y, z, 1);
                }
            }
            queue.flush();
        });

        return false;
    }

}
