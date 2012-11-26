package me.Mattier.Abilify;

import java.io.File;
import java.util.ArrayList;

import me.Mattier.Abilify.component.SimpleAbilifyComponent;
import me.Mattier.Abilify.database.AbilifyDatabase;
import me.Mattier.Abilify.database.Database;
import me.Mattier.Abilify.mechanic.Data;
import me.Mattier.Abilify.mechanic.Mechanic;

import org.spout.api.Spout;
import org.spout.api.entity.Entity;

/**
 * This class is the core of Abilify. It manages all mechanics: loading,
 * wrapping, saving wrappers to the database. It also contains various utility
 * methods for interacting with Abilify.
 */
public class AbilifyManager implements MechanicManager {
	private final File packloc;
	private final AbilifyDatabase database;
	private final ArrayList<Mechanic> mechanics;
	
	public AbilifyManager(File file) {
		this.packloc = new File(file + File.separator + "packs");
		this.database = new AbilifyDatabase(new File(file + File.separator + "db"));
		this.mechanics = new ArrayList<Mechanic>();
	}
	
	/**
	 * Starts the manager, loading all available mechanics, wrapping them
	 * so that they are usable by other plugins, and loading all online
	 * players skills/statuses.
	 */
	public void onEnable() {
		Abilify.info("Starting Mechanic Manager...");
		if (!packloc.exists())
			packloc.mkdir();
		database.onEnable();
		loadMechanics();
		Abilify.info("...Mechanic Manager started!");
	}

	/**
	 * Stops the manager, clearing all of the loaded mechanics and
	 * wrapped mechanics.
	 */
	public void onDisable() {
		Abilify.info("Stopping Mechanic Manager...");
		mechanics.clear();
		database.onDisable();
		Abilify.info("...Mechanic Manager stopped!");
	}
	
	/**
	 * Reloads the manager.
	 */
	public void onReload() {
		mechanics.clear();
		loadMechanics();
	}

	/**
	 * Loads all mechanic packs available in the '../Abilify/packs' folder.
	 * Mechanic packs will register their individual mechanics, and all 
	 * mechanics which are successfully registered will end up in the 
	 * 'mechanics' ArrayList.
	 */
	public void loadMechanics() {
		if (packloc.isDirectory() && packloc.list().length > 0)
			Spout.getPluginManager().loadPlugins(packloc);
	}
	
/* Database */
	public Database getDatabase() {
		return database;
	}
	
/* Attaching/Detaching of Abilify Components. */
	@Override
	public void abilifyEntities(Entity[] entities) {
		for (Entity e : entities)
			e.add(SimpleAbilifyComponent.class);
	}
	
	@Override
	public void abilifyEntity(Entity e) {
		e.add(SimpleAbilifyComponent.class);
	}
	
	@Override
	public void debilifyEntities(Entity[] entities) {
		for (Entity e : entities)
			e.detach(SimpleAbilifyComponent.class);
	}
	
	@Override
	public void debilifyEntity(Entity e) {
		e.detach(SimpleAbilifyComponent.class);
	}
	
/* Mechanic Methods. */
	@Override
	public void register(Class<? extends Mechanic> mechanic) {
		try {
			mechanics.add(mechanic.newInstance());
		} catch (Exception e) {
			Abilify.warning("Error loading " + mechanic.getAnnotation(Data.class).name() 
					+ " Mechanic, in Pack " + mechanic.getAnnotation(Data.class).pack() + ".");
		}
	}
	
	@Override
	public ArrayList<Mechanic> getMechanics() {
		return mechanics;
	}
	
	@Override
	public Mechanic getMechanic(String name) {
		try {
			return mechanics.get(mechanics.indexOf(Class.forName(name)));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public boolean hasMechanic(String name) {
		try {
			return mechanics.contains(Class.forName(name));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}
	}
}
