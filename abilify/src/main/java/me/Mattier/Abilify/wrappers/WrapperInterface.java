package me.Mattier.Abilify.wrappers;

import me.Mattier.Abilify.mechanic.Mechanic;

public interface WrapperInterface {
	/**
	 * @return The unique database id for this wrapper.
	 */
	public int getId();
	
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
}
