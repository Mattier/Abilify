package me.Mattier.Abilify.wrappers.ability;

import me.Mattier.Abilify.mechanic.Mechanic;

import org.spout.api.entity.Entity;

public class Untargeted extends AbilityWrapper {

	public Untargeted(Mechanic mechanic) {
		super(mechanic);
	}

	@Override
	public Entity[] use(Entity owner) {
		return getMechanic().main(owner, getModifier());
	}

}
