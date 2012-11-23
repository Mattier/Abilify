package me.Mattier.Abilify.event;

import org.spout.api.entity.Entity;
import org.spout.api.event.Event;
import org.spout.api.event.HandlerList;

public class AbilifyDamageEvent extends Event {
	private static HandlerList handlers = new HandlerList();
	private final int damage;
	private final Entity target;
	private final Entity source;
	
	public AbilifyDamageEvent(int damage, Entity target, Entity source) {
		this.damage = damage;
		this.target = target;
		this.source = source;
	}
	
	public AbilifyDamageEvent(int damage, Entity target) {
		this(damage, target, null);
	}
	
	public int getDamage() {
		return damage;
	}
	
	public Entity getTarget() {
		return target;
	}
	
	public Entity getSource() {
		return source;
	}
	
	@Override
	public HandlerList getHandlers() {
		return handlers;
	}
}
