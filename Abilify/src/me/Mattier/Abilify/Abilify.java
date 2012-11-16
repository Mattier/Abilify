package me.Mattier.Abilify;

import java.util.logging.Logger;

import me.Mattier.Abilify.mechanic.Mechanic;

import org.spout.api.UnsafeMethod;
import org.spout.api.plugin.CommonPlugin;

public class Abilify extends CommonPlugin {
	private static Logger logger;
	
	@Override
	@UnsafeMethod
	public void onDisable() {
		info("Abilify: Disabled!");
	}

	@Override
	@UnsafeMethod
	public void onEnable() {
		logger = getLogger();
		info("Abilify: Enabled!");
		
		//Spout.getPluginManager().loadPlugins(File arg0);
	}
	
	@Override @UnsafeMethod public void onLoad() {}
	@Override @UnsafeMethod public void onReload() {}
	
	public static boolean register(Class<? extends Mechanic> mechanic) {
		return true;
	}
	
/* Logger */
	public static void info(String s) {logger.info(s);}
	public static void warning(String s) {logger.warning(s);}
	public static void severe(String s) {logger.severe(s);}

}
