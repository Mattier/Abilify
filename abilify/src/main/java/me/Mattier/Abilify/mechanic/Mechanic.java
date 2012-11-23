package me.Mattier.Abilify.mechanic;

import me.Mattier.Abilify.event.AbilifyDamageEvent;

import org.spout.api.Spout;
import org.spout.api.entity.Entity;

/**
 * A raw game mechanic. Package information about the mechanic should be supplied
 * in the {@link PackageData} annotation, and mechanical information about the mechanic
 * should be supplied in the {@link MechanicData} annotation.
 */
public abstract class Mechanic {
/* Mechanic Data */
	/**
	 * @return The {@link Type} of this mechanic.
	 */
	public Type getType() {
		return this.getClass().getAnnotation(MechanicData.class).type();
	}
	
	/**
	 * @return The {@link SubType} of this mechanic.
	 */
	public SubType getSubType() {
		return this.getClass().getAnnotation(MechanicData.class).subtype();
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
	
/* Other Methods */
	/**
	 * Basic Mechanic main() method. When an ability is used, or a status ticks, this is what it does.
	 * 
	 * @param owner The entity which owns this mechanic, ie. the caster of an ability mechanic, 
	 * or the individual affected by a status mechanic.
	 * @param modifier The modifier array for this mechanic, these values are used by a server
	 * admin to customize a mechanic.
	 * @param args Variable arguments depending on the abilities subtypes.
	 * @return The targets of a mechanic, or null if this mechanic is untargeted.
	 */
	public Entity[] main(Entity owner, int[] modifier, Object... args) {
		return null;
	}
	
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
