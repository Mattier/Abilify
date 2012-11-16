package me.Mattier.Abilify.mechanic;

import org.spout.api.entity.Entity;
import org.spout.api.geo.discrete.Point;

public class Mechanic {
	protected boolean cancelled = false;
	protected int power = 0;
	
	public String getAuthor() {
		return this.getClass().getAnnotation(MechanicData.class).author();
	}
	
	public String getName() {
		return this.getClass().getAnnotation(MechanicData.class).name();
	}
	
	public String getPack() {
		return this.getClass().getAnnotation(MechanicData.class).pack();
	}
	
	public MechanicType getType() {
		return this.getClass().getAnnotation(MechanicData.class).type();
	}
	
	/* Status, Passive, and Untargeted */
	public boolean main(Entity e) {
		return false;
	}
	
	/* Targeted, point */
	public boolean main(Entity e, Point target) {
		return false;
	}
	
	/* Targeted, entity */
	public boolean main(Entity e, Entity target) {
		return false;
	}
}
