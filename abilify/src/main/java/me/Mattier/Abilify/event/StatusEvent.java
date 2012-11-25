package me.Mattier.Abilify.event;

import me.Mattier.Abilify.wrappers.Status;

import org.spout.api.entity.Entity;
import org.spout.api.event.Cancellable;
import org.spout.api.event.Event;
import org.spout.api.event.HandlerList;

public class StatusEvent extends Event implements Cancellable {
	private static HandlerList handlers = new HandlerList();
	private boolean c = false;
	private final Status s;
	private final Entity e;

	public StatusEvent(Status s, Entity e) {
		this.s = s;
		this.e = e;
	}
	
	public Status getStatus() {
		return s;
	}
	
	public Entity getOwner() {
		return e;
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
