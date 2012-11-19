package me.Mattier.Abilify.wrappers.ability;

import org.spout.api.entity.Entity;

import me.Mattier.Abilify.mechanic.Mechanic;
import me.Mattier.Abilify.wrappers.MechanicWrapper;

public abstract class AbilityWrapper extends MechanicWrapper implements Ability {
	public AbilityWrapper(int id, Mechanic m) {
		super(id, m);
	}
	
	public abstract Entity[] use(Entity owner);

}
