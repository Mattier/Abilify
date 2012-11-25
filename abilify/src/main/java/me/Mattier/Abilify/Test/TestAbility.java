package me.Mattier.Abilify.Test;

import me.Mattier.Abilify.mechanic.Data;
import me.Mattier.Abilify.mechanic.Mechanic;
import me.Mattier.Abilify.mechanic.Type;
import me.Mattier.Abilify.wrappers.Ability;
import me.Mattier.Abilify.wrappers.Datatable;
import me.Mattier.Abilify.wrappers.Default;
import me.Mattier.Abilify.wrappers.Status;

import org.spout.api.entity.Entity;

@Data(type = Type.ABILITY, name = "TestAbility", author = "Mattier", pack = "TestPack")
public class TestAbility extends Mechanic {
	{
		addDefault(new Default<String>("Random", "Name"));
		addDefault(new Default<Status>("Status Applied", null));
		addDefault(new Default<Ability>("Ability Chained", null));
	}
	
	@Override
	public void main(Entity owner, Datatable data) {
		// Do stuff!
	}
}
