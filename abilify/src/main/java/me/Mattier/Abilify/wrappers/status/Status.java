package me.Mattier.Abilify.wrappers.status;

import me.Mattier.Abilify.wrappers.MechanicWrapper;
import me.Mattier.Abilify.wrappers.WrapperInterface;

import org.spout.api.entity.Entity;

/**
 * The {@link MechanicWrapper} for a Status. Contains status
 * specific information in addition the the basic mechanic information.
 */
public interface Status extends WrapperInterface {
	/**
	 * @return The duration that this status ticks for, before being removed.
	 */
	public int getDuration();
	
	/**
	 * @return The rate at which this status ticks.
	 */
	public int getTickRate();
	
	/**
	 * @param duration The duration that this status lasts for, in ticks.
	 */
	public void setDuration(int duration);
	
	/**
	 * @param rate The rate at which this status ticks.
	 */
	public void setTickRate(int rate);
	
	/**
	 * Currently only used with triggered statuses. This checks if the mechanic will trigger.
	 * In the case that this returns true, the {@link #main} method will be called, and the 
	 * status will be removed from its owner.
	 * 
	 * @param owner The entity which owns this mechanic, ie. the individual affected by a status mechanic.
	 * @return Whether or not the status will trigger.
	 */
	public boolean check(Entity owner);
}
