package me.Mattier.Abilify.wrapper.data;

import java.io.Serializable;

public class Default <T extends Serializable> {
	private final String key;
	private final T defaultValue;

	public Default(String key, T defaultValue) {
		this.key = key;
		this.defaultValue = defaultValue;
	}

	public T getDefaultValue() {
		return defaultValue;
	}

	public String getKeyString() {
		return key;
	}

}
