package me.Mattier.Abilify.wrappers.ability;

import me.Mattier.Abilify.mechanic.Mechanic;

import org.spout.api.entity.Entity;

/**
 * An untargeted {@link Ability}.
 */
public class Untargeted extends AbilityWrapper {

	public Untargeted(int id, Mechanic m) {
		super(id, m);
	}

	@Override
	public Entity[] use(Entity owner) {
		return getMechanic().main(owner, getModifier());
	}

}
