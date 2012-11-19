package me.Mattier.Abilify.wrappers.status;

import me.Mattier.Abilify.wrappers.MechanicWrapper;
import me.Mattier.Abilify.wrappers.WrapperInterface;

import org.spout.api.entity.Entity;

/**
 * The {@link MechanicWrapper} for a Status. Contains status
 * specific information in addition the the basic mechanic information.
 */
public interface Status extends WrapperInterface{
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
	 * When called, causes the status to tick.
	 * 
	 * @param owner The owner of this status, who will be affected by it.
	 * @return An array of any entities targeted by this status (ie. if the status
	 * causes a ticking aoe around the owner, whoever will be hit), or null if 
	 * the status has no targets.
	 */
	public Entity[] tick(Entity owner);
}
