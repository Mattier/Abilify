package me.Mattier.Abilify;

import java.util.logging.Level;
import java.util.logging.Logger;

import me.Mattier.Abilify.configuration.AbilifyConfig;

import org.spout.api.UnsafeMethod;
import org.spout.api.exception.ConfigurationException;
import org.spout.api.plugin.CommonPlugin;

public class Abilify extends CommonPlugin {
	private static Logger LOGGER;
	private static AbilifyConfig CONFIG;
	private static AbilifyManager MANAGER;
	
	
	@Override @UnsafeMethod
	public void onDisable() {
		MANAGER.onDisable();
		info("Disabled!");
	}

	@Override @UnsafeMethod
	public void onEnable() {
		LOGGER = getLogger();
		if (!loadConfig())
			return;
		MANAGER.onEnable();
		info("Enabled!");
	}
	
	@Override @UnsafeMethod 
	public void onReload() {
		if (!loadConfig())
			return;
		MANAGER.onReload();
		info("Reloaded!");
	}
	
	@Override @UnsafeMethod 
	public void onLoad() {
		CONFIG = new AbilifyConfig(getDataFolder());
		MANAGER = new AbilifyManager(getDataFolder());
	}
	
/* Other methods */
	/**
	 * @return The {@link MechanicManager}, which is responsible for the
	 * handling of all {@link me.Mattier.Abilify.mechanic.Mechanic Mechanics}.
	 */
	public static MechanicManager getManager() {
		return MANAGER;
	}
	
	/**
	 * @return The {@link me.Mattier.Abilify.configuration.AbilifyConfig config}
	 * for this plugin.
	 */
	public static AbilifyConfig getConfig() {
		return CONFIG;
	}
	
	private boolean loadConfig() {
		try {
			CONFIG.load();
			return true;
		} catch (ConfigurationException e) {
			LOGGER.log(Level.SEVERE, "Unable to load configuration file: ", e);
			this.setEnabled(false);
			info("Disabled!");
			return false;
		}
	}
	
/* Logger */
	public static void info(String s) {LOGGER.info(s);}
	public static void warning(String s) {LOGGER.warning(s);}
	public static void severe(String s) {LOGGER.severe(s);}

}
