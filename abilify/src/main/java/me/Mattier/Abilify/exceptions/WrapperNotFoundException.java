package me.Mattier.Abilify.exceptions;

public class WrapperNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private int id;
	
	public WrapperNotFoundException(int id) {
		this.id = id;
	}
	
	public int getWrapperId() {
		return id;
	}

	@Override
	public String getMessage() {
		return "No mechanic wrapper exists for ID: '" + getWrapperId() + "'.";
	}
}
