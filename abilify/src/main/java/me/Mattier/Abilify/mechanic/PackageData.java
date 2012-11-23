package me.Mattier.Abilify.mechanic;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * An annotation to hold pack information about a {@link Mechanic}. This 
 * includes the mechanic's name, the author's name, and the package's name.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface PackageData {
	String name();
	String author();
	String pack();
}
