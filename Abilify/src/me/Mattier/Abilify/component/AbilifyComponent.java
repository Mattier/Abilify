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

import org.spout.api.component.components.EntityComponent;
import org.spout.api.entity.Entity;

public class AbilifyComponent extends EntityComponent {
	@Override
	public void onAttached() {
		Entity holder = getOwner();
		holder.add(StatusComponent.class);
		holder.add(AbilityComponent.class);
	}
	
	@Override
	public boolean canTick() {
		return false;
	}
	
	public AbilityComponent getAbility() {
		return getOwner().get(AbilityComponent.class);
	}
	
	public StatusComponent getStatus() {
		return getOwner().get(StatusComponent.class);
	}
}
