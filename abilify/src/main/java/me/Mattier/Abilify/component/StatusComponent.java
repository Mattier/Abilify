package me.Mattier.Abilify.component;

import java.util.HashMap;

import me.Mattier.Abilify.wrappers.status.Status;

import org.spout.api.component.components.EntityComponent;

/**
 * Component that controls the Abilify statuses for entities.
 */
public class StatusComponent extends EntityComponent {
	private HashMap<Status, Integer> statuses;
	
	@Override
	public void onAttached() {
		this.statuses = new HashMap<Status, Integer>();
	}
	
	@Override
	public boolean canTick() {
		return true;
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
