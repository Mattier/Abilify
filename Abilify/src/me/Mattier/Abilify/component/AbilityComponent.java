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
package me.Mattier.Abilify.component;

import java.util.ArrayList;

import me.Mattier.Abilify.wrappers.ability.Ability;

import org.spout.api.component.components.EntityComponent;

public class AbilityComponent extends EntityComponent {
	private ArrayList<Ability> abilities;
	
	@Override
	public void onAttached() {
		this.abilities = new ArrayList<Ability>();
	}
	
	@Override
	public void onDetached() {
		// Save abilities.
	}
	
	@Override
	public boolean canTick() {
		return false;
	}
	
	public boolean addAbility(Ability a) {
		return abilities.add(a);
	}
	
	public boolean removeAbility(Ability a) {
		return abilities.remove(a);
	}
	
	public boolean hasAbility(Ability a) {
		return abilities.contains(a);
	}
	
	public boolean useAbility(Ability a) {
		if (!hasAbility(a))
			return false;
		else {
			a.use(this.getOwner());
			return true;
		}
	}
}
