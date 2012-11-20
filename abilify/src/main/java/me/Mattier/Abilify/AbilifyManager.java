package me.Mattier.Abilify;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import me.Mattier.Abilify.component.AbilifyComponent;
import me.Mattier.Abilify.database.AbilifyDatabase;
import me.Mattier.Abilify.database.DatabaseUtil;
import me.Mattier.Abilify.mechanic.Mechanic;
import me.Mattier.Abilify.mechanic.PackageData;
import me.Mattier.Abilify.wrappers.ability.Ability;
import me.Mattier.Abilify.wrappers.status.Status;

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
	private final HashMap<Integer, Ability> abilities;
	private final HashMap<Integer, Status> statuses;
	
	public AbilifyManager(File file) {
		this.packloc = new File(file + File.separator + "packs");
		this.database = new AbilifyDatabase(new File(file + File.separator + "db"));
		this.mechanics = new ArrayList<Mechanic>();
		this.abilities = new HashMap<Integer, Ability>();
		this.statuses = new HashMap<Integer, Status>();
	}
	
	/**
	 * Starts the manager, loading all available mechanics, wrapping them
	 * so that they are usable by other plugins, and loading all online
	 * players skills/statuses.
	 */
	public void onEnable() {
		AbilifyPlugin.info("Starting Mechanic Manager...");
		database.onEnable();
		loadMechanics();
		loadWrappers();
		AbilifyPlugin.info("...Mechanic Manager started!");
	}

	/**
	 * Stops the manager, clearing all of the loaded mechanics and
	 * wrapped mechanics.
	 */
	public void onDisable() {
		AbilifyPlugin.info("Stopping Mechanic Manager...");
		abilities.clear();
		statuses.clear();
		mechanics.clear();
		database.onDisable();
		AbilifyPlugin.info("...Mechanic Manager stopped!");
	}
	
	/**
	 * Reloads the manager.
	 */
	public void onReload() {
		abilities.clear();
		statuses.clear();
		mechanics.clear();
		loadMechanics();
		loadWrappers();
	}

	/**
	 * Loads all mechanic packs available in the '../Abilify/packs' folder.
	 * Mechanic packs will register their individual mechanics, and all 
	 * mechanics which are successfully registered will end up in the 
	 * 'mechanics' ArrayList.
	 */
	public void loadMechanics() {
		Spout.getPluginManager().loadPlugins(packloc);
	}
	
	/**
	 * Loads all of the Ability and Status wrappers from the database.
	 */
	public void loadWrappers() {
		abilities.putAll(DatabaseUtil.loadAbilitiesFrom(database.getDatabase()));
		statuses.putAll(DatabaseUtil.loadStatusesFrom(database.getDatabase()));
	}
	
/* Attaching/Detaching of Abilify Components. */
	/**
	 * Attach abilify components to the selected entities.
	 */
	public void abilifyEntities(Entity[] entities) {
		for (Entity e : entities)
			e.add(AbilifyComponent.class);
	}
	
	/**
	 * Attach abilify components to the selected entity.
	 */
	public void abilifyEntity(Entity e) {
		e.add(AbilifyComponent.class);
	}
	
	/**
	 * Detach abilify components to the selected entities.
	 */
	public void debilifyEntities(Entity[] entities) {
		for (Entity e : entities)
			e.detach(AbilifyComponent.class);
	}
	
	/**
	 * Detatch abilify components from the selected entity.
	 */
	public void debilifyEntity(Entity e) {
		e.detach(AbilifyComponent.class);
	}
	
/* Mechanic Methods. */
	/**
	 * As a pack is loaded, this is used to initiate and register any
	 * {@link Mechanic mechanics} that it contains.
	 * 
	 * @param mechanic The mechanic class to register with the manager.
	 */
	public void register(Class<? extends Mechanic> mechanic) {
		try {
			mechanics.add(mechanic.newInstance());
		} catch (Exception e) {
			AbilifyPlugin.warning("Error loading " + mechanic.getAnnotation(PackageData.class).name() 
					+ " Mechanic, in Pack " + mechanic.getAnnotation(PackageData.class).pack() + ".");
		}
	}
	
	/**
	 * @param name The class name for a {@link Mechanic Mechanic}, as returned by
	 * {@link Class#getName()}. 
	 * @return The loaded mechanic.
	 */
	public Mechanic getMechanic(String name) {
		try {
			return mechanics.get(mechanics.indexOf(Class.forName(name)));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * @return An ArrayList of all of the loaded mechanics.
	 */
	public ArrayList<Mechanic> getMechanics() {
		return mechanics;
	}
	
	/**
	 * @param name The class name for a mechanic, as returned by
	 * {@link Class#getName()}.
	 * @return true If the specified mechanic has been loaded by the manager.
	 */
	public boolean hasMechanic(String name) {
		try {
			return mechanics.contains(Class.forName(name));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}
	}

/* Mechanic Wrapper Methods. */
	/**
	 * Registers an {@link Ability} with the manager.
	 * 
	 * @param ability The ability to register.
	 * @return true (as specified by {@link ArrayList#add})
	 */
	public boolean registerAbility(Ability ability) {
		return abilities.put(ability.getId(), ability) == null ? false : true;
	}
	
	/**
	 * Registers an {@link Status} with the manager.
	 * 
	 * @param ability The ability to register.
	 * @return true (as specified by {@link ArrayList#add})
	 */
	public boolean registerStatus(Status status) {
		return statuses.put(status.getId(), status) == null ? false : true;
	}
	
	/**
	 * @return An {@link ArrayList} of all of the registered {@link Ability abilities},
	 * and their associated IDs.
	 */
	public HashMap<Integer, Ability> getAbilities() {
		return abilities;
	}
	
	/**
	 * @param id
	 * @return The {@link Ability} with the associated ID.
	 */
	public Ability getAbility(int id) {
		return abilities.get(id);
	}
	
	/**
	 * @return An {@link ArrayList} of all of the registered {@link Status statuses},
	 * and their associated IDs.
	 */
	public HashMap<Integer, Status> getStatuses() {
		return statuses;
	}
	
	/**
	 * @param id
	 * @return The {@link Status} with the associated ID.
	 */
	public Status getStatus(int id) {
		return statuses.get(id);
	}
	
	/**
	 * @return true if the specified ability is registered with the manager.
	 */
	public boolean hasAbility(Ability ability) {
		return abilities.containsKey(ability.getId());
	}
	
	/**
	 * @return true if the specified status is registered with the manager.
	 */
	public boolean hasStatus(Status status) {
		return statuses.containsKey(status.getId());
	}
}
