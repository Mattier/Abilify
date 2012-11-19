package me.Mattier.Abilify.wrappers.status;

import org.spout.api.entity.Entity;

import me.Mattier.Abilify.mechanic.Mechanic;
import me.Mattier.Abilify.wrappers.MechanicWrapper;

public abstract class StatusWrapper extends MechanicWrapper implements Status {
	private int duration, rate;
	
	public StatusWrapper(int id, Mechanic m) {
		super(id, m);
	}
	
	public abstract Entity[] tick(Entity owner);
	
	public int getDuration() {
		return duration;
	}
	
	public int getTickRate() {
		return rate;
	}
	
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public void setTickRate(int rate) {
		this.rate = rate;
	}
}
