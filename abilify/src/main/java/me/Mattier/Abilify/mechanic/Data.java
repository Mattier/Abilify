package me.Mattier.Abilify.mechanic;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * An annotation to hold mechanical information about a {@link Mechanic}. This
 * includes its {@link Type type} and the default modifier array for the mechanic.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Data {
	Type type();
	String name();
	String author();
	String pack();
}



