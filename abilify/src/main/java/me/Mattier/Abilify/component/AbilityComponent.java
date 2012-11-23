package me.Mattier.Abilify.component;

import java.util.HashSet;
import java.util.UUID;

import me.Mattier.Abilify.Abilify;
import me.Mattier.Abilify.event.AbilityEvent;
import me.Mattier.Abilify.wrappers.ability.Ability;

import org.spout.api.component.components.EntityComponent;
import org.spout.api.entity.Entity;

/**
 * Component that controls the Abilify abilities for entities.
 */
public class AbilityComponent extends EntityComponent {
	private HashSet<UUID> abilities;
	
	@Override
	public void onAttached() {
		this.abilities = new HashSet<UUID>();
	}
	
	@Override
	public void onDetached() {
		getData().remove("ABILIFY_ABILITY");
	}
	
	@Override
	public boolean canTick() {
		return false;
	}
	
	public boolean addAbility(Ability ability) {
		return addAbility(ability.getId());
	}
	
	public boolean addAbility(UUID id) {
		boolean b = abilities.add(id);
		save();
		return b;
	}
	
	public boolean removeAbility(Ability ability) {
		return removeAbility(ability.getId());
	}
	
	public boolean removeAbility(UUID id) {
		boolean b = abilities.remove(id);
		save();
		return b;
	}
	
	public boolean hasAbility(Ability a) {
		return hasAbility(a.getId());
	}
	
	public boolean hasAbility(UUID id) {
		return abilities.contains(id);
	}
	
	public boolean useAbility(Ability a) {
		return useAbility(a.getId());
	}
	
	public boolean useAbility(UUID id) {
		if (!hasAbility(id))
			return false;
		else {
			Ability a = Abilify.getManager().getAbility(id);
			Entity e = this.getOwner();
			AbilityEvent event = new AbilityEvent(a, e);
			if (event.isCancelled())
				return false;
			a.main(this.getOwner());
			return true;
		}
	}
	
	@SuppressWarnings("unchecked")
	public void load() {
		abilities = (HashSet<UUID>) getData().get("ABILIFY_ABILITY");
		for (UUID i : abilities) {
			if (!Abilify.getManager().hasAbility(i))
				removeAbility(i);
		}
	}

	public void save() {
		getData().put("ABILIFY_ABILITY", abilities);
	}
}
