package me.Mattier.Abilify.component;

import java.util.UUID;

public interface AbilityComponent {
	
	public boolean addAbility(UUID id);
	
	public boolean removeAbility(UUID id);
	
	public boolean hasAbility(UUID id);
	
	public boolean useAbility(UUID id);
}
