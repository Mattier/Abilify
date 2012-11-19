package me.Mattier.Abilify.Test;

import me.Mattier.Abilify.mechanic.Mechanic;
import me.Mattier.Abilify.mechanic.MechanicData;
import me.Mattier.Abilify.mechanic.MechanicType;
import me.Mattier.Abilify.mechanic.PackageData;

import org.spout.api.entity.Entity;

@PackageData(name = "TestAbility", author = "Mattier", pack = "TestPack")
@MechanicData(type = MechanicType.TARGETED, mod = {0, 1, 2, 3, 4, 5})
public class TestAbility extends Mechanic {
	
	@Override
	public Entity[] main(Entity owner, int[] modifier) {
		return null;
	}
	
}
