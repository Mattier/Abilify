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

import java.util.HashMap;

import me.Mattier.Abilify.wrappers.status.Status;

import org.spout.api.component.components.EntityComponent;

public class StatusComponent extends EntityComponent {
	private HashMap<Status, Integer> statuses;
	
	@Override
	public void onAttached() {
		this.statuses = new HashMap<Status, Integer>();
	}
	
	@Override
	public void onTick(float dt) {
		int count;
		for (Status s : statuses.keySet()) {
			count = statuses.get(s);
			if (count == -1) {
				useStatus(s);
			} else if(count % s.getTickRate() == 1) {
				useStatus(s);
				statuses.put(s, count--);
			} else if(count % s.getTickRate() == 0) {
				useStatus(s);
				removeStatus(s);
			} else {
				statuses.put(s, count--);
			}
		}
	}
	
	public boolean addStatus(Status s) {
		if (statuses.put(s, s.getDuration()) == null)
			return false;
		return true;
	}
	
	public boolean removeStatus(Status s) {
		if (statuses.remove(s) == null)
			return false;
		return true;
	}
	
	public boolean hasStatus(Status s) {
		return statuses.containsKey(s);
	}
	
	public boolean useStatus(Status s) {
		if (!hasStatus(s))
			return false;
		else {
			s.tick(this.getOwner());
			return true;
		}
	}
}
