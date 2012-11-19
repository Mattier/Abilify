package me.Mattier.Abilify.wrappers.status;

import me.Mattier.Abilify.mechanic.Mechanic;

import org.spout.api.entity.Entity;

/**
 * A triggered {@link Status}. This type of status will tick once per every
 * 10 server ticks (~ .5s), and when a certain condition is met, it will trigger
 * and be removed from its owner.
 */
public class Triggered extends StatusWrapper {

	public Triggered(int id, Mechanic m) {
		super(id, m);
	}
	
	@Override
	public Entity[] tick(Entity owner) {
		return getMechanic().main(owner, getModifier());
	}

	public boolean check(Entity owner) {
		return getMechanic().check(owner);
	}
	
	@Override
	public int getTickRate() {
		return 10;
	}
}
