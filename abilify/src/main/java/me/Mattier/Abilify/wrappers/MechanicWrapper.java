package me.Mattier.Abilify.wrappers;

import me.Mattier.Abilify.mechanic.Mechanic;

/**
 * Wraps a raw {@link Mechanic}, holding basic information
 * about it, such as it's display name, description, announcement 
 * text, and modifier array.
 */
public abstract class MechanicWrapper implements WrapperInterface {
	private final int id;
	private final Mechanic mech;
	private int[] mod;
	private String name, desc, annc;
	
	public int getId() {
		return id;
	}
	
	public MechanicWrapper(int id, Mechanic m) {
		this.id = id;
		this.mech = m;
	}
	
	public Mechanic getMechanic() {
		return mech;
	}
	
	public int[] getModifier() {
		return mod;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return desc;
	}
	
	public String getAnnounce() {
		return annc;
	}
	
	public void setModifier(int[] modifier) {
		this.mod = modifier;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDescription(String description) {
		this.desc = description;
	}
	
	public void setAnnounce(String announce) {
		this.annc = announce;
	}
}
