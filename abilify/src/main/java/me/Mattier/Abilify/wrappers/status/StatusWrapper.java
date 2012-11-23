package me.Mattier.Abilify.wrappers.status;

import java.util.UUID;

import org.spout.api.entity.Entity;

import me.Mattier.Abilify.mechanic.Mechanic;
import me.Mattier.Abilify.wrappers.MechanicWrapper;

public class StatusWrapper extends MechanicWrapper implements Status {
	private int duration, rate;
	
	public StatusWrapper(UUID id, Mechanic m) {
		super(id, m);
	}
	
	@Override
	public boolean check(Entity owner) {
		return getMechanic().check(owner);
	}
	
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
