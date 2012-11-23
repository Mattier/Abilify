package me.Mattier.Abilify.wrappers.ability;

import java.util.UUID;

import me.Mattier.Abilify.mechanic.Mechanic;
import me.Mattier.Abilify.wrappers.MechanicWrapper;

public class AbilityWrapper extends MechanicWrapper implements Ability {
	public AbilityWrapper(UUID id, Mechanic m) {
		super(id, m);
	}
}
