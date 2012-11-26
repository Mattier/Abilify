package me.Mattier.Abilify.database;

import java.util.UUID;

import me.Mattier.Abilify.mechanic.Type;
import me.Mattier.Abilify.wrapper.MechanicWrapper;

import com.alta189.simplesave.Field;
import com.alta189.simplesave.Id;
import com.alta189.simplesave.Table;

@Table(value = "abilify_ability")
public class WrapperTable {
	@Id
	private int id;
	
	@Field
	private UUID uuid;
	
	@Field
	private MechanicWrapper wrapper;
	
	@Field
	private Type type;
	
	@Field
	private String name;
	
	/*
	public WrapperTable(MechanicWrapper wrapper) {
		this.uuid = wrapper.getId();
		this.wrapper = wrapper;
		this.type = wrapper.getType();
		this.name = wrapper.getData().get("name", String.class);
	}
	*/

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public UUID getUUID() {
		return uuid;
	}

	public MechanicWrapper getWrapper() {
		return wrapper;
	}
	
	public Type getType() {
		return type;
	}
	
	public String getName() {
		return name;
	}
	
	public void setWrapper(MechanicWrapper wrapper) {
		this.uuid = wrapper.getId();
		this.wrapper = wrapper;
		this.type = wrapper.getType();
		this.name = wrapper.getData().get("name", String.class);
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof WrapperTable) {
			WrapperTable compare = (WrapperTable) o;
			if (compare.uuid.equals(uuid) && compare.wrapper.equals(wrapper))
				return true;
		}
		return false;
	}
}