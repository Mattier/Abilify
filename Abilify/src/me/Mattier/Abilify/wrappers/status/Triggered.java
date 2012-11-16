package me.Mattier.Abilify.wrappers.status;

import me.Mattier.Abilify.mechanic.Mechanic;

import org.spout.api.entity.Entity;

public class Triggered extends StatusWrapper {

	public Triggered(Mechanic mechanic) {
		super(mechanic);
	}
	
	@Override
	public void tick(Entity owner) {
		getMechanic().main(owner, getModifier());
	}

}
