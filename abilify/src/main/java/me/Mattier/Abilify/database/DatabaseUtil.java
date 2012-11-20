package me.Mattier.Abilify.database;

import java.util.ArrayList;
import java.util.HashMap;

import me.Mattier.Abilify.AbilifyPlugin;
import me.Mattier.Abilify.mechanic.Mechanic;
import me.Mattier.Abilify.mechanic.MechanicType;
import me.Mattier.Abilify.wrappers.ability.Ability;
import me.Mattier.Abilify.wrappers.ability.AbilityWrapper;
import me.Mattier.Abilify.wrappers.ability.Targeted;
import me.Mattier.Abilify.wrappers.ability.Untargeted;
import me.Mattier.Abilify.wrappers.status.Status;
import me.Mattier.Abilify.wrappers.status.StatusWrapper;
import me.Mattier.Abilify.wrappers.status.Ticking;
import me.Mattier.Abilify.wrappers.status.Triggered;

import com.alta189.simplesave.Database;

public class DatabaseUtil {
	
	public static HashMap<Integer, Ability> loadAbilitiesFrom(Database db) {
		HashMap<Integer, Ability> a = new HashMap<Integer, Ability>();
		for (AbilityTable t : db.select(AbilityTable.class).execute().find()) {
			a.put(t.getId(), tableToWrapper(t));
		}
		return a;
	}
	
	public static HashMap<Integer, Status> loadStatusesFrom(Database db) {
		HashMap<Integer, Status> s = new HashMap<Integer, Status>();
		for (StatusTable t : db.select(StatusTable.class).execute().find()) {
			s.put(t.getId(), tableToWrapper(t));
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
		Mechanic m = AbilifyPlugin.getManager().getMechanic(a.getMech());
		
		if (m.getType() == MechanicType.TARGETED)
			wrapper = new Targeted(a.getId(), m);
		else
			wrapper = new Untargeted(a.getId(), m);
		
		wrapper.setModifier(a.getMod());
		wrapper.setName(a.getName());
		wrapper.setDescription(a.getDesc());
		wrapper.setAnnounce(a.getAnnc());
		return wrapper;
	}
	
	public static Status tableToWrapper(StatusTable s) {
		StatusWrapper wrapper;
		Mechanic m = AbilifyPlugin.getManager().getMechanic(s.getMech());
		
		if (m.getType() == MechanicType.TICKING)
			wrapper = new Ticking(s.getId(), m);	
		else
			wrapper = new Triggered(s.getId(), m);
		
		wrapper.setModifier(s.getMod());
		wrapper.setName(s.getName());
		wrapper.setDescription(s.getDesc());
		wrapper.setAnnounce(s.getAnnc());
		wrapper.setDuration(s.getDur());
		return wrapper;
	}
	
	public static AbilityTable wrapperToTable(Ability a) {
		AbilityTable table = new AbilityTable();
		table.setId(a.getId());
		table.setMech(a.getMechanic().getClass().getName());
		table.setMod(a.getModifier());
		table.setName(a.getName());
		table.setDesc(a.getDescription());
		table.setAnnc(a.getAnnounce());
		return table;
	}
	
	public static StatusTable wrapperToTable(Status s) {
		StatusTable table = new StatusTable();
		table.setId(s.getId());
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
