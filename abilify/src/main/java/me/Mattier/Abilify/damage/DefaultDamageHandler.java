package me.Mattier.Abilify.damage;

import me.Mattier.Abilify.event.AbilifyDamageEvent;

import org.spout.api.event.EventHandler;
import org.spout.api.event.Listener;

public class DefaultDamageHandler implements DamageHandler, Listener {
	private boolean active = false;
	
	@EventHandler
	public void onAbilifyDamage (AbilifyDamageEvent event) {
		return;
	}
	
	public void setActive(boolean b) {
		active = b;
	}
	
	public boolean isActive() {
		return active;
	}
}
