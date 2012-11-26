package me.Mattier.Abilify.Test;

import me.Mattier.Abilify.mechanic.Data;
import me.Mattier.Abilify.mechanic.Mechanic;
import me.Mattier.Abilify.mechanic.Type;
import me.Mattier.Abilify.wrapper.data.Datatable;
import me.Mattier.Abilify.wrapper.data.Default;
import me.Mattier.Abilify.wrapper.type.Ability;
import me.Mattier.Abilify.wrapper.type.Status;

import org.spout.api.entity.Entity;

@Data(type = Type.ABILITY, name = "TestAbility", author = "Mattier", pack = "TestPack")
public class TestAbility extends Mechanic {
	private static final long serialVersionUID = 1L;

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
