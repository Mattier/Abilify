package me.Mattier.Abilify.wrappers;

import java.util.UUID;

import me.Mattier.Abilify.mechanic.Mechanic;
import me.Mattier.Abilify.mechanic.Type;

import org.spout.api.entity.Entity;

/**
 * Wraps a raw {@link Mechanic}, holding basic information
 * about it, such as it's display name, description, announcement 
 * text, and modifier array.
 */
public class SimpleMechanicWrapper implements Ability, Status, Cost {
	private static final long serialVersionUID = 1L;
	private final UUID id;
	private final Mechanic mech;
	private final Datatable data;
	
	public SimpleMechanicWrapper(Mechanic m) {
		this.id = UUID.randomUUID();
		this.mech = m;
		this.data = m.getData();
	}
	
	public UUID getId() {
		return id;
	}
	
	public Mechanic getMechanic() {
		return mech;
	}
	
	public Datatable getData() {
		return data;
	}

	@Override
	public Type getType() {
		return mech.getType();
	}

	@Override
	public void main(Entity owner) {
		mech.main(owner, data);
	}
	
	
	
	/*
	public String getName() {
		return getData().get("name", String.class);
	}
	
	public String getDescription() {
		return getData().get("description", String.class);
	}
	
	public String getAnnounce() {
		return getData().get("announce", String.class);
	}
	
	public void setName(String name) {
		getData().put("name", name);
	}
	
	public void setDescription(String description) {
		getData().put("descrsiption", description);
	}
	
	public void setAnnounce(String announce) {
		getData().put("announce", announce);
	}
	*/
}
