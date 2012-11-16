package me.Mattier.Abilify.wrappers.ability;

import me.Mattier.Abilify.mechanic.Mechanic;
import me.Mattier.Abilify.wrappers.MechanicWrapper;

public abstract class AbilityWrapper extends MechanicWrapper implements Ability {
	public AbilityWrapper(Mechanic mechanic) {
		super(mechanic);
	}
}
