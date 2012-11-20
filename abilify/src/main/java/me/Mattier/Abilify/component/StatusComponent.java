package me.Mattier.Abilify.component;

import java.util.HashMap;

import me.Mattier.Abilify.AbilifyPlugin;
import me.Mattier.Abilify.database.AbilifyDatabase;
import me.Mattier.Abilify.wrappers.status.Status;

import org.spout.api.component.components.EntityComponent;

/**
 * Component that controls the Abilify statuses for entities.
 */
public class StatusComponent extends EntityComponent {
	private int count = 0;
	private HashMap<Integer, Integer> statuses;
	
	@Override
	public void onAttached() {
		this.statuses = new HashMap<Integer, Integer>();
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
		for (int i : statuses.keySet()) {
			s = AbilifyPlugin.getManager().getStatus(i);
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
		if (statuses.put(s.getId(), s.getDuration()) == null)
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

	@SuppressWarnings("unchecked")
	public void load() {
		statuses = (HashMap<Integer, Integer>) getData().get("ABILIFY_STATUS");
	}

	public void save(AbilifyDatabase database) {
		getData().put("ABILIFY_STATUS", statuses);
	}
}
