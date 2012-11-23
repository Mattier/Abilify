package me.Mattier.Abilify.wrappers;

import java.util.UUID;

import org.spout.api.entity.Entity;

import me.Mattier.Abilify.mechanic.Mechanic;
import me.Mattier.Abilify.wrappers.ability.Ability;
import me.Mattier.Abilify.wrappers.status.Status;

public interface WrapperInterface {
	/**
	 * @return The unique database id for this wrapper.
	 */
	public UUID getId();
	
	/**
	 * @return The raw mechanic which this wraps.
	 */
	public Mechanic getMechanic();
	
	/**
	 * @return The modifier array for the wrapped mechanic.
	 */
	public int[] getModifier();
	
	/**
	 * @return The display name for this wrapper.
	 */
	public String getName();
	
	/**
	 * @return The description text for this wrapper.
	 */
	public String getDescription();
	
	/**
	 * @return The announcement text for this wrapper
	 */
	public String getAnnounce();
	
	/**
	 * @return The secondary status/ability if the mechanic is chained
	 * or applies a status, otherwise null.
	 */
	public MechanicWrapper getSecondary();
	
	/**
	 * @param modifier A modifier array for the wrapped mechanic.
	 */
	public void setModifier(int[] modifier);
	
	/**
	 * @param name The display name for this wrapper.
	 */
	public void setName(String name);
	
	/**
	 * @param description The description text for this wrapper.
	 */
	public void setDescription(String description);
	
	/**
	 * @param announce The announcement text for this wrapper.
	 */
	public void setAnnounce(String announce);
	
	/**
	 * @param wrapper The secondary status/ability if the mechanic is chained
	 * or applies a status.
	 */
	public void setSecondary(MechanicWrapper wrapper);
	
	/**
	 * When called, causes a status to tick, or an ability to fire.
	 * 
	 * @param owner The owner of this status, who will be affected by it.
	 * @return An array of any entities targeted by this mechanic, or null 
	 * if it has no targets.
	 */
	public Entity[] main(Entity owner);
	
	/**
	 * When called, causes a status to tick, or an ability to fire. This method
	 * is used when an ability chains with the mechanic.
	 * 
	 * @param owner The owner of this status, who will be affected by it.
	 * @param ability The ability to be chained with the mechanic.
	 * @return An array of any entities targeted by this mechanic, or null 
	 * if it has no targets.
	 */
	public Entity[] main(Entity owner, Ability ability);
	
	/**
	 * When called, causes a status to tick, or an ability to fire. This method
	 * is used when the mechanic also applies a status effect.
	 * 
	 * @param owner The owner of this status, who will be affected by it.
	 * @param status The status effect to be applied by the mechanic.
	 * @return An array of any entities targeted by this mechanic, or null 
	 * if it has no targets.
	 */
	public Entity[] main(Entity owner, Status status);
}
