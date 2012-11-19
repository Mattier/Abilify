package me.Mattier.Abilify.component;

import org.spout.api.component.components.EntityComponent;
import org.spout.api.entity.Entity;

/**
 * Component that allows an Entity to interact with Abilify
 * statuses and abilities.
 */
public class AbilifyComponent extends EntityComponent {
	@Override
	public void onAttached() {
		Entity holder = getOwner();
		holder.add(StatusComponent.class);
		holder.add(AbilityComponent.class);
	}
	
	@Override
	public boolean canTick() {
		return false;
	}
	
	public AbilityComponent getAbility() {
		return getOwner().get(AbilityComponent.class);
	}
	
	public StatusComponent getStatus() {
		return getOwner().get(StatusComponent.class);
	}
}