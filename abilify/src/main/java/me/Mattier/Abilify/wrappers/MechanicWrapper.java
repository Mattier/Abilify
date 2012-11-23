package me.Mattier.Abilify.wrappers;

import java.util.UUID;

import org.spout.api.entity.Entity;

import me.Mattier.Abilify.mechanic.Mechanic;
import me.Mattier.Abilify.mechanic.SubType;
import me.Mattier.Abilify.wrappers.ability.Ability;
import me.Mattier.Abilify.wrappers.status.Status;

/**
 * Wraps a raw {@link Mechanic}, holding basic information
 * about it, such as it's display name, description, announcement 
 * text, and modifier array.
 */
public abstract class MechanicWrapper implements WrapperInterface {
	private final UUID id;
	private final Mechanic mech;
	private int[] mod;
	private String name, desc, annc;
	private MechanicWrapper m;
	
	public MechanicWrapper(UUID id, Mechanic m) {
		this.id = id;
		this.mech = m;
	}
	
	public UUID getId() {
		return id;
	}
	
	public Mechanic getMechanic() {
		return mech;
	}
	
	public int[] getModifier() {
		return mod;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return desc;
	}
	
	public String getAnnounce() {
		return annc;
	}
	
	public MechanicWrapper getSecondary() {
		return m;
	}
	
	public void setModifier(int[] modifier) {
		this.mod = modifier;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDescription(String description) {
		this.desc = description;
	}
	
	public void setAnnounce(String announce) {
		this.annc = announce;
	}
	
	public void setSecondary(MechanicWrapper m) {
		this.m = m;
	}
	
	@Override
	public Entity[] main(Entity owner) {
		if (getMechanic().getSubType() == SubType.APPLIES_STATUS)
			return main(owner, (Ability) getSecondary());
		else if (getMechanic().getSubType() == SubType.CHAINS_ABILITY)
			return main(owner, (Status) getSecondary());
		else 
			return getMechanic().main(owner, getModifier());
	}

	@Override
	public Entity[] main(Entity owner, Ability ability) {
		return getMechanic().main(owner, getModifier(), ability);
	}

	@Override
	public Entity[] main(Entity owner, Status status) {
		return getMechanic().main(owner, getModifier(), status);
	}
}
