package me.Mattier.Abilify.wrappers.status;

import me.Mattier.Abilify.mechanic.Mechanic;

import org.spout.api.entity.Entity;

/**
 * A ticking {@link Status}. This type of status will tick as specified by
 * its tick rate.
 */
public class Ticking extends StatusWrapper {

	public Ticking(int id, Mechanic m) {
		super(id, m);
	}
	
	@Override
	public Entity[] tick(Entity owner) {
		return getMechanic().main(owner, getModifier());
	}

}
