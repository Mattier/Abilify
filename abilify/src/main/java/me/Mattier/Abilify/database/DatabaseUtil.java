package me.Mattier.Abilify.database;

import java.util.HashMap;
import java.util.UUID;

import me.Mattier.Abilify.mechanic.Type;
import me.Mattier.Abilify.wrappers.MechanicWrapper;

import com.alta189.simplesave.Database;

public class DatabaseUtil {
	
/* Wrapper Methods */
	public static void saveWrapper(Database db, MechanicWrapper mw) {
		saveWrapperTable(db, new WrapperTable(mw));
	}
	
	public static MechanicWrapper findWrapper(Database db, UUID id) {
		return findWrapperTable(db, id).getWrapper();
	}
	
	public static MechanicWrapper findWrapper(Database db, String name) {
		return findWrapperTable(db, name).getWrapper();
	}
	
	public static HashMap<UUID, MechanicWrapper> findWrappers(Database db, Type type) {
		HashMap<UUID, MechanicWrapper> wrappers = new HashMap<UUID, MechanicWrapper>();
		for (WrapperTable t : db.select(WrapperTable.class).where().equal("type", type).execute().find())
			wrappers.put(t.getUUID(), t.getWrapper());
		return wrappers;
	}
	
/* Table Methods */
	public static void saveWrapperTable(Database db, WrapperTable wt) {
		db.save(WrapperTable.class, wt);
	}
	
	public static WrapperTable findWrapperTable(Database db, UUID id) {
		return db.select(WrapperTable.class).where().equal("uuid", id).execute().findOne();
	}
	
	public static WrapperTable findWrapperTable(Database db, String name) {
		return db.select(WrapperTable.class).where().equal("name", name).execute().findOne();
	}
}
