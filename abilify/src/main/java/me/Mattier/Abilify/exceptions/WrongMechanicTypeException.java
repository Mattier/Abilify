package me.Mattier.Abilify.exceptions;

import me.Mattier.Abilify.mechanic.Type;

public class WrongMechanicTypeException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private Type t;
	
	public WrongMechanicTypeException(Type t) {
		this.t = t;
	}
	
	public Type getType() {
		return t;
	}

	@Override
	public String getMessage() {
		return "Wrong mechanic type: 'Type." + getType() + "'.";
	}
}
