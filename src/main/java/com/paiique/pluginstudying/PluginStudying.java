package com.paiique.pluginstudying;

import com.paiique.pluginstudying.registers.BukkitRunnableInit;
import com.paiique.pluginstudying.registers.RegisterCommands;
import com.paiique.pluginstudying.registers.RegisterEvents;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.logging.Level;

public final class PluginStudying extends JavaPlugin {

    public void loggerInfo(String msg) {
        getLogger().log(Level.INFO, msg);
    }


    @Override
    public void onEnable() {
        loggerInfo("Oii");

        new BukkitRunnableInit(this);
        new RegisterEvents(this);
        new RegisterCommands(this);
    }

    @Override
    public void onDisable() {
        loggerInfo("Tchau!");
    }
}
