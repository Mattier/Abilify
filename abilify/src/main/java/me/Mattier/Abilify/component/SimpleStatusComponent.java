package me.Mattier.Abilify.component;

import java.util.HashMap;
import java.util.UUID;

import me.Mattier.Abilify.Abilify;
import me.Mattier.Abilify.event.StatusEvent;
import me.Mattier.Abilify.exceptions.WrongMechanicTypeException;
import me.Mattier.Abilify.mechanic.Type;
import me.Mattier.Abilify.wrapper.MechanicWrapper;
import me.Mattier.Abilify.wrapper.type.Status;

import org.spout.api.component.components.EntityComponent;

/**
 * Component that controls the Abilify statuses for entities.
 */
public class SimpleStatusComponent extends EntityComponent implements StatusComponent {
	private int count = 0;
	private HashMap<UUID, Integer> statuses;
	
	@Override
	public void onAttached() {
		this.statuses = new HashMap<UUID, Integer>();
	}
	
	@Override
	public boolean canTick() {
		return true;
	}
	
	@Override
	public void onTick(float dt) {
		MechanicWrapper s;
		int d, r;
		for (UUID i : statuses.keySet()) {
			s = Abilify.getDatabase().getWrapper(i);
			d = statuses.get(i); 
			r = s.getData().get("rate", Integer.class);
			
			if (r == -1) { // Infinite rate (triggered)
				continue;
			} 
			else if (d == -1  && count % r == 0) { // Infinite duration (passive)
				useStatus(i);
			} 
			else if(d == 0) { // Expired 
				removeStatus(i);
			} 
			else if(d % r == 0) { // Tick
				useStatus(i);
				statuses.put(i, d--);
			} 
			else { // Tock
				statuses.put(i, d--);
			}
		}
		count++;
		
		if (count == Integer.MAX_VALUE) { // Reset count
			count = 0;
		}
		
		if (count % 20 == 0) { // Save every second
			save();
		}
	}
	
	@Override
	public boolean addStatus(UUID id) throws WrongMechanicTypeException {
		MechanicWrapper m = Abilify.getDatabase().getWrapper(id);
		if (m.getType() != Type.STATUS_TICKING && m.getType() != Type.STATUS_TRIGGERED) {
			throw new WrongMechanicTypeException(m.getType());
		}
		
		if (statuses.put(id, m.getData().get("duration", Integer.class)) != null) {
			save();
			return true;
		}
		return false;	
	}
	
	@Override
	public boolean removeStatus(UUID id) {
		if (statuses.remove(id) != null) {
			save();
			return true;
		}
		return false;
	}
	
	@Override
	public boolean hasStatus(UUID id) {
		return statuses.containsKey(id);
	}
	
	@Override
	public boolean useStatus(UUID id) {
		Status status = (Status) Abilify.getDatabase().getWrapper(id);
		StatusEvent event = new StatusEvent(status, getOwner());
		if (event.isCancelled())
			return false;
		status.main(this.getOwner());
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public void load() {
		statuses = getData().get("ABILIFY_STATUS", HashMap.class);
		MechanicWrapper m;
		for (UUID id : statuses.keySet()) {
			m = Abilify.getDatabase().getWrapper(id);
			if (m == null || (m.getType() != Type.STATUS_TICKING && m.getType() != Type.STATUS_TRIGGERED))
				removeStatus(id);
		}
	}

	public void save() {
		getData().put("ABILIFY_STATUS", statuses);
	}
}
