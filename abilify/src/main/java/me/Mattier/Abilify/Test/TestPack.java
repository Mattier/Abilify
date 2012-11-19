package me.Mattier.Abilify.Test;

import me.Mattier.Abilify.AbilityPack;

public class TestPack extends AbilityPack {

	@Override
	public void unpack() {
		add(TestAbility.class);
	}

}
