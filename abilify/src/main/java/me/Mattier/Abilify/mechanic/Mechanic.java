package me.Mattier.Abilify.mechanic;

import java.io.Serializable;

import me.Mattier.Abilify.event.AbilifyDamageEvent;
import me.Mattier.Abilify.wrappers.Cost;
import me.Mattier.Abilify.wrappers.Datatable;
import me.Mattier.Abilify.wrappers.Default;
import me.Mattier.Abilify.wrappers.Status;

import org.spout.api.Spout;
import org.spout.api.entity.Entity;

/**
 * A raw game mechanic. Package information about the mechanic should be supplied
 * in the {@link PackageData} annotation, and mechanical information about the mechanic
 * should be supplied in the {@link MechanicData} annotation.
 */
public abstract class Mechanic {
	private static final Datatable data = new Datatable();
	{
		addDefault(new Default<String>("name", "Name"));
		addDefault(new Default<String>("description", "Description Text"));
		addDefault(new Default<String>("announce", "Announcement Text"));
		
		if (getType() == Type.ABILITY) {
			addDefault(new Default<Cost>("cost", null));
		} else if (getType() == Type.STATUS_TICKING) {
			addDefault(new Default<Integer>("duration", 20));
			addDefault(new Default<Integer>("rate", 20));
		} else if (getType() == Type.STATUS_TRIGGERED) {
			addDefault(new Default<Integer>("duration", 20));
			addDefault(new Default<Integer>("rate", -1));
			addDefault(new Default<Status>("hidden", null));
		}
	}
	
	/**
	 * Registers a new default with the Datatable.
	 */
	public <T extends Serializable> void addDefault(Default<T> def) {
		data.addDefault(def);
	}
	
/* Mechanic Data */
	/**
	 * @return The default {@link Datatable} for this mechanic.
	 */
	public Datatable getData() {
		return data;
	}
	
	/**
	 * @return The {@link Type} of this mechanic.
	 */
	public Type getType() {
		return this.getClass().getAnnotation(Data.class).type();
	}
	
	/**
	 * @return The name of this mechanic.
	 */
	public String getName() {
		return this.getClass().getAnnotation(Data.class).name();
	}
	
	/**
	 * @return The author of this mechanic.
	 */
	public String getAuthor() {
		return this.getClass().getAnnotation(Data.class).author();
	}
	
	/**
	 * @return The name of the package which contains this mechanic.
	 */
	public String getPack() {
		return this.getClass().getAnnotation(Data.class).pack();
	}
	
/* Other Methods */
	/**
	 * Basic Mechanic main() method. When an ability is used, or a status ticks, this is what it does.
	 * 
	 * @param owner The entity which owns this mechanic, ie. the caster of an ability mechanic, 
	 * or the individual affected by a status mechanic.
	 * @param table The datatable of a mechanic wrapper.
	 * @return The targets of a mechanic, or null if this mechanic is untargeted.
	 */
	public abstract void main(Entity owner, Datatable table);
	
	/**
	 * Currently only used with triggered statuses. This checks if the mechanic will trigger, 
	 * and returns the result. In the case that this returns true, the {@link #main} method
	 * will be called, and the status will be removed from its owner.
	 * 
	 * @param owner The entity which owns this mechanic, ie. the individual affected by a status mechanic.
	 * @return Whether or not the status will trigger.
	 */
	public boolean check(Entity owner) {
		return false;
	}
	
	/**
	 * Used to call an {@link me.Mattier.Abilify.event.AbilifyDamageEvent AbilifyDamageEvent}, which 
	 * will later be handled by the specified {@link me.Mattier.Abilify.DamageHandler DamageHandler}.
	 * 
	 * As an example, after this event is called on a server where a Vanilla damage handler has
	 * been specified, the handler will turn this into a VanillaDamageEvent.
	 * 
	 * @param damage The amount of damage to be applied.
	 * @param target The entity being damaged.
	 */
	public void damage(int damage, Entity target) {
		damage(damage, target, null);
	}
	
	/**
	 * Used to call an {@link me.Mattier.Abilify.event.AbilifyDamageEvent AbilifyDamageEvent}, which 
	 * will later be handled by the specified {@link me.Mattier.Abilify.DamageHandler DamageHandler}.
	 * 
	 * As an example, after this event is called on a server where a Vanilla damage handler has
	 * been specified, the handler will turn this into a VanillaDamageEvent.
	 * 
	 * @param damage The amount of damage to be applied.
	 * @param target The entity being damaged.
	 * @param source The entity which is the source of the damage.
	 */
	public void damage(int damage, Entity target, Entity source) {
		AbilifyDamageEvent event = new AbilifyDamageEvent(damage, target, source);
		Spout.getEventManager().callEvent(event);
	}
}
