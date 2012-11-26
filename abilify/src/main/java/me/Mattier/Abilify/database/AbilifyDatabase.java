package me.Mattier.Abilify.database;

import java.io.File;
import java.util.HashMap;
import java.util.UUID;

import me.Mattier.Abilify.mechanic.Type;
import me.Mattier.Abilify.wrapper.MechanicWrapper;

import com.alta189.simplesave.DatabaseFactory;
import com.alta189.simplesave.exceptions.ConnectionException;
import com.alta189.simplesave.exceptions.TableRegistrationException;
import com.alta189.simplesave.h2.H2Configuration;

public class AbilifyDatabase implements Database {
	private final File dbloc;
	private com.alta189.simplesave.Database db;
	
	public AbilifyDatabase(File dbloc) {
		this.dbloc = dbloc;
		if (!dbloc.exists())
			dbloc.mkdir();
	}
	
	public void onEnable() {
		H2Configuration h2 = new H2Configuration();
		File h2db = new File(dbloc, "database");
		h2.setDatabase(h2db.getAbsolutePath());
		db = DatabaseFactory.createNewDatabase(h2);
		
		try {
			db.registerTable(WrapperTable.class);
		} catch (TableRegistrationException e) {
			e.printStackTrace();
		}
		
		try {
			db.connect();
		} catch (ConnectionException e) {
			e.printStackTrace();
		}
	}
	
	public void onDisable() {
		try {
			db.close();
		} catch (ConnectionException e) {
			e.printStackTrace();
		}
	}
	
/* Database API */
	@Override
	public void saveWrapper(MechanicWrapper wrapper) {
		DatabaseUtil.saveWrapper(db, wrapper);
	}
	
	@Override
	public MechanicWrapper getWrapper(UUID id) {
		return DatabaseUtil.findWrapper(db, id);
	}
	
	@Override
	public HashMap<UUID, MechanicWrapper> getWrappers(Type type) {
		return DatabaseUtil.findWrappers(db, type);
	}
}
