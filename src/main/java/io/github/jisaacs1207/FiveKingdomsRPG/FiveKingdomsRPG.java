package io.github.jisaacs1207.FiveKingdomsRPG;

import io.github.jisaacs1207.FiveKingdomsRPG.Weapons;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class FiveKingdomsRPG extends JavaPlugin{
	public static FiveKingdomsRPG plugin;
	
	@Override
	public void onEnable() {
		plugin = this;
		saveDefaultConfig();
		getLogger().info("5K RPG core is now loaded.");
		registerEvents(this, new Weapons());
	}

	@Override
	public void onDisable() {
		getLogger().info("5K RPG core is now unloaded.");
		plugin = null;
	}

	public static void registerEvents(org.bukkit.plugin.Plugin plugin, Listener... listeners) {
        for (Listener listener : listeners) {
            Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
        }
    }
}
