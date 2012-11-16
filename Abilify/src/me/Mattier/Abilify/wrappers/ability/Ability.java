package me.Mattier.Abilify.wrappers.ability;

import me.Mattier.Abilify.wrappers.WrapperInterface;

import org.spout.api.entity.Entity;

public interface Ability extends WrapperInterface {
	public Entity[] use(Entity owner);
}
