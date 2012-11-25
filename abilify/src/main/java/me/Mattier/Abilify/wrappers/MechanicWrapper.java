package me.Mattier.Abilify.wrappers;

import java.io.Serializable;
import java.util.UUID;

import me.Mattier.Abilify.mechanic.Mechanic;
import me.Mattier.Abilify.mechanic.Type;

import org.spout.api.entity.Entity;

public interface MechanicWrapper extends Serializable {
	/**
	 * @return The unique database id for this wrapper.
	 */
	public UUID getId();
	
	/**
	 * @return The raw mechanic which this wraps.
	 */
	public Mechanic getMechanic();
	
	/**
	 * @return The datatable for this wrapper.
	 */
	public Datatable getData();
	
	/**
	 * @return The type of mechanic that this wraps.
	 */
	public Type getType();
	
	/**
	 * When called, causes a status to tick, or an ability to fire.
	 * 
	 * @param owner The owner of this status, who will be affected by it.
	 * @return An array of any entities targeted by this mechanic, or null 
	 * if it has no targets.
	 */
	public void main(Entity owner);
}
