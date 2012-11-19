package me.Mattier.Abilify.mechanic;

import org.spout.api.entity.Entity;

/**
 * A raw game mechanic. Package information about the mechanic should be supplied
 * in the {@link PackageData} annotation, and mechanical information about the mechanic
 * should be supplied in the {@link MechanicData} annotation.
 */
public abstract class Mechanic {
/* Mechanic Data */
	/**
	 * @return The {@link MechanicType} of this mechanic.
	 */
	public MechanicType getType() {
		return this.getClass().getAnnotation(MechanicData.class).type();
	}
	
	/**
	 * @return The default modifier array of this mechanic.
	 */
	public int[] getModifier() {
		return this.getClass().getAnnotation(MechanicData.class).mod();
	}

/* Pack Data */
	/**
	 * @return The name of this mechanic.
	 */
	public String getName() {
		return this.getClass().getAnnotation(PackageData.class).name();
	}
	
	/**
	 * @return The author of this mechanic.
	 */
	public String getAuthor() {
		return this.getClass().getAnnotation(PackageData.class).author();
	}
	
	/**
	 * @return The name of the package which contains this mechanic.
	 */
	public String getPack() {
		return this.getClass().getAnnotation(PackageData.class).pack();
	}
	
/* Main Method */
	/**
	 * The core of a mechanic. When an ability is used, or a status ticks, this is what it does.
	 * 
	 * @param owner The entity which owns this mechanic, ie. the caster of an ability mechanic, 
	 * or the individual affected by a status mechanic.
	 * @param modifier The modifier array for this mechanic, these values are used by a server
	 * admin to customize a mechanic.
	 * @return The targets of a mechanic, or null if this mechanic is untargeted.
	 */
	public abstract Entity[] main(Entity owner, int[] modifier);
	
	/**
	 * Currently only used with triggered statuses. This checks if the mechanic will trigger, 
	 * and returns the result. In the case that this returns true, the {@link #main} method
	 * will be called, and the status will be removed from its owner.
	 * 
	 * @param owner The entity which owns this mechanic, ie. the individual affected by a status mechanic.
	 * @return Whether or not the status will trigger.
	 */
	public boolean check(Entity owner) {
		return true;
	}
	
}
