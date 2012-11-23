package me.Mattier.Abilify.component;

import java.util.HashMap;
import java.util.UUID;

import me.Mattier.Abilify.Abilify;
import me.Mattier.Abilify.event.StatusEvent;
import me.Mattier.Abilify.wrappers.status.Status;

import org.spout.api.component.components.EntityComponent;
import org.spout.api.entity.Entity;

/**
 * Component that controls the Abilify statuses for entities.
 */
public class StatusComponent extends EntityComponent {
	private int count = 0;
	private HashMap<UUID, Integer> statuses;
	
	@Override
	public void onAttached() {
		this.statuses = new HashMap<UUID, Integer>();
	}
	
	@Override
	public void onDetached() {
		getData().remove("ABILIFY_STATUS");
	}
	
	@Override
	public boolean canTick() {
		return true;
	}
	
	@Override
	public void onTick(float dt) {
		Status s;
		int d;
		for (UUID i : statuses.keySet()) {
			s = Abilify.getManager().getStatus(i);
			d = statuses.get(i);
			if (d == -1  && count == 9) {
				useStatus(s);
			} else if(d == 0) {
				removeStatus(s);
			} else if(d % s.getTickRate() == 0) {
				useStatus(s);
				statuses.put(i, d--);
			} else {
				statuses.put(i, d--);
			}
		}
		count++;
		if (count == 10)
			count = 0;
	}
	
	public boolean addStatus(Status s) {
		return addStatus(s.getId());
	}
	
	public boolean addStatus(UUID id) {
		if (statuses.put(id, Abilify.getManager().getStatus(id).getDuration()) != null) {
			save();
			return true;
		}
		return false;	
	}
	
	public boolean removeStatus(Status s) {
		return removeStatus(s.getId());
	}
	
	public boolean removeStatus(UUID id) {
		if (statuses.remove(id) != null) {
			save();
			return true;
		}
		return false;
	}
	
	public boolean hasStatus(Status s) {
		return hasStatus(s.getId());
	}
	
	public boolean hasStatus(UUID id) {
		return statuses.containsKey(id);
	}
	
	public boolean useStatus(Status s) {
		return useStatus(s.getId());
	}
	
	public boolean useStatus(UUID id) {
		if (!hasStatus(id))
			return false;
		else {
			Status s = Abilify.getManager().getStatus(id);
			Entity e = this.getOwner();
			StatusEvent event = new StatusEvent(s, e);
			if (event.isCancelled())
				return false;
			s.main(this.getOwner());
			return true;
		}
	}
	
	@SuppressWarnings("unchecked")
	public void load() {
		statuses = (HashMap<UUID, Integer>) getData().get("ABILIFY_STATUS");
		for (UUID i : statuses.keySet()) {
			if (!Abilify.getManager().hasStatus(i))
				removeStatus(i);
		}
	}

	public void save() {
		getData().put("ABILIFY_STATUS", statuses);
	}
}
