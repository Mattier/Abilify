package me.Mattier.Abilify.Test;

import me.Mattier.Abilify.mechanic.Mechanic;
import me.Mattier.Abilify.mechanic.MechanicData;
import me.Mattier.Abilify.mechanic.MechanicType;

import org.spout.api.entity.Entity;

@MechanicData(name = "TestStatus", type = MechanicType.STATUS, author = "Mattier", pack = "TestPack")
public class TestStatus extends Mechanic {
	
	@Override
	public boolean main(Entity e) {
		return false;
	}
	
}
