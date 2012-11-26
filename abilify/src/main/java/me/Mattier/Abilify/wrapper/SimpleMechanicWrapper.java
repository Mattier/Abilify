package me.Mattier.Abilify.wrapper;

import java.util.UUID;

import me.Mattier.Abilify.mechanic.Mechanic;
import me.Mattier.Abilify.mechanic.Type;
import me.Mattier.Abilify.wrapper.data.Datatable;
import me.Mattier.Abilify.wrapper.type.Ability;
import me.Mattier.Abilify.wrapper.type.Cost;
import me.Mattier.Abilify.wrapper.type.Status;

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
	
	@Override
	public final UUID getId() {
		return id;
	}
	
	@Override
	public final Mechanic getMechanic() {
		return mech;
	}
	
	@Override
	public final Datatable getData() {
		return data;
	}

	@Override
	public final Type getType() {
		return mech.getType();
	}

	@Override
	public void main(Entity owner) {
		mech.main(owner, data);
	}
}
