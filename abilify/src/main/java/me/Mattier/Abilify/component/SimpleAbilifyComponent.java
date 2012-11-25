package me.Mattier.Abilify.component;

import org.spout.api.component.components.EntityComponent;
import org.spout.api.entity.Entity;

/**
 * Component that allows an Entity to interact with Abilify
 * statuses and abilities.
 */
public class SimpleAbilifyComponent extends EntityComponent implements AbilifyComponent {
	@Override
	public void onAttached() {
		Entity holder = getOwner();
		holder.add(SimpleStatusComponent.class);
		holder.add(SimpleAbilityComponent.class);
	}
	
	@Override
	public void onDetached() {
		Entity holder = getOwner();
		holder.detach(SimpleAbilityComponent.class);
		holder.detach(SimpleStatusComponent.class);
	}
	
	@Override
	public boolean canTick() {
		return false;
	}
	
	public AbilityComponent getAbilityComponent() {
		return getOwner().get(SimpleAbilityComponent.class);
	}
	
	public StatusComponent getStatusComponent() {
		return getOwner().get(SimpleStatusComponent.class);
	}
}
