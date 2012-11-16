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
package me.Mattier.Abilify.Test;

import me.Mattier.Abilify.mechanic.Mechanic;
import me.Mattier.Abilify.mechanic.MechanicData;
import me.Mattier.Abilify.mechanic.MechanicType;
import me.Mattier.Abilify.mechanic.PackData;

import org.spout.api.entity.Entity;

@PackData(name = "TestAbility", author = "Mattier", pack = "TestPack")
@MechanicData(type = MechanicType.TARGETED, mod = {0, 1, 2, 3, 4, 5})
public class TestAbility extends Mechanic {
	
	@Override
	public Entity[] main(Entity owner, int[] modifier) {
		return null;
	}
	
}
