package me.Mattier.Abilify.component;

import java.util.HashMap;

import me.Mattier.Abilify.mechanic.Mechanic;

import org.spout.api.component.components.EntityComponent;

public class StatusComponent extends EntityComponent {
	//private final HashMap<Status, Integer> skillMap;
	
	@Override
	public void onAttached() {
	}
	
	@Override
	public void onTick(float dt) {
	}
	
	public boolean addStatus() {
		return true;
	}
	
	public boolean removeStatus() {
		return true;
	}
}
