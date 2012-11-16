package me.Mattier.Abilify.wrappers.status;

import me.Mattier.Abilify.mechanic.Mechanic;

import org.spout.api.entity.Entity;

public class Ticking extends StatusWrapper {

	public Ticking(Mechanic mechanic) {
		super(mechanic);
	}
	
	@Override
	public void tick(Entity owner) {
		getMechanic().main(owner, getModifier());
	}

}
