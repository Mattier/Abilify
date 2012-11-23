package me.Mattier.Abilify;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

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
	private final HashMap<UUID, Ability> abilities;
	private final HashMap<UUID, Status> statuses;
	
	public AbilifyManager(File file) {
		this.packloc = new File(file + File.separator + "packs");
		this.database = new AbilifyDatabase(new File(file + File.separator + "db"));
		this.mechanics = new ArrayList<Mechanic>();
		this.abilities = new HashMap<UUID, Ability>();
		this.statuses = new HashMap<UUID, Status>();
	}
	
	/**
	 * Starts the manager, loading all available mechanics, wrapping them
	 * so that they are usable by other plugins, and loading all online
	 * players skills/statuses.
	 */
	public void onEnable() {
		Abilify.info("Starting Mechanic Manager...");
		database.onEnable();
		loadMechanics();
		loadWrappers();
		Abilify.info("...Mechanic Manager started!");
	}

	/**
	 * Stops the manager, clearing all of the loaded mechanics and
	 * wrapped mechanics.
	 */
	public void onDisable() {
		Abilify.info("Stopping Mechanic Manager...");
		abilities.clear();
		statuses.clear();
		mechanics.clear();
		database.onDisable();
		Abilify.info("...Mechanic Manager stopped!");
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
	@Override
	public void abilifyEntities(Entity[] entities) {
		for (Entity e : entities)
			e.add(AbilifyComponent.class);
	}
	
	@Override
	public void abilifyEntity(Entity e) {
		e.add(AbilifyComponent.class);
	}
	
	@Override
	public void debilifyEntities(Entity[] entities) {
		for (Entity e : entities)
			e.detach(AbilifyComponent.class);
	}
	
	@Override
	public void debilifyEntity(Entity e) {
		e.detach(AbilifyComponent.class);
	}
	
/* Mechanic Methods. */
	@Override
	public void register(Class<? extends Mechanic> mechanic) {
		try {
			mechanics.add(mechanic.newInstance());
		} catch (Exception e) {
			Abilify.warning("Error loading " + mechanic.getAnnotation(PackageData.class).name() 
					+ " Mechanic, in Pack " + mechanic.getAnnotation(PackageData.class).pack() + ".");
		}
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
	public ArrayList<Mechanic> getMechanics() {
		return mechanics;
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

/* Mechanic Wrapper Methods. */
	@Override
	public boolean registerAbility(Ability ability) {
		return abilities.put(ability.getId(), ability) == null ? false : true;
	}
	
	@Override
	public boolean registerStatus(Status status) {
		return statuses.put(status.getId(), status) == null ? false : true;
	}
	
	@Override
	public HashMap<UUID, Ability> getAbilities() {
		return abilities;
	}
	
	@Override
	public HashMap<UUID, Status> getStatuses() {
		return statuses;
	}
	
	@Override
	public Ability getAbility(UUID id) {
		return abilities.get(id);
	}
	
	@Override
	public Status getStatus(UUID id) {
		return statuses.get(id);
	}
	
	@Override
	public boolean hasAbility(Ability ability) {
		return hasAbility(ability.getId());
	}
	
	@Override
	public boolean hasAbility(UUID id) {
		return abilities.containsKey(id);
	}
	
	@Override
	public boolean hasStatus(Status status) {
		return hasStatus(status.getId());
	}
	
	@Override
	public boolean hasStatus(UUID id) {
		return statuses.containsKey(id);
	}
}
