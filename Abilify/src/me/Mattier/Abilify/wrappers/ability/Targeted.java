package me.Mattier.Abilify.wrappers.ability;

import me.Mattier.Abilify.mechanic.Mechanic;

import org.spout.api.entity.Entity;

public class Targeted extends AbilityWrapper {
	
	public Targeted(Mechanic mechanic) {
		super(mechanic);
	}

	@Override
	public Entity[] use(Entity owner) {
		return getMechanic().main(owner, getModifier());
	}

}
