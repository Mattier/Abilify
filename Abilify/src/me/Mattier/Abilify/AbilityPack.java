package me.Mattier.Abilify;

import me.Mattier.Abilify.mechanic.Mechanic;

import org.spout.api.UnsafeMethod;
import org.spout.api.plugin.CommonPlugin;

public abstract class AbilityPack extends CommonPlugin {

	@Override
	@UnsafeMethod
	public final void onDisable() {}

	@Override
	@UnsafeMethod
	public void onEnable() {
		unpack();
	}
	
	public final void add(Class<? extends Mechanic> mechanic) {
		Abilify.register(mechanic);
	}
	
	public abstract void unpack();

}
