package me.Mattier.Abilify.component;

import me.Mattier.Abilify.mechanic.Mechanic;

import org.spout.api.component.components.EntityComponent;

public class AbilityComponent extends EntityComponent {
	@Override
	public void onAttached() {
	}
	
	@Override
	public boolean canTick() {
		return false;
	}
	
	public boolean useAbility(Class<? extends Mechanic> mechanic) {
		return true;
	}
	
	public boolean addAbility() {
		return true;
	}
	
	public boolean removeAbility() {
		return true;
	}
}
