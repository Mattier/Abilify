package me.Mattier.Abilify.wrappers.status;

import me.Mattier.Abilify.wrappers.WrapperInterface;

import org.spout.api.entity.Entity;

public interface Status extends WrapperInterface{
	public int getDuration();
	public int getTickRate();
	public void tick(Entity owner);
}
