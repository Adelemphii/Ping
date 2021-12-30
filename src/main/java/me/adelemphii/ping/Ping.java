package me.adelemphii.ping;

import me.adelemphii.ping.events.AsyncChatListener;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author Adelempii
 * All the code in this plugin is meant to be garbage.
 */
public final class Ping extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new AsyncChatListener(), this);
    }

    @Override
    public void onDisable() {
    }
}
