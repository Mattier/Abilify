package me.Mattier.Abilify.mechanic;

/**
* The type of {@link me.Mattier.abilify.mechanic.Abilify.mechanic.Mechanic Mechanic}. 
* There are two general mechanic types, 
* {@link me.Mattier.Abilify.wrappers.ability.Ability Ability} and 
* {@link me.Mattier.Abilify.wrappers.status.Status Status}, for which 
* there are two subtypes. For abilities, you can have 
* {@link me.Mattier.Abilify.wrappers.ability.Targeted Targeted} and
* {@link me.Mattier.Abilify.wrappers.ability.Untargeted Untargeted}, 
* and for status, you can have 
* {@link me.Mattier.Abilify.wrappers.status.Ticking Ticking} and 
* {@link me.Mattier.Abilify.wrappers.status.Triggered Triggered}.
*/
public enum Type {
	// Statuses
	TICKING,
	TRIGGERED,
	
	// Abilities
	TARGETED,
	UNTARGETED,
	
	// System
	SYSTEM;
}
