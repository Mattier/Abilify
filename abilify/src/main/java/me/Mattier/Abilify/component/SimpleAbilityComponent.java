package me.Mattier.Abilify.component;

import java.util.HashSet;
import java.util.UUID;

import me.Mattier.Abilify.Abilify;
import me.Mattier.Abilify.event.AbilityEvent;
import me.Mattier.Abilify.exceptions.WrongMechanicTypeException;
import me.Mattier.Abilify.mechanic.Type;
import me.Mattier.Abilify.wrappers.Ability;
import me.Mattier.Abilify.wrappers.MechanicWrapper;

import org.spout.api.component.components.EntityComponent;

/**
 * Component that controls the Abilify abilities for entities.
 */
public class SimpleAbilityComponent extends EntityComponent implements AbilityComponent {
	private HashSet<UUID> abilities;
	
	@Override
	public void onAttached() {
		this.abilities = new HashSet<UUID>();
	}
	
	@Override
	public boolean canTick() {
		return false;
	}
	
	@Override
	public boolean addAbility(UUID id) throws WrongMechanicTypeException {
		Type t = Abilify.getDatabase().getWrapper(id).getType();
		if (t != Type.ABILITY) {
			throw new WrongMechanicTypeException(t);
		}
		
		boolean b = abilities.add(id);
		save();
		return b;
	}
	
	@Override
	public boolean removeAbility(UUID id) {
		boolean b = abilities.remove(id);
		save();
		return b;
	}
	
	@Override
	public boolean hasAbility(UUID id) {
		return abilities.contains(id);
	}
	
	@Override
	public boolean useAbility(UUID id) {
		Ability ability = (Ability) Abilify.getDatabase().getWrapper(id);
		AbilityEvent event = new AbilityEvent(ability, getOwner());
		if (event.isCancelled())
			return false;
		event.getCost().main(getOwner());
		ability.main(this.getOwner());
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public void load() {
		abilities = getData().get("ABILIFY_ABILITY", HashSet.class);
		MechanicWrapper m;
		for (UUID id : abilities) {
			m = Abilify.getDatabase().getWrapper(id);
			if (m == null || m.getType() != Type.ABILITY)
				removeAbility(id);
		}
	}

	public void save() {
		getData().put("ABILIFY_ABILITY", abilities);
	}
}
