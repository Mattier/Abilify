package me.Mattier.Abilify.component;

import org.spout.api.component.components.EntityComponent;
import org.spout.api.entity.Entity;

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
}
