package me.relocation.giantpenis;

import me.relocation.giantpenis.commands.PenisCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class GiantPenis extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("penis").setExecutor(new PenisCommand());
    }

    @Override
    public void onDisable() {
    }

}
