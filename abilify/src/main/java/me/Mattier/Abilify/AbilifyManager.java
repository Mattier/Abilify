package me.Mattier.Abilify;

import java.io.File;
import java.util.ArrayList;

import me.Mattier.Abilify.database.AbilifyDatabase;
import me.Mattier.Abilify.database.DatabaseUtil;
import me.Mattier.Abilify.mechanic.Mechanic;
import me.Mattier.Abilify.mechanic.PackageData;
import me.Mattier.Abilify.wrappers.ability.Ability;
import me.Mattier.Abilify.wrappers.status.Status;

import org.spout.api.Spout;

public class AbilifyManager {
	private final AbilifyPlugin plugin;
	private final File packDirectory;
	private final AbilifyDatabase database;
	private final ArrayList<Mechanic> mechanics;
	private final ArrayList<Ability> abilities;
	private final ArrayList<Status> statuses;
	
	public AbilifyManager(AbilifyPlugin plugin) {
		this.plugin = plugin;
		this.packDirectory = new File(plugin.getDataFolder() + File.separator + "packs");
		this.database = new AbilifyDatabase(plugin.getDataFolder());
		this.mechanics = new ArrayList<Mechanic>();
		this.abilities = new ArrayList<Ability>();
		this.statuses = new ArrayList<Status>();
	}
	
	/**
	 * Starts the manager, loading all available mechanics, and wrapping them
	 * so that they are usable by other plugins.
	 */
	public void onEnable() {
		AbilifyPlugin.info("Starting Mechanic Manager...");
		database.onEnable();
		loadMechanics();
		loadWrappers();
		loadPlayers();
		AbilifyPlugin.info("...Mechanic Manager started!");
	}

	/**
	 * Stops the manager, clearing all of the loaded mechanics and
	 * wrapped mechanics.
	 */
	public void onDisable() {
		AbilifyPlugin.info("Stopping Mechanic Manager...");
		mechanics.clear();
		abilities.clear();
		statuses.clear();
		database.onDisable();
		AbilifyPlugin.info("...Mechanic Manager stopped!");
	}

	/**
	 * Loads all mechanic packs available in the '../Abilify/packs' folder.
	 * Mechanic packs will register their individual mechanics, and all 
	 * mechanics which are successfully registered will end up in the 
	 * 'mechanics' ArrayList.
	 */
	public void loadMechanics() {
		Spout.getPluginManager().loadPlugins(packDirectory);
	}
	
	/**
	 * Loads all of the Ability and Status wrappers from the database.
	 */
	private void loadWrappers() {
		abilities.addAll(DatabaseUtil.loadAbilitiesFrom(database.getDatabase()));
		statuses.addAll(DatabaseUtil.loadStatusesFrom(database.getDatabase()));
	}
	
	/**
	 * Attach abilify components to all online players, and load their abilities
	 * and statuses from the database.
	 */
	private void loadPlayers() {
		
		//XXXXXXXXXXXXXXXXXXXXXXXXXXXX
		
	}
	
	/**
	 * @param name The class name for a mechanic, as returned by
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
	 * @return An {@link ArrayList} of all of the registered {@link Ability abilities}.
	 */
	public ArrayList<Ability> getAbilities() {
		return abilities;
	}
	
	/**
	 * @return An {@link ArrayList} of all of the registered {@link Status statuses}.
	 */
	public ArrayList<Status> getStatuses() {
		return statuses;
	}
	
	/**
	 * As a pack is loaded, this is used to instantiate and register any
	 * mechanics that it contains.
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
	 * Registers an {@link Ability} with the manager.
	 * 
	 * @param ability The ability to register.
	 * @return true (as specified by {@link ArrayList#add})
	 */
	public boolean registerAbility(Ability ability) {
		return abilities.add(ability);
	}
	
	/**
	 * Registers an {@link Status} with the manager.
	 * 
	 * @param ability The ability to register.
	 * @return true (as specified by {@link ArrayList#add})
	 */
	public boolean registerStatus(Status status) {
		return statuses.add(status);
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
	
	/**
	 * @return true if the specified ability is registered with the manager.
	 */
	public boolean hasAbility(Ability ability) {
		return abilities.contains(ability);
	}
	
	/**
	 * @return true if the specified status is registered with the manager.
	 */
	public boolean hasStatus(Status status) {
		return statuses.contains(status);
	}
	
}
