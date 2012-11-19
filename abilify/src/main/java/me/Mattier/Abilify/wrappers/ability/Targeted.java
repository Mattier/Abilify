package me.Mattier.Abilify.wrappers.ability;

import me.Mattier.Abilify.mechanic.Mechanic;

import org.spout.api.entity.Entity;

/**
 * An targeted {@link Ability}.
 */
public class Targeted extends AbilityWrapper {
	
	public Targeted(int id, Mechanic m) {
		super(id, m);
	}

	@Override
	public Entity[] use(Entity owner) {
		return getMechanic().main(owner, getModifier());
	}

}
