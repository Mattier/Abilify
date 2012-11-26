package me.Mattier.Abilify.event;

import me.Mattier.Abilify.wrapper.type.Ability;
import me.Mattier.Abilify.wrapper.type.Cost;

import org.spout.api.entity.Entity;
import org.spout.api.event.Cancellable;
import org.spout.api.event.Event;
import org.spout.api.event.HandlerList;

public class AbilityEvent extends Event implements Cancellable {
	private static HandlerList handlers = new HandlerList();
	private boolean c = false;
	private final Ability a;
	private final Entity e;
	private Cost cost;

	public AbilityEvent(Ability a, Entity e) {
		this.a = a;
		this.e = e;
		this.cost = a.getData().get("cost", Cost.class);
	}
	
	public Ability getAbility() {
		return a;
	}
	
	public Entity getOwner() {
		return e;
	}
	
	public Cost getCost() {
		return cost;
	}
	
	public void setCost(Cost cost) {
		this.cost = cost;
	}

	@Override
	public boolean isCancelled() {
		return c;
	}

	@Override
	public void setCancelled(boolean c) {
		this.c = c;
	}

	@Override
	public HandlerList getHandlers() {
		return handlers;
	}
}
