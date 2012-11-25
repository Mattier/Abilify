package me.Mattier.Abilify.component;

import java.util.UUID;

public interface StatusComponent {
	
	public boolean addStatus(UUID id);
	
	public boolean removeStatus(UUID id);
	
	public boolean hasStatus(UUID id);
	
	public boolean useStatus(UUID id);
}
