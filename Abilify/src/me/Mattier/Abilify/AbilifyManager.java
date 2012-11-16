package me.Mattier.Abilify;

import org.spout.api.Spout;


public class AbilifyManager {
	private final AbilifyPlugin plugin;
	
	public AbilifyManager(AbilifyPlugin plugin) {
		this.plugin = plugin;
	}

	public void loadAbilityPacks() {
		Spout.getPluginManager().loadPlugins(plugin.getDataFolder());
	}

	public void stop() {
		// TODO Auto-generated method stub
		
	}

	public void start() {
		// TODO Auto-generated method stub
		
	}
}
