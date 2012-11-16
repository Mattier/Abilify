package me.Mattier.Abilify.wrappers;

import me.Mattier.Abilify.mechanic.Mechanic;
import me.Mattier.Abilify.wrappers.ability.Targeted;
import me.Mattier.Abilify.wrappers.ability.Untargeted;
import me.Mattier.Abilify.wrappers.status.Ticking;
import me.Mattier.Abilify.wrappers.status.Triggered;

public class WrapperFactory {
	public static MechanicWrapper createWrapper(Mechanic m) {
		switch(m.getType()) {
			case TARGETED: return new Targeted(m);
			case UNTARGETED: return new Untargeted(m);
			case TICKING: return new Ticking(m);
			case TRIGGERED: return new Triggered(m);
			default: return null;
		}
	}
}
