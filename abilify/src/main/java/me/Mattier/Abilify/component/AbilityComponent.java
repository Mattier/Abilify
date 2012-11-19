package me.Mattier.Abilify.component;

import java.util.ArrayList;

import me.Mattier.Abilify.wrappers.ability.Ability;

import org.spout.api.component.components.EntityComponent;

/**
 * Component that controls the Abilify abilities for entities.
 */
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
