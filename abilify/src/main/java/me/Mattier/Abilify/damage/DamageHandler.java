package me.Mattier.Abilify.damage;

import me.Mattier.Abilify.event.AbilifyDamageEvent;

import org.spout.api.event.Listener;

/**
 *  The DamageHandler is responsible for intercepting the abstract
 *  {@link AbilifyDamageEvent}, and transforming it into a real 
 *  damage event.
 */
public interface DamageHandler extends Listener {
	
	/**
	 *  Event handler.
	 */
	public void onAbilifyDamage(AbilifyDamageEvent event);
	
	/**
	 *  Sets the damage handler as active.
	 */
	public void setActive(boolean b);
	
	/**
	 *  Checks whether the damage handler is active.
	 */
	public boolean isActive();
}
