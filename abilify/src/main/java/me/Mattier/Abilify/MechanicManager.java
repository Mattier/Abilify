package me.Mattier.Abilify;

import java.util.ArrayList;

import me.Mattier.Abilify.mechanic.Mechanic;

import org.spout.api.entity.Entity;

public interface MechanicManager {

/* Attaching/Detaching of Abilify Components. */
	/**
	 * Attach abilify components to the selected entities.
	 */
	public void abilifyEntities(Entity[] entities);
	
	/**
	 * Attach abilify components to the selected entity.
	 */
	public void abilifyEntity(Entity e);
	
	/**
	 * Detach abilify components to the selected entities.
	 */
	public void debilifyEntities(Entity[] entities);
	
	/**
	 * Detatch abilify components from the selected entity.
	 */
	public void debilifyEntity(Entity e);
	
/* Mechanic Methods. */
	/**
	 * As a pack is loaded, this is used to initiate and register any
	 * {@link Mechanic mechanics} that it contains.
	 * 
	 * @param mechanic The mechanic class to register with the manager.
	 */
	public void register(Class<? extends Mechanic> mechanic);
	
	/**
	 * @return An ArrayList of all of the loaded mechanics.
	 */
	public ArrayList<Mechanic> getMechanics();
	
	/**
	 * @param name The class name for a {@link Mechanic Mechanic}, as returned by
	 * {@link Class#getName()}. 
	 * @return The loaded mechanic.
	 */
	public Mechanic getMechanic(String name);
	
	/**
	 * @param name The class name for a mechanic, as returned by
	 * {@link Class#getName()}.
	 * @return true If the specified mechanic has been loaded by the manager.
	 */
	public boolean hasMechanic(String name);
}
