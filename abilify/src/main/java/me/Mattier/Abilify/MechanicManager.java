package me.Mattier.Abilify;

import java.util.ArrayList;
import java.util.HashMap;

import me.Mattier.Abilify.mechanic.Mechanic;
import me.Mattier.Abilify.wrappers.ability.Ability;
import me.Mattier.Abilify.wrappers.status.Status;

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
	 * @param name The class name for a {@link Mechanic Mechanic}, as returned by
	 * {@link Class#getName()}. 
	 * @return The loaded mechanic.
	 */
	public Mechanic getMechanic(String name);
	
	/**
	 * @return An ArrayList of all of the loaded mechanics.
	 */
	public ArrayList<Mechanic> getMechanics();
	
	/**
	 * @param name The class name for a mechanic, as returned by
	 * {@link Class#getName()}.
	 * @return true If the specified mechanic has been loaded by the manager.
	 */
	public boolean hasMechanic(String name);

/* Mechanic Wrapper Methods. */
	/**
	 * Registers an {@link Ability} with the manager.
	 * 
	 * @param ability The ability to register.
	 * @return true (as specified by {@link ArrayList#add})
	 */
	public boolean registerAbility(Ability ability);
	
	/**
	 * Registers an {@link Status} with the manager.
	 * 
	 * @param ability The ability to register.
	 * @return true (as specified by {@link ArrayList#add})
	 */
	public boolean registerStatus(Status status);
	
	/**
	 * @return An {@link ArrayList} of all of the registered {@link Ability abilities},
	 * and their associated IDs.
	 */
	public HashMap<Integer, Ability> getAbilities();
	
	/**
	 * @param id
	 * @return The {@link Ability} with the associated ID.
	 */
	public Ability getAbility(int id);
	
	/**
	 * @return An {@link ArrayList} of all of the registered {@link Status statuses},
	 * and their associated IDs.
	 */
	public HashMap<Integer, Status> getStatuses();
	
	/**
	 * @param id
	 * @return The {@link Status} with the associated ID.
	 */
	public Status getStatus(int id);
	
	/**
	 * @return true if the specified ability is registered with the manager.
	 */
	public boolean hasAbility(Ability ability);
	
	/**
	 * @return true if the specified status is registered with the manager.
	 */
	public boolean hasStatus(Status status);
}
