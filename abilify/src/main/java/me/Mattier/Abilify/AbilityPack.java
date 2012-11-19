package me.Mattier.Abilify;

import me.Mattier.Abilify.mechanic.Mechanic;

import org.spout.api.Spout;
import org.spout.api.UnsafeMethod;
import org.spout.api.plugin.CommonPlugin;

public abstract class AbilityPack extends CommonPlugin {
	private final AbilifyPlugin plugin = (AbilifyPlugin) Spout.getPluginManager().getPlugin("Abilify");

	@Override
	@UnsafeMethod
	public final void onDisable() {}

	@Override
	@UnsafeMethod
	public void onEnable() {
		unpack();
	}
	
	public final void add(Class<? extends Mechanic> mechanic) {
		plugin.getManager().register(mechanic);
	}
	
	public abstract void unpack();

}
