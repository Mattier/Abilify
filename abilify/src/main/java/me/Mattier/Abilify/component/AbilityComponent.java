package me.Mattier.Abilify.component;

import java.util.HashSet;

import me.Mattier.Abilify.database.AbilifyDatabase;
import me.Mattier.Abilify.wrappers.ability.Ability;

import org.spout.api.component.components.EntityComponent;

/**
 * Component that controls the Abilify abilities for entities.
 */
public class AbilityComponent extends EntityComponent {
	private HashSet<Integer> abilities;
	
	@Override
	public void onAttached() {
		this.abilities = new HashSet<Integer>();
	}
	
	@Override
	public void onDetached() {
		getData().remove("ABILIFY_ABILITY");
	}
	
	@Override
	public boolean canTick() {
		return false;
	}
	
	public boolean addAbility(Ability a) {
		return abilities.add(a.getId());
	}
	
	public boolean removeAbility(Ability a) {
		return abilities.remove(a.getId());
	}
	
	public boolean hasAbility(Ability a) {
		return abilities.contains(a.getId());
	}
	
	public boolean useAbility(Ability a) {
		if (!hasAbility(a))
			return false;
		else {
			a.use(this.getOwner());
			return true;
		}
	}
	
	@SuppressWarnings("unchecked")
	public void load() {
		abilities = (HashSet<Integer>) getData().get("ABILIFY_ABILITY");
	}

	public void save(AbilifyDatabase database) {
		getData().put("ABILIFY_ABILITY", abilities);
	}
}
