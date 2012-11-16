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
package me.Mattier.Abilify.mechanic;

import org.spout.api.entity.Entity;

public abstract class Mechanic {
/* Mechanic Data */
	public MechanicType getType() {
		return this.getClass().getAnnotation(MechanicData.class).type();
	}
	
	public int[] getModifier() {
		return this.getClass().getAnnotation(MechanicData.class).mod();
	}

/* Pack Data */
	public String getName() {
		return this.getClass().getAnnotation(PackData.class).name();
	}
	
	public String getAuthor() {
		return this.getClass().getAnnotation(PackData.class).author();
	}
	
	public String getPack() {
		return this.getClass().getAnnotation(PackData.class).pack();
	}
	
/* Targeted */
	public abstract Entity[] main(Entity owner, int[] modifier);
}
