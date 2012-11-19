package me.Mattier.Abilify.wrappers.ability;

import me.Mattier.Abilify.wrappers.WrapperInterface;

import org.spout.api.entity.Entity;

/**
 * The {@link MechanicWrapper} for an Ability. Contains ability
 * specific information in addition the the basic mechanic information.
 */
public interface Ability extends WrapperInterface {
	/**
	 * When called, causes the ability to be cast.
	 * 
	 * @param owner The owner of this ability, who casts it.
	 * @return An array of any entities targeted by this ability, 
	 * or null if the ability is untargeted.
	 */
	public Entity[] use(Entity owner);
}
