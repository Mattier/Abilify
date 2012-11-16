package me.Mattier.Abilify.wrappers;

import me.Mattier.Abilify.mechanic.Mechanic;

public abstract class MechanicWrapper {
	private final Mechanic mechanic;
	private int[] mod;
	private String name, desc, annc;
	
	public MechanicWrapper(Mechanic mechanic) {
		this.mechanic = mechanic;
	}
	
	public Mechanic getMechanic() {
		return mechanic;
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
