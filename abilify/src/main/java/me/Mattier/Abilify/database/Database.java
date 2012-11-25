package me.Mattier.Abilify.database;

import java.util.HashMap;
import java.util.UUID;

import me.Mattier.Abilify.mechanic.Type;
import me.Mattier.Abilify.wrappers.MechanicWrapper;

public interface Database {
/* Database Saving */
	/**
	 * Saves an {@link Ability} wrapper to the database
	 */
	public void saveWrapper(MechanicWrapper wrapper);

/* Database Lookup */
	/**
	 * @return The {@link Ability} with the associated ID.
	 */
	public MechanicWrapper getWrapper(UUID id);
	
	/**
	 * @return A map of all of the registered MechanicWrappers of the
	 * specified mechanic type, and their associated IDs.
	 */
	public HashMap<UUID, MechanicWrapper> getWrappers(Type type);
}
