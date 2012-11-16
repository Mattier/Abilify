package me.Mattier.Abilify.wrappers.status;

import me.Mattier.Abilify.mechanic.Mechanic;
import me.Mattier.Abilify.wrappers.MechanicWrapper;

public abstract class StatusWrapper extends MechanicWrapper implements Status {
	private int duration, rate;
	
	public StatusWrapper(Mechanic mechanic) {
		super(mechanic);
	}
	
	public int getDuration() {
		return duration;
	}
	
	public int getTickRate() {
		return rate;
	}
	
	public void setDuration(int i) {
		this.duration = i;
	}
	
	public void setTickRate(int i) {
		this.rate = i;
	}
}
