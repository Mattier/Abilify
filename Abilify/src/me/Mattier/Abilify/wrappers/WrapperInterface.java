package me.Mattier.Abilify.wrappers;

import me.Mattier.Abilify.mechanic.Mechanic;

public interface WrapperInterface {
	public Mechanic getMechanic();
	public int[] getModifier();
	public String getName();
	public String getDescription();
	public String getAnnounce();
	public void setModifier(int[] modifier);
	public void setName(String name);
	public void setDescription(String description);
	public void setAnnounce(String announce);
}
