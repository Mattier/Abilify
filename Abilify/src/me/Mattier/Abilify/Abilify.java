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

import org.spout.api.Spout;

import me.Mattier.Abilify.mechanic.Mechanic;

public class Abilify {
	@SuppressWarnings("unused")
	private static final AbilifyPlugin plugin = (AbilifyPlugin) Spout.getPluginManager().getPlugin("Abilify");
	
	public Abilify() {}

	public static boolean register(Class<? extends Mechanic> mechanic) {
		return true;
	}
}
