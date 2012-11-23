package me.Mattier.Abilify.mechanic;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * An empty annotation to mark the main method in a {@link 
 * me.Mattier.Abilify.mechanic.Mechanic Mechanic}.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Main {}
