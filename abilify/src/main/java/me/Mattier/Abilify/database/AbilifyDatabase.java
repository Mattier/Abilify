package me.Mattier.Abilify.database;

import java.io.File;

import com.alta189.simplesave.Database;
import com.alta189.simplesave.DatabaseFactory;
import com.alta189.simplesave.exceptions.ConnectionException;
import com.alta189.simplesave.exceptions.TableRegistrationException;
import com.alta189.simplesave.h2.H2Configuration;

public class AbilifyDatabase {
	private final File dbloc;
	private Database db;
	
	public AbilifyDatabase(File dbloc) {
		this.dbloc = dbloc;
	}
	
	public Database getDatabase() {
		return db;
	}
	
	public void onEnable() {
		H2Configuration h2 = new H2Configuration();
		File h2db = new File(dbloc, "database");
		h2.setDatabase(h2db.getAbsolutePath());
		db = DatabaseFactory.createNewDatabase(h2);
		
		try {
			db.registerTable(AbilityTable.class);
			db.registerTable(StatusTable.class);
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
}
