/*****************************************************************/
/*		Abilify - The SpoutAPI, Component-based, ability API
 * 			and management system.
 * 			
 *		Copyright (C) 2012 Charlotte Mattier
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package me.Mattier.Abilify;

import java.util.logging.Logger;

import org.spout.api.UnsafeMethod;
import org.spout.api.plugin.CommonPlugin;

public class AbilifyPlugin extends CommonPlugin {
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
	
	
	
/* Logger */
	public static void info(String s) {logger.info(s);}
	public static void warning(String s) {logger.warning(s);}
	public static void severe(String s) {logger.severe(s);}

}
