package me.Mattier.Abilify.Test;

import me.Mattier.Abilify.mechanic.Mechanic;
import me.Mattier.Abilify.mechanic.MechanicData;
import me.Mattier.Abilify.mechanic.MechanicType;

import org.spout.api.entity.Entity;

@MechanicData(name = "TestAbility", type = MechanicType.UNTARGETED, author = "Mattier", pack = "TestPack")
public class TestAbility extends Mechanic {
	
	@Override
	public boolean main(Entity e) {
		return false;
	}
	
}
