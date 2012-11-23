package me.Mattier.Abilify.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import me.Mattier.Abilify.Abilify;
import me.Mattier.Abilify.mechanic.Mechanic;
import me.Mattier.Abilify.wrappers.ability.Ability;
import me.Mattier.Abilify.wrappers.ability.AbilityWrapper;
import me.Mattier.Abilify.wrappers.status.Status;
import me.Mattier.Abilify.wrappers.status.StatusWrapper;

import com.alta189.simplesave.Database;

public class DatabaseUtil {
	
	public static HashMap<UUID, Ability> loadAbilitiesFrom(Database db) {
		HashMap<UUID, Ability> a = new HashMap<UUID, Ability>();
		for (AbilityTable t : db.select(AbilityTable.class).execute().find()) {
			a.put(t.getUUID(), tableToWrapper(t));
		}
		return a;
	}
	
	public static HashMap<UUID, Status> loadStatusesFrom(Database db) {
		HashMap<UUID, Status> s = new HashMap<UUID, Status>();
		for (StatusTable t : db.select(StatusTable.class).execute().find()) {
			s.put(t.getUUID(), tableToWrapper(t));
		}
		return s;
	}
	
	public static void saveAbilitiesTo(Database db, ArrayList<Ability> l) {
		for (Ability a : l) {
			db.save(wrapperToTable(a));
		}
	}
	
	public static void saveStatusesTo(Database db, ArrayList<Status> l) {
		for (Status s : l) {
			db.save(wrapperToTable(s));
		}
	}
	
	public static Ability tableToWrapper(AbilityTable a) {
		AbilityWrapper wrapper;
		Mechanic m = Abilify.getManager().getMechanic(a.getMech());
		wrapper = new AbilityWrapper(a.getUUID(), m);
		wrapper.setModifier(a.getMod());
		wrapper.setName(a.getName());
		wrapper.setDescription(a.getDesc());
		wrapper.setAnnounce(a.getAnnc());
		return wrapper;
	}
	
	public static Status tableToWrapper(StatusTable s) {
		StatusWrapper wrapper;
		Mechanic m = Abilify.getManager().getMechanic(s.getMech());
		wrapper = new StatusWrapper(s.getUUID(), m);
		wrapper.setModifier(s.getMod());
		wrapper.setName(s.getName());
		wrapper.setDescription(s.getDesc());
		wrapper.setAnnounce(s.getAnnc());
		wrapper.setDuration(s.getDur());
		return wrapper;
	}
	
	public static AbilityTable wrapperToTable(Ability a) {
		AbilityTable table = new AbilityTable();
		table.setUUID(a.getId());
		table.setMech(a.getMechanic().getClass().getName());
		table.setMod(a.getModifier());
		table.setName(a.getName());
		table.setDesc(a.getDescription());
		table.setAnnc(a.getAnnounce());
		return table;
	}
	
	public static StatusTable wrapperToTable(Status s) {
		StatusTable table = new StatusTable();
		table.setUUID(s.getId());
		table.setMech(s.getMechanic().getClass().getName());
		table.setMod(s.getModifier());
		table.setName(s.getName());
		table.setDesc(s.getDescription());
		table.setAnnc(s.getAnnounce());
		table.setDur(s.getDuration());
		table.setRate(s.getTickRate());
		return table;
	}
}
